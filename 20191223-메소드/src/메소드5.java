import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class �޼ҵ�5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        String data="�������� ���� ���� ���� ���! �����̹���������ͱ��� �����";
        // ���� ���� ==> ���鵵 ���� 
        System.out.println("������ ����:"+data.length());
		/*
		 * System.out.println("�����ܾ��� ����:"); int count=0; Pattern
		 * p=Pattern.compile("����"); Matcher m=p.matcher(data); while(m.find()) {
		 * count++; } System.out.println(count);
		 */
        // substring(0) , substring(2,3)
        int n=data.indexOf("!");
        System.out.println(n);
        String fData=data.substring(0,data.indexOf("!"));
        System.out.println(fData);
        String lData=data.substring(data.indexOf("!")+1);
        System.out.println(lData.trim());
        
        int a=10;
        int b=20;
        double d=10.5;
        // 102010.5  ==> ��ȣ  ==> 201912231 , 201912232
        String sss=a+""+b+""+d;
        System.out.println(sss);
        sss=String.valueOf(a)+String.valueOf(b)+String.valueOf(d);
        System.out.println(sss);
        // valueOf==>��� ���������� ���ڷ� ��ȯ 
	}

}







