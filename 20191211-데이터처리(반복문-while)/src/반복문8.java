// 구구단 => dan을 입력 받아서 
/*
 *    프로그램 
 *    =======
 *      사용자 정의 + java라이브러리 + 외부오픈소스(mvnrepository.com)
 *      =====================================================
 *                            조립 
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
public class 반복문8 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
        Scanner scan=new Scanner(System.in);
        System.out.print("단 입력:");
        int dan=scan.nextInt();
        
        int i=1;
        while(i<=9)
        {
        	System.out.printf("%2d * %2d = %2d\n",dan,i,dan*i);
        	i++;
        }
        // 처리 
        // String s=JOptionPane.showInputDialog("정수입력");
        
        
	}

}






