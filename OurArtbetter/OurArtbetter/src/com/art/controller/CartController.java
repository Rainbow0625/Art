package com.art.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.art.businessService.ProductService;
import com.art.cart.Cart;
import com.art.cart.CartItem;
import com.art.entity.Artwork;


@Controller

public class CartController {

	@Resource
	private ProductService productService;
	@Autowired
	public CartController(ProductService productService)
	{
		this.productService=productService;
	}
	//首页上跳转到购物车
	@RequestMapping("/myCart")
	public String myCart(){
		return "cart";
	}
	//清空购物车
	@RequestMapping(value="/clearCart")
	public String clearCart(HttpSession session){
		Cart cart = (Cart) session.getAttribute("cart");
		cart.clearCart();
		return "cart";
	}
	//删除购物车中的商品
	@RequestMapping(value="/removeCart")
	public String removeCart(@RequestParam int artworkId,HttpSession session){
		//获得购物车对象
		Cart cart = (Cart) session.getAttribute("cart");
		//根据商品的artworkId从购物车中移除商品
		cart.removeCart(artworkId);
		return "cart";
	}
	//添加到购物车
	@SuppressWarnings("unused")
	@RequestMapping(value="/addCart")
	public String addCart(@RequestParam int artworkId,@RequestParam int count, HttpServletRequest request,
			HttpSession session){
		// 根据artworkId进行查询商品:
		Artwork product = productService.findByPid(artworkId);
		// 封装一个CartItem对象.
		CartItem cartItem = new CartItem();
		
		// 设置数量:		
				cartItem.setCount(count);
		// 设置商品:
		cartItem.setProduct(product);

		// 购物车应该存在session中.从session中获取Cart对象
		Cart cart = (Cart) session.getAttribute("cart");
		//System.out.println(cart.getTotal());
		//如果此时的购物车为空，则应先创建购物车放入到session中
		if (cart == null) {
			cart = new Cart();
			session.setAttribute("cart", cart);
			System.out.println("创建购物车了");
		}
		// 将购物项添加到购物车.
		cart.addCart(cartItem);
		
		System.out.println("加入购物车了");
		return "cart";
	}
	
}
