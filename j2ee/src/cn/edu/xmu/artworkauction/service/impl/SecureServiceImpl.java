/**
 * 
 */
package cn.edu.xmu.artworkauction.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.edu.xmu.artworkauction.dao.AdminDAO;
import cn.edu.xmu.artworkauction.dao.ArtistDAO;
import cn.edu.xmu.artworkauction.dao.UserDAO;
import cn.edu.xmu.artworkauction.entity.Admin;
import cn.edu.xmu.artworkauction.entity.Artist;
import cn.edu.xmu.artworkauction.entity.User;
import cn.edu.xmu.artworkauction.service.SecureService;

/**
 * @author Administrator
 *
 */
@Service("secureService")
public class SecureServiceImpl implements SecureService{
	
	private UserDAO userDAO;
	@Resource(name="userDAO")
	public void setUserDAO(UserDAO userDAO){
		this.userDAO=userDAO;
	}	
	
	private AdminDAO adminDAO;
	@Resource(name="adminDAO")
	public void setAdminDAO(AdminDAO adminDAO){
		this.adminDAO=adminDAO;
	}
	
	@Override
	public User userRegister(String email, String userName, String phoneNumber, String password) {
		// TODO Auto-generated method stub
		return userDAO.userRegister(email, userName, phoneNumber, password);
	}
	@Override
	public User userLoginByUserName(String userName, String password) {
		// TODO Auto-generated method stub
		return userDAO.findUserByUserNameAndPassword(userName, password);
	}
	@Override
	public User userLoginByEmail(String email, String password) {
		// TODO Auto-generated method stub
		return userDAO.findUserByEmailAndPassword(email, password);
	}

	@Override
	public Admin adminLogin(String adminName, String password) {
		// TODO Auto-generated method stub
		return adminDAO.adminLogin(adminName, password);
	}

}