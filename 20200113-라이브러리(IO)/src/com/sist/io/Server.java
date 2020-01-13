package com.sist.io;
import java.io.*;
import java.net.*;
/*
 *   MVC , Spring , Kotlin 
 *   =====================
 *   
 *   서버 :
 *        대기서버 => 1개  ===> 연결기기 (Socket) => 전화기
 *                 ServerSocket => 접속시 처리 
 *        통신서버 => 접속수만큼 생성 (Thread)
 *                 Socket => 실제 통신 
 *                 
 *   서버 => 여러개의 통신하는 프로그램이 필요 
 *         ========== 동일 
 */
public class Server implements Runnable{
    private ServerSocket ss;
    public Server()
    {
    	try
    	{
    		ss=new ServerSocket(3355);
    		// bind => 개통(통신이 가능) 
    		// bind => 1.IP , 2. Port 
    		// 서버는 port => 고정 포트, 클라이언트 => 임시 포트 
    		// listen => 대기상태
    		System.out.println("Server Start...");
    	}catch(Exception ex) {}
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Server server=new Server();
        new Thread(server).start();
        // server에 있는 run함수를 호출 
	}
    // 쓰레드 작동 
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true)
		{
			try
			{
				Socket s=ss.accept();// 클라이언트의 정보 (Socket)
				System.out.println("접속한 클라이언트의 IP:"+s.getInetAddress().getHostAddress());
				System.out.println("임시포트:"+s.getPort());
				System.out.println("=======================");
			}catch(Exception ex) {}
		}
	}

}





