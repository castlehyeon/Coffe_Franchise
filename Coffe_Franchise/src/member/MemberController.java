package member;

public class MemberController {
    public void start() {

        System.out.println("아이디와 비밀번호 입력하기");
        System.out.println("테스트 진행 id: aaa / pw: 1234 / phone: 0000");
        Customer customer = new Customer("aaa","1234","0000");
        customer.customerMainmenu();

    }
}
