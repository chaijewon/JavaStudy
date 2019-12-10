/*
 *    while => while(true) :무한루프 
 *    //for   => for(;;)  : 무한루프 
 *    
 *    반복문을 제어 
 *    ==========
 *      continue => 특정내용을 제외
 *      break => 반복문을 종료 
 *      
 *      1~10  ==> 7 9
 *      
 *      for(int i=1;i<=10;i++)
 *      {
 *          if(i==7 || i==9)
 *            continue; ==> i++
 *            
 *          if(i==9)
 *             break;
 *      }
 */
import java.util.Scanner;

import com.sun.org.apache.xalan.internal.xsltc.compiler.sym;
public class 반복문2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        // while ==> 1~(사용자 입력값)까지의 짝수의 합,홀수의 합 , 총합을 구해서 출력 
	    int sum=0,even=0,odd=0;
	    int i=1;
	    Scanner scan=new Scanner(System.in);
	    System.out.print("정수 입력:");
	    int user=scan.nextInt();
	    while(i<=user)
	    {
	    	sum+=i;
	    	if(i%2==0)
	    		even+=i;
	    	else
	    		odd+=i;
	    	
	    	i++;
	    }
	    
	    System.out.println("합:"+sum);
	    System.out.println("짝수:"+even);
	    System.out.println("홀수:"+odd);
	    
	}

}










