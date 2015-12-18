package com.art.dao;

import java.sql.Date;
import java.util.List;





import com.art.entity.Artist;


public interface ArtistDao extends UserDao
{
	public List<Artist> getAllArtist(String status);
	public Artist artistApply(String realName,String tel, String password,String gender,Date birthday,String email,String photo,String introduction);
}
