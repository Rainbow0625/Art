package com.art.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.art.dao.UserDao;
import com.art.entity.User;
import com.art.personalService.LoginService;
import com.art.personalService.SignupService;


@Controller

public class UserPersonalController 
{
	@Resource
	private SignupService signupService;
	//private LoginService loginService;
	private User user;
	
	@RequestMapping("/lala")
	public ModelAndView register(HttpServletRequest request,Model model){
		return new ModelAndView("login");
	}
	
	@RequestMapping("/userRegister")
	public ModelAndView userRegister(HttpServletRequest request,Model model){
		String tel=request.getParameter("tel");
		String password=request.getParameter("password");
		String comfirmPassword=request.getParameter("comfirmPassword");
		if(!comfirmPassword.equals(password))System.out.println("password not valid!");
		ModelAndView modelAndView=new ModelAndView("user");
		user=signupService.userRegister(tel, password);
		model.addAttribute("user", user);
		request.getSession().setAttribute("user", user);
		return modelAndView;
	}
	
	@RequestMapping ("/userLogin")
	public ModelAndView userLogin(HttpServletRequest request)
	{
		String tel=request.getParameter("tel");
		String password=request.getParameter("password");
		User user=signupService.userLogin(tel, password);
		ModelAndView modelAndView;
		if(user==null)
		{
			modelAndView =new ModelAndView("invalidLogin");
			return modelAndView;
		}
		else 
			modelAndView =new ModelAndView(user.getUsername());
		request.getSession().setAttribute("user", user);
		return modelAndView;
	}
}
