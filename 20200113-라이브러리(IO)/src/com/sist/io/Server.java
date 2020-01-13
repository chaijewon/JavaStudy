package com.sist.io;
import java.io.*;
import java.net.*;
/*
 *   MVC , Spring , Kotlin 
 *   =====================
 *   
 *   ���� :
 *        ��⼭�� => 1��  ===> ������ (Socket) => ��ȭ��
 *                 ServerSocket => ���ӽ� ó�� 
 *        ��ż��� => ���Ӽ���ŭ ���� (Thread)
 *                 Socket => ���� ��� 
 *                 
 *   ���� => �������� ����ϴ� ���α׷��� �ʿ� 
 *         ========== ���� 
 */
public class Server implements Runnable{
    private ServerSocket ss;
    public Server()
    {
    	try
    	{
    		ss=new ServerSocket(3355);
    		// bind => ����(����� ����) 
    		// bind => 1.IP , 2. Port 
    		// ������ port => ���� ��Ʈ, Ŭ���̾�Ʈ => �ӽ� ��Ʈ 
    		// listen => ������
    		System.out.println("Server Start...");
    	}catch(Exception ex) {}
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Server server=new Server();
        new Thread(server).start();
        // server�� �ִ� run�Լ��� ȣ�� 
	}
    // ������ �۵� 
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true)
		{
			try
			{
				Socket s=ss.accept();// Ŭ���̾�Ʈ�� ���� (Socket)
				System.out.println("������ Ŭ���̾�Ʈ�� IP:"+s.getInetAddress().getHostAddress());
				System.out.println("�ӽ���Ʈ:"+s.getPort());
				System.out.println("=======================");
			}catch(Exception ex) {}
		}
	}

}





