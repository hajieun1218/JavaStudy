import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import java.util.Scanner;
/*
 *   <td class="info">
     <a href="#" class="title ellipsis" title="재생" onclick="fnPlaySong('89296790','1');return false;">
              안녕</a>
     <a href="#" class="artist ellipsis" onclick="fnViewArtist('80247689');return false;">폴킴</a>
 */

public class 반복문7 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		Scanner scan = new Scanner(System.in);
		System.out.print("검색어 입력 :");
		String fd = scan.next();

		int k = 1;
		while (k <= 4) {

			Document doc = Jsoup.connect("https://www.genie.co.kr/chart/top200?ditc=D&ymd=20191211&hh=15&rtm=Y&pg=" + k)
					.get();
			// System.out.println(doc);

			Elements title = doc.select("td.info a.title"); // Elements => 태그
			Elements singer = doc.select("td.info a.artist");
			int i = 0;
			while (i < title.size()) {

				String data = title.get(i).text();
//			if(data.contains(fd)) {
				System.out.println((i + 1) + ". " + data);
				System.out.println(singer.get(i).text());
				System.out.println("=========================");
//			}
//			System.out.println((i+1) + ". " + data);
//			System.out.println(singer.get(i).text());
//			System.out.println("=========================");
				i++;
			}
			k++;
		}
	}
}
