package com.art.daoImp;


import java.util.Calendar;
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

/**
 * @author ���
 * @category DateAndPosDao��ʵ��
 * */
@Repository("dateAndPosDao")
public class DateAndPosDaoImp implements DateAndPosDao
{
	@Resource(name="sessionFactory")
	private SessionFactory sessionFactory;
	
	public DateAndPosDaoImp(){}
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	/**
	 * ������Ŀ�ţ��õ��������Ϣ
	 * */
	@Override
	public Information getTodayInfoByInfoColumnId(int infoColumnId) {
		
		Calendar count = Calendar.getInstance();
		Date todaydate = new Date();
		
		String hql = "from DateAndPos as dateAndPos where dateAndPos.infoColumn.id=?";  
		Query query = this.sessionFactory.getCurrentSession().createQuery(hql);
		query.setInteger(0, infoColumnId); 
		List<DateAndPos> dateAndPosList =getDateAndPosByInfoColumnId(infoColumnId);
		
		Information todayInfo=new Information();
		int flag=0;
		
		for(int i = 0;i < dateAndPosList.size(); i++)
		{
			int days= dateAndPosList.get(i).getDays();
			count.setTime(dateAndPosList.get(i).getDate());
			
			if(count.getTime().equals(todaydate))  //������ڣ�ֱ�ӷ���
			{
				todayInfo = dateAndPosList.get(i).getInformation();
				//flag=1;
				break;
			}
			else if( count.getTime().before(todaydate) )  //���С�ڣ������жϵı�Ҫ
			{
				for(int j = 0 ; j<days ; j++)
				{
					count.add(Calendar.DAY_OF_YEAR, 1);
					if( count.getTime().equals(todaydate))
					{
						todayInfo = dateAndPosList.get(i).getInformation();
						flag=1;
						break;
					}
				}
				if(flag==1)
					break;
			}
			else     //������ڣ�û���жϵı�Ҫ������������һ��
				continue;
		}
		
		return todayInfo;
	}

	/**
	 * ��������id���õ�DateAndPos
	 * */
	@Override  
	public List<DateAndPos> getDateAndPosByInformationId(int informationId) {
		String hql = "select dateAndPos from DateAndPos as dateAndPos where dateAndPos.information.id=? " ;  
		Query query = this.sessionFactory.getCurrentSession().createQuery(hql);
		query.setInteger(0, informationId);  
		@SuppressWarnings("unchecked")
		List<DateAndPos> dateAndPos =  query.list();
		return dateAndPos;
	}

	/**
	 * ������Ŀid���õ�DateAndPos
	 * */
	@Override  // not use
	public List<DateAndPos> getDateAndPosByInfoColumnId(int infoColumnId) {
		String hql = "select dateAndPos from DateAndPos as dateAndPos where dateAndPos.infoColumn.id=?";  
		Query query = this.sessionFactory.getCurrentSession().createQuery(hql);
		query.setInteger(0, infoColumnId);  
		@SuppressWarnings("unchecked")
		List<DateAndPos> dateAndPos =  query.list();
		return dateAndPos;
	}

	/**
	 * ����һ��DateAndPos
	 * */
	@Override
	public Boolean setDateAndPos(DateAndPos dateAndPos) {
		Session session = sessionFactory.getCurrentSession();
		session.save(dateAndPos);
		session.flush();
		return true;
	}

	/**
	 * ɾ��һ��DateAndPos
	 * */
	@Override
	public Boolean deleteDateAndPos(int dateAndPosId) {
		Session session = sessionFactory.getCurrentSession();
		//session.delete(dateAndPos);
		String hql= "delete DateAndPos where id=?";
		Query query = session.createQuery(hql);
		query.setInteger(0,dateAndPosId);
		query.executeUpdate();
		session.flush();
		return true;
	}

}
