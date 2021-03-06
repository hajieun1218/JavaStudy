package com.sist.music;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class MusicManager {

	public ArrayList<MusicVO> musicAllData() {
		ArrayList<MusicVO> list=new ArrayList<MusicVO>();
		try {
			Date date=new Date();
			SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMdd");
			System.out.println(sdf.format(date));
			int rank=1;
			
			MusicDAO dao=new MusicDAO();
			for(int i=1;i<=4;i++) {
				try {
					Document doc=Jsoup.connect("https://www.genie.co.kr/chart/top200?ditc=D&ymd="+sdf.format(date)+"&hh=10&rtm=Y&pg="+i).get();
//					System.out.println(doc.toString()); 
					Elements title=doc.select("tr.list td.info a.title");
					Elements singer=doc.select("tr.list td.info a.artist");
					Elements album=doc.select("tr.list td.info a.albumtitle");
					Elements poster=doc.select("tr.list td a.cover img");
					
					Elements temp=doc.select("tr.list span.rank");
					for(int j=0;j<title.size();j++) {
						System.out.println("순위:"+rank);
						System.out.println("제목:"+title.get(j).text());
						System.out.println("가수:"+singer.get(j).text());
						System.out.println("앨범:"+album.get(j).text());
						System.out.println("이미지:"+poster.get(j).attr("src"));
//						System.out.println("기타:"+temp.get(j).text());
						String s=temp.get(j).text();  // 5하강,4상승,유지
						/*
						 *   [0-9] : 숫자 전체 , [^0-9] : 숫자 제외, ^[0-9] : 숫자로 시작
						 *   [A-Za-z] : 알파벳 전체
						 *   [가-힣] : 한글전체
						 *   
						 *   ip => 0~255.0~255.0~255.0~255
						 *          211 .  238.  142.  181
						 *   [0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}
						 */
						String ss=s.replaceAll("[^가-힣]", ""); //한글 제외 나머지는 공백(숫자제거)
						String idcrement=""; 
						String state="";
						if(ss.equals("상승")) {
							idcrement=s.replaceAll("[^0-9]", ""); // 숫자 제외하고 나머지 공백(한글제거)
							state=ss;
						}
						else if(ss.equals("하강")) {
							idcrement=s.replaceAll("[^0-9]", "");
							state=ss;
						}
						else { // 유지
							idcrement="0";
							state="유지";
						}
						System.out.println("등폭:"+state);
						System.out.println("변경값:"+idcrement);
//						System.out.println("동영상 키:"+youtubeKeyData(title.get(j).text()));
						System.out.println("==========================================");
						MusicVO vo=new MusicVO();
						vo.setRank(rank);
						vo.setTitle(title.get(j).text());
						vo.setSinger(singer.get(j).text());
						vo.setAlbum(album.get(j).text());
						vo.setPoster(poster.get(j).attr("src"));
						vo.setState(state);
						vo.setIdcrement(Integer.parseInt(idcrement));
						vo.setKey(youtubeKeyData(title.get(j).text()));
						list.add(vo);
						
						dao.musicInsert(vo);
						rank++;
					}
					
//					Elements idcrement=doc.select("tr.list td.info a.title");
//					Elements state=doc.select("tr.list td.info a.title");
				} catch(Exception ex) {}
				
			}
			
		} catch(Exception ex) {}
		return list;
	}
	
	public String youtubeKeyData(String title) {
		String key="";
		try {
			Document doc=Jsoup.connect("https://www.youtube.com/results?search_query="+title).get();
			Pattern p=Pattern.compile("/watch\\?v=[^가-힣]+");  // $  ^ . ? |  ==> 앞에 \\ 붙이고 사용
			Matcher m=p.matcher(doc.toString());
			// 찾기
			while(m.find()) {
				String temp=m.group();
				key=temp.substring(temp.indexOf("=")+1,temp.indexOf("\""));
//				System.out.println(temp);
				break;
			}
		} catch(Exception ex) {}
		return key;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MusicManager m=new MusicManager();
		MusicDAO dao=new MusicDAO();
		ArrayList<MusicVO> list=m.musicAllData();
//		for(MusicVO vo:list) {
//			dao.musicInsert(vo);
//		}
		System.out.println("Oracle Save End...");
//		m.youtubeKeyData(title);
	}

}
