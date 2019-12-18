/*
 *         1     2    4
 *    for(초기값;조건문;증가식)
 *       실행문장  3
 *       
 *    초기값
 *    while(조건문)
 *    {
 *       실행문장 
 *       증가식
 *    }
 */
public class 정리문제6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        for(int i=0;i<=10;i++)
        {
        	for(int j=0;j<=i;j++)
        	{
        		System.out.print("*");
        	}
        	System.out.println();
        }
        
        int i=0;
        while(i<=10)
        {
        	int j=0;
        	while(j<=i)
        	{
        		System.out.print("*");
        		j++;
        	}
        	System.out.println();
        	i++;
        }
        
        int[] arr= {10,20,30,40,50};
        int sum=0;
        //for(int k=0;k<arr.length;k++)
        for(int k:arr)
        {
        	sum+=k;
        }
        System.out.println(sum);
	}
	/*
	 *    int[] arr , int arr[]
	 *    int[][] arr, int arr[][],int[] arr[] 
	 *    
	 *    int[] arr={1,2,3}
	 *    int[] arr=new int[5]
	 */

}





