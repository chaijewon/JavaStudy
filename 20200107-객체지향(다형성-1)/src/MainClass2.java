/*
 *    �������̵� 
 *    ======== �߻� Ŭ���� , �������̽� 
 *    ����� ���� 
 *    �޼ҵ���� ���� 
 *    �Ű����� ���� 
 *    �������� ���� 
 *    ���� �������� Ȯ�� 
 *    =============
 *     private < default < proptected < public 
 *     
 *     ==> interface I
 *         {
 *             int a=10; ==> ����   ===> public static final int a=10
 *                                    ====================
 *             void display(); ===> public abstract void display();
 *                                  ===============
 *         }
 *         
 *         public A implements I
 *         {
 *             public void display(){  ==> ����
 *             }
 *         }
 */
/*
 *   ����� �ȵǴ� Ŭ����  : ���� Ŭ���� 
 *   public final class 
 *   ����� ���� : static , ������
 */
class Super
{
	public void display() {
		System.out.println("Super:display() Call");
	}
}
// Super�κ��� ��� �ޱ� 
class Sub extends Super
{
	/*
	 *  public void display() {
		System.out.println("Super:display() Call");
	    }
	 */
	    public void display() {
		   System.out.println("Sub:display() Call");
	    }
}
class Sub2 {
	Super su=new Super(); /*
							 * { public void display() { System.out.println("Sub2:display() Call"); } };
							 */
	
}
public class MainClass2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Sub sub=new Sub();
        sub.display();
        
        Sub2 s=new Sub2();
        s.su.display();
	}

}
