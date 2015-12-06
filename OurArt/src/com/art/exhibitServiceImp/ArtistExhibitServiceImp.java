package com.art.exhibitServiceImp;


import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.art.dao.ArtistDao;
import com.art.entity.Artist;
import com.art.exhibitService.ArtistExhibitService;

@Service
public class ArtistExhibitServiceImp implements ArtistExhibitService
{
	@Resource
	private ArtistDao artistDao;
	
	public void setArtistDao(ArtistDao artistDao){
		this.artistDao=artistDao;
	}
	
	@Override
	public List<Artist> getAllArtist() {
		List<Artist> artist_list = artistDao.getAllArtist();
		return artist_list;
	}

}
