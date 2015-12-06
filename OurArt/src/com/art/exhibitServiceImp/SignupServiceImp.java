package com.art.exhibitServiceImp;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import com.art.dao.UserDao;
import com.art.entity.User;
import com.art.personalService.SignupService;

@Service
@RequestMapping("/User")
public class SignupServiceImp implements SignupService{
	
	@Resource
	private UserDao userDao;

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public User userRegister(String tel, String password) {
		// TODO Auto-generated method stub
		return userDao.findUserByTelAndPassword(tel, password);
	}

	@Override
	public User userLogin(String tel, String password) {
		// TODO Auto-generated method stub
		return userDao.userRegister(tel, password);
	}
	

}
