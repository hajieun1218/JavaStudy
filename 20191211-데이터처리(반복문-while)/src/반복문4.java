// 100~999 7�ǹ�� ����, 4�ǹ�� �ƴ� ����

public class �ݺ���4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int i = 100;
		int seven = 0, notFour = 0;
		while(i<=999) {
			if(i%7==0) {
				seven++;
			}
			if(i%4!=0) {
				notFour++;
			}
			i++;
		}
		System.out.println("7�ǹ�� : " + seven + "��, 4�ǹ�� �ƴ� : " + notFour + "��");
	}

}
