
class Board {
	public void write() {
		System.out.println("Board : write() : �۾���");
	}
	public void content() {
		System.out.println("Board : content() : ���뺸��");
	}
	public void update() {
		System.out.println("Board : update() : �����ϱ�");
	}
	public void list() {
		System.out.println("Board : list() : ������");
	}
	public void find() {
		System.out.println("Board : find() : ã��");
	}
	public void delete() {
		System.out.println("Board : delete() : ����");
	}
}

// ������ ���� 
// �۾���, ������ ����
class GalleryBoard extends Board {
	public void write() {
		System.out.println("GalleryBoard : write() : �۾��� + �̹��� ���ε�");
	}
	
	public void list() {
		System.out.println("GalleryBoard : list() : ������ + �̹��� ���");
	}
}

class DataBoard extends Board {

	@Override
	public void write() {
		System.out.println("DataBoard : write() : �۾��� + ���� ���ε�");
	}

	public void write(int a) {
		System.out.println("DataBoard : write(int a)");
	}
	
	@Override
	public void content() {
		System.out.println("DataBoard : content() : ���뺸�� + ���� �ٿ�ε�");
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
		
		// gb�� �������ִ� �޼ҵ常
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
		 *   ����Ŭ������ ����Ŭ������ ����
		 *   
		 *   Board db = new DataBoard(); ==> ����� �޼ҵ常 ȣ���� ����
		 *   ============================ ����� �޴� ���
		 *   => ���� Ŭ������ ���� Ŭ������ �߰��� �޼ҵ峪 ������ ������ �Ұ���
		 *   => ���� : Ŭ���� Ÿ��
		 *   => �޼ҵ� : ������
		 */
	}

}
