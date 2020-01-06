// 파일,네트워크,데이터베이스 => 예외처리 
public class Member {
   private String id;
   private String pwd;
   
   // 초기화 
   public Member() {
	   // 데이터베이스에서 읽기,파일 읽기
	   id="hong";
	   pwd="1234";
   }
   
   public Member(String id, String pwd) {
	this.id = id;
	this.pwd = pwd;
   }

   public void print()
   {
	   System.out.println("ID:"+id);
	   System.out.println("Password:"+pwd);
   }
}
