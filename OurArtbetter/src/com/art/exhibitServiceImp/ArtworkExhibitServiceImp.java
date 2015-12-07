package com.art.exhibitServiceImp;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.art.dao.ArtistDao;
import com.art.dao.ProductDao;
import com.art.daoImp.ProductDaoImp;
import com.art.entity.Artwork;
import com.art.exhibitService.ProductExhibitService;



@Service
@Transactional(propagation = Propagation.SUPPORTS)
public class ArtworkExhibitServiceImp implements ProductExhibitService{
	@Resource
	private ProductDao productDao;
	
	public void setProductDao(ProductDao productDao){
		this.productDao=productDao;
	}
	
	@Override
	public List<Artwork> getAllProduct() {
		List<Artwork> product_list = productDao.getAllProduct();
		return product_list;
	}

}
