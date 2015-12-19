package com.art.personalServiceImp;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import com.art.dao.AdminDao;
import com.art.entity.Admin;
import com.art.personalService.AdminPersonalService;

@Service

public class AdminPersonalServiceImp implements AdminPersonalService{
	
	@Resource(name="adminDao")
	private AdminDao adminDao;
	
	
	public AdminPersonalServiceImp() {}




	@Override
	public Admin addAdmin(String tel, String password, int adminType) {
		// TODO Auto-generated method stub
		return adminDao.addAdmin(tel, password, adminType);
	}

	@Override
	public Admin adminLogin(String tel, String password) {
		// TODO Auto-generated method stub
		return adminDao.findAdminByTelAndPassword(tel, password);
	}

	@Override
	public List<Admin> getAllAdmin() {
		// TODO Auto-generated method stub
		return adminDao.getAllAdmin();
	}

	@Override
	public Admin updatePassword(String tel, String password, String newPassword) {
		// TODO Auto-generated method stub
		if(adminDao.findAdminByTelAndPassword(tel, newPassword)==null)
			return null;
		else {
			return adminDao.updatePassword(tel, password, newPassword);
		}
	}

}
