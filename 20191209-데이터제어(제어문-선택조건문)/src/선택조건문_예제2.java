// ��ǻ�� ���� , ����� �Է�  ==> ����,����,�� 
import java.util.Scanner;
public class �������ǹ�_����2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        // 0,1,2
		int com=(int)(Math.random()*3);
		
		
		Scanner scan=new Scanner(System.in);
		System.out.print("����(0),����(1),��(2):");
		int user=scan.nextInt();
		
		String[] value= {"����","����","��"};
		
		System.out.println("��ǻ��:"+value[com]+",�÷��̾�:"+value[user]);
		// ����
		/*
		 * if(com==0) System.out.println("��ǻ��:����"); if(com==1)
		 * System.out.println("��ǻ��:����"); if(com==2) System.out.println("��ǻ��:��");
		 * 
		 * 
		 * if(user==0) System.out.println("�÷��̾�:����"); if(user==1)
		 * System.out.println("�÷��̾�:����"); if(user==2) System.out.println("�÷��̾�:��");
		 */
		
		// ���  ==> com-user
		/*
		 * if(com==0) //���� { if(user==0)// ���� ==> 0 { System.out.println("����"); }
		 * if(user==1)// ���� ==> -1 { System.out.println("�÷��̾� Win!!"); } if(user==2) //��
		 * ==> -2 { System.out.println("��ǻ�� Win!!"); } } if(com==1) //���� { if(user==0)//
		 * ���� ==> 1 { System.out.println("��ǻ�� Win!!"); } if(user==1)// ���� ==> 0 {
		 * System.out.println("����"); } if(user==2) //�� ==> -1 {
		 * System.out.println("�÷��̾� Win!!"); } } if(com==2) //�� { if(user==0)// ���� 2 {
		 * System.out.println("�÷��̾� Win!!"); } if(user==1)// ���� 1 {
		 * System.out.println("��ǻ�� Win!!"); } if(user==2) //�� 0 {
		 * System.out.println("����"); } }
		 */
		
		// player ==> -1,2 // com ==> 1,-2
		
		int result=com-user;
		if(result==-1 || result==2)
			System.out.println("�÷��̾� Win!!");
		if(result==1 || result==-2)
			System.out.println("��ǻ�� Win!!");
		if(result==0)
			System.out.println("����!!");
		
	}

}



