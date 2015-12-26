package com.art.entity;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

@Entity
@DynamicInsert
@DynamicUpdate
@Table(name="dateAndPos")
public class DateAndPos implements java.io.Serializable
{
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="id",nullable=false)
	private int id;
	
	private Date date; //NEED TO create an index on the column in the DateBase
	
	@ManyToOne( targetEntity=InfoColumn.class,cascade={CascadeType.ALL},fetch=FetchType.EAGER ,optional=false)
	@JoinColumn(name="infoColumnId")//加入一列作为外键列
	private InfoColumn infoColumn;
	
	@ManyToOne( targetEntity=Infomation.class,cascade={CascadeType.ALL},fetch=FetchType.EAGER ,optional=false)
	@JoinColumn(name="infomationId")//加入一列作为外键列
	private Infomation infomation;
	
	public int getId() 
	{
        return this.id;
    }
	
	public Date getDate ()
	{
		return date;
	}
	public void setDate ( Date date )
	{
		this.date = date;
	}
	
	public InfoColumn getInfoColumn ()
	{
		return infoColumn;
	}
	public void setInfoColumn ( InfoColumn infoColumn )
	{
		this.infoColumn = infoColumn;
	}
	
	public Infomation getInfomation ()
	{
		return infomation;
	}
	public void setInfomation ( Infomation infomation )
	{
		this.infomation = infomation;
	}
	
	
	
}
