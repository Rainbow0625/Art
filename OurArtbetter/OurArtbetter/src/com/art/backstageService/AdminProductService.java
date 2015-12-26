package com.art.backstageService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.art.dao.ArtworkDao;
import com.art.entity.Artwork;

@Transactional
@Service
public class AdminProductService {

	@Autowired
	private ArtworkDao productRepository;
	/*
	//分页查询商品
	public Page<Artwork> listProduct(Integer page){
		//根据商品的时间进行排序
		Sort sort = new Sort(Sort.Direction.DESC,"pdate");
		//每页默认为10条记录
		Pageable pageable = new PageRequest(page - 1, 8, sort); 
		Page<Artwork> products = productRepository.findAll(pageable);
		return products;
	}
	*/
	//查询商品的页数
	public Integer countProduct() {
		Integer count = productRepository.CountProduct();
		return (count % 8 == 0 ?(count / 8) : ( count / 8 + 1));
	}

	//保存商品
	public void saveProduct(Artwork product) {
		productRepository.save(product);
	}

	//查找某个具体的商品
	public Artwork findProduct(Integer pid) {
		return productRepository.findOne(pid);
	}
	
	//删除商品
	public void deleteProduct(Artwork product){
		productRepository.delete(product);
	}
}
