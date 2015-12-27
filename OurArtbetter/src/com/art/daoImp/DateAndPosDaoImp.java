package com.art.daoImp;


import java.text.ParseException;
import java.text.SimpleDateFormat;
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
 
   @author 吴虹
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
	public Information getTodayInfoByInfoColumnId(int infoColumnId) throws ParseException {
		//String date =request.getParameter("startDate");
		//Date update = sdf.parse(date);
		
		//ok
		String hql = "from DateAndPos as dateAndPos where dateAndPos.infoColumn.id=?";  
		Query query = this.sessionFactory.getCurrentSession().createQuery(hql);
		query.setInteger(0, infoColumnId); 
		List<DateAndPos> dateAndPosList =getDateAndPosByInfoColumnId(infoColumnId);
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");  
		Calendar count = Calendar.getInstance();
		
		
		String temp = sdf.format( new Date() );
		Date todaydate = sdf.parse(temp);
		
		Information todayInfo=new Information();
		int flag=0;
		
		for(int i = 0;i < dateAndPosList.size(); i++)
		{
			int days= dateAndPosList.get(i).getDays();
			count.setTime(dateAndPosList.get(i).getDate());
			Date compare = sdf.parse( sdf.format(count.getTime()) );
			
			if(compare.equals(todaydate))  //如果等于，直接返回
			{
				todayInfo = dateAndPosList.get(i).getInformation();
				//flag=1;
				break;
			}
			else if( compare.before(todaydate) ) //如果小于，还有判断的必要
			{
				for(int j = 0 ; j<days ; j++)
				{
					count.add(Calendar.DAY_OF_YEAR, 1);
					compare = sdf.parse( sdf.format(count.getTime()));
					if( compare.equals(todaydate))
					{
						todayInfo = dateAndPosList.get(i).getInformation();
						flag=1;
						break;
					}
				}
				if(flag==1)
					break;
			}
			else      //如果大于，没有判断的必要，继续查找下一个
				continue;
		}

		return todayInfo;
	}

	/**
	 *根据软文id，得到DateAndPos
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
	 *  根据栏目id，得到DateAndPos
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
	 * 设置DateAndPos
	 * */
	@Override
	public Boolean setDateAndPos(DateAndPos dateAndPos) {
		Session session = sessionFactory.getCurrentSession();
		session.save(dateAndPos);
		session.flush();
		return true;
	}

	/**
	 *  删除一条DateAndPos
	 * */
	@Override
	public Boolean deleteDateAndPos(int dateAndPosId) {
		Session session = sessionFactory.getCurrentSession();
		//session.delete(dateAndPos);
		String hql= "delete DateAndPos from DateAndPos where id=?";
		Query query = session.createQuery(hql);
		query.setInteger(0,dateAndPosId);
		query.executeUpdate();
		session.flush();
		return true;
	}
	
	/**
	 * 根据当前想要设置软文的时间，得到可用的栏目编号
	 * @throws ParseException 
	 * */

	@Override
	public String getUnavailableColumnId(Date date, int days) throws ParseException
	{
		//Session session = sessionFactory.getCurrentSession();
		Date tempDate;
		
		String result="";
		int success= 0;
		int flag = 0;
		
		Calendar startC = Calendar.getInstance();
		Calendar endC = Calendar.getInstance();
		Date start;
		Date end;
		//Calendar testEnd = Calendar.getInstance();
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String temp = sdf.format(date);
		Date testStart = sdf.parse(temp);   //testDateΪ����DateAndPOS�Ŀ�ʼʱ��
		Calendar testEndC = Calendar.getInstance();
		testEndC.setTime(testStart);
		testEndC.add(Calendar.DAY_OF_YEAR, days);
		Date testEnd = testEndC.getTime();
		
		
		System.out.println(temp);
		
		for(int i = 1 ; i<=6 ; i++ )
		{
			success= 0;
			String hql= "from DateAndPos as dateAndPos where dateAndPos.infoColumn.id=?";
			Query query = sessionFactory.getCurrentSession().createQuery(hql);
			query.setInteger(0,i);
			@SuppressWarnings("unchecked")
			List<DateAndPos> dateAndPosList= query.list();
			for(int j =0 ; j< dateAndPosList.size(); j++ )
			{
				tempDate =dateAndPosList.get(j).getDate();
				startC.setTime(tempDate);       //start为数据库中已经设置好的开始时间
				endC.setTime(tempDate);  
				endC.add(Calendar.DAY_OF_YEAR, dateAndPosList.get(j).getDays());    //endΪ为数据库中已经设置好的结束时间
				start = startC.getTime();
				end = endC.getTime();
				
				//进行比较
				if( testEnd.before(start) )
				{
					success++;
				}
				else if( testStart.after(end) )
				{
					success++;
				}
			}
			
			if(dateAndPosList.size()==0)
			{}	
			else if( success !=  dateAndPosList.size() )
			{
				if(flag ==1)	
					result+=" ";
				result+=Integer.toString(i);
				flag=1;
			}
		
		}
		System.out.println(result);
		
		return result;
		
	}

}
