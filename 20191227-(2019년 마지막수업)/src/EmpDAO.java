import java.sql.*;
public class EmpDAO {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		String url="jdbc:oracle:thin:@localhost:1521:XE";
        Connection conn=DriverManager.getConnection(url,"hr","happy");
        String sql="SELECT empno,ename,job,hiredate FROM emp";
        PreparedStatement ps=conn.prepareStatement(sql);
        ResultSet rs=ps.executeQuery();
        while(rs.next())
        {
        	System.out.println(rs.getInt(1)+" "
        			+rs.getString(2)+" "
        			+rs.getString(3)+" "
        			+rs.getDate(4));
        }
        rs.close();
	}

}
