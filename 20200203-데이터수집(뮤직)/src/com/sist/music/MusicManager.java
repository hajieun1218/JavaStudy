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
						System.out.println("����:"+rank);
						System.out.println("����:"+title.get(j).text());
						System.out.println("����:"+singer.get(j).text());
						System.out.println("�ٹ�:"+album.get(j).text());
						System.out.println("�̹���:"+poster.get(j).attr("src"));
//						System.out.println("��Ÿ:"+temp.get(j).text());
						String s=temp.get(j).text();  // 5�ϰ�,4���,����
						/*
						 *   [0-9] : ���� ��ü , [^0-9] : ���� ����, ^[0-9] : ���ڷ� ����
						 *   [A-Za-z] : ���ĺ� ��ü
						 *   [��-�R] : �ѱ���ü
						 *   
						 *   ip => 0~255.0~255.0~255.0~255
						 *          211 .  238.  142.  181
						 *   [0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}
						 */
						String ss=s.replaceAll("[^��-�R]", ""); //�ѱ� ���� �������� ����(��������)
						String idcrement=""; 
						String state="";
						if(ss.equals("���")) {
							idcrement=s.replaceAll("[^0-9]", ""); // ���� �����ϰ� ������ ����(�ѱ�����)
							state=ss;
						}
						else if(ss.equals("�ϰ�")) {
							idcrement=s.replaceAll("[^0-9]", "");
							state=ss;
						}
						else { // ����
							idcrement="0";
							state="����";
						}
						System.out.println("����:"+state);
						System.out.println("���氪:"+idcrement);
//						System.out.println("������ Ű:"+youtubeKeyData(title.get(j).text()));
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
			Pattern p=Pattern.compile("/watch\\?v=[^��-�R]+");  // $  ^ . ? |  ==> �տ� \\ ���̰� ���
			Matcher m=p.matcher(doc.toString());
			// ã��
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
