/**
 * 
 */
package cn.edu.xmu.artworkauction.dao.impl;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import cn.edu.xmu.artworkauction.dao.UserDAO;
import cn.edu.xmu.artworkauction.entity.Artist;
import cn.edu.xmu.artworkauction.entity.User;

/**
 * @author Administrator
 *
 */
@Repository("userDAO")
public class UserDAOImpl implements UserDAO{

	private SessionFactory sessionFactory;
	
	@Resource(name="sessionFactory")
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	public User userRegister(String email, String userName, String phoneNumber, String password) {
		// TODO Auto-generated method stub
		if(checkEmailUnique(email)&&checkUserNameUnique(userName))
		{
			User user=new User(email,userName,phoneNumber,password);
			saveUser(user);
			return user;
		}
		else
			return null;
	}

	@Override
	public boolean checkUserNameUnique(String userName) {
		// TODO Auto-generated method stub
		String hql="from User u where u.userName=?";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setString(0, userName);
		User user=(User)query.uniqueResult();
		return user==null;
	}

	@Override
	public boolean checkEmailUnique(String email){
		// TODO Auto-generated method stub
		String hql="from User u where u.email=?";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setString(0, email);
		User user=(User)query.uniqueResult();
		return user==null;
	}
	@Override
	public User findUserByUserNameAndPassword(String userName, String password) {
		// TODO Auto-generated method stub
		String hql="from User u where u.userName=? and u.password=?";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		query.setString(0, userName);
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
	public void saveUser(User user) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().save(user);
	}

	@Override
	public void addUser(User user) {
		// TODO Auto-generated method stub
		saveUser(user);
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
		return user;
	}
	
}
