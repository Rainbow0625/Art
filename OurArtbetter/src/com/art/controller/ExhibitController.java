package com.art.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.art.dao.ArtistDao;
import com.art.dao.ProductDao;
import com.art.entity.Artwork;
import com.art.exhibitService.ArtistExhibitService;
import com.art.exhibitService.ProductExhibitService;

@Controller
@RequestMapping(value = "/ExhibitController")
public class ExhibitController {
	
	@Resource
	private ArtistExhibitService artistExhibitService;
	private ProductExhibitService productExhibitService; 
	
	@Autowired
	public ExhibitController(ArtistExhibitService artistExhibitService,ProductExhibitService productExhibitService)
	{
		this.artistExhibitService=artistExhibitService;
		this.productExhibitService=productExhibitService;
		
	}
	
	
	
	
	@RequestMapping(value = "/getAllProduct")
	public ModelAndView listAllProduct(HttpServletRequest request)
	{
		Map<String,Object> model = new HashMap<String,Object>();
		model.put("product_list", productExhibitService.getAllProduct());
		return new ModelAndView("product",model);
	}
	

	@RequestMapping(value = "/getAllArtistList")
	public ModelAndView listAllArtist(HttpServletRequest request)
	{
		Map<String,Object> model = new HashMap<String,Object>();
		model.put("artist_list", artistExhibitService.getAllArtist());
		return new ModelAndView("artistList",model);
	}
	
}