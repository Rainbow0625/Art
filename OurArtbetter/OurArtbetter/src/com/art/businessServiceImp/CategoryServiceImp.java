package com.art.businessServiceImp;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.art.businessService.CategoryService;
import com.art.dao.CategoryDao;
import com.art.entity.Category;
@Transactional(rollbackFor={Exception.class})
@Service
public class CategoryServiceImp implements CategoryService{

	@Resource
	private CategoryDao categoryRepository;
	@Override
	public List<Category> getCategory(){
		return categoryRepository.findAll();
	}
	
}
