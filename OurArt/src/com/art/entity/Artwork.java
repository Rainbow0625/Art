package com.art.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

@Entity
@DynamicInsert
@DynamicUpdate
@Table(name="artwork")
public class Artwork implements java.io.Serializable
{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy =GenerationType.AUTO)
	@Column(name="artworkId",nullable=false)
	private int artworkId;
	
	@Column(name="artworkName",nullable=false)
	private String artworkName;
	
	//artworkType   1 product  2 customization 3 auction
	@Column(name="artworkType",nullable=false)
	private int artworkType;
	
	@Column(name="artworkKind",nullable=false,updatable=false)
	private String artworkKind;
	
	@Column(name="artworkPrice")
	private int artworkPrice;
	
	@Column(name="artistsId",updatable=false)
	private int artistsId;
	
	@Column(name="artworkInformation")
	private String artworkInformation;
	
	@Column(name="imagesURL",nullable=false)
	private  String imagesURL;
	
	public Artwork(){}
	public Artwork(int artworkId,String artworkName,int artworkType,String artworkKind,int artworkPrice,int artistsId,String artworkInformation,String imagesURL)
	{
		setartworkId(artworkId);
		setartworkName(artworkName);
		setartworkType(artworkType);
		setartworkKind(artworkKind);
		setartworkPrice(artworkPrice);
		setartistsId(artistsId);
		setartworkInformation(artworkInformation);
		setimagesURL(imagesURL);
	}
	public String getimagesURL() 
   	{
           return this.imagesURL;
   	}  
    public void setimagesURL(String imagesURL) 
	{
    	this.imagesURL = imagesURL;
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

	public void setartworkKind(String artworkKind) {
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
