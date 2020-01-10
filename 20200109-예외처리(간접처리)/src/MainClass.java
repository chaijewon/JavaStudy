import java.io.IOException;
import java.sql.SQLException;

class MyException{
	// 구현된 내용중에 예상되는 에러가 있다 => 시스템에 알려준다 => throws 
	public void display() throws NumberFormatException,NullPointerException,ArithmeticException
	{
		System.out.println("MyException:display Call...");
	}
	public void display1() throws IOException,SQLException
	{
		System.out.println("MyException:display1 Call...");
	}
}
public class MainClass {

	public static void main(String[] args) /* throws IOException,SQLException */{
		// TODO Auto-generated method stub
        // 메모리 할당 
		// NumberFormatException,NullPointerException,ArithmeticException
		// RuntimeException => 생략가능 
		MyException m=new MyException(); // m주소에 display()저장 
		m.display();
		/*
		 * try { m.display1(); }catch(IOException e) {} catch(SQLException e) {}
		 */
		try
		{
			m.display1();
		}//catch(Exception e) {}
		catch(Throwable e) {}
	}

}
