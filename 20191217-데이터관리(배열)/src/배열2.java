/*
 *    중복이 없는 난수 
 *    => 배열 
 *    ============
 *    =======
 *    난수발생  ==> 
 *    =======
 *    
 *    =======
 *    => 제어문 
 *       for()
 *       {
 *          for()
 *          {
 *          }
 *       }
 *       
 *       for()
 *       {
 *          do{
 *          }while()
 *       }
 *       
 *       for()
 *       {
 *          while()
 *          {
 *          }
 *       }
 *       
 *       while()
 *       {
 *          do{
 *          }while()
 *       }
 *       
 *       while()
 *       {
 *         for()
 *         {
 *         }
 *       }
 *       
 *       for => while => do~while ==> 8
 */
public class 배열2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        int[] com=new int[9];
        int su=0;// 난수 발생시 저장 
        boolean bCheck=false;// 중복여부를 확인 
        
        for(int i=0;i<com.length;i++)
        {
        	bCheck=true;
        	//=================
        	/*
        	 *     com[0]=9
        	 *     com[1]=8
        	 *     su=8 ==>
        	 */
        	while(bCheck)// for(;;) 
        	{
        		//난수 발생 
        		su=(int)(Math.random()*9)+1;
        		System.out.println(su);
        		bCheck=false;
        		//중복여부 확인 
        		for(int j=0;j<i;j++)
        		{
        			if(com[j]==su)
        			{
        				bCheck=true;
        				break;
        			}
					/*
					 * else { bCheck=false; break; }
					 */
        		}
        	}
        	//=================
        	com[i]=su;
        }
        
        // 출력 
        for(int i:com)
        {
        	System.out.print(i+" ");
        }
	}

}







