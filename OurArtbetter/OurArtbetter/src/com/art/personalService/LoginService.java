package com.art.personalService;

import com.art.entity.User;

public interface LoginService {

	public void LoginValidate(User user);
	public boolean exisitUser(String username);
	public boolean confirmPassword(String username,String password);
}
