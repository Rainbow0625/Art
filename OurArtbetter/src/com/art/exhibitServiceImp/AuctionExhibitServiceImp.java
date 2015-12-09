package com.art.exhibitServiceImp;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;


import com.art.dao.AuctionDao;
import com.art.entity.Artwork;
import com.art.exhibitService.AuctionExhibitService;


@Service
public class AuctionExhibitServiceImp implements AuctionExhibitService{

	@Resource
	private AuctionDao auctionDao;
	
	public void setAuctionDao(AuctionDao auctionDao){
		this.auctionDao=auctionDao;
	}
	
	@Override
	public List<Artwork> getAllAuction() {
		List<Artwork> auction_list = auctionDao.getAllAuction();
		return auction_list;
	}
}
