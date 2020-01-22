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
	private Vector<Room> roomVc=new Vector<Room>();
	public Server()
	{
		try
		{
			ss=new ServerSocket(PORT);//bind,listen
			System.out.println("Server Start...");
		}catch(Exception ex){System.out.println(ex.getMessage());}
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
		int avata,score,rank;
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
					String msg=in.readLine();// Ŭ���̾�Ʈ�� ���۰�(��û)
					System.out.println("Client=>"+msg);
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
						   avata=Integer.parseInt(st.nextToken());
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
						   
						   // ������ ������ ���� 
						   for(Room room:roomVc)
						   {
							   messageTo(Function.MAKEROOM+"|"+room.roomName+"|"
									   +room.roomState+"|"
									   +room.current+"/"+room.maxcount);
						   }
						   
						   break;
					   }
					   case Function.WAITCHAT:
					   {
						   messageAll(Function.WAITCHAT+"|["+name+"]"+st.nextToken());
						   break;
					   }
					   case Function.EXIT:
					   {
						   String mid=id;
						   for(int i=0;i<waitVc.size();i++)
						   {
							   Client user=waitVc.get(i);
							   if(mid.equals(user.id))
							   {
								   // ������ ����
								   messageTo(Function.MYEXIT+"|");
								   // Vector���� ����
								   waitVc.remove(i);
								   // �ݱ�(��� ����)
								   in.close();
								   out.close();
								   break;
							   }
						   }
						   // ��ü �޼��� => ������ ������ ���̺��� ����
						   messageAll(Function.EXIT+"|"+mid);
						   break;
					   }
					   case Function.MAKEROOM:
					   {
						   /*
						    *   Function.MAKEROOM+"|"+rn+"|"
			                +rs+"|"+rp+"|"+inwon+
						    */
						   Room room=new Room(st.nextToken(), st.nextToken(), st.nextToken(), Integer.parseInt(st.nextToken()));
						   room.userVc.add(this);
						   
						   roomVc.add(room);
						   pos=room.roomName;
						   room.bang=id;
						   messageAll(Function.MAKEROOM+"|"+room.roomName+"|"
								   +room.roomState+"|"
								   +room.current+"/"+room.maxcount);
						   
						   // �濡 ���� ����� 
						   messageTo(Function.ROOMIN+"|"+room.roomName+"|"
								   +id+"|"+sex+"|"+avata+"|"+room.bang);
						   
						   // ����
						   messageAll(Function.POSCHANGE+"|"+id+"|"+pos);
						   break;
					   }
					   case Function.ROOMIN:
					   {
						   // Function.ROOMIN+"|"+rn
						   String rn=st.nextToken();
						   /*
						    *    1. ���̸��� �޴´� 
						    *    2. ���� ã�´� (roomVc)
						    *    3. pos,current�� ����
						    *    ====================
						    *    =  �濡 �ִ� ���ó�� => ROOMADD
						    *       1. �濡 �����ϴ� ����� ���� ����(id,avata..)
						    *       2. ����޼��� ���� 
						    *    =  �濡 ���� ��� ó�� 
						    *       1. �濡 ���� => ROOIN
						    *       2. �濡 �ִ� ������� ������ �����ش� 
						    *    =  ���� ���� 
						    *       �ο����� ���� => �޼��� ���� 
						    */
						   for(Room room:roomVc)
						   {
							   if(rn.equals(room.roomName))// ��ã��
							   {
								   pos=room.roomName;
								   room.current++;
								   
								   for(Client user:room.userVc)
								   {
									   user.messageTo(Function.ROOMADD+"|"
											  +id+"|"+sex+"|"+avata+"|"+room.bang);
									   user.messageTo(Function.ROOMCHAT
											   +"|[�˸� ��]"+id+"���� �����ϼ̽��ϴ�");
								   }
								   
								   // ���� ó��
								   room.userVc.add(this);
								   messageTo(Function.ROOMIN+"|"+room.roomName+"|"
										   +id+"|"+sex+"|"+avata+"|"+room.bang);
								   
								   for(Client user:room.userVc)
								   {
									   if(!id.equals(user.id))
									   {
										   messageTo(Function.ROOMADD+"|"
												+user.id+"|"+user.sex+"|"+user.avata+"|"+room.bang);
									   }
								   }
								   // ���� ���� 
								   messageAll(Function.WAITUPDATE+"|"+room.roomName+"|"
										   +room.current+"|"+room.maxcount+"|"+id+"|"+pos);
								   
								   if(room.current==room.maxcount)
								   {
									   for(Client user:room.userVc)
									   {
										   user.messageTo(Function.START+"|[�˸� ��] ������ �����մϴ�");
									   }
								   }
							   }
							   
						   }
						   // ���� ���� 
						   
						   // ��ü������ ���� 
						   /*
						    *    ���� => messageAll
						    *    ��,���� => messageTo
						    *    
						    *    ==> ������ ó�� 
						    *    ==> ���� �ִ� ���..
						    *    ==> ���� 
						    */
						   break;
					   }
					   case Function.ROOMCHAT:
					   {
						   String rn=st.nextToken();
						   String strMsg=st.nextToken();
						   // ���� ã�´�
						   for(Room room:roomVc)
						   {
							   if(rn.equals(room.roomName))
							   {
								   for(Client user:room.userVc)
								   {
									   user.messageTo(Function.ROOMCHAT+"|["+name+"] "+strMsg);
								   }
							   }
						   }
						   break;
					   }
					   case Function.ROOMOUT:
					   {
						   // ��ã��
						   String rn=st.nextToken();
						   for(int i=0;i<roomVc.size();i++)
						   {
							   Room room=roomVc.get(i);
							   if(rn.equals(room.roomName))
							   {
								   pos="����";
								   room.current--;
								   
								   // �濡 ���� �ִ� ��� 
								   for(Client user:room.userVc)
								   {
									   if(!user.id.equals(id))
									   {
										   user.messageTo(Function.ROOMOUT+"|"+id);
										   user.messageTo(Function.ROOMCHAT+"|[�˸� ��] "+name+"���� �����ϼ̽��ϴ�");
									   }
								   }
								   // ���� ������ ���
								   for(int j=0;j<room.userVc.size();j++)
								   {
									   Client user=room.userVc.get(j);
									   if(id.equals(user.id))
									   {
										   //userVc���� ���� 
										   room.userVc.remove(j);
										   messageTo(Function.MYROOMOUT+"|");
										   break;
									   }
								   }
								   // ����
								   messageAll(Function.WAITUPDATE+"|"+room.roomName+"|"
										   +room.current+"|"+room.maxcount+"|"+id+"|"+pos);
								   if(room.current==0)
								   {
									   roomVc.remove(i);
									   break;
								   }
							   }
						   }
						   break;
					   }
					   case Function.KANG:
					   {
						
						   String rn=st.nextToken();
						   String yid=st.nextToken();
						   for(Client user:waitVc)
						   {
							   if(yid.equals(user.id))
							   {
								   user.messageTo(Function.KANG+"|"+rn);
								   break;
							   }
						   }
						   break;
					   }
					   
					   case Function.END:
					   {
						   String rn=st.nextToken();
						   String jumsu=st.nextToken();
						   for(int i=0;i<roomVc.size();i++)
						   {
							   Room room=roomVc.get(i);
							   if(rn.equals(room.roomName))
							   {
							       room.end++;
							       score=Integer.parseInt(jumsu);
							       if(room.end==room.current)
							       {
							    	   String temp="";
							    	   for(int a=0;a<room.userVc.size();a++)
							    	   {
							    		   Client user1=room.userVc.get(a);
							    		   user1.rank=1;
							    		   for(int b=0;b<room.userVc.size();b++)
							    		   {
							    			   Client user2=room.userVc.get(b);
							    			   if(user1.score<user2.score)
							    			   {
							    				   user1.rank++;
							    			   }
							    		   }
							    	   }
							    	   /*
							    	    *   hong /90 /1 @
							    	    *   shim /80 /3 @
							    	    *   kim /85  /2 
							    	    */
							    	   for(Client user:room.userVc)
							    	   {
							    		   temp+=user.id+"/"+user.score+"/"+user.rank+"@";
							    	   }
							    	   temp=temp.substring(0,temp.lastIndexOf("@"));
							    	   System.out.println(temp);
							    	   for(Client user:room.userVc)
							    	   {
							    		   user.messageTo(Function.END+"|"+temp);
							    	   }
							       }
							       break;
							   }
						   }
						   break;
					   }
					   case Function.INVATE:
					   {
						   String yid=st.nextToken();
						   String rn=st.nextToken();
						   for(Client user:waitVc)
						   {
							   if(yid.equals(user.id))
							   {
								   user.messageTo(Function.INVATE+"|"+id+"|"+rn);
								   break;
							   }
						   }
						   break;
					   }
					   case Function.INVATE_NO:
					   {
						   String yid=st.nextToken();
						   for(Client user:waitVc)
						   {
							   if(yid.equals(user.id))
							   {
								   user.messageTo(Function.INVATE_NO+"|"+id);
								   break;
							   }
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






