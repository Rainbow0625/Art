/**
 * 
 */
package cn.edu.xmu.artworkauction.service;

import cn.edu.xmu.artworkauction.entity.Admin;
import cn.edu.xmu.artworkauction.entity.Artist;
import cn.edu.xmu.artworkauction.entity.User;

/**
 * @author Administrator
 *
 */
public interface SecureService {
	public User userRegister(String email,String userName,String phoneNumber,String password);
	public User userLoginByUserName(String userName,String password);
	public User userLoginByEmail(String email,String password);
	public Admin adminLogin(String adminName,String password);
}
