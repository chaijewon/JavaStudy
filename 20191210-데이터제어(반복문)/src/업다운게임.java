/*
 *    ��ǻ�� => 1~100������ ������ ���� ���� 
 *    
 *    ��Ʈ => UP / DOWN 
 *    
 *    78
 *    
 *    70 ==> UP
 *    
 *    80 ==> DOWN
 */
import java.util.Scanner;
public class ���ٿ���� {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        // ���� (������ ��)
		int com=(int)(Math.random()*100)+1; //1~100
		// 0.0 and less than 1.0.
		Scanner scan=new Scanner(System.in);
		while(true)
		{
			System.out.print("1~100������ ���� �Է�:");
			int user=scan.nextInt();
			// ���� 
			if(user<1 || user>100)
			{
				System.out.println("�߸��� �Է��Դϴ�!!");
				continue;// while=> ���ǽ����� �̵� 
				
			}
			
			// ó�� 
			if(com>user)
			{
				System.out.println("�Է°����� ū���� �Է��ϼ���");
			}
			else if(com<user)
			{
				System.out.println("�Է°����� �������� �Է��ϼ���");
			}
			else
			{
				System.out.println("Game Over!!");
				// ���� 
				break; // while���� ���� 
				//System.exit(0);
			}
			
		}
	}

}




