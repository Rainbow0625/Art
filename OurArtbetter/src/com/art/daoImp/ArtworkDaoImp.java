package com.art.daoImp;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.art.dao.ArtworkDao;
import com.art.entity.Artwork;
@Repository("ArtworkDao")
public class ArtworkDaoImp implements ArtworkDao {
	@Resource(name="sessionFactory")
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	@Override
	public List<Artwork> getAllAuction() {
		// TODO Auto-generated method stub
				String hql = "from Artwork where artworkType=3";
				Query query = this.sessionFactory.getCurrentSession().createQuery(hql);
				@SuppressWarnings("unchecked")
				List<Artwork> auction_list = query.list();
				return auction_list;// TODO Auto-generated method stub
	}
	@Override
	public void deleteArtworkById(int ArtworkId) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public List<Artwork> getAllArtwork() {
		
		String hql = "from Artwork";
		Query query = this.sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Artwork> artwork_list = query.list();
		return artwork_list;// TODO Auto-generated method stub
	}
	@Override
	public List<Artwork> getAllProduct() {
		// TODO Auto-generated method stub
		String hql = "from Artwork where artworkType=1";
		Query query = this.sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Artwork> product_list = query.list();
		return product_list;
	}
	@Override
	public List<Artwork> getAllCustommade() {
		// TODO Auto-generated method stub
		String hql = "from Artwork where artworkType=2";
		Query query = this.sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Artwork> custommade_list = query.list();
		return custommade_list;
	}
	@Override
	public void saveArtwork(Artwork Auction) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void updateArtwork(Artwork Auction) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public Artwork getArtworkByname(String AuctionName) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
