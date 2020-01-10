import java.util.*;
public class MainClass2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
        ArrayList list = new ArrayList();
        // 이름 목록 
        list.add("홍길동"); // 0
        list.add("심청이"); // 1
        /*
         *  ===============
         *  add() // 2
         */
        list.add("박문수"); // 3
        list.add("춘향이"); // 4
        list.add("이순신"); // 5
        
        // 저장된 갯수 확인 
        System.out.println("저장된 인원:"+list.size());
        
        // 출력 
        for(int i=0;i<list.size();i++)
        {
            String name=(String)list.get(i);
            System.out.println(name);
        }
        /*
         *     list.add("홍길동"); // 0
               list.add("심청이"); // 1
               list.add("박문수"); // 3
               list.add("춘향이"); // 4
               list.add("이순신"); // 5
         *    
         */
        System.out.println("========================");
        // 추가 
        list.add("강감찬");
        
        /*
         *     list.add("홍길동"); // 0
               list.add("심청이"); // 1
               list.add("박문수"); // 2
               list.add("춘향이"); // 3
               list.add("이순신"); // 4
               list.add("강감찬"); // 5
         *    
         */
        // 출력 
        for(int i=0;i<list.size();i++)
        {
            String name=(String)list.get(i);
            System.out.println(name);
        }
        
        System.out.println("=======================");
        list.add(2,"김두한");
        
        /*
         *     list.add("홍길동"); // 0
               list.add("심청이"); // 1
               list.add(2,"김두한"); // 2
               list.add("박문수"); // 3
               list.add("춘향이"); // 4
               list.add("이순신"); // 5
               list.add("강감찬"); // 6
         *    
         */
        // 출력 
        for(int i=0;i<list.size();i++)
        {
            String name=(String)list.get(i);
            System.out.println(name);
        }
        
        System.out.println("=======================");
        // 삭제 
        list.remove(3);
        /*
         *     list.add("홍길동"); // 0
               list.add("심청이"); // 1
               list.add(2,"김두한"); // 2
               list.add("춘향이"); // 3
               list.add("이순신"); // 4
               list.add("강감찬"); // 5
         *    
         */
        for(int i=0;i<list.size();i++)
        {
            String name=(String)list.get(i);
            System.out.println(name);
        }
        
        System.out.println("==========================");
        // 수정 
        list.set(4, "이순신 수정");
        /*
         *     list.add("홍길동"); // 0
               list.add("심청이"); // 1
               list.add(2,"김두한"); // 2
               list.add("춘향이"); // 3
               list.add("이순신수정"); // 4
               list.add("강감찬"); // 5
         *    
         */
        for(int i=0;i<list.size();i++)
        {
            String name=(String)list.get(i);
            System.out.println(name);
        }
        
        System.out.println("=========================");
        // 문제 발생 
        list.add(100);
        
        for(int i=0;i<list.size();i++)
        {
            String name=(String)list.get(i);
            System.out.println(name);
        }
	}

}





