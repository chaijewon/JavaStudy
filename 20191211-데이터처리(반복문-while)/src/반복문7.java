import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
/*
 * 
 *    <td class="info">
                                    
            <a href="#" class="title ellipsis" title="���" 
            onclick="fnPlaySong('89702558','1');return false;">
           Popo (How deep is our love?)</a>

                                        <a href="#" class="artist ellipsis" onclick="fnViewArtist('80287630');return false;">�鿹��</a>
                                        
 *   <a href="#" class="title text-bold" onclick="fnPlaySong('89613039','1'); return false;"><span>Blueming
</span></a>
                <a href="#" class="artist ellipsis" onclick="fnViewArtist('67872918'); return false;">������ (IU)</a>
                <dl class="desc">
                    <dt>4��</dt>
                    <dd>8�ð� °</dd>
                    <dt>5����</dt>
                    <dd>9�ð� °
                        
                            <span class="top-duration">17�ð�</span></dd>
                        
                </dl>
 */
import java.util.Scanner;
public class �ݺ���7 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		
		Scanner scan=new Scanner(System.in);
		System.out.print("�˻��� �Է�:");
		String fd=scan.next();
		
	 int k=1;
	 while(k<=4)
	 {
		Document doc=Jsoup.connect("https://www.genie.co.kr/chart/top200?ditc=D&ymd=20191211&hh=15&rtm=Y&pg="+k).get();
		//System.out.println(doc);
		Elements title=doc.select("td.info a.title");
		Elements singer=doc.select("td.info a.artist");
		int i=0;
		while(i<title.size())
		{
			String data=title.get(i).text();
			//if(data.contains(fd))
			//{
			  System.out.println(data);
			  System.out.println(singer.get(i).text());
			  System.out.println("============================");
			//}
			i++;
		}
		
		k++;
	 }
	}
    public static void music() throws Exception
    {
    	int k=1;
   	 while(k<=4)
   	 {
   		Document doc=Jsoup.connect("https://www.genie.co.kr/chart/top200?ditc=D&ymd=20191211&hh=15&rtm=Y&pg="+k).get();
   		//System.out.println(doc);
   		Elements title=doc.select("td.info a.title");
   		Elements singer=doc.select("td.info a.artist");
   		int i=0;
   		while(i<title.size())
   		{
   			String data=title.get(i).text();
   			//if(data.contains(fd))
   			//{
   			  System.out.println(data);
   			  System.out.println(singer.get(i).text());
   			  System.out.println("============================");
   			//}
   			i++;
   		}
   		
   		k++;
   	 }
    }

}
