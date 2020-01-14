package com.sist.server;
import java.io.*;
import java.net.*;
import java.util.*;
import com.sist.common.*;
public class Server implements Runnable{
	// ����=>����ó�� => ServerSocket
	// �� Ŭ���̾�Ʈ���� ��Ŵ�� (Thread) => Socket <=> Socket
	// 1. ���� ���� 
	private ServerSocket ss;
	private final int PORT=3355;
	// ������ ���� ���� 
	private Vector<Client> waitVc=new Vector<Client>();
	public Server()
	{
		try
		{
			ss=new ServerSocket(PORT);//bind,listen
			System.out.println("Server Start...");
		}catch(Exception ex){}
	}
	// ���ӽ� ó�� 
    public void run()
    {
    	try
    	{
    		while(true)
    		{
    			// ������ �ߴٸ� => Ŭ���̾�Ʈ�� �������� => IP,PORT(Socket)
    			Socket s=ss.accept();
    			// s(Ŭ���̾�Ʈ�� ���� (ip,port) => Thread�� ���� (���ڸ��� ����� �� �� �ִ�)
    		    Client client=new Client(s);
    		    client.start();
    		}
    	}catch(Exception ex) {}
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Server server=new Server();
        new Thread(server).start();
	}
	// ����� ����ϴ� �κ�(��Ŭ���̾�Ʈ���� ���� �۾��� �Ѵ�)
	class Client extends Thread
	{
		String id,name,sex,pos;
		// pos=> ����ġ 
		// ��� 
		Socket s;// ������ 
		// ������
		OutputStream out;
		// �ޱ�
		BufferedReader in;
		
		public Client(Socket s)
		{
			try
			{
				this.s=s;
				out=s.getOutputStream();// Ŭ���̾�Ʈ�� ������ġ => �о �� �ְ� �����
				in=new BufferedReader(new InputStreamReader(s.getInputStream()));
				//InputStreamReader (���ͽ�Ʈ��) => byte=>2byte�� ��ȯ 
			}catch(Exception ex) {}
		}
		
		// Ŭ���̾�Ʈ�� ��� 
		public void run()
		{
			// 100|hong|ȫ�浿|����\n
			try
			{
				while(true)
				{
					String msg=in.readLine();
					StringTokenizer st=
							new StringTokenizer(msg,"|");
					int protocol=Integer.parseInt(st.nextToken());
					switch(protocol)
					{
					   case Function.LOGIN:
					   {
						   id=st.nextToken();
						   name=st.nextToken();
						   sex=st.nextToken();
						   pos="����";
						   
						   
						   messageAll(Function.LOGIN+"|"
								   +id+"|"+name+"|"+sex+"|"+pos);
						   
						   waitVc.add(this);
						   
						   messageTo(Function.MYLOG+"|"+id);
						   
						   for(Client user:waitVc)
						   {
							   messageTo(Function.LOGIN+"|"
						        +user.id+"|"+user.name+"|"
						        +user.sex+"|"+user.pos);
						   }
						   break;
					   }
					}
				}
			}catch(Exception ex) {}
		}
		// �ݺ��� ���� => �޼ҵ� 
		// �������� => ���� 
		// ���������� ����
		public synchronized void messageTo(String msg)
		{
			try
			{
				out.write((msg+"\n").getBytes());
				// readLine() => ������ ���� =(\n)
			}catch(Exception ex) {}
		}
		// ��ü������ ���� 
		public synchronized void messageAll(String msg)
		{
			try
			{
				for(Client user:waitVc)
				{
					user.messageTo(msg);
				}
			}catch(Exception ex) {}
		}
		
	}

}






