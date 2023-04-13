package payment;

public class Cash extends Payment {
	private int inputMoney;
	
	public Cash(int inputMoney) {
		this.inputMoney = inputMoney;
	}
	
	public int returnChange() {
		return this.getPaymetAmount()-this.inputMoney;
	}

	public int getInputMoney() {
		return inputMoney;
	}

	public void setInputMoney(int inputMoney) {
		this.inputMoney = inputMoney;
	}
	
	

}
