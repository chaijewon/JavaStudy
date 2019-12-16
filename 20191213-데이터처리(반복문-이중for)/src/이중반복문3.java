/*
 *   // 정보처리,코딩테스트 => 2for
 *   // break : 반복 중단 
 *   for(int i=1;i<=10;i++)
 *   {
 *       if(i==5)
 *         break;==> 여기서 종료
 *       System.out.println(i);
 *   }
 *   // continue : 특정부분을 제외 할때 
 *   for(int i=1;i<=10;i++)
 *   {
 *       if(i==5)
 *         continue;// 여기서 => 증가한 다음에 다시 시작
 *       System.out.println(i);
 *   }
 */
public class 이중반복문3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(int i=1;i<=10;i++)
		{
		   if(i==5)
		   break;//==> 여기서 종료
		   System.out.println(i);
		}
		System.out.println("==== continue ====");
		
		 //int k=10; if(k%2==0) return;
		 
		for(int i=1;i<=10;i++)
		{
		   //if(i==5 || i==7)
		  if(i%2!=0)
		   continue;//==> 여기서 종료
		   System.out.println(i);
		}
	}

}
