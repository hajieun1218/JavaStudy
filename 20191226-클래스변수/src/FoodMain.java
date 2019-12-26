import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

class Category {
	int cateno;  // ī�װ� ��ȣ
	String poster;
	String title;
	String subTitle;
	String link;
}

class Food {
	int cateno;
	int no;
	String[] poster = new String[4];
	String title;
	double score;
	String addr;
	String tell;
	String type;
	String price;
	String parking;
	String time;
	String menu;
	int good;
	int soso;
	int bad;
}

/*
 * 
    <ul class="list-toplist-slider" style="width: 531px;">
 *   <li>
              <img class="center-croping" alt="2020 ���� �α� ���� TOP 60 ����"
                   data-lazy="https://mp-seoul-image-production-s3.mangoplate.com/keyword_search/meta/pictures/7zsdxmpu4kauzpk7.jpg?fit=around|600:400&amp;crop=600:400;*,*&amp;output-format=jpg&amp;output-quality=80"/>

              <a href="/top_lists/2264_jeju2020"
                 onclick="trackEvent('CLICK_TOPLIST', {&quot;section_position&quot;:0,&quot;section_title&quot;:&quot;�ϰ� ���� ���� ����Ʈ&quot;,&quot;position&quot;:0,&quot;link_key&quot;:&quot;PQQTL_E&quot;});">
                <figure class="ls-item">
                  <figcaption class="info">
                    <div class="info_inner_wrap">
                      <span class="title">2020 ���� �α� ���� TOP 60</span>
                      <p class="desc">"������ �α� ������ ��� ��� ��Ҵ�!"</p>
                      
                      
                      �±� ���� => text    
                      �±� �ȿ� => attr    attr("class")
                      
          <p> => ������ ���
          <li> => �޴�, ����, ... 
 */
public class FoodMain {

	Category[] foodCategoryData() throws Exception{
		Category[] cate = new Category[12];
		Document doc = Jsoup.connect("https://www.mangoplate.com/").get();
		Elements title = doc.select("div.info_inner_wrap span.title");
		Elements poster = doc.select("ul.list-toplist-slider img");
		Elements sub = doc.select("div.info_inner_wrap p.desc");
		Elements link = doc.select("ul.list-toplist-slider a");
		for(int i=0; i<12; i++) {
			Category g = new Category();
			g.cateno = i+1;
			g.title = title.get(i).text();
			g.subTitle = sub.get(i).text();
			g.poster = poster.get(i).attr("data-lazy");
			g.link = link.get(i).attr("href");
			cate[i] = g;
		}
		
		return cate;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
	}

}
