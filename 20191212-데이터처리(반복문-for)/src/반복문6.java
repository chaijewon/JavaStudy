/*
 *    ���ĺ��� �빮�� 
 *     DDD  ==> AAA
 *     ZZZ  ==> WWW
 */
import java.util.Scanner;
public class �ݺ���6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Scanner scan=new Scanner(System.in);
        
        System.out.println("�빮�ڿ����� �Է�:");
        String data=scan.next();
        
        for(int i=0;i<data.length();i++)
        {
        	char c=data.charAt(i);
        	
        	System.out.print((char)(c-3));
        }
        
	}

}






