package com.sist.exception;
/*
 *    ����ó�� 
 *    ====== �ҽ��󿡼� ������ ������ ���� (������ ����:���α׷��Ӱ� ó���� ����)
 *           0���� ������ 
 *           ���ϸ��� Ʋ���� 
 *           IP�� Ʋ���� 
 *           URL�ּҰ� Ʋ����
 *           �迭�� ������ �ʰ�
           ����ó�� 
            1) ������ �߻��� ������ �ϴ� ���α׷� 
            2) ������ �߻��� => ���� ���� ���� ��� 
            
            ==> "1,000" ==> "10,00"
           ����ó��
                             �ڹ�
         ======================
         |                    |
             �����Ͻ�  (javac)        ����� (java)
      ===============       ============
       JVM�� �˻�                            ����ø��� ���� 
     => �ݵ�� ����ó��                  => �ʿ��ϸ� ����ó���� �Ѵ� 
              �����
         = �޸� ����� 
           System.out.print()
           System.in.read()
         = File �����
         = ��Ʈ��ũ ����� 
       
 */
public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//int a=System.in.read();
        int[] arr=new int[6];
        //try {
        	for(int i=0;i<=6;i++)
            {
            	arr[i]=(int)(Math.random()*45)+1;
            }
        //}catch(Exception e) {System.out.println("�����߻�");}
       
        
	        for(int i=0;i<6;i++)
	        {
	        	System.out.print(arr[i]+" ");
	        	
	        	try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	        }
        
        
        
	}

}





