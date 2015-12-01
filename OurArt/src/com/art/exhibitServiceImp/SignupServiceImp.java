package com.art.exhibitServiceImp;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.art.dao.UserDao;
import com.art.entity.User;
import com.art.personalService.SignupService;

@Service
@RequestMapping("/User")
public class SignupServiceImp implements SignupService{
	
	@Resource
	private UserDao userDao;
	
	@Override
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public void addUser(User user)
	{
		userDao.addUser(user);
	}
	

}
