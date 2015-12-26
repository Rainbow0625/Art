package com.art.backstageService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.art.dao.CategorySecondDao;
import com.art.entity.CategorySecond;

@Transactional
@Service
public class AdminCategorySecondService {
	
	@Autowired
	private CategorySecondDao categorySecondRepository;
/*	
	//分页查找二级分类
	public Page<CategorySecond> listCategorySecond(Integer page){
		Sort sort = new Sort(Sort.Direction.ASC,"csid");
		Pageable pageable = new PageRequest(page - 1,15,sort);
		Page<CategorySecond> categorySeconds = categorySecondRepository.findAll(pageable);
		return categorySeconds;
	}
*/
	//统计二级分类的个数
	public Integer countCategorySecond() {
		Integer count = categorySecondRepository.countCategorySecond();
		return (count % 15 == 0 ? (count / 15) : (count / 15 + 1));
	}
	
	//保存二级分类
	public void addCategorySecond(CategorySecond categorySecond) {
		categorySecondRepository.save(categorySecond);
	}

	//删除二级分类
	public void deleteCategorySecond(Integer csid) {
		categorySecondRepository.delete(csid);
	}

	//查找具体某个二级分类
	public CategorySecond findCategorySecond(Integer csid) {
		return categorySecondRepository.findOne(csid);
	}

	//更新二级分类
	public void updateCategorySecond(CategorySecond categorySecond) {
		categorySecondRepository.save(categorySecond);
	}
	
	//查找所有的二级分类
	public List<CategorySecond> listCategorySecond(){
		return categorySecondRepository.findAll();
	}

	public List<CategorySecond> listCategorySecond(Integer page) {
		return categorySecondRepository.findAll();
	}
}
