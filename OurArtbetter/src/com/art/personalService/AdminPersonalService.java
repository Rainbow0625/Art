package com.art.personalService;

import java.util.List;

import com.art.entity.Admin;

public interface AdminPersonalService {
	
	public Admin addAdmin(String tel, String password,int adminType);
	public Admin adminLogin(String tel,String password);
	public List<Admin> getAllAdmin();
	public Admin updatePassword(String tel,String password,String newPassword);

}
