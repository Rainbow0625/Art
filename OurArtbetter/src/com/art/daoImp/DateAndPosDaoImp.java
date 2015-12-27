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
	 * @throws ParseException 
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
			
			if(compare.equals(todaydate))  //������ڣ�ֱ�ӷ���
			{
				todayInfo = dateAndPosList.get(i).getInformation();
				//flag=1;
				break;
			}
			else if( compare.before(todaydate) )  //���С�ڣ������жϵı�Ҫ
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
		String hql= "delete DateAndPos from DateAndPos where id=?";
		Query query = session.createQuery(hql);
		query.setInteger(0,dateAndPosId);
		query.executeUpdate();
		session.flush();
		return true;
	}
	
	/**
	 * ����һ��DateAndPosʱ�����뵱ǰ�����õ�ʱ�䣬���ز����õ�������Ŀ��id
	 * @throws ParseException 
	 * */

	@Override
	public String getUnavailableColumnId(Date date, int days) throws ParseException
	{
		//Session session = sessionFactory.getCurrentSession();
		Date tempDate;
		
		String result = null;
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
			String hql= "from DateAndPos as dateAndPos where dateAndPos.infoColumn.id=?";
			Query query = sessionFactory.getCurrentSession().createQuery(hql);
			query.setInteger(0,i);
			@SuppressWarnings("unchecked")
			List<DateAndPos> dateAndPosList= query.list();
			for(int j =0 ; j< dateAndPosList.size(); j++ )
			{
				tempDate =dateAndPosList.get(j).getDate();
				startC.setTime(tempDate);       //startΪ���ݿ��в�����Ѿ���ռ�õ�ʱ��Ŀ�ʼʱ��
				endC.setTime(tempDate);  
				endC.add(Calendar.DAY_OF_YEAR, dateAndPosList.get(j).getDays());    //endΪ���ݿ��в�����Ѿ���ռ�õ�ʱ��Ŀ�ʼʱ��
				start = startC.getTime();
				end = endC.getTime();
				
				//���бȽ�
				if( testEnd.before(start) )
				{
					success++;
				}
				else if( testStart.after(end) )
				{
					success++;
				}

			}
			
			if( success ==  dateAndPosList.size())
			{
				if(flag ==1)
					result+=" ";
				result+=Integer.toString(i);
				flag=1;
			}
		
		}
		System.out.println(result);
		
		return result;//ifû�У�return null
		
	}

}
