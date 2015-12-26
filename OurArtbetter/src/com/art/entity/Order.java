package com.art.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

@Table(name="orders")
@Entity
@DynamicInsert
@DynamicUpdate
public class Order implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Id
	private Integer oid;
	private Double total;
	private Date ordertime;
	private Integer state;// 1:未付款   2:订单已经付款   3:已经发货   4:订单结束
	private String nickName;
	private String tel;
	private String address;
	
	// 用户的外键:对象
	@JoinColumn(name="id")
	@ManyToOne(fetch=FetchType.LAZY)
	private User user;
	
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

	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	/*
	public Artist getArtist() {
		return artist;
	}
	public void setArtist(Artist artist) {
		this.artist = artist;
	}
	*/
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
		return artist;
	}
	public void setArtsit(Artist artsit) {
		this.artist = artsit;
	}
	*/
	public Set<Payment> getPayments() {
		return payments;
	}
	public void setPayments(Set<Payment> payments) {
		this.payments = payments;
	}
	
}
