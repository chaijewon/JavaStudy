import java.util.Calendar;
import java.util.Scanner;

public class 메소드8 {
    static void process()
    {
    	// 년도 , 월 
    			char[] strWeek={'일','월','화','수','목','금','토'};
    			// MONTH => 0  +1
    			// DAY_OF_WEEK => 1 -1
    			Calendar cal=Calendar.getInstance();
    			int y=cal.get(cal.YEAR);
    			int m=cal.get(cal.MONTH)+1;
    			int d=cal.get(cal.DATE);
    			int w=cal.get(cal.DAY_OF_WEEK);
    			System.out.println("====== "+y+"년도 "+m+"월 "+d+"일 "
    			    +strWeek[w-1]+"요일 =======");
    			Scanner scan=new Scanner(System.in);
    			System.out.print("년도 입력:");
    			int year=scan.nextInt();
    			
    			System.out.print("월 입력:");
    			int month=scan.nextInt();
    			
    			System.out.println(year+"년도 "+month+"월");
    			System.out.println("\n");
    			
    			/*System.out.print("일\t");
    			System.out.print("월\t");
    			System.out.print("화\t");
    			System.out.print("수\t");
    			System.out.print("목\t");
    			System.out.print("금\t");
    			System.out.print("토\t");*/
    			
    			for(int i=0;i<7;i++)
    			{
    				System.out.print(strWeek[i]+"\t");
    			}
    			
    			// 1일자의 요일을 구한다 
    			// 전년도의 12/31 => 총합
    			int total=(year-1)*365
    					 +(year-1)/4
    					 -(year-1)/100
    					 +(year-1)/400;
    			// 전달 
    			int[] lastday={31,28,31,30,31,30,
    					      31,31,30,31,30,31};
    			if((year%4==0 && year%100!=0)||(year%400==0))
    				lastday[1]=29;
    			else
    				lastday[1]=28;
    			
    			for(int i=0;i<month-1;i++)
    			{
    				total+=lastday[i];
    			}
    			
    			// +1 ====> %7===> 요일을 구한다 
    			total++;// 각달의 1일자 
    			int week=total%7;
    			
    			
    			System.out.println();
    			for(int i=1;i<=lastday[month-1];i++)
    			{
    				if(i==1)
    				{
    					for(int j=0;j<week;j++)
    					{
    						System.out.print("\t");
    					}
    				}
    				System.out.printf("%2d\t",i);
    				week++;
    				if(week>6)
    				{
    					week=0;
    					System.out.println();
    				}
    			}
    			
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        process();
	}

}
