import java.util.Scanner;
public class 오늘의문제 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Scanner scan=new Scanner(System.in);
        System.out.print("년도 입력:");
        int year=scan.nextInt();
        
        System.out.print("월 입력:");
        int month=scan.nextInt();
        
        System.out.print("일 입력:");
        int day=scan.nextInt();
        
        // 처리 
        // 전년도까지의 합
        int total=(year-1)*365
        		 +(year-1)/4
        		 -(year-1)/100
        		 +(year-1)/400;
        
        // 전달까지의 합
        int[] lastDay= {31,28,31,30,31,30,
        		        31,31,30,31,30,31};
        if((year%4==0 && year%100!=0)||(year%400==0))
        	lastDay[1]=29;
        else
        	lastDay[1]=28;
        /*
         *   if(month-1==1)
         *      total+=31
         *   if(month-1==2)
         *      total+=31+28
         */
        for(int i=0;i<month-1;i++)
        {
        	total+=lastDay[i];
        }
        total+=day;
        int week=total%7;
        
        char strWeek='월';
        if(week==0)
        	strWeek='일';
        if(week==1)
        	strWeek='월';
        if(week==2)
        	strWeek='화';
        if(week==3)
        	strWeek='수';
        if(week==4)
        	strWeek='목';
        if(week==5)
        	strWeek='금';
        if(week==6)
        	strWeek='토';
        // 결과 
        System.out.println(year+"년도 "+month+"월 "+day+"일은 "
        +strWeek+"요일입니다");
	}

}




