package com.art.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

@Entity
@DynamicInsert
@DynamicUpdate
@Table(name="chiefEditor")
@NamedQueries(
		{ 
			@NamedQuery(name= "@GetAllChiefEditor",query = "from ChiefEditor"),
			@NamedQuery(name = "@FindChiefEditorByName", query = "from ChiefEditor ce where ce.name=?0"),
			@NamedQuery(name = "@FindChiefEditorByNameAndPassword", query = "from ChiefEditor ce where ce.name=?0 and ce.password=?1")
		})
public class ChiefEditor implements java.io.Serializable
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
	
	@OneToMany(targetEntity=Information.class,cascade = {CascadeType.ALL},mappedBy="chiefEditor",fetch=FetchType.LAZY)
	private List<Information> informationListToCheck;
	
	public ChiefEditor() {}
	
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
		return informationListToCheck;
	}
	public void setInformation(List<Information> informationListToCheck) {
		this.informationListToCheck=informationListToCheck;
	}
}
