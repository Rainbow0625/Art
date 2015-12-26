package com.art.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
@Table(name="dateAndPos")
public class DateAndPos implements java.io.Serializable
{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY) //Increase auto
	@Column(name="id",nullable=false)
	private int id;
	
	@Column(name="date")
	private Date date; //NEED TO create an index on the column in the DateBase

	@Column(name="days")
	private int days; 
	
	
	@ManyToOne( targetEntity=InfoColumn.class,cascade={CascadeType.ALL},fetch=FetchType.LAZY ,optional=false)
	@JoinColumn(name="infoColumnId")//加入一列作为外键列
	private InfoColumn infoColumn;
	
	@ManyToOne( targetEntity=Information.class,cascade={CascadeType.ALL},fetch=FetchType.LAZY ,optional=false)
	@JoinColumn(name="informationId")//加入一列作为外键列
	private Information information;
	
	public int getId() 
	{
        return this.id;
    }
	public void setId(int id) 
	{
        this.id=id;
    }
	
	public Date getDate ()
	{
		return date;
	}
	public void setDate ( java.util.Date date )
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
	
	public void setInformation ( Information information )
	{
		this.information = information;
	}
	public int getDays() {
		return days;
	}
	public void setDays(int days) {
		this.days = days;
	}
	public Information getInformation() {
		return information;
	}
	
	
	
}
