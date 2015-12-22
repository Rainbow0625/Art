package com.art.daoImp;


import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.art.dao.DateAndPosDao;
import com.art.entity.DateAndPos;

import com.art.entity.Information;

@Repository("dateAndPosDao")
public class DateAndPosDaoImp implements DateAndPosDao
{
	@Resource(name="sessionFactory")
	private SessionFactory sessionFactory;
	
	public DateAndPosDaoImp(){}
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	public Information getTodayInfoByInfoColumnId(int infoColumnId) {
		Date todayDate = new Date();
		//SimpleDateFormat sdf = new SimpleDateFormat("yy-mm-dd");
		
		String hql = "select information from DateAndPos as dateAndPos where dateAndPos.infoColumn.id=? and dateAndPos.date=? ";  
		Query query = this.sessionFactory.getCurrentSession().createQuery(hql);
		query.setInteger(0, infoColumnId);
		query.setDate(1,todayDate);  
		Information information = (Information)query.uniqueResult();
		
		return information;
	}

	@Override
	public List<DateAndPos> getDateAndPosByInformationId(int informationId) {
		String hql = "select dateAndPos from DateAndPos as dateAndPos where dateAndPos.information.id=? " ;  
		Query query = this.sessionFactory.getCurrentSession().createQuery(hql);
		query.setInteger(0, informationId);  
		@SuppressWarnings("unchecked")
		List<DateAndPos> dateAndPos =  query.list();
		return dateAndPos;
	}

	@Override
	public List<DateAndPos> getDateAndPosByInfoColumnId(int infoColumnId) {
		String hql = "select dateAndPos from DateAndPos as dateAndPos where dateAndPos.infoColumn.id=?";  
		Query query = this.sessionFactory.getCurrentSession().createQuery(hql);
		query.setInteger(0, infoColumnId);  
		@SuppressWarnings("unchecked")
		List<DateAndPos> dateAndPos =  query.list();
		return dateAndPos;

	}

	@Override
	public void setDateAndPos(DateAndPos dateAndPos) {
		Session session = sessionFactory.getCurrentSession();
		session.save(dateAndPos);
	}

	@Override
	public void deleteDateAndPos(int dateAndPosId) {
		Session session = sessionFactory.getCurrentSession();
		//session.delete(dateAndPos);
		String hql= "delete DateAndPos where id=?";
		Query query = session.createQuery(hql);
		query.setInteger(0,dateAndPosId);
		query.executeUpdate();
		
	}

}
