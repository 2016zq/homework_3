package model;

/**
 * ��Ʒ��
 * 
 * @author Qiong
 *
 */
public class Goods {
	//��Ʒ����:��Ʒ��š���Ʒ���ơ���Ʒ�۸���Ʒ����
	private String goodsId;
	private String goodsName;
	private double price;
	private String goodsDesp;
	//���췽��
	public Goods() {
	}
	
	public Goods(String goodsId, String goodsName, double price, String goodsDesp) {
		this.setGoodsId(goodsId);
		this.setGoodsName(goodsName);
		this.setPrice(price);
		this.setGoodsDesp(goodsDesp);
	}
	//getter��setter����
	public String getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(String goodsId) {
		this.goodsId = goodsId;
	}

	public String getGoodsName() {
		return goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getGoodsDesp() {
		return goodsDesp;
	}

	public void setGoodsDesp(String goodsDesp) {
		this.goodsDesp = goodsDesp;
	}
	
	//hashCode()����
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((goodsDesp == null) ? 0 : goodsDesp.hashCode());
		result = prime * result + ((goodsId == null) ? 0 : goodsId.hashCode());
		result = prime * result + ((goodsName == null) ? 0 : goodsName.hashCode());
		long temp;
		temp = Double.doubleToLongBits(price);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}
	//equals()����
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (obj.getClass() == Goods.class) {
			Goods gd = (Goods) obj;
			if (gd.getGoodsId().equals(this.getGoodsId()) && (gd.getGoodsName().equals(this.getGoodsName()))
					&& (gd.getPrice() == this.getPrice()) && (gd.getGoodsDesp().equals(this.getGoodsDesp()))) {
				return true;
			}
		}
		return false;
	}
	//toString()����
	@Override
	public String toString() {
		return "��Ʒ��Ϣ[��Ʒ���=" + this.getGoodsId() + ", ��Ʒ����=" + this.getGoodsName() + ", ��Ʒ�۸�=" + this.getPrice()
				+ ",��Ʒ����:" + this.getGoodsDesp() + "]";
	}

}
