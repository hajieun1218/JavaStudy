package com.sist.common;

public class Function {

   
   //    �� �̵� 
   public static final int START = 1000;
   // START�� �̵�

//   public final int WAITROOM = 3000;
//   // �������� �̵�
//   public final int GAMEROOM = 4000;
   
   
   //  �α���
   public static final int LOGIN_VIEW = 2000;
   // �α��� â���� �̵� 
   public static final int LOGIN = 200;
   /*
        ���� : ID|PW Ȯ��
        client : ����â���� ��ȯ (�α��� ������)
    */
   public static final int LOGIN_UPDATE = 230;
   /*
       client :  ���� ��ġ ���
    */
   public static final int LOGIN_CHECK =210;
   /*
        ���� : �α��� �������� Ȯ�� -> ������  true ��ȯ, ���н� FALSE
   */
   
   
   
   // ȸ�� ����
   public static final int JOIN = 100;
   // ȸ���������� �̵�
   public static final int JOIN_ID_CHECK = 110;
   // CLIENT : ���̵� �Է� �� �ߺ�üũ Ŭ��
   // ���� : DB���� �ߺ�Ȯ�� �� �� ��ȯ
   public static final int JOIN_INPUT =120;
   /*
       CLIENT : ȸ�� ���� ���� �Է��� Ȯ�� Ŭ��
       ���� : ���̵�|�н�����|�������  �Է�  DB�� �Է¤�
    */
   
   
   
   
   
   // ����
   public static final int WAIT_CHAT = 300;
   /* CLIENT : ä�� ���� ������ �Ѱ���
       ���� : ��ü �̿��ڵ鿡�� �޼��� ���
   */
   
   public static final int WAIT_MAKEROOM =310;
   // �游���
   /*
       CLIENT : DIALOG â���� �游��� ��ư Ŭ��(  ����|�ο���|-> ������ ����)
       ���� : 1. ���ӹ����� ��ȯ
           2. ���濡 ����|�ο��� �߰�
    */
   public static final int WAIT_INROOM =320;
   //�� ����
   /*
       CLIENT : ����� Ŭ��
       ���� : 1. ���ӹ����� ��ȯ ,2. ~~���� �����Ͽ����ϴ� ���
          
    */
   public static final int WAIT_UPDATE =321;
   // ���� ������Ʈ
   // ���� -> CLIENT ����, ���� �ο��� ����
   

   public static final int WAIT_EXIT = 330;
   // ���� ������
   public static final int WAIT_EXIT_U = 331;
   // ���� ������Ʈ
   
   
   
   
   // ���ӹ�
   public static final int GAME_CHAT = 410;
   // ���� ä��
   /*
       CLIENT : ���� ä�� ���� ������ ����
       ���� : ä�� ��ü �޼��� ����
    */
   
   public static final int GAME_USERADD = 420;
   
   public static final int GAME_ANSWER = 430;
   // ���� �Է�
   /*
       CLINET : ���� �Է�
       ���� : Ÿ�̸� �ð��� ���� ��  DB�� ����� �� ��
        ������   TRUE Ʋ���� FALSE�� ������ 
    */
   public static final int GAME_SCORE =431;
   //  ����Ȯ�� �� ���� CHECK 

   public static final int GAME_EXIT = 440;
// ���ӹ� ������
   public static final int GAME_EXIT_U = 441;
// ���ӹ� ������ ������Ʈ

   
   /*   CLIENT : TRUE/ FALSE�� �޾Ƽ� ������ SOCRE ++ Ʋ���� X
           ���� ���Ȱ�|50|�źϵ���|100| ==> ������ ����
       ���� -> CLIENT��   ���� ���Ȱ�|50|�źϵ���|100| ��� ��û
    */
   
}