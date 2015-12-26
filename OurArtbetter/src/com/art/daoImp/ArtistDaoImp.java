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

import com.art.dao.ArtistDao;
import com.art.dao.UserDao;
import com.art.entity.AUDIT_STATUS;
import com.art.entity.Artist;
import com.art.entity.User;

@Repository("artistDao")
public class ArtistDaoImp implements ArtistDao
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

	@SuppressWarnings("null")
	@Override
	public Artist artistApply(String realName,String tel, String password,String gender,Date birthday,String email,String photo,String introduction) {
		// TODO Auto-generated method stub
		User user = null;
		UserDao userDao = null;
		try {			
			user = userDao.findUserByTelAndPassword(tel, password);
			if(user!=null)
			{
				Artist artist = new Artist(realName, tel, password, gender, birthday, email, photo, introduction);
				return artist;
			}
			else 
				System.out.println("error in artistApply(can not find the user) in dao!");//for test
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println("error in artistApply in dao!");//for test
		}		
		return null;
	}

	@Override
	public Artist auditArtist(String tel,String status) {
		// TODO Auto-generated method stub
		Artist artist = null;
		User user = null;
		try {
			Query query = this.sessionFactory.getCurrentSession().getNamedQuery("@FindUserByTel");
			query.setString("0", tel);
			user = (User)query.uniqueResult();
			if(user!=null)
			{
				artist = (Artist)user;
				artist.setAudit_status(AUDIT_STATUS.valueOf(status));
				updateArtist(artist);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println("error in auditArtist in dao!");//for debug
		}
		return artist;
	}
	
	public List<Artist> getAllArtist() //obtain the list of artist on the status
	{
		String hql = "from Artist";
		Query query = this.sessionFactory.getCurrentSession().createQuery(hql);
	
		@SuppressWarnings("unchecked")
		List<Artist> artist_list = query.list();
		return artist_list;
	}
	@Override
	public void updateArtist(Artist artist) {
		// TODO Auto-generated method stub
		try {
			Session session = sessionFactory.getCurrentSession();
			session.saveOrUpdate(artist);
			session.flush();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println("error in updateArtist in dao!");//for debug
		}
	}

	
}
