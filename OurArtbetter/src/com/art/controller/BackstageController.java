package com.art.controller;
/*
 * @author 范溢贞 24320132202399
 */

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;








import com.art.backstageService.ManageUserService;
import com.art.entity.Admin;
import com.art.entity.Artist;
import com.art.entity.User;
import com.art.personalService.AdminPersonalService;
import com.art.personalService.UserPersonalService;

@Controller
public class BackstageController 
{
	@Resource
	private ManageUserService manageUserService;
	@Resource
	private UserPersonalService userPersonalService;
	@Resource
	private AdminPersonalService adminPersonalService;

	@RequestMapping("/setUserIlleagalOrleagal")
	public ModelAndView setUserIlleagalOrleagal(HttpServletRequest request)
	{
		String tel = request.getParameter("cur_tel");
		int state = Integer.parseInt(request.getParameter("cur_state"));
		ModelAndView modelAndView = null;
		try {
			User user = manageUserService.setUserIlleagal(tel,state);
			if(user!=null)
			{
				List<User> user_list = userPersonalService.getAllUser();
				request.getSession().setAttribute("user_list", user_list);
				modelAndView = new ModelAndView("ADMIN_usermanage","user_list",user_list);
				//				modelAndView = new ModelAndView("xxx","user",user);
			}
			//			else 
			//				System.out.println("error in setUserIlleagal(user is null) in controller!");//for debug
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println("error in backstage setUserIlleagalOrleagal in controller!");//for debug	
		}
		return modelAndView;		
	}

	@RequestMapping("/auditArtist")
	public ModelAndView auditArtist(HttpServletRequest request)
	{
		ModelAndView modelAndView = null;
		String tel = request.getParameter("tel");
		String status = request.getParameter("status");
		try {
			Artist artist = manageUserService.auditArtist(tel, status);
			if(artist != null)
				modelAndView = new ModelAndView("xxx","artist",artist);
			else 
			{
				String message = "审核艺术家失败！";
				modelAndView = new ModelAndView("error","message",message);
			}				
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println("error in backstage auditArtist in controller!");//for debug
		}
		return modelAndView;		
	}

	@RequestMapping("/setAdminType")
	public ModelAndView setAdminType(HttpServletRequest request)
	{
		ModelAndView modelAndView = null;
		int id= Integer.parseInt(request.getParameter("id"));
		int adminType = Integer.parseInt(request.getParameter("adminType"));
		try {
			Admin admin = manageUserService.setAdminType(id, adminType);
			if(admin != null)
				modelAndView = new ModelAndView("xxx","admin",admin);
			else 
			{
				String message = "设置管理员权限失败！";
				modelAndView = new ModelAndView("error","message",message);
			}			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println("error in backstage setAdminType in controller!");//for debug
		}
		return modelAndView;		
	}

	@RequestMapping("/addAdmin")
	public ModelAndView addAdmin(HttpServletRequest request)
	{
		ModelAndView modelAndView = null;
		String name = request.getParameter("name");
		String password = "123";
		int  adminType = Integer.parseInt(request.getParameter("adminType"));
		try {
			Admin admin = manageUserService.addAdmin(name, password, adminType);
			if(admin != null)
				modelAndView = new ModelAndView("xxx","admin",admin);
			else 
			{
				String message = "添加管理员失败！";
				modelAndView = new ModelAndView("error","message",message);
			}				
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println("error in backstage addAdmin in controller!");//for debug
		}

		return modelAndView;

	}

	@RequestMapping("/resetPassword")
	public ModelAndView resetPassword(HttpServletRequest request)
	{	
		int resetType = Integer.parseInt(request.getParameter("resetType"));
		int id =Integer.parseInt(request.getParameter("cur_id"));
		System.out.println(id+" hahaha");//for debug	
		ModelAndView modelAndView = null;
		switch (resetType) {
		case 1:
			try {
				User user = manageUserService.resetUserPassword(id, "123");
				if(user!=null)
				{
					List<User> user_list = userPersonalService.getAllUser();
					request.getSession().setAttribute("user_list", user_list);
					modelAndView = new ModelAndView("ADMIN_usermanage","user_list",user_list);
					//				modelAndView = new ModelAndView("xxx","user",user);
				}
				//			else 
				//				System.out.println("error in setUserIlleagal(user is null) in controller!");//for debug
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
				System.out.println("error in backstage setUserIlleagal in controller!");//for debug	
			}
			break;

		case 2:
			try {
				Admin admin = manageUserService.resetAdminPassword(id, "123");
				if(admin!=null)
				{
					List<Admin> admin_list = adminPersonalService.getAllAdmin();
					request.getSession().setAttribute("admin_list",admin_list);
					modelAndView = new ModelAndView("ADMIN_managermanage","admin_list",admin_list);
				}
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
				System.out.println("error in backstage setUserIlleagal in controller!");//for debug	
			}
			break;
		}
		
		return modelAndView;	

	}

	//实现后台管理界面的逻辑判断以及跳转
	@RequestMapping("/turnToUserManage")
	public ModelAndView turnToUserManage(HttpServletRequest request)
	{
		ModelAndView modelAndView = null;
		@SuppressWarnings("unused")
		Admin admin = (Admin) request.getSession().getAttribute("admin");
		
		try {			
			int manageType = Integer.parseInt(request.getParameter("manageType"));
			switch (manageType) {
			case 1:
				List<User> user_list = userPersonalService.getAllUser();
				request.getSession().setAttribute("user_list", user_list);
				modelAndView = new ModelAndView("ADMIN_usermanage","user_list",user_list);
				break;
			case 2:
				List<Artist> artist_list = userPersonalService.getAllArtist();
				request.getSession().setAttribute("artist_list", artist_list);
				modelAndView = new ModelAndView("ADMIN_artistmanage","artist_list", artist_list);
				break;
			case 3:
				List<Admin> admin_list = adminPersonalService.getAllAdmin();
				request.getSession().setAttribute("admin_list", admin_list);
				modelAndView = new ModelAndView("ADMIN_managermanage","admin_list", admin_list);
				break;
					
			}				
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println("error in backstage turnToUserManage in controller!");//for debug
		}

		return modelAndView;	
	}

}
