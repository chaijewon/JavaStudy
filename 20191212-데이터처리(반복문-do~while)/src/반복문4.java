/*
 *    �ΰ��� ������ �Է¹޾Ƽ� 
 *    �ִ밪,�ּҰ�
 *    do~while
 *    
 *    10 30  ==> �ִ밪:30 , �ּҰ�:10
 */
import java.util.Scanner;
public class �ݺ���4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        int num1=0,num2=0;
        int i=1;
        Scanner scan=new Scanner(System.in);
        System.out.print("ù��° ����:");
		num1=scan.nextInt();
		System.out.print("�ι�° ����:");
		num2=scan.nextInt();
        do
        {
        	if(i==1)
        	{
        		System.out.print("ù��° ����:");
        		num1=scan.nextInt();
        	}
        	else
        	{
        		System.out.print("�ι�° ����:");
        		num2=scan.nextInt();
        	}
        	i++;
        }while(i<=2);
        
        if(num1>num2)
        	System.out.println("�ִ밪:"+num1+",�ּҰ�:"+num2);
        else
        	System.out.println("�ִ밪:"+num2+",�ּҰ�:"+num1);
        
        System.out.println("�ִ밪:"+(num1>num2?num1:num2)
        		+",�ּҰ�:"+(num1>num2?num1:num2));
        System.out.println("�ִ밪:"+(Math.max(num1, num2))
        		+",�ּҰ�:"+(Math.min(num1,num2)));
        	
	}

}






