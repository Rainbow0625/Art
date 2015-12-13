package com.art.daoImp;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
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
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	public Information getTodayInfoByInfoColumnId(int infoColumnId) {
		String id=String.valueOf(infoColumnId);
		Date date = new Date();
		String hql = "select information from DateAndPos as dateAndPos where dateAndPos.infoColumn.id="+ id+" and dateAndPos.date.equals("+date+")";  //dateÎª½ñÌì
		Query query = this.sessionFactory.getCurrentSession().createQuery(hql);
		Information information =  (Information) query.uniqueResult();
		return information;
	}

	@Override
	public List<DateAndPos> getDateAndPosByInformationId(int informationId) {
		String id=String.valueOf(informationId);
		String hql = "select dateAndPos from DateAndPos as dateAndPos where dateAndPos.information.id="+ id ;  
		Query query = this.sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<DateAndPos> dateAndPos =  query.list();
		return dateAndPos;
	}

	@Override
	public List<DateAndPos> getDateAndPosByInfoColumnId(int infoColumnId) {
		String id=String.valueOf(infoColumnId);
		String hql = "select dateAndPos from DateAndPos as dateAndPos where dateAndPos.infoColumn.id="+ id ;  
		Query query = this.sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<DateAndPos> dateAndPos =  query.list();
		return dateAndPos;
	}

}
