/*
 *    while => while(true) :���ѷ��� 
 *    //for   => for(;;)  : ���ѷ��� 
 *    
 *    �ݺ����� ���� 
 *    ==========
 *      continue => Ư�������� ����
 *      break => �ݺ����� ���� 
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
public class �ݺ���2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        // while ==> 1~(����� �Է°�)������ ¦���� ��,Ȧ���� �� , ������ ���ؼ� ��� 
	    int sum=0,even=0,odd=0;
	    int i=1;
	    Scanner scan=new Scanner(System.in);
	    System.out.print("���� �Է�:");
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
	    
	    System.out.println("��:"+sum);
	    System.out.println("¦��:"+even);
	    System.out.println("Ȧ��:"+odd);
	    
	}

}










