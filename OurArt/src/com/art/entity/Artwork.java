package com.art.entity;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="artwork")
public class Artwork 
{
	@Id
	@GeneratedValue(strategy =GenerationType.AUTO)
	@Column(name="artworkId",nullable=false)
	private int artworkId;
	
	@Column(name="artworkName",nullable=false)
	private String artworkName;
	//artworkType璁剧疆鎴恑nt鍨嬶紝1鏄垚鍝�2鏄鍒跺搧3鏄媿鍗栧搧
	@Column(name="artworkType",nullable=false)
	private int artworkType;
	
	@Column(name="artworkKind",nullable=false)
	private String artworkKind;
	
	@Column(name="artworkPrice")
	private int artworkPrice;
	
	@Column(name="artistsId")
	private int artistsId;
	
	@Column(name="artworkInformation")
	private String artworkInformation;
	
	@Column(name="images",nullable=false)
	private  String images;
	
	public String getImages() 
   	{
           return this.images;
   	}  
    public void setImages(String images) 
	{
    	this.images = images;
	}

	public int getartworkId() {
		return artworkId;
	}
	
	public void setartworkId(int artworkId) {
		this.artworkId = artworkId;
	}

	public int getartworkType() {
		return artworkType;
	}
	
	public void setartworkType(int artworkType) {
		this.artworkType = artworkType;
	}
	
	public String getartworkName() {
		return artworkName;
	}

	public void setartworkName(String artworkName) {
		this.artworkName = artworkName;
	}

	public String getartworkKind() {
		return artworkKind;
	}

	public void setartworkkind(String artworkKind) {
		this.artworkKind = artworkKind;
	}

	public int getartworkPrice() {
		return artworkPrice;
	}

	public void setartworkPrice(int artworkPrice) {
		this.artworkPrice = artworkPrice;
	}

	public int getartistsId() {
		return artistsId;
	}

	public void setartistsId(int artistsId) {
		this.artistsId = artistsId;
	}

	public String getartworkInformation() {
		return artworkInformation;
	}

	public void setartworkInformation(String artworkInformation) {
		this.artworkInformation = artworkInformation;
	}




}
