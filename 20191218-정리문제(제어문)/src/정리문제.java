/*
 *   1. x>10 && x<20
 *   2. char==' ' || char!='\t'
 *   3. char=='x' || char=='X'
 *   4. char>='0' && char<='9'
 *   5. (char>='A' && char<='Z')||(char>='a' && char<='z')
 *   6. (year%4==0 && year%100!=0) || (year%400==0)
 *   7. (powerOn==false)?true:false
 *   8. str.equals("yes")
 */
public class 정리문제 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        int sum=0;
        for(int i=1;i<=20;i++)
        {
        	//if(i%2!=0 || i%3!=0)
        	if(!(i%2==0 || i%3==0))
        	{
        		System.out.print(i+"  ");
        		sum+=i;
        	}
        }
        
        System.out.println("\n"+"sum="+sum);
	}

}
