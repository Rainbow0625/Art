package com.art.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.art.entity.CategorySecond;

public interface CategorySecondDao{
	//统计二级分类的个数
	    public int countCategorySecond();

		public CategorySecond findOne(int csid);

		public void deleteAll();

		public void delete(CategorySecond categorySecond);

		public void delete(int csid);

		public CategorySecond findAll(int csid);

		public List<CategorySecond> findAll();

		public void save(CategorySecond categorySecond);
}
