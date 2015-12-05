/**
 * 
 */
package cn.edu.xmu.artworkauction.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;


/**
 * @author Administrator
 *
 */
@Entity
@DynamicInsert
@DynamicUpdate
@Table(name="tb_artwork")
public class Artwork implements java.io.Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer id;
	private Artist artist;
	private String material;
	private String size;
	private String creationTime;
	private String descrition;
	private List<String> imageURL;
	private String type;
	private String theme;
	
	public Artwork(){}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	@ManyToOne(targetEntity = Artist.class, cascade = {CascadeType.ALL})
    @JoinColumn(name = "artist_id", nullable = false)
	public Artist getArtist() {
		return artist;
	}
	public void setArtist(Artist artist) {
		this.artist = artist;
	}

	@Column(length=100)
	public String getMaterial() {
		return material;
	}
	public void setMaterial(String material) {
		this.material = material;
	}

	@Column(length=100)
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}

	@Column(length=100)
	public String getCreationTime() {
		return creationTime;
	}
	public void setCreationTime(String creationTime) {
		this.creationTime = creationTime;
	}

	@Column(length=1000)
	public String getDescrition() {
		return descrition;
	}
	public void setDescrition(String descrition) {
		this.descrition = descrition;
	}

	@ElementCollection
	@CollectionTable(name="artworkImageURL", joinColumns=@JoinColumn(name="artwork_id"))
	@Column(name="artworkImageURL")
	public List<String> getImageURL() {
		return imageURL;
	}
	public void setImageURL(List<String> imageURL) {
		this.imageURL = imageURL;
	}

	@Column(length=100)
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}

	@Column(length=100)
	public String getTheme() {
		return theme;
	}
	public void setTheme(String theme) {
		this.theme = theme;
	}
}
