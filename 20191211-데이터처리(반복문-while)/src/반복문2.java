// A~Z => 
// 
public class ¹Ýº¹¹®2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        int i=1;
        char c='A';
        boolean bCheck=true;
        while(i<=26)
        {
        	if(bCheck==true)
        	   System.out.print(c+"\t");
        	else
        	   System.out.print((char)(c+32)+"\t");
        	if(i%5==0)
        	{
        		System.out.println();
        		bCheck=!bCheck;
        	}
        	
        	i++;
        	c++;
        }
	}

}
