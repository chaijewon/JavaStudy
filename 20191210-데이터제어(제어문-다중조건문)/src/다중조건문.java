/*
 *   다중조건문 : 여러개의 조건을 제시하고 해당 조건 1개만 수행이 되게 만든다 
 *   1) 형식 
 *       if(조건문) 
 *         실행문장1   => true => 실행문장1을 수행하고 종료 
 *                   => false
 *                   바로 밑에 조건문으로 이동 
 *       else if(조건문)
 *         실행문장2
 *       else if(조건문)
 *         실행문장3 
 *       ==============
 *       else
 *         실행 문장4
 *       ============== 해당 조건이 없는 경우에 처리 (생략이 가능)
 */
// 성적 처리 
// 3개의 점수를 받아서 => 총점을 출력,평균을 출력 , 학점을 출력 
import java.util.Scanner;
public class 다중조건문 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        // 필요한 변수 선언 
		int kor,eng,math,total,temp;
		double avg;
		char score;
		
		// 입력을 받는다 
		Scanner scan=new Scanner(System.in);
		// new : 메모리 할당 
		// Scanner(System.in) : 변수에 대한 초기화 (생성자)
		// 클래스 => 사용자 정의 데이터형 (변수+메소드)
        System.out.print("국어점수:");
        kor=scan.nextInt();
        
        System.out.print("영어점수:");
        eng=scan.nextInt();
        
        System.out.print("수학점수:");
        math=scan.nextInt();
		
		// 총점
        total=kor+eng+math;
        // 평균
        avg=total/3.0;
        
        temp=(int)avg;// total/3
        // 학점
        
        if(temp>=90)
        	score='A';
        else if(temp>=80)
        	score='B';
        else if(temp>=70)
        	score='C';
        else if(temp>=60)
        	score='D';
        else
        	score='F';
        
        System.out.println("총점:"+total);
        System.out.printf("평균:%.2f\n",avg);
        System.out.println("학점:"+score);
        
	}

}





