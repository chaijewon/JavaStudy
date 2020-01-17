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
public class MainForm extends JFrame implements ActionListener,Runnable,MouseListener{
   String[] dap= {"a","b","c","d","e","f","g","h","i","j"};
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
   String myRoom,myId;
   int imageNo=1;
   int count=0;
   ProgressThread pt;
   MainForm() {
	   pt=new ProgressThread();
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
	  
	  wr.table1.addMouseListener(this);
	  
	  // ��ȿ��� ä�� ��� 
	  gr.tf.addActionListener(this);
	  gr.b5.addActionListener(this);// �泪���� ��ư 
	  gr.b2.addActionListener(this);// ����
	  gr.b3.addActionListener(this);
	  gr.b4.addActionListener(this);
	  
	  gr.dapTf.addActionListener(this);
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
			String rp=" ";//��й�ȣ 
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
		else if(e.getSource()==gr.tf)
		{
			String msg=gr.tf.getText();
			if(msg.length()<1)
				return;
			try
			{
				out.write((Function.ROOMCHAT+"|"+myRoom+"|"+msg+"\n").getBytes());
			}catch(Exception ex){}
			
			gr.tf.setText("");
		}
		else if(e.getSource()==gr.b5)// �泪����
		{
			try
			{
				out.write((Function.ROOMOUT+"|"+myRoom+"\n").getBytes());
			}catch(Exception ex) {}
		}
		else if(e.getSource()==gr.b2)
		{
			String youId=gr.box.getSelectedItem().toString();
			try
			{
				out.write((Function.KANG+"|"+myRoom+"|"+youId+"\n").getBytes());
			}catch(Exception ex){}
		}
		else if(e.getSource()==gr.b3)
		{
			gr.games.setImage(imageNo);
			gr.games.repaint();
			count=0;
		}
		else if(e.getSource()==gr.b4)
		{
			imageNo++;
			if(imageNo>10)
			{
			   System.out.println("��������!!");
			   System.out.println("����:"+count);
			   return;
			}
			gr.games.setImage(imageNo);
			gr.games.repaint();
			
		}
		else if(e.getSource()==gr.dapTf)
		{
			String data=gr.dapTf.getText();
			System.out.println(data+"|"+dap[imageNo-1]);
			if(data.equals(dap[imageNo-1]))
			{
				gr.daps[imageNo+9].setIcon(new ImageIcon(gr.getImageSizeChange(new ImageIcon("c:\\image\\o.png"), 65, 40)));
				count++;
			}
			else
			{
				gr.daps[imageNo+9].setIcon(new ImageIcon(gr.getImageSizeChange(new ImageIcon("c:\\image\\x.png"), 65, 40)));
			}
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
				System.out.println("Server=>"+msg);
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
				  case Function.ROOMIN:
				  {
					  /*
					   *  Function.ROOMIN+"|"+room.roomName+"|"
								   +id+"|"+sex+"|"+avata
					   */
					  myRoom=st.nextToken();
					  String id=st.nextToken();
					  String sex=st.nextToken();
					  String avata=st.nextToken();
					  String bang=st.nextToken();
					  myId=id;
					  String temp="";
					  if(sex.equals("����"))
					  {
						  temp="m"+avata; // m1.png,m2.png...
					  }
					  else
					  {
						  temp="w"+avata; // w1.png,w2.png
					  }
					  
					  // ȭ�� �̵� 
					  card.show(getContentPane(), "GAME");
					  for(int i=0;i<6;i++)
					  {
						  if(gr.sw[i]==false)
						  {
							  gr.sw[i]=true;
							  gr.pans[i].removeAll();
							  gr.pans[i].setLayout(new BorderLayout());
							  gr.pans[i].add("Center",new JLabel(new ImageIcon(gr.getImageSizeChange(new ImageIcon("c:\\image\\"+temp+".png"), 150, 120))));
							  gr.pans[i].validate();
							  gr.ids[i].setText(id);
							  break;
						  }
					  }
					  
					  gr.bar.setValue(0);
					 
					  break;
				  }
				  case Function.ROOMADD:
				  {
					  String id=st.nextToken();
					  String sex=st.nextToken();
					  String avata=st.nextToken();
					  String bang=st.nextToken();
					  String temp="";
					  if(sex.equals("����"))
					  {
						  temp="m"+avata; // m1.png,m2.png...
					  }
					  else
					  {
						  temp="w"+avata; // w1.png,w2.png
					  }
					  
					  
					  for(int i=0;i<6;i++)
					  {
						  if(gr.sw[i]==false)
						  {
							  gr.sw[i]=true;
							  gr.pans[i].removeAll();
							  gr.pans[i].setLayout(new BorderLayout());
							  gr.pans[i].add("Center",new JLabel(new ImageIcon(gr.getImageSizeChange(new ImageIcon("c:\\image\\"+temp+".png"), 150, 120))));
							  gr.pans[i].validate();
							  gr.ids[i].setText(id);
							  break;
						  }
					  }
					  gr.box.addItem(id);
					  break;
				  }
				  case Function.ROOMCHAT:
				  {
					  gr.ta.append(st.nextToken()+"\n");
					  break;
				  }
				  case Function.WAITUPDATE:
				  {
					  /*
					   * Function.WAITUPDATE+"|"+room.roomName+"|"
										   +room.current+"/"+room.maxcount+"|"+id+"|"+pos
					   */
					  String rn=st.nextToken();
					  String current=st.nextToken();
					  String maxcount=st.nextToken();
					  String id=st.nextToken();
					  String pos=st.nextToken();
					  
					  // ���̺��� ���� ã�´� 
					  for(int i=0;i<wr.model1.getRowCount();i++)
					  {
						  String roomName=wr.model1.getValueAt(i, 0).toString();
						  if(rn.equals(roomName))
						  {
							  if(Integer.parseInt(current)==0)
							  {
								  wr.model1.removeRow(i);
							  }
							  else
							  {
							      wr.model1.setValueAt(current+"/"+maxcount, i, 2);
							  }
							  break;
						  }
					  }
					  // ������ ��� ���� 
					  for(int i=0;i<wr.model2.getRowCount();i++)
					  {
						  String mid=wr.model2.getValueAt(i, 0).toString();
						  if(mid.equals(id))
						  {
							  wr.model2.setValueAt(pos, i, 3);
							  break;
						  }
					  }
					  break; 
				  }
				  
				  case Function.POSCHANGE:
				  {
					  String id=st.nextToken();
					  String pos=st.nextToken();
					  for(int i=0;i<wr.model2.getRowCount();i++)
					  {
						  String mid=wr.model2.getValueAt(i, 0).toString();
						  if(mid.equals(id))
						  {
							  wr.model2.setValueAt(pos, i, 3);
							  break;
						  }
					  }
					  break;
				  }
				  case Function.ROOMOUT:
				  {
					  String id=st.nextToken();
					  for(int i=0;i<6;i++)
					  {
						  String mid=gr.ids[i].getText();
						  if(id.equals(mid))
						  {
							  gr.sw[i]=false;
							  gr.pans[i].removeAll();
							  gr.pans[i].setLayout(new BorderLayout());
							  gr.pans[i].add("Center",new JLabel(new ImageIcon(gr.getImageSizeChange(new ImageIcon("c:\\image\\def.png"), 150, 120))));
							  gr.pans[i].validate();
							  gr.ids[i].setText("");
							  break;
						  }
					  }
					  break;
				  }
				  case Function.MYROOMOUT:
				  {
					  // �ʱ�ȭ 
					  for(int i=0;i<6;i++)
					  {
						  gr.sw[i]=false;
						  gr.pans[i].removeAll();
						  gr.pans[i].setLayout(new BorderLayout());
						  gr.pans[i].add("Center",new JLabel(new ImageIcon(gr.getImageSizeChange(new ImageIcon("c:\\image\\def.png"), 150, 120))));
						  gr.pans[i].validate();
						  gr.ids[i].setText("");
					  }
					  gr.ta.setText("");
					  gr.tf.setText("");
					  card.show(getContentPane(), "WR");
					  
					  pt.interrupt();
					  break;
				  }
				  case Function.KANG:
				  {
					  String rn=st.nextToken();
					  JOptionPane.showMessageDialog(this, rn+"�濡�� ����Ǿ����ϴ�");
					  out.write((Function.ROOMOUT+"|"+rn+"\n").getBytes());
					  break;
				  }
				  case Function.START:
				  {
					  //JOptionPane.showMessageDialog(this, st.nextToken());
					  gr.ta.append(st.nextToken()+"\n");
					  gr.games.setImage(0);
					  gr.games.repaint();
					  pt=new ProgressThread();
					  pt.start();
					  break;
				  }
				  
				  case Function.END:
				  {
					  System.out.println("����:"+count);
					  JOptionPane.showMessageDialog(this, "������ ����Ǿ����ϴ�");
				  }
				}
				
			}
		}catch(Exception ex) {}
	}
	
	/*
	 *    switch(no)
	 *    {
	 *       case 1:
	 *       {
	 *          int num=3;
	 *          break;
	 *       }
	 *       case 2:
	 *          int num=5;
	 *          break;
	 *       case 3:
	 *          int num=7;
	 *          break;
	 *    }
	 *    
	 *    for()
	 *    {
	 *       for()
	 *       {
	 *          break;
	 *       }
	 *       
	 *    }
	 */
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==wr.table1)
		{
			if(e.getClickCount()==2)// ���� Ŭ�� 
			{
				// ���̸� 
				int row=wr.table1.getSelectedRow();
				String rn=wr.model1.getValueAt(row,0).toString();
				String inwon=wr.model1.getValueAt(row,2).toString();
				//String state=wr.model1.getValueAt(row, 1).toString();
				StringTokenizer st=new StringTokenizer(inwon,"/");
				// 1/5
				int no1=Integer.parseInt(st.nextToken());// 1
				int no2=Integer.parseInt(st.nextToken());// 5
				if(no1==no2)
				{
					// �濡 �� �� ����
					JOptionPane.showMessageDialog(this, 
							"�̹� ���ο��� á���ϴ�\n�ٸ� ���� �����ϼ���");
				}
				else
				{
					// �濡 �� �� �ִ�
					try
					{
						out.write((Function.ROOMIN+"|"+rn+"\n").getBytes());
					}catch(Exception ex) {}
				}
				
			}
		}
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	class ProgressThread extends Thread
	{
		public void run()
		{
			try
			{
				for(int i=0;i<=100;i++)
				{
					gr.bar.setValue(i);
					Thread.sleep(500);
					if(i>=100)
					{
						out.write((Function.END+"|"+myRoom+"\n").getBytes());
					}
				}
				
			}catch(Exception ex) {}
		}
	}
}








