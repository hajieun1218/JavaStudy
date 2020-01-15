package com.sist.common;

public class Function {

   
   //    방 이동 
   public static final int START = 1000;
   // START로 이동

//   public final int WAITROOM = 3000;
//   // 대기방으로 이동
//   public final int GAMEROOM = 4000;
   
   
   //  로그인
   public static final int LOGIN_VIEW = 2000;
   // 로그인 창으로 이동 
   public static final int LOGIN = 200;
   /*
        서버 : ID|PW 확인
        client : 대기실창으로 전환 (로그인 성공시)
    */
   public static final int LOGIN_UPDATE = 230;
   /*
       client :  대기실 위치 출력
    */
   public static final int LOGIN_CHECK =210;
   /*
        서버 : 로그인 성공여부 확인 -> 성공시  true 반환, 실패시 FALSE
   */
   
   
   
   // 회원 가입
   public static final int JOIN = 100;
   // 회원가입으로 이동
   public static final int JOIN_ID_CHECK = 110;
   // CLIENT : 아이디 입력 후 중복체크 클릭
   // 서버 : DB에서 중복확인 후 값 반환
   public static final int JOIN_INPUT =120;
   /*
       CLIENT : 회원 가입 내역 입력후 확인 클릭
       서버 : 아이디|패스워드|생년월일  입력  DB에 입력ㄴ
    */
   
   
   
   
   
   // 대기방
   public static final int WAIT_CHAT = 300;
   /* CLIENT : 채팅 값을 서버에 넘겨줌
       서버 : 전체 이용자들에게 메세지 출력
   */
   
   public static final int WAIT_MAKEROOM =310;
   // 방만들기
   /*
       CLIENT : DIALOG 창에서 방만들기 버튼 클릭(  방제|인원수|-> 서버에 전송)
       서버 : 1. 게임방으로 전환
           2. 대기방에 방제|인원수 추가
    */
   public static final int WAIT_INROOM =320;
   //방 들어가기
   /*
       CLIENT : 방들어가기 클릭
       서버 : 1. 게임방으로 전환 ,2. ~~님이 입장하였습니다 출력
          
    */
   public static final int WAIT_UPDATE =321;
   // 대기방 업데이트
   // 서버 -> CLIENT 대기실, 방제 인원수 조정
   

   public static final int WAIT_EXIT = 330;
   // 대기방 나가기
   public static final int WAIT_EXIT_U = 331;
   // 대기방 업데이트
   
   
   
   
   // 게임방
   public static final int GAME_CHAT = 410;
   // 게임 채팅
   /*
       CLIENT : 게임 채팅 내용 서버로 전송
       서버 : 채팅 전체 메세지 저장
    */
   
   public static final int GAME_USERADD = 420;
   
   public static final int GAME_ANSWER = 430;
   // 정답 입력
   /*
       CLINET : 정답 입력
       서버 : 타이머 시간이 지난 후  DB의 정답과 비교 후
        맞으면   TRUE 틀리면 FALSE를 돌려줌 
    */
   public static final int GAME_SCORE =431;
   //  정답확인 겸 점수 CHECK 

   public static final int GAME_EXIT = 440;
// 게임방 나가기
   public static final int GAME_EXIT_U = 441;
// 게임방 나가기 업데이트

   
   /*   CLIENT : TRUE/ FALSE를 받아서 맞으면 SOCRE ++ 틀리면 X
           점수 저팔계|50|거북도사|100| ==> 서버로 전송
       서버 -> CLIENT에   점수 저팔계|50|거북도사|100| 출력 요청
    */
   
}