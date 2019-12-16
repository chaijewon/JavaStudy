/*
 *   년도 월을 입력받아서 ==> 월의 마지막날은 몇일?
 *   배열 => 일괄 처리가 가능 
 *   
 *   31  28(29) 31 30  31 30
 *   31  31     30 31  30 31
 */
import java.util.Scanner; 
public class 배열4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        int year,month;// int[] data=new int[2]
        Scanner scan=new Scanner(System.in);
        System.out.print("년도 입력:");
        year=scan.nextInt();
        
        System.out.print("월 입력:");
        month=scan.nextInt();
        
        int lastDay=0;
		/*
		 * if(month==4 || month==6 || month==9 || month==11) { lastDay=30; } else
		 * if(month==2) { // 윤년 if((year%4==0 && year%100!=0)||(year%400==0)) {
		 * lastDay=29; } else { lastDay=28; } } else { lastDay=31; }
		 */
        switch(month)
        {
        case 4:case 6:case 9:
        case 11:
        	lastDay=30;
        	break;
        case 2:
        	if((year%4==0 && year%100!=0)||(year%400==0)) 
        	{
       		  lastDay=29; 
       		} 
        	else 
        	{ 
        		lastDay=28;
        	}
        	break;
        default:
        	lastDay=31;
        	
        }
        System.out.println(month+"달의 마지막 날은 "+lastDay);
	}

}







