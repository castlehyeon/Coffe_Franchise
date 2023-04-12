package global;

import java.util.Scanner;

import member.MemberController;
import store.Headquarter;
import store.AdminController;
import store.StoreOwnerController;

public class Controller {

    Headquarter douzoneCoffee = new Headquarter();
    MemberController memberController= new MemberController();
    AdminController adminController = new AdminController();
    StoreOwnerController storeOwnerController = new StoreOwnerController();
    public void start() {
        Scanner sc = new Scanner(System.in);

        boolean stop = false;

        System.out.println("안녕하세요.");
        System.out.println(douzoneCoffee.getHeadquarterName() + "입니다.");
        do{
            try{

        System.out.println("1. 고객모드 2. 가맹점모드 3. 관리자모드 4. 회원가입 0. 종료");
        int temp = sc.nextInt();

            switch (temp) {
                case 1 :
                    memberController.start();
                    break;//고객모드
                case 2 :
                    storeOwnerController.start();
                    break;//가맹점모드
                case 3 :
                    adminController.start();
                    break;//관리자모드
                case 4 :
                    joinMember();break;//회원가입
                case 0 :
                    stop = true;
                    break;//종료
                default:
            }
            }catch (Exception e){
                e.printStackTrace();
            }


        }while(!stop);


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