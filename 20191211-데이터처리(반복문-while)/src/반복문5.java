// 문자 찾기 (검색)
// ==> 문자 ==> charAt(0)
// String s = "asdffghjklxsaaahbj"  => charAt(0) ==> a

public class 반복문5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String s = "sjdasdlfkjlsaanlsieaokwnA";
		System.out.println("s = " + s);
		
		int i = 0;
		int count = 0;
		while(i<s.length()) {
			System.out.println((i+1) + "번째 문자 : " + s.charAt(i));
			if(s.charAt(i)=='a' || s.charAt(i)=='A')
				count++;
			i++;
		}
		System.out.println("a또는 A의 개수 : " + count);
	}
}
