package com.art.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.art.businessService.ProductService;
import com.art.entity.Artist;
import com.art.entity.Artwork;

@Controller
public class ProductController {

	@Autowired
	private ProductService productService;
	
	//根据二级分类查询商品
	@RequestMapping(value="/findByCsid")
	public String findByCsid(@RequestParam("csid") Integer csid,Map<String,Object> map){
		Integer count = productService.CountPageProductFromCategorySecond(csid);
		List<Artwork> products = productService.findByCsid(csid);
		map.put("products", products);
		map.put("csid", csid);
		return "productList";
	}
	
	@RequestMapping(value="/findByArtist")
	public String findByArtistid(@RequestParam("artist") Artist artist,Map<String,Object> map){
		@SuppressWarnings("unused")
		
		List<Artwork> products = productService.findByArtist(artist);
		map.put("products", products);
		map.put("artist", artist);
		return "product";
	}
	
	//首页中点击一级分类查询商品
	@RequestMapping(value="/findByCid")
	public String findByCid(@RequestParam Integer cid,Map<String,Object> map){
		List<Artwork> products = productService.findByCid(cid);
		Integer count = productService.CountPageProductFromCategory(cid);
		map.put("products", products);
		map.put("cid", cid);
		return "productList";
	}
	//根据商品的pid查询商品
	@SuppressWarnings("unused")
	@RequestMapping(value="/findByPid",method=RequestMethod.GET)
	public String findByPid(@RequestParam int pid,Map<String,Object> map){
		Artwork artwork= productService.findByPid(pid);
		Artist artist=artwork.getArtist();
		List<Artwork> products = productService.findByArtist(artist);
		map.put("products", products);
		map.put("product", artwork);
		map.put("artist", artist);
		return "product";
	}
}
