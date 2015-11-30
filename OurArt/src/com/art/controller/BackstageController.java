package com.art.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.art.backstageService.ManageUserService;
import com.art.dao.UserDao;
import com.art.entity.User;

public class BackstageController 
{
	@Resource
	private ManageUserService manageUserService;
	
	/*
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ModelAndView saveUser1(HttpServletRequest request,
			ModelMap model){
		int age = 0;
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String sex = request.getParameter("sex");
		String str = request.getParameter("birthday");
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
		Date birthday=null;
		try {
			
			birthday = sf.parse(str);
		} catch (ParseException e) {
			System.out.println("鏉堟挸鍙嗛弮銉︽埂缁鐎锋稉宥囶儊閸氬牐顫夐懠锟�");
			return new ModelAndView("redirect:/user/add.html");
		}catch(NumberFormatException e){
			age = Integer.valueOf(request.getParameter("age"));
			
		}
		User user = new User();
		user.setAge(age);
		user.setBirthday(birthday);
		user.setPassword(password);
		user.setSex(sex);
		user.setUsername(username);
		userDao.save(user);
		return new ModelAndView("redirect:/user.html");
	}
	*/
	
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView listAllUser()
	{
		Map<String,Object> model = new HashMap<String,Object>();
		model.put("user_list", manageUserService.getAllUser());
		return new ModelAndView("userList",model);
	}
	
	/*
	@RequestMapping(value="/add",method=RequestMethod.GET)
	public ModelAndView addUser(@ModelAttribute("user") User user,
			BindingResult result){
		return new ModelAndView("adduser");
	}
	
	@RequestMapping(value="/del",method=RequestMethod.GET)
	public ModelAndView delUser(@ModelAttribute("user") User user){
		userDao.deleteById(user.getId());		
		return new ModelAndView("redirect:/user.html");
	}
	*/

}
