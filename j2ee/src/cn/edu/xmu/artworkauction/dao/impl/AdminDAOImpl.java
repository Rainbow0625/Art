/**
 * 
 */
package cn.edu.xmu.artworkauction.dao.impl;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import cn.edu.xmu.artworkauction.dao.AdminDAO;
import cn.edu.xmu.artworkauction.entity.Admin;
import cn.edu.xmu.artworkauction.entity.ChiefEditor;
import cn.edu.xmu.artworkauction.entity.Editor;
import cn.edu.xmu.artworkauction.entity.ServiceAdmin;
import cn.edu.xmu.artworkauction.entity.UserAdmin;

/**
 * @author Administrator
 *
 */
@Repository("adminDAO")
public class AdminDAOImpl implements AdminDAO{
	
    private SessionFactory sessionFactory;
	@Resource(name="sessionFactory")
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public Admin adminLogin(String adminName, String password) {
		// TODO Auto-generated method stub
		String hql="from Admin a where a.adminName=? and a.password=?";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		query.setString(0, adminName);
		query.setString(1, password);
		Admin admin=(Admin)query.uniqueResult();
		if(admin.getAdminType().equals("editor"))
			admin=(Editor)admin;
		else if(admin.getAdminType().equals("chiefEditor"))
			admin=(ChiefEditor)admin;
		else if(admin.getAdminType().equals("userAdmin"))
			admin=(UserAdmin)admin;
		else
			admin=(ServiceAdmin)admin;
		return admin;
	}

}
