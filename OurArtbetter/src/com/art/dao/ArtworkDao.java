package com.art.dao;

import java.util.List;

import com.art.entity.Artwork;

public interface ArtworkDao {
	public void deleteArtworkById(int AuctionId);
	public List<Artwork> getAllArtwork();
	public List<Artwork> getAllProduct();
	public List<Artwork> getAllAuction();
	public List<Artwork> getAllCustommade();
	public void saveArtwork(Artwork Auction);
	public void updateArtwork(Artwork Auction);
	public Artwork getArtworkByname(String AuctionName);
}
