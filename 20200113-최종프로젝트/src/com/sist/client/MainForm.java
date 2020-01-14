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
public class MainForm extends JFrame implements ActionListener,Runnable{
   Login login=new Login();
   WaitRoom wr=new WaitRoom();
   //GameRoom gr=new GameRoom();
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
   MainForm() {
	  setLayout(card);
	  //add("GAME",gr);
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
	}
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
				}
				
			}
		}catch(Exception ex) {}
	}
}








