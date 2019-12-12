/*
 *    반복문 
 *    
 *    while
 *      형식)
 *           초기값              ===>  1
 *           while(조건문) ===>  2
 *           {
 *              반복 실행문장 ===> 3
 *              증가식           ===> 4   ===> 2 = 3= 4 
 *                                      ==
 *                                      false면 종료
 *           }
 *           
 *           예)
 *              1~10 
 *              int i=1;
 *              while(i<=10)  ==> 선조건 (실행이 안될 수도 있다)
 *              {
 *                 System.out.println(i);
 *                 i++;
 *              }
 *    do~while
 *       형식)  ==> 후조건 
 *            초기값  ======== 1
 *            do
 *            {
 *                실행문장 === 2
 *                증가식    === 3
 *            }while(조건문); ==> 4
 *            
 *       예)
 *            int i=1;
 *            do
 *            {
 *                System.out.println(i); // 출력
 *                i++; // i=2
 *            }while(i<=10);
 *    
 *    for
 *        형식) 
 *                  1    2    4
 *            for(초기값;조건식;증가식)
 *            {
 *                실행문장   => 3
 *            }
 *            
 *         예)
 *             for(int i=1;i<=10;i++)
 *             {
 *                 System.out.println(i)
 *             }
 *             
 *        ================================
 *        출력 
 *          ===========================
 *    
 */
public class 반복문1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        int i=1;
        while(i<=10)
        {
        	
        	System.out.print(i+"\t");
        	if(i%3==0)
        		System.out.println();
        	i++;
        }
        
        System.out.println("\ndo~while");
        
        i=1;
        do {
        	System.out.print(i+"\t");
        	if(i%3==0)
        		System.out.println();
        	i++;
        }while(i<=10);
        
        System.out.println("\nfor");
        for(i=1;i<=10;i++)
        {
        	System.out.print(i+"\t");
        	if(i%3==0)
        		System.out.println();
        }
        
	}

}






