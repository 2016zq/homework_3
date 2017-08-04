package model;
/**
 * 购物车中的商品信息类
 * @author Qiong
 *
 */
public class GoodsInCart {
	//商品属性:商品,商品数量
	private Goods goods;
	private int num;
	//构造方法
	public GoodsInCart() {
	}
	public GoodsInCart(Goods goods,int num) {
		this.setGoods(goods);
		this.setNum(num);
	}
	//getter和setter方法
	public Goods getGoods() {
		return goods;
	}
	public void setGoods(Goods goods) {
		this.goods = goods;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	
}
