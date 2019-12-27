import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

/*
 *   {
    "_id" : ObjectId("5de083d182c7eea91c37aba6"),
    "cateno" : 1,
    "no" : 1,
    "title" : "겨울왕국 2 (2019)",
    "poster" : "//img1.daumcdn.net/thumb/C155x225/?fname=http%3A%2F%2Ft1.daumcdn.net%2Fmovie%2F5afd212b68e34e61a964d969dd898e2f1574298873981",
    "actor" : "제니퍼 리",
    "director" : "크리스 벅",
    "grade" : "103분, 전체관람가",
    "genre" : "애니메이션/어드벤처/코미디/판타지/뮤지컬",
    "score" : "7.6",
    "story" : "내 마법의 힘은 어디서 왔을까? 나를 부르는 저 목소리는 누구지? 어느 날 부턴가 의문의 목소리가 엘사를 부르고, 평화로운 아렌델 왕국을 위협한다. 트롤은 모든 것은 과거에서 시작되었음을 알려주며 엘사의 힘의 비밀과 진실을 찾아 떠나야한다고 조언한다. 위험에 빠진 아렌델 왕국을 구해야만 하는 엘사와 안나는 숨겨진 과거의 진실을 찾아 크리스토프, 올라프 그리고 스벤과 함께 위험천만한 놀라운 모험을 떠나게 된다. 자신의 힘을 두려워했던 엘사는 이제 이 모험을 헤쳐나가기에 자신의 힘이 충분하다고 믿어야만 하는데… 11월, 두려움을 깨고 새로운 운명을 만나다!",
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
 *   주소	제주 제주시 이도이동 1063-6
전화번호	064-726-5242
음식 종류	회 / 스시
가격대	만원-2만원
주차	주차공간없음
영업시간	11:00 - 15:00
휴일	화
메뉴	
하브동 (소)
16,000원 |육회동 (소)
10,500원
데카동 (소)
10,500원
도로도로동 (소)
26,000원
마구로카츠동
9,800원
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
              <img class="center-croping" alt="2020 제주 인기 맛집 TOP 60 사진"
                   data-lazy="https://mp-seoul-image-production-s3.mangoplate.com/keyword_search/meta/pictures/7zsdxmpu4kauzpk7.jpg?fit=around|600:400&amp;crop=600:400;*,*&amp;output-format=jpg&amp;output-quality=80"/>

              <a href="/top_lists/2264_jeju2020"
 *   <li>
              <img class="center-croping" alt="2020 제주 인기 맛집 TOP 60 사진"
                   data-lazy="https://mp-seoul-image-production-s3.mangoplate.com/keyword_search/meta/pictures/7zsdxmpu4kauzpk7.jpg?fit=around|600:400&amp;crop=600:400;*,*&amp;output-format=jpg&amp;output-quality=80"/>
                   attr("data-lazy")
              <a href="/top_lists/2264_jeju2020"
                 onclick="trackEvent('CLICK_TOPLIST', {&quot;section_position&quot;:0,&quot;section_title&quot;:&quot;믿고 보는 맛집 리스트&quot;,&quot;position&quot;:0,&quot;link_key&quot;:&quot;PQQTL_E&quot;});">
                <figure class="ls-item"> attr("class")
                  <figcaption class="info">
                    <div class="info_inner_wrap">
                    <span class="title">2020 제주 인기 맛집 TOP 60</span>
                      <p class="desc">"제주의 인기 맛집만 쏙쏙 골라 모았다!"</p>
                      
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
    		g.title="2020 제주 인기 맛집 TOP 60";
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




