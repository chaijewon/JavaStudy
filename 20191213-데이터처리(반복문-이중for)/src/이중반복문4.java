import java.util.Scanner;

/*
 *    구구단 출력 
 */
class A
{
	static int aa=10;
}
public class 이중반복문4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//A a=new A();
		//a.aa=100;
		//A b=new A();
		//System.out.println("b="+b.aa);
        for(int i=1;i<=9;i++)
        {
        	for(int j=2;j<=9;j++)
        	{
        		System.out.printf("%2d * %2d = %2d\t",j,i,j*i);
        	}
        	System.out.println();
        }
        
        System.out.println("\nfor~while===========");
        int j=2;
        //A a=new A();
        for(int i=1;i<=9;i++)
        {
        	
        	//Scanner scan=new Scanner(System.in);
        	//System.out.println("scan="+scan);
        	j=2;
        	while(j<=9)
        	{
        		System.out.printf("%2d * %2d = %2d\t",j,i,j*i);
        		
            	//System.out.println("a="+a);
        		j++;
        	}
        	System.out.println();
        }
	}

}




