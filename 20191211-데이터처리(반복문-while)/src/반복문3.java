// 가위바위보 ==> 5   ==> 1승 3패 1무 
import java.util.Scanner;
public class 반복문3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        int i=1;
        int win=0,lose=0,same=0;
        /*
         *     com-user 
         *     가위 (0) - 가위(0)   ==> 0
         *              바위(1)    ==> -1
         *              보(2)     ==> 2
         *     바위(1) - 가위(0)    ==> 1
         *              바위(1)    ==> 0
         *              보(2)      ==> -1
         *     보(2)  - 가위(0)     ==> 2
         *              바위(1)     ==> 1
         *              보(2)       ==> 0
         *              
         *     사용자 ==> -1,2
         *     컴퓨터 ==> 1,-2
         */
        Scanner scan=new Scanner(System.in);
        while(i<=5)
        {
        	// 가위 바위 보 게임
        	// 컴퓨터 => 가위바위보 
        	int com=(int)(Math.random()*3); // 0~2
        	// 사용자 => 입력 
        	System.out.print("가위(0),바위(1),보(2):");
        	int user=scan.nextInt();
        	// 비교 
        	
        	int res=com-user;
			/*
			 * if(res==-1 || res==2) { // 사용자 win win++; } else if(res==1 || res==-2) { //
			 * 컴퓨터 win lose++; } else { // 비겼다 same++; }
			 */
        	switch(res)
        	{
        	case -1:
        	case 2:
        		win++;
        		break;
        	case 1:
        	case -2:
        		lose++;
        		break;
        	default: same++;
        	}
        	i++;
        }
        
        // 승 무 패...
        System.out.println("사용자 전적:"+win+"승 "+same+"무 "+lose+"패");
	}

}





