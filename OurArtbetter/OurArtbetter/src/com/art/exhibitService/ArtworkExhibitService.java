package com.art.exhibitService;

import java.util.List;

import com.art.entity.Artist;
import com.art.entity.Artwork;
import com.art.entity.Artwork;



public interface ArtworkExhibitService 
{
	
	public List<Artwork> getAllAuction();

	public List<Artwork> getAllProduct();

	public List<Artwork> getAllArtwork();

	public List<Artwork> getAllCustommade();
}
