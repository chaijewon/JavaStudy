import java.util.Scanner;
public class 반복문3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        int kor=0,eng=0,math=0,total=0,avg=0;
        char score='A';
        
        int[] first=new int[6];
        
        int kor1=0,eng1=0,math1=0,total1=0,avg1=0;
        char score1='A';
        
        int kor2=0,eng2=0,math2=0,total2=0,avg2=0;
        char score2='A';
        
        int i=1;
        Scanner scan=new Scanner(System.in);
        do
        {
        	if(i==1) // 첫번째 학생
        	{
        		System.out.print("국어 점수:");
               	kor=scan.nextInt();
               	
               	System.out.print("영어 점수:");
               	eng=scan.nextInt();
               	
               	System.out.print("수학 점수:");
               	math=scan.nextInt();
               	
               	total=kor+eng+math;
               	avg=total/3;
               	
               	char c='A';
               	switch(avg/10)
               	{
               	case 10:
               	case 9:
               		c='A';
               		break;
               	case 8:
               		c='B';
               		break;
               	case 7:
               		c='C';
               		break;
               	case 6:
               		c='D';
               		break;
               	default:
               		c='F';
               	}
               	score=c;
        	}
        	else if(i==2) // 두번째 학생
        	{
        		System.out.print("국어 점수:");
               	kor1=scan.nextInt();
               	
               	System.out.print("영어 점수:");
               	eng1=scan.nextInt();
               	
               	System.out.print("수학 점수:");
               	math1=scan.nextInt();
               	
               	total1=kor1+eng1+math1;
               	avg1=total1/3;
               	
               	char c='A';
               	switch(avg1/10)
               	{
               	case 10:
               	case 9:
               		c='A';
               		break;
               	case 8:
               		c='B';
               		break;
               	case 7:
               		c='C';
               		break;
               	case 6:
               		c='D';
               		break;
               	default:
               		c='F';
               	}
               	score1=c;
        	}
        	else if(i==3) // 세번째 학생 
        	{
        		System.out.print("국어 점수:");
               	kor2=scan.nextInt();
               	
               	System.out.print("영어 점수:");
               	eng2=scan.nextInt();
               	
               	System.out.print("수학 점수:");
               	math2=scan.nextInt();
               	
               	total2=kor2+eng2+math2;
               	avg2=total2/3;
               	
               	char c='A';
               	switch(avg2/10)
               	{
               	case 10:
               	case 9:
               		c='A';
               		break;
               	case 8:
               		c='B';
               		break;
               	case 7:
               		c='C';
               		break;
               	case 6:
               		c='D';
               		break;
               	default:
               		c='F';
               	}
               	score2=c;
        	}
        	i++;
        }while(i<=3);
        
        // 결과
        System.out.println("국어  영어  수학   총점  평균  학점");
        System.out.println(kor+"  "+eng+"  "+math+"  "
                      +total+"  "+avg+"  "+score);
        System.out.println(kor1+"  "+eng1+"  "+math1+"  "
                +total1+"  "+avg1+"  "+score1);
        System.out.println(kor2+"  "+eng2+"  "+math2+"  "
                +total2+"  "+avg2+"  "+score2);
	}
	
	

}




