
public class 메소드3 {
    static void a()
    {
    	System.out.println("a() 기능처리..");
    	b();
    }
    static void b()
    {
    	c();
    	System.out.println("b() 기능처리..");
    }
    static void c()
    {
    	System.out.println("c() 기능처리 전..");
    	d();
    	System.out.println("c() 기능처리..");
    }
    static void d()
    {
    	System.out.println("d() 기능처리..");
    }
    static void process()
    {
    	System.out.println("a() 호출전...");
    	a();
    	System.out.println("a() 호출후...");
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
       process();
	}

}
