package com.art.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

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
		String tel = request.getParameter("tel");
		String confirmPassword = request.getParameter("confirmPassword");
		String newPassword = request.getParameter("newPassword");
		System.out.print(tel+" "+confirmPassword+" "+newPassword);
		User user=userPersonalService.updatePassword(tel, confirmPassword, newPassword);
		//ModelAndView modelAndView;
		if (user==null) {  

			return new ModelAndView("Fail");  
		}  
		//ModelAndView modelAndView=new ModelAndView("index","user",user);
		request.getSession().setAttribute("user",user);
		//MessageDigestPasswordEncoder encoder = new MessageDigestPasswordEncoder("md5");  
		return new ModelAndView("Success","user",user);
	}

	@RequestMapping("/completePersonalInfo")//可以将手机号和密码的输入框设为已经只读
	public ModelAndView completePersonalInfo(HttpServletRequest request)throws Exception
	{
		String nickName = request.getParameter("nickName");
		String gender = request.getParameter("gender");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date birthday=null;
		try {
			birthday = (Date) sdf.parse(request.getParameter("birthday"));
		} catch (ParseException e) {
			System.out.println("输入日期类型不符合规范");			
		}
		String email = request.getParameter("email");
		String tel = request.getParameter("tel");
		String password = request.getParameter("password");
		User user = userPersonalService.fillUserInfo(nickName, tel, password, gender, birthday, email);
		//System.out.print(nickName+" "+gender+" "+birthday+" "+email+" "+tel+" "+password);
		return new ModelAndView("index","user",user);//return to personalInfo page
	}

	@RequestMapping("artistApply")
	public ModelAndView artistApply(HttpServletRequest request)throws Exception
	{
		return null;

	}

	@RequestMapping("/getAllUser")
	public ModelAndView getAllUser()
	{
		List<User> user_list = userPersonalService.getAllUser();
		return new ModelAndView("userList","user_list",user_list);	
	}
}
