
public class �������ǹ�_����1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        // ���� => ��ǻ�Ϳ��� ������ ���� ���� 
		int score=(int)(Math.random()*101); //0~100
		//      0.0~0.99  ==> 0.99*101 ==> 100..0
		System.out.println("score="+score);
		
		// 90�̻� => A , 80=> B  , 70 => C  , 60 => D , 60���� => F
		if(score<60)
		{
			System.out.println("F�����Դϴ�");
		}
		else
		{
			// ��ø if => ���� ���ǹ� 
			// if�� �������� ������� ��쿡�� ���� �´� ��� ������ ���� �� �� �ִ�
			if(score>=90 && score<=100)
				System.out.println("A����");
			if(score>=80 && score<90)
				System.out.println("B����");
			if(score>=70 && score<80)
				System.out.println("C����");
			if(score>=60 && score<70)
				System.out.println("D����");
		}
	}

}
