
public class �������ǹ�_����3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        int a=(int)(Math.random()*100)+1;
        int b=(int)(Math.random()*100)+1;
        
        // ū��,���� �� 
        System.out.println("a="+a+",b="+b);
        
        if(a>b)
        {
        	System.out.println("ū���� "+a+"�Դϴ�");
        	System.out.println("���� ���� "+b+"�Դϴ�");
        }
        if(a<b)
        {
        	System.out.println("ū ���� "+b+"�Դϴ�");
        	System.out.println("���� ���� "+a+"�Դϴ�");
        }
        if(a==b)
        {
        	System.out.println("����");
        }
        
        
	}

}
