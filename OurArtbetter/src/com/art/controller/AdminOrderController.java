package com.art.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.art.backstageService.AdminOrderService;
import com.art.entity.Order;
import com.art.entity.OrderItem;
@Controller
public class AdminOrderController {

	@Autowired
	private AdminOrderService adminOrderService;
	
	
	public AdminOrderController(){}

	@RequestMapping(value="/findOrderItem/{oid}/{time}")
	public String findOrderItem(@RequestParam Integer oid,Map<String,Object> map,
			HttpServletResponse response) throws IOException{
		Order order = adminOrderService.findOrder(oid);
		Set<OrderItem> orderItem = order.getOrderItems();
		map.put("orderItem",orderItem);
		return "admin/order/orderItem";
	}
	//发货操作
	@RequestMapping(value="/updateStateOrder")
	public ModelAndView updateStateOrder(@RequestParam Integer oid){
		ModelAndView modelAndView = new ModelAndView("redirect:/listOrder/");
		Order order = adminOrderService.findOrder(oid);
		order.setState(3);
		adminOrderService.saveOrUpdateOrder(order);
		return modelAndView;
	}
	
	//查询订单
	@RequestMapping(value="/listOrder")
	public ModelAndView listOrder(){
		ModelAndView modelAndView = new ModelAndView("admin/order/list");
		//分页查找所有的订单
	    List<Order> orders = adminOrderService.listOrder();
		modelAndView.addObject("orders", orders);
		//保存当前的页数
		//查询总共有多少页的数据
		Long count = adminOrderService.countOrder();
		modelAndView.addObject("count", count);
		return modelAndView;
	}
}
