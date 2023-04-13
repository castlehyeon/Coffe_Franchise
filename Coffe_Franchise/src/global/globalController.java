package global;

import java.util.Scanner;
import java.util.regex.Pattern;

import member.Member;
import member.adminMember;
import store.Headquarter;

public class globalController {

	Headquarter douzoneCoffee = new Headquarter();

	public void start() {
		Scanner sc = new Scanner(System.in);
		System.out.println("안녕하세요.");
		System.out.println(douzoneCoffee.getHeadquarterName() + "입니다.");
		
		System.out.println("1. 고객모드 2. 가맹점모드 3. 관리자모드 4. 회원가입");
		int temp = sc.nextInt();

		switch (temp) {
			case 1 : System.out.println("고객모드 개발중"); 		break;//고객모드
			case 2 : System.out.println("가맹점모드 개발중"); 	break;//가맹점모드
			case 3 : douzoneCoffee.headquarterMainMenu(); 	break;//관리자모드
			case 4 : joinMember();							break;//회원가입
			case 0 : break;//종료
			default:
		}
	}

	//회원가입
    public void joinMember() {
        Scanner sc = new Scanner(System.in);
        boolean chkIdRun = true;
        boolean chkPwRun = true;
        boolean chkPhoneNumRun = true;
        String id = "";
        String pw = "";
        String phoneNum = "";
        
        System.out.println("============");
        System.out.println("회원가입");
        
        while(chkIdRun) {
        	System.out.print("아이디 입력 : ");
        	id = sc.next();
        	chkIdRun = douzoneCoffee.duplicateId(id);	//ID 중복검사
        }
        
        while(chkPwRun) {
	        System.out.print("비밀번호 입력 (영문과 특수문자 숫자를 포함하며 8자 이상 입력해주세요): ");
	        pw = sc.next();
	        chkPwRun = !(Pattern.matches("^(?=.*[a-zA-Z])(?=.*\\d)(?=.*\\W).{8,20}$", pw)); //형식검사
	        if(chkPhoneNumRun == true) {System.out.println("올바른 형식을 입력해주세요.");}
        }
        
        while(chkPhoneNumRun) {
        	System.out.print("핸드폰번호 입력 : ");
        	phoneNum = sc.next();
        	chkPhoneNumRun = !(Pattern.matches("^01(?:0|1|[6-9]) - (?:\\d{3}|\\d{4}) - \\d{4}$", phoneNum));//형식검사
        	if(chkPhoneNumRun == true) {System.out.println("올바른 형식을 입력해주세요.");}
        }
        
        Member newMember = new adminMember(id,pw,phoneNum);
        douzoneCoffee.addMember(newMember);
    }

		

}
