// 5개의 정수를 입력받아서 => 5개 정수를 출력하고 ==> 합,평균 
import java.util.Scanner;
public class 배열7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Scanner scan=new Scanner(System.in);
        // 5개 정수 저장하는 공간 
        int[] arr=new int[5];
        // 총점을 저장하는 변수 
        int total=0;
        // 평균을 저장하는 변수
        double avg=0.0;
        
        // 정수를 5개 입력
        for(int i=0;i<arr.length;i++)
        {
        	System.out.print((i+1)+"번째 정수 입력:");
        	arr[i]=scan.nextInt();
        }
        // 10 20 30 40
        // 출력
        for(double score:arr)
        {
        	System.out.println(score);
        	total+=score;
        }
        
        avg=total/(double)arr.length;
        
        System.out.println("총점:"+total);
        System.out.printf("평균:%.2f\n",avg);
	}

}






