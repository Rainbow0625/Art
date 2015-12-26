package com.art.backstageService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.art.dao.OrderDao;
import com.art.entity.Order;

@Transactional
@Service
public class AdminOrderService {

	@Autowired
	private OrderDao orderRepository;
	
	public AdminOrderService(){}
	
	//查询某个具体的订单
	public Order findOrder(Integer oid){
		return orderRepository.findByOid(oid);
	}
	//保存和更新订单
	public void saveOrUpdateOrder(Order order){
		orderRepository.save(order);
	}
	//分页查询所有的订单
	
	public List<Order> listOrder(){
		//根据订单的时间进行升序排列
		Sort sort = new Sort(Sort.Direction.ASC,"ordertime");
		List<Order> orders = orderRepository.findAll();
		return orders;
	}
	
	//查询总共有多少页的订单
	public Long countOrder() {
		Long count = orderRepository.count();
		return (count % 10 == 0 ? (count / 10) :( count / 10 + 1));
	}
}
