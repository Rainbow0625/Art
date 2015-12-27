package com.art.controller;

import java.io.IOException;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.art.businessService.OrderService;
import com.art.cart.Cart;
import com.art.cart.CartItem;
import com.art.entity.Order;
import com.art.entity.OrderItem;
import com.art.entity.User;
import com.art.util.PaymentUtil;

@Controller
public class OrderController {

	@Autowired
	private OrderService orderService;

	//根据订单id查询订单
	@RequestMapping(value="/findByOid")
	public String findByOid(@RequestParam int oid,
			Map<String,Object> map){
		Order order = orderService.findByOid(oid);
		map.put("order",order);
		return "order";
	} 
	//查询订单
	@RequestMapping(value="/findOrderByUid")
	public String findOrderByUid(HttpSession session,Map<String,Object> map){
		//从session获取user对象
		User user = (User) session.getAttribute("user");
		if(user == null){
			map.put("notLogin", "notLogin");
			return "msg";
		}
		//查询总共有多少页的数据
		Integer count = orderService.findCountByUid(user.getId());
		//根据用户分页查询订单
		List<Order> orders = orderService.findOrderByUid(user.getId());
		map.put("orders", orders);
		map.put("count",count);
		return "orderList";
	}
	
	//保存订单的
	
	@RequestMapping(value="/saveOrder")
	public String saveOrder(HttpSession session,Map<String,Object> map,HttpServletRequest request){
		
		User user = (User) session.getAttribute("user");
		System.out.println("user's id is :" + user.getId());
		//从session获取购物车对象
		Cart cart = (Cart) session .getAttribute("cart");
		//如果购物车为空，则返回到我的购物车页面
		if(cart == null){
			return "redirect:myCart";
		}
		//User user=new User(123,"123");
		//订单对象
		Order order = new Order();
		order.setTotal(cart.getTotal());
		// 1:未付款. 2.已经付款，没有发货 3.发货，没有确认发货 4.交易完成
		order.setState(1);
		// 设置订单时间
		order.setOrdertime(new Date());
		// 设置订单关联的客户:
		order.setUser(user);
		// 设置订单项集合:
		// 设置订单项集合:
		Set<OrderItem> sets = new HashSet<>();
		for (CartItem cartItem : cart.getCartItems()) {
			// 订单项的信息从购物项获得的.
			OrderItem orderItem = new OrderItem();			
			orderItem.setCount(cartItem.getCount());
			orderItem.setSubtotal(cartItem.getSubtotal());
			orderItem.setProduct(cartItem.getProduct());
			//双向关联时在多的一方设置一的一方的属性
			orderItem.setOrder(order);
			//把orderItem对象添加到集合中
			sets.add(orderItem);
			System.out.println(orderItem);			
		}
		//双向关联时在一的一方设置多的一方的属性
		order.setOrderItems(sets);
		orderService.saveOrder(order);
		//清除购物车
		cart.clearCart();
		map.put("order",order);
		return "order";
	}
	
	/* 确认订单的操作,为订单付款:
	 * addr:收货人地址 name:收货人 phone:联系电话  oid:订单的oid
	 * pd_FrpId:接收支付通道编码
	 */
	@RequestMapping(value="/payOrder")
	public String payOrder(@RequestParam Integer oid,@RequestParam String nickName,@RequestParam String address,@RequestParam String tel,
			@RequestParam String pd_FrpId,HttpServletResponse response){
		Order order = orderService.findByOid(oid);
		System.out.println("12456");
		order.setAddress(address);
		order.setNickName(nickName);
		order.setTel(tel);
		//修改订单
		orderService.updateOrder(order);
		// 2.完成付款:
		// 付款需要的参数:
		String p0_Cmd = "Buy"; // 业务类型:
		String p1_MerId = "10001126856";// 商户编号:
		String p2_Order = order.getOid().toString();// 订单编号:
		String p3_Amt = "0.01"; // 付款金额:
		String p4_Cur = "CNY"; // 交易币种:
		String p5_Pid = ""; // 商品名称:
		String p6_Pcat = ""; // 商品种类:
		String p7_Pdesc = ""; // 商品描述:
		String p8_Url = "http://localhost:8080/OurArtbetter/callBack"; // 商户接收支付成功数据的地址:
		String p9_SAF = ""; // 送货地址:
		String pa_MP = ""; // 商户扩展信息:
		String pr_NeedResponse = "1"; // 应答机制:
		String keyValue = "69cl522AV6q613Ii4W6u8K6XuW8vM1N6bFgyv769220IuYe9u37N4y7rI4Pl"; // 秘钥
		String hmac = PaymentUtil.buildHmac(p0_Cmd, p1_MerId, p2_Order, p3_Amt, p4_Cur, p5_Pid, p6_Pcat, p7_Pdesc,
				p8_Url, p9_SAF, pa_MP, pd_FrpId, pr_NeedResponse, keyValue); // hmac码
		// 向易宝发送请求:
		StringBuffer sb = new StringBuffer("https://www.yeepay.com/app-merchant-proxy/node?");
		sb.append("p0_Cmd=").append(p0_Cmd).append("&");
		sb.append("p1_MerId=").append(p1_MerId).append("&");
		sb.append("p2_Order=").append(p2_Order).append("&");
		sb.append("p3_Amt=").append(p3_Amt).append("&");
		sb.append("p4_Cur=").append(p4_Cur).append("&");
		sb.append("p5_Pid=").append(p5_Pid).append("&");
		sb.append("p6_Pcat=").append(p6_Pcat).append("&");
		sb.append("p7_Pdesc=").append(p7_Pdesc).append("&");
		sb.append("p8_Url=").append(p8_Url).append("&");
		sb.append("p9_SAF=").append(p9_SAF).append("&");
		sb.append("pa_MP=").append(pa_MP).append("&");
		sb.append("pd_FrpId=").append(pd_FrpId).append("&");
		sb.append("pr_NeedResponse=").append(pr_NeedResponse).append("&");
		sb.append("hmac=").append(hmac);
		// 重定向:向易宝出发:
		try {
			response.sendRedirect(sb.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	/*
	 * 付款成功后跳转回来的路径:
	 * r6_Order,r3_Amt 接收付款成功后的参数:
	 */
	@RequestMapping(value="/callBack")
	public String callBack(@RequestParam Integer r6_Order,
			@RequestParam("r3_Amt") String r3_Amt,Map<String,Object> map){
		// 修改订单的状态:
		Order currOrder = orderService.findByOid(r6_Order);
		// 修改订单状态为2:已经付款:
		currOrder.setState(2);
		orderService.saveOrder(currOrder);
		map.put("success", "支付成功!订单编号为: "+r6_Order +" 付款金额为: "+r3_Amt);
		return "msg";
	}
	//确认收货
	@RequestMapping(value="/updateState")
	public ModelAndView updateState(@RequestParam Integer oid){
		System.out.println(oid);
		Order order = orderService.findByOid(oid);
		order.setState(4);
		orderService.saveOrder(order);
		ModelAndView model = new ModelAndView("redirect:/findOrderByUid");
		return model;
	}
}
