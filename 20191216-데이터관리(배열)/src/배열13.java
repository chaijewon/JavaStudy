/*
 * 
 */
import java.util.*;
class Client {
	String id;
	int score;
	int rank;
}
public class ¹è¿­13 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Vector<Client> userVc=new Vector<Client>();
        Client c=new Client();
        c.id="hong";
        c.score=80;
        userVc.add(c);
        
        c=new Client();
        c.id="shim";
        c.score=70;
        userVc.add(c);
        
        c=new Client();
        c.id="kim";
        c.score=85;
        userVc.add(c);
        
        for(int i=0;i<userVc.size();i++)
        {
        	Client user=userVc.get(i);
        	user.rank=1;
        	for(int j=0;j<userVc.size();j++)
        	{
        		Client user2=userVc.get(j);
        		if(user.score<user2.score)
        		{
        			user.rank++;
        		}
        	}
        }
        
        for(Client u:userVc)
        {
        	System.out.println(u.id+"|"+u.score+"|"+u.rank);
        }
        
	}

}





