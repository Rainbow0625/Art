package com.art.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
	@Column(name="id",nullable=false)
	private int id;
	
	private Date date; //NEED TO create an index on the column in the DateBase
	
	@ManyToOne( targetEntity=InfoColumn.class,cascade={CascadeType.ALL},fetch=FetchType.LAZY ,optional=false)
	@JoinColumn(name="infoColumnId")//����һ����Ϊ�����
	private InfoColumn infoColumn;
	
	@ManyToOne( targetEntity=Information.class,cascade={CascadeType.ALL},fetch=FetchType.LAZY ,optional=false)
	@JoinColumn(name="informationId")//����һ����Ϊ�����
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
	
	public Information getInfomation ()
	{
		return information;
	}
	public void setInformation ( Information information )
	{
		this.information = information;
	}
	
	
	
}
