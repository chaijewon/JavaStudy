/*
 *    ���� 
 *     = instance ���� : ���� => new �޸𸮸� ���� ��� 
 *     = static ����    : �����ϵɶ� ==> �޼ҵ忡���� ����� �Ұ��� 
 *     =================> �ڵ� �ʱ�ȭ 
 *     = �������� : �޼ҵ� ȣ�� �� 
 *     =================> �ݵ�� �ʱ�ȭ�� �Ѵ� 
 */
class Data{
	// ���� ���� (���� => ����ó��,���,�޼ҵ�ȣ��) ==> {}
	int a=10; // 0
	float f; // 0.0F
	double d;// 0.0
	boolean boo=true; //false
	long l; // 0L
	char c='A'; // '\0'
	String s="Hello"; // null
	String ss="";
	static int aa;//0
}
public class MainClass2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(Data.aa);
		/*
		 * Data dd=new Data(); System.out.println(dd.a); System.out.println(dd.boo);
		 * System.out.println(dd.c); System.out.println(dd.d); System.out.println(dd.f);
		 * System.out.println(dd.l); System.out.println(dd.s);
		 * System.out.println(dd.ss);
		 */
	}

}







