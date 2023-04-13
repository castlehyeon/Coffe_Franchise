package global;

import java.util.HashMap;
import java.util.Scanner;
import java.util.regex.Pattern;

import member.AdminController;
import member.Customer;
import member.Member;
import member.MemberController;
import member.StoreAdmin;
import member.StoreOwner;
import member.StoreOwnerController;
import store.Headquarter;
import store.HeadquarterInfoManage;

public class Controller{

    Headquarter headquarter = new Headquarter();
    HeadquarterInfoManage headquarterInfoManage = new HeadquarterInfoManage();
    MemberController memberController= new MemberController();
    AdminController adminController = new AdminController();
    StoreOwnerController storeOwnerController = new StoreOwnerController();
    
    public void prepare() {
    	HashMap info = HeadquarterInfoManage.load();
		if(info!=null) {
			headquarterInfoManage.setHeadquarterInfoMap(info);
		}
    }
    public void start() {
    	adminController.setController(this);
    	memberController.setController(this);
    	storeOwnerController.setController(this);
    	Scanner sc = new Scanner(System.in);
    	boolean run = true;
    	headquarter.getStoreAdminList().add(new StoreAdmin("abc","aaaaaa1!","000-0000-0000"));
		System.out.println("***********이디야에 오신 것을 환영합니다.***********");
		System.out.println("1. 로그인하기 2. 회원가입하기 3. 종료하기 ");
		int temp = sc.nextInt();
		switch (temp) {
			case 1 : this.login();		break;	//로그인하기 
			case 2 : this.joinMember();	start(); break;	//회원가입하기
			case 3 :
				headquarterInfoManage.save();
				break;	//종료
			default: System.out.println("유효한 값을 입력해주세요.");start();
		}
    }
    
    //로그인
    public void login(){
    	Scanner sc = new Scanner(System.in);
    	try{
	    	System.out.println("*로그인*");
	    	System.out.print("아이디 입력 : ");
	    	String id = sc.nextLine();
	    	System.out.print("비밀번호 입력 : ");
	    	String pw = sc.nextLine();
	    	
	    	Member loginMember = headquarter.checkLogin(id,pw);
	    	if(loginMember != null) {
		    	if (loginMember instanceof Customer) {
		    		memberController.setCustomer((Customer)loginMember);
					memberController.start();
		    	}else if(loginMember instanceof StoreOwner) {
		    		storeOwnerController.setStoreOwner((StoreOwner)loginMember);
		    		storeOwnerController.start();
		    	}else if(loginMember instanceof StoreAdmin){
					adminController.setController(this);
		    		adminController.start();
		    	}else{
		    		start();
		    	}
	    	}else {
	    		System.out.println("로그인에 실패하였습니다."); this.start();
	    	}
    	}catch (Exception e){
          e.printStackTrace();
    	}
    }
    
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
        	chRun = headquarter.duplicateId(id);	//ID 중복검사
        }chRun = true;
        
        while(chRun) {
	        System.out.print("비밀번호 입력 (영문과 특수문자 숫자를 포함하며 8자 이상 입력해주세요): ");
	        pw = sc.nextLine();
	        chRun = !(Pattern.matches("^(?=.*[a-zA-Z])(?=.*\\d)(?=.*\\W).{8,20}$", pw));
	        if(chRun == true) {System.out.println("올바른 형식을 입력해주세요.");}
        }chRun = true;
        
        while(chRun) {
        	System.out.print("핸드폰번호 입력 : ");
        	phoneNum = sc.nextLine();
        	chRun = !(Pattern.matches("^(01\\d{1}|02|0505|0502|0506|0\\d{1,2})-?(\\d{3,4})-?(\\d{4})", phoneNum));	
        	if(chRun == true) {System.out.println("올바른 형식을 입력해주세요.");}
        }
        
        Member member = new Customer(id, pw, phoneNum);
        headquarter.getMemberList().add(member);
        
    }

}