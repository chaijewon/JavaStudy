/*
 *   클래스 
 *   =====
 *     일반 클래스 : 메소드+변수+생성자 
 *     추상 클래스 : 메소드+변수+생성자 ==> 미완성 클래스
 *               ====== 구현된 메소드 + 미구현된 메소드 
 *               항상 상속을 내려서 사용 
 *               => 자체 메모리 할당을 할 수 없다 (new를 사용할 수 없다)
 *     public abstract class A
 *       A a=new A(); => error
 *     public class B extends A
 *       A a=new B(); ==> 추상클래스 , 인터페이스를 구현한 클래스 
 *       B b=new B();
 *     ========= 
 *     인터페이스 : 추상클래스의 일종  =========> 상속 + 오버라이딩
 *               메소드 + 변수 (상수형 변수)
 *               =====
 *               구현이 안된 메소드만 존재 
 *               
 *     인터페이스  ========> 인터페이스 (다중 가능)
 *              extends 
 *     인터페이스  ========> 클래스
 *              implements
 *     클래스        ========> 인터페이스 
 *               error
 *               
 *               
 *     class A
 *     class C
 *     class B extends A,C(X)
 *     
 *     class A
 *     class B extends A
 *     class C extends B
 *     
 *     interface A
 *     interface B
 *     interface C extends A,B
 *     
 *     ==============================
 *                추상클래스        인터페이스
 *     ==============================
 *      상속               단일 상속         다중 상속
 *     ==============================
 *      메소드     구현된 메소드          미구현된 메소드
 *             + 미구현된 메소드
 *     ==============================
 *      변수       일반 변수                상수형 변수 사용 
 *     ==============================
 *      사용처    => 여러개의 관련된 클래스가 존재 => 묶어서 한개의 이름 제어
 *               서로 다른 클래스를 연결해서 사용하는 경우 
 *     ==============================
 *     키워드     =>  extends     implements 
 *     
 *     ====> JDK 1.8 변경된 내용이 있다 
 *           인터페이스에 구현된 메소드도 사용이 가능 
 */
public class MainClass5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
