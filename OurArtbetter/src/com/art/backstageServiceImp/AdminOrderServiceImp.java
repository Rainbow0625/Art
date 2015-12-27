package com.art.backstageServiceImp;

import java.util.List;

import javax.annotation.Resource;


import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.art.backstageService.AdminOrderService;
import com.art.dao.OrderDao;
import com.art.entity.Order;
import com.art.entity.OrderItem;
@Service
public class AdminOrderServiceImp implements AdminOrderService {
	@Resource
	private OrderDao orderDao;
	
	public AdminOrderServiceImp(){}
	
	//查询某个具体的订单
	public Order findOrder(Integer oid){
		return orderDao.findByOid(oid);
	}
	
	//保存和更新订单
	public void saveOrUpdateOrder(Order order){
		orderDao.save(order);
	}

	public List<Order> listOrder(){
		//根据订单的时间进行升序排列
		Sort sort = new Sort(Sort.Direction.ASC,"ordertime");
		List<Order> orders = orderDao.findAll();
		return orders;
	}
	
	//查询总共有多少页的订单
	public Long countOrder() {
		Long count = orderDao.count();
		return (count % 10 == 0 ? (count / 10) :( count / 10 + 1));
	}
	
	public List<OrderItem> findAllItemByOrderId(int id) {
		return orderDao.findAllItemByOrderId(id);
	}

}
