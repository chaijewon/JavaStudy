/*
 *   ���� �ʱ�ȭ 
 *   ========
 *    ����� ���ÿ� �ʱ�ȭ 
 *    int a=10;
 *    a=100(X)
 *    =============
 *    {
 *       a=100;
 *    }
 *    ============= �ʱ�ȭ ���(��������� �ʱ�ȭ)
 *    static
 *    {
 *       �ڵ�
 *    }
 *    ============ static �ʱ�ȭ ��� (�������(static) �ʱ�ȭ)
 *    
 *    Ŭ������()
 *    {
 *       a=200;
 *    }
 */
class MyData{
	static int[] arr=new int[6];
	public MyData() {
		// TODO Auto-generated constructor stub
	
		for(int i=0;i<6;i++)
		{
			arr[i]=(int)(Math.random()*100)+1;
		}
	}
	
}
public class MainClass2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		MyData m1=new MyData();// arr
		for(int i=0;i<6;i++)
		{
			System.out.print(m1.arr[i]+" ");
		}
		System.out.println("\n=============");
		MyData m2=new MyData();// arr
		for(int i=0;i<6;i++)
		{
			System.out.print(m2.arr[i]+" ");
		}
		System.out.println("\n=============");
		MyData m3=new MyData();
		for(int i=0;i<6;i++)
		{
			System.out.print(m3.arr[i]+" ");
		}
		System.out.println("\n=============");
		
		for(int i=0;i<6;i++)
		{
			System.out.print(m1.arr[i]+" ");
		}
		System.out.println("\n=============");
		
		/*
		 * MyData m1=new MyData(); for(int i=0;i<6;i++) {
		 * System.out.print(m1.arr[i]+" "); }
		 * 
		 * System.out.println("\n================");
		 * 
		 * MyData m2=new MyData(); for(int i=0;i<6;i++) {
		 * System.out.print(m2.arr[i]+" "); }
		 */
		int a;
		a=100;
		int b=a+10;
		
		System.out.println(a);
	}

}





