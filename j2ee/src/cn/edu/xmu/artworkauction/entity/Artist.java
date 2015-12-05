/**
 * 
 */
package cn.edu.xmu.artworkauction.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;


/**
 * @author Administrator
 *
 */
@Entity
@DiscriminatorValue("artist")
public class Artist extends User{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String IDNumber;
	private String description;
	private List<Artwork> artworks;
	
	public Artist(){}
	@Column(length = 18,unique=true)
	public String getIDNumber() {
		return IDNumber;
	}
	public void setIDNumber(String iDNumber) {
		IDNumber = iDNumber;
	}
	
	@Column
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	@OneToMany(mappedBy = "artist", targetEntity = Artwork.class,
            cascade = CascadeType.ALL)
	public List<Artwork> getArtworks() {
		return artworks;
	}
	public void setArtworks(List<Artwork> artworks) {
		this.artworks=artworks;
	}
}
