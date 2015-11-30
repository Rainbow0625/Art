package com.art.controller;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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

@Controller

public class ExhibitController {
	
	@Resource
	private ProductDao productDao;
	@RequestMapping(value = "/artwork/save", method = RequestMethod.POST)
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
	
	@RequestMapping(value="/artwork/add",method=RequestMethod.GET)
	public ModelAndView addProduct(@ModelAttribute("product") Artwork product,
			BindingResult result){
		return new ModelAndView("addproduct");
	}
	
	
	@RequestMapping(value="/artwork/del",method=RequestMethod.GET)
	public ModelAndView delProduct(@ModelAttribute("product") Artwork product){
		productDao.deleteById(product.getartworkId());		
		return new ModelAndView("redirect:/product.html");
	}
	
}
