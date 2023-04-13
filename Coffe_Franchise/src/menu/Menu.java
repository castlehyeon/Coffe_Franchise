package menu;

import java.io.Serializable;

public class Menu implements Serializable {

	private int menuCode;
	private String menuName;
	private int menuPrice;
	
	//생성자 함수
	public Menu(String menuName, int menuPrice) {
		this.menuCode = menuCode+1;
		this.menuName = menuName;
		this.menuPrice = menuPrice;
	}

	
	public int getMenuCode() {
		return menuCode;
	}

	public void setMenuCode(int menuCode) {
		this.menuCode = menuCode;
	}

	public String getMenuName() {
		return menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	public int getMenuPrice() {
		return menuPrice;
	}


	public void setMenuPrice(int menuPrice) {
		this.menuPrice = menuPrice;
	}


	@Override
	public String toString() {
		return "Menu [menuCode=" + menuCode + ", menuName=" + menuName + ", menuPrice=" + menuPrice + "]";
	}


}