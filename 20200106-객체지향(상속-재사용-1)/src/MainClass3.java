// ���� �ٸ� Ŭ������ �����ؼ� ��� (�Ѱ��� Ŭ������ �̿��ؼ� ����)
// �������� Ŭ������ ��� �Ѱ��� ��ü�� ���� 
abstract class ����{
	abstract void �ȴ´�();// ����  {}
	abstract void �Դ´�();
	/*
	 * void display() { System.out.println("���� ǥ��!!!"); }
	 */
}
class ��� extends ����{

	@Override
	void �ȴ´�() {
		// TODO Auto-generated method stub
		System.out.println("���ó�� �ȴ´�");
	}

	@Override
	void �Դ´�() {
		// TODO Auto-generated method stub
		System.out.println("������ �Դ´�");
	}
	
}
class ���� extends ����{

	@Override
	void �ȴ´�() {
		// TODO Auto-generated method stub
		System.out.println("����ó�� �ȴ´�");
	}

	@Override
	void �Դ´�() {
		// TODO Auto-generated method stub
		System.out.println("����ó�� �Դ´�");
	}
	
}
class �� extends ����{

	@Override
	void �ȴ´�() {
		// TODO Auto-generated method stub
		System.out.println("��ó�� �ȴ´�");
	}

	@Override
	void �Դ´�() {
		// TODO Auto-generated method stub
		System.out.println("��ó�� �Դ´�");
	}
	
}
public class MainClass3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
               ���� a=new ���();
        a.�ȴ´�();
        a.�Դ´�();
        
        a=new ��();
        a.�ȴ´�();
        a.�Դ´�();
        
        a=new ����();
        a.�ȴ´�();
        a.�Դ´�();
        
	}

}
