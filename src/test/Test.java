package test;

import java.util.*;

import model.*;

public class Test {
	private static Scanner sc = new Scanner(System.in);
	private static GoodsManage gm = new GoodsManage();
	private static ShoppingCart shoppingCart = new ShoppingCart();
	public static void main(String[] args) {
		Test ts = new Test();
		ts.notice();
	}

	// ���˵�
	public void notice() {
		System.out.println("************************************************" + "\n"
				+ "                    **���˵�**                    " + "\n"
				+ "                    1--��Ʒ����                                                           " + "\n"
				+ "                    2--���ﳵ                                                               " + "\n"
				+ "                    0--�˳�                                                                   " + "\n"
				+ "************************************************");
		System.out.println("�������Ӧ���ֽ��в���:");
		try {
			int input = sc.nextInt();
			switch(input) {
			case 1:
				goodsM();
			case 2:
				shopCar();
			case 0:
				System.exit(0);
			default:
				System.out.println("������û�ж�Ӧ�Ĳ���!");
				notice();
			}
		}catch(InputMismatchException e) {
			System.out.println("��������ȷ�ĸ�ʽ!");
			sc.next();
			notice();
			return; 
		}catch(Exception e) {
			System.out.println("���������!����Լ���Ƿ��иò���?�밴Ҫ������Ӵ~");
			notice();
			return;
		}
	}
	
	
	//��Ʒ����
	public void goodsM() {
		System.out.println("************************************************" + "\n"
				+ "                  **��Ʒ����**                    " + "\n"
				+ "                  1--��Ʒ��Ϣ����                                                        " + "\n"
				+ "                  2--��ʾ������Ʒ��Ϣ                                                " + "\n"
				+ "                  9--������һ���˵�                                                    " + "\n"
				+ "************************************************");
		System.out.println("�������Ӧ�����ֶ���Ʒ���й���:");
		try {
			int input = sc.nextInt();
			switch(input) {
			case 1:
				gm.importGoods();
				goodsM();
				return;
			case 2:
				gm.displayAllGoods();
				goodsM();
				return;
			case 9:
				notice();
			default:
				System.out.println("������û�ж�Ӧ�Ĳ���!");
				goodsM();
			}
		}catch(InputMismatchException e) {
			System.out.println("��������ȷ�ĸ�ʽ!");
			sc.next();
			goodsM();
			return; 
		}catch(Exception e) {
			System.out.println("���������!����Լ���Ƿ��иò���?�밴Ҫ������Ӵ~");
			goodsM();
			return;
		}
	}
	
	//���ﳵ����
	public void shopCar() {
		System.out.println("************************************************" + "\n"
				+ "                  **���ﳵ����**                   " + "\n"
				+ "                  1--�����Ʒ�����ﳵ                                                " + "\n"
				+ "                  2--�޸Ĺ��ﳵ�е���Ʒ����                                    " + "\n"
				+ "                  3--��ʾ���ﳵ�е�������Ʒ��Ϣ                            " + "\n"
				+ "                  4--����                                                                        " + "\n"
				+ "                  9--������һ���˵�                                                    " + "\n"
				+ "************************************************");
		System.out.println("�������Ӧ�����ֶԹ��ﳵ���й���:");
		try {
			int input = sc.nextInt();
			switch(input) {
			case 1:
				if(gm.getGoodsSet().isEmpty()) {
					System.out.println("��û����Ʒ���ǵõ�����Ʒ��ϢӴ!");
					goodsM();
					return;
				}
				else {
					gm.displayAllGoods();
					shoppingCart.addGoodsToCart(gm);
					shopCar();
					return;
				}
			case 2:
				if(shoppingCart.getShoppingCart().isEmpty()) {
					System.out.println("���ﳵ�ǿյ�Ӵ,�Ͽ�װ����~");
				}else {
					shoppingCart.updateNumInCart();
				}
				shopCar();
				return;
			case 3:
				shoppingCart.displayAllInCart();
				shopCar();
				return;
			case 4:
				shoppingCart.settleAccounts();
				shopCar();
				return;
			case 9:
				notice();
			default:
				System.out.println("������û�ж�Ӧ�Ĳ���!");
				shopCar();
			}
		}catch(InputMismatchException e) {
			System.out.println("��������ȷ�ĸ�ʽ!");
			sc.next();
			shopCar();
			return; 
		}catch(Exception e) {
			System.out.println("���������!����Լ���Ƿ��иò���?�밴Ҫ������Ӵ~");
			shopCar();
			return;
		}
	}
}
