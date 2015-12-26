package com.art.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.art.entity.Artist;
import com.art.entity.Artwork;

public interface ArtworkDao{

	public List<Artwork> getAllArtwork();
	public List<Artwork> getAllProduct();
	public List<Artwork> getAllAuction();
	public List<Artwork> getAllCustommade();

/*
	//查询最热的商品
	@Query("SELECT p FROM Product p WHERE p.is_hot=1 ORDER BY p.pdate DESC")
	public Page<Artwork> findHot(PageRequest pageRequest);

	//根据二级分类查询商品
	public Page<Artwork> findByCategorySecondCsid(Integer csid,Pageable pageable);
	
	//根据一级分类查询商品
	public Page<Artwork> findByCategorySecondCategoryCid(Integer cid,Pageable pageable);
*/
	
	public void deleteArtworkById(int ArtworkId);
	public List<Artwork> findAll();
	public void delete(int artworkId);
	public void delete(Artwork artwork);
	public Artwork findOne(int artworkId);
	public void deleteAll();
	public int CountPageProductFromCategory(Integer cid);
	public int CountPageProductFromCategorySecond(Integer csid);
	public int CountProduct();
	public void save(Artwork product);
	public Artwork findAll(int artworkId);
	public List<Artwork> findHot();
	public List<Artwork> findByCategorySecondCsid(int csid);
	public List<Artwork> findByCategorySecondCategoryCid(int cid);
	public List<Artwork> getArtwork(Artist artist);
	
}
