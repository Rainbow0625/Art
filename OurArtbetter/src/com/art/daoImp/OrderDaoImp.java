package com.art.daoImp;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import com.art.dao.OrderDao;
import com.art.entity.Artwork;
import com.art.entity.CategorySecond;
import com.art.entity.Order;
@Repository("orderDao")
public class OrderDaoImp implements OrderDao{
	@Resource(name="sessionFactory")
	private SessionFactory sessionFactory;
	
	//Session session=sessionFactory.openSession();
	
	public OrderDaoImp(){}
	
	/*
	@Override
	public void deleteAllInBatch() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void deleteInBatch(Iterable<Order> arg0) {
		// TODO Auto-generated method stub
		
	}
	*/
	@Override
	public List<Order> findAll() {
		String hql = "from Order";
		@SuppressWarnings("unchecked")
		List<Order> list = this.sessionFactory.getCurrentSession().createQuery(hql)
				.list();
		return list;
	}
	@Override
	public Order findAll(int orderId) {
		return (Order)this.sessionFactory.getCurrentSession().get(Order.class, orderId);
	}
	
	
	@Override
	public void delete(int orderId) {
		Order order=null;
		  String hql = "delete Order a where a.oid=?";
		  try {  
				Query query=this.sessionFactory.getCurrentSession().createQuery(hql); 
				query.setInteger(0, orderId);
				order= (Order)query.uniqueResult();
				System.out.println("Order"+order);

				this.sessionFactory.getCurrentSession().delete(order);
			}
			catch (HibernateException e) 
			{ 
				throw e; 
			}
	}
	@Override
	public void delete(Order order) {
		 try {  
				System.out.println("Order"+order);
				this.sessionFactory.getCurrentSession().delete(order);
			}
			catch (HibernateException e) 
			{ 
				throw e; 
			} 
	}
	
	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public Order findOne(int orderId) {
		Order order=null;
		String hql = "from Order where oid=?"+orderId;
		try {  
			Query query=this.sessionFactory.getCurrentSession().createQuery(hql); 
			order=(Order)query.uniqueResult();
		}
		catch (HibernateException e) 
		{ 
			throw e; 
		}
		return order; 
	}

	@Override
	public Order findByOid(int orderId) {
		Order order=null;
		String hql = "from Order where oid="+orderId;;
		try {  
			Query query=this.sessionFactory.getCurrentSession().createQuery(hql); 
			order=(Order)query.uniqueResult();
		}
		catch (HibernateException e) 
		{ 
			throw e; 
		}
		return order; 
	}
	
	@Override
	public List<Order> findByUserUid(int uid) {
		String hql = "from Order,User where Order.uid=User.id";
		@SuppressWarnings("unchecked")
		List<Order> list = this.sessionFactory.getCurrentSession().createQuery(hql)
				.list();
		return list;
	}
	
	@Override
	public int findCountByorderId(int oid) {
		int count=0;
		String hql="SELECT COUNT(*) FROM orders o WHERE oid = ?1";
		try {  
			Query query=this.sessionFactory.getCurrentSession().createQuery(hql);
			count=(int) query.uniqueResult(); 
			} 
			catch (HibernateException e)
			{ throw e; }
		    return count; 
	}
	@Override
	public void save(Order order) {
		Session session = sessionFactory.getCurrentSession();
		session.save(order);
		session.flush();
	}


	@Override
	public int findCountByUid(int uid) {
		int count=0;
		String hql="SELECT COUNT(*) FROM orders o WHERE uid = ?1";
		try {  
			Query query=this.sessionFactory.getCurrentSession().createQuery(hql);
			count=(int) query.uniqueResult(); 
			} 
			catch (HibernateException e)
			{ throw e; }
		    return count; 
	}
	@Override
	public Long count() {
		long count;
		String hql="SELECT COUNT(*) FROM Order";
		try {  
			Query query=this.sessionFactory.getCurrentSession().createQuery(hql);
			count=(long) query.uniqueResult(); 
			} 
			catch (HibernateException e)
			{ throw e; } 
		    return count; 
	}
}
