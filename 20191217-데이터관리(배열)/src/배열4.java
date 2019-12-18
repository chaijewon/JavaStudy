/*
 *    관련된 내용을 묶어서 사용 
 *    
 *    => 같은 데이터형 묶어서 한개 이름으로 제어 : 배열 
 *       =========
 *       int[] arr={'A','B'...} => arr[0],arr[1],arr[2]
 *       int[] arr=new int[3];
 *       
 *       
 *       double[] arr={10,20,30...}
 *       String[] arr={"","","","",""...}  => 클래스 (값이 없는 경우:null)
 *       
 *       
 */
public class 배열4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int x=2;
		int y=5;
		char c='A';
		
		System.out.println(1+x << 33);
		System.out.println(x==5 || x>=2 && y<=5);
		                         // false && false= false
		System.out.println(y+=10 - x++);
		System.out.println(x+=2);
		
		System.out.println(!('A'<=c && c<='Z'));
		System.out.println('C'-c);
		
		System.out.println(c+1);
		System.out.println(++c);
		System.out.println(c++);
		System.out.println(c);
		
		int num=123;
		int size=10;
		System.out.println(num%size!=0?num/size+1:num/size);
		
		char ch='1';
		boolean b=(ch>='A' && ch>='Z')||(ch>='a' && ch<='z')||(ch>='0' && ch<='9');
		System.out.println(b);
		
		//boolean cc=Character.isDigit(ch);
		boolean dd=Character.isLowerCase(ch)||Character.isUpperCase(ch)||Character.isDigit(ch);
		System.out.println(dd);
		//System.out.println(cc);
	}

}
