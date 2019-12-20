/*
 *   메소드 
 *   =====
 *     자바 (객체지향  => 클래스) : 클래스 구성요소 (변수,메소드)
 *                                           =======
 *                                           연산자+제어문
 *   형식)
 *        리턴형(처리결과값) 메소드명(매개변수...) ==>선언부
 *        ============== ======
 *          기본형                 약속 : 소문자 (헝거리언식)
 *          =======            getText() ==> nextInt()
 *                             class Name{} => Name name
 *                             
 *                             class A
 *                             {
	 *                             if()
	 *                             {
	 *                             }
	 *                             else
	 *                             {
	 *                             }
 *                             }
 *          배열형
 *          클래스형 
 *          ======= 결과값이 여러개 
 *        {
 *            ==> 구현부 
 *            연산처리 
 *            제어문 
 *            
 *            return 결과값 ==> void(생략이 가능) => JVM이 자동으로 return추가
 *        }
 *        
 *        ** return 값은 => 1개 설정이 가능 
 *           여러개일 경우 ====> 묶어서 보내준다 
 *        ** 모든 메소드는 return이 있으면 종료 한다 
 *        
 *        ------------------------
 *        ** 사용자가 요청한 값?
 *           처리 결과 
 *           
 *        ** 호출 (어느 시기)
 *        ------------------------
 *        
 *        
 *        
 */
import java.util.Scanner;
public class 메소드1 {
    // +
	static int plus(int a,int b)
	{
		return a+b;
	}
	// -
	static int minus(int a,int b)
	{
		return a-b;
	}
	// *
	static int gop(int a,int b)
	{
		return a*b;
	}
	// /
	static double div(int a,int b)
	{
		return a/(double)b;
	}
	// 계산기 
	static void process()
	{
		Scanner scan=new Scanner(System.in);
		System.out.print("첫번째 정수 입력:");
		int a=scan.nextInt();
		
		System.out.print("두번째 정수 입력:");
		int b=scan.nextInt();
		
		System.out.print("연산자(+,-,*,/)입력:");
		String op=scan.next();
		
		switch(op)
		{
		case "+":
		{
			int res=plus(a,b);
			System.out.printf("%d%s%d=%d\n",a,op,b,res);
		}
			break;
		case "-":
		{
			int res=minus(a,b);
			System.out.printf("%d%s%d=%d\n",a,op,b,res);
		}
			break;
		case "*":
		{
			int res=gop(a,b);
			System.out.printf("%d%s%d=%d\n",a,op,b,res);
		}
			break;
		case "/":
		{
			double res=div(a,b);
			System.out.printf("%d%s%d=%f\n",a,op,b,res);
		}
			break;
		}
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Scanner scan=new Scanner(System.in);
        while(true)
        {
		   process();
		   System.out.print("y|n 입력:");
		   String ex=scan.next();
		   switch(ex)
		   {
		   case "y":
			   System.exit(0);
			   break;
		   case "n":
			   break;
		   }
	}

	}
}





