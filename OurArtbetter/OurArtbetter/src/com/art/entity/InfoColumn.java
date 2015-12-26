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
	
	@Column(name="content",nullable=false)
	private String content;
	
	@Column(name="price",nullable=false)
	private String price; //everyday price
	
	@OneToMany(targetEntity=DateAndPos.class,cascade = {CascadeType.ALL},mappedBy="infoColumn",fetch=FetchType.EAGER)
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
    
    public String getContent() 
	{
        return this.content;
    }
    public void setContent(String content) 
    {
        this.content = content;
    }
    
    public String getPrice()
	{
        return this.price;
    }
    public void setPrice(String price) 
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
