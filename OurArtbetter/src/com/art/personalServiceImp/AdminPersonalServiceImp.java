package com.art.personalServiceImp;
/*
 * @author 范溢贞 24320132202399
 */
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.art.dao.AdminDao;
import com.art.entity.Admin;
import com.art.personalService.AdminPersonalService;

@Service
public class AdminPersonalServiceImp implements AdminPersonalService{
	
	@Resource(name="adminDao")
	private AdminDao adminDao;
	
	
	public AdminPersonalServiceImp() {}

	@Override
	public Admin addAdmin(String name, String password, int adminType) {
		// TODO Auto-generated method stub
		return adminDao.addAdmin(name, password, adminType);
	}

	@Override
	public Admin findAdminByNameAndPassword(String name, String password) {
		// TODO Auto-generated method stub
		Admin admin = null;
		try {
			admin = adminDao.findAdminByNameAndPassword(name, password);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println("error in find admin by name and password in service!");//for test
		}
		return admin;
	}

	@Override
	public List<Admin> getAllAdmin() {
		// TODO Auto-generated method stub
		return adminDao.getAllAdmin();
	}

	@Override
	public Admin updatePassword(String name, String password, String newPassword) {
		// TODO Auto-generated method stub
		if(adminDao.findAdminByNameAndPassword(name, newPassword)==null)
			return null;
		else {
			return adminDao.updatePassword(name, password, newPassword);
		}
	}

	


}
