package com.art.backstageService;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.art.entity.Order;
import com.art.entity.OrderItem;

@Transactional
@Service
public interface AdminOrderService  {
	//查询某个具体的订单
	public Order findOrder(Integer oid);
	
	//保存和更新订单
	public void saveOrUpdateOrder(Order order);
	
    //查询所有订单
	public List<Order> listOrder();
	
	//查询总共有多少页的订单
	public Long countOrder();
	
	//根绝订单号查询orderItem
	public List<OrderItem> findAllItemByOrderId(int id);
}
