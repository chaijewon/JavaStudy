/*
 *   �ڹ�(JAVA)�� ���(extends)
         # �θ� Ŭ����(parent class) �� �ڽ� Ŭ����(children class)�� 
                      �ڹ� ��������� extends�� ���Ͽ� �������ϴ�.
         # �ϳ��� �θ� Ŭ����(parent class)�� �������� �ڽ� Ŭ����(children)�� 
                      ���� �� �ֽ��ϴ�.
         # �ݴ�� �ϳ��� Ŭ������ �������� Ŭ�����κ��� ����� �������� �����ϴ�.
         # �θ� Ŭ����(parent class)�κ��� ��ӹ��� �ڽ� Ŭ������ 
                      �θ� Ŭ������ �ڿ�(source) ��θ� ��� �� �� �ֽ��ϴ�.
         # �ݴ�� �θ�Ŭ������ �ڽ�Ŭ������ �ڿ��� ������ �� ���� �����ϴ�.
         # �ڽ�Ŭ������ �Ǵٸ� Ŭ������ �θ� Ŭ������ �� �� �ֽ��ϴ�. 
         # �ڽ�Ŭ������ �θ�Ŭ�����κ��� �������� �ڿ��� override �Ͽ� �����ؼ� ��� �� �� �ֽ��ϴ�.
         # �θ�Ŭ������ ��ӹ��� �ڿ��� �ڽ�Ŭ������ ��� �����մϴ�.
 */
class ����{
	public void draw() {
		System.out.println("���� �׸���");
	}
	// �߰� 
}
class �� extends ����{
	public void draw() {
		System.out.println("���� �׸���");
	}
	// �߰� 
}
class �ﰢ�� extends ����{
	public void draw() {
		System.out.println("�ﰢ���� �׸���");
	}
}
class �׸� extends ����{
	public void draw() {
		System.out.println("�׸� �׸���");
	}
}
// ���̺귯���� ��� => �����ؼ� ��� 
public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
                ���� m=new �׸�();
        m.draw();
        
        m=new �ﰢ��();
        m.draw();
        
        m=new ��();
        m.draw();
        
        m=new ����();
        m.draw();
        
	}

}
