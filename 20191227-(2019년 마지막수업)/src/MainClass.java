/*
 *     �ڹ� (Ŭ������ ������)==> �� ���� , ������ ������ ���� ��� 
 *     �Ѱ��� ���Ͽ��� ��� 
 *     ==============
 *     class A
 *     class C
 *     class D
 *     public class B 
 *     =============== B.java (publicŬ������ �Ѱ��� ����)
 *     class A
 *     class B
 *     ======== 
 */
class News{
    public String title;
	protected String content;
	String author;
	String regdate;
	static String site;
	//���� �� �� �ִ� ����
}// News�������� 
// ������ 
public class MainClass {
    class A
    {
    	// ���� Ŭ���� 
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        // ���� => ������ ���� 
		// �޸� ����� 
		News n1=new News();
		n1.title="\"8��° 1��\"..'��λ�', 450���� ����..'õ��' ���� ù�� 14�� ��...";
		n1.content="[OSEN=�ϼ��� ����] ��ȭ '��λ�'�� ��ź���� �̾� ��ȭ�� ������ ���� ������ ���װ�, 'õ��: �ϴÿ� ���´�'�� ù�� 2���� ������   �ڽ����ǽ� �ǵ��� �� �ٲ����.";
	    n1.author="OSEN";
	    n1.regdate="19.12.27";
	    
	    News n2=new News();
	    // int a=10; a=20;
	    n2.title="�����ԡ������� ��ȭ 'ī��Ʈ' ĳ����";
		n2.content="[OSEN=�ϼ��� ����] ��ȭ '��λ�'�� ��ź���� �̾� ��ȭ�� ������ ���� ������ ���װ�, 'õ��: �ϴÿ� ���´�'�� ù�� 2���� ������   �ڽ����ǽ� �ǵ��� �� �ٲ����.";
	    n2.author="OSEN";
	    n2.regdate="19.12.27";
	    
	    // ��� 
	    /*
	     *   int a=10;
	     *   
	     */
	    System.out.println(n1.title);
	    System.out.println(n2.title);
	    
	}

}








