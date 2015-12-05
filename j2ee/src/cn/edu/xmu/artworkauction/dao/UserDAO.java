/**
 * 
 */
package cn.edu.xmu.artworkauction.dao;

import cn.edu.xmu.artworkauction.entity.User;

/**
 * @author Administrator
 *
 */
public interface UserDAO {
	
	public User userRegister(String email,String userName,String phoneNumber,String password);
	public boolean checkUserNameUnique(String userName);
	public boolean checkEmailUnique(String email);
	public User findUserByUserNameAndPassword(String userName,String password);
	public User findUserByEmailAndPassword(String email,String password);
	public void saveUser(User user);
	public void addUser(User user);
	public void deleteUser(User user);
	public User updateUser(User user);
}