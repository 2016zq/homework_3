package model;
/**
 * ���ﳵ�е���Ʒ��Ϣ��
 * @author Qiong
 *
 */
public class GoodsInCart {
	//��Ʒ����:��Ʒ,��Ʒ����
	private Goods goods;
	private int num;
	//���췽��
	public GoodsInCart() {
	}
	public GoodsInCart(Goods goods,int num) {
		this.setGoods(goods);
		this.setNum(num);
	}
	//getter��setter����
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
