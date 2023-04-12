import store.Headquarter;

public class HeadquarterMain {

	public static void main(String[] args) {
	
		Headquarter douzoneCoffee = new Headquarter();
		
		System.out.println("로그인 됐다고 치고~");
		System.out.println("[관리자 모드로 로그인되었습니다.]");
		
		douzoneCoffee.headquarterMainMenu();	
	}

}
