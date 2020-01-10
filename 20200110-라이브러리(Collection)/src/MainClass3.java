import java.util.*;
public class MainClass3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        ArrayList<Integer> list=new ArrayList<Integer>();
        list.add(10);
        list.add(20);
        
        for(int i=0;i<list.size();i++)
        {
        	int num=list.get(i);
        	System.out.println(num);
        }
	}

}
