/*
 *   �������ǹ� : �������� ������ �����ϰ� �ش� ���� 1���� ������ �ǰ� ����� 
 *   1) ���� 
 *       if(���ǹ�) 
 *         ���๮��1   => true => ���๮��1�� �����ϰ� ���� 
 *                   => false
 *                   �ٷ� �ؿ� ���ǹ����� �̵� 
 *       else if(���ǹ�)
 *         ���๮��2
 *       else if(���ǹ�)
 *         ���๮��3 
 *       ==============
 *       else
 *         ���� ����4
 *       ============== �ش� ������ ���� ��쿡 ó�� (������ ����)
 */
// ���� ó�� 
// 3���� ������ �޾Ƽ� => ������ ���,����� ��� , ������ ��� 
import java.util.Scanner;
public class �������ǹ� {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        // �ʿ��� ���� ���� 
		int kor,eng,math,total,temp;
		double avg;
		char score;
		
		// �Է��� �޴´� 
		Scanner scan=new Scanner(System.in);
		// new : �޸� �Ҵ� 
		// Scanner(System.in) : ������ ���� �ʱ�ȭ (������)
		// Ŭ���� => ����� ���� �������� (����+�޼ҵ�)
        System.out.print("��������:");
        kor=scan.nextInt();
        
        System.out.print("��������:");
        eng=scan.nextInt();
        
        System.out.print("��������:");
        math=scan.nextInt();
		
		// ����
        total=kor+eng+math;
        // ���
        avg=total/3.0;
        
        temp=(int)avg;// total/3
        // ����
        
        if(temp>=90)
        	score='A';
        else if(temp>=80)
        	score='B';
        else if(temp>=70)
        	score='C';
        else if(temp>=60)
        	score='D';
        else
        	score='F';
        
        System.out.println("����:"+total);
        System.out.printf("���:%.2f\n",avg);
        System.out.println("����:"+score);
        
	}

}





