import java.awt.*;
import java.awt.event.*;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;

import javax.swing.*;

public class GameView extends JPanel{
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
	Test can;
	JButton jbt1, jbt2, jbt3, jbt4, jbt5, jbt6,jbt7,jbt8;
	JComboBox jcb;

	public GameView() {
		can = new Test();
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
		jbt7 = new JButton("지우개");
		jbt7.setBackground(Color.white);
		/*
		 * jbt7 = new JButton("화면"); jbt7.setBackground(Color.magenta);
		 */

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
		

		jp.add(jbt1);
		jp.add(jbt2);
		jp.add(jbt3);
		jp.add(jbt4);
		jp.add(jbt5);
		jp.add(jbt6);
		jp.add(jbt7);
		//jp.add(jbt8);
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
		jbt7.addActionListener(new ActionListener() {
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
				//send
			}
		});

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
		else if (str.equalsIgnoreCase("지우개"))
			can.setC(Color.white);
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
// repaint => update(){clearRect() paint()}
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
