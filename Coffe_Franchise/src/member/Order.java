package member;

import menu.Menu;

public class Order {
	private int menuCount;
	private Menu menu;
	
	Order(int menuCount, Menu menu) {
		this.menuCount = menuCount;
		this.menu = menu;
	}
	
	public int getMenuCount() {
		return menuCount;
	}
	public void setMenuCount(int menuCount) {
		this.menuCount = menuCount;
	}
	public Menu getMenu() {
		return menu;
	}
	public void setMenu(Menu menu) {
		this.menu = menu;
	}	
	
	//
	// t
	//
}
