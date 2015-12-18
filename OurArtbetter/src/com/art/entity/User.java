package com.art.entity;

import java.util.Date;

import javax.persistence.*;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

@Entity
@DynamicInsert
@DynamicUpdate
@DiscriminatorColumn(name="UserType")
@DiscriminatorValue(value="user")
@Table(name="user")
@NamedQueries(
		{ 
			@NamedQuery(name= "@GetAllUser",query = "from User"),
			@NamedQuery(name = "@FindUserByTel", query = "from User u where u.tel=?0"),
			@NamedQuery(name = "@FindUserByEmail", query = "from User u where u.email=?0"),
			@NamedQuery(name = "@FindUserByTelAndPassword", query = "from User u where u.tel=?0 and u.password=?1"),
			@NamedQuery(name = "@FindUserByEmailAndPassword",query = "from User u where u.email=?0 and u.password=?1")
		})
public class User implements java.io.Serializable
{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY) //Increase auto
	@Column(name="id",nullable=false)
	protected int id;
	
	@Column(name="nickName")
	protected String nickName;
	
	@Column(name="password")
	protected String password;	
	
	@Column(name="gender")
	protected String gender;
	
	@Column(name="birthday")
	protected Date birthday;
	
	@Column(name="tel")
	protected String tel;
	
	@Column(name="email")
	protected String email;
		
	
	public User(){}
	public User(String tel,String password) //for user register
	{
		setTel(tel);
		setPassword(password);
	}
	
	public User(String nickName,String tel, String password,String gender,Date birthday,String email)//for user complete personal infomation
	{
		setNickName(nickName);
		setTel(tel);
		setPassword(password);
		setGender(gender);
		setBirthday(birthday);
		setEmail(email);
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
}
