package com.art.personalService;

import com.art.entity.User;

public interface SignupService {

	public User userRegister(String tel,String password);
	public User userLogin(String tel,String password);
}
