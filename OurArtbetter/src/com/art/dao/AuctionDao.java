package com.art.dao;

import java.util.List;

import com.art.entity.Artwork;

public interface AuctionDao {
	public void deleteAuctionById(int AuctionId);
	public List<Artwork> getAllAuction();
	public void saveAuction(Artwork Auction);
	public void updateAuction(Artwork Auction);
	public Artwork getAuctionByname(String AuctionName);
}
