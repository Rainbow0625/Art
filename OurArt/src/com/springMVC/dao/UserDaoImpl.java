package com.springMVC.dao;

import java.util.List;
import javax.annotation.Resource;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import com.springMVC.entity.User;

@Service
@Transactional(propagation = Propagation.SUPPORTS)
public class UserDaoImpl implements UserDao {
	
	@Resource 
	private SessionFactory sessionFactory;
	
	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void update(User user) {
		this.sessionFactory.getCurrentSession().update(user);
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void save(User user) {
		
		System.out.println("Dao灞傜敤鎴风敓鏃�        锛�"+user.getBirthday());
		this.sessionFactory.getCurrentSession().save(user);
		
	}


	@Override
	public List<User> getAllUser() {
		String hql = "from User";
		Query query = this.sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<User> user_list = query.list();
		return user_list;
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void deleteById(int  id) {
		String sqlString = "from User u where u.id=?";
		Query query = this.sessionFactory.getCurrentSession().createQuery(sqlString);
		query.setInteger(0, id);
		User user = (User)query.uniqueResult();
		System.out.println("userDao"+user);

		this.sessionFactory.getCurrentSession().delete(user);

	}

	@Override
	public User getUserByname(String username) {
		User user = new User();
		user.setUsername(username);
		Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(User.class);
		criteria.add(Example.create(user));
		user = (User) criteria.uniqueResult();
		return user;
	}
}
