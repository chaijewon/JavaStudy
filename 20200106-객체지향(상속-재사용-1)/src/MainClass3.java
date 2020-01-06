// 서로 다른 클래스를 연결해서 사용 (한개의 클래스를 이용해서 제어)
// 여러개의 클래스를 묶어서 한개의 객체로 제어 
abstract class 동물{
	abstract void 걷는다();// 선언  {}
	abstract void 먹는다();
	/*
	 * void display() { System.out.println("동물 표현!!!"); }
	 */
}
class 사람 extends 동물{

	@Override
	void 걷는다() {
		// TODO Auto-generated method stub
		System.out.println("사람처럼 걷는다");
	}

	@Override
	void 먹는다() {
		// TODO Auto-generated method stub
		System.out.println("수저로 먹는다");
	}
	
}
class 돼지 extends 동물{

	@Override
	void 걷는다() {
		// TODO Auto-generated method stub
		System.out.println("돼지처럼 걷는다");
	}

	@Override
	void 먹는다() {
		// TODO Auto-generated method stub
		System.out.println("돼지처럼 먹는다");
	}
	
}
class 소 extends 동물{

	@Override
	void 걷는다() {
		// TODO Auto-generated method stub
		System.out.println("소처럼 걷는다");
	}

	@Override
	void 먹는다() {
		// TODO Auto-generated method stub
		System.out.println("소처럼 먹는다");
	}
	
}
public class MainClass3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
               동물 a=new 사람();
        a.걷는다();
        a.먹는다();
        
        a=new 소();
        a.걷는다();
        a.먹는다();
        
        a=new 돼지();
        a.걷는다();
        a.먹는다();
        
	}

}
