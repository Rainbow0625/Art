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
import org.springframework.web.bind.annotation.RequestParam;
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
	@Resource
	private ArtworkExhibitService artworkExhibitService; 
	@Resource
	private InfoService infoService;
	
	public ExhibitController(){}
	
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
		
		//List<Information> adverList = new ArrayList<Information>();
		Information adver1 = new Information();
		Information adver2 = new Information();
		Information adver3 = new Information();
		adver1 = infoService.getTodayInfoByColumnId(1);
		adver2 = infoService.getTodayInfoByColumnId(2);
		adver3 = infoService.getTodayInfoByColumnId(3);
		List<Information> infoList = new ArrayList<Information>();
		/*
		for(int i =1;i<4;i++)
			adverList.add(infoService.getTodayInfoByColumnId(i)); 
			*/
	
		for(int i =4;i<=6;i++)
			infoList.add(infoService.getTodayInfoByColumnId(i));
		model.addAttribute("adver1", adver1);
		model.addAttribute("adver2", adver2);
		model.addAttribute("adver3", adver3);
		model.addAttribute("infoList", infoList);
		
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
	public String listAllArtist(@RequestParam int flag,ModelMap model)
	{
		List<Artist> artistList = artistExhibitService.getAllArtist();
		if(flag==1)
		{model.addAttribute("artist_list", artistList); return "shop";}
		else
		{model.addAttribute("artist_list", artistList);return "artistList";}
		
	}
	
}