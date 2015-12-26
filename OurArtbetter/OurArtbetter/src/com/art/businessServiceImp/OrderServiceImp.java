package com.art.businessServiceImp;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.art.businessService.OrderService;
import com.art.dao.OrderDao;
import com.art.entity.Order;

@Transactional
@Service
public class OrderServiceImp implements OrderService{

	@Resource
	private OrderDao orderRepository;
	
	//修改订单
	@Override
	public void updateOrder(Order order){
		orderRepository.save(order);
	}
	//根据订单的编号查询订单
	@Override
	public Order findByOid(Integer oid){
		return orderRepository.findByOid(oid);
	}
	
	//保存订单
	@Override
	public void saveOrder(Order order){
     	orderRepository.save(order);
	}
	
	//根据用户名查询订单
	@Override
	public List<Order> findOrderByUid(int uid) {
		//按照订单的时间进行排序
		Sort sort = new Sort(Sort.Direction.DESC,"ordertime");
		//默认每页显示8条的数据
		return orderRepository.findByUserUid(uid);
	}
	
	//根据用户查询订单的页数
	@Override
	public Integer findCountByUid(Integer uid){
		Integer count = orderRepository.findCountByUid(uid);
		return (count % 4 == 0 ? (count / 4) : (count / 4 + 1));
	}
}
