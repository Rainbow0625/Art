package com.art.dao;
/*
 * @author 范溢贞 24320132202399
 */
import java.util.List;

import com.art.entity.Admin;

public interface AdminDao {
	
	public List<Admin> getAllAdmin();
	public Admin addAdmin(String name,String password,int adminType);
	public boolean checkAdminNameUnique(String name);
	public List<Admin> findAdminByAdminType(int adminType);
	public Admin findAdminById(int id);
	public Admin findAdminByNameAndPassword(String name, String password);
	public Admin findAdminByIdAndPassword(int id,String password);
	public void deleteAdminById(int id);
	public void deleteAdminByName(String name);
	public Admin updatePassword(String name, String password, String newPassword);
	public void updateAdmin(Admin admin);
	public Admin setAdminType(int id,int adminType);
	public Admin resetAdminPassword(int id, String newPassword);
}
