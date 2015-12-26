package com.art.businessServiceImp;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;

import com.art.businessService.ProductService;
import com.art.dao.ArtworkDao;
import com.art.entity.Artist;
import com.art.entity.Artwork;

/*
 * 商品的service层
 */
@Transactional
@Controller
public class ProductServiceImp implements ProductService{

	@Resource
	private ArtworkDao productRepository;

	//根据二级分类查询商品
	@Override
	public List<Artwork> findByCsid(Integer csid) {
		return productRepository.findByCategorySecondCsid(csid);
	}

	//根据一级分类查询商品
	@Override
	public List<Artwork> findByCid(Integer cid){
		return productRepository.findByCategorySecondCategoryCid(cid);
	}
	
	//查找最热的商品10条
	@Override
	public List<Artwork> findHot(){
		//分页查询，只查询第一列，每页10条记录
		return productRepository.findHot();
	}
	
	//查找最新的商品10条
	@Override
	public List<Artwork> findNew(){
		//按商品的时间进行降序排列,pdate为Product中的pdate字段
		Sort sort = new Sort(Sort.Direction.DESC,"pdate");
		//分页查询，只查询第一列，每页10条记录
		Pageable pageable = new PageRequest(0, 10, sort); 
		return productRepository.findAll();
	}

	//根据商品的pid的值查询商品
	@Override
	public Artwork findByPid(Integer pid) {
		return productRepository.findOne(pid);
	}
	//返回一级有多少页的数据
	@Override
	public Integer CountPageProductFromCategory(Integer cid) {
		Integer count = productRepository.CountPageProductFromCategory(cid);
		System.out.println("一级分类下有多少商品:"+count);
	    count = (count % 16 == 0 ? (count/16):(count/16+1));
	    System.out.println("总共有多少页:"+count);
	    return count;
	}

	//返回二级分类下游多少的数据
	@Override
	public Integer CountPageProductFromCategorySecond(Integer csid) {
		Integer count = productRepository.CountPageProductFromCategorySecond(csid);
		System.out.println("一级分类下有多少商品:"+count);
        count = (count % 16 == 0 ? (count/16):(count/16+1));
        System.out.println("总共有多少页:"+count);
        return count;
	}

	@Override
	public List<Artwork> findByArtist(Artist artist) {
		return productRepository.getArtwork(artist);
	}




	
}
