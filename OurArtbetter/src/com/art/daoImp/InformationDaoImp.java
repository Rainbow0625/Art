package com.art.daoImp;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import com.art.dao.InformationDao;
import com.art.entity.Information;

@Repository("informationDao")
public class InformationDaoImp implements InformationDao
{
	@Resource(name="sessionFactory")
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public Information getInformationById(int informationId) {
		
		String id=String.valueOf(informationId);
		String hql = "from Information where id="+ id;
		Query query = this.sessionFactory.getCurrentSession().createQuery(hql);
		Information information = (Information) query.uniqueResult();
		return information;
	}

	@Override
	public List<Information> getAllAdver() {
		
		String hql = "from Information where contentType=\"ADVER\" ";
		Query query = this.sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Information> informationList = query.list();
		return informationList;
		
	}

	@Override
	public List<Information> getAllInfo() {
		String hql = "from Information where contentType=\"INFO\" ";
		Query query = this.sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Information> informationList = query.list();
		return informationList;
	}

	@Override
	public List<Information> getInformationByEditorId(int editorId) {
		String id=String.valueOf(editorId);
		String hql = "from Information as information where information.editor.id="+ id;
		Query query = this.sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Information> informationList = query.list();
		return informationList;
	}

	@Override
	public List<Information> getInformationByChiefEditorId(int chiefEditorId) {
		String id=String.valueOf(chiefEditorId);
		String hql = "from Information as information where information.chiefEditor.id="+ id;
		Query query = this.sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Information> informationList = query.list();
		return informationList;
	}

}
