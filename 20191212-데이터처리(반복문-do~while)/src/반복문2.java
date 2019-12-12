/*
 *     1) 3명의 학생 => 국어,영어,수학 점수 => 평균,총점,학점을 출력 
 *        
 *        국어   영어   수학  총점  평균  학점 
 *        80   80   80  240 80  'B'
 *        70   70   70  210 70  'C'
 *        90   90   90  270 90  'A'
 */
import java.util.Scanner;
public class 반복문2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        int kor,eng,math,total,avg;
        String result="";
        int i=1;
        Scanner scan=new Scanner(System.in);
        do 
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
          result+=kor+"  "+eng+"  "+math+"  "+total+"  "+avg+"  "
        		 +c+"\n";
          i++;
        }while(i<=3);
        
        System.out.println("국어  영어  수학  총점  평균  학점");
        System.out.println(result);
	}

}







