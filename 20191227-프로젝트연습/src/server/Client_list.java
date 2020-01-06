package server;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Client_list extends Thread {
	Socket s;
	PaintServer server;
	ObjectOutputStream out;
	ObjectInputStream in;

	public Client_list() {
	}

	public Client_list(Socket s, PaintServer server) {
		this.s = s;
		this.server = server;
		try {
			out = new ObjectOutputStream(s.getOutputStream());
			in = new ObjectInputStream(s.getInputStream());
		} catch (Exception e) {
		}
	}

	@Override
	public void run() {
		bk: while (true) {
			try {
				PaintProtocol p = (PaintProtocol) in.readObject();
				switch (p.getCmd()) {
				case 1:	// 종료
					out.writeObject(p);
					out.flush();
					server.del(this);
					break;
				case 2:	// 그리기
					server.sendMsg(p);
					break;
				}
			} catch (Exception e) {
			}

		}
	}
}
