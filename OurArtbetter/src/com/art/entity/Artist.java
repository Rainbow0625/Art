package com.art.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

@Entity
@DynamicInsert
@DynamicUpdate
@DiscriminatorValue(value="artist")
public class Artist extends User
{
	private static final long serialVersionUID = 1L;
	
	@Column(name="artistType")
	@Enumerated(EnumType.STRING)
	private ARTISTTYPE artistType;
	
	@Column(name="photo")
	private  String photo;
	
	@Column(name="realName")
	private String realName;
	
	@Column(name="introduction")
	private String introduction;
	
	@Column(name="audit_status")
	@Enumerated(EnumType.STRING)
	private AUDIT_STATUS audit_status;
	
	public Artist(String realName,String tel, String password,String gender,Date birthday,String email,String photo,String introduction)
	{
		super(null,tel,password,gender,birthday,email);
		this.setRealName(realName);
		this.setAudit_status(AUDIT_STATUS.unChecked);
		this.setIntroduction(introduction);
		this.setPhoto(photo);
	}
	
	
	
	public AUDIT_STATUS getAudit_status() {
		return audit_status;
	}
	public void setAudit_status(AUDIT_STATUS audit_status) {
		this.audit_status = audit_status;
	}



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
