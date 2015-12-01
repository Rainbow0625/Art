package com.art.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

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

@Controller
@RequestMapping(value = "/exhibit")
public class ExhibitController {
	
	@Resource
	private ArtistExhibitService artistExhibitService;
	private ProductDao productDao;  //蕊君，这个不对 ，应该调用的是service，而且下面的方面名你要改一下
	
	/* 产品的controller */
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ModelAndView saveProduct1(HttpServletRequest request,
			ModelMap model){
		int productId =  Integer.valueOf(request.getParameter("artworkId"));
		String productName = request.getParameter("artworkName");
		String productKind = request.getParameter("artworkKind");
		int productPrice =  Integer.valueOf(request.getParameter("artworkPrice"));
		int productType =  Integer.valueOf(request.getParameter("productType"));
		String productInformation = request.getParameter("artworkInformation");
		int artistsId =  Integer.valueOf(request.getParameter("artistsId"));
	
		Artwork product = new Artwork();
		product.setartistsId(artistsId);
		product.setartworkPrice(productPrice);
		product.setartworkkind(productKind);
		product.setartworkInformation(productInformation);
		product.setartworkName(productName);
		productDao.save(product);
		return new ModelAndView("redirect:/product.html");
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView listAllProduct(){
		Map<String,Object> model = new HashMap<String,Object>();
		model.put("product_list", productDao.getAllProduct());
		return new ModelAndView("productList",model);
	}
	
	@RequestMapping(value="/add",method=RequestMethod.GET)
	public ModelAndView addProduct(@ModelAttribute("product") Artwork product,
			BindingResult result){
		return new ModelAndView("addproduct");
	}
	
	
	@RequestMapping(value="/del",method=RequestMethod.GET)
	public ModelAndView delProduct(@ModelAttribute("product") Artwork product){
		productDao.deleteById(product.getartworkId());		
		return new ModelAndView("redirect:/product.html");
	}
	
	
	/* 艺术家的controller */
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView listAllArtist()
	{
		Map<String,Object> model = new HashMap<String,Object>();
		model.put("artist_list", artistExhibitService.getAllArtist());
		return new ModelAndView("artistList",model);
	}
	
}