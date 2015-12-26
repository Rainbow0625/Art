package com.art.backstageService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.art.dao.CategoryDao;
import com.art.entity.Category;

@Transactional
@Service
public class AdminCategoryService {

	@Autowired
	private CategoryDao categoryRepository;
/*
	// 分页查询一级分类
	public Page<Category> listCategory(Integer page) {
		Sort sort = new Sort(Sort.Direction.ASC, "cid");
		Pageable pageable = new PageRequest(page - 1, 10, sort);
		Page<Category> categorys = categoryRepository.findAll(pageable);
		return categorys;
	}
*/
	// 查询一级分类的页数
	public Integer countCategory() {
		Integer count = categoryRepository.countCategory(); 
		return  (count % 10 == 0 ? (count /10) : (count / 10 + 1));
	}

	//添加二级分类
	public void addCategory(Category category) {
		categoryRepository.save(category);
	}

	//删除二级分类
	public void deleteCategory(Integer cid) {
		categoryRepository.delete(cid);
	}

	//查询某个具体的一级分类
	public Category findCategory(Integer cid) {
         return categoryRepository.findOne(cid);
	}

	//更新一级分类
	public void updateCategory(Category category) {
		categoryRepository.save(category);
	}

	public List<Category> findCategory() {
		return categoryRepository.findAll();
	}

	public List<Category> listCategory() {
		// TODO Auto-generated method stub
		return null;
	}
}
