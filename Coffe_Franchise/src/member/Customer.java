package member;

import java.util.List;

import menu.Menu;

public class Customer extends Member implements NoneAdmin {
	private int gifticon;
	private int stamp;
	private List<Order> orders;
	
	// 주문 수량과 메뉴를 받아 Customer의 주문 리스트에 저장
	public void orderMenu(int menuCount, Menu menu) {
		Order order = new Order(menuCount, menu);
		this.orders.add(order);
		System.out.printf("메뉴 %s %d개가 장바구니에 추가되었습니다.\n", menu.getMenuName(), menuCount);
	}
	
	// 주문 리스트에 있는 메뉴의 갯수만큼 스탬프 추가
	public void saveStamp() {
		int addStamp = this.orders.size();
		System.out.printf("현재 스탬프는 %d개 입니다.\n", this.stamp);
		this.stamp += addStamp;
		System.out.printf("총 %d개 적리되어 현재 스탬프는 %d개 입니다.\n", addStamp, this.stamp);
	}
	
	// 기프티콘 생성
	public void createGifticon() {
		
	}
} 
