package com.sist.client;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

import com.sist.common.Function;
import com.sist.dao.*;
// 서버 연결 
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
   // 서버 연결과 관련된 라이브러리
   Socket s;// 서버연결
   OutputStream out;// 서버로 데이터 전송 (요청)
   BufferedReader in;// 서버에서 응답한 데이터를 받는다 
   /*
    *   1) 유저가 직접 보내는 데이터 => 이벤트 발생 
    *                           
    *   2) 서버에서 들어오는 데이터 => Thread => 출력 (Function)
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
	  setVisible(true);// 윈도우 보여라 
	  
	  setResizable(false);// 크기 조절 방지 => 화면 고정
	  setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
	  login.b1.addActionListener(this);
	  wr.tf.addActionListener(this);
	  wr.b6.addActionListener(this);// 나가기 
	  wr.b1.addActionListener(this);// 방만들기 
	  
	  mr.b1.addActionListener(this);// 실제 방만들기
	  mr.b2.addActionListener(this);
	  
	  wr.table1.addMouseListener(this);
	  
	  // 방안에서 채팅 등록 
	  gr.tf.addActionListener(this);
	  gr.b5.addActionListener(this);// 방나가기 버튼 
	  gr.b2.addActionListener(this);// 강퇴
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
				JOptionPane.showMessageDialog(this, "ID를 입력하세요");
				login.tf.requestFocus();
				return;
			}
			
			String pwd=String.valueOf(login.pf.getPassword());
			if(pwd.length()<1)
			{
				JOptionPane.showMessageDialog(this, "비밀번호를 입력하세요");
				login.pf.requestFocus();
				return;
			}
			
			// 처리
			MemberDAO dao=new MemberDAO();
			String result=dao.isLogin(id, pwd);
			if(result.equals("NOID"))
			{
				JOptionPane.showMessageDialog(this, "ID가 존재하지 않습니다");
				login.tf.setText("");
				login.pf.setText("");
				login.tf.requestFocus();
			}
			else if(result.equals("NOPWD"))
			{
				JOptionPane.showMessageDialog(this, "비밀번호가 틀립니다");
				login.pf.setText("");
				login.pf.requestFocus();
			}
			else
			{
				connection(result);
			}
		}
		else if(e.getSource()==wr.tf)// 대기실채팅
		{
			// 입력된 문자열 읽기
			String msg=wr.tf.getText();
			if(msg.length()<1)// 입력이 안된 경우
			{
				wr.tf.requestFocus();
				return;
			}
			
			// 서버로 전송 
			try
			{
				out.write((Function.WAITCHAT+"|"+msg+"\n").getBytes());
			}catch(Exception ex) {}
			
			wr.tf.setText("");
		}
		// 나가기(대기실)
		else if(e.getSource()==wr.b6)
		{
			try
			{
				out.write((Function.EXIT+"|\n").getBytes());
				/*
				 *   나가기 => 요청 
				 *           ===
				 *           처리 ==> 서버 
				 *           결과출력 => 클라이언트 
				 */
			}catch(Exception ex) {}
		}
		else if(e.getSource()==wr.b1) //방만들기 버튼 클릭 
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
			// 1. 방이름 
			String rn=mr.tf.getText();
			if(rn.length()<1)
			{
				JOptionPane.showMessageDialog(this, "방이름을 입력하세요");
				mr.tf.requestFocus();
				return;
			}
			
			for(int i=0;i<wr.model1.getRowCount();i++)
			{
				String roomName=wr.model1.getValueAt(i, 0).toString();
				if(rn.equals(roomName))
				{
					JOptionPane.showMessageDialog(this,
							"이미 존재하는 방입니다\n다시입력하세요");
					mr.tf.setText("");
					mr.tf.requestFocus();
					return;
				}
			}
			
			// 공개 비공개
			String rs="";//상태
			String rp=" ";//비밀번호 
			if(mr.rb1.isSelected())
			{
				rs="공개";
				rp=" ";
			}
			else
			{
				rs="비공개";
				rp=String.valueOf(mr.pf.getPassword());
			}
			
			// 인원
			int inwon=mr.box.getSelectedIndex()+2;
			
			// 서버로 전송 
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
		else if(e.getSource()==gr.b5)// 방나가기
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
			   System.out.println("게임종료!!");
			   System.out.println("정답:"+count);
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
			s=new Socket("localhost",3355);// 전화걸기
			// 송신/수신
			// 송신 
			out=s.getOutputStream();
			in=new BufferedReader(new InputStreamReader(s.getInputStream()));
			
			// 로그인 데이터 보내기 
			// 100|hong|홍길동|남자\n
			out.write((Function.LOGIN+"|"+userData+"\n").getBytes());
		}catch(Exception ex) {}
		// 서버로부터 데이터를 읽기 시작 
		new Thread(this).start();
	}
	
	// 서버로부터 데이터를 수신하는 기능 
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try
		{
			while(true)
			{
				// 100|hong|홍길동|남자|대기실\n
				String msg=in.readLine();
				System.out.println("Server=>"+msg);
				StringTokenizer st=new StringTokenizer(msg,"|");
				int protocol=Integer.parseInt(st.nextToken());
				switch(protocol)
				{
				  case Function.LOGIN:
				  {
					  String[] data= {
						 st.nextToken(), //아이디
						 st.nextToken(), // 이름
						 st.nextToken(), // 성별
						 st.nextToken()  // 위치
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
				  case Function.EXIT: // 남아 있는 사람 
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
				  case Function.MYEXIT: // 실제 나가는 사람 처리
				  {
					  dispose();// 메모리 회수
					  System.exit(0);// 프로그램 종료
				  }
				  case Function.MAKEROOM:
				  {
					 String[] data= {
						st.nextToken(), // 방이름
						st.nextToken(), // 상태(공개/비공개)
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
					  if(sex.equals("남자"))
					  {
						  temp="m"+avata; // m1.png,m2.png...
					  }
					  else
					  {
						  temp="w"+avata; // w1.png,w2.png
					  }
					  
					  // 화면 이동 
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
					  if(sex.equals("남자"))
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
					  
					  // 테이블에서 방을 찾는다 
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
					  // 접속자 목록 변경 
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
					  // 초기화 
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
					  JOptionPane.showMessageDialog(this, rn+"방에서 강퇴되었습니다");
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
					  System.out.println("정답:"+count);
					  JOptionPane.showMessageDialog(this, "게임이 종료되었습니다");
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
			if(e.getClickCount()==2)// 더블 클릭 
			{
				// 방이름 
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
					// 방에 들어갈 수 없다
					JOptionPane.showMessageDialog(this, 
							"이미 방인원이 찼습니다\n다른 방을 선택하세요");
				}
				else
				{
					// 방에 들어갈 수 있다
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








