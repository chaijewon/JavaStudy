/*
 *    �ݺ��� 
 *      =============== ������ 
 *      = for : �ݺ�Ƚ�� ����      
 *      = while : ������ ���� ��� 
 *        �ʱⰪ 
 *        while(���ǹ�)
 *        {
 *           ���๮�� 
 *           ������ 
 *        }
 *      =============== ������
 *      = do~while : �ѹ� �̻��� �ݵ�� ����
 *        �ʱⰪ
 *        do
 *        {
 *           ���๮��
 *           ������
 *        }while(���ǹ�)
 *      ===============
 */
public class �ݺ��� {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * String[] s= {"a","b","c","d","e","f","g","h","i","k"}; int[] ss=
		 * {3,4,6,7,8,9,10,11,4,5}; int i=0; while(i<10) {
		 * System.out.println(s[i]+"-"+ss[i]); i++; }
		 */
		int i=1;  // 1
		int sum3=0,sum5=0,sum7=0; 
		while(i<=100) //2
		{
			if(i%3==0)
				sum3+=i;
			if(i%5==0)
				sum5+=i;
			if(i%7==0)
				sum7+=i;
			i++; // 4
		}
		/*
		 *    i=1 ==> sum=1
		 *    i=2 ==> sum=3
		 *    i=3 ==> sum=6
		 */
		//System.out.println("1~100������ ��:"+sum);
		/*
		 *    1==>2==>3==>4
		 *        2==>3==>4
		 *        =
		 *        false => ����
		 */
		System.out.println("1~100������ 3�ǹ�� ��:"+sum3);
		System.out.println("1~100������ 5�ǹ�� ��:"+sum5);
		System.out.println("1~100������ 7�ǹ�� ��:"+sum7);
		/*
		 *   A
		 *   B
		 *   C
		 *   
		 *   A B C D 
		 */
		char c='A';
		while(c<='Z')
		{
			System.out.print(c+" ");
			c++;
		}

	}

}







