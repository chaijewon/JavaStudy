/*
 *    컬렉션 
 *    =====
 *      데이터를 메모리에 저장하는 방법 , 표준화가 되는 상태 
 *                              ====== 인터페이스
 *      여러개 데이터를 쉽게 제어가 가능 
 *      가변 배열 => 데이터 갯수를 클래스에 제어
 *      
 *      * 단점 : 서로 다른 데이터타입을 저장 할 수 있다 => 데이터타입 통일 => 제네닐스 타입 
 *                                           ========
 *                                           <데이터타입>
 *                                           ========== 클래스형 
 *                                           <int> (X)
 *                                           <Integer> (O)
 *        *** 저장 => 같은 데이터형을 저장하는 것이 제어하기 편리하다
 *        
 *      종류 
 *               Collection
 *               ==========
 *                  | =================> Queue,Stack
 *            ==========================
 *            List          Set     Map   (interface)
 *             |             |       |
 *        ============   =========  ====     ==> (interface를 구현한 클래스)
 *        ***ArrayList     HashSet  Hashtable
 *        Vector           TreeSet  ***HashMap : Hashtable을 보완
 *        LinkedList                => key,value => 순서는 없다 
 *                                     key=> 중복허용하지 않는다
 *                                     value => 중복을 허용 
 *        * 순서를 가지고 있다   * 순서가 존재하지 않는다
 *        * 중복데이터를 허용    * 중복데이터를 허용하지 않는다
 *       =====================================================
 *         자료구조 => 메모리에 저장된 데이터관리 
 *                              =======
 *                              읽기 , 쓰기 , 검색 , 수정 , 삭제 
 *                              =========================
 *                              메소드 => 쓰기 => 
 *                                    add(데이터) *****
 *                                    add(index,데이터)
 *                                    읽기 => 
 *                                    get(index)
 *                                    수정 =>
 *                                    set(index,데이터) 
 *                                    삭제 =>
 *                                    remove(index) 
 *                                    remove(데이터)
 *                                    
 *        
 */
import java.util.*;
public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        ArrayList list=new ArrayList();
        // 추가 
        list.add("홍길동");
        list.add(30);
        list.add("서울");
        list.add("1111-1111");
        list.add(180.5);
        list.add("A");
        
        // 데이터 읽기
        String name=(String)list.get(0);
        int age=(int)list.get(1);
        String addr=(String)list.get(2);
        String tel=(String)list.get(3);
        double ki=(double)list.get(4);
        String aa=(String)list.get(5);
        
        System.out.println("이름:"+name);
        System.out.println("나이:"+age);
        System.out.println("주소:"+addr);
        System.out.println("전화:"+tel);
        System.out.println("키:"+ki);
        System.out.println("혈액형:"+aa);
	}

}







