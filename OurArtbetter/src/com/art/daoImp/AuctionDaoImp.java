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

import com.art.dao.AuctionDao;
import com.art.entity.Artwork;

@Repository("AuctionDao")
public class AuctionDaoImp implements AuctionDao{
	@Resource(name="sessionFactory")
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void deleteAuctionById(int AuctionId) {
		// TODO Auto-generated method stub
		
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
	public void saveAuction(Artwork Auction) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateAuction(Artwork Auction) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Artwork getAuctionByname(String AuctionName) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
