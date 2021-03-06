package com.art.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * 订单项的实体
 */
@Table(name="orderitem")
@Entity
public class OrderItem implements java.io.Serializable{
	private static final long serialVersionUID = 1L;
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Id
	private Integer itemid;
	//数量
	private Integer count;
	//小计
	private Double subtotal;
	
	// 商品外键:对象
	@JoinColumn(name="artworkId")
	@ManyToOne(fetch=FetchType.LAZY)
	private Artwork product;
	// 订单外键:对象
	@JoinColumn(name="oid")
	@ManyToOne(cascade={CascadeType.ALL})
	private Order order;
	
	public Integer getItemid() {
		return itemid;
	}
	public void setItemid(Integer itemid) {
		this.itemid = itemid;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	public Double getSubtotal() {
		return subtotal;
	}
	public void setSubtotal(Double subtotal) {
		this.subtotal = subtotal;
	}
	public Artwork getProduct() {
		return product;
	}
	public void setProduct(Artwork product) {
		this.product = product;
	}
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}

}
