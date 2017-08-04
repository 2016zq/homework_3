package model;
import java.util.*;

import model.Goods;
/**
 * ��Ʒ������
 * @author Qiong
 *
 */
public class GoodsManage {
	//���ԣ������Ʒ������
	private Set<Goods> goodsSet = new HashSet<Goods>();
	
	public GoodsManage() {
	}
	
	public GoodsManage(Set<Goods> goodsSet) {
		this.setGoodsSet(goodsSet);
	}
	//getter��setter����
	public Set<Goods> getGoodsSet() {
		return goodsSet;
	}

	public void setGoodsSet(Set<Goods> goodsSet) {
		this.goodsSet = goodsSet;
	}
	
	//��Ʒ��Ϣ����
	public void importGoods() {
		Goods gd1 = new Goods("goods001","ˮ��",56,"�����ˮ��");
		Goods gd2 = new Goods("goods002","��ˮ��",299,"���������ܵ���ˮ��");
		Goods gd3 = new Goods("goods003","�ʼǱ�����",4999,"15��ʼǱ�����");
		Goods gd4 = new Goods("goods004","�ֻ�",2300,"android�ֻ�");
		goodsSet.add(gd1);
		goodsSet.add(gd2);
		goodsSet.add(gd3);
		goodsSet.add(gd4);
		System.out.println("��Ʒ��Ϣ����ɹ�!");
	}
	
	
	//��ʾ������Ʒ��Ϣ
	public void displayAllGoods() {
		if(goodsSet.isEmpty()) {
			System.out.println("��û����Ʒ���ǵõ�����Ʒ��ϢӴ!");
		}
		else {
			Iterator<Goods> itr = goodsSet.iterator();
			System.out.println("������Ʒ��ϢΪ:");
			while(itr.hasNext()) {
				System.out.println(itr.next());
			}
		}
	}
	
}
