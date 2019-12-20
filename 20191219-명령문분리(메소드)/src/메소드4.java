/*
 *    ===========================
 *     1. 메소드 호출 
 *     2. 메소드 블록으로 접근 
 *     3. 블록안에 있는 모든 모든 문장 수행 
 *     4. 메소드 호출한 위치로 돌아간다 
 *    =========================== 
 *    
 *     게시판 
 *      목록출력 
 *      내용보기 
 *      글쓰기 
 *      수정하기 
 *      답변하기
 *      삭제하기
 *      찾기
 *    
 */
import java.util.Scanner;
public class 메소드4 {
    static void gugudan(int dan)
    {
    	for(int i=1;i<=9;i++)
    	{
    		System.out.printf("%d*%d=%d\n",dan,i,dan*i);
    	}
    }
    static String gugudan2(int dan)
    {
    	String result="";
    	for(int i=1;i<=9;i++)
    	{
    		result+=dan+"*"+i+"="+(dan*i)+"\n";
    	}
    	
    	return result;
    }
    static void process() 
    {
        Scanner scan=new Scanner(System.in);
        System.out.print("단 입력:");
        int dan=scan.nextInt();
        // 구구단 
        String res=gugudan2(dan);
        System.out.println(res);
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
         process();
	}

}








