package com.sist.client;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

import com.sist.common.Function;
import com.sist.dao.*;
// ���� ���� 
import java.util.*;
import java.net.*;
import java.io.*;
public class MainForm extends JFrame implements ActionListener,Runnable{
   Login login=new Login();
   WaitRoom wr=new WaitRoom();
   GameRoom gr=new GameRoom();
   MakeRoom mr=new MakeRoom();
   CardLayout card=new CardLayout();
   // ���� ����� ���õ� ���̺귯��
   Socket s;// ��������
   OutputStream out;// ������ ������ ���� (��û)
   BufferedReader in;// �������� ������ �����͸� �޴´� 
   /*
    *   1) ������ ���� ������ ������ => �̺�Ʈ �߻� 
    *                           
    *   2) �������� ������ ������ => Thread => ��� (Function)
    */
   MainForm() {
	  setLayout(card);
	  add("LOGIN",login);
	  add("WR",wr);
	  add("GAME",gr);
	  setBounds(448,216,1024, 768);
	  setVisible(true);// ������ ������ 
	  
	  setResizable(false);// ũ�� ���� ���� => ȭ�� ����
	  setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
	  login.b1.addActionListener(this);
	  wr.tf.addActionListener(this);
	  wr.b6.addActionListener(this);// ������ 
	  wr.b1.addActionListener(this);// �游��� 
	  
	  mr.b1.addActionListener(this);// ���� �游���
	  mr.b2.addActionListener(this);
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
				connection(result);
			}
		}
		else if(e.getSource()==wr.tf)// ����ä��
		{
			// �Էµ� ���ڿ� �б�
			String msg=wr.tf.getText();
			if(msg.length()<1)// �Է��� �ȵ� ���
			{
				wr.tf.requestFocus();
				return;
			}
			
			// ������ ���� 
			try
			{
				out.write((Function.WAITCHAT+"|"+msg+"\n").getBytes());
			}catch(Exception ex) {}
			
			wr.tf.setText("");
		}
		// ������(����)
		else if(e.getSource()==wr.b6)
		{
			try
			{
				out.write((Function.EXIT+"|\n").getBytes());
				/*
				 *   ������ => ��û 
				 *           ===
				 *           ó�� ==> ���� 
				 *           ������ => Ŭ���̾�Ʈ 
				 */
			}catch(Exception ex) {}
		}
		else if(e.getSource()==wr.b1) //�游��� ��ư Ŭ�� 
		{
			mr.tf.setText("");
			mr.rb1.setSelected(true);
			mr.box.setSelectedIndex(0);
			mr.la4.setVisible(false);
			mr.pf.setVisible(false);
			mr.pf.setText("");
			mr.tf.requestFocus();
			mr.setVisible(true);
		}
		else if(e.getSource()==mr.b1)
		{
			// 1. ���̸� 
			String rn=mr.tf.getText();
			if(rn.length()<1)
			{
				JOptionPane.showMessageDialog(this, "���̸��� �Է��ϼ���");
				mr.tf.requestFocus();
				return;
			}
			
			for(int i=0;i<wr.model1.getRowCount();i++)
			{
				String roomName=wr.model1.getValueAt(i, 0).toString();
				if(rn.equals(roomName))
				{
					JOptionPane.showMessageDialog(this,
							"�̹� �����ϴ� ���Դϴ�\n�ٽ��Է��ϼ���");
					mr.tf.setText("");
					mr.tf.requestFocus();
					return;
				}
			}
			
			// ���� �����
			String rs="";//����
			String rp="";//��й�ȣ 
			if(mr.rb1.isSelected())
			{
				rs="����";
				rp=" ";
			}
			else
			{
				rs="�����";
				rp=String.valueOf(mr.pf.getPassword());
			}
			
			// �ο�
			int inwon=mr.box.getSelectedIndex()+2;
			
			// ������ ���� 
			try
			{
				out.write((Function.MAKEROOM+"|"+rn+"|"
			                +rs+"|"+rp+"|"+inwon+"\n").getBytes());
			}catch(Exception ex) {}
            mr.setVisible(false);			
			
		}
		else if(e.getSource()==mr.b2)
		{
			mr.setVisible(false);
		}
	}// actionPerformed end
	public void connection(String userData)
	{
		try
		{
			s=new Socket("localhost",3355);// ��ȭ�ɱ�
			// �۽�/����
			// �۽� 
			out=s.getOutputStream();
			in=new BufferedReader(new InputStreamReader(s.getInputStream()));
			
			// �α��� ������ ������ 
			// 100|hong|ȫ�浿|����\n
			out.write((Function.LOGIN+"|"+userData+"\n").getBytes());
		}catch(Exception ex) {}
		// �����κ��� �����͸� �б� ���� 
		new Thread(this).start();
	}
	
	// �����κ��� �����͸� �����ϴ� ��� 
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try
		{
			while(true)
			{
				// 100|hong|ȫ�浿|����|����\n
				String msg=in.readLine();
				StringTokenizer st=new StringTokenizer(msg,"|");
				int protocol=Integer.parseInt(st.nextToken());
				switch(protocol)
				{
				  case Function.LOGIN:
				  {
					  String[] data= {
						 st.nextToken(), //���̵�
						 st.nextToken(), // �̸�
						 st.nextToken(), // ����
						 st.nextToken()  // ��ġ
					  };
					  wr.model2.addRow(data);
					  break;
				  }
				  case Function.MYLOG:
				  {
					  String id=st.nextToken();
					  setTitle(id);
					  card.show(getContentPane(), "WR");
					  break;
				  }
				  case Function.WAITCHAT:
				  {
					  wr.tp.append(st.nextToken()+"\n");
					  break;
				  }
				  case Function.EXIT: // ���� �ִ� ��� 
				  {
					  String id=st.nextToken();
					  for(int i=0;i<wr.model2.getRowCount();i++)
					  {
						  String mid=wr.model2.getValueAt(i,0).toString();
						  // (String)wr.model2.getValueAt(i,0)
						  if(mid.equals(id))
						  {
							  wr.model2.removeRow(i);
							  break;
						  }
					  }
					  break;
				  }
				  case Function.MYEXIT: // ���� ������ ��� ó��
				  {
					  dispose();// �޸� ȸ��
					  System.exit(0);// ���α׷� ����
				  }
				  case Function.MAKEROOM:
				  {
					 String[] data= {
						st.nextToken(), // ���̸�
						st.nextToken(), // ����(����/�����)
						st.nextToken()  //  1/6
					 };
					 wr.model1.addRow(data);
					 break;  
				  }
				}
				
			}
		}catch(Exception ex) {}
	}
}








