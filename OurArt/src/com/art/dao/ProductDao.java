package com.art.dao;

import java.util.List;

import com.art.entity.Artwork;


public interface ProductDao {

	public void deleteById(int productid);
	public List<Artwork> getAllProduct();
	public void save(Artwork product);
	public void update(Artwork product);
	public Artwork getProductByname(String Productname);

}
