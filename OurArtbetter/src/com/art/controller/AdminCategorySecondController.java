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
import org.springframework.web.servlet.ModelAndView;

import com.art.backstageService.AdminCategorySecondService;
import com.art.backstageService.AdminCategoryService;
import com.art.entity.Category;
import com.art.entity.CategorySecond;


@Controller
public class AdminCategorySecondController {

	@Autowired
	private AdminCategorySecondService adminCategorySecondService;
	@Autowired
	private AdminCategoryService adminCategoryService;
	
	//跟新二级分类
	@RequestMapping(value="/updateCategorySecond",method=RequestMethod.POST)
	public ModelAndView updateCategorySecond(@RequestParam("csid") Integer csid,@RequestParam("csname") String csname,
			@RequestParam("cid") Integer cid){
		Category category = adminCategoryService.findCategory(cid);
		CategorySecond categorySecond = adminCategorySecondService.findCategorySecond(csid);
		categorySecond.setCategory(category);
		categorySecond.setCsname(csname);
		adminCategorySecondService.updateCategorySecond(categorySecond);
		ModelAndView modelAndView = new ModelAndView("redirect:/listCategorySecond/1");
		return modelAndView;
	}
	
	//跳转到修改二级分类界面
	@RequestMapping(value="/gotoEditCategorySecond")
	public String gotoEditCategorySecond(@RequestParam Integer csid,
			Map<String,Object> map){
		//查找对应的二级分类
		CategorySecond categorySecond = adminCategorySecondService.findCategorySecond(csid);
		map.put("categorySecond", categorySecond);
		//查找对应的一级分类
		List<Category> categorys = adminCategoryService.findCategory();
		map.put("categorys", categorys);
		return "admin/categorysecond/edit";
	}
	
	//删除二级分类
	@RequestMapping(value="/deleteCategorySecond/{csid}")
	public ModelAndView deleteCategorySecond(@PathVariable("csid") Integer csid){
		adminCategorySecondService.deleteCategorySecond(csid);
		ModelAndView modelAndView = new ModelAndView("redirect:/listCategorySecond/");
		return modelAndView;
	}
	//跳转到添加二级分类的界面
	@RequestMapping(value="/gotoAddCategorySecond")
	public String gotoAddCategorySecond(Map<String,Object> map){
		List<Category> categorys = adminCategoryService.findCategory();
		map.put("categorys",categorys);
		return "admin/categorysecond/add";
	}
	
	//添加二级分类
	@RequestMapping(value="/addCategorySecond")
	public ModelAndView addCategorySecond(@RequestParam("csname") String csname,@RequestParam("cid") Integer cid){
		//查找一级分类对象
		Category category = adminCategoryService.findCategory(cid);
		//创建二级分类对象
	    CategorySecond categorySecond = new CategorySecond();
	    //设置一级分类和二级分类的关联关系
	    categorySecond.setCategory(category);
	    categorySecond.setCsname(csname);
	    //保存对象
	    adminCategorySecondService.addCategorySecond(categorySecond);
	    ModelAndView modelAndView = new ModelAndView("redirect:listCategorySecond/1");
		return modelAndView;
	}
	
	//按分页显示二级分类
	@RequestMapping(value="/listCategorySecond")
	public String listCategorySecond(Map<String,Object> map){
		 List<CategorySecond> categorySeconds = adminCategorySecondService.listCategorySecond();
		 map.put("categorySeconds", categorySeconds);
		 Integer count = adminCategorySecondService.countCategorySecond();
		 map.put("count", count);
		return "admin/categorysecond/list";
	}
	
}
