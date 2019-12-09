/*
 *    조건문 : true/false일때 별도로 처리를 따로 한다 
 *      형식)
 *           if(조건문)
 *             실행 문장  ==> 조건문 true 
 *           else
 *             실행 문장  ==> 조건문 false
 *             
 *           예) 
 *               사용자 => 두개의 정수 입력 => 처리 (나누기)
 *               
 *               0/2 ==> 0
 *               2/0 ==> error
 *               
 *               ===> if ==> error 방지 , 원하는 데이터 
 *                           =========
 *                           실제 처리 
 *               
 */
public class 선택조건문_형식 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        // 나누기 
		int a=10;
		int b=2;
		//System.out.println("a/b="+(a/b));
		if(b==0)
			System.out.println("0으로 나눌 수 없습니다");
		else
			System.out.println("a/b="+(a/b));
	}

}









