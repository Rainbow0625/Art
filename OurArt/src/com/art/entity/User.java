package com.art.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user")
public class User 
{
	@Id
	@GeneratedValue(strategy =GenerationType.AUTO) //Increase auto
	@Column(name="id",nullable=false)
	private int id;
	
	@Column(name="realName",nullable=false)
	private String realName;
	
	@Column(name="nickName",nullable=false)
	private String nickName;
	
	@Column(name="gender",nullable=false)
	private String gender;
	
	@Column(name="birthday",nullable=false)
	private Date birthday;
	
	@Column(name="tel",nullable=false)
	private String tel;
	
	@Column(name="email",nullable=false)
	private String email;
	
	@Column(name="password",nullable=false)
	private String password;
	
	public int getId() 
	{
        return this.id;
    }
    public void setId(int id) 
    {
        this.id = id;
    }
    
    public String getRealName() 
	{
        return this.realName;
    }
    public void setRealName(String realName) 
    {
        this.realName = realName;
    }
    
    public String getNickName() 
	{
        return this.nickName;
    }
    public void setNickName(String nickName) 
    {
        this.nickName = nickName;
    }
    
    public String getGender() 
   	{
           return this.gender;
   	}  
    public void setGender(String gender) 
	{
    	this.gender = gender;
	}
    
    public String getTel() 
   	{
           return this.tel;
   	}  
    public void setTel(String tel) 
	{
    	this.tel = tel;
	}
    
    public String getEmail() 
   	{
           return this.email;
   	}  
    public void setEmail(String email) 
	{
    	this.email = email;
	}
    
    public String getPassword() 
   	{
           return this.password;
   	}  
    public void setPassword(String password) 
	{
    	this.password = password;
	}
    
    public Date getBirthday() 
   	{
           return this.birthday;
   	}  
    public void setBirthday(Date birthday) 
	{
    	this.birthday = birthday;
	}

}
