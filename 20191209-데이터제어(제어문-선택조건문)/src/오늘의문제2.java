import java.util.Scanner;
public class �����ǹ���2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Scanner scan=new Scanner(System.in);
        System.out.print("ù��° �����Է�:");
        int num1=scan.nextInt();
        
        System.out.print("�ι�° �����Է�:");
        int num2=scan.nextInt();
        
        System.out.print("������ (+,-,*,/) �Է�:");
        String op=scan.next();
        
        // ������ ��ȯ 
        char c=op.charAt(0);
        // if(op.equals("+"))
        if(c=='+')
        {
        	System.out.println(num1+"+"+num2+"="+(num1+num2));
        }
        if(c=='-')
        {
        	System.out.println(num1+"-"+num2+"="+(num1-num2));
        }
        if(c=='*')
        {
        	System.out.println(num1+"*"+num2+"="+(num1*num2));
        }
        if(c=='/')
        {
        	if(num2==0)
        		System.out.println("0���� ���� �� �����ϴ�");
        	else
        		System.out.println(num1+"/"+num2+"="+(num1/num2));
        }
        
	}

}
