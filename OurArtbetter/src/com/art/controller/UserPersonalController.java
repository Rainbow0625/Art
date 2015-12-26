package com.art.controller;
/*
 * @author 范溢贞 24320132202399
 */

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.art.entity.Artist;
import com.art.entity.User;
import com.art.personalService.UserPersonalService;

@Controller
public class UserPersonalController 
{
	@Resource
	private UserPersonalService userPersonalService;

	@RequestMapping("/updatePassword")
	public ModelAndView updatePassword(HttpServletRequest request) throws Exception//后期可以再加入密码加密技术
	{
		String message = null;
		ModelAndView modelAndView = null;
		
		User user = (User) request.getSession().getAttribute("user");//
		String tel = user.getTel();//
		String password =request.getParameter("password");
		try {
			if(password.equals(user.getPassword()))
			{
				String newPassword = request.getParameter("newPassword");
				String confirmPassword = request.getParameter("confirmPassword");
				if(newPassword.equals(confirmPassword))
				{
					System.out.print(tel+" "+confirmPassword+" "+newPassword);//for test
					user = userPersonalService.updatePassword(tel, password, newPassword);
					request.getSession().setAttribute("user",user);
					modelAndView = new ModelAndView("index","user",user);
				}
				else {				
					message = "两次输入的密码不一致！";	
					modelAndView = new ModelAndView("updatepwd","message",message); 
				}
			}
			else {
				message = "原密码输入错误！";
				modelAndView = new ModelAndView("updatepwd","message",message);  
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println("error in user updatepwd in controller!");//for debug
		}
		
		return modelAndView;
	}

	@RequestMapping("/completePersonalInfo")//可以将手机号和密码的输入框设为已经只读
	public ModelAndView completePersonalInfo(HttpServletRequest request)throws Exception
	{
		User user = (User) request.getSession().getAttribute("user");//
		String tel = user.getTel();//
		String password = user.getPassword();//
		
		String nickName = request.getParameter("nickName");
		String gender = request.getParameter("gender");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date birthday=null;
		try {
			birthday = (Date) sdf.parse(request.getParameter("birthday"));
			//birthday = (Date) sdf.parse("1994-10-07");
		} catch (ParseException e) {
			System.out.println("输入日期类型不符合规范");			
		}
		String email = request.getParameter("email");	
		String code = request.getParameter("code");
		String address = request.getParameter("address");
		//System.out.println(tel+" "+password);//for test

		try {
			user = userPersonalService.fillUserInfo(nickName, tel, password, gender, birthday, email,code,address);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println("error in user completePersonalInfo in controller!");//for debug
		}
		
		//System.out.print(nickName+" "+gender+" "+birthday+" "+email+" "+tel+" "+password);
		return new ModelAndView("index","user",user);//return to personalInfo page
	}

	@RequestMapping("/artistApply")
	public ModelAndView artistApply(HttpServletRequest request)
	{
		Artist artist = null;
		ModelAndView modelAndView = null;
		
		User user = (User) request.getSession().getAttribute("user");//
		String tel = user.getTel();//
		String password = user.getPassword();//
		String realName = request.getParameter("realName");
		String gender = request.getParameter("gender");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date birthday=null;
		try {
			birthday = (Date) sdf.parse(request.getParameter("birthday"));
			//birthday = (Date) sdf.parse("1994-10-07");
		} catch (ParseException e) {
			System.out.println("输入日期类型不符合规范");			
		}
		String email = request.getParameter("email");	
		String photo = request.getParameter("photo");
		String introduction = request.getParameter("introduction");
		
		try {
			artist = userPersonalService.artistApply(realName, tel, password, gender, birthday, email, photo, introduction);			
		    modelAndView = new ModelAndView("","artist",artist);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println("error in artistApply in controller!");//for debug
		}
		return modelAndView;		
	}
	

	@RequestMapping("/getAllUser")
	public ModelAndView getAllUser()
	{
		List<User> user_list = userPersonalService.getAllUser();
		return new ModelAndView("userList","user_list",user_list);	
	}
	
	@RequestMapping("/turnToUpdatePwd")
	public ModelAndView turnToUpdatePwd()
	{		
		return new ModelAndView("updatepwd");		
	}
	
	
	
}
