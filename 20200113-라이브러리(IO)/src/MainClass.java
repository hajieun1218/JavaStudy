/*
 *     IO : CheckException (반드시 예외처리)
 *          Input/Output (입출력)
 *          
 *     = 메모리 입출력
 *         표준 : System.in.read(), System.out.println()
 *     = 파일 입출력
 *     = 네트워크 입출력
 *     
 *     // 데이터를 이동하는 통로 : 스트림
 *     라이브러리에서 제공하는  IO => 단점(단방향)
 *     ===================
 *         바이트스트림  - InputStream, OutputStream   
 *                     => FileInputStream
 *                        FileOutputStream
 *                     => 보조장치 (임시공간에 저장했다가 한번에 가져옴 => 속도가 빠르다)
 *                        BufferedInputStream
 *                        BufferedOutputStream
 *                     => File (객체단위로 저장 => 직렬화/역직렬화)
 *                        ObjectInputStream
 *                        ObjectOutputStream
 *         문자스트림  - Reader,Writer
 *                     => FileReader
 *                        FileWriter
 *                     => 보조장치
 *                        BufferedReader
 *                        BufferedWriter
 */
public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
