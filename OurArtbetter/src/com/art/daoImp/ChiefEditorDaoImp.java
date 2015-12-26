package com.art.daoImp;
/*
 * @author 范溢贞 24320132202399
 */
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.art.dao.ChiefEditorDao;
import com.art.entity.ChiefEditor;

@Repository("ChiefEditor")
public class ChiefEditorDaoImp implements ChiefEditorDao{

	@Resource
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public List<ChiefEditor> getAllChiefEditor() {
		// TODO Auto-generated method stub
		Query query = this.sessionFactory.getCurrentSession().getNamedQuery("@GetAllChiefEditor");
		@SuppressWarnings("unchecked")
		List<ChiefEditor> chiefEditor_list = query.list();
		return chiefEditor_list;
	}

	@Override
	public ChiefEditor findChiefEditorByNameAndPassword(String name,String password) {
		// TODO Auto-generated method stub
		ChiefEditor chiefEditor = null;
		try {
			Query query = this.sessionFactory.getCurrentSession().getNamedQuery("@FindChiefEditorByNameAndPassword");
			query.setString("0", name);
			query.setString("1", password);
			chiefEditor = (ChiefEditor) query.uniqueResult();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println("error in find chiefEditor by name and password in dao!");//for test
		}
		
				
		return chiefEditor;
	}

	@Override
	public void addEditor(ChiefEditor chiefEditor) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().save(chiefEditor);
	
		
	}

	@Override
	public void deleteEditor(ChiefEditor chiefEditor) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().delete(chiefEditor);
		
	}

	@Override
	public void updateEditor(ChiefEditor chiefEditor) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().update(chiefEditor);
		
	}

}
