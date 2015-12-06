package com.art.daoImp;

import java.util.List;

import javax.annotation.Resource;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
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
		String hql = "from User";
		Query query = this.sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<User> user_list = query.list();
		return user_list;
	}

	
	
	@Override
	@Transactional(propagation=Propagation.REQUIRED)  
	public void updateUser(User user) {

		this.sessionFactory.getCurrentSession().update(user);
		
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void addUser(User user) 
	{
		((UserDao) this.sessionFactory.getCurrentSession()).addUser(user);
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
