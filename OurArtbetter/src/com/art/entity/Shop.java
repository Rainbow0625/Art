package com.art.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Table(name="Shop")
@Entity
public class Shop implements Serializable{
	private static final long serialVersionUID = 1L;
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Id
	private int id;
	
	private String shopNameString;
	
	@JoinColumn(name="artistid")
	@ManyToOne
	private Artist artist;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getShopNameString() {
		return shopNameString;
	}

	public void setShopNameString(String shopNameString) {
		this.shopNameString = shopNameString;
	}

	public Artist getArtist() {
		return artist;
	}

	public void setArtist(Artist artist) {
		this.artist = artist;
	}
	
	
}
