package global;

import java.util.Scanner;
import java.util.regex.Pattern;

import member.Customer;
import member.Member;
import member.MemberController;
import member.StoreAdmin;
import member.StoreOwner;
import store.AdminController;
import store.Headquarter;
import store.StoreOwnerController;

public class Controller {

    Headquarter douzoneCoffee = new Headquarter();

    MemberController memberController= new MemberController();
    AdminController adminController = new AdminController();
    StoreOwnerController storeOwnerController = new StoreOwnerController();
    
    public void start() {
    	Scanner sc = new Scanner(System.in);
    	boolean run = true;
    	
		System.out.println("1. 로그인하기 2. 회원가입하기 3. 종료하기 ");
		int temp = sc.nextInt();
		switch (temp) {
			case 1 : this.login();		break;	//로그인하기 
			case 2 : this.joinMember();	start(); break;	//회원가입하기
			case 3 : break;	//종료
			default: System.out.println("유효한 값을 입력해주세요.");start();
		}
    }
    
    //로그인
    public void login(){
    	Scanner sc = new Scanner(System.in);
    	try{
	    	System.out.println("*로그인*");
	    	System.out.print("아이디 입력 : ");
	    	String id = sc.next();
	    	System.out.print("비밀번호 입력 : ");
	    	String pw = sc.next();
	    	
	    	Member loginMember = douzoneCoffee.checkLogin(id,pw);
	    	if(loginMember != null) {
		    	if (loginMember instanceof Customer) {
		    		memberController.start();
		    	}else if(loginMember instanceof StoreOwner) {
		    		storeOwnerController.start();
		    	}else if(loginMember instanceof StoreAdmin){
		    		adminController.start();
		    	}else{
		    		start();
		    	}
	    	}else {
	    		System.out.println("로그인에 실패하였습니다."); start();
	    	}
    	}catch (Exception e){
          e.printStackTrace();
    	}
    }
    
//    public void start() {
//        Scanner sc = new Scanner(System.in);
//
//        boolean stop = false;
//
//        System.out.println("안녕하세요.");
//        System.out.println(douzoneCoffee.getHeadquarterName() + "입니다.");
//        
//        do{
//        	try{
//		        System.out.println("1. 고객모드 2. 가맹점모드 3. 관리자모드 4. 로그인 5. 회원가입 0. 종료");
//		        int temp = sc.nextInt();
//		
//		            switch (temp) {
//		                case 1 ://고객모드
//		                    memberController.start();
//		                    break;
//		                case 2 ://가맹점모드
//		                    storeOwnerController.start();
//		                    break;
//		                case 3 ://관리자모드
//		                    adminController.start();
//		                    break;
//		                case 4 : //로그인
//		                	this.login();
//		                	break;
//		                case 5 ://회원가입
//		                    this.joinMember();
//		                    break;
//		                case 0 ://종료
//		                    stop = true;
//		                    break;
//		                default:
//		            }
//            }catch (Exception e){
//                e.printStackTrace();
//            }
//
//        }while(!stop);
//
//    }

    //회원가입
    public void joinMember() {
        Scanner sc = new Scanner(System.in);
        boolean chRun = true;
        String id = "";
        String pw = "";
        String phoneNum = "";
        
        System.out.println("============");
        System.out.println("회원가입");
        
        while(chRun) {
        	System.out.print("아이디 입력 : ");
        	id = sc.next();
        	chRun = douzoneCoffee.duplicateId(id);	//ID 중복검사
        }chRun = true;
        
        while(chRun) {
	        System.out.print("비밀번호 입력 (영문과 특수문자 숫자를 포함하며 8자 이상 입력해주세요): ");
	        pw = sc.next();
	        chRun = !(Pattern.matches("^(?=.*[a-zA-Z])(?=.*\\d)(?=.*\\W).{8,20}$", pw));
	        if(chRun == true) {System.out.println("올바른 형식을 입력해주세요.");}
        }chRun = true;
        
        while(chRun) {
        	System.out.print("핸드폰번호 입력 : ");
        	phoneNum = sc.next();
        	chRun = !(Pattern.matches("^(01\\d{1}|02|0505|0502|0506|0\\d{1,2})-?(\\d{3,4})-?(\\d{4})", phoneNum));	
        	if(chRun == true) {System.out.println("올바른 형식을 입력해주세요.");}
        }
        
        Member newMember = new Customer(id,pw,phoneNum);
        douzoneCoffee.addMember(newMember);
    }
    
}