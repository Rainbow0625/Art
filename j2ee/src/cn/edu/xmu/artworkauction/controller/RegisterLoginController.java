/**
 * 
 */
package cn.edu.xmu.artworkauction.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cn.edu.xmu.artworkauction.entity.Admin;
import cn.edu.xmu.artworkauction.entity.Artist;
import cn.edu.xmu.artworkauction.entity.ChiefEditor;
import cn.edu.xmu.artworkauction.entity.Editor;
import cn.edu.xmu.artworkauction.entity.ServiceAdmin;
import cn.edu.xmu.artworkauction.entity.User;
import cn.edu.xmu.artworkauction.entity.UserAdmin;
import cn.edu.xmu.artworkauction.service.SecureService;

/**
 * @author Administrator
 *
 */
@Controller
public class RegisterLoginController {

	@Resource
	private SecureService secureService;
	
	private User user;
	@RequestMapping("/userRegister")
	public ModelAndView userRegister(HttpServletRequest request,Model model){
		String email=request.getParameter("email");
		String userName=request.getParameter("userName");
		String phoneNumber=request.getParameter("phoneNumber");
		String password=request.getParameter("password");
		ModelAndView modelAndView=new ModelAndView("user");
		user=secureService.userRegister(email, userName, phoneNumber, password);
		model.addAttribute("user", user);
		request.getSession().setAttribute("user", user);
		return modelAndView;
	}
	
	@RequestMapping ("/userLoginByUserName")
	public ModelAndView userLoginByUserName(HttpServletRequest request)
	{
		String userName=request.getParameter("userName");
		String password=request.getParameter("password");
		User user=secureService.userLoginByUserName(userName, password);
		ModelAndView modelAndView;
		if(user==null)
		{
			modelAndView =new ModelAndView("index");
			return modelAndView;
		}
		else 
			modelAndView =new ModelAndView(user.getUserType());
		request.getSession().setAttribute("user", user);
		return modelAndView;
	}
	
	@RequestMapping ("/adminLogin")
	public ModelAndView adminLogin(HttpServletRequest request) {
		String adminName=request.getParameter("adminName");
		String password=request.getParameter("password");

		Admin admin=secureService.adminLogin(adminName, password);
		ModelAndView modelAndView ;
		if(admin==null) {
			modelAndView=new ModelAndView("adminLogin");
		}
		else
			modelAndView=new ModelAndView(admin.getAdminType());
		request.getSession().setAttribute("admin", admin);
		return modelAndView;
	}
}
