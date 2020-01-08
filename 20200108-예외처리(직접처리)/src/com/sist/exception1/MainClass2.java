package com.sist.exception1;
/*
 *    형식)
 *         try
 *         {
 *             평상시 소스 내용(정상 실행이 가능한 소스)
 *             
 *             try를 수행하면서 
 *             에러가 발생하면 
 *             해당 catch를 찾아서 복구하고 
 *             catch밑에 문장들을 수행 
 *             
 *             1
 *             2
 *             3
 *             4==>error => 4,5수행하지 않고 => catch를 수행한다
 *             5
 *             
 *         }catch(예외처리클래스)
 *         {
 *             예외를 처리 (복구) => 에러가 출력한 부분을 제외하고 나머지 수행 
 *         }
 *         finally
 *         {
 *             try나 catch나 상관없이 무조건 수행하는 문장 
 *             = 파일 닫기
 *             = 서버 닫기
 *         }
 *         
 *         
 *         목적) 에러를 찾아서 수정할 목적(프로그래머)
 *              => 에러메세지 확인 
 *                 =======
 *                 getMessage() => 에러메세지만 전송
 *                    => 10/0  ==> / by zero
 *                 printStackTrace() => 실행한 파일을 읽어서 에러난 라인수를 제공
 *              프로그램이 정상상태를 유지할 목적(유저)
 *         사용법)
 *                전체를 처리 => 부분적으로 처리 기능 
 */
// 숫자 야구 게임 => 윈도우
import java.awt.*;
import javax.swing.*;

import jdk.nashorn.internal.scripts.JO;

import java.awt.event.*;
public class MainClass2 extends JFrame implements ActionListener{
    JTextArea ta;
    JTextField tf;
    JButton b1,b2;
    
    // 게임에 핑료한 데이터 
    int[] com=new int[3];
    int[] user=new int[3];
    int s,b;
    public MainClass2() {
    	ta=new JTextArea();
    	ta.setEditable(false);
    	
    	//ta.setEnabled(false);
    	//ta.setText("sfsflslfsljflsjf");
    	JScrollPane js=new JScrollPane(ta);
    	tf=new JTextField(13);
    	tf.setEnabled(false);
    	b1=new JButton("시작");
    	b2=new JButton("종료");
    	
    	JPanel p=new JPanel();
    	p.add(tf);p.add(b1);p.add(b2);
    	
    	// 배치
    	add("Center",js);
    	add("South",p);
    	
    	setSize(450, 500);
    	setVisible(true);
    	setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);// X
    	
    	b1.addActionListener(this);
    	b2.addActionListener(this);
    	tf.addActionListener(this);
    	
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        new MainClass2();
	}
	// 난수를 발생하는 메소드
	public void getRand() {
		int su=0; // 난수 저장 
		boolean bCheck=false; // 중복 체크하는 변수 
		for(int i=0;i<3;i++)
		{
			// 난수 => 중복이 안된 경우에만 => com[]에 저장 
			bCheck=true;
			while(bCheck)
			{
				// 난수 발생 
				su=(int)(Math.random()*9)+1;
				bCheck=false;
				// 저장된 (com[]) 값 , 난수가 발생된 값 (su) 중복여부 확인
				// 중복된 경우에는 bCheck  => true => while문을 다시 수행
				for(int j=0;j<i;j++)
				{
					if(com[j]==su)
					{
						bCheck=true;
						break;
					}
				}
			}
			com[i]=su;
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		// 버튼 클릭시 처리
		if(e.getSource()==b1)
		{
		     //난수 발생 
			 getRand();
			 JOptionPane.showMessageDialog(this, "게임을 시작합니다");
			 tf.setEnabled(true);
			 b1.setEnabled(false);
			 tf.requestFocus();
		}
		else if(e.getSource()==b2)
		{
			dispose();
			System.exit(0);// 프로그램 종료
		}
		else if(e.getSource()==tf)
		{
			String input=tf.getText();
			input=input.trim();
			if(input.length()<1)
			{
				JOptionPane.showMessageDialog(this, "세자리 정수를 입력하세요");
				// javascript => alert()
				tf.requestFocus();
				return;
			}
			
			int no=0;
			try
			{
				// 정수 변환 
			   	no=Integer.parseInt(input);
			}catch(Exception ex) 
			{
				JOptionPane.showMessageDialog(this, "정수만 입력이 가능합니다");
				tf.setText("");
				tf.requestFocus();
				return;
			}
			
			// 잘못된 입력 
			if(no<100 || no>999)
			{
				JOptionPane.showMessageDialog(this, "세자리정수만  입력이 가능합니다");
				tf.setText("");
				tf.requestFocus();
				return;
			}
			
			// user[]에 저장 
			user[0]=no/100;
			user[1]=(no%100)/10;
			user[2]=no%10;
			
			if(user[0]==user[1] || user[1]==user[2] ||user[0]==user[2])
			{
				JOptionPane.showMessageDialog(this, "중복된 수는 사용할 수 없습니다");
				tf.setText("");
				tf.requestFocus();
				return;
			}
			
			if(user[0]==0 || user[1]==0 || user[2]==0)
			{
				JOptionPane.showMessageDialog(this, "0은 사용 할 수 없습니다");
				tf.setText("");
				tf.requestFocus();
				return;
			}
			// 비교
			s=0;
			b=0;
			for(int i=0;i<3;i++)
			{
				for(int j=0;j<3;j++)
				{
					if(com[i]==user[j])// 같은 수저 있는지 확인
					{
						if(i==j)
							s++;
						else
							b++;
					}
				}
			}
			// 힌트 
			String hint="Input Number:"+no+",Result:"+s+"S-"+b+"B\n";
			ta.append(hint);
			
			// 종료여부 
			if(s==3)
			{
				int res=JOptionPane.showConfirmDialog(this,"종료할까요?","종료",
						JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
				
				if(res==JOptionPane.YES_OPTION)
				{
					dispose();
					System.exit(0);
				}
				else
				{
					ta.setText("");
					tf.setText("");
					tf.setEnabled(false);
					b1.setEnabled(true);
				}
			}
			tf.setText("");
			tf.requestFocus();
		}
	}

}










