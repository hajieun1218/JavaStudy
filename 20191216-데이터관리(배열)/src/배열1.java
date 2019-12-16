/*
 *   배열(Array)
 *   1) 같은 데이터를 여러개 모아서 한개의 변수명으로 제어
 *   2) 배열 선언시에 자동으로 연속적인 메모리를 생성
 *                     ===========
 *                     => 시작과 끝이 일관적으로 정해져 있다
 *                     => 0 ~ 배열 개수(반복문 조절)
 *   3) 단점 : 고정적
 *   4) 사용처 => 관련된 데이터가 3개 이상이면 => 배열
 *   5) 사용
 *       1. 선언
 *          데이터형[] 배열명;   // 자바 권장 사항
 *          데이터형 배열명[];   // C/C++
 *       2. 초기값 설정
 *           int[] arr = {10, 20, 30, 40, 50};
 *           int[] arr = new int[5];    // new 초기값 ==> 전체가 0
 *                                         double[] arr = new double[3]; 0.0
 *                                         String[] arr = new String[3]; null
 *                                         char[] arr = new char[3]; '\0'
 *                                         boolean[] arr = new boolean[3]; false
 *       3. 활용
 *          => 값을 변경
 *             첨자(인덱스)를 이용 ==> arr[0] = 100;
 *          => 출력 ==> 배열의 모든 첨자는 0부터 시작 ==> 
 *                    for(int i=0; ...)
 *       4. 초과하거나 줄일 수 없다 => 에러발생
 *          ArrayIndexOfBoundsException => 배열의 범위가 초과
 *       5. 배열의 개수 ==> 배열명.length
 *                           
 *    6) 주소를 참조해서 데이터를 관리 ==> 참조변수
 *        (배열,클래스)
 */ 


// 정수 3개 입력 => 입력받은 데이터를 출력
import java.util.Scanner;
public class 배열1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int a,b,c;
		
		Scanner scan = new Scanner(System.in);
		System.out.print("첫번째 정수 입력 : ");
		a = scan.nextInt();
		System.out.print("두번째 정수 입력 : ");
		b = scan.nextInt();
		System.out.print("세번쨰 정수 입력 : ");
		c = scan.nextInt();
		
		// 제어 => a,b,c 중에 가장 큰 수를 출력
		int max = 0;
		if(a>max)
			max = a;
		if(b>max)
			max = b;
		if(c>max)
			max = c;
		
		System.out.println("가장 큰 값 : " + max);
		
		
		
	}

}
