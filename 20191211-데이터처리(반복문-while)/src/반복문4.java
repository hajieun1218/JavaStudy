// 100~999 7의배수 개수, 4의배수 아닌 개수

public class 반복문4 {

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
		System.out.println("7의배수 : " + seven + "개, 4의배수 아님 : " + notFour + "개");
	}

}
