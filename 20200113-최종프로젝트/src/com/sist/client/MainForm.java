package com.sist.client;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import com.sist.dao.*;
public class MainForm extends JFrame implements ActionListener{
   Login login=new Login();
   WaitRoom wr=new WaitRoom();
   //GameRoom gr=new GameRoom();
   CardLayout card=new CardLayout();
   MainForm() {
	  setLayout(card);
	  //add("GAME",gr);
	  add("LOGIN",login);
	  add("WR",wr);
	  
	  setSize(1024, 768);
	  setVisible(true);// ������ ������ 
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
	    new MainForm();
	    
   }
  
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==login.b1)
		{
			String id=login.tf.getText();
			if(id.length()<1)
			{
				JOptionPane.showMessageDialog(this, "ID�� �Է��ϼ���");
				login.tf.requestFocus();
				return;
			}
			
			String pwd=String.valueOf(login.pf.getPassword());
			if(pwd.length()<1)
			{
				JOptionPane.showMessageDialog(this, "��й�ȣ�� �Է��ϼ���");
				login.pf.requestFocus();
				return;
			}
			
			// ó��
			MemberDAO dao=new MemberDAO();
			String result=dao.isLogin(id, pwd);
			if(result.equals("NOID"))
			{
				JOptionPane.showMessageDialog(this, "ID�� �������� �ʽ��ϴ�");
				login.tf.setText("");
				login.pf.setText("");
				login.tf.requestFocus();
			}
			else if(result.equals("NOPWD"))
			{
				JOptionPane.showMessageDialog(this, "��й�ȣ�� Ʋ���ϴ�");
				login.pf.setText("");
				login.pf.requestFocus();
			}
			else
			{
				JOptionPane.showMessageDialog(this, id+"�� �α��εǾ����ϴ�");
				card.show(getContentPane(), "WR");
				
			}
		}
	}
}








