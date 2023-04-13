package store;

import exception.ObjectNullException;
import member.Customer;
import member.Member;
import menu.Menu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HeadquarterInfoManage {
    // Flyweight 패턴을 적용하기 위해 객체 간 공유할 정보를 담는 Map
    private static Map<String, List<?>> headquarterInfoMap = new HashMap<>();


    //리스트를 뱉는 메서드
    public List<?> getMenus() {
        if (headquarterInfoMap.containsKey("menu")) {
            return headquarterInfoMap.get("menu");
        }
        //리스트가 생성되어있지 않다면 생성해서 반환.
        List<?> menus = createMenus();
        headquarterInfoMap.put("menu", menus);
        return menus;
    }

    //메뉴를 꺼내서 보여줌.
    public Menu getMenu(String name){
        Menu findMenu = null;
        // "menu" 키로 등록된 내부 객체가 이미 존재하면 해당 객체를 반환
        if (headquarterInfoMap.containsKey("menu")) {
            List<Menu> menuList = (List<Menu>) headquarterInfoMap.get("menu");
            //value값 중 동일한 이름의 메뉴가 있는지 확인
            for(Menu m : menuList){
                if(m.getMenuName().equals(name)) {
                    findMenu = m;
                }
            }

        }
        return  findMenu;
    }

    public void createMenu(String name, int price) {
        List<Menu> menuList = (List<Menu>) headquarterInfoMap.get("menu");
        Menu menu = new Menu(name, price);
        menuList.add(menu);
        headquarterInfoMap.put("menu", menuList);
    }
    

    public List<?> getMembers() {
        // "members" 키로 등록된 내부 객체가 이미 존재하면 해당 객체를 반환
        if (headquarterInfoMap.containsKey("members")) {
            return headquarterInfoMap.get("members");
        }

        // "members" 키로 등록된 내부 객체가 존재하지 않으면 새로 생성하고 등록 후 반환
        List<?> members = createMembers();
        headquarterInfoMap.put("members", members);
        return members;
    }
 
    //회원정보를 꺼내서 보여줌.
    public Member getMember(String id){
    	Member findMember = null;
        // "menu" 키로 등록된 내부 객체가 이미 존재하면 해당 객체를 반환
        if (headquarterInfoMap.containsKey("member")) {
            List<Member> memberList = (List<Member>) headquarterInfoMap.get("member");
            //value값 중 동일한 이름의 메뉴가 있는지 확인
            for(Member m : memberList){
                if(m.getID().equals(id)) {
                    findMember = m;
                }
            }

        }
        return  findMember;
    }
    
    public void createMember(String id, String password, String phoneNumber) {
        List<Member> memberList = (List<Member>) headquarterInfoMap.get("member");
        Member member = new Customer(id,password,phoneNumber);
        memberList.add(member);
        headquarterInfoMap.put("member", memberList);
    }
	
    public List<?> getStores() {
        // "stores" 키로 등록된 내부 객체가 이미 존재하면 해당 객체를 반환
        if (headquarterInfoMap.containsKey("stores")) {
            return headquarterInfoMap.get("stores");
        }

        // "stores" 키로 등록된 내부 객체가 존재하지 않으면 새로 생성하고 등록 후 반환
        List<?> stores = createStores();
        headquarterInfoMap.put("stores", stores);
        return stores;
    }

    // 실제로 객체를 생성하는 메서드, public으로 선언해도 될까
    // 이 메서드들은 Flyweight 패턴에서 호출

    private List<?> createMenus() {
        // 메뉴리스트 객체 생성 로직
        List<Menu> menuList = new ArrayList<>();
        return menuList;
    }
    private List<?> createMembers() {
    	List<Menu> memberList = new ArrayList<>();
        return memberList;
        // 멤버 객체 생성 로직
    }
    private List<?> createStores() {
    	List<Menu> storeList = new ArrayList<>();
        return storeList;
        // 상점 객체 생성 로직
    }
}
