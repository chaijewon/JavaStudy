// ������ => dan�� �Է� �޾Ƽ� 
/*
 *    ���α׷� 
 *    =======
 *      ����� ���� + java���̺귯�� + �ܺο��¼ҽ�(mvnrepository.com)
 *      =====================================================
 *                            ���� 
 *      5*1=5
 *          ==
 *      5*2=10
 *      
 *      2*1=2  3*1=3  -----  9*1=9
 *      
 *      
 *      2*9=18 3*9=27  ------- 9*9=81
 *      
 */
import java.util.Scanner;

import javax.swing.JOptionPane;
public class �ݺ���8 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
        Scanner scan=new Scanner(System.in);
        System.out.print("�� �Է�:");
        int dan=scan.nextInt();
        
        int i=1;
        while(i<=9)
        {
        	System.out.printf("%2d * %2d = %2d\n",dan,i,dan*i);
        	i++;
        }
        // ó�� 
        // String s=JOptionPane.showInputDialog("�����Է�");
        
        
	}

}






