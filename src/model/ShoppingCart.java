package model;

import java.util.*;

/**
 * 购物车类
 * 
 * @author Qiong
 *
 */
public class ShoppingCart {
	// 属性:购物车容器
	private Map<String, GoodsInCart> shoppingCart = new HashMap<String, GoodsInCart>();
	Scanner input = new Scanner(System.in);

	// 构造方法
	public ShoppingCart() {
	}

	public ShoppingCart(Map<String, GoodsInCart> shoppingCart) {
		this.setShoppingCart(shoppingCart);
	}

	// getter和setter方法
	public Map<String, GoodsInCart> getShoppingCart() {
		return shoppingCart;
	}

	public void setShoppingCart(Map<String, GoodsInCart> shoppingCart) {
		this.shoppingCart = shoppingCart;
	}

	// 添加商品到购物车
	public void addGoodsToCart(GoodsManage gm) {
		System.out.println("请输入要添加商品的编号:");
		String goodsId = input.next();
		if(shoppingCart.containsKey(goodsId)) {
			System.out.println("该商品已经买过啦~~如果想修改数量，可以去“修改购物车中的商品数量”哟~~");
		}
		else {
			Iterator<Goods> itr = gm.getGoodsSet().iterator();
			Goods goods = null;
			while (itr.hasNext()) {
				Goods gd = itr.next();
				if (gd.getGoodsId().equals(goodsId)) {
					goods = gd;
					break;
				}
			}
			if (goods == null) {
				System.out.println("不存在该编号的商品!");
			} else {
				System.out.println("请输入要添加的商品的数量:");
				try{
					int num = input.nextInt();
					GoodsInCart goodsInCar = new GoodsInCart(goods, num);
					shoppingCart.put(goodsId, goodsInCar);
					System.out.println("商品添加成功!");
				}catch(Exception e) {
					System.out.println("请输入正确格式的数字~");
					input.next();
				}
			}
		}
	}
	
	//修改购物车中的商品数量
	public void updateNumInCart() {
		System.out.println("修改购物车中的商品数量");
		for(GoodsInCart gic : shoppingCart.values()) {
			System.out.println("商品编号:" + gic.getGoods().getGoodsId() + "商品名称:" + gic.getGoods().getGoodsName() + ", 商品价格:" + gic.getGoods().getPrice()
					+ ", 商品描述:" + gic.getGoods().getGoodsDesp() + ", 数量:" + gic.getNum());
		}
		System.out.println("请输入要修改的商品编号:");
		String goodsId = input.next();
		if(!shoppingCart.containsKey(goodsId)) {
			System.out.println("您的购物车中不存在该商品");
		}
		else {
			System.out.println("请输入新的商品数量:");
			try {
				int num = input.nextInt();
				if(num==0) {
					shoppingCart.remove(goodsId);
				}
				else{
					shoppingCart.get(goodsId).setNum(num);
					System.out.println("商品数量修改成功!");
				}
			}catch(Exception e) {
				input.next();
				System.out.println("请输入正确的格式!");
			}
		}
	}
	
	// 显示购物车中的所有商品
	public void displayAllInCart() {
		if(shoppingCart.isEmpty()) {
			System.out.println("购物车是空的哟,赶快装满吧~");
		}
		else{
			Iterator<GoodsInCart> itr = shoppingCart.values().iterator();
			while (itr.hasNext()) {
				GoodsInCart gic = itr.next();
				System.out.println("商品名称:" + gic.getGoods().getGoodsName() + ", 商品价格:" + gic.getGoods().getPrice()
						+ ", 商品描述:" + gic.getGoods().getGoodsDesp() + ", 数量:" + gic.getNum());
			}
		}
	}
	
	//结算
	public void settleAccounts() {
		if(shoppingCart.isEmpty()) {
			System.out.println("购物车是空的哟,赶快装满吧~");
		}
		else {
			System.out.println("结算:");
			double priceSum = 0;
			Iterator<GoodsInCart> itr = shoppingCart.values().iterator();
			while (itr.hasNext()) {
				GoodsInCart gic = itr.next();
				priceSum = priceSum + (gic.getNum())*(gic.getGoods().getPrice());
			}
			System.out.println("商品的总价为:" + priceSum);
			for(GoodsInCart gic:shoppingCart.values()) {
				System.out.println("商品名称:" + gic.getGoods().getGoodsName() + ", 商品价格:" + gic.getGoods().getPrice()
						+ ", 商品描述:" + gic.getGoods().getGoodsDesp() + ", 数量:" + gic.getNum());
			}
			shoppingCart.clear();
		}
	}
}
