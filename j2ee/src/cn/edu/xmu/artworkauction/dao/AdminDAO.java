/**
 * 
 */
package cn.edu.xmu.artworkauction.dao;

import cn.edu.xmu.artworkauction.entity.Admin;

/**
 * @author Administrator
 *
 */
public interface AdminDAO {
	public Admin adminLogin(String adminName,String password);
}
