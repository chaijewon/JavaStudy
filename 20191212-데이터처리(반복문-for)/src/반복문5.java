/*
 *   1~100까지의 합 
 *   짝수 / 홀수 합  출력 
 *   
 *   결과 
 *   1~100까지의 합 : 5050
 *   1~100까지의 짝수의 합 :
 *   1~100까지의 홀수의 합
 */
public class 반복문5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int sum=0,even=0,odd=0;
		for(int i=1;i<=100;i++)
		{
			sum+=i;
	    	if(i%2==0)
	    		even+=i;
	    	else
	    		odd+=i;
		}
		System.out.println("합:"+sum);
	    System.out.println("짝수:"+even);
	    System.out.println("홀수:"+odd);
	}

}
