import java.util.Scanner;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
/*
 *  td class="info">
                              
             <a href="#" class="title ellipsis" title="재생" onclick="fnPlaySong('89741945','1');return false;">
   다시는 사랑하지 않고, 이별에 아파하기 싫어</a>
 */
public class 메소드2 {
    static String[] getMusicTitle() throws Exception
    {
    	String[] list=new String[50];
    	Document doc=Jsoup.connect("https://www.genie.co.kr/chart/top200").get();
    	Elements title=doc.select("td.info a.title");
    	
    	for(int i=0;i<50;i++)
    	{
    		list[i]=title.get(i).text();
    	}
    	return list;
    }
    // 1|제목|가수명|앨범|100
    // 전체 데이터 ==> 
    // 
    static String getMusicInfo(int no) throws Exception
    {
    	
    }
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
        String[] title=getMusicTitle();
        System.out.println("===========지니뮤직 top50===========");
        for(String s:title)
        {
        	System.out.println(s);
        }
        System.out.println("==================================");
        Scanner scan=new Scanner(System.in);
        System.out.print("제목 입력:");
        String name=scan.next();
        for(String s:title)
        {
        	if(s.contains(name))
        	{
        		System.out.println(s);
        	}
        }
        
	}

}
