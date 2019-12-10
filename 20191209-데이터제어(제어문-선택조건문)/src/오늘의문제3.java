/*
 *    1. if ~ else 
 *       정수를 한개 입력받아서 짝수/홀수 
 *    2. 임의의 알파벳을 받아서 대문자/소문자 (if~else)
 *       =====
 *       char a='A'
 *    3. 정수 3개를 입력을 받아서 
 *        평균 => 90이상 => 'A'
 *              80이상 => 'B'
 *              70이상=> 'C'
 *              60이상 => 'D'
 *              이하 => 'F'
 *    
 */
import java.util.Scanner;
public class 오늘의문제3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Scanner scan=new Scanner(System.in);
        System.out.print("정수 입력:");
        int num=scan.nextInt();
        
        if(num%2==0)
        	System.out.println("짝수");
        else
        	System.out.println("홀수");
        
        char c='A';
        if(c>='A' && c<='Z')
        	System.out.println("대문자");
        else
        	System.out.println("소문자");
        
        System.out.print("국어 점수:");
        int kor=scan.nextInt();
        
        System.out.print("영어 점수:");
        int eng=scan.nextInt();
        
        System.out.print("수학 점수:");
        int math=scan.nextInt();
        
        int avg=(kor+eng+math)/3;
        
        // 80+90+80 ==> 250/3 ==> 83...
        
        int res=avg/10; // 8
        
        if(res==10 || res==9)
        	System.out.println("A");
        if(res==8)
        	System.out.println("B");
        if(res==7)
        	System.out.println("C");
        if(res==6)
        	System.out.println("D");
        if(res<6)
        	System.out.println("F");
        
		/*
		 * switch (res) { case 10: case 9: System.out.println("A"); break; case 8:
		 * System.out.println("B"); break; case 7: System.out.println("C"); break; case
		 * 6: System.out.println("D"); break; default: System.out.println("F"); break; }
		 */
        
	}

}





