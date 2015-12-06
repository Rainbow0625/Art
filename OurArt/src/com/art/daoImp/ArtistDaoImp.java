package com.art.daoImp;


import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.art.dao.ArtistDao;
import com.art.entity.Artist;

@Repository("artistDao")
public class ArtistDaoImp implements ArtistDao
{
	@Resource(name="sessionFactory")
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	public List<Artist> getAllArtist() 
	{
		String hql = "from Artist";
		Query query = this.sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Artist> artist_list = query.list();
		return artist_list;
	}
}
