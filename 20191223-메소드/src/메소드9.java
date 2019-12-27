import java.util.Calendar;
import java.util.Scanner;

public class 메소드9 {
    // 오늘 날짜 출력
	static void today()
	{
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
	}
	// 년도 , 월 
	static int input(String msg)
	{
		Scanner scan=new Scanner(System.in);
		System.out.print(msg);
		int year=scan.nextInt();
		return year;
	}
	// 요일 
	static int getWeek(int year,int month)
	{
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
		
		return week;
	}
	// 달력 출력 
	static void datePrint(int month,int week)
	{
		char[] strWeek={'일','월','화','수','목','금','토'};
		int[] lastday={31,28,31,30,31,30,
			      31,31,30,31,30,31};
		for(int i=0;i<7;i++)
		{
			System.out.print(strWeek[i]+"\t");
		}
		System.out.println("\n");
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
	// 조립
	static void process()
	{
		today();
		int year=input("년도 입력:");
		int month=input("월 입력:");
		System.out.println(year+"년도 "+month+"월");
		System.out.println("\n");
		
		int week=getWeek(year, month);
		datePrint(month, week);
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        process();
	}

}
