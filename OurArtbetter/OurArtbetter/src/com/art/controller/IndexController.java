package com.art.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.art.businessService.CategoryService;
import com.art.businessService.ProductService;


@Controller
public class IndexController {

	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private ProductService productService;
	
	//商品首页的action
	@RequestMapping(value="/index")
	public String showIndex(Map<String,Object> map,HttpSession session){
		//把所有的一级分类都存入到session中
		session.setAttribute("cList", categoryService.getCategory());;
		//把最新的10条商品存放到map集合中
		map.put("nList", productService.findNew());
		//把最热的10条商品添加到马屁集合中
		map.put("hList", productService.findHot());
		return "index"; 
	}
}
