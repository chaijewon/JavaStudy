/*
 *    5���� ������ �޾Ƽ� 
 *    �ִ밪,�ּҰ�...
 *    
 *    1) ���� 
 *       int a,b,c,d,e ==> ���� (�Ѱ��� ��Ƽ� ó��) => �迭
 *       int max,min
 */
import java.util.Scanner;
public class �迭9 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Scanner scan=new Scanner(System.in);
        int[] arr=new int[5];
        // �� �Է� 
        for(int i=0;i<5;i++)
        {
        	arr[i]=(int)(Math.random()*100)+1;
        }
        int max=0;
        int min=100;
        
        // ó�� => �ִ밪,�ּҰ�
        for(int i:arr)
        {
        	if(max<i)
        		max=i;
        	if(min>i)
        		min=i;
        }
        
        // ��� 
        for(int i:arr)
        {
        	System.out.print(i+"  ");
        }
        System.out.println();
        System.out.println("Max:"+max);
        System.out.println("Min:"+min);
	}

}



