import java.util.Scanner;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
/*
 *   ������:
 *   ������ :
 *   ...
 *   ...
 *   ...
 */
/*
 *  td class="info">
                              
             <a href="#" class="title ellipsis" title="���" onclick="fnPlaySong('89741945','1');return false;">
   �ٽô� ������� �ʰ�, �̺��� �����ϱ� �Ⱦ�</a>
 */
public class �޼ҵ�2 {
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
    // 1|����|������|�ٹ�|100
    // ��ü ������ ==> 
    /*
     *   <a href="#" class="artist ellipsis" onclick="fnViewArtist('14936387');return false;">������</a>
                                        
                                        <div class="toggle-button-box" >
                                            <button type="button" class="btn artist-etc" onclick="fnRelationArtistList('89741945');">��</button>
                                            <ul class="list" id="RelationArtist_89741945"></ul>
                                        </div>
                                        
                                        <i class="bar">|</i>
                                        <a href="#" class="albumtitle ellipsis" onclick="fnViewAlbumLayer('81337060');return false;">�ٽô� ������� �ʰ�, �̺��� �����ϱ� �Ⱦ�</a>
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
        System.out.println("===========���Ϲ��� top50===========");
        for(String s:title)
        {
        	System.out.println(s);
        }
        System.out.println("==================================");
        Scanner scan=new Scanner(System.in);
		/*
		 * System.out.print("���� �Է�:"); String name=scan.next(); for(String s:title) {
		 * if(s.contains(name)) { System.out.println(s); } }
		 */
        System.out.print("�󼼺� ������ȣ �Է�(1~50):");
        int no=scan.nextInt();
        String detail=getMusicInfo(no);
        // aaaaaa|bbbbbb
        // $ , . , ^ , | , ? 
        String[] value=detail.split("\\|");
        // StringTokenizer
        System.out.println("������:"+value[0]);
        System.out.println("�ٹ�:"+value[1]);
        
	}

}
