package com.art.businessService;

import java.util.List;
import com.art.entity.Artwork;

/*
 * 商品的service层
 */
public interface ProductService {

	//根据二级分类查询商品
	public List<Artwork> findByCsid(Integer csid);
	//根据一级分类查询商品
	public List<Artwork> findByCid(Integer cid);
	
	//查找最热的商品10条
	public List<Artwork> findHot();
	
	//查找最新的商品10条
	public List<Artwork> findNew();

	//根据商品的pid的值查询商品
	public Artwork findByPid(Integer pid);
	//返回一级有多少页的数据
	public Integer CountPageProductFromCategory(Integer cid);
	//返回二级分类下游多少的数据
	public Integer CountPageProductFromCategorySecond(Integer csid);
	
}
