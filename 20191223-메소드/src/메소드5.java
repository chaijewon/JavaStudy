import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class 메소드5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        String data="버섯으로 관자 느낌 내는 방법! 새송이버섯간장버터구이 만들기";
        // 문자 갯수 ==> 공백도 포함 
        System.out.println("문자의 갯수:"+data.length());
		/*
		 * System.out.println("버섯단어의 갯수:"); int count=0; Pattern
		 * p=Pattern.compile("버섯"); Matcher m=p.matcher(data); while(m.find()) {
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
        // 102010.5  ==> 번호  ==> 201912231 , 201912232
        String sss=a+""+b+""+d;
        System.out.println(sss);
        sss=String.valueOf(a)+String.valueOf(b)+String.valueOf(d);
        System.out.println(sss);
        // valueOf==>모든 데이터형을 문자로 변환 
	}

}







