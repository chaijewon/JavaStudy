class Super{
	int a=10;
	public Super() {
		a=20;
	}
	void display() 
	{
		System.out.println("Super:display Call...");
	}
}
class Sub extends Super{
	int b=20;
	int a=10;
	public Sub()
	{
		a=100;
	}
	void display() {
		System.out.println("Sub:display Call...");
	}
	void display(int a)
	{
		System.out.println("Sub:display(int a) Call...");
	}
}
public class MainClass3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Super s=new Super();
        System.out.println(s.a);
        s.display();
        
        Sub s1=new Sub();// ���� ȣ�� 
        System.out.println(s1.a);
        System.out.println(s1.b);
        s1.display();
        s1.display(10);
        
        Super s2=new Sub();// ������ Ŭ������ ���� ==> �޼ҵ常 ���� �Ҷ� 
        System.out.println(s2.a);
        s2.display();
        
	}

}
