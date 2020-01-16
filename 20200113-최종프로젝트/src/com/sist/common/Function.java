package com.sist.common;
/*
 *    네트워크 (CS) ==> 서버를 거쳐서 클라이언트가 변경 
 *      서버 => 클라이언트의 요청을 받아서 => 응답(명령)
 *      클라이언트 => 요청 => 응답받아서 클라이언트 프로그램에 출력 
 *      
 *      1) 클라이언트마다 통신이 따로 만들어야 한다 
 *                       ======
 *                        쓰레드  => 통신만 담당 
 *      2) 클라이언트 자체에서 처리하지 않고 => 항상 서버를 통해서 
 *      3) 스트림을 이용한 프로그램 
 *         =====
 *         전송 => 바이트스트림 ==> OutputStream
 *         수신 => 문자스트림    ==> BufferedReader
 */
public class Function {
   public static final int LOGIN=100;// 목록 출력 명령
   public static final int MYLOG=110;// 로그인 => 대기실로 변경 
   public static final int MAKEROOM=200; // 방정보를 출력
   public static final int ROOMIN=210; // 방에 들어가라 
   public static final int ROOMOUT=220;
   public static final int ROOMADD=230;
   public static final int MYROOMOUT=240;
   public static final int WAITUPDATE=250;
   public static final int POSCHANGE=260;
   public static final int WAITCHAT=270;
   public static final int ROOMCHAT=280;
   public static final int KANG=300;
   public static final int INVATE=310;
   public static final int INVATE_YES=320;
   public static final int INVATE_NO=330;
   public static final int EXIT=900;
   public static final int MYEXIT=910;
   
   public static final int START=500;
   public static final int NEXT=510;
   public static final int END=520;
   
}
