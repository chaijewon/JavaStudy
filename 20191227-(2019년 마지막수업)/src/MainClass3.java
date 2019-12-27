// 변수는 우선순위가 => 지역변수(지역변수,매개변수) {}이 종료하면 사라지는 변수 
class Sawon{
	int sabun;
	String name;
	String dept;
	String loc;
	long pay;
	static String company;	
}
public class MainClass3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Sawon s1=new Sawon();
        s1.sabun=1;
        s1.name="홍길동";
        s1.dept="개발부";
        s1.loc="서울";
        s1.pay=3500;
        s1.company="SIST";
        Sawon s2=new Sawon();
        s2.sabun=2;
        s2.company="SIST2";
        
        Sawon.company="SIST3";// 다른 클래스에서 사용 
        System.out.println("s1:"+s1.sabun);
        System.out.println("s2:"+s2.sabun);
        System.out.println(s1.company);
        System.out.println(s2.company);
        System.out.println(Sawon.company);
        
        
	}

}






