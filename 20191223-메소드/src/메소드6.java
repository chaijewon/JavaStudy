import java.util.Scanner;
public class �޼ҵ�6 {
    // �����߻�
	static int[] getRand(int no)
	{
		int[] com=new int[no];
		int su=0;
		boolean bCheck=false;
		for(int i=0;i<no;i++)
		{
			bCheck=true;
			while(bCheck)
			{
				// ���� �߻�
				su=(int)(Math.random()*9)+1;
				bCheck=false;
				for(int j=0;j<i;j++)
				{
					if(com[j]==su)
					{
						bCheck=true; //while���� �̵�
						break;
					}
				}
			}
			// �ߺ��� ���� ����
			com[i]=su;
		}
		return com;
	}
	// ����� �Է� 
	static int[] userInput()
	{
		int[] user=new int[3];
		Scanner scan=new Scanner(System.in);
		while(true)
		{
			System.out.print("3�ڸ� ������ �Է�:");
			int input=scan.nextInt();
			if(input<100 || input>999)
			{
				System.out.println("�߸��� �Է��Դϴ�!!");
				continue;
			}
			user[0]=input/100;
			user[1]=(input%100)/10;
			user[2]=input%10;
			
			if(user[0]==user[1] || user[1]==user[2] || user[0]==user[2])
			{
				System.out.println("�ߺ��� ���� ����� �� �����ϴ�");
				continue;
			}
			
			if(user[0]==0 || user[1]==0 || user[2]==0)
			{
				System.out.println("0�� ��� �� �� �����ϴ�!!");
				continue;
			}
			
			break;
		}
		return user;
	}
	// �� 
	static int compare(int[] com,int[] user)
	{
		int s=0,b=0;
		for(int i=0;i<3;i++)
		{
			for(int j=0;j<3;j++)
			{
				// �迭�ȿ� ���� ���� ���翩��
				if(com[i]==user[j])
				{
					// ���� �ڸ� 
					if(i==j)
						s++;
					else
						b++;
				}
			}
		}
		
		hint(user, s, b);
		return s;
	}
	// ��Ʈ 
	static void hint(int[] user,int s,int b)
	{
		System.out.printf("Input Number:%d%d%d,Result:%dS-%dB\n",
				user[0],user[1],user[2],s,b);
	}
	// ���Ῡ�� 
	static boolean isEnd(int s)
	{
		boolean bCheck=false;
		if(s==3)
			bCheck=true;
		
		return bCheck;
	}
	
	// ���� 
	static void process()
	{
		int[] com=getRand(3);
		Scanner scan=new Scanner(System.in);
		while(true)
		{
		   int[] user=userInput();
		   int s=compare(com, user);
		   if(isEnd(s))
		   {
			   System.out.print("�����ұ��(y|n)?");
			   String data=scan.next();
			   if(data.equals("y"))
			   {
				   System.out.println("Game Over!!");
				   System.exit(0);
			   }
			   else
			   {
				   System.out.println("�� ������ ���۵Ǿ����ϴ�!!");
				   process();
			   }
		   }
		}
	}
	static String start()
	{
		return "������ �����մϴ�!!";
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.out.println(start());
		// int a=10
		String s=start();
		System.out.println(s);
        process();
	}

}










