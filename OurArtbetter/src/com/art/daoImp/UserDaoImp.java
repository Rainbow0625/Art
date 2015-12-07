package com.art.daoImp;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.art.dao.UserDao;
import com.art.entity.Artist;
import com.art.entity.User;

@Repository("UserDao")
@Transactional(propagation = Propagation.SUPPORTS)   //@Transactional : mean��
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
		String hql = "from User";
		Query query = this.sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<User> user_list = query.list();
		return user_list;
	}	


	@Override
	public User userRegister(String tel, String password) {
		// TODO Auto-generated method stub
		if(checkTelUnique(tel))
		{
			User user=new User(tel,password);
			saveUser(user);
			return user;
		}
		else
			return null;
	}



	@Override
	public boolean checkTelUnique(String tel) {
		// TODO Auto-generated method stub
		String hql="from User u where u.tel=?";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setString(0, tel);
		User user=(User)query.uniqueResult();
		return user==null;
	}



	@Override
	public boolean checkEmailUnique(String email) {
		// TODO Auto-generated method stub
		String hql="from User u where u.email=?";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setString(0, email);
		User user=(User)query.uniqueResult();
		return user==null;
	}



	@Override
	public User findUserByTelAndPassword(String tel, String password) {
		// TODO Auto-generated method stub
		String hql="from User u where u.tel=? and u.password=?";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		query.setString(0, tel);
		query.setString(1, password);
		User user=(User)query.uniqueResult();
		if(user.getUserType().equals("artist")){
			user=(Artist)user;
		}
		return user;
	}



	@Override
	public User findUserByEmailAndPassword(String email, String password) {
		// TODO Auto-generated method stub
		String hql="from User u where u.email=? and u.password=?";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		query.setString(0, email);
		query.setString(1, password);
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
	public User updateUser(User user) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().saveOrUpdate(user);
		return null;
	}
	

}
