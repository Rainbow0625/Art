package com.art.controller;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.art.backstageService.AdminCategorySecondService;
import com.art.backstageService.AdminProductService;
import com.art.entity.Artwork;
import com.art.entity.CategorySecond;

@Controller
public class AdminProductController {

	@Autowired
	private AdminProductService adminProductService;
	@Autowired//因为在添加商品需要二级分类的方法，所以注入CategorySecondService
	private AdminCategorySecondService categoryService;

	//更新商品
	@RequestMapping(value="/updateProduct")
	public ModelAndView updateProduct(@ModelAttribute("product") Artwork product
			,@RequestParam("upload")  CommonsMultipartFile upload,HttpServletRequest request){
		ServletContext servletContext = request.getSession().getServletContext();
		//查询该商品
		Artwork oldProduct = adminProductService.findProduct(product.getArtworkId());
		//从该字符串中截取出该图片的名称
		int begin = oldProduct.getImagesURL().lastIndexOf("/");
		String filename = oldProduct.getImagesURL().substring(begin+1, oldProduct.getImagesURL().length());
		//获取文件的名称
		String uploadFilename = upload.getOriginalFilename();
		//如果新上传的图片的名称和旧的照片不一致
		if(filename != uploadFilename){
			//获取文件保存目录
			String path = servletContext.getRealPath("/products/3");
			try {
				FileUtils.writeByteArrayToFile(new File(path,uploadFilename), upload.getBytes());
			} catch (IOException e) {
				e.printStackTrace();
			}
			//重新设置文件的路径
			product.setImagesURL("products/3/"+uploadFilename);
			//更新商品的时间
			product.setPdate(new Date());			
			//删除旧的商品的图片
			path = request.getServletContext().getRealPath("/" + oldProduct.getImagesURL());
			File file = new File(path);
			file.delete();
		}else{
			//更新商品的时间
			product.setPdate(new Date());
		}
		//更新商品
		adminProductService.saveProduct(product);
		ModelAndView modelAndView = new ModelAndView("redirect:/listProduct/1");
		return modelAndView;
	}
	//修改商品
	@RequestMapping(value="/editProduct")
	public ModelAndView editProduct(@RequestParam Integer pid){
			ModelAndView modelAndView = new ModelAndView("admin/product/edit");
			//查询所有二级分类的集合
			List<CategorySecond> categorySeconds = categoryService.listCategorySecond();
			modelAndView.addObject("categorySeconds", categorySeconds);
			//查询商品
			Artwork product = adminProductService.findProduct(pid);
			modelAndView.addObject("product", product);
			return modelAndView;	
	}

	//删除商品
	@RequestMapping(value="/deleteProduct")
	public ModelAndView deleteProduct(@RequestParam Integer pid,HttpServletRequest request){
		//获取该商品的对象
		Artwork product = adminProductService.findProduct(pid);
		//获取文件保存目录
		String path = request.getServletContext().getRealPath("/" + product.getImagesURL());
		File file = new File(path);
		// 删除商品服务器上的图片:
		file.delete();
		//删除商品在数据库中的记录
		adminProductService.deleteProduct(product);
		ModelAndView modelAndView = new ModelAndView("redirect:/listProduct/1");
		return modelAndView;
	}
	
	//上传商品
	@RequestMapping(value="/addProduct",method=RequestMethod.POST)
	public ModelAndView addProduct(@ModelAttribute("product") Artwork product,
			@RequestParam("upload")  CommonsMultipartFile upload,HttpServletRequest request,@RequestParam Integer csid){		
		//获取文件保存目录
		ServletContext servletContext = request.getSession().getServletContext();
		String path = servletContext.getRealPath("/products/3");
		//获取文件的名称
		String filename = upload.getOriginalFilename();
		try {
			FileUtils.writeByteArrayToFile(new File(path,filename), upload.getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}
		//设置文件的路径
		product.setImagesURL("products/3/"+filename);
		//设置上传的时间
		
		//该商品所属的二级分类
		CategorySecond categorySecond = categoryService.findCategorySecond(csid);

		//保存商品
		adminProductService.saveProduct(product);
		
		ModelAndView modelAndView = new ModelAndView("redirect:/listProduct/1");
		return modelAndView;
	}
	/*
	//分页查询所有的商品
	@RequestMapping(value="/listProduct/{page}")
	public String listProduct(@PathVariable("page") Integer page,Map<String,Object> map){
		//分页查询商品
		Page<Artwork> products = adminProductService.listProduct(page);
		//查询商品的页数
		Integer count = adminProductService.countProduct();
		map.put("products",products);
		map.put("page", page);
		map.put("count", count);
		return "admin/product/list";
	}
	*/
	//跳转到添加商品
	@RequestMapping(value="/gotoAddProduct")
	public ModelAndView gotoAddProduct(){
		ModelAndView modelAndView = new ModelAndView("admin/product/add");
		//查询所有二级分类的集合
		List<CategorySecond> categorySeconds = categoryService.listCategorySecond();
		modelAndView.addObject("categorySeconds", categorySeconds);
		return modelAndView;
	}
}
