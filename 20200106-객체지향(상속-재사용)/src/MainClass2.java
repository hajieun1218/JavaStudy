
class Board {
	public void write() {
		System.out.println("Board : write() : 글쓰기");
	}
	public void content() {
		System.out.println("Board : content() : 내용보기");
	}
	public void update() {
		System.out.println("Board : update() : 수정하기");
	}
	public void list() {
		System.out.println("Board : list() : 목록출력");
	}
	public void find() {
		System.out.println("Board : find() : 찾기");
	}
	public void delete() {
		System.out.println("Board : delete() : 삭제");
	}
}

// 변경이 가능 
// 글쓰기, 목록출력 변경
class GalleryBoard extends Board {
	public void write() {
		System.out.println("GalleryBoard : write() : 글쓰기 + 이미지 업로드");
	}
	
	public void list() {
		System.out.println("GalleryBoard : list() : 목록출력 + 이미지 출력");
	}
}

class DataBoard extends Board {

	@Override
	public void write() {
		System.out.println("DataBoard : write() : 글쓰기 + 파일 업로드");
	}

	public void write(int a) {
		System.out.println("DataBoard : write(int a)");
	}
	
	@Override
	public void content() {
		System.out.println("DataBoard : content() : 내용보기 + 파일 다운로드");
	}
}

public class MainClass2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		GalleryBoard gb = new GalleryBoard();
//		gb.list();
//		gb.write();
//		gb.content();
//		gb.update();
//		gb.delete();
//		gb.find();
//		
//		System.out.println();
//		DataBoard db = new DataBoard();
//		db.list();
//		db.write();
//		db.content();
//		db.update();
//		db.delete();
//		db.find();	
		
		// gb가 가지고있는 메소드만
		Board gb = new GalleryBoard();
		gb.list();
		gb.write();
		gb.content();
		gb.update();
		gb.delete();
		gb.find();
		
		System.out.println();
		gb = new DataBoard();
		gb.list();
		gb.write();
		gb.content();
		gb.update();
		gb.delete();
		gb.find();
//		gb.write(10);
		
		/*
		 *   상위클래스로 하위클래스의 생성
		 *   
		 *   Board db = new DataBoard(); ==> 변경된 메소드만 호출이 가능
		 *   ============================ 상속을 받는 경우
		 *   => 상위 클래스는 하위 클래스에 추가된 메소드나 변수에 접근이 불가능
		 *   => 변수 : 클래스 타입
		 *   => 메소드 : 생성자
		 */
	}

}
