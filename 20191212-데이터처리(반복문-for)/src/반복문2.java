// 1-2+3-4+5........-10
// ��� ==> �ݺ��� (���ǹ�)
public class �ݺ���2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int sum=0;
        for(int i=1;i<=10;i++)
        {
        	if(i%2==0)
        		sum-=i;
        	else
        		sum+=i;
        }
        System.out.println("sum="+sum);
	}

}
