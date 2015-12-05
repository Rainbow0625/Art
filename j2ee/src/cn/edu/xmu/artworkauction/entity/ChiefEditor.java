/**
 * 
 */
package cn.edu.xmu.artworkauction.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * @author Administrator
 *
 */
@Entity
@DiscriminatorValue("chiefEditor")
public class ChiefEditor extends Admin {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
