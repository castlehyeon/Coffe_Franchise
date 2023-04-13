package member;

import store.Store;

public class StoreAdmin extends Member implements NoneAdmin {
	private Store store;
	
	public void createMenu() {}
	public void updateMenu() {}
	public void createStore() {}
	public void updateStore() {}
	public void deleteStore() {}
	public void storeSalesList() {}
}