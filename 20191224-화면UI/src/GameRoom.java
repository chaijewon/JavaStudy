import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class GameRoom extends JPanel{
   JPanel[] pans=new JPanel[6];
   JTextField[] ids=new JTextField[6];
   JTextArea ta=new JTextArea();
   JTextField tf=new JTextField();
   JButton b1,b2,b3,b4,b5;
   JPanel games=new JPanel();
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
	   ids[0].setBounds(10, 140, 150, 30);
	   
	   pans[1].setBounds(10, 180, 150,120 );
	   ids[1].setBounds(10, 305, 150, 30);
	   
	   pans[2].setBounds(10, 345, 150,120 );
	   ids[2].setBounds(10, 470, 150, 30);
	   
	   pans[3].setBounds(850, 15, 150,120 );
	   ids[3].setBounds(850, 140, 150, 30);
	   
	   pans[4].setBounds(850, 180, 150,120 );
	   ids[4].setBounds(850, 305, 150, 30);
	   
	   pans[5].setBounds(850, 345, 150,120 );
	   ids[5].setBounds(850, 470, 150, 30);
	   
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
}


