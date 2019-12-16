/*
 *       1  2  3  4  5
 *          6  7  8
 *             9
 *         10 11 12
 *       13 14 15 16 17
 */
public class 이중반복몬2 {
    /*     i   js   je
     *     0    0   4
     *     1    1   3
     *     2    2   2
     *     ====================  js=i  i+je=4 => je=4-i
     *     3    1   3            i+js=4 => js=4-i  je=i
     *     4    0   4
     */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        int[][] arr=new int[5][5];
        int k=1;
        for(int i=0;i<3;i++)
        {
        	for(int j=i;j<=4-i;j++)
        	{
        		arr[j][i]=k++;
        	}
        }
        for(int i=3;i<5;i++)
        {
        	for(int j=4-i;j<=i;j++)
        	{
        		arr[j][i]=k++;
        	}
        }
        
        for(int i=0;i<5;i++)
        {
        	for(int j=0;j<5;j++)
        	{
				
				  if(arr[i][j]==0) 
					  System.out.print("\t"); 
				  else
				    System.out.print(arr[i][j]+"\t");
        	}
        	System.out.println("\n");
        }
        
	}

}





