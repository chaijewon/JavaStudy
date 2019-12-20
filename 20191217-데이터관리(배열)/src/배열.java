/*
 *   �迭 => ���������͸� �Ѱ��� �̸����� ���� => �ε���(÷��)�� �̿��Ѵ� 
 *          ** �ε����� 0���� ���� 
 *   1) ����
 *      1. ���� 
 *         ��������[] �迭��
 *         ======
 *          = �⺻Ÿ��(int,long,float,double...)
 *            int[] arr
 *            long[] arr
 *            char[] arr
 *          = ����� ���� Ÿ��(Ŭ����)
 *            class Movie
 *            Movie[] arr
 *            String[] names
 *            ======
 *            ����� ���� 
 *      2. �ʱⰪ
 *          = arr={1,2,3,4,5,6}
 *          = arr=new int[6] ==> ��ü �ʱⰪ (int:0,long:0L,String:null)
 *            null ==> �޸𸮿� ����� �ּҰ��� �������� �ʴ´� 
 *      3. ������ �б�
 *          = arr[index] ==> �������� �Ѱ��� ���� 
 *      4. ������ ���� 
 *          = arr[1]=10
 */
/*
 *    ���� �߱� ����
 *    ========== SB
 *      => ���� => 729
 *      => ����� �Է� => 567 ==> 0S-1B 
 *      =>            785  ==> 1S-0B
 *                    793  ==> 1S-1B
 *                    279  ==> 1S-2B
 *                    729  ==> 3S-0B ==> break
 */
import java.util.Scanner;
/*
 *    1. �ߺ����� ���� �߻�   ==> com[]
 *    ==================
 *    2. ����� �Է�  ==> user[]
 *       �� ==> com[] user[]
 *    3. ��Ʈ ==> s b
 *    4. ���Ῡ�� Ȯ��  s
 *    5. 3S=> �����Ѵ� 
 *    ================== �ݺ� while
 */
// ������Ʈ 
/*
 *    ����    ������  ���   ���
 *         ==========
 *            �޼ҵ� 
 *    ===================== Ŭ���� 
 *    
 *    �ڽŰ� , ���� , ���� , ���� 
 *    ���� => �䱸���� ==> �м�  
 */
public class �迭 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] com=new int[3];
        int su=0;// ���� �߻��� ���� 
        boolean bCheck=false;// �ߺ����θ� Ȯ�� 
        
        for(int i=0;i<com.length;i++)
        {
        	bCheck=true;
        	//=================
        	/*
        	 *     com[0]=9
        	 *     com[1]=8
        	 *     su=8 ==>
        	 */
        	while(bCheck)
        	{
        		//���� �߻� 
        		su=(int)(Math.random()*9)+1;
        		bCheck=false;
        		//�ߺ����� Ȯ�� 
        		for(int j=0;j<i;j++)
        		{
        			if(com[j]==su)
        			{
        				bCheck=true;
        				break;
        			}
        		}
        	}
        	//=================
        	com[i]=su;
        }
        int[] user=new int[3];
        Scanner scan=new Scanner(System.in);
        while(true)
        {
        	System.out.print("3�ڸ� ���� �Է�:");
        	// ���� �޴´� 
        	int input=scan.nextInt();
        	// ���� ó�� 
        	if(input<100 || input>999)
        	{
        		System.out.println("�߸��� �Է��Դϴ�.�ٽ� �Է��ϼ���");
        		continue;
        	}
        	
        	// �迭�� ���� ����   567/100
        	user[0]=input/100;// 5
        	user[1]=(input%100)/10;// 6
        	user[2]=input%10;//7
        	
        	// ���� ó�� => �ߺ��� ���� ����� �� ���� , 0�� ��� �� �� ����
        	// 729 => 777 1S-2B
        	// ��ȿ�� �˻� 
        	if(user[0]==user[1] || user[1]==user[2] || user[0]==user[2])
        	{
        		System.out.println("�ߺ��� ���� ��� �� �� �����ϴ�");
        		continue; // ó������ �ٽ� ���� 
        	}
        	
        	if(user[0]==0 || user[1]==0 || user[2]==0)
        	{
        		System.out.println("0�� ��� �� �� �����ϴ�");
        		continue;
        	}
        	
        	// �� ���� 
        	int s=0,b=0;
        	for(int i=0;i<3;i++) // i ==> com
        	{
        		for(int j=0;j<3;j++) // j ==> user
        		{
        			if(com[i]==user[j])
        			{
        				if(i==j)
        					s++;
        				else
        					b++;
        			}
        		}
        	}
        	// ��Ʈ 
        	System.out.printf("Input Number:%d,Result:%dS-%dB\n",
        			input,s,b);
        	System.out.println("=======================");
        	System.out.print("S:");
        	for(int i=0;i<s;i++)
        	{
        		System.out.print("��");
        	}
        	System.out.print("\nB:");
        	for(int i=0;i<b;i++)
        	{
        		System.out.print("��");
        	}
        	System.out.println("\n=======================");
        	// ���Ῡ�� Ȯ�� 
        	if(s==3)
        	{
        		System.out.println("Game Over!!");
        		break;
        	}
        	
        }
	}

}






