package com.sist.exception;
/*
 *    예외처리 
 *    ======
 *      예외처리 종류 
 *      예외복구 : try~catch (직접처리)  =============> 70%
 *      예외회피 : throws (간접처리 => 시스템에 의해 처리) ==> 29%
 *      예외발생 : throw (사용자 정의 예외처리) =====> 1%
 *      
 *      ===========================================
 *      try ~ catch ~ finally(생략해도 무방)
 *      
 *      형식)
 *           try
 *           {
 *            
 *              정상수행을 할 수 있는 문장 
 *              1번 문장 
 *              2번 문장
 *              3번 문장  ==> 1유형 에러발생 ==> catch를 수행 
 *              =======
 *              4번 문장
 *              5번 문장
 *              ======= 수행할 수 없는 문장
 *              
 *           }catch(예상되는 예외 1)
 *           {
 *              복구 문장 
 *              6번 문장
 *           }catch(예상되는 예외 2)
 *           {
 *           
 *              복구 문장
 *              7번 문장
 *           }catch(예상되는 예외 3)
 *           {
 *              복구 문장
 *              8번 문장
 *           }finally
 *           {
 *               정상수행 OR 복구문장을 수행하든 관계없이 무조건 수행하는 문장 
 *               9번 문장
 *           }
 *           
 *           10번 문장
 *           
 *           
 *           try
 *           {
 *               for(int i=0;i<10;i++)
 *               {
 *                   실행문장  ===> i==5 예외발생 
 *               }
 *           }catch(Exception ex){}
 *           
 *           for(int i=0;i<10;i++)
 *           {
 *               try
 *               {
 *                   실행문장  ===> i==5 예외발생 
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
		 * System.out.println("오류 발생"); }
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
				System.out.println("오류발생");
			}
		}
	}

}








