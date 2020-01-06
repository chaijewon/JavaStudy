/*
 *   자바(JAVA)의 상속(extends)
         # 부모 클래스(parent class) 와 자식 클래스(children class)는 
                      자바 지정예약어 extends에 의하여 정해집니다.
         # 하나의 부모 클래스(parent class)는 여러개의 자식 클래스(children)을 
                      가질 수 있습니다.
         # 반대로 하나의 클래스는 여러개의 클래스로부터 상속을 받을수는 없습니다.
         # 부모 클래스(parent class)로부터 상속받은 자식 클래스는 
                      부모 클래스의 자원(source) 모두를 사용 할 수 있습니다.
         # 반대로 부모클래스는 자식클래스의 자원을 가져다 쓸 수는 없습니다.
         # 자식클래스는 또다른 클래스의 부모 클래스가 될 수 있습니다. 
         # 자식클래스는 부모클래스로부터 물려받은 자원을 override 하여 수정해서 사용 할 수 있습니다.
         # 부모클래스가 상속받은 자원도 자식클래스가 사용 가능합니다.
 */
class 도형{
	public void draw() {
		System.out.println("도형 그린다");
	}
	// 추가 
}
class 원 extends 도형{
	public void draw() {
		System.out.println("원을 그린다");
	}
	// 추가 
}
class 삼각형 extends 도형{
	public void draw() {
		System.out.println("삼각형을 그린다");
	}
}
class 네모 extends 도형{
	public void draw() {
		System.out.println("네모를 그린다");
	}
}
// 라이브러리를 상속 => 변경해서 사용 
public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
                도형 m=new 네모();
        m.draw();
        
        m=new 삼각형();
        m.draw();
        
        m=new 원();
        m.draw();
        
        m=new 도형();
        m.draw();
        
	}

}
