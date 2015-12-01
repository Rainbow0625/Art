package com.art.daoImp;


import java.util.List;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import com.art.dao.ArtistDao;
import com.art.entity.Artist;


public class ArtistDaoImp implements ArtistDao
{
	private SessionFactory sessionFactory;
	
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
