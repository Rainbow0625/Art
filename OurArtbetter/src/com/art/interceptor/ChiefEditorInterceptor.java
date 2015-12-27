package com.art.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.art.entity.ChiefEditor;
import com.art.util.RequestUtil;

/**
 * 主编权限拦截器
 * 
 * **/

public class ChiefEditorInterceptor  implements HandlerInterceptor
{
	
	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		if ("GET".equalsIgnoreCase(request.getMethod())) {  
            RequestUtil.saveRequest();  
        } 
		
		ChiefEditor chiefEditor =  (ChiefEditor)request.getSession().getAttribute("chiefEditor");   
	        if(chiefEditor == null)
	        {  
				//再在no中返回到刚才的welcome	
	            request.getRequestDispatcher("/WEB-INF/JSP/no.jsp").forward(request, response);    
	            return false;  
	        }else  
	            return true;  

	}

}
