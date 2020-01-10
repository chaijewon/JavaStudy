/*
 *    StringTokenizer
 *    =============== 문자열 나눠줄때 사용하는 클래스
 *    1) 객체단위로 전송 
 *    2) 문자열 (0)
 *       id|pwd|avata
 *       == === ===== split => regex
 *       
 *       1. hasMoreTokens()
 *       2. nextToken()
 */
import java.util.*;
class Info
{
	String id;
	String name;
	String pwd;
	String sex;
	String address;
	String tel;
}
public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        String data="admin|홍길동|1234|남자|서울|1111-1111";
        StringTokenizer st=new StringTokenizer(data,"|");
		/*
		 * String id=st.nextToken(); String name=st.nextToken(); String
		 * pwd=st.nextToken(); String sex=st.nextToken(); String addr=st.nextToken();
		 * String tel=st.nextToken();
		 * 
		 * System.out.println("ID:"+id); System.out.println("Name:"+name);
		 * System.out.println("Password:"+pwd); System.out.println("Sex:"+sex);
		 * System.out.println("Address:"+addr); System.out.println("Tel:"+tel);
		 */
        Info info=new Info();
        while(st.hasMoreTokens())
        {
        	System.out.println(st.nextToken());
        }
        
	}

}








