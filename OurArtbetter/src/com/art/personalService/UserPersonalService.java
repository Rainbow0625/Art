package com.art.personalService;
/*
 * @author 范溢贞 24320132202399
 */
import java.util.Date;
import java.util.List;

import com.art.entity.Artist;
import com.art.entity.User;

public interface UserPersonalService {

	public User userRegister(String tel,String password);
	public User userLogin(String tel,String password);
	public User fillUserInfo(String nickName,String tel, String password,String gender,Date birthday,String email,String code,String address);
	public List<User> getAllUser();
	public List<Artist> getAllArtist();
	public User updatePassword(String tel,String password,String newPassword);
	public Artist artistApply(String realName,String tel, String password,String gender,Date birthday,String email,String photo,String introduction);
	public User findUserById(int id);
	public User resetUserPassword(int id,String newPassword);
}
