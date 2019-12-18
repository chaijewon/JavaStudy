
public class 정리문제3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        for(int i=1;i<=6;i++)
        {
        	for(int j=1;j<=6;j++)
        	{
        		if(i+j==6)
        		{
        			System.out.println("("+i+","+j+")");
        		}
        	}
        }
		/*
		 * int[] arr[]; int[] arr1= {1,2,3}; int arr2[5]; int[] arr3=new int[5]; int[]
		 * arr4[]=new int[3][];
		 */
        int[] arr= {10,20,30,40,50};
        int sum=0;
        for(int i:arr)
        {
        	sum+=i;
        }
        
        System.out.println("sum="+sum);
        
	}

}
