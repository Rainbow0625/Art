package com.art.daoImp;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.art.dao.AdminDao;
import com.art.entity.Admin;

@Repository("adminDao")
public class AdminDaoImp implements AdminDao{

	@Resource(name = "sessionFactory")
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public List<Admin> getAllAdmin() {
		// TODO Auto-generated method stub
		Query query = this.sessionFactory.getCurrentSession().getNamedQuery("@GetAllAdmin");
		@SuppressWarnings("unchecked")
		List<Admin> admin_list = query.list();
		return admin_list;
	}

	@Override
	public Admin addAdmin(String tel, String password,int adminType) {
		// TODO Auto-generated method stub
		if(checkAdminTelUnique(tel))
		{
			Admin admin = new Admin(tel, password, adminType);
			sessionFactory.getCurrentSession().save(admin);
			return admin;
		}
		else
			return null;
	}

	@Override
	public boolean checkAdminTelUnique(String tel) {
		// TODO Auto-generated method stub
		Query query = sessionFactory.getCurrentSession().getNamedQuery("@FindAdminByTel");
		query.setString("0", tel);
		Admin admin=(Admin) query.uniqueResult();//此处待改！
		return admin==null;
	}

	@Override
	public List<Admin> findAdminByAdminType(int adminType) {
		// TODO Auto-generated method stub
		Query query=sessionFactory.getCurrentSession().getNamedQuery("@FindAdminByAdminType");
		query.setInteger("0", adminType);
		@SuppressWarnings({ "unchecked" })
		List<Admin> admin_list = query.list();
		return admin_list;
	}

	@Override
	public Admin findAdminByTelAndPassword(String tel, String password) {
		// TODO Auto-generated method stub
		Query query=sessionFactory.getCurrentSession().getNamedQuery("@FindAdminByTelAndPassword");
		query.setString("0", tel);
		query.setString("1", password);
		Admin admin=(Admin) query.uniqueResult();//此处待改！
		return admin;
	}

	@Override
	public Admin findAdminById(int id) {
		// TODO Auto-generated method stub
		Query query=sessionFactory.getCurrentSession().getNamedQuery("@FindAdminById");
		query.setInteger("0", id);
		Admin admin=(Admin) query.uniqueResult();//此处待改！
		return admin;
	}

	@Override
	public Admin findAdminByIdAndPassword(int id, String password) {
		// TODO Auto-generated method stub
		Query query=sessionFactory.getCurrentSession().getNamedQuery("@FindAdminByIdAndPassword");
		query.setInteger("0", id);
		query.setString("1", password);
		Admin admin=(Admin) query.uniqueResult();//此处待改！
		return admin;
	}

	@Override
	public void deleteAdminById(int id) {
		// TODO Auto-generated method stub
		Query query=sessionFactory.getCurrentSession().getNamedQuery("@FindAdminById");
		query.setInteger("0", id);
		Admin admin=(Admin) query.uniqueResult();//此处待改！
		sessionFactory.getCurrentSession().delete(admin);
	}

	@Override
	public void deleteAdminByTel(String tel) {
		// TODO Auto-generated method stub
		Query query = sessionFactory.getCurrentSession().getNamedQuery("@FindAdminByTel");
		query.setString("0", tel);
		Admin admin=(Admin) query.uniqueResult();//此处待改！
		sessionFactory.getCurrentSession().delete(admin);
	}

	@Override
	public Admin updatePassword(String tel, String password, String newPassword) {
		// TODO Auto-generated method stub
		Admin admin = findAdminByTelAndPassword(tel,password);
		admin.setPassword(newPassword);
		updateAdmin(admin);
		return null;
	}

	@Override
	public void updateAdmin(Admin admin) {
		// TODO Auto-generated method stub
		try {
			Session session = sessionFactory.openSession();
			Transaction transaction = session.beginTransaction();
			session.saveOrUpdate(admin);
			transaction.commit();
			//sessionFactory.getCurrentSession().saveOrUpdate(user);
			//log.logDebug("update userInfo successfully!");
		} catch (Exception e) {
			// TODO: handle exception
			//log.logError("update failed!",e);
		}
	}

}
