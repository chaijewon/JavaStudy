/*
 *   1
 *   1+2
 *   1+2+3
 */
public class 정리문제4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int sum=0;
        for(int i=1;i<=10;i++)
        {
        	for(int j=1;j<=i;j++)
        	{
        		System.out.print(j+" ");
        		sum+=j;
        	}
        	System.out.println();
        }
        System.out.println("sum="+sum);
        
        sum=0;
        int i=1;
        for(;;)
        {
          
        	if(i%2==0)
        		sum-=i;
        	else
        		sum+=i;
           if(sum>100)break;
           i++;
        }
        System.out.println("sum="+sum+",i="+i);
	}

}
