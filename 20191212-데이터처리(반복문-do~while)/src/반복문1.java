/*
 *    do~while : �ѹ� �̻��� �����ϴ� �ݺ��� (�� ���� ����)
 *    ����)
 *          �����ͺ��̽� : �� 
 *          ��Ʈ��ũ : ����Ʈ
 *          ==============
 *          
 *          // C,C++,C#,Java => 0 (���ڿ�,�ڷᱸ��(List,Set,Map),�迭)
 *          ��� 
 *            ��  ===> 1
 *            �ް�  3
 *            ����  2
 *            ���  1   ���� (��Ÿ��)
 *          
 *          �ʱⰪ => �׻� 1�̴� (X) 
 *          do{
 *               ���๮�� ==> ���������� ��� �Ҽ� �ִ� 
 *               ������ ==> ������
 *                   i++ , i--
 *                   i+=2, i-=2
 *          }while(���ǹ�);
 *          
 */
public class �ݺ���1 {
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        // 1~10���� 
		int i=1;// 1~10 => �������� 
		do {
			 System.out.println("i="+i);
			 i++;
		}while(i<=10);
		System.out.println("10~1");
		do {
			 System.out.println("i="+(i-1));
			 i--;
		}while(i>1);
	}

}







