// 5���� ������ �Է¹޾Ƽ� => 5�� ������ ����ϰ� ==> ��,��� 
import java.util.Scanner;
public class �迭7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Scanner scan=new Scanner(System.in);
        // 5�� ���� �����ϴ� ���� 
        int[] arr=new int[5];
        // ������ �����ϴ� ���� 
        int total=0;
        // ����� �����ϴ� ����
        double avg=0.0;
        
        // ������ 5�� �Է�
        for(int i=0;i<arr.length;i++)
        {
        	System.out.print((i+1)+"��° ���� �Է�:");
        	arr[i]=scan.nextInt();
        }
        // 10 20 30 40
        // ���
        for(double score:arr)
        {
        	System.out.println(score);
        	total+=score;
        }
        
        avg=total/(double)arr.length;
        
        System.out.println("����:"+total);
        System.out.printf("���:%.2f\n",avg);
	}

}






