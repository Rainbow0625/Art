package com.art.dao;

import java.util.List;

import com.art.entity.User;

public interface UserDao 
{
	public List<User> getAllUser(); 
	public User userRegister(String tel, String password);
	public boolean checkTelUnique(String tel);
	public boolean checkEmailUnique(String email);
	public User findUserByTelAndPassword(String tel,String password);
	public User findUserByEmailAndPassword(String email,String password);
	public void saveUser(User user);
	public void addUser(User user);
	public void deleteUser(User user);
	public User updateUser(User user);
}
