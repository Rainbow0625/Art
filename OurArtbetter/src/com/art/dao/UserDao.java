package com.art.dao;

import java.util.Date;
import java.util.List;

import com.art.entity.Artist;
import com.art.entity.User;

public interface UserDao 
{
	public List<User> getAllUser(); 
	public List<Artist> getAllArtist();
	public User userRegister(String tel, String password);
	public User fillUserInfo(String nickName,String tel, String password,String gender,Date birthday,String email,String code,String address);
	public boolean checkTelUnique(String tel);
	public boolean checkEmailUnique(String email);
	public User findUserByTelAndPassword(String tel,String password);
	public void addUser(User user);
	public void deleteUser(User user);
	public void updateUser(User user);
	public User updatePassword(String tel,String password,String newPassword);
	public User setUserIlleagal(String tel,int state);
	public User findUserById(int id);
	public User resetUserPassword(int id, String newPassword);
	
}
