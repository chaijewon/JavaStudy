package com.sist.exception;
/*
 *    예외처리 
 *    ====== 소스상에서 수정이 가능한 에러 (가벼운 에러:프로그래머가 처리가 가능)
 *           0으로 나눈다 
 *           파일명이 틀리다 
 *           IP가 틀리다 
 *           URL주소가 틀리다
 *           배열의 범위가 초과
           예외처리 
            1) 에러가 발생시 예방을 하는 프로그램 
            2) 에러가 발생시 => 정상 상태 유지 방법 
            
            ==> "1,000" ==> "10,00"
           예외처리
                             자바
         ======================
         |                    |
             컴파일시  (javac)        실행시 (java)
      ===============       ============
       JVM이 검색                            실행시마다 에러 
     => 반드시 예외처리                  => 필요하면 예외처리를 한다 
              입출력
         = 메모리 입출력 
           System.out.print()
           System.in.read()
         = File 입출력
         = 네트워크 입출력 
       
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
        //}catch(Exception e) {System.out.println("오류발생");}
       
        
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





