package com.art.dao;

import java.util.List;

import com.art.entity.Order;
import com.art.entity.OrderItem;

//管理订单的repository
public interface OrderDao{

	//Order findByOid(Integer oid);
	//根据用户分页查询订单
	//Page<Order> findByUserUid(Integer uid,Pageable pageable);
	//根据用户查询订单 的数量
	public int findCountByUid(int uid);
	public Order findOne(int orderId);
	public void save(Order order);
	public int findCountByorderId(int orderId);
	public Order findByOid(int orderId);
	public void deleteAll();
	public void delete(Order order);
	public void delete(int orderId);
	public Order findAll(int orderId);
	public List<Order> findAll();
	public Long count();
	public List<Order> findByUserUid(int uid);
	public Order findOrder(int state);
	
	public List<OrderItem> findAllItemByOrderId(int id);
	
}
