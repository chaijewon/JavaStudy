import java.util.Scanner;
public class �����ǹ��� {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Scanner scan=new Scanner(System.in);
        System.out.print("�⵵ �Է�:");
        int year=scan.nextInt();
        
        System.out.print("�� �Է�:");
        int month=scan.nextInt();
        
        System.out.print("�� �Է�:");
        int day=scan.nextInt();
        
        // ó�� 
        // ���⵵������ ��
        int total=(year-1)*365
        		 +(year-1)/4
        		 -(year-1)/100
        		 +(year-1)/400;
        
        // ���ޱ����� ��
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
        
        char strWeek='��';
        if(week==0)
        	strWeek='��';
        if(week==1)
        	strWeek='��';
        if(week==2)
        	strWeek='ȭ';
        if(week==3)
        	strWeek='��';
        if(week==4)
        	strWeek='��';
        if(week==5)
        	strWeek='��';
        if(week==6)
        	strWeek='��';
        // ��� 
        System.out.println(year+"�⵵ "+month+"�� "+day+"���� "
        +strWeek+"�����Դϴ�");
	}

}




