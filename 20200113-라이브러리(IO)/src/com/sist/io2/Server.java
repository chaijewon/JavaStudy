package com.sist.io2;
import java.util.*;
import java.io.*;
import java.net.*;
/*
 *     Ŭ������ ���� 
 *       = �Ϲ� Ŭ���� 
 *       = �߻� Ŭ����(�������̽�)
 *       = ����Ŭ���� 
 *          1) Ŭ�������� �����͸� ���� => static  ==> ���Ŭ����
 *             class A
 *             {
 *                class B
 *                {
 *                }
 *             }
 *             Server�� ������ �ִ� ��� ������ ����
 *          2) ��Ӿ��� �������̵��� ��� => �͸��� Ŭ���� 
 */
public class Server implements Runnable{
    private ServerSocket ss;
    private final int PORT=3355;
    private Vector<Client> waitVc=new Vector<Client>();// ������ ������ ���� (ip,port)
	
    // ���� ����  => Server => �޸� �Ҵ��� �ѹ��� ��� 
    public Server() {
    	try
    	{
    		ss=new ServerSocket(PORT);// 50���� ��� 
    		// ���� => bind , ������ => listen
    		System.out.println("Server Start...");
    	}catch(Exception ex){}
    }
    
    @Override
	public void run() {
		// TODO Auto-generated method stub
		// ���ӽÿ� ó�� 
    	while(true)
    	{
    		try
    		{
    			// ���ӽÿ� Ŭ���̾�Ʈ�� ������ �޾Ƽ� �����ϰ� => ������� ���� 
    			// ���ӽÿ� ���� ==> Socket(ip,port)
    			Socket s=ss.accept();// �����̵Ǹ� ȣ��Ǵ� �޼ҵ� 
    			// Socket ==> Ŭ���̾�Ʈ (����)
    			System.out.println("Ŭ���̾�Ʈ ���� �Ϸ�!!=>"
    					+s.getInetAddress().getHostAddress());
    			Client client=new Client(s);
    			client.start();// Client=> run() :���
    			waitVc.add(client);
    			// ������ ���� 
    		}catch(Exception ex) {}
    	}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Server server=new Server();
        new Thread(server).start();
	}
	// innerŬ���� => Thread,������ => ������
	class Client extends Thread
	{
		// Server�� ������ �ִ� ��� �����͸� ��� �� �� �ִ�
		Socket s;// Ŭ���̾�Ʈ�� ���� ��ȭ��(������=>����Ʈ���� ����)
		OutputStream out; // Ŭ���̾�Ʈ�� ����� ���� 
		BufferedReader in; // Ŭ���̾�Ʈ�κ��� ��û���� �޴´� 
		public Client(Socket s)
		{
		   try
		   {
			   this.s=s;
			   out=s.getOutputStream();// Ŭ���̾�Ʈ�� ���� ������ �������� 
			   in=new BufferedReader(new InputStreamReader(s.getInputStream()));
			   
		   }catch(Exception ex) {}
		}
		
		// ��� 
		public void run()
		{
			while(true)
			{
				try
				{
					// Ŭ���̾�Ʈ�� ������ �޼��� �б�
					String msg=in.readLine();
					System.out.println("Client=>"+msg);
					// ������ ��ü Ŭ���̾�Ʈ�� ���� ���� 
					for(Client c:waitVc)
					{
						c.out.write((msg+"\n").getBytes());
					}
				}catch(Exception ex) {}
			}
		}
	}

}





