import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import java.util.Scanner;
/*
 *   <td class="info">
     <a href="#" class="title ellipsis" title="���" onclick="fnPlaySong('89296790','1');return false;">
              �ȳ�</a>
     <a href="#" class="artist ellipsis" onclick="fnViewArtist('80247689');return false;">��Ŵ</a>
 */

public class �ݺ���7 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		Scanner scan = new Scanner(System.in);
		System.out.print("�˻��� �Է� :");
		String fd = scan.next();

		int k = 1;
		while (k <= 4) {

			Document doc = Jsoup.connect("https://www.genie.co.kr/chart/top200?ditc=D&ymd=20191211&hh=15&rtm=Y&pg=" + k)
					.get();
			// System.out.println(doc);

			Elements title = doc.select("td.info a.title"); // Elements => �±�
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
