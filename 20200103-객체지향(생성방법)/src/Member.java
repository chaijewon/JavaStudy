// ����,��Ʈ��ũ,�����ͺ��̽� => ����ó�� 
public class Member {
   private String id;
   private String pwd;
   
   // �ʱ�ȭ 
   public Member() {
	   // �����ͺ��̽����� �б�,���� �б�
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
