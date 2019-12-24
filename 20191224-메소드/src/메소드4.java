
public class 메소드4 {

	static String[] movieList(int page) {
		String[] data = new String[5];
		String[] title = {
				"백두산",
				"시동",
				"포드 V 페라리",
				"겨울왕국 2",
				"나이브스 아웃",
				"쥬만지: 넥스트 레벨",
				"블랙머니",
				"캣츠",
				"신비아파트 극장판 하늘도깨비 대 요르문간드",
				"6 언더그라운드",
				"감쪽같은 그녀"
		};
		
		int rowSize=5;
		int j=0;  // 5개씩 나눠주는 변수
		int pagecnt = (page*rowSize)-rowSize; // 시작점
		// 1page => 0~4
		// 2page => 5~9
		// 3page => 10~14
		
		int k=0;
		for(int i=0; i<title.length; i++) {
			if(j<5 && i>=pagecnt) { 
				data[k] = title[i];
				k++;
				j++;
			}
		}
		
		return data;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int page = 3;
		String[] data = movieList(page);
		for(String s:data) {
			if(s!=null)
				System.out.println(s);
		}
		
	}

}
