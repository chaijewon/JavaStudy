package com.sist.exception;
/*
 *    ����ó�� 
 *    ======
 *      ����ó�� ���� 
 *      ���ܺ��� : try~catch (����ó��)  =============> 70%
 *      ����ȸ�� : throws (����ó�� => �ý��ۿ� ���� ó��) ==> 29%
 *      ���ܹ߻� : throw (����� ���� ����ó��) =====> 1%
 *      
 *      ===========================================
 *      try ~ catch ~ finally(�����ص� ����)
 *      
 *      ����)
 *           try
 *           {
 *            
 *              ��������� �� �� �ִ� ���� 
 *              1�� ���� 
 *              2�� ����
 *              3�� ����  ==> 1���� �����߻� ==> catch�� ���� 
 *              =======
 *              4�� ����
 *              5�� ����
 *              ======= ������ �� ���� ����
 *              
 *           }catch(����Ǵ� ���� 1)
 *           {
 *              ���� ���� 
 *              6�� ����
 *           }catch(����Ǵ� ���� 2)
 *           {
 *           
 *              ���� ����
 *              7�� ����
 *           }catch(����Ǵ� ���� 3)
 *           {
 *              ���� ����
 *              8�� ����
 *           }finally
 *           {
 *               ������� OR ���������� �����ϵ� ������� ������ �����ϴ� ���� 
 *               9�� ����
 *           }
 *           
 *           10�� ����
 *           
 *           
 *           try
 *           {
 *               for(int i=0;i<10;i++)
 *               {
 *                   ���๮��  ===> i==5 ���ܹ߻� 
 *               }
 *           }catch(Exception ex){}
 *           
 *           for(int i=0;i<10;i++)
 *           {
 *               try
 *               {
 *                   ���๮��  ===> i==5 ���ܹ߻� 
 *               }catch(Exception ex){}
 *           }
 *           
 *      
 */
public class MainClass2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * try { for(int i=1;i<=10;i++) { if(i==5) { int a=10/0;// catch }
		 * System.out.println("i="+i); } }catch(Exception ex) {
		 * System.out.println("���� �߻�"); }
		 */
		for(int i=1;i<=10;i++)
		{
			try
			{
				if(i==5)
				{
					int a=10/0;
				}
				System.out.println("i="+i);
			}catch(Exception ex) 
			{
				System.out.println("�����߻�");
			}
		}
	}

}








