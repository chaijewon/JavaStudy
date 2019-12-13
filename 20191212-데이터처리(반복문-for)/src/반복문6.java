/*
 *    알파벳을 대문자 
 *     DDD  ==> AAA
 *     ZZZ  ==> WWW
 */
import java.util.Scanner;
public class 반복문6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Scanner scan=new Scanner(System.in);
        
        System.out.println("대문자여러개 입력:");
        String data=scan.next();
        
        for(int i=0;i<data.length();i++)
        {
        	char c=data.charAt(i);
        	
        	System.out.print((char)(c-3));
        }
        
	}

}






