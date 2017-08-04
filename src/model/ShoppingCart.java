package model;

import java.util.*;

/**
 * ���ﳵ��
 * 
 * @author Qiong
 *
 */
public class ShoppingCart {
	// ����:���ﳵ����
	private Map<String, GoodsInCart> shoppingCart = new HashMap<String, GoodsInCart>();
	Scanner input = new Scanner(System.in);

	// ���췽��
	public ShoppingCart() {
	}

	public ShoppingCart(Map<String, GoodsInCart> shoppingCart) {
		this.setShoppingCart(shoppingCart);
	}

	// getter��setter����
	public Map<String, GoodsInCart> getShoppingCart() {
		return shoppingCart;
	}

	public void setShoppingCart(Map<String, GoodsInCart> shoppingCart) {
		this.shoppingCart = shoppingCart;
	}

	// �����Ʒ�����ﳵ
	public void addGoodsToCart(GoodsManage gm) {
		System.out.println("������Ҫ�����Ʒ�ı��:");
		String goodsId = input.next();
		if(shoppingCart.containsKey(goodsId)) {
			System.out.println("����Ʒ�Ѿ������~~������޸�����������ȥ���޸Ĺ��ﳵ�е���Ʒ������Ӵ~~");
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
				System.out.println("�����ڸñ�ŵ���Ʒ!");
			} else {
				System.out.println("������Ҫ��ӵ���Ʒ������:");
				try{
					int num = input.nextInt();
					GoodsInCart goodsInCar = new GoodsInCart(goods, num);
					shoppingCart.put(goodsId, goodsInCar);
					System.out.println("��Ʒ��ӳɹ�!");
				}catch(Exception e) {
					System.out.println("��������ȷ��ʽ������~");
					input.next();
				}
			}
		}
	}
	
	//�޸Ĺ��ﳵ�е���Ʒ����
	public void updateNumInCart() {
		System.out.println("�޸Ĺ��ﳵ�е���Ʒ����");
		for(GoodsInCart gic : shoppingCart.values()) {
			System.out.println("��Ʒ���:" + gic.getGoods().getGoodsId() + "��Ʒ����:" + gic.getGoods().getGoodsName() + ", ��Ʒ�۸�:" + gic.getGoods().getPrice()
					+ ", ��Ʒ����:" + gic.getGoods().getGoodsDesp() + ", ����:" + gic.getNum());
		}
		System.out.println("������Ҫ�޸ĵ���Ʒ���:");
		String goodsId = input.next();
		if(!shoppingCart.containsKey(goodsId)) {
			System.out.println("���Ĺ��ﳵ�в����ڸ���Ʒ");
		}
		else {
			System.out.println("�������µ���Ʒ����:");
			try {
				int num = input.nextInt();
				if(num==0) {
					shoppingCart.remove(goodsId);
				}
				else{
					shoppingCart.get(goodsId).setNum(num);
					System.out.println("��Ʒ�����޸ĳɹ�!");
				}
			}catch(Exception e) {
				input.next();
				System.out.println("��������ȷ�ĸ�ʽ!");
			}
		}
	}
	
	// ��ʾ���ﳵ�е�������Ʒ
	public void displayAllInCart() {
		if(shoppingCart.isEmpty()) {
			System.out.println("���ﳵ�ǿյ�Ӵ,�Ͽ�װ����~");
		}
		else{
			Iterator<GoodsInCart> itr = shoppingCart.values().iterator();
			while (itr.hasNext()) {
				GoodsInCart gic = itr.next();
				System.out.println("��Ʒ����:" + gic.getGoods().getGoodsName() + ", ��Ʒ�۸�:" + gic.getGoods().getPrice()
						+ ", ��Ʒ����:" + gic.getGoods().getGoodsDesp() + ", ����:" + gic.getNum());
			}
		}
	}
	
	//����
	public void settleAccounts() {
		if(shoppingCart.isEmpty()) {
			System.out.println("���ﳵ�ǿյ�Ӵ,�Ͽ�װ����~");
		}
		else {
			System.out.println("����:");
			double priceSum = 0;
			Iterator<GoodsInCart> itr = shoppingCart.values().iterator();
			while (itr.hasNext()) {
				GoodsInCart gic = itr.next();
				priceSum = priceSum + (gic.getNum())*(gic.getGoods().getPrice());
			}
			System.out.println("��Ʒ���ܼ�Ϊ:" + priceSum);
			for(GoodsInCart gic:shoppingCart.values()) {
				System.out.println("��Ʒ����:" + gic.getGoods().getGoodsName() + ", ��Ʒ�۸�:" + gic.getGoods().getPrice()
						+ ", ��Ʒ����:" + gic.getGoods().getGoodsDesp() + ", ����:" + gic.getNum());
			}
			shoppingCart.clear();
		}
	}
}
