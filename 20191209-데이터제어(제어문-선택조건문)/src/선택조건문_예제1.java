
public class 선택조건문_예제1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        // 난수 => 컴퓨터에서 임의의 수를 추출 
		int score=(int)(Math.random()*101); //0~100
		//      0.0~0.99  ==> 0.99*101 ==> 100..0
		System.out.println("score="+score);
		
		// 90이상 => A , 80=> B  , 70 => C  , 60 => D , 60이하 => F
		if(score<60)
		{
			System.out.println("F학점입니다");
		}
		else
		{
			// 중첩 if => 이중 조건문 
			// if문 여러개를 사용했을 경우에는 조건 맞는 모든 문장을 수행 할 수 있다
			if(score>=90 && score<=100)
				System.out.println("A학점");
			if(score>=80 && score<90)
				System.out.println("B학점");
			if(score>=70 && score<80)
				System.out.println("C학점");
			if(score>=60 && score<70)
				System.out.println("D학점");
		}
	}

}
