package com.art.backstageServiceImp;
/*
 * @author 范溢贞 24320132202399
 */
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.art.backstageService.ManageUserService;
import com.art.dao.AdminDao;
import com.art.dao.ArtistDao;
import com.art.dao.UserDao;
import com.art.entity.Admin;
import com.art.entity.Artist;
import com.art.entity.User;

@Service
public class ManageUserServiceImp implements ManageUserService
{
	@Resource
	private UserDao userDao;
	@Resource
	private ArtistDao artistDao;
	@Resource
	private AdminDao adminDao;
	
	@Override
	public List<User> getAllUser() 
	{
		List<User> user_list = userDao.getAllUser();
		return user_list;
	}

	@Override
	public User resetUserPassword(int id,String newPassword) {
		// TODO Auto-generated method stub
		return  userDao.resetUserPassword(id, newPassword);
	}

	@Override
	public User setUserIlleagal(String tel,int state) {
		// TODO Auto-generated method stub
		return  userDao.setUserIlleagal(tel,state);		
	}

	@Override
	public Artist auditArtist(String tel,String status) {
		// TODO Auto-generated method stub
		return artistDao.auditArtist(tel, status);
	}

	@Override
	public Admin setAdminType(int id, int adminType) {
		// TODO Auto-generated method stub
		return adminDao.setAdminType(id, adminType);
	}

	@Override
	public Admin addAdmin(String name, String password, int adminType) {
		// TODO Auto-generated method stub
		return adminDao.addAdmin(name, password, adminType);
	}
	
	@Override
	public Admin resetAdminPassword(int id, String newPassword) {
		// TODO Auto-generated method stub
		return adminDao.resetAdminPassword(id, newPassword);
	}
	
}
