package com.art.backstageServiceImp;

import java.util.ArrayList;
import com.art.backstageService.ManageUserService;
import com.art.dao.UserDao;
import com.art.entity.User;

public class ManageUserServiceImp implements ManageUserService
{

	private UserDao userDao;
	
	@Override
	public ArrayList<User> getAllUser() 
	{
		ArrayList<User> user_list = userDao.getAllUser();
		return user_list;
	}
	
}
