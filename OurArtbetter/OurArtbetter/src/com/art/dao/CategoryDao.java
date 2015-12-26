package com.art.dao;

import java.util.List;

import javax.swing.text.Position;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.art.entity.Category;

public interface CategoryDao{
	
	//查询一级分类的总的个数
		public int countCategory();
		public List<Category> findAll();
		
		public void save(Category category);
		public void delete(int cid);
		public Category findOne(int cid);
		//public List<Position> getPagePosition(int pageNum,int pageSize);
}
