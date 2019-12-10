import java.util.Scanner;

/*
 *    다중if <====> switch
 *    => Servlet <===> JSP ===> MVC ===> 틀(Spring)
 *    선택문 : 한개의 값을 받아서 처리 (한번만 수행 => break)
 *           게임,네트워크 ...
 *    형식)
 *                 1
 *         switch(정수) ===> 정수,문자,문자열
 *         {
 *            case 1:
 *              처리
 *              break;
 *            case 2:
 *              처리
 *            case 3:
 *              처리
 *              break;
 *            ============
 *            default:
 *              처리 
 *            ============ 생략이 가능 
 *         }
 *         
 *         if(score==10 || score==9) 'A'
 *         
 *         switch(정수)
 *         {
 *           case 10:
 *           case 9:
 *              'A'
 *         }
 */
public class 선택문 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		System.out.print("첫번째 정수:");
		int num1=scan.nextInt();
		
		System.out.print("두번째 정수:");
		int num2=scan.nextInt();
		
		System.out.print("연산자(+,-,*,/):");
		String op=scan.next();
		
		// 처리  ==> int , char , String
		switch(op) 
		{
		  case "+":
			 System.out.printf("%d+%d=%d\n",num1,num2,num1+num2);
			 break;
		  case "-":
			 System.out.printf("%d-%d=%d\n",num1,num2,num1-num2);
			  break;
		  case "*":
			  System.out.printf("%d*%d=%d\n",num1,num2,num1*num2);
			  break;
		  case "/":
			  if(num2==0)
				System.out.println("0으로 나눌 수 없습니다");
			  else
				System.out.printf("%d/%d=%.2f\n",num1,num2,num1/(double)num2);
			  break;
		  default:
			  System.out.println("잘못된 연산자입니다!!");
		}
	}

}





