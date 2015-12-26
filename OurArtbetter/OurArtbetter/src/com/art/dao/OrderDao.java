package com.art.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.art.entity.Order;

//管理订单的repository
public interface OrderDao{

	//Order findByOid(Integer oid);
	//根据用户分页查询订单
	//Page<Order> findByUserUid(Integer uid,Pageable pageable);
	//根据用户查询订单 的数量
	@Query(value="SELECT COUNT(*) FROM orders o WHERE uid = ?1",nativeQuery=true)
	int findCountByUid(int uid);
	Order findOne(int orderId);
	void save(Order order);
	int findCountByorderId(int orderId);
	Order findByOid(int orderId);
	void deleteAll();
	void delete(Order order);
	void delete(int orderId);
	Order findAll(int orderId);
	List<Order> findAll();
	Long count();
	List<Order> findByUserUid(int uid);
	
}
