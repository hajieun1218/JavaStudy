package com.sist.movie;

// 파일 읽기
import java.util.*;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
/*
 *  Element  : 내가 가져와야하는 태그 이름  ==> MovieVO
 *  Elements : 같은 태그 여러개                  ==> ArrayList
 */

/*
 * <div class="info_tit">
	   <em class="ico_movie ico_15rating">15세이상관람가</em>
	  <a href="/moviedb/main?movieId=122091" class="name_movie #title">남산의 부장들</a>
   </div>
 */

/*
 *   <div class="a">
 *     <p>aaaa</p>
 *     <a href="bbbb">bbb</a>
 *   </div>
 *   
 *   div.a p    => text()        ==> aaaa
 *   div.a a    => attr("href")  ==> bbbb
 *   div.a      => text()        ==> aaaa bbb
 *                 html()        ==> <p>aaaa</p>
 *                                   <a href="bbbb">bbb</a>
 */
public class MovieManager {

	public ArrayList<MovieVO> movieListData() {
		ArrayList<MovieVO> list = new ArrayList<MovieVO>();
		try {
			MovieDAO dao=new MovieDAO();
//			for (int i = 1; i <= 6; i++) 
			{
				// 영화 목록
				Document doc = Jsoup.connect("https://movie.daum.net/boxoffice/yearly").get();
				Elements link = doc.select("div.info_tit a"); // a태그 여러개
				for (int j = 0; j < link.size(); j++) {
					try {
						Element elem = link.get(j); // a태그 한개
						// 태그 안에있는 내용 읽을 때는 attr, 태그 밖(텍스트)은 text
//					    System.out.println(i+"-"+elem.attr("href"));

						// 상세페이지
						String mLink = "https://movie.daum.net" + elem.attr("href");
						Document doc2 = Jsoup.connect(mLink).get();
//					    System.out.println(doc2);
						Element title = doc2.selectFirst("div.subject_movie strong.tit_movie");
						System.out.println(title.text());
						Element score = doc2.selectFirst("div.subject_movie em.emph_grade");
						System.out.println(score.text());
						Element genre = doc2.select("dl.list_movie dd.txt_main").get(0);
						System.out.println(genre.text());
						Element regdate = doc2.select("dl.list_movie dd.txt_main").get(1);
						System.out.println(regdate.text());
						Element time = doc2.select("dl.list_movie dd").get(3);
						System.out.println(time.text());

						String temp = time.text();
						StringTokenizer st = new StringTokenizer(temp, ",");
						String strTime = st.nextToken();
						String strGrade = st.nextToken().trim();
						System.out.println(strTime);
						System.out.println(strGrade);

//					    Element grade;
						Element director = doc2.select("dl.list_movie dd.type_ellipsis").get(0);
						System.out.println(director.text());
						Element actor = doc2.select("dl.list_movie dd.type_ellipsis").get(1);
						System.out.println(actor.text());
						Element story = doc2.selectFirst("div.desc_movie p");
						System.out.println(story.text());
						
						MovieVO vo=new MovieVO();
						vo.setTitle(title.text());
						vo.setScore(Double.parseDouble(score.text()));
						vo.setGenre(genre.text());
						vo.setRegdate(regdate.text());
						vo.setTime(strTime);
						vo.setGrade(strGrade);
						vo.setDirector(director.text());
						vo.setActor(actor.text());
						vo.setStory(story.text());
						
						dao.movieInsert(vo);
					} catch (Exception ex) {
						ex.printStackTrace();
					}
				}
			}
			System.out.println("DataBase Insert End...");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return list;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MovieManager m = new MovieManager();
		m.movieListData();
	}

}
