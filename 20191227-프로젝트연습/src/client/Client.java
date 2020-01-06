package client;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Client extends JFrame implements Runnable {
	CardLayout card;
	JPanel card1, card2, jp, jp2;
	JPanel south_p, s1, s2;
	JTextField name_tf;
	JButton login_bt;
	JTextArea jta;
	JPanel input_p;
	JTextField jtf;
	JButton send_bt;
	JPanel t_card;
	Thread t;
	// 자원을 주고 받기 위해 필요한 것
	Socket s;
	ObjectInputStream ois;
	ObjectOutputStream oos;
	InputStream is;
	OutputStream out;
	Test can;
	JButton jbt1, jbt2, jbt3, jbt4, jbt5, jbt6;
	JComboBox jcb;

	public Client() {
		can = new Test();
		setTitle("그리기");
		jbt1 = new JButton("red");
		jbt1.setBackground(Color.red);
		jbt2 = new JButton("orange");
		jbt2.setBackground(Color.orange);
		jbt3 = new JButton("yellow");
		jbt3.setBackground(Color.yellow);
		jbt4 = new JButton("green");
		jbt4.setBackground(Color.green);
		jbt5 = new JButton("blue");
		jbt5.setBackground(Color.blue);
		jbt6 = new JButton("pink");
		jbt6.setBackground(Color.pink);

		String[] str = { "10", "15", "20", "25", "30" };
		jcb = new JComboBox(str);
		jp = new JPanel(new FlowLayout());
		jp2 = new JPanel();
		
		jp.add(jbt1);
		jp.add(jbt2);
		jp.add(jbt3);
		jp.add(jbt4);
		jp.add(jbt5);
		jp.add(jbt6);
		jp.add(jcb);
		setLayout(new BorderLayout());
		add(jp, BorderLayout.NORTH);
		add(can, BorderLayout.CENTER);

		setBounds(100, 100, 600, 600);
		setResizable(true);
		setVisible(true);

		jp.add(jbt1);
		jp.add(jbt2);
		jp.add(jbt3);
		jp.add(jbt4);
		jp.add(jbt5);
		jp.add(jbt6);
		jp.add(jcb);
		add(jp, BorderLayout.NORTH);
		add(can, BorderLayout.CENTER);

		jbt1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String str = e.getActionCommand();
				changeColor(str);
			}
		});
		jbt2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String str = e.getActionCommand();
				changeColor(str);
			}
		});
		jbt3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String str = e.getActionCommand();
				changeColor(str);
			}
		});
		jbt4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String str = e.getActionCommand();
				changeColor(str);
			}
		});
		jbt5.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String str = e.getActionCommand();
				changeColor(str);
			}
		});
		jbt6.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String str = e.getActionCommand();
				changeColor(str);
			}
		});
		jcb.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if (e.SELECTED == e.getStateChange()) {
					String str = (String) e.getItem();
					if (str.equalsIgnoreCase("10"))
						can.setSize(10);
					else if (str.equalsIgnoreCase("15"))
						can.setSize(15);
					else if (str.equalsIgnoreCase("20"))
						can.setSize(20);
					else if (str.equalsIgnoreCase("25"))
						can.setSize(25);
					else if (str.equalsIgnoreCase("30"))
						can.setSize(30);
				}
			}
		});

		can.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				can.setX(e.getX() - 15);
				can.setY(e.getY() - 15);
				can.repaint();
				sendMsg(e.getX() -15, e.getY() -15, can.getC(), can.getSiz());
			}
		});

		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				if (s != null) { // 접속이 된 상태
					PaintProtocol p = new PaintProtocol();
					p.setCmd(1);
					try {
						oos.writeObject(p); // 서버에 정료보내기
					} catch (Exception e2) {
					}
				} else { // 접속하지 않은 상태
					System.exit(0);
				}
			}
		});
		connected();
	}

	@Override
	public void run() {
		// 서버로부터 Protocol을 받는다.
		bk: while (true) {
			try {
				PaintProtocol p = (PaintProtocol) ois.readObject();
				System.out.println(p.getColor()+""+p.getWh()+p.getCmd());
				switch (p.getCmd()) {
				case 2: // 그리기
					can.setC(p.getColor());
					can.setX(p.getX());
					can.setY(p.getY());
					can.setSize(p.getWh());
					can.repaint();
					break;
				case 1:
					;
				}
			} catch (Exception e) {
				
			}
		}
	}

	public void sendMsg(int x, int y, Color c, int size) {
		// 사용자가 그린대로 보내기
		PaintProtocol p = new PaintProtocol(x, y, size, 2, c);
		try {
			oos.writeObject(p);
		} catch (Exception e) {
			System.out.println("msg 에러");
		}
	}

	public void connected() {
		try {
			s = new Socket("localhost", 7777);
			is = s.getInputStream();
			out = s.getOutputStream();
			ois = new ObjectInputStream(is);
			oos = new ObjectOutputStream(out);
			t = new Thread(this);
			t.start();
			//PaintProtocol p = new PaintProtocol();
			//p.setCmd(0);
			//oos.writeObject(p); // 최초로 서버에 전달
			
		} catch (Exception e) {
		}

	}

	public void changeColor(String str) {
		if (str.equalsIgnoreCase("red"))
			can.setC(Color.red);
		else if (str.equalsIgnoreCase("orange"))
			can.setC(Color.orange);
		else if (str.equalsIgnoreCase("blue"))
			can.setC(Color.blue);
		else if (str.equalsIgnoreCase("green"))
			can.setC(Color.green);
		else if (str.equalsIgnoreCase("yellow"))
			can.setC(Color.yellow);
		else if (str.equalsIgnoreCase("pink"))
			can.setC(Color.pink);
	}

	public static void main(String[] args) {
		new Client();
	}

	public class Test extends Canvas {
		private int x = -30;
		private int y = -30;
		Color c = Color.green;
		int size = 20;

		@Override
		public void paint(Graphics g) {
			g.setColor(c);
			g.fillOval(x, y, size, size);

		}

		public int getSiz() {
			return size;
		}

		public Color getC() {
			return c;
		}

		public void setSize(int size) {
			this.size = size;
		}

		public void setC(Color c) {
			this.c = c;
		}

		@Override
		public void update(Graphics g) {
			paint(g);
		}

		public int getX() {
			return x;
		}

		public void setX(int x) {
			this.x = x;
		}

		public int getY() {
			return y;
		}

		public void setY(int y) {
			this.y = y;
		}
	}
}
