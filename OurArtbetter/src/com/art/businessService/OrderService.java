package com.art.businessService;

import java.util.List;
import com.art.entity.Order;

public interface OrderService {
	
	//修改订单
	public void updateOrder(Order order);
	//根据订单的编号查询订单
	public Order findByOid(Integer oid);
	//保存订单
	public void saveOrder(Order order);
	
	//根据用户名查询订单
	//public Page<Order> findOrderByUid(int uid,Integer page);
	//根据用户查询订单的页数
	public Integer findCountByUid(Integer uid);
	public List<Order> findOrderByUid(int id);
}
