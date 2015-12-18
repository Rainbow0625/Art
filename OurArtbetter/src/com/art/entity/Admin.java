package com.art.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

@Entity
@DynamicInsert
@DynamicUpdate
@Table(name="Admin")
@NamedQueries({
	@NamedQuery(name="@GetAllAdmin", query="from Admin"),
	@NamedQuery(name="@FindAdminById",query="from Admin a where a.id =?0"),
	@NamedQuery(name="@FindAdminByTel",query="from Admin a where a.tel =?0"),
	@NamedQuery(name="@FindAdminByIdAndPassword",query="from Admin a where a.id =?0 and a.password=?1"),
	@NamedQuery(name="@FindAdminByTelAndPassword",query="from Admin a where a.tel =?0 and a.password=?1"),
	@NamedQuery(name="@FindAdminByAdminType",query="from Admin a where a.adminType =?0")
	
})
public class Admin implements java.io.Serializable
{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY) //Increase auto
	@Column(name="id")
	private int id;
	
	@Column(name="tel")
	private String tel;
	
	@Column(name="password")
	private String password;
	
	@Column(name="adminType")
	private int adminType;

	public Admin(String tel,String password,int adminType)
	{
		this.setTel(tel);
		this.setPassword(password);
		this.setAdminType(adminType);
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getAdminType() {
		return adminType;
	}

	public void setAdminType(int adminType) {
		this.adminType = adminType;
	}	
}
