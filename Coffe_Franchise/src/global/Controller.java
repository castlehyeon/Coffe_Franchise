package global;

import java.util.Scanner;

import member.Member;
import store.Headquarter;

public class Controller {

    Headquarter douzoneCoffee = new Headquarter();

    public void start() {
        Scanner sc = new Scanner(System.in);
        System.out.println("안녕하세요.");
        System.out.println(douzoneCoffee.getHeadquarterName() + "입니다.");

        System.out.println("1. 고객모드 2. 가맹점모드 3. 관리자모드 4. 회원가입");
        int temp = sc.nextInt();

        switch (temp) {
            case 1 :

                break;//고객모드
            case 2 :

                break;//가맹점모드
            case 3 :

                break;//관리자모드
            case 4 : joinMember();break;//회원가입
            case 0 : break;//종료
            default:
        }

    }

    //회원가입
    public void joinMember() {
        Scanner sc = new Scanner(System.in);

        System.out.println("============");
        System.out.println("회원가입");
        System.out.print("아이디 입력 : ");
        String id = sc.next();
        System.out.print("비밀번호 입력 : ");
        String pw = sc.next();
        System.out.print("핸드폰번호 입력 : ");
        String phoneNum = sc.next();

//        Member newMember = new adminMember(id,pw,phoneNum);
//        douzoneCoffee.addMember(newMember);
    }


}