import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class MainForm extends JFrame implements ActionListener{
   Login login=new Login();
   WaitRoom wr=new WaitRoom();
   CardLayout card=new CardLayout();
   MainForm() {
	  setLayout(card);
	  add("LOGIN",login);
	  add("WR",wr);
	  
	  setSize(1024, 768);
	  setVisible(true);// 윈도우 보여라 
	  login.b1.addActionListener(this);
   }
   public static void main(String[] args) {
	   try
	   {
   		UIManager.setLookAndFeel("com.jtattoo.plaf.mcwin.McWinLookAndFeel");
			//UIManager.setLookAndFeel("com.jtattoo.plaf.acryl.AcrylLookAndFeel");
			JFrame.setDefaultLookAndFeelDecorated(true);
		}
		catch(Exception e){}
	   MainForm mf=new MainForm();
   }
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==login.b1)
		{
			card.show(getContentPane(), "WR");
		}
	}
}
