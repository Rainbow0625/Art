package com.art.backstageServiceImp;

import java.util.ArrayList;
import java.util.List;

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
	public List<User> getAllUser() 
	{
		List<User> user_list = userDao.getAllUser();
		return user_list;
	}
	
}
