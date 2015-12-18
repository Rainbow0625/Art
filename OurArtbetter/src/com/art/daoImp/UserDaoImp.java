package com.art.daoImp;


import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.art.dao.UserDao;
import com.art.entity.User;

@Repository("userDao")
public class UserDaoImp implements UserDao
{
	@Resource(name="sessionFactory")
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}


	@Override
	public List<User> getAllUser() 
	{
		Query query = this.sessionFactory.getCurrentSession().getNamedQuery("@GetAllUser");
		@SuppressWarnings("unchecked")
		List<User> user_list = query.list();
		return user_list;
	}	

	@Override
	public User userRegister(String tel, String password) {
		// TODO Auto-generated method stub
		if(checkTelUnique(tel))
		{
			//Transaction tran = ((SharedSessionContract) this.sessionFactory).beginTransaction();//开始事物
			User user=new User(tel,password);
			saveUser(user);
			//updateUser(user);//
			//tran.commit();
			return user;
		}
		else
			return null;
	}

	@Override
	public User fillUserInfo(String nickName,String tel, String password,String gender,Date birthday,String email) {
		// TODO Auto-generated method stub
		User user = findUserByTelAndPassword(tel, password);
		if(user!=null)
		{
			user.setNickName(nickName);
			user.setBirthday(birthday);
			user.setEmail(email);
			user.setGender(gender);
			
			updateUser(user);//
			//tran.commit();
			return user;
		}
		else
			return null;
	}


	@Override
	public boolean checkTelUnique(String tel) {
		// TODO Auto-generated method stub
		Query query = sessionFactory.getCurrentSession().getNamedQuery("@FindUserByTel");
		query.setString("0", tel);
		User user=(User)query.uniqueResult();//此处待改！
		return user==null;
	}



	@Override
	public boolean checkEmailUnique(String email) {
		// TODO Auto-generated method stub
		Query query = sessionFactory.getCurrentSession().getNamedQuery("@FindUserByEmail");
		query.setString("0", email);
		User user=(User)query.uniqueResult();
		return user==null;
	}



	@Override
	public User findUserByTelAndPassword(String tel, String password) {
		// TODO Auto-generated method stub
		Query query=sessionFactory.getCurrentSession().getNamedQuery("@FindUserByTelAndPassword");
		query.setString("0", tel);
		query.setString("1", password);
		User user=(User)query.uniqueResult();
//		if(user.getuseType.equals("artist")){
//			user=(Artist)user;
//		}
		return user;
	}



	@Override
	public User findUserByEmailAndPassword(String email, String password) {
		// TODO Auto-generated method stub
		Query query=sessionFactory.getCurrentSession().getNamedQuery("@FindUserByEmailAndPassword");
		query.setString("0", email);
		query.setString("1", password);
		User user=(User)query.uniqueResult();
		return user;
	}


	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void addUser(User user) {
		// TODO Auto-generated method stub
		saveUser(user);
	}


	@Override
	public void saveUser(User user) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().save(user);
	}



	@Override
	public void deleteUser(User user) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().delete(user);
	}



	@Override
	public void updateUser(User user) {
		// TODO Auto-generated method stub
		//Logger logger = Logger.getLogger(UserDaoImp.class);
		//log.logDebug("update userInfo!");
		try {
			Session session = sessionFactory.openSession();
			Transaction transaction = session.beginTransaction();
			session.saveOrUpdate(user);
			transaction.commit();
			//sessionFactory.getCurrentSession().saveOrUpdate(user);
			//log.logDebug("update userInfo successfully!");
		} catch (Exception e) {
			// TODO: handle exception
			//log.logError("update failed!",e);
		}
		//此处带测试session.close();
	}
	
	@Override
	public User updatePassword(String tel,String password,String newPassword){
		// TODO Auto-generated method stub
		User user = findUserByTelAndPassword(tel,password);
		user.setPassword(newPassword);
		updateUser(user);//
		return user;
	}
	

}
