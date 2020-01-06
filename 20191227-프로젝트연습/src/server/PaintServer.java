package server;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Iterator;



public class PaintServer implements Runnable{
	ServerSocket ss;
	Socket s;
	Thread t;
	ArrayList<Client_list> list = new ArrayList<Client_list>();
	
	
	public PaintServer() {
		try {
			t = new Thread(this);
			t.start();
			ss= new ServerSocket(7777);
			System.out.println("서버 대기중....");
		} catch (Exception e) {
		}
	}
	
	public static void main(String[] args) {
		new PaintServer();
	}

	public void sendMsg(PaintProtocol p){
		
		try {
			
			Iterator<Client_list> it = list.iterator();
			/*
			for(Client_list k: list){
				System.out.println("쏜다");
				k.out.writeObject(p);
				k.out.flush();
			}*/
			
			while(it.hasNext()){
				Client_list k= it.next();
				k.out.writeObject(p);
				k.out.flush();
				System.out.println(k.getName()+" "+k.server+" "+k.s+" ");
			}
		} catch (Exception e) {
		
		}
	}
	
	public void del(Client_list p){
		list.remove(p);
	}
	@Override
	public void run() {
		while(true){
			try {
				s = ss.accept();
				Client_list c_list = new Client_list(s, this);
				list.add(c_list);	
				c_list.start();
			} catch (Exception e) {
			}
		}
	}
}
