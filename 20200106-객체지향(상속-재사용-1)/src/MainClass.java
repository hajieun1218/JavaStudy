class ���� {
	public void draw() {
		System.out.println("���� �׸���");
	}
}
class �� extends ���� {
	public void draw() {
		System.out.println("���� �׸���");
	}
}
class �ﰢ�� extends ���� {
	public void draw() {
		System.out.println("�ﰢ���� �׸���");
	}
}
class �׸� extends ���� { 
	public void draw() {
		System.out.println("�׸� �׸���");
	}
}
public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		�׸� m = new �׸�();
		���� m = new �׸�();
		m.draw();
		
		m = new �ﰢ��();
		m.draw();
		
		m = new ��();
		m.draw();
		
		m = new ����();
		m.draw();
	}

}
