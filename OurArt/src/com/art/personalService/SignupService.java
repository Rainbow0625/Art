package com.art.personalService;


import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import com.art.dao.UserDao;
import com.art.entity.User;

@Service
@RequestMapping("/User")
public class SignupService {
	
	@Resource
	private UserDao userDao;
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public void addUser(User user)
	{
		userDao.addUser(user);
	}
	

}
