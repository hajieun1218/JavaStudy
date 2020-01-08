package com.sist.exception;
/*
 *    ����ó�� ����
 *     = ���ܺ��� : try~catch (����ó��)  ================> 70%
 *     = ����ȸ�� : throws (����ó�� => �ý��ۿ� ���� ó��) =====> 29%
 *     = ���ܹ߻� : throw (����� ���� ����ó��)   ============> 1%
 *     
 *     
 *     try ~ catch ~ finally(�����ص� ����)
 *     ����) 
 *          try {
 *             ��������� �� �� �ִ� ����
 *          }catch(����Ǵ� ����) {
 *             ���� ����
 *          }catch(����Ǵ� ����) {
 *             ���� ����
 *          }catch(����Ǵ� ����) {
 *             ���� ����
 *          }finally {
 *             ���� ���� or ���������� �����ϵ� ������� ������ �����ϴ� ����
 *          }
 */ 
public class MainClass2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		try {
//			for(int i=1;i<=10;i++) {
//				if(i==5) {
//					int a=10/0;
//				}
//				System.out.println("i="+i);
//			}
//		} catch(Exception ex) {
//			System.out.println("���� �߻�");
//		}
		
		
		for(int i=1;i<=10;i++) {
			try {
				if(i==5) {
					int a=10/0;
				}
				System.out.println("i="+i);
			} catch(Exception ex) {
				System.out.println("���� �߻�");
			}
		}
		
		
	}

}
