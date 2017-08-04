package model;
import java.util.*;

import model.Goods;
/**
 * 商品管理类
 * @author Qiong
 *
 */
public class GoodsManage {
	//属性：存放商品的容器
	private Set<Goods> goodsSet = new HashSet<Goods>();
	
	public GoodsManage() {
	}
	
	public GoodsManage(Set<Goods> goodsSet) {
		this.setGoodsSet(goodsSet);
	}
	//getter和setter方法
	public Set<Goods> getGoodsSet() {
		return goodsSet;
	}

	public void setGoodsSet(Set<Goods> goodsSet) {
		this.goodsSet = goodsSet;
	}
	
	//商品信息导入
	public void importGoods() {
		Goods gd1 = new Goods("goods001","水杯",56,"不锈钢水杯");
		Goods gd2 = new Goods("goods002","饮水机",299,"带净化功能的饮水机");
		Goods gd3 = new Goods("goods003","笔记本电脑",4999,"15寸笔记本电脑");
		Goods gd4 = new Goods("goods004","手机",2300,"android手机");
		goodsSet.add(gd1);
		goodsSet.add(gd2);
		goodsSet.add(gd3);
		goodsSet.add(gd4);
		System.out.println("商品信息导入成功!");
	}
	
	
	//显示所有商品信息
	public void displayAllGoods() {
		if(goodsSet.isEmpty()) {
			System.out.println("还没有商品，记得导入商品信息哟!");
		}
		else {
			Iterator<Goods> itr = goodsSet.iterator();
			System.out.println("所有商品信息为:");
			while(itr.hasNext()) {
				System.out.println(itr.next());
			}
		}
	}
	
}
