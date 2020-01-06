/*
 *    클래스의 구성요소 
 *    ======================
 *      변수 (전역변수 , 멤버변수)
 *      => 다른 클래스에서 사용이 가능 
 *      => 메모리에서 해제되는 시점이 프로그램 종료시 
 *         (메모리 => heap)
 *    ======================
 *      생성자 : 멤버변수에 대한 초기화 담당 
 *      특징)
 *           1. 클래스명과 동일 
 *           2. 리턴형이 없다 (void는 리턴형)
 *           3. 생성자는 여러개를 만들 수 있고 
 *              사용하지 않을 수도 있다 ======> JVM이 자동으로 생성자를 생성 
 *           4. 오버로딩을 지원한다 
 *              ======
 *               1) 한개의 클래스안에서 같은 이름의 메소드를 여러개 사용 
 *                  =========
 *               2) 매개변수가 다르다 (매개변수의 데이터형이 다르다,갯수가 틀리면 다른 메소드로 인식)
 *               3) 리턴형은 관계없다 
 *                  void display()
 *                  int display(int a)
 *               4) 기능이 같다 
 *                  plusInt(int a,int b)
 *                  plusDouble(double d1,double d2) 
 *           5. 상속 예외 조건 (생성자,static)
 *    ======================
 *      ===> 명령문의 집합  => 관련된 명령을 모아서 처리 (구조적 프로그램)
 *       메소드 : 멤버변수를 활용 => 기능 
 *              연산처리 = 제어문 처리 
 *              => 사용자 요청을 처리 
 *    ======================
 *    
 *    
 */
public class MainClass {
    String name;
    String sex;
    int age;
    // 초기화 ==> MainClass mc=new MainClass()
	/*
	 * public MainClass() { // 초기화 ==> 윈도우 , 네트워크 , 데이터베이스 name="심청이"; sex="여자";
	 * age=25; }
	 */
    // 매개변수를 가지고 있는 생성자 
    //this.name="";
    public MainClass(String name,String sex,int age)
    {
    	// 지역변수 멤버변수 동일 ==> 지역변수가 우선 적용 
    	System.out.println("this="+this);
    	this.name=name;
    	this.sex=sex;
    	this.age=age;
    	// 자신의 객체주소 => this => 반드시 메소드안에서만 사용이 가능 
    	
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// int a=10
		MainClass mc1=new MainClass("이순신","남자",30);
		/*
		 *   MainClass.this=mc1;
		 */
		System.out.println("mc1="+mc1);
		System.out.println(mc1.name);
		System.out.println(mc1.sex);
		System.out.println(mc1.age);
		MainClass mc2=new MainClass("심청이","여자",20);
		/*
		 *   MainClass.this=mc2;
		 */
		System.out.println("mc2="+mc2);
		System.out.println(mc2.name);
		System.out.println(mc2.sex);
		System.out.println(mc2.age);
		MainClass mc3=new MainClass("강감찬","남자",35);
		/*
		 *   MainClass.this=mc3;
		 */
		System.out.println("mc3="+mc3);
		System.out.println(mc3.name);
		System.out.println(mc3.sex);
		System.out.println(mc3.age);
		
		System.out.println(new MainClass("박문수", "남자", 10).name);
		System.out.println(new MainClass("박문수", "남자", 10).sex);
		System.out.println(new MainClass("박문수", "남자", 10).age);
		//mc2.name="aaa"; // this => 200
		/*
		 * MainClass mc=new MainClass(); // static이 아님 변수는 저장공간을 별로로 만들어서 저장해야 한다 (new)
		 * // 생성자는 호출시에 반드시 new를 동반한다 //new MainClass(); System.out.println(mc.name);
		 * System.out.println(mc.sex); System.out.println(mc.age);
		 */
	}

}





