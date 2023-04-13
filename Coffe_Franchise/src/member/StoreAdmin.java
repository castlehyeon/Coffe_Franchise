package member;

import store.Store;

import java.io.Serializable;

public class StoreAdmin extends Member implements NoneAdmin, Serializable {
	private Store store;

	public StoreAdmin(String ID, String password, String phoneNumber) {
		super(ID, password, phoneNumber);
		this.store = store;
	}

	public void createMenu() {}
	public void updateMenu() {}
	public void createStore() {}
	public void updateStore() {}
	public void deleteStore() {}
	public void storeSalesList() {}
}