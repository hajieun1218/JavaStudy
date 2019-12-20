/*
 *   String : ¹®ÀÚ¿­À» Á¦¾î
 *   
 *     java.lang => import¸¦ »ı·«ÇÒ ¼ö ÀÖ´Ù
 *     ¹®ÀÚ¿­À» ÀúÀåÇÏ´Â ¹æ¹ı
 *       1) String º¯¼ö¸í = "Hello Java";
 *       2) String º¯¼ö¸í = new String("Hello Java");  // °°Àº ¹®ÀÚ¿­ => º°µµ·Î ÀúÀå
 *                       ====
 *                       »õ·Î¿î ¸Ş¸ğ¸®¿¡ ÀúÀå
 *     
 *      String¿¡¼­ Á¦°øÇÏ´Â ±â´É
 *        1) equals : ÀúÀåµÈ ¹®ÀÚ¿­ °°ÀºÁö ¿©ºÎ È®ÀÎ(true/false)
 *             ID,PWD ==> ·Î±×ÀÎ (´ë¼Ò¹®ÀÚ ±¸ºĞ)
 *             ¹®ÀÚ¿­Àº (==)(X)
 *             
 *             String s = "Hello";
 *             String s1 = "Hello";
 *             String s2 = new String("Hello");
 *             
 *             if(s==s1) ===> true
 *             if(s==s2) ===> false;
 *             if(s.equals(s1)) ===>true
 *             
 *        2) substring : ¹®ÀÚ¿­À» ÀÚ¸¦ ¶§ 
 *             substring(int start)
 *             substring(int start, int end)
 *             
 *             String s = "0123456789";
 *             substring(3) => "3456789"
 *             String s = "112ºĞ, 15¼¼ÀÌ»ó°ü¶÷°¡";
 *             substring(0,3) => "112"
 *             
 *        3) length : ¹®ÀÚ¿­ °³¼ö
 *             String s = "Hello È«±æµ¿";
 *             s.length ==> 9°³
 *             
 *        4) trim : ÁÂ¿ìÀÇ °ø¹é¹®ÀÚ Á¦°Å
 *             String s = "Hello Java";
 *                  => s.length => 10°³
 *                  => s.trim().length => 10°³  (Áß°£ °ø¹éÀº Á¦°ÅX)
 *                  
 *        5) startsWith, endsWith : ½ÃÀÛ ¹®ÀÚ¿­ÀÌ °°À» ¶§, ³¡³ª´Â ¹®ÀÚ¿­ÀÌ °°À» ¶§
 *                                  ==> °Ë»öÇÒ ¶§ ¸¹ÀÌ »ç¿ë
 *             startsWith("ÀÚ¹Ù");
 *             
 *        6) indexOf, lastIndexOf
 *             ¹®ÀÚÀÇ À§Ä¡ : (indexOf:¾Õ¿¡¼­, lastIndexOf:µÚ¿¡¼­)
 *             String s = "Hello Java";
 *             s.indexOf('a');     ==> 7
 *             s.lastIndexOf('a'); ==> 9
 *             
 *        7) split
 *             String s = "ÀÌº´Çå, ÇÏÁ¤¿ì, ¸¶µ¿¼®, ÀüÇıÁø, ¼öÁö";
 *             String[] names = s.split(",");
 *             
 *             Á¤±Ô½Ä
 *             ====
 *              211.238.142.181
 *              211.238.142.180
 *              211.238.142.1
 *              211.238.142.23
 *              211.238.1.1
 *              ==> [0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}
 *                  0¿¡¼­ 9±îÁö / 1-3ÀÚ¸®
 *        
 *        8) toUpperCase, toLowerCase : ´ë¹®ÀÚ º¯È¯, ¼Ò¹®ÀÚ º¯È¯
 *             String s = "Hello";
 *             s.toUpperCase();  ==> HELLO
 *             s.toLowerCase();  ==> hello
 *             
 *        9) replace, replaceAll 
 *           =======
 *           º¯°æ ==> String s = "Hello Java";
 *                  s.replace('a','b');  ==> Hello jbvb 
 *                  
 *           replaceAll ==> Á¤±Ô½Ä
 *             String s = "113ºĞ";
 *             s.replaceAll("[^0-9]","");  ==> 113 (¼ıÀÚ»©°í Áö¿ì±â)
 *             s.replaceAll("^[0-9]","");  ==>     (¼ıÀÚ·Î ½ÃÀÛÇÏ´Â)
 *             s.replaceAll("[^0-9]$","");  ==>    (¼ıÀÚ·Î ³¡³ª´Â)
 *             s.replaceAll("[^°¡-ÆR]","");  ==>    (ÇÑ±Û»©°í Áö¿ì±â)
 *             s.replaceAll("[^A-Za-z]","");  ==>  (¿µ¹®»©°í Áö¿ì±â)
 *        
 *         10) contains : Æ÷ÇÔµÈ ¹®ÀÚ¸¦ Ã£´Â °æ¿ì
 *               
 */
import java.util.Scanner;

public class ¹®ÀÚ¿­Å¬·¡½º {

	static String[] autoComplate(String data) {
		String[] ss = {
				"ÀÚ¹Ù¿Í JSP","ÀÚ¹Ù ÇÁ·Î±×·¡¹Ö","½ºÇÁ¸µ 5","Ajax¿Í JSP","¸®´ö½º¿Í ¸®¾×Æ®",
				"ÀÚ¹Ù ¿À¶óÅ¬","MVC ±¸Á¶","ÄÚÆ²¸°°ú ¾Èµå·ÎÀÌµå","ÄÚÆ²¸° ÇÁ·Î±×·¥","½ºÇÁ¸µ µ¥ÀÌÅÍ",
				"È¥ÀÚ¹è¿ì´Â ÀÚ¹Ù","Áö´ÉÇüÀ¥ ÇÁ·Î±×·¥","À¥ ÇÁ·Î±×·¥","ÀÚ¹Ù À¥ÇÁ·Î±×·¥","¿À¶óÅ¬ ÀÚ¹Ù"};
		String[] findData = new String[10];
		
		int j=0;
		for(int i=0; i<ss.length; i++) {
//			if(ss[i].startsWith(data)) {
			if(ss[i].contains(data)) {
				findData[j] = ss[i];
				j++;
			}
		}
		return findData;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scan = new Scanner(System.in);
		System.out.print("°Ë»ö¾î ÀÔ·Â : ");
		String data = scan.next();
		
		String[] fd = autoComplate(data);
		for(int i=0; i<fd.length; i++) {
			if(fd[i] != null) {
				System.out.println(fd[i]);
			}
		}
		
	}

}
