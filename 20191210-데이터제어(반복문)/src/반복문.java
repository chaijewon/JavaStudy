/*
 *    반복문 
 *      =============== 선조건 
 *      = for : 반복횟수 지정      
 *      = while : 지정이 없는 경우 
 *        초기값 
 *        while(조건문)
 *        {
 *           실행문장 
 *           증가식 
 *        }
 *      =============== 후조건
 *      = do~while : 한번 이상은 반드시 수행
 *        초기값
 *        do
 *        {
 *           실행문장
 *           증가식
 *        }while(조건문)
 *      ===============
 */
public class 반복문 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * String[] s= {"a","b","c","d","e","f","g","h","i","k"}; int[] ss=
		 * {3,4,6,7,8,9,10,11,4,5}; int i=0; while(i<10) {
		 * System.out.println(s[i]+"-"+ss[i]); i++; }
		 */
		int i=1;  // 1
		int sum3=0,sum5=0,sum7=0; 
		while(i<=100) //2
		{
			if(i%3==0)
				sum3+=i;
			if(i%5==0)
				sum5+=i;
			if(i%7==0)
				sum7+=i;
			i++; // 4
		}
		/*
		 *    i=1 ==> sum=1
		 *    i=2 ==> sum=3
		 *    i=3 ==> sum=6
		 */
		//System.out.println("1~100까지의 합:"+sum);
		/*
		 *    1==>2==>3==>4
		 *        2==>3==>4
		 *        =
		 *        false => 종료
		 */
		System.out.println("1~100까지의 3의배수 합:"+sum3);
		System.out.println("1~100까지의 5의배수 합:"+sum5);
		System.out.println("1~100까지의 7의배수 합:"+sum7);
		/*
		 *   A
		 *   B
		 *   C
		 *   
		 *   A B C D 
		 */
		char c='A';
		while(c<='Z')
		{
			System.out.print(c+" ");
			c++;
		}

	}

}







