package com.art.cart; 

import com.art.entity.Artwork;


/**
 * 购物项对象
 */
public class CartItem {
	private Artwork product;	// 购物项中商品信息
	private int count;			// 购买某种商品数量
	private double subtotal;	// 购买某种商品小计
	public Artwork getProduct() {
		return product;
	}
	public void setProduct(Artwork product) {
		this.product = product;
		System.out.println("222");
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	// 小计自动计算的.
	public double getSubtotal() {
		return count * product.getArtworkId();
	}
}
