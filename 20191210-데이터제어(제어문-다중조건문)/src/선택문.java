import java.util.Scanner;

/*
 *    ����if <====> switch
 *    => Servlet <===> JSP ===> MVC ===> Ʋ(Spring)
 *    ���ù� : �Ѱ��� ���� �޾Ƽ� ó�� (�ѹ��� ���� => break)
 *           ����,��Ʈ��ũ ...
 *    ����)
 *                 1
 *         switch(����) ===> ����,����,���ڿ�
 *         {
 *            case 1:
 *              ó��
 *              break;
 *            case 2:
 *              ó��
 *            case 3:
 *              ó��
 *              break;
 *            ============
 *            default:
 *              ó�� 
 *            ============ ������ ���� 
 *         }
 *         
 *         if(score==10 || score==9) 'A'
 *         
 *         switch(����)
 *         {
 *           case 10:
 *           case 9:
 *              'A'
 *         }
 */
public class ���ù� {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		System.out.print("ù��° ����:");
		int num1=scan.nextInt();
		
		System.out.print("�ι�° ����:");
		int num2=scan.nextInt();
		
		System.out.print("������(+,-,*,/):");
		String op=scan.next();
		
		// ó��  ==> int , char , String
		switch(op) 
		{
		  case "+":
			 System.out.printf("%d+%d=%d\n",num1,num2,num1+num2);
			 break;
		  case "-":
			 System.out.printf("%d-%d=%d\n",num1,num2,num1-num2);
			  break;
		  case "*":
			  System.out.printf("%d*%d=%d\n",num1,num2,num1*num2);
			  break;
		  case "/":
			  if(num2==0)
				System.out.println("0���� ���� �� �����ϴ�");
			  else
				System.out.printf("%d/%d=%.2f\n",num1,num2,num1/(double)num2);
			  break;
		  default:
			  System.out.println("�߸��� �������Դϴ�!!");
		}
	}

}





