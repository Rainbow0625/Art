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
 * @author 吴虹
 * @category DateAndPosDao的实现
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
	 * 根据栏目号，得到今天的信息
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
			
			if(count.getTime().equals(todaydate))  //如果等于，直接返回
			{
				todayInfo = dateAndPosList.get(i).getInformation();
				//flag=1;
				break;
			}
			else if( count.getTime().before(todaydate) )  //如果小于，还有判断的必要
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
			else     //如果大于，没有判断的必要，继续查找下一个
				continue;
		}
		
		return todayInfo;
	}

	/**
	 * 根据软文id，得到DateAndPos
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
	 * 根据栏目id，得到DateAndPos
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
	 * 增加一条DateAndPos
	 * */
	@Override
	public Boolean setDateAndPos(DateAndPos dateAndPos) {
		Session session = sessionFactory.getCurrentSession();
		session.save(dateAndPos);
		session.flush();
		return true;
	}

	/**
	 * 删除一条DateAndPos
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
