package com.art.personalService;

import java.util.Date;
import java.util.List;

import com.art.entity.User;

public interface UserPersonalService {

	public User userRegister(String tel,String password);
	public User userLogin(String tel,String password);
	public User fillUserInfo(String nickName,String tel, String password,String gender,Date birthday,String email);
	public List<User> getAllUser();
	public User updatePassword(String tel,String password,String newPassword);
}
