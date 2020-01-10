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
        s.setName("홍길동");
        s.setDept("개발부");
        list.add(s);
        
        s=new Sawon();
        s.setSabun(2);
        s.setName("심청이");
        s.setDept("기획부");
        list.add(s);
        
        s=new Sawon();
        s.setSabun(3);
        s.setName("박문수");
        s.setDept("영업부");
        list.add(s);
        
        for(Sawon ss:list)
        {
        	System.out.println("사번:"+ss.getSabun());
        	System.out.println("이름:"+ss.getName());
        	System.out.println("부서:"+ss.getDept());
        	System.out.println("==============");
        }
        
	}

}







