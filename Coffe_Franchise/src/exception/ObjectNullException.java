package exception;

public class ObjectNullException extends Exception {
    public ObjectNullException(String a) {
        super(a);
    }
}


//} catch (ObjectNullException e) {
//        System.out.println(e.getMessage());
//        }


//유효성 검사
//        if (findMenu == null) {
//                throw new ObjectNullException("음수 값 입력 금지");
//                }
