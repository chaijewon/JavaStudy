/*
 *    5개의 정수를 받아서 
 *    최대값,최소값...
 *    
 *    1) 변수 
 *       int a,b,c,d,e ==> 같다 (한개로 모아서 처리) => 배열
 *       int max,min
 */
import java.util.Scanner;
public class 배열9 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Scanner scan=new Scanner(System.in);
        int[] arr=new int[5];
        // 값 입력 
        for(int i=0;i<5;i++)
        {
        	arr[i]=(int)(Math.random()*100)+1;
        }
        int max=0;
        int min=100;
        
        // 처리 => 최대값,최소값
        for(int i:arr)
        {
        	if(max<i)
        		max=i;
        	if(min>i)
        		min=i;
        }
        
        // 출력 
        for(int i:arr)
        {
        	System.out.print(i+"  ");
        }
        System.out.println();
        System.out.println("Max:"+max);
        System.out.println("Min:"+min);
	}

}



