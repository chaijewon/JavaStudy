// ���������� ==> 5   ==> 1�� 3�� 1�� 
import java.util.Scanner;
public class �ݺ���3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        int i=1;
        int win=0,lose=0,same=0;
        /*
         *     com-user 
         *     ���� (0) - ����(0)   ==> 0
         *              ����(1)    ==> -1
         *              ��(2)     ==> 2
         *     ����(1) - ����(0)    ==> 1
         *              ����(1)    ==> 0
         *              ��(2)      ==> -1
         *     ��(2)  - ����(0)     ==> 2
         *              ����(1)     ==> 1
         *              ��(2)       ==> 0
         *              
         *     ����� ==> -1,2
         *     ��ǻ�� ==> 1,-2
         */
        Scanner scan=new Scanner(System.in);
        while(i<=5)
        {
        	// ���� ���� �� ����
        	// ��ǻ�� => ���������� 
        	int com=(int)(Math.random()*3); // 0~2
        	// ����� => �Է� 
        	System.out.print("����(0),����(1),��(2):");
        	int user=scan.nextInt();
        	// �� 
        	
        	int res=com-user;
			/*
			 * if(res==-1 || res==2) { // ����� win win++; } else if(res==1 || res==-2) { //
			 * ��ǻ�� win lose++; } else { // ���� same++; }
			 */
        	switch(res)
        	{
        	case -1:
        	case 2:
        		win++;
        		break;
        	case 1:
        	case -2:
        		lose++;
        		break;
        	default: same++;
        	}
        	i++;
        }
        
        // �� �� ��...
        System.out.println("����� ����:"+win+"�� "+same+"�� "+lose+"��");
	}

}





