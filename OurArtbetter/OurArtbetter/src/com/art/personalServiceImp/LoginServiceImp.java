package com.art.personalServiceImp;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.art.dao.UserDao;
import com.art.entity.User;
import com.art.personalService.LoginService;

@Service
@RequestMapping("/User")
public class LoginServiceImp implements LoginService{

	@Resource
	private UserDao userDao;
	
	@Override
	public void LoginValidate(User user)
	{
		userDao.addUser(user);
	}

	@Override
	public boolean exisitUser(String username) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean confirmPassword(String username, String password) {
		// TODO Auto-generated method stub
		return false;
	}	
}
