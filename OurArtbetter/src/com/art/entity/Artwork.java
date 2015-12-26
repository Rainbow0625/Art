package com.art.entity;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
	

	@JoinColumn(name="csid")
	@ManyToOne
	private CategorySecond categorySecond;
	//artworkType   1 product  2 customization 3 auction


	@Column(name="artworkType",nullable=false)
	private int artworkType;

	
	@Column(name="Pdate")
	private Date Pdate;  //制作的时间

	@Column(name="quantity")
	private int quantity;     //库存
	
	
	@Column(name="artworkPrice")
	private int artworkPrice;
	
	@JoinColumn(name="artistid")
	@ManyToOne(targetEntity=Artist.class,cascade={CascadeType.ALL},fetch=FetchType.EAGER )
	private Artist artist;
	
	@Column(name="hotNum")
	private int hotNum;
	
	@Column(name="artworkInformation")
	private String artworkInformation;
	
	@Column(name="imagesURL",nullable=false)
	private  String imagesURL;
	
	public Artwork(){}
	public Artwork(int artworkId,String artworkName,int artworkType,int artworkPrice,int hotNum,int artistsId,String artworkInformation,String imagesURL,Artist artist)
	{
		setArtworkId(artworkId);
		setArtworkId(artworkType);
		setArtworkPrice(artworkPrice);
		setHotNum(hotNum);
		setArtworkInformation(artworkInformation);
		setImagesURL(imagesURL);
		setArtist(artist);
	}
	public int getArtworkId() {
		return artworkId;
	}
	public void setArtworkId(int artworkId) {
		this.artworkId = artworkId;
	}
	public String getArtworkName() {
		return artworkName;
	}
	public void setArtworkName(String artworkName) {
		this.artworkName = artworkName;
	}
	public CategorySecond getCategorySecond() {
		return categorySecond;
	}
	public void setCategorySecond(CategorySecond categorySecond) {
		this.categorySecond = categorySecond;
	}
	public int getArtworkType() {
		return artworkType;
	}
	public void setArtworkType(int artworkType) {
		this.artworkType = artworkType;
	}
	public int getArtworkPrice() {
		return artworkPrice;
	}
	public void setArtworkPrice(int artworkPrice) {
		this.artworkPrice = artworkPrice;
	}
	public int getHotNum() {
		return hotNum;
	}
	public void setHotNum(int hotNum) {
		this.hotNum = hotNum;
	}
	
	public Artist getArtist() {
		return artist;
	}
	public void setArtist(Artist artist) {
		this.artist = artist;
	}
	public String getArtworkInformation() {
		return artworkInformation;
	}
	public void setArtworkInformation(String artworkInformation) {
		this.artworkInformation = artworkInformation;
	}
	public String getImagesURL() {
		return imagesURL;
	}
	public void setImagesURL(String imagesURL) {
		this.imagesURL = imagesURL;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public Date getPdate() {
		return Pdate;
	}
	public void setPdate(Date pdate) {
		Pdate = pdate;
	}

}
