import java.util.*;

class Sawon{
	private int sabun;
	private String name;
	private String dept;
	public int getSabun() {
		return sabun;
	}
	public void setSabun(int sabun) {
		this.sabun = sabun;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	
}
public class MainClass4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        ArrayList<Sawon> list=new ArrayList<Sawon>();
        Sawon s=new Sawon();
        s.setSabun(1);
        s.setName("ȫ�浿");
        s.setDept("���ߺ�");
        list.add(s);
        
        s=new Sawon();
        s.setSabun(2);
        s.setName("��û��");
        s.setDept("��ȹ��");
        list.add(s);
        
        s=new Sawon();
        s.setSabun(3);
        s.setName("�ڹ���");
        s.setDept("������");
        list.add(s);
        
        for(Sawon ss:list)
        {
        	System.out.println("���:"+ss.getSabun());
        	System.out.println("�̸�:"+ss.getName());
        	System.out.println("�μ�:"+ss.getDept());
        	System.out.println("==============");
        }
        
	}

}







