package com.art.backstageService;
/*
 * @author 范溢贞 24320132202399
 */
import java.util.List;

import com.art.entity.Admin;
import com.art.entity.Artist;
import com.art.entity.User;

public interface ManageUserService 
{
	public List<User> getAllUser();
	public User resetUserPassword(int id,String newPassword);
	public User setUserIlleagal(String tel,int state);
	public Artist auditArtist(String tel,String status);
	public Admin setAdminType(int id,int adminType);
	public Admin addAdmin(String name, String password,int adminType);
	public Admin resetAdminPassword(int id, String newPassword);
}
