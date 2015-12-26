package com.art.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * 二级分类的实体
 */
@Table(name="categorysecond")
@Entity
public class CategorySecond implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Id
	private Integer csid;
	private String csname;
	// 所属一级分类.存的是一级分类的对象.
	@JoinColumn(name="cid")
	@ManyToOne
	private Category category;
	// 配置商品集合
	@OneToMany(fetch=FetchType.LAZY,mappedBy="categorySecond")
	private Set<Artwork> products = new HashSet<Artwork>();
	
	public Integer getCsid() {
		return csid;
	}
	public void setCsid(Integer csid) {
		this.csid = csid;
	}
	public String getCsname() {
		return csname;
	}
	public void setCsname(String csname) {
		this.csname = csname;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public Set<Artwork> getProducts() {
		return products;
	}
	public void setProducts(Set<Artwork> products) {
		this.products = products;
	}
	
}
