package com.art.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.art.backstageService.AdminCategoryService;
import com.art.entity.Category;

@Controller
public class AdminCategoryController {

	
	@Autowired
	private AdminCategoryService adminCategoryService;
	
	@ModelAttribute("category")
	public void getCategory(@RequestParam(value="cid",required=false) Integer cid,Map<String,Object> map){
		if(cid != null){
			Category category = adminCategoryService.findCategory(cid);
			map.put("category",category);
		}
	}
	//修改二级分类
	@RequestMapping(value="/updateCategory")
	public ModelAndView updateCategory(@ModelAttribute("category") Category category){
		adminCategoryService.updateCategory(category);
		ModelAndView modelAndView = new ModelAndView("redirect:/listCategory/1");
		return modelAndView;
	}
	//跳转到修改de一级分类
	@RequestMapping(value="/gotoEditCategory/{cid}")
	public String gotoEditCategory(@PathVariable("cid") Integer cid,Map<String,Object> map){
		Category category  = adminCategoryService.findCategory(cid);
		map.put("category",category);
		return "admin/category/edit";
	}
	
	//删除一级分类
	@RequestMapping(value="/deleteCategory/{cid}")
	public ModelAndView deleteCategory(@PathVariable("cid") Integer cid){
		adminCategoryService.deleteCategory(cid);
		ModelAndView modelAndView = new ModelAndView("redirect:/listCategory/");
		return modelAndView;
	}
	//添加一级分类，cname为前台传过来的一级分类的名称
	@RequestMapping(value="/addCategory")
	public ModelAndView addCategory(@RequestParam(value="cname",required=true) String cname){
		//创建一级分类的对象
		Category category = new Category();
		category.setCname(cname);
		adminCategoryService.addCategory(category);
		ModelAndView modelAndView = new ModelAndView("redirect:listCategory/1");
		return modelAndView;
	}
	
	//跳转到添加一级分类
	@RequestMapping(value="/gotoAddCategory")
	public String gotoAddCategory(){
		return "admin/category/add";
	}
	//查询一级分类
	
	@RequestMapping(value="/listCategory")
	public String listCategory(Map<String,Object> map){
		List<Category> categorys = adminCategoryService.listCategory();
		map.put("categorys", categorys);
		//查询一级分类的页数
		Integer count = adminCategoryService.countCategory();
		map.put("count", count);
		return "admin/category/list";
	}
	
}
