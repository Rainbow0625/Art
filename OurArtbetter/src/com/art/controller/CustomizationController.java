package com.art.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.art.businessService.CustomizationService;

@Controller
public class CustomizationController 
{
	//@Resource
	//private CustomizationService customizationService;
	
	public CustomizationController(){}
	
	@RequestMapping("/customization") 
	public ModelAndView tocustomization()
	{
		return new ModelAndView("customization");
	}
	
	@RequestMapping("/customizationForm")
	public ModelAndView startCustomization()
	{
		return new ModelAndView("customization-form");
	}
	

}
