package com.art.backstageServiceImp;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.art.backstageService.ManageUserService;
import com.art.dao.UserDao;
import com.art.entity.User;

@Service
@Transactional(propagation = Propagation.SUPPORTS)   //������� �����Ҳ���
public class ManageUserServiceImp implements ManageUserService
{
	@Resource
	private UserDao userDao;
	
	@Override
	public ArrayList<User> getAllUser() 
	{
		ArrayList<User> user_list = userDao.getAllUser();
		return user_list;
	}
	
}
