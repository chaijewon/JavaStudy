/*
 *   �޼ҵ� 
 *   =====
 *     �ڹ� (��ü����  => Ŭ����) : Ŭ���� ������� (����,�޼ҵ�)
 *                                           =======
 *                                           ������+���
 *   ����)
 *        ������(ó�������) �޼ҵ��(�Ű�����...) ==>�����
 *        ============== ======
 *          �⺻��                 ��� : �ҹ��� (��Ÿ����)
 *          =======            getText() ==> nextInt()
 *                             class Name{} => Name name
 *                             
 *                             class A
 *                             {
	 *                             if()
	 *                             {
	 *                             }
	 *                             else
	 *                             {
	 *                             }
 *                             }
 *          �迭��
 *          Ŭ������ 
 *          ======= ������� ������ 
 *        {
 *            ==> ������ 
 *            ����ó�� 
 *            ��� 
 *            
 *            return ����� ==> void(������ ����) => JVM�� �ڵ����� return�߰�
 *        }
 *        
 *        ** return ���� => 1�� ������ ���� 
 *           �������� ��� ====> ��� �����ش� 
 *        ** ��� �޼ҵ�� return�� ������ ���� �Ѵ� 
 *        
 *        ------------------------
 *        ** ����ڰ� ��û�� ��?
 *           ó�� ��� 
 *           
 *        ** ȣ�� (��� �ñ�)
 *        ------------------------
 *        
 *        
 *        
 */
import java.util.Scanner;
public class �޼ҵ�1 {
    // +
	static int plus(int a,int b)
	{
		return a+b;
	}
	// -
	static int minus(int a,int b)
	{
		return a-b;
	}
	// *
	static int gop(int a,int b)
	{
		return a*b;
	}
	// /
	static double div(int a,int b)
	{
		return a/(double)b;
	}
	// ���� 
	static void process()
	{
		Scanner scan=new Scanner(System.in);
		System.out.print("ù��° ���� �Է�:");
		int a=scan.nextInt();
		
		System.out.print("�ι�° ���� �Է�:");
		int b=scan.nextInt();
		
		System.out.print("������(+,-,*,/)�Է�:");
		String op=scan.next();
		
		switch(op)
		{
		case "+":
		{
			int res=plus(a,b);
			System.out.printf("%d%s%d=%d\n",a,op,b,res);
		}
			break;
		case "-":
		{
			int res=minus(a,b);
			System.out.printf("%d%s%d=%d\n",a,op,b,res);
		}
			break;
		case "*":
		{
			int res=gop(a,b);
			System.out.printf("%d%s%d=%d\n",a,op,b,res);
		}
			break;
		case "/":
		{
			double res=div(a,b);
			System.out.printf("%d%s%d=%f\n",a,op,b,res);
		}
			break;
		}
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Scanner scan=new Scanner(System.in);
        while(true)
        {
		   process();
		   System.out.print("y|n �Է�:");
		   String ex=scan.next();
		   switch(ex)
		   {
		   case "y":
			   System.exit(0);
			   break;
		   case "n":
			   break;
		   }
	}

	}
}





