package com.sist.io2;
import java.util.*;
import java.io.*;
import java.net.*;
/*
 *     클래스의 종류 
 *       = 일반 클래스 
 *       = 추상 클래스(인터페이스)
 *       = 내부클래스 
 *          1) 클래스끼리 데이터를 공유 => static  ==> 멤버클래스
 *             class A
 *             {
 *                class B
 *                {
 *                }
 *             }
 *             Server가 가지고 있는 모든 변수를 공유
 *          2) 상속없이 오버라이딩을 사용 => 익명의 클래스 
 */
public class Server implements Runnable{
    private ServerSocket ss;
    private final int PORT=3355;
    private Vector<Client> waitVc=new Vector<Client>();// 접속한 유저의 정보 (ip,port)
	
    // 서버 가동  => Server => 메모리 할당을 한번만 사용 
    public Server() {
    	try
    	{
    		ss=new ServerSocket(PORT);// 50정도 사용 
    		// 개통 => bind , 대기상태 => listen
    		System.out.println("Server Start...");
    	}catch(Exception ex){}
    }
    
    @Override
	public void run() {
		// TODO Auto-generated method stub
		// 접속시에 처리 
    	while(true)
    	{
    		try
    		{
    			// 접속시에 클라이언트의 정보를 받아서 저장하고 => 쓰레드로 전송 
    			// 접속시에 정보 ==> Socket(ip,port)
    			Socket s=ss.accept();// 접속이되면 호출되는 메소드 
    			// Socket ==> 클라이언트 (유저)
    			System.out.println("클라이언트 접속 완료!!=>"
    					+s.getInetAddress().getHostAddress());
    			Client client=new Client(s);
    			client.start();// Client=> run() :통신
    			waitVc.add(client);
    			// 정보를 저장 
    		}catch(Exception ex) {}
    	}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Server server=new Server();
        new Thread(server).start();
	}
	// inner클래스 => Thread,윈도우 => 빅데이터
	class Client extends Thread
	{
		// Server가 가지고 있는 모든 데이터를 사용 할 수 있다
		Socket s;// 클라이언트와 연결 전화기(연결기계=>소프트웨어 제작)
		OutputStream out; // 클라이언트로 결과값 전송 
		BufferedReader in; // 클라이언트로부터 요청값을 받는다 
		public Client(Socket s)
		{
		   try
		   {
			   this.s=s;
			   out=s.getOutputStream();// 클라이언트로 값을 전송할 목적으로 
			   in=new BufferedReader(new InputStreamReader(s.getInputStream()));
			   
		   }catch(Exception ex) {}
		}
		
		// 통신 
		public void run()
		{
			while(true)
			{
				try
				{
					// 클라이언트가 전송한 메세지 읽기
					String msg=in.readLine();
					System.out.println("Client=>"+msg);
					// 접속한 전체 클라이언트에 값을 전송 
					for(Client c:waitVc)
					{
						c.out.write((msg+"\n").getBytes());
					}
				}catch(Exception ex) {}
			}
		}
	}

}





