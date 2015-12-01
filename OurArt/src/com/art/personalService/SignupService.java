package com.art.personalService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.art.dao.UserDao;
import com.art.entity.User;

@Service
@RequestMapping("/User")
public class SignupService {
	
	@Resource
	private UserDao userDao;
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ModelAndView saveUser1(HttpServletRequest request,ModelMap model)
	{
		//int id = 0;
		String realName = request.getParameter("realName");
		String nickName = request.getParameter("nickName");
		String gender = request.getParameter("gender");
		String password= request.getParameter("password");
		String tel = request.getParameter("tel");
		String email = request.getParameter("email");
		String str = request.getParameter("birthday");
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
		Date birthday=null;
		try {			
			birthday = sf.parse(str);
		} catch (ParseException e) {
			System.out.println("输入日期类型不符合规�?");
			return new ModelAndView("redirect:/user/add.html");
		}//还需要增加对邮箱电话等的正则表达式的判断
		
		User user = new User();
		user.setRealName(realName);
		user.setNickName(nickName);
		user.setGender(gender);
		user.setPassword(password);
		user.setTel(tel);
		user.setEmail(email);
		user.setBirthday(birthday);
		
		userDao.addUser(user);
		return new ModelAndView("redirect:/user.html");//此处的跳转页面待修改
	}
	

}
