package com.art.controller;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.art.entity.Admin;
import com.art.entity.User;
import com.art.personalService.AdminPersonalService;
import com.art.personalService.UserPersonalService;

@Controller
public class RegisterAndLoginController 
{
	@Resource
	private UserPersonalService userPersonalService;
	private AdminPersonalService adminPersonalService;

	@RequestMapping("/Register")//正则表达式的判断放在前端做
	public ModelAndView userRegister(HttpServletRequest request)throws Exception
	{
		String tel=request.getParameter("tel");
		String password=request.getParameter("password");
		String confirmPassword=request.getParameter("confirmPassword");
		int RegisterType = Integer.parseInt(request.getParameter("RegisterType")); 
		//System.out.println(tel+password);
		ModelAndView modelAndView = null;
		String messageString;
		if(!confirmPassword.equals(password))
		{
			messageString="两次密码不一致!";	
			return new ModelAndView("Register1","message",messageString);
		}
		if(RegisterType==1)
		{
			User user=userPersonalService.userRegister(tel,password);
		    modelAndView=new ModelAndView("index","user",user);
		}
		else if(RegisterType==2)
		{
			//这里带补充主编与采编的登录
		}
		else
		{
			int adminType = Integer.parseInt(request.getParameter("adminType"));
			Admin admin=adminPersonalService.addAdmin(tel, confirmPassword, adminType);
		    modelAndView=new ModelAndView("Success","admin",admin);
		}
		
		return modelAndView;
	}

	@RequestMapping ("/Login")
	public ModelAndView userLogin(HttpServletRequest request)throws ServletException, IOException 
	{
		String tel=request.getParameter("tel");
		String password=request.getParameter("password");
		int loginType = Integer.parseInt(request.getParameter("loginType"));		
		ModelAndView modelAndView = null;
		int errorFlag =0;
		if(loginType==1)
		{
			User user=userPersonalService.userLogin(tel, password);
			if(user==null)
				errorFlag=1;
			else 
				modelAndView =new ModelAndView("index","user",user);
		}
		else if(loginType==2)
		{
			//这里带补充主编与采编的登录
		}
		else if(loginType==3)
		{
			Admin admin = adminPersonalService.adminLogin(tel, password);
			if(admin==null)
				errorFlag=1;
			else 
				modelAndView =new ModelAndView("Success","admin",admin);
		}
		if(errorFlag == 1)
		{
			String message = "用户名或者密码错误!";
			modelAndView = new ModelAndView("login","message",message);
		}
		return modelAndView;
	}
	
	@RequestMapping("TurnToLogin")
	public ModelAndView TurnToLogin(HttpServletRequest request)throws Exception
	{
		return new ModelAndView("login");

	}
	
	@RequestMapping("TurnToAdminLogin")
	public ModelAndView TurnToAdminLogin(HttpServletRequest request)throws Exception
	{
		return new ModelAndView("ADMIN_login");

	}
	
	@RequestMapping("TurnToRegister")
	public ModelAndView TurnToRegister(HttpServletRequest request)throws Exception
	{
		return new ModelAndView("Register");

	}
}
