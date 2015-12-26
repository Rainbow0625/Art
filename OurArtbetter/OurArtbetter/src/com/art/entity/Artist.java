package com.art.entity;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

@Entity
@DynamicInsert
@DynamicUpdate
@DiscriminatorValue("artist")

public class Artist extends User
{
	public Artist(Integer uid, String password) {
		super(uid, password);
		// TODO Auto-generated constructor stub
	}
	private static final long serialVersionUID = 1L;
	
	@Column(name="artistType",nullable=false)
	@Enumerated(EnumType.STRING)
	private ARTISTTYPE artistType;
	
	@OneToMany(fetch=FetchType.EAGER,mappedBy="artist")
	private Set<Order> order = new HashSet<Order>();
	
	@OneToMany(fetch=FetchType.EAGER,mappedBy="artist")
	private Set<Artwork> artwork = new HashSet<Artwork>();
	
	@Column(name="photo",nullable=false)
	private  String photo;
	
	@Column(name="realName",nullable=false)
	private String realName;
	
	@Column(name="introduction",nullable=false)
	private String introduction;
	
	
	//public Artist(){}
	
	public String getRealName() 
   	{
           return this.realName;
   	}  
    public void setRealName(String realName) 
	{
    	this.realName = realName;
	}

	public ARTISTTYPE getArtistType() 
   	{
           return this.artistType;
   	}  
    public void setArtistType(ARTISTTYPE artistType) 
	{
    	this.artistType = artistType;
	}
    
    public String getPhoto() 
   	{
           return this.photo;
   	}  
    public void setPhoto(String photo) 
	{
    	this.photo = photo;
	}
    
    public String getIntroduction() 
   	{
           return this.introduction;
   	}  
    public void setIntroduction(String introduction) 
	{
    	this.introduction = introduction;
	}	
}
