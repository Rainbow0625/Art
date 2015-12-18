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
@Table(name="editor")
public class Editor implements java.io.Serializable
{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY) //Increase auto
	@Column(name="id",nullable=false)
	private int id;
	
	@Column(name="name",nullable=false)
	private String name;
	
	@Column(name="password",nullable=false)
	private String password;
	
	
	//µç»°£¡£¡£¡£¡£¡£¡£¡£¡£¡£¡£¡£¡£¡£¡£¡£¡£¡£¡
	
	@OneToMany(targetEntity=Information.class,cascade = {CascadeType.ALL},mappedBy="editor",fetch=FetchType.LAZY)
	private List<Information> informationListToEdit;
	
	public Editor() {}
	
	public int getId() 
	{
        return this.id;
    }
    public void setId(int id) 
    {
        this.id = id;
    }
    
    public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	 public String getPassword() 
	   	{
	           return this.password;
	   	}  
	    public void setPassword(String password) 
		{
	    	this.password = password;
		}
	
	public List<Information> getInformation() {
		return informationListToEdit;
	}
	public void setInformation(List<Information> informationListToEdit) {
		this.informationListToEdit=informationListToEdit;
	}
	
	
	

}
