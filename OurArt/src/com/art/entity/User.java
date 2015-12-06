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
public class User implements java.io.Serializable
{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY) //Increase auto
	@Column(name="id",nullable=false)
	private int id;
	
	@Column(name="nickName",nullable=true)
	private String nickName;
	
	@Column(name="password",nullable=false)
	private String password;	
	
	@Column(name="gender",nullable=true)
	private String gender;
	
	@Column(name="birthday",nullable=true)
	private Date birthday;
	
	@Column(name="tel",nullable=false)
	private String tel;
	
	@Column(name="email",nullable=true)
	private String email;
	
	@Column(name="userType",nullable=false)
	private String userType;
		
	
	public User(){}
	public User(String tel,String password) //two parameters must be filled while registering
	{
		setTel(tel);
		setPassword(password);
	}

	
	public int getId() 
	{
        return this.id;
    }
    public void setId(int id) 
    {
        this.id = id;
    }
    
    public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
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

    public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
}
