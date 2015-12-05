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
@DiscriminatorValue("serviceAdmin")
public class ServiceAdmin extends Admin{

}
