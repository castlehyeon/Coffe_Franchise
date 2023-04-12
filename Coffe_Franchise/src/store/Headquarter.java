package store;

import java.util.List;

import menu.Menu;

abstract class Headquarter {

	public List<Menu> menuList;					//메뉴
	private List<Store> storeList;				//가맹점들
	
	//생성자
	public Headquarter() {
	}

	//본사는 가맹점을 추가할 수 있다.
	private void addStore(Store store) {	
		storeList.add(store);
	}

	//본사는 메뉴를 추가할 수 있다.
	public void addMenu(Menu menu) {
		menuList.add(menu);
	}
	
	
	@Override
	public String toString() {
		return "본사의 메뉴리스트" + menuList.toString() + "\n 가맹점 리스트" + storeList.toString();
	}
	
	
}
