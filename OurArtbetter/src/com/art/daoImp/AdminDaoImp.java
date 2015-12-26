package com.art.daoImp;
/*
 * @author 范溢贞 24320132202399
 */
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
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
	public Admin addAdmin(String name, String password,int adminType) {
		// TODO Auto-generated method stub
		Admin admin = null;
		try {
			if(checkAdminNameUnique(name))
			{
				admin = new Admin(name, password, adminType);
				sessionFactory.getCurrentSession().save(admin);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println("error in find admin by name and password in dao!");//for debug
		}
		
		return admin;
	}

	@Override
	public boolean checkAdminNameUnique(String name) {
		// TODO Auto-generated method stub
		Query query = sessionFactory.getCurrentSession().getNamedQuery("@FindAdminByName");
		query.setString("0", name);
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
	public Admin findAdminByNameAndPassword(String name, String password) {
		// TODO Auto-generated method stub
		Query query=sessionFactory.getCurrentSession().getNamedQuery("@FindAdminByNameAndPassword");
		query.setString("0", name);
		query.setString("1", password);
		Admin admin = null;
		try {
			admin=(Admin)query.uniqueResult();//此处待改！
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println("error in find admin by name and password in dao!");//for debug
		}
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
	public void deleteAdminByName(String name) {
		// TODO Auto-generated method stub
		Query query = sessionFactory.getCurrentSession().getNamedQuery("@FindAdminByName");
		query.setString("0", name);
		Admin admin=(Admin) query.uniqueResult();//此处待改！
		sessionFactory.getCurrentSession().delete(admin);
	}

	@Override
	public Admin updatePassword(String name, String password, String newPassword) {
		// TODO Auto-generated method stub
		Admin admin = findAdminByNameAndPassword(name,password);
		admin.setPassword(newPassword);
		updateAdmin(admin);
		return null;
	}

	@Override
	public void updateAdmin(Admin admin) {
		// TODO Auto-generated method stub
		try {
			Session session = sessionFactory.getCurrentSession();
			session.saveOrUpdate(admin);
			session.flush();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println("error in updateAdmin in dao!");//for debug
		}
	}

	@Override
	public Admin setAdminType(int id, int adminType) {
		// TODO Auto-generated method stub
		Admin admin = null;
		try {
			Query query = sessionFactory.getCurrentSession().getNamedQuery("@FindAdminById");
			query.setInteger("0", id);
			admin = (Admin) query.uniqueResult();
			if(admin!=null)
			{
				admin.setAdminType(adminType);
				updateAdmin(admin);
			}
			else 
				System.out.println("error in setAdminType(can not find the admin) in dao!");//for debug
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println("error in setAdminType in dao!");//for debug
		}
		return admin;
	}

	@Override
	public Admin resetAdminPassword(int id, String newPassword) {
		// TODO Auto-generated method stub
		Admin admin = null;
		try {
			admin = findAdminById(id);
			if(admin!=null)
			{
				admin.setPassword(newPassword);
				updateAdmin(admin);	
			}
			else 
				System.out.println("resetUserPassword(can not find the user) in dao!");//for debug
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println("error in resetUserPassword in dao!");//for debug
		}
		return admin;
	}

}
