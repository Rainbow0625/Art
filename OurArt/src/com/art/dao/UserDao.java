package com.art.dao;

import java.util.List;

import com.art.entity.User;

public interface UserDao 
{
	public void updateUser(User user);
	
	public void addUser(User user);
	
	public List<User> getAllUser();
	
	public User getUserByRealName(String realName);
	
	public void deleteById(int id);
}
