package com.sist.dao;
import java.sql.*;
public class MemberDAO {
   private Connection conn;//오라클 연결 => Socket
   private PreparedStatement ps;// BufferedReader,OutputStream
   private final String URL="jdbc:oracle:thin:@localhost:1521:XE";
   // 오라클 연결 주소 
   // 1. 드라이버 등록 => 한번 수행 => 생성자 
   public MemberDAO()
   {
	   try
	   {
		   Class.forName("oracle.jdbc.driver.OracleDriver");
	   }catch(Exception ex) 
	   {
		   System.out.println(ex.getMessage());
	   }
   }
   // 2. 연결 
   public void getConnection()
   {
	   try
	   {
		   conn=DriverManager.getConnection(URL,"hr","happy");
		   // conn hr/happy
	   }catch(Exception ex) {}
   }
   // 3. 연결해제
   public void disConnection()
   {
	   try
	   {
		   if(ps!=null) ps.close();
		   if(conn!=null) conn.close();
		   // exit
	   }catch(Exception ex) {}
   }
   // 4. 기능 처리 
   public String isLogin(String id,String pwd)
   {
	   String result="";
	   try
	   {
		   // 연결
		   getConnection();
		   // 오라클에 요청 
		   String sql="SELECT COUNT(*) FROM member WHERE id=?";
		   ps=conn.prepareStatement(sql); // 오라클로 전송 
		   // ?에 값을 채운다 
		   ps.setString(1, id);
		   // 실행요청 
		   ResultSet rs=ps.executeQuery();
		   rs.next(); // 실제 출력위치에 커서를 이동한다 
		   int count=rs.getInt(1);
		   rs.close();
		   
		   if(count==0)
		   {
			   result="NOID";
		   }
		   else
		   {
			   // 요청 
			   sql="SELECT * FROM member WHERE id=?";
			   ps=conn.prepareStatement(sql);// 전송 
			   ps.setString(1, id);// 실행전에 ?에 값을 채운다
			   rs=ps.executeQuery();// 실행
			   rs.next();
			   
			   // 값을 받는다 
			   String mid=rs.getString(1);
			   String mpwd=rs.getString(2);
			   String name=rs.getString(3);
			   String sex=rs.getString(4);
			   int avata=rs.getInt(5);
			   System.out.println(name+"  "+sex);
			   rs.close();
			   
			   if(mpwd.equals(pwd))
			   {
				  // 로그인   
				  result=mid+"|"+name+"|"+sex+"|"+avata;
			   }
			   else
			   {
				   // 비밀번호가 틀리다 
				   result="NOPWD";
			   }
			   
			   /*
			    *    String name="";
			    *    String sex="";
			    *    String id="";
			    *    int age=10;
			    *    VARCHAR
			    *    sql="INSERT INTO member VALUES('"+name+"','"+sex
			    *        +"','"+id+"',"+age+")"
			    *    sql="INSERT INTO member VALUES(?,?,?,?)"
			    */
		   }
		   
		   
	   }catch(Exception ex)
	   {
		   System.out.println(ex.getMessage());
	   }
	   // CREATE ....(avata NUMBER)
	   /*
	    *   INSERT INTO ~~ ( '남자',1) m1,m2...
	    *   "C:\\image\\m"+no+".png"
	    */
	   finally
	   {
		   // 연결 해제
		   disConnection();
	   }
	   return result;
   }
}





