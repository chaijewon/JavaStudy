import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

/*
 *   {
    "_id" : ObjectId("5de083d182c7eea91c37aba6"),
    "cateno" : 1,
    "no" : 1,
    "title" : "�ܿ�ձ� 2 (2019)",
    "poster" : "//img1.daumcdn.net/thumb/C155x225/?fname=http%3A%2F%2Ft1.daumcdn.net%2Fmovie%2F5afd212b68e34e61a964d969dd898e2f1574298873981",
    "actor" : "������ ��",
    "director" : "ũ���� ��",
    "grade" : "103��, ��ü������",
    "genre" : "�ִϸ��̼�/��庥ó/�ڹ̵�/��Ÿ��/������",
    "score" : "7.6",
    "story" : "�� ������ ���� ��� ������? ���� �θ��� �� ��Ҹ��� ������? ��� �� ���ϰ� �ǹ��� ��Ҹ��� ���縦 �θ���, ��ȭ�ο� �Ʒ��� �ձ��� �����Ѵ�. Ʈ���� ��� ���� ���ſ��� ���۵Ǿ����� �˷��ָ� ������ ���� ��а� ������ ã�� �������Ѵٰ� �����Ѵ�. ���迡 ���� �Ʒ��� �ձ��� ���ؾ߸� �ϴ� ����� �ȳ��� ������ ������ ������ ã�� ũ��������, �ö��� �׸��� ������ �Բ� ����õ���� ���� ������ ������ �ȴ�. �ڽ��� ���� �η����ߴ� ����� ���� �� ������ ���ĳ����⿡ �ڽ��� ���� ����ϴٰ� �Ͼ�߸� �ϴµ��� 11��, �η����� ���� ���ο� ����� ������!",
    "key" : "F9Cuj4Q0P-0"
}

       
 */
class Category{
	int cateno; //cno
	String poster;
	String title;
	String subTitle;
	String link;
	
}
/*
 *   �ּ�	���� ���ֽ� �̵��̵� 1063-6
��ȭ��ȣ	064-726-5242
���� ����	ȸ / ����
���ݴ�	����-2����
����	������������
�����ð�	11:00 - 15:00
����	ȭ
�޴�	
�Ϻ굿 (��)
16,000�� |��ȸ�� (��)
10,500��
��ī�� (��)
10,500��
���ε��ε� (��)
26,000��
������ī����
9,800��
 */
class Food{
	int cateno;
	int no;
	String[] poster=new String[4];
	String title;
	double score;
	String addr;
	String tel;
	String type;
	String price;
	String packing;
	String time;
	String menu;
	int good;
	int soso;
	int bad;
	
}
/*
 *   <ul class="list-toplist-slider" style="width: 531px;">
            <li>
              <img class="center-croping" alt="2020 ���� �α� ���� TOP 60 ����"
                   data-lazy="https://mp-seoul-image-production-s3.mangoplate.com/keyword_search/meta/pictures/7zsdxmpu4kauzpk7.jpg?fit=around|600:400&amp;crop=600:400;*,*&amp;output-format=jpg&amp;output-quality=80"/>

              <a href="/top_lists/2264_jeju2020"
 *   <li>
              <img class="center-croping" alt="2020 ���� �α� ���� TOP 60 ����"
                   data-lazy="https://mp-seoul-image-production-s3.mangoplate.com/keyword_search/meta/pictures/7zsdxmpu4kauzpk7.jpg?fit=around|600:400&amp;crop=600:400;*,*&amp;output-format=jpg&amp;output-quality=80"/>
                   attr("data-lazy")
              <a href="/top_lists/2264_jeju2020"
                 onclick="trackEvent('CLICK_TOPLIST', {&quot;section_position&quot;:0,&quot;section_title&quot;:&quot;�ϰ� ���� ���� ����Ʈ&quot;,&quot;position&quot;:0,&quot;link_key&quot;:&quot;PQQTL_E&quot;});">
                <figure class="ls-item"> attr("class")
                  <figcaption class="info">
                    <div class="info_inner_wrap">
                    <span class="title">2020 ���� �α� ���� TOP 60</span>
                      <p class="desc">"������ �α� ������ ��� ��� ��Ҵ�!"</p>
                      
                    <div>
                      <span></span>
                      <p></p>
                    </div>
                      <span></span>
 */
public class FoodMain {
    Category[] foodCategoryData() throws Exception
    {
    	Category[] cate=new Category[12];
    	Document doc=Jsoup.connect("https://www.mangoplate.com/").get();
    	Elements title=doc.select("div.info_inner_wrap span.title");
    	Elements poster=doc.select("ul.list-toplist-slider img");
    	Elements sub=doc.select("div.info_inner_wrap p.desc");
    	Elements link=doc.select("ul.list-toplist-slider a");
    	for(int i=0;i<12;i++)
    	{
    		Category g=new Category();
    		g.cateno=i+1;
    		g.title="2020 ���� �α� ���� TOP 60";
    		g.subTitle=sub.get(i).text();
    		g.poster=poster.get(i).attr("data-lazy");
    		g.link=link.get(i).attr("href");
    		cate[i]=g;
    	}
    	return cate;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
       
        
	}

}




