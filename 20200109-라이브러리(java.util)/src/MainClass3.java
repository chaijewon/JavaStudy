import java.util.*;
import java.text.*;
public class MainClass3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        // �ý����� �ð� �б�  : Date
		Date date=new Date();
		System.out.println(date);
		// 2020/01/09
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-M-d");
		System.out.println(sdf.format(date));
		
		StringTokenizer st=new StringTokenizer(sdf.format(date),"-");
		String year=st.nextToken();
		String month=st.nextToken();
		String day=st.nextToken();
		
		System.out.println("�⵵:"+year);
		System.out.println("��:"+month);
		System.out.println("��:"+day);
		
		
	}

}
