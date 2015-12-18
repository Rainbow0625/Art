package com.art.daoImp;

import java.sql.Date;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.art.dao.ArtistDao;
import com.art.entity.Artist;
import com.art.entity.User;

@Repository("artistDao")
public class ArtistDaoImp extends UserDaoImp implements ArtistDao
{
	@Resource(name="sessionFactory")
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public List<Artist> getAllArtist(String status) //obtain the list of artist on the status
	{
		String hql = "from Artist a where a.audit_status = ?0";
		Query query = this.sessionFactory.getCurrentSession().createQuery(hql);
		query.setString("0", status);
		@SuppressWarnings("unchecked")
		List<Artist> artist_list = query.list();
		return artist_list;
	}

	@Override
	public Artist artistApply(String realName,String tel, String password,String gender,Date birthday,String email,String photo,String introduction) {
		// TODO Auto-generated method stub
		if(findUserByTelAndPassword(tel, password)!=null)
		{
			//Transaction tran = ((SharedSessionContract) this.sessionFactory).beginTransaction();//开始事物
			Artist artist = new Artist(realName, tel, password, gender, birthday, email, photo, introduction);
			//tran.commit();
			return artist;
		}
		return null;
	}

//	@Override
//	public List<User> getAllUser() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public User userRegister(String tel, String password) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public User fillUserInfo(String nickName, String tel, String password,
//			String gender, Date birthday, String email) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public boolean checkTelUnique(String tel) {
//		// TODO Auto-generated method stub
////		String hql="from Artist a where a.tel=?0";
////		Query query = sessionFactory.getCurrentSession().createQuery(hql);
////		query.setString("0", tel);
////		Artist artist=(Artist)query.uniqueResult();
////		return artist==null;
//		return this.checkTelUnique(tel);
//	}
//
//	@Override
//	public boolean checkEmailUnique(String email) {
//		// TODO Auto-generated method stub
//		return false;
//	}
//
//	@Override
//	public User findUserByTelAndPassword(String tel, String password) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public User findUserByEmailAndPassword(String email, String password) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public void saveUser(User user) {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public void addUser(User user) {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public void deleteUser(User user) {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public User updateUser(User user) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public User updatePassword(String tel, String newPassword) {
//		// TODO Auto-generated method stub
//		return null;
//	}
}
