package com.art.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.art.util.RequestUtil;

/**
 * ��½������
 * 
 * **/

public class LoginInterceptor  implements HandlerInterceptor{

	
	/** 
     * ��ҵ��������������֮ǰ������ 
     * ����false 
     *     �ӵ�ǰ�����������ִ��������������afterCompletion(),���˳���������
     *     
     * ����true 
     *    ִ����һ��������,ֱ�����е���������ִ����� 
     *    ��ִ�б����ص�Controller 
     *    Ȼ�������������, 
     *    �����һ�����������ִ�����е�postHandle() 
     *    �����ٴ����һ�����������ִ�����е�afterCompletion() 
     */  
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		
		if ("GET".equalsIgnoreCase(request.getMethod())) {  
            RequestUtil.saveRequest();  
        }  
           
        //String requestUri = request.getRequestURI();  
        //String contextPath = request.getContextPath();  
        //String url = requestUri.substring(contextPath.length());  
        
        String username =  (String)request.getSession().getAttribute("user");   
        if(username == null){  
            request.getRequestDispatcher("/WEB-INF/JSP/login.jsp").forward(request, response);    //��
            return false;  
        }else  
            return true;  
	}

	
	/** 
     * ��DispatcherServlet��ȫ����������󱻵���,������������Դ��  
     *  
     * �����������׳��쳣ʱ,��ӵ�ǰ���������ִ�����е���������afterCompletion() 
     */
	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	
	 /**
     * ��ҵ��������������ִ����ɺ�,�����ͼ֮ǰִ�еĶ���   
     * ����modelAndView�м�����ݣ����統ǰʱ��
     */
	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

}
