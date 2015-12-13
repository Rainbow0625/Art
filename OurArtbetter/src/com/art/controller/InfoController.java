package com.art.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.art.backstageService.InfoService;
import com.art.entity.Information;

@Controller
public class InfoController 
{
	@Resource
	private InfoService infoService;
	
	@Autowired
	public InfoController(InfoService infoService)
	{
		this.infoService=infoService;
	}

	@RequestMapping("/")
	public String listAllInfo(ModelMap model)
	{
		List<Information> adverList = new ArrayList<Information>();
		List<Information> infoList = new ArrayList<Information>();
		for(int i =0;i<3;i++)
			adverList.add(infoService.getTodayInfoByColumnId(i)); 
		
		for(int i =3;i<6;i++)
			infoList.add(infoService.getTodayInfoByColumnId(i));
		model.addAttribute("adverList", adverList);
		model.addAttribute("adverList", infoList);
		System.out.println("ok");
		return "index";

	}
}
