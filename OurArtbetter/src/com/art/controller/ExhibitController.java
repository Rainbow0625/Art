package com.art.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.art.dao.ArtistDao;
import com.art.dao.ProductDao;
import com.art.entity.Artist;
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
	
	
	
	/*
	@RequestMapping
	public ModelAndView listAllProduct(HttpServletRequest request)
	{
		Map<String,Object> model = new HashMap<String,Object>();
		model.put("product_list", productExhibitService.getAllProduct());
		return new ModelAndView("product",model);
	}
	*/
	

	@RequestMapping(value = "/artistList")
	public ModelAndView listAllArtist(HttpServletRequest request,  
	        HttpServletResponse response)throws Exception
	{
		//Map<String,Object> model = new HashMap<String,Object>();
		List<Artist> artistList = artistExhibitService.getAllArtist();
		
		/*
		for (Artist i: artistList) 
		{
			System.out.print(i.getNickName());
		}
		*/
		
		//model.put("artist_list", artist_list);
		ModelAndView modelAndView=new ModelAndView("artistList","artist_list",artistList);
		return modelAndView;
	}
	
}