package com.art.daoImp;
/*
 * @author 范溢贞 24320132202399
 */

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.art.dao.UserDao;
import com.art.entity.Artist;
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
		User user = null;
		if(checkTelUnique(tel))
		{			
			try {
				user =new User(tel,password);
				user.setState(1);
				addUser(user);
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
				System.out.println("error in create a user by name and password in dao!");//for test
			}
		}
		return user;
	}

	@Override
	public User fillUserInfo(String nickName,String tel, String password,String gender,Date birthday,String email,String code,String address) {
		// TODO Auto-generated method stub
		User user = null;
		try {
			System.out.println(tel+" "+password);//for test
			user = findUserByTelAndPassword(tel, password);
			if(user!=null)
			{
				user.setNickName(nickName);
				user.setBirthday(birthday);
				user.setEmail(email);
				user.setGender(gender);
				user.setAddress(address);
				user.setCode(code);
				user.setState(1);

				updateUser(user);//
				//				Session session =sessionFactory.getCurrentSession();
				//				session.saveOrUpdate(user);
				//				session.flush();

			}
			else 
				System.out.println("error in fillUserInfo(can not find the user) in dao!");//for test
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println("error in fillUserInfo in dao!");//for test
		}
		return user;
	}


	@Override
	public boolean checkTelUnique(String tel) {
		// TODO Auto-generated method stub
		Query query = sessionFactory.getCurrentSession().getNamedQuery("@FindUserByTel");
		query.setString("0", tel);
		User user = null;
		try {
			user=(User)query.uniqueResult();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println("error in checkTelUnique in dao!");//for test
		}
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
		
		return user;
	}


	@Override
	public void addUser(User user) {
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
		try {			
			Session session = sessionFactory.getCurrentSession();			
			session.saveOrUpdate(user);	
			session.flush();
//			Session session = this.sessionFactory.openSession();
//			Transaction transaction = session.beginTransaction();
//			session.saveOrUpdate("user");
//			transaction.commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println("error in updateUser in dao!");//for debug
		}
	}

	@Override
	public User updatePassword(String tel,String password,String newPassword){
		// TODO Auto-generated method stub
		User user=null;
		try {
			user = findUserByTelAndPassword(tel,password);
			if(user!=null)
			{
				user.setPassword(newPassword);
				updateUser(user);
			}
			else 
				System.out.println("error in updatePassword(can not find the user) in dao!");//for debug		
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println("error in updatePassword in dao!");//for debug
		}
		return user;
	}


	@Override
	public User setUserIlleagal(String tel,int state) {
		// TODO Auto-generated method stub
		User user = null;
		try {
			Query query=sessionFactory.getCurrentSession().getNamedQuery("@FindUserByTel");
			query.setString("0", tel);
			user=(User)query.uniqueResult();
			if(user!=null)
			{
				user.setState(state);
				updateUser(user);
			}
			else 
				System.out.println("setUserIlleagal(can not find the user) in dao!");//for debug
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println("error in setUserIlleagal in dao!");//for debug
		}
		return user;
	}


	@Override
	public List<Artist> getAllArtist() {
		// TODO Auto-generated method stub
		Query query = this.sessionFactory.getCurrentSession().getNamedQuery("@GetAllArtist");
		@SuppressWarnings("unchecked")
		List<Artist> artist_list = query.list();
		return artist_list;
	}


	@Override
	public User findUserById(int id) {
		// TODO Auto-generated method stub
		Query query=sessionFactory.getCurrentSession().getNamedQuery("@FindUserById");
		query.setInteger("0", id);
		User user=(User)query.uniqueResult();
		
		return user;
	}


	@Override
	public User resetUserPassword(int id, String newPassword) {
		// TODO Auto-generated method stub
		User user = null;
		try {
			user = findUserById(id);
			if(user!=null)
			{
				user.setPassword(newPassword);
				updateUser(user);			
			}
			else 
				System.out.println("resetUserPassword(can not find the user) in dao!");//for debug
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println("error in resetUserPassword in dao!");//for debug
		}
		return user;
	}


}
