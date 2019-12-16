
public class 배열3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        int com=(int)(Math.random()*3); //0,1,2
        /*if(com==0)
        	System.out.println("가위");
        else if(com==1)
        	System.out.println("바위");
        else if(com==2)
        	System.out.println("보");
        */
        String[] res= {"가위","바위","보"};
        System.out.println(res[com]);
        
	}

}
