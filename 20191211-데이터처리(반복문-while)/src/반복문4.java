
public class �ݺ���4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        int i=100; //��������  100~999
        int a7=0,a4=0;
        while(i<=999)
        {
        	if(i%7==0)
        		a7++;
        	if(i%4!=0)
        		a4++;
        	
        	//System.out.println(i);
        	i++;
        }
        System.out.println("7�� ����� ����:"+a7);
        System.out.println("4�� ����� �ƴ� ����:"+a4);
	}

}
