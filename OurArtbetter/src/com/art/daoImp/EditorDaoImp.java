package com.art.daoImp;
/*
 * @author 范溢贞 24320132202399
 */
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.art.dao.EditorDao;
import com.art.entity.Editor;


@Repository("EditorDao")
public class EditorDaoImp implements EditorDao{

	@Resource
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void addEditor(Editor editor) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().save(editor);

	}

	@Override
	public void deleteEditor(Editor editor) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().delete(editor);
	}

	@Override
	public void updateEditor(Editor editor) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().saveOrUpdate(editor);

	}

	@Override
	public List<Editor> getAllEditor() {
		// TODO Auto-generated method stub
		Query query = this.sessionFactory.getCurrentSession().getNamedQuery("@GetAllEditor");
		@SuppressWarnings("unchecked")
		List<Editor> editor_list = query.list();
		return editor_list;
	}

	@Override
	public Editor findEditorByNameAndPassword(String name, String password) {
		// TODO Auto-generated method stub
		Editor editor = null;
		try {
			Query query = this.sessionFactory.getCurrentSession().getNamedQuery("@FindEditorByNameAndPassword");
			query.setString("0", name);
			query.setString("1", password);
			editor = (Editor) query.uniqueResult();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println("error in find editor by name and password in dao!");//for test
		}

		return editor;
	}

}
