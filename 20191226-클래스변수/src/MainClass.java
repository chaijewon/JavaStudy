/*
 *     변수 => 발전 사항  ==> 클래스 (변수,변수+메소드,메소드)
 *                       =========
 *                       ~VO , ~DTO  
 *                       ~Manager , ~Service , ~DAO
 *     =============
 *       변수 ==> 배열  ==> 구조체  ==> 클래스 ==> 파일 ===> RDBMS(오라클)
 *                       (X)
 *       ===================================================== 데이터베이스 
 *     자바 클래스 구조 (구성요소 : 변수 + 메소드 + 생성자)
 *                               =====
 *     변수로 사용이 가능한 것 :  단일변수 => int year,month...
 *                        클래스  => String name...
 *                                JButton b1,b2...
 *                        배열  => 
 *     => 컴포넌트 베이스 
 *        예) 컴퓨터 구조 
 *           CPU , 메모리 , 하드디스크 , 사운드 카드 ....(컴포넌트)
 *     class ClassName
 *     {
 *        =====클래스만 가지고 있는 변수======== 전역변수 (다른 클래스에서 사용이 가능)
 *         => 메모리에 따로 저장되는 변수(instance 변수) 
 *         => 공유하는 변수 (static변수) => 메모리 공간이 한개 
 *        =============================== 
 *         생성자 함수 : 전역변수의 초기화 ==> 한번만 호출 , 객체생성될때 처음으로 호출 
 *         윈도우 , 네트워크 , 데이터베이스 
 *         클래스명과 동일 , 리턴형이 없다 
 *         ==> 만약에 생성자가 없는 경우에는 JVM이 자동으로 만들어 준다 (default생성자)
 *        ===============================
 *         메소드 : 기능 수행 
 *        ===============================
 *     }
 *     
 *     클래스명 ==> MovieVO => 클래스 (String , 배열
 *               MusicVO
 *               RecipeVO
 *               FoodHouseVO 
 *               ============ 따로 저장 
 *               
 *               class FoodHouseVO{
 *                 String[] poster;
 *                 String addr,tel,...
 *                 String[] menu;
 *                 String[] reply;
 *                 
 *               }
 *               
 *              백두산 (2019)
				평점6.9/10
				드라마/액션
				2019.12.19 개봉
				128분, 12세이상관람가
				(감독) 이해준, 김병서
				(주연) 이병헌, 하정우, 마동석, 전혜진, 수지
				
				
				class MovieVO
				=> 사용자가 만든 데이터형 
				=> int a
				   double d
				   ============== 컴퓨터가 메모리 크기 인식 
				   MovieVO vo   malloc(sizeOf(MovieVO))
				   ========== 메모리 크기를 알 수 없다 
				              메모리 크기 확인 => 메모리를 생성 
				       ========================= new
 */
class MovieVO{
	// instance변수 ==> 메모리에 저장되는 시점 ==> new(새로운 메모리를 만들때 => 따로 메모리 생성)
	String title;
	double score;
	String genre;
	String regdate;
	int time;
	String grade;
	String director;
	String actor;
	String singer;
}
public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        // 메모리 저장 => 호출 연습 
		MovieVO m1=new MovieVO();
		m1.title="백두산 (2019)";
		// . (메모리 주소 접근 연산자)
		MovieVO m2=new MovieVO();
		m2.title="천문: 하늘에 묻는다";
		MovieVO m3=new MovieVO();
		m3.title="캣츠 (2019)";
		
		MovieVO m4=m3;
		m4.title="시동 (2019)";
		
		System.out.println("m1:"+m1);
		System.out.println("m2:"+m2);
		System.out.println("m3:"+m3);
		System.out.println("m4:"+m4);
		
		System.out.println("저장된 영화 제목");
		System.out.println(m1.title);
		System.out.println(m2.title);
		//////////////////////////////
		System.out.println(m3.title);
		System.out.println(m4.title);
		
		MovieVO[] vo= {m1,m2,m3,m4};
		for(int i=0;i<vo.length;i++)
		{
			System.out.println(vo[i].title);
		}
	}

}






