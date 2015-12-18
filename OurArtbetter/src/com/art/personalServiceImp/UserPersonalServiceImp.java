package com.art.personalServiceImp;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import com.art.dao.ArtistDao;
import com.art.dao.UserDao;
import com.art.entity.User;
import com.art.personalService.UserPersonalService;

@Service
@RequestMapping("/User")
public class UserPersonalServiceImp implements UserPersonalService{

	@Resource
	private UserDao userDao;
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
		return userDao.userRegister(tel, password);
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
		if(userDao.findUserByTelAndPassword(tel, password)==null)
			return null;
		else 
			return userDao.updatePassword(tel,password, newPassword);		
	}
	
	@Override
	public User fillUserInfo(String nickName,String tel, String password,String gender,Date birthday,String email){
		// TODO Auto-generated method stub
		return userDao.fillUserInfo(nickName, tel, password, gender, birthday, email);	
	}

}
