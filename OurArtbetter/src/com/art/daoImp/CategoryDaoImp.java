package com.art.daoImp;

import java.util.List;

import javax.annotation.Resource;
import javax.swing.text.Position;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import com.art.dao.CategoryDao;
import com.art.entity.Artwork;
import com.art.entity.Category;

@Repository("categoryDao")
public class CategoryDaoImp implements CategoryDao{
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	@Override
	public int countCategory() {
		int count;
		try{
		String hql="select count(*) from Category as category";
		System.out.println("1234");
		Query query=this.sessionFactory.getCurrentSession().createQuery(hql);
		count=(int) query.uniqueResult(); 
		} 
		catch (HibernateException e)
		{ throw e; }
		finally{  this.sessionFactory.close(); }  
	    return count; 
	}

	@Override
	public List<Category> findAll() {
		String hql = "from Category";
		Query query = this.sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Category> category_list = query.list();
		return category_list;
	}

	@Override
	public void save(Category category) {
		
		this.sessionFactory.getCurrentSession().save(category);
	}
	@Override
	public void delete(int cid) {
		Category category=null;
		  String hql = "delete Category a where a.id=?";
		  try {  
				Query query=this.sessionFactory.getCurrentSession().createQuery(hql); 
				query.setInteger(0, cid);
				category= (Category)query.uniqueResult();
				System.out.println("CategoryDao"+category);

				this.sessionFactory.getCurrentSession().delete(category);
			}
			catch (HibernateException e) 
			{ 
				throw e; 
			}finally
			{  
				this.sessionFactory.close(); 
			} 
			}
	@Override
	public Category findOne(int cid) {
		Category category=null;
		String hql = "from Category where cid=cid";
		try {  
			Query query=this.sessionFactory.getCurrentSession().createQuery(hql); 
			category=(Category)	query.uniqueResult();
		}
		catch (HibernateException e) 
		{ 
			throw e; 
		}finally
		{  
			this.sessionFactory.close(); 
		} 
		return category; 
		}
	

}
