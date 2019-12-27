/*
 *     자바 (클래스가 여러개)==> 한 파일 , 별도로 파일일 만들어서 사용 
 *     한개의 파일에서 사용 
 *     ==============
 *     class A
 *     class C
 *     class D
 *     public class B 
 *     =============== B.java (public클래스는 한개만 존재)
 *     class A
 *     class B
 *     ======== 
 */
class News{
    public String title;
	protected String content;
	String author;
	String regdate;
	static String site;
	//선언문 할 수 있는 영역
}// News데이터형 
// 조립기 
public class MainClass {
    class A
    {
    	// 내부 클래스 
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        // 저장 => 통으로 저장 
		// 메모리 만들기 
		News n1=new News();
		n1.title="\"8일째 1위\"..'백두산', 450만명 돌파..'천문' 개봉 첫날 14만 흥...";
		n1.content="[OSEN=하수정 기자] 영화 '백두산'이 성탄절에 이어 문화의 날에도 흥행 정상을 지켰고, '천문: 하늘에 묻는다'가 첫날 2위에 오르며   박스오피스 판도가 또 바뀌었다.";
	    n1.author="OSEN";
	    n1.regdate="19.12.27";
	    
	    News n2=new News();
	    // int a=10; a=20;
	    n2.title="진선규·성유빈 영화 '카운트' 캐스팅";
		n2.content="[OSEN=하수정 기자] 영화 '백두산'이 성탄절에 이어 문화의 날에도 흥행 정상을 지켰고, '천문: 하늘에 묻는다'가 첫날 2위에 오르며   박스오피스 판도가 또 바뀌었다.";
	    n2.author="OSEN";
	    n2.regdate="19.12.27";
	    
	    // 출력 
	    /*
	     *   int a=10;
	     *   
	     */
	    System.out.println(n1.title);
	    System.out.println(n2.title);
	    
	}

}








