package com.art.personalService;
/*
 * @author 范溢贞 24320132202399
 */
import java.util.List;

import com.art.entity.Admin;

public interface AdminPersonalService {
	
	public Admin addAdmin(String name, String password,int adminType);
	public Admin findAdminByNameAndPassword(String name, String password) ;
	public List<Admin> getAllAdmin();
	public Admin updatePassword(String name,String password,String newPassword);

}
