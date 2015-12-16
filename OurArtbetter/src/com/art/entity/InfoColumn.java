package com.art.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

@Entity
@DynamicInsert
@DynamicUpdate
@Table(name="infoColumn")
public class InfoColumn implements java.io.Serializable
{
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="id",nullable=false)
	private int id;
	
	@Column(name="contentType",nullable=false)
	private String contentType;
	
	@Column(name="price",nullable=false)
	private double price; //everyday price
	
	@OneToMany(targetEntity=DateAndPos.class,cascade = {CascadeType.ALL},mappedBy="infoColumn",fetch=FetchType.LAZY)
	private List<DateAndPos> dateAndPosS; 
	
	public InfoColumn(){}
	
	
	public int getId() 
	{
        return this.id;
    }
    public void setId(int id) 
    {
        this.id = id;
    }
    
    public String getContentType() 
	{
        return this.contentType;
    }
    public void setContentType(String content) 
    {
        this.contentType = content;
    }
    
    public double getPrice()
	{
        return this.price;
    }
    public void setPrice(double price) 
    {
        this.price = price;
    }
    
    public List<DateAndPos> getDateAndPos() {
		return dateAndPosS;
	}
	public void setDateAndPos(List<DateAndPos> dateAndPosS) {
		this.dateAndPosS=dateAndPosS;
	}
}
