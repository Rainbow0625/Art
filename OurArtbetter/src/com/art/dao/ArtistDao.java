package com.art.dao;
/*
 * @author 范溢贞 24320132202399
 */

import java.util.Date;
import java.util.List;
import com.art.entity.Artist;



public interface ArtistDao
{
	public List<Artist> getAllArtist();
	public List<Artist> getAllArtist(String status);
	public Artist artistApply(String realName,String tel, String password,String gender,Date birthday,String email,String photo,String introduction);    
	public Artist auditArtist(String tel,String status);
	public void updateArtist(Artist artist);
}

