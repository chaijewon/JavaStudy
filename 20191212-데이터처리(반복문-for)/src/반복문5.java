/*
 *   1~100������ �� 
 *   ¦�� / Ȧ�� ��  ��� 
 *   
 *   ��� 
 *   1~100������ �� : 5050
 *   1~100������ ¦���� �� :
 *   1~100������ Ȧ���� ��
 */
public class �ݺ���5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int sum=0,even=0,odd=0;
		for(int i=1;i<=100;i++)
		{
			sum+=i;
	    	if(i%2==0)
	    		even+=i;
	    	else
	    		odd+=i;
		}
		System.out.println("��:"+sum);
	    System.out.println("¦��:"+even);
	    System.out.println("Ȧ��:"+odd);
	}

}
