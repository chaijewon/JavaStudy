import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class GameRoom extends JPanel{
   JPanel[] pans=new JPanel[6];
   JTextField[] ids=new JTextField[6];
   JTextArea ta=new JTextArea();
   JTextField tf=new JTextField();
   JButton b1,b2,b3,b4,b5;
   GameView games=new GameView();
   public GameRoom()
   {
	   for(int i=0;i<6;i++)
	   {
		   pans[i]=new JPanel();
		   pans[i].setBackground(Color.black);
		   ids[i]=new JTextField();
	   }
	   setLayout(null);
	   pans[0].setBounds(10, 15, 150,120 );
	   pans[0].setLayout(new BorderLayout());
	   pans[0].add("Center",new JLabel(new ImageIcon(getImageSizeChange(new ImageIcon("c:\\image\\w1.png"), 150, 120))));
	   ids[0].setBounds(10, 140, 150, 30);
	   ids[0].setEditable(false);
	   ids[0].setText("심청이");
	   
	   pans[1].setBounds(10, 180, 150,120 );
	   pans[1].setLayout(new BorderLayout());
	   pans[1].add("Center",new JLabel(new ImageIcon(getImageSizeChange(new ImageIcon("c:\\image\\w2.png"), 150, 120))));
	   ids[1].setBounds(10, 305, 150, 30);
	   ids[1].setEditable(false);
	   ids[1].setText("이순신");
	   
	   pans[2].setBounds(10, 345, 150,120 );
	   pans[2].setLayout(new BorderLayout());
	   pans[2].add("Center",new JLabel(new ImageIcon(getImageSizeChange(new ImageIcon("c:\\image\\m1.png"), 150, 120))));
	   ids[2].setBounds(10, 470, 150, 30);
	   ids[2].setEditable(false);
	   ids[2].setText("박문수");
	   
	   pans[3].setBounds(850, 15, 150,120 );
	   pans[3].setLayout(new BorderLayout());
	   pans[3].add("Center",new JLabel(new ImageIcon(getImageSizeChange(new ImageIcon("c:\\image\\m2.png"), 150, 120))));
	   ids[3].setBounds(850, 140, 150, 30);
	   ids[3].setEditable(false);
	   ids[3].setText("춘향이");
	   
	   pans[4].setBounds(850, 180, 150,120 );
	   pans[4].setLayout(new BorderLayout());
	   pans[4].add("Center",new JLabel(new ImageIcon(getImageSizeChange(new ImageIcon("c:\\image\\w3.png"), 150, 120))));
	   ids[4].setBounds(850, 305, 150, 30);
	   ids[4].setEditable(false);
	   ids[4].setText("홍길동");
	   
	   pans[5].setBounds(850, 345, 150,120 );
	   pans[5].setLayout(new BorderLayout());
	   pans[5].add("Center",new JLabel(new ImageIcon(getImageSizeChange(new ImageIcon("c:\\image\\w4.png"), 150, 120))));
	   ids[5].setBounds(850, 470, 150, 30);
	   ids[5].setEditable(false);
	   ids[5].setText("소서노");
	   
	   for(int i=0;i<6;i++)
	   {
		   add(pans[i]);
		   add(ids[i]);
	   }
	   
	   games.setBackground(Color.white);
	   games.setBounds(170, 15, 670, 485);
	   add(games);
	   
	   JScrollPane js=new JScrollPane(ta);
	   js.setBounds(10, 510, 830, 180);
	   add(js);
	   
	   tf.setBounds(10, 695, 830, 30);
	   add(tf);
	   
	   b1=new JButton("초대하기");
	   b2=new JButton("강퇴하기");
	   b3=new JButton("게임준비");
	   b4=new JButton("게임시작");
	   b5=new JButton("나가기");
	   
	   JPanel p=new JPanel();
	   p.setLayout(new GridLayout(5,1,5,5));
	   p.add(b1);p.add(b2);p.add(b3);p.add(b4);p.add(b5);
	   p.setBounds(850, 510, 150, 210);
	   add(p);
   }
   public Image getImageSizeChange(ImageIcon icon,int width,int height)
   {
   	Image img=icon.getImage();
   	Image change=img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
   	return change;
   }
}


