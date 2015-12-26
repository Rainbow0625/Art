package com.art.daoImp;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.art.dao.ArtworkDao;
import com.art.entity.Artist;
import com.art.entity.Artwork;

@Repository("ArtworkDao")
public class ArtworkDaoImp implements ArtworkDao {
	@Resource(name="sessionFactory")
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	@Override
	public List<Artwork> getAllAuction() {
		// TODO Auto-generated method stub
				String hql = "from Artwork where artworkType=3";
				Query query = this.sessionFactory.getCurrentSession().createQuery(hql);
				@SuppressWarnings("unchecked")
				List<Artwork> auction_list = query.list();
				return auction_list;// TODO Auto-generated method stub
	}
	@Override
	public void deleteArtworkById(int ArtworkId) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public List<Artwork> getAllArtwork() {
		String hql = "from Artwork";
		Query query = this.sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Artwork> artwork_list = query.list();
		return artwork_list;// TODO Auto-generated method stub
	}
	@Override
	public List<Artwork> getAllProduct() {
		// TODO Auto-generated method stub
		String hql = "from Artwork where artworkType=1";
		Query query = this.sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Artwork> product_list = query.list();
		return product_list;
	}
	@Override
	public List<Artwork> getAllCustommade() {
		// TODO Auto-generated method stub
		String hql = "from Artwork where artworkType=2";
		Query query = this.sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Artwork> custommade_list = query.list();
		return custommade_list;
	}
	/*
	@Override
	public void deleteAllInBatch() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteInBatch(Iterable<Artwork> arg0) {
		// TODO Auto-generated method stub
		
	}
*/
	@Override
	public List<Artwork> findAll() {
		String hql = "from Artwork";
		@SuppressWarnings("unchecked")
		List<Artwork> list = this.sessionFactory.getCurrentSession().createQuery(hql)
				.list();
		return list;
	}
/*
	@Override
	public List<Artwork> findAll(Sort arg0) {
		// TODO Auto-generated method stub
		return null;
	}
*/
	@Override
	public Artwork findAll(int artworkId) {
		return (Artwork)this.sessionFactory.getCurrentSession().get(Artwork.class, artworkId);
	}

	@Override
	public void delete(int artworkId) {
		Artwork artwork=null;
		  String hql = "delete Artwork a where a.artworkId=?";
		  try {  
				Query query=this.sessionFactory.getCurrentSession().createQuery(hql); 
				query.setInteger(0, artworkId);
				artwork= (Artwork)query.uniqueResult();
				System.out.println("Artwork"+artwork);

				this.sessionFactory.getCurrentSession().delete(artwork);
			}
			catch (HibernateException e) 
			{ 
				throw e; 
			}
	}

	@Override
	public void delete(Artwork artwork) {
		  try {  
				System.out.println("Artwork"+artwork);
				this.sessionFactory.getCurrentSession().delete(artwork);
			}
			catch (HibernateException e) 
			{ 
				throw e; 
			}
	}

	@Override
	public void deleteAll() {
		
		
	}

	@Override
	public Artwork findOne(int  artworkId) {
		Artwork artwork=null;
		String hql = "from Artwork where artworkId="+artworkId;
		try {  
			Query query=this.sessionFactory.getCurrentSession().createQuery(hql); 
			artwork=(Artwork)query.uniqueResult();
		}
		catch (HibernateException e) 
		{ 
			throw e; 
		}
		return artwork; 
		}
	
	@Override
	public List<Artwork> findHot() {
		String hql="from Artwork by hotNum desc";
		//from User order by Age desc
		Query query=this.sessionFactory.getCurrentSession().createQuery(hql); 
		query.setFirstResult(0);//开始从第几条开始取数据
        query.setMaxResults(10);//取多少条数据
        @SuppressWarnings("unchecked")
		List<Artwork> list= query.list();//转换成表的集合。。。
		return list;
	}

	@Override
	public List<Artwork> findByCategorySecondCsid(int csid) {
		String hql = "from Artwork,CategorySecond where Artwork.csid=CategorySecond.csid";
		@SuppressWarnings("unchecked")
		List<Artwork> list = this.sessionFactory.getCurrentSession().createQuery(hql)
				.list();
		return list;
	}
	@Override
	public List<Artwork> findByCategorySecondCategoryCid(int cid) {
		String hql = "from Artwork,CategorySecond,Category where Artwork.csid=CategorySecond.csid and CategorySecond.csid=Category.cid";
		@SuppressWarnings("unchecked")
		List<Artwork> list = this.sessionFactory.getCurrentSession().createQuery(hql)
				.list();
		return list;
	}
	@Override
	public int CountPageProductFromCategory(Integer cid) {
		int count=0;
		String hql="SELECT COUNT(*) FROM Artwork p,Category c,CategorySecond cs WHERE p.csid = cs.csid and cs.cid = c.cid and c.cid = ?1 ";
		try {  
			Query query=this.sessionFactory.getCurrentSession().createQuery(hql);
			count=(Integer) query.uniqueResult(); 
			} 
			catch (HibernateException e)
			{ throw e; }
		    return count; 
	}

	@Override
	public int CountPageProductFromCategorySecond(Integer csid) {
		int count=0;
		String hql="SELECT COUNT(*) FROM Artwork p,CategorySecond cs WHERE p.csid = cs.csid and cs.csid = ?1 ";
		try {  
			Query query=this.sessionFactory.getCurrentSession().createQuery(hql);
			count=(Integer) query.uniqueResult(); 
			} 
			catch (HibernateException e)
			{ throw e; }
		    return count; 
	}

	@Override
	public int CountProduct() {
		int count=0;
		String hql="SELECT COUNT(*) FROM Artwork";
		try {  
			Query query=this.sessionFactory.getCurrentSession().createQuery(hql);
			count=(Integer) query.uniqueResult(); 
			} 
			catch (HibernateException e)
			{ throw e; }
		    return count; 
	}
	@Override
	public void save(Artwork product) {
		this.sessionFactory.getCurrentSession().save(product);
	}
	@Override
	public List<Artwork> getArtwork(Artist artist) {
		String hql = "from Artwork where artistId="+artist.getId();
		@SuppressWarnings("unchecked")
		List<Artwork> list = this.sessionFactory.getCurrentSession().createQuery(hql)
				.list();
		return list;
	}


	
}
