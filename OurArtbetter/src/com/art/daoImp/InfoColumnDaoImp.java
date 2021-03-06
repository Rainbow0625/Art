package com.art.daoImp;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import com.art.dao.InfoColumnDao;
import com.art.entity.InfoColumn;


@Repository("infoColumnDao")
public class InfoColumnDaoImp implements InfoColumnDao
{
	@Resource(name="sessionFactory")
	private SessionFactory sessionFactory;
	
	public InfoColumnDaoImp(){}
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public InfoColumn getInfoColumnById(int infoColumnById) {
		String hql = "from InfoColumn where id=?";
		Query query = this.sessionFactory.getCurrentSession().createQuery(hql);
		query.setInteger(0, infoColumnById);
		InfoColumn infoColumn = (InfoColumn) query.uniqueResult();
		return infoColumn;
	}

	@Override  //use!!
	public double getInforColumnPriceById(int infoColumnById) {
		String hql = "select from InfoColumn where id=?";
		Query query = this.sessionFactory.getCurrentSession().createQuery(hql);
		query.setInteger(0, infoColumnById);
		InfoColumn infoColumn = (InfoColumn) query.uniqueResult();
		double price = infoColumn.getPrice();
		return price;
	}

	@Override 
	public String getInforColumnTypeById(int infoColumnById) {
		String hql = "select from InfoColumn where id=?";
		Query query = this.sessionFactory.getCurrentSession().createQuery(hql);
		query.setInteger(0, infoColumnById);
		InfoColumn infoColumn = (InfoColumn) query.uniqueResult();
		String type = infoColumn.getContentType();
		return type;
	}
	
	
	
}
