package com.art.controller;

import java.util.ArrayList;
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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.art.backstageService.InfoService;
import com.art.dao.ArtistDao;
import com.art.entity.Artist;
import com.art.entity.Artwork;
import com.art.entity.Information;
import com.art.exhibitService.ArtistExhibitService;
import com.art.exhibitService.ArtworkExhibitService;
@Controller

public class ExhibitController {
	
	@Resource
	private ArtistExhibitService artistExhibitService;
	private ArtworkExhibitService artworkExhibitService; 
	private InfoService infoService;
	
	@Autowired
	public ExhibitController(ArtistExhibitService artistExhibitService,ArtworkExhibitService artworkExhibitService, InfoService infoService)
	{
		this.artistExhibitService=artistExhibitService;
		this.artworkExhibitService=artworkExhibitService;
		this.infoService = infoService;
	}
	
	
	
	
	@RequestMapping(value = "/productList")
	public ModelAndView listAllArtwork(HttpServletRequest request)
	{
		List<Artwork> artworkList = artworkExhibitService.getAllArtwork();
		ModelAndView modelAndView=new ModelAndView("productList","artwork_list",artworkList);
		return modelAndView;

	}

	@RequestMapping("/")
	public String listAllIndex(ModelMap model)
	{
		List<Artist> artistList = artistExhibitService.getAllArtist();
		List<Artwork> productList = artworkExhibitService.getAllProduct();
		List<Artwork> auctionList = artworkExhibitService.getAllAuction();
		List<Artwork> custommadeList = artworkExhibitService.getAllCustommade();
		model.addAttribute("product_list", productList);
		model.addAttribute("auction_list", auctionList);
		model.addAttribute("custommade_list", custommadeList);
		model.addAttribute("artist_list", artistList);
		System.out.println("11111111111111");
		
		List<Information> adverList = new ArrayList<Information>();
		List<Information> infoList = new ArrayList<Information>();
		for(int i =1;i<4;i++)
			adverList.add(infoService.getTodayInfoByColumnId(i)); 
		
		for(int i =4;i<=6;i++)
			infoList.add(infoService.getTodayInfoByColumnId(i));
		model.addAttribute("adverList", adverList);
		model.addAttribute("infoList", infoList);
		System.out.println("ok");
		
		
		 return "index";

	}
	
	@RequestMapping(value = "/infoContent/${infomationId}")
	public ModelAndView infoContent(@PathVariable int infomationId,Model model)
	{
		Information information = infoService.getInformationById(infomationId);
		model.addAttribute(information);
		return new ModelAndView("infoContent");
	}
	

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