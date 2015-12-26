package com.art.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

@Entity
@DynamicInsert
@DynamicUpdate
@Table(name="payment")
public class Payment implements java.io.Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -8683366258711513310L;

	@Id
	@GeneratedValue(strategy =GenerationType.AUTO)
	@Column(name="Id",nullable=false)
	private int id;
	
	@JoinColumn(name="orderid")
	@ManyToOne
	private Order order;
	
	private int amount;
	
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}
	@Override
	public String toString() {
		return "Payment [id=" + id + ", order=" + order + ", amount=" + amount + "]";
	}
	
}
