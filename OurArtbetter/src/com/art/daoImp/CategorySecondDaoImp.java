package com.art.daoImp;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import com.art.dao.CategorySecondDao;
import com.art.entity.Artwork;
import com.art.entity.CategorySecond;
@Repository("categorySecondDao")
public class CategorySecondDaoImp implements CategorySecondDao{
	@Resource(name="sessionFactory")
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
/*
	@Override
	public void deleteAllInBatch() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteInBatch(Iterable<CategorySecond> arg0) {
		// TODO Auto-generated method stub
		
	}
*/
	@Override
	public List<CategorySecond> findAll() {
		String hql = "from CategorySecond";
		@SuppressWarnings("unchecked")
		List<CategorySecond> list = this.sessionFactory.getCurrentSession().createQuery(hql)
				.list();
		return list;
	}

	@Override
	public CategorySecond findAll(int csid) {
		return (CategorySecond)this.sessionFactory.getCurrentSession().get(CategorySecond.class, csid);
	}
/*
	@Override
	public Page<CategorySecond> findAll(Pageable arg0) {
		// TODO Auto-generated method stub
		return null;
	}
*/

	@Override
	public void delete(int csid) {
		CategorySecond categorySecond=null;
		  String hql = "delete CategorySecond a where a.csid="+csid;
		  try {  
				Query query=this.sessionFactory.getCurrentSession().createQuery(hql); 
				query.setInteger(0, csid);
				categorySecond= (CategorySecond)query.uniqueResult();
				System.out.println("CategorySecond"+categorySecond);

				this.sessionFactory.getCurrentSession().delete(categorySecond);
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
	public void delete(CategorySecond categorySecond) {
		this.sessionFactory.getCurrentSession().delete(categorySecond);
	}



	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public CategorySecond findOne(int csid) {
		CategorySecond categorySecond=null;
		String hql = "from Artwork where csid="+csid;
		try {  
			Query query=this.sessionFactory.getCurrentSession().createQuery(hql); 
			categorySecond=(CategorySecond)query.uniqueResult();
		}
		catch (HibernateException e) 
		{ 
			throw e; 
		}finally
		{  
			this.sessionFactory.close(); 
		} 
		return categorySecond; 
	}


	@Override
	public int countCategorySecond() {
		int count=0;
		String hql="SELECT COUNT(*) FROM CategorySecond";
		try {  
			Query query=this.sessionFactory.getCurrentSession().createQuery(hql);
			count=(int) query.uniqueResult(); 
			} 
			catch (HibernateException e)
			{ throw e; }
			finally{  this.sessionFactory.close(); }  
		    return count; 
	}
	@Override
	public void save(CategorySecond categorySecond) {
		this.sessionFactory.getCurrentSession().save(categorySecond);
	}

}
