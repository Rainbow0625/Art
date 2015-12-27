package com.art.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.hibernate.Session;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.art.entity.Admin;
import com.art.entity.ChiefEditor;
import com.art.entity.Editor;
import com.art.entity.User;
import com.art.personalService.AdminPersonalService;
import com.art.personalService.ChiefEditorPersonalService;
import com.art.personalService.EditorPersonalService;
import com.art.personalService.UserPersonalService;

@Controller
public class RegisterAndLoginController 
{
	@Resource
	private UserPersonalService userPersonalService;
	@Resource
	private AdminPersonalService adminPersonalService;
	@Resource
	private EditorPersonalService editorPersonalService;
	@Resource
	private ChiefEditorPersonalService chiefEditorPersonalService;
	
	
	public RegisterAndLoginController(){}
	
	@RequestMapping("/ADMIN_login")
	public ModelAndView toLogin()
	{
		return  new ModelAndView("ADMIN_login");
	}
	

	@RequestMapping("/Register")//正则表达式的判断放在前端做
	public ModelAndView Register(HttpServletRequest request)throws Exception
	{
		String tel=request.getParameter("tel");
		String password=request.getParameter("password");
		String confirmPassword=request.getParameter("confirmPassword");
		System.out.println(tel+" "+password);//

		ModelAndView modelAndView = null;
		String messageString;
		if(!confirmPassword.equals(password))
		{
			messageString="两次密码不一致!";	
			return new ModelAndView("Register","message",messageString);
		}

		try {
			User user=userPersonalService.userRegister(tel,password);
			request.getSession().setAttribute("userName", user.getTel());
			request.getSession().setAttribute("user", user);
			modelAndView=new ModelAndView("index","user",user);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println("error in user register in controller!");//
		}
		

		return modelAndView;
	}

	@RequestMapping ("/Login")
	public ModelAndView Login(HttpServletRequest request)throws ServletException, IOException 
	{
		int loginType = Integer.parseInt(request.getParameter("loginType"));		
		ModelAndView modelAndView = null;
		int errorFlag =0;
		//System.out.println(tel+" "+password);//for test
		if(loginType==1)
		{
			try {
				String tel=request.getParameter("tel");
				String password=request.getParameter("password");
				User user=userPersonalService.userLogin(tel, password);
				if(user==null)
					errorFlag=1;
				else {
					request.getSession().setAttribute("userName", user.getTel());
					request.getSession().setAttribute("user", user);
					modelAndView =new ModelAndView("index","user",user);
				}
				if(errorFlag == 1)
				{
					String message = "用户名或者密码错误!";
					modelAndView = new ModelAndView("login","message",message);
				}
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
				System.out.println("error in user login in controller!");//
			}
			
				
		}
		else if(loginType==2)
		{
			String name=request.getParameter("name");
			String password=request.getParameter("password");
			String adminType = request.getParameter("adminType");
			
			Admin admin;
			Editor editor;
			ChiefEditor chiefEditor;
			
			switch(adminType)
			{
			case "admin":
				try {
					//System.out.println(adminType+" "+name+" "+password);//for test
					admin = adminPersonalService.findAdminByNameAndPassword(name, password);
					if(admin!=null)
					{
						request.getSession().setAttribute("admin", admin);
						modelAndView =new ModelAndView("ADMIN_welcome","admin",admin);
					}
					else {
						String message = "用户名或者密码错误!";
						modelAndView = new ModelAndView("ADMIN_login","message",message);
					} 

				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
					System.out.println("error in admin login in controller!");//
				}
				break;
			case "editor":
				try {	
					//System.out.println(adminType+" "+name+" "+password);//for test
					editor = editorPersonalService.findEditor(name, password);
					if(editor!=null)
					{
						request.getSession().setAttribute("editor", editor);
						modelAndView =new ModelAndView("ADMIN_welcome","editor",editor);
					}
						
					else {
						String message = "用户名或者密码错误!";
						modelAndView = new ModelAndView("ADMIN_login","message",message);
					}
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
					System.out.println("error in editor login in controller!");//
				}	
				break;
			case "chiefEditor":
				try {
					//System.out.println(adminType+" "+name+" "+password);//for test
					chiefEditor = chiefEditorPersonalService.findChiefEditor(name, password);
					if(chiefEditor!=null)
					{
						request.getSession().setAttribute("chiefEditor", chiefEditor);
						modelAndView =new ModelAndView("ADMIN_welcome","chiefEditor",chiefEditor);
					}
						
					else {
						String message = "用户名或者密码错误!";
						modelAndView = new ModelAndView("ADMIN_login","message",message);
					}
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
					System.out.println("error in chiefEditor login in controller!");//
				}
			}
		}		
		
		return modelAndView;
	}
	
	@RequestMapping("/LoginOut")
	public ModelAndView LoginOut(HttpServletRequest request)
	{
//		Admin admin = (Admin) request.getSession().getAttribute("admin");
//		Editor editor = (Editor)request.getSession().getAttribute("editor");
//		ChiefEditor chiefEditor = (ChiefEditor)request.getSession().getAttribute("chiefEditor");

//		Session session = (Session) request.getSession();
//		session.evict(adminPersonalService);
//		session.evict(editorPersonalService);
//		session.evict(chiefEditorPersonalService);
		request.getSession().setAttribute("admin", null);
		request.getSession().setAttribute("editor", null);
		request.getSession().setAttribute("chiefEditor", null);
				
		return new ModelAndView("ADMIN_welcome");
		
	}

	@RequestMapping("TurnToLogin")
	public ModelAndView TurnToLogin(HttpServletRequest request)throws Exception
	{
		User user = (User) request.getSession().getAttribute("user");
		
		if(user==null)
			return new ModelAndView("login");			
		else
		{
			String userName = user.getTel();		
			return new ModelAndView("personalInfo","userName",userName);	
		}
				
	}

	/*
	@RequestMapping("TurnToAdminLogin")
	public ModelAndView TurnToAdminLogin(HttpServletRequest request)throws Exception
	{
		return new ModelAndView("ADMIN_login");

	}
	*/

	@RequestMapping("TurnToRegister")
	public ModelAndView TurnToRegister(HttpServletRequest request)throws Exception
	{
		return new ModelAndView("Register");

	}
	
	@RequestMapping("TurnToPersonalCenter")
	public ModelAndView TurnToPersonalCenter(HttpServletRequest request)throws Exception
	{
		String userName = request.getParameter("userName");
		System.out.println(userName);//
		return new ModelAndView("personalcenter","userName",userName);

	}
}
