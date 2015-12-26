package com.art.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * 订单实体
 *CREATE TABLE `orders` (
  `oid` int(11) NOT NULL AUTO_INCREMENT,
  `total` double DEFAULT NULL,
  `ordertime` datetime DEFAULT NULL,
  `state` int(11) DEFAULT NULL,
  `name` varchar(20) DEFAULT NULL,
  `phone` varchar(20) DEFAULT NULL,
  `addr` varchar(50) DEFAULT NULL,
  `uid` int(11) DEFAULT NULL,
  PRIMARY KEY (`oid`),
  KEY `FKC3DF62E5AA3D9C7` (`uid`),
  CONSTRAINT `FKC3DF62E5AA3D9C7` FOREIGN KEY (`uid`) REFERENCES `user` (`uid`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
 */
@Table(name="orders")
@Entity
public class Order {
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Id
	private Integer oid;
	private Double total;
	private Date ordertime;
	private Integer state;// 1:未付款   2:订单已经付款   3:已经发货   4:订单结束
	private String name;
	private String phone;
	private String addr;
	// 用户的外键:对象
	@JoinColumn(name="id")
	@ManyToOne(fetch=FetchType.LAZY)
	private User user;
	//艺术家的外键：对象'
	@JoinColumn(name="artistid")
	@ManyToOne(targetEntity=Artist.class,cascade={CascadeType.ALL},fetch=FetchType.EAGER )
	private Artist artist;
	// 配置订单项的集合
	//mappedBy="order"指明order为双向关系维护端是由哪个属性来维护
	//cascade级联操作级别,refresh:级联刷新,remove级联删除
	@OneToMany(cascade={CascadeType.ALL},fetch=FetchType.EAGER,mappedBy="order")
	private Set<OrderItem> orderItems = new HashSet<OrderItem>();
	
	@OneToMany(cascade={CascadeType.ALL},fetch=FetchType.EAGER,mappedBy="order")
	private Set<Payment> payments = new HashSet<Payment>();
	public Integer getOid() {
		return oid;
	}
	public void setOid(Integer oid) {
		this.oid = oid;
	}
	public Double getTotal() {
		return total;
	}
	public void setTotal(Double total) {
		this.total = total;
	}
	public Date getOrdertime() {
		return ordertime;
	}
	public void setOrdertime(Date ordertime) {
		this.ordertime = ordertime;
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Set<OrderItem> getOrderItems() {
		return orderItems;
	}
	public void setOrderItems(Set<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}
	/*
	public Artist getArtsit() {
		return artsit;
	}
	public void setArtsit(Artist artsit) {
		this.artsit = artsit;
	}
	*/
	public Set<Payment> getPayments() {
		return payments;
	}
	public void setPayments(Set<Payment> payments) {
		this.payments = payments;
	}
	@Override
	public String toString() {
		return "Order [oid=" + oid + ", total=" + total + ", ordertime=" + ordertime + ", state=" + state + ", name="
				+ name + ", phone=" + phone + ", addr=" + addr + ", user=" + user + ", orderItems=" + orderItems + "]";
	}
	
}
