package com.art.personalServiceImp;
/*
 * @author 范溢贞 24320132202399
 */
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.art.dao.ArtistDao;
import com.art.dao.UserDao;
import com.art.entity.Artist;
import com.art.entity.User;
import com.art.personalService.UserPersonalService;

@Service
public class UserPersonalServiceImp implements UserPersonalService{

	@Resource
	private UserDao userDao;
	@Resource
	private ArtistDao artistDao;

	public UserDao getUserDao() {
		return userDao;
	}

	public ArtistDao getArtistDao() {
		return artistDao;
	}

	public void setArtistDao(ArtistDao artistDao) {
		this.artistDao = artistDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public User userRegister(String tel, String password) {
		// TODO Auto-generated method stub
		return  userDao.userRegister(tel, password);
	}

	@Override
	public User userLogin(String tel, String password) {
		// TODO Auto-generated method stub
		return userDao.findUserByTelAndPassword(tel, password);
	}

	@Override
	public List<User> getAllUser() {
		// TODO Auto-generated method stub
		List<User> user_list = userDao.getAllUser();
		return user_list;
	}

	@Override
	public User updatePassword(String tel,String password,String newPassword){
		// TODO Auto-generated method stub
		return userDao.updatePassword(tel,password, newPassword);		
	}

	@Override
	public User fillUserInfo(String nickName,String tel, String password,String gender,Date birthday,String email,String code,String address){
		// TODO Auto-generated method stub
		return  userDao.fillUserInfo(nickName, tel, password, gender, birthday, email,code,address);	
	}

	@Override
	public Artist artistApply(String realName, String tel, String password,
			String gender, Date birthday, String email, String photo,
			String introduction) {
		// TODO Auto-generated method stub
		return  artistDao.artistApply(realName, tel, password, gender, birthday, email, photo, introduction);
	}

	@Override
	public List<Artist> getAllArtist() {
		// TODO Auto-generated method stub
		List<Artist> artist_list = userDao.getAllArtist();
		return artist_list;
	}

	@Override
	public User findUserById(int id) {
		// TODO Auto-generated method stub
		return userDao.findUserById(id);
	}

	@Override
	public User resetUserPassword(int id, String newPassword) {
		// TODO Auto-generated method stub
		return userDao.resetUserPassword(id, newPassword);
	}


}
