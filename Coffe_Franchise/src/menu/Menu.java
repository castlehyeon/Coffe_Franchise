package menu;

import store.Headquarter;
import java.io.Serializable;

public class Menu implements Serializable {

	Headquarter headquarter =  new Headquarter();
	private int menuCode;
	private String menuName;
	private int menuPrice;
	
	//생성자 함수
	public Menu(String menuName, int menuPrice) {
		this.menuCode = headquarter.getMenuList().size()+1;
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
		return "[메뉴코드 : " + menuCode + ", 메뉴명 : " + menuName + ", 가격 : " + menuPrice + "]";
	}


}