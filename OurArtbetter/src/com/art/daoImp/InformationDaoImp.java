package com.art.daoImp;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
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
		for(int i =0 ; i<informationList.size() ;i++)
		{
			informationList.get(i).getEditor().getId();
		}
		return informationList;
	} 

	@Override
	public List<Information> getAllInfo() {
		String hql = "from Information where contentType=\"INFO\" ";
		Query query = this.sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Information> informationList = query.list();
		for(int i =0 ; i<informationList.size() ;i++)
		{
			informationList.get(i).getEditor().getId();
		}
		return informationList;
	}

	@Override
	public List<Information> getInformationByEditorId(int editorId) {
		//System.out.println("here!" );
		
		String hql = "from Information information where information.editor.id=? and information.contentType='INFO' ";
		Query query = this.sessionFactory.getCurrentSession().createQuery(hql);
		query.setInteger(0, editorId);
		List<Information> informationList = query.list();

		
		for(int i =0 ; i<informationList.size() ;i++)
		{
			informationList.get(i).getChiefEditor().getId();
		}
		return informationList;
	}
	
	
	
	@Override
	public List<Information> getAdverByEditorId(int editorId){

		String hql = "from Information as information where information.editor.id=? and information.contentType='ADVER' ";
		Query query = this.sessionFactory.getCurrentSession().createQuery(hql);
		query.setInteger(0, editorId);
		@SuppressWarnings("unchecked")
		List<Information> informationList = query.list();
		for(int i =0 ; i<informationList.size() ;i++)
		{
			informationList.get(i).getChiefEditor().getId();
		}
		return informationList;
	}

	@Override
	public List<Information> getInformationByChiefEditorId(int chiefEditorId) {

		String hql = "from Information as information where information.chiefEditor.id=?";
		Query query = this.sessionFactory.getCurrentSession().createQuery(hql);
		query.setInteger(0, chiefEditorId);
		@SuppressWarnings("unchecked")
		List<Information> informationList = query.list();
		return informationList;
	}
	
	@Override
	public void addAnInfo(Information info) {
		//System.out.println("here!" );
		Session session = sessionFactory.getCurrentSession();
		//session.beginTransaction();
		session.save(info);
		//session.getTransaction().commit();
	}

	@Override
	public void deleteAnInfo(Information info) {
		Session session = sessionFactory.getCurrentSession();
		//session.beginTransaction();
		session.delete(info);
		session.getTransaction().commit();
	}

	@Override
	public void updateAnInfo(Information info) {
		
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		session.saveOrUpdate(info);
		//other : sessionFactory.getCurrentSession().update(info);
		session.getTransaction().commit();
		
	}

	@Override
	public void checkInfoById(int infoId) {
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		String hql = "update Information info set info.state='2' where info.id=?";
		Query query = session.createQuery(hql);
		query.setInteger(0, infoId);
		query.executeUpdate();
		session.getTransaction().commit();
	}
	
	
	@Override
	public void failInfoById(int infoId) {
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		String hql = "update Information info set info.state='3' where info.id=?";
		Query query = session.createQuery(hql);
		query.setInteger(0, infoId);
		query.executeUpdate();
		session.getTransaction().commit();
	}

}
