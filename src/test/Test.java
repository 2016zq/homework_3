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

	// 主菜单
	public void notice() {
		System.out.println("************************************************" + "\n"
				+ "                    **主菜单**                    " + "\n"
				+ "                    1--商品管理                                                           " + "\n"
				+ "                    2--购物车                                                               " + "\n"
				+ "                    0--退出                                                                   " + "\n"
				+ "************************************************");
		System.out.println("请输入对应数字进行操作:");
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
				System.out.println("该数字没有对应的操作!");
				notice();
			}
		}catch(InputMismatchException e) {
			System.out.println("请输入正确的格式!");
			sc.next();
			notice();
			return; 
		}catch(Exception e) {
			System.out.println("程序出错啦!你可以检查是否有该操作?请按要求输入哟~");
			notice();
			return;
		}
	}
	
	
	//商品管理
	public void goodsM() {
		System.out.println("************************************************" + "\n"
				+ "                  **商品管理**                    " + "\n"
				+ "                  1--商品信息导入                                                        " + "\n"
				+ "                  2--显示所有商品信息                                                " + "\n"
				+ "                  9--返回上一级菜单                                                    " + "\n"
				+ "************************************************");
		System.out.println("请输入对应的数字对商品进行管理:");
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
				System.out.println("该数字没有对应的操作!");
				goodsM();
			}
		}catch(InputMismatchException e) {
			System.out.println("请输入正确的格式!");
			sc.next();
			goodsM();
			return; 
		}catch(Exception e) {
			System.out.println("程序出错啦!你可以检查是否有该操作?请按要求输入哟~");
			goodsM();
			return;
		}
	}
	
	//购物车管理
	public void shopCar() {
		System.out.println("************************************************" + "\n"
				+ "                  **购物车管理**                   " + "\n"
				+ "                  1--添加商品到购物车                                                " + "\n"
				+ "                  2--修改购物车中的商品数量                                    " + "\n"
				+ "                  3--显示购物车中的所有商品信息                            " + "\n"
				+ "                  4--结算                                                                        " + "\n"
				+ "                  9--返回上一级菜单                                                    " + "\n"
				+ "************************************************");
		System.out.println("请输入对应的数字对购物车进行管理:");
		try {
			int input = sc.nextInt();
			switch(input) {
			case 1:
				if(gm.getGoodsSet().isEmpty()) {
					System.out.println("还没有商品，记得导入商品信息哟!");
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
					System.out.println("购物车是空的哟,赶快装满吧~");
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
				System.out.println("该数字没有对应的操作!");
				shopCar();
			}
		}catch(InputMismatchException e) {
			System.out.println("请输入正确的格式!");
			sc.next();
			shopCar();
			return; 
		}catch(Exception e) {
			System.out.println("程序出错啦!你可以检查是否有该操作?请按要求输入哟~");
			shopCar();
			return;
		}
	}
}
