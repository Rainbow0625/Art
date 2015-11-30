package com.art.daoImp;

import java.util.ArrayList;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.art.dao.UserDao;
import com.art.entity.User;

public class UserDaoImp implements UserDao
{
	
	private SessionFactory sessionFactory;

	@Override
	public ArrayList<User> getAllUser() 
	{
		String hql = "from User";
		Query query = this.sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		ArrayList<User> user_list = (ArrayList<User>)query.list();
		return user_list;
	}

	
	
	@Override
	@Transactional(propagation=Propagation.REQUIRED)  //mean£¿
	public void updateUser(User user) {

		this.sessionFactory.getCurrentSession().update(user);
		
	}

	@Override
	//¿Õ
	public void addUser(User user) 
	{
		
	}

	
	@Override
	public User getUserByRealName(String realName) {

		User user = new User();
		user.setRealName(realName);
		Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(User.class);
		criteria.add(Example.create(user));
		user = (User) criteria.uniqueResult();
		return user;
	}

	@Override
	public void deleteById(int id) {
		String sqlString = "from User u where u.id=?";
		Query query = this.sessionFactory.getCurrentSession().createQuery(sqlString);
		query.setInteger(0, id);
		User user = (User)query.uniqueResult();
		//System.out.println("userDao"+user);
		this.sessionFactory.getCurrentSession().delete(user);
	}
	

}
