// ���� ã�� (�˻�)
// ==> ���� ==> charAt(0)
// String s = "asdffghjklxsaaahbj"  => charAt(0) ==> a

public class �ݺ���5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String s = "sjdasdlfkjlsaanlsieaokwnA";
		System.out.println("s = " + s);
		
		int i = 0;
		int count = 0;
		while(i<s.length()) {
			System.out.println((i+1) + "��° ���� : " + s.charAt(i));
			if(s.charAt(i)=='a' || s.charAt(i)=='A')
				count++;
			i++;
		}
		System.out.println("a�Ǵ� A�� ���� : " + count);
	}
}
