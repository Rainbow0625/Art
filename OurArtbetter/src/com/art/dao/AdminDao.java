package com.art.dao;

import java.util.List;

import com.art.entity.Admin;;

public interface AdminDao {
	
	public List<Admin> getAllAdmin();
	public Admin addAdmin(String tel,String password,int adminType);
	public boolean checkAdminTelUnique(String tel);
	public List<Admin> findAdminByAdminType(int adminType);
	public Admin findAdminById(int id);
	public Admin findAdminByTelAndPassword(String tel,String password);
	public Admin findAdminByIdAndPassword(int id,String password);
	public void deleteAdminById(int id);
	public void deleteAdminByTel(String tel);
	public Admin updatePassword(String tel, String password, String newPassword);
	public void updateAdmin(Admin admin);

}
