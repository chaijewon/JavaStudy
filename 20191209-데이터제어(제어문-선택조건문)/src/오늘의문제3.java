/*
 *    1. if ~ else 
 *       ������ �Ѱ� �Է¹޾Ƽ� ¦��/Ȧ�� 
 *    2. ������ ���ĺ��� �޾Ƽ� �빮��/�ҹ��� (if~else)
 *       =====
 *       char a='A'
 *    3. ���� 3���� �Է��� �޾Ƽ� 
 *        ��� => 90�̻� => 'A'
 *              80�̻� => 'B'
 *              70�̻�=> 'C'
 *              60�̻� => 'D'
 *              ���� => 'F'
 *    
 */
import java.util.Scanner;
public class �����ǹ���3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Scanner scan=new Scanner(System.in);
        System.out.print("���� �Է�:");
        int num=scan.nextInt();
        
        if(num%2==0)
        	System.out.println("¦��");
        else
        	System.out.println("Ȧ��");
        
        char c='A';
        if(c>='A' && c<='Z')
        	System.out.println("�빮��");
        else
        	System.out.println("�ҹ���");
        
        System.out.print("���� ����:");
        int kor=scan.nextInt();
        
        System.out.print("���� ����:");
        int eng=scan.nextInt();
        
        System.out.print("���� ����:");
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





