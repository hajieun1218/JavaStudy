/*
 *        *
 *       **
 *      ***
 *     ****
 *    *****
 *    
 *    i    j     k    i=k  ==> k=i
 *   �ټ�     ����       ��ǥ
 *    1    4     1
 *    2    3     2
 *    3    2     3
 *    4    1     4
 *    5    0     5
 *       i+j=5  ==> j=5-i
 *    
 *    
 *    
 *    
 *    *****
 *     ****
 *      ***
 *       **
 *        *
 *        
 *     i    j     k   i+k=6  ==> k=6-i
 *    �ټ�     ����       ��ǥ
 *     1    0     5
 *     2    1     4
 *     3    2     3
 *     4    3     2
 *     5    4     1
 *        j=i-1 
 *    
 */
public class ���߹ݺ��� {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		�ڡڡڡڡ�
//		�ڡڡڡڡ�
//		�ڡڡڡڡ�
//		�ڡڡڡڡ�
//		�ڡڡڡڡ�
		for (int i=1; i<=5; i++) {
			for (int j=1; j<=5; j++) {
				System.out.print("��");
			}
			System.out.println();
		}
		System.out.println();
		
		
//		1####
//		#2###
//		##3##
//		###4#
//		####5
		for (int i=1; i<=5; i++) {
			for (int j=1; j<=5; j++) {
				if (i==j)
					System.out.print(j);
				else
					System.out.print("#");
			}
			System.out.println();
		}
		System.out.println();
		
		
		
//		*
//		**
//		***
//		****
//		*****
		for(int i=1; i<=5; i++) {
			for(int j=1; j<=i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		System.out.println();
		
		
//		*****
//		****
//		***
//		**
//		*
		for(int i=1; i<=5; i++) {
			for(int j=1; j<=6-i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		System.out.println();
		
		
		
//	     *
//	    **
//	   ***
//	  ****
//	 *****
		for(int i=1; i<=5; i++) {
			for(int j=1; j<=5-i; j++) {
				System.out.print(" ");
			}
			for(int k=1;k<=i;k++) {
				System.out.print("*");
			}
			System.out.println();
		}
		System.out.println();
		
		
//		*****
//		 ****
//		  ***
//		   **
//		    *
		for(int i=1; i<=5; i++) {
			for(int j=1; j<=i-1; j++) {
				System.out.print(" ");
			}
			for(int k=1;k<=6-i;k++) {
				System.out.print("*");
			}
			System.out.println();
		}
		System.out.println();
		
		
		
		
		/*
		 *      *******
		 *        ***
		 *         *
		 *        ***
		 *      *******
		 *      
		 *      
		 *      *       *
		 *      *       *
		 *      * *   * *
		 *      * * * * *
 		 *      * *   * * 
		 *      *       *
		 *      *       *
		 *      
		 *      
		 *        *
		 *       ***
		 *      *****
		 *       ***
		 *        *
		 *    
		 */

	}

}
