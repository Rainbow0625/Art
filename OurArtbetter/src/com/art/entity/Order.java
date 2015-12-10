package com.art.entity;

import java.util.Date;

import javax.persistence.*;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
/*
@Entity
@DynamicInsert
@DynamicUpdate
@Table(name="order")
@Inheritance(strategy=InheritanceType.JOINED) */
public class Order implements java.io.Serializable
{/*
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY) //Increase auto
	@Column(name="orderId",nullable=false)
	private int orderId;  //auto +1 
	
	//1为成品、2为订制品、3为拍卖品
	@Column(name="orderType",nullable=false)
	private int orderType;
	
	private int artworkId;
	private int artistId;
	private int userId;
	private double total;  // total money need to pay
	private Date OrderDate;

	public Order(){}
	
	
	public int getorderId() 
	{
        return this.orderId;
    }
    public void setorderId(int orderId) 
    {
        this.orderId = orderId;
    }
    
    public int getArtworkId() 
	{
        return this.artworkId;
    }
    public void setArtworkId(int artworkId) 
    {
        this.artworkId = artworkId;
    }
    
    public int getArtistId() 
	{
        return this.artistId;
    }
    public void setArtistId(int artistId) 
    {
        this.artistId = artistId;
    }
    
    
    public int getUserId() 
	{
        return this.userId;
    }
    public void setUserIdId(int userId) 
    {
        this.userId = userId;
    }
    
    
    public double getTotal() 
	{
        return this.total;
    }
    public void setTotal(double total) 
    {
        this.total = total;
    }
	*/
	
}
