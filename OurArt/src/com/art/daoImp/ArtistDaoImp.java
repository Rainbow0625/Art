package com.art.daoImp;

import java.util.ArrayList;

import org.hibernate.Query;
import org.hibernate.SessionFactory;

import com.art.dao.ArtistDao;
import com.art.entity.Artist;


public class ArtistDaoImp implements ArtistDao
{
	private SessionFactory sessionFactory;
	
	@Override
	public ArrayList<Artist> getAllArtist() 
	{
		String hql = "from Artist";
		Query query = this.sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		ArrayList<Artist> artist_list = (ArrayList<Artist>)query.list();
		return artist_list;
	}

}
