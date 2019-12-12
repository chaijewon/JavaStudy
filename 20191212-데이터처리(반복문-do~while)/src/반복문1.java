/*
 *    do~while : 한번 이상을 수행하는 반복문 (빈도 많이 없다)
 *    형식)
 *          데이터베이스 : 웹 
 *          네트워크 : 스마트
 *          ==============
 *          
 *          // C,C++,C#,Java => 0 (문자열,자료구조(List,Set,Map),배열)
 *          라면 
 *            물  ===> 1
 *            달걀  3
 *            스프  2
 *            라면  1   로직 (스타일)
 *          
 *          초기값 => 항상 1이다 (X) 
 *          do{
 *               실행문장 ==> 여러문장을 사용 할수 있다 
 *               증가식 ==> 증감식
 *                   i++ , i--
 *                   i+=2, i-=2
 *          }while(조건문);
 *          
 */
public class 반복문1 {
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        // 1~10까지 
		int i=1;// 1~10 => 루프변수 
		do {
			 System.out.println("i="+i);
			 i++;
		}while(i<=10);
		System.out.println("10~1");
		do {
			 System.out.println("i="+(i-1));
			 i--;
		}while(i>1);
	}

}







