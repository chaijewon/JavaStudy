import java.util.Arrays;

/*
 *    5개의 난수 발생 ==> 배열
 *    30 20 40 50 10 
 *    ===============> 50 40 30 20 10
 *    
 *    for(int i=0;i<4;i++)
 *    {
 *       for(int j=(i+1);j<(5);j++)
 *       {
 *           if(arr[i]<arr[j])
 *           {
 *              int temp=arr[i];
 *              arr[i]=arr[j];
 *              arr[j]=temp;
 *           }
 *       }
 *    }
 *    i   j-s j-e     js-1=i  => js=i+1
 *    0    1   4
 *    1    2   4
 *    2    3   4
 *    3    4   4
 *    ==================================
 *    30 20 40 50 10
 *    == ==
 *    30 20
 *    ==    ==
 *    40    30
 *    ==       ==
 *    50       40
 *    ==          ==
 *    50          10
 *    ------------------------------ 1Round
 *    50 20 30 40 10
 *       == ==
 *       30 20
 *       ==    ==
 *       40    30
 *       ==       ==
 *       40       10
 *    ------------------------------ 2Round
 *    50 40 20 30 10
 *          == ==
 *          30 20
 *          ==    ==
 *          30    10
 *    ------------------------------ 3Round
 *    50 40 30 20 10
 *             == ==
 *             20 10
 *    ------------------------------ 4Round
 *    50 40 30 20 10
 */
public class 배열11 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * int a=10; int b=20; int temp=a; a=b;// a=20 b=temp;// b=20
		 * System.out.println("a="+a); System.out.println("b="+b);
		 */
		// 정수 저장 
		int[] arr=new int[10];
		// 초기값
		for(int i=0;i<arr.length;i++)
		{
			arr[i]=(int)(Math.random()*100)+1;//1~100
		}
		
		System.out.println("정렬 전:");
		for(int i:arr)
		{
			System.out.print(i+" ");
		}
		System.out.println();
		System.out.println("정렬 후:");
		
		// 정렬 
		for(int i=0;i<arr.length-1;i++)
		{
			for(int j=i+1;j<arr.length;j++)
			{
				if(arr[i]<arr[j])
				{
					int temp=arr[i];
					arr[i]=arr[j];
					arr[j]=temp;
				}
			}
		}
		
		for(int i:arr)
		{
			System.out.print(i+" ");
		}
		
	}

}







