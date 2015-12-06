package com.art.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

@Entity
@DynamicInsert
@DynamicUpdate
@Table(name="purchaseOrder")

public class PurchaseOrder extends Order implements java.io.Serializable
{
	private static final long serialVersionUID = 1L;
	
	
}
