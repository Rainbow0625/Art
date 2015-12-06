package com.art.daoImp;

/**
 * @author Administrator
 *
 */
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.art.dao.ProductDao;
import com.art.entity.Artwork;
import com.art.entity.User;


@Repository("productDao")

public class ProductDaoImp implements ProductDao{
	
	private SessionFactory sessionFactory;
	@Resource(name="sessionFactory")
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	@Override
	public void deleteById(int productid) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Artwork> getAllProduct() {
		// TODO Auto-generated method stub
		//String hql = "from User";
		Query query = this.sessionFactory.getCurrentSession().createQuery("select *from Artwork where artworkType=1");
		@SuppressWarnings("unchecked")
		List<Artwork> product_list = query.list();
		return product_list;
	}

	@Override
	public void save(Artwork product) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Artwork product) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Artwork getProductByname(String Productname) {
		// TODO Auto-generated method stub
		return null;
	}

}
