package com.sist.common;
/*
 *    ��Ʈ��ũ (CS) ==> ������ ���ļ� Ŭ���̾�Ʈ�� ���� 
 *      ���� => Ŭ���̾�Ʈ�� ��û�� �޾Ƽ� => ����(���)
 *      Ŭ���̾�Ʈ => ��û => ����޾Ƽ� Ŭ���̾�Ʈ ���α׷��� ��� 
 *      
 *      1) Ŭ���̾�Ʈ���� ����� ���� ������ �Ѵ� 
 *                       ======
 *                        ������  => ��Ÿ� ��� 
 *      2) Ŭ���̾�Ʈ ��ü���� ó������ �ʰ� => �׻� ������ ���ؼ� 
 *      3) ��Ʈ���� �̿��� ���α׷� 
 *         =====
 *         ���� => ����Ʈ��Ʈ�� ==> OutputStream
 *         ���� => ���ڽ�Ʈ��    ==> BufferedReader
 */
public class Function {
   public static final int LOGIN=100;// ��� ��� ���
   public static final int MYLOG=110;// �α��� => ���Ƿ� ���� 
   public static final int MAKEROOM=200; // �������� ���
   public static final int ROOMIN=210; // �濡 ���� 
   public static final int ROOMOUT=220;
   public static final int ROOMADD=230;
   public static final int MYROOMOUT=240;
   public static final int WAITUPDATE=250;
   public static final int POSCHANGE=260;
   public static final int WAITCHAT=270;
   public static final int ROOMCHAT=280;
   public static final int EXIT=900;
   public static final int MYEXIT=910;
}
