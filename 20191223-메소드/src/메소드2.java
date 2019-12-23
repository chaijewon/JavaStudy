import java.util.Scanner;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
/*
 *   제작자:
 *   수정일 :
 *   ...
 *   ...
 *   ...
 */
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
    /*
     *   <a href="#" class="artist ellipsis" onclick="fnViewArtist('14936387');return false;">백지영</a>
                                        
                                        <div class="toggle-button-box" >
                                            <button type="button" class="btn artist-etc" onclick="fnRelationArtistList('89741945');">외</button>
                                            <ul class="list" id="RelationArtist_89741945"></ul>
                                        </div>
                                        
                                        <i class="bar">|</i>
                                        <a href="#" class="albumtitle ellipsis" onclick="fnViewAlbumLayer('81337060');return false;">다시는 사랑하지 않고, 이별에 아파하기 싫어</a>
     */
    static String getMusicInfo(int no) throws Exception
    {
    	String res="";
  
    	Document doc=Jsoup.connect("https://www.genie.co.kr/chart/top200").get();
    	Elements singer=doc.select("td.info a.artist");
    	Elements album=doc.select("td.info a.albumtitle");
    	for(int i=0;i<50;i++)
    	{
    		if(i==(no-1))
    		{
    			res=singer.get(i).text()+"|"+album.get(i).text();
    			break;
    		}
    	}
    	
    	return res;
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
		/*
		 * System.out.print("제목 입력:"); String name=scan.next(); for(String s:title) {
		 * if(s.contains(name)) { System.out.println(s); } }
		 */
        System.out.print("상세볼 뮤직번호 입력(1~50):");
        int no=scan.nextInt();
        String detail=getMusicInfo(no);
        // aaaaaa|bbbbbb
        // $ , . , ^ , | , ? 
        String[] value=detail.split("\\|");
        // StringTokenizer
        System.out.println("가수명:"+value[0]);
        System.out.println("앨범:"+value[1]);
        
	}

}
