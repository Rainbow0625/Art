package com.art.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.validator.constraints.Email;

@Entity
@DynamicInsert
@DynamicUpdate
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)  
@DiscriminatorValue("user")
@Table(name="user")
public class User implements java.io.Serializable
{
	private static final long serialVersionUID = 1L;
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Id
	private Integer uid;
	private String username;
	private String password;
	private String name;
	private String email;
	private String phone;
	private String addr;
	private Integer state;
	private String code;
	public Integer getUid() {
		return uid;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public User(Integer uid,String password) //two parameters must be filled while registering
	{
		setUid(uid);
		setPassword(password);
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	@Override
	public String toString() {
		return "User [uid=" + uid + ", username=" + username + ", password=" + password + ", name=" + name + ", email="
				+ email + ", phone=" + phone + ", addr=" + addr + ", state=" + state + ", code=" + code + "]";
	}	
}
