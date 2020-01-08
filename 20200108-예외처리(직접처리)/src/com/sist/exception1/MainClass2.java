package com.sist.exception1;
/*
 *    ����)
 *         try
 *         {
 *             ���� �ҽ� ����(���� ������ ������ �ҽ�)
 *             
 *             try�� �����ϸ鼭 
 *             ������ �߻��ϸ� 
 *             �ش� catch�� ã�Ƽ� �����ϰ� 
 *             catch�ؿ� ������� ���� 
 *             
 *             1
 *             2
 *             3
 *             4==>error => 4,5�������� �ʰ� => catch�� �����Ѵ�
 *             5
 *             
 *         }catch(����ó��Ŭ����)
 *         {
 *             ���ܸ� ó�� (����) => ������ ����� �κ��� �����ϰ� ������ ���� 
 *         }
 *         finally
 *         {
 *             try�� catch�� ������� ������ �����ϴ� ���� 
 *             = ���� �ݱ�
 *             = ���� �ݱ�
 *         }
 *         
 *         
 *         ����) ������ ã�Ƽ� ������ ����(���α׷���)
 *              => �����޼��� Ȯ�� 
 *                 =======
 *                 getMessage() => �����޼����� ����
 *                    => 10/0  ==> / by zero
 *                 printStackTrace() => ������ ������ �о ������ ���μ��� ����
 *              ���α׷��� ������¸� ������ ����(����)
 *         ����)
 *                ��ü�� ó�� => �κ������� ó�� ��� 
 */
// ���� �߱� ���� => ������
import java.awt.*;
import javax.swing.*;

import jdk.nashorn.internal.scripts.JO;

import java.awt.event.*;
public class MainClass2 extends JFrame implements ActionListener{
    JTextArea ta;
    JTextField tf;
    JButton b1,b2;
    
    // ���ӿ� �η��� ������ 
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
    	b1=new JButton("����");
    	b2=new JButton("����");
    	
    	JPanel p=new JPanel();
    	p.add(tf);p.add(b1);p.add(b2);
    	
    	// ��ġ
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
	// ������ �߻��ϴ� �޼ҵ�
	public void getRand() {
		int su=0; // ���� ���� 
		boolean bCheck=false; // �ߺ� üũ�ϴ� ���� 
		for(int i=0;i<3;i++)
		{
			// ���� => �ߺ��� �ȵ� ��쿡�� => com[]�� ���� 
			bCheck=true;
			while(bCheck)
			{
				// ���� �߻� 
				su=(int)(Math.random()*9)+1;
				bCheck=false;
				// ����� (com[]) �� , ������ �߻��� �� (su) �ߺ����� Ȯ��
				// �ߺ��� ��쿡�� bCheck  => true => while���� �ٽ� ����
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
		// ��ư Ŭ���� ó��
		if(e.getSource()==b1)
		{
		     //���� �߻� 
			 getRand();
			 JOptionPane.showMessageDialog(this, "������ �����մϴ�");
			 tf.setEnabled(true);
			 b1.setEnabled(false);
			 tf.requestFocus();
		}
		else if(e.getSource()==b2)
		{
			dispose();
			System.exit(0);// ���α׷� ����
		}
		else if(e.getSource()==tf)
		{
			String input=tf.getText();
			input=input.trim();
			if(input.length()<1)
			{
				JOptionPane.showMessageDialog(this, "���ڸ� ������ �Է��ϼ���");
				// javascript => alert()
				tf.requestFocus();
				return;
			}
			
			int no=0;
			try
			{
				// ���� ��ȯ 
			   	no=Integer.parseInt(input);
			}catch(Exception ex) 
			{
				JOptionPane.showMessageDialog(this, "������ �Է��� �����մϴ�");
				tf.setText("");
				tf.requestFocus();
				return;
			}
			
			// �߸��� �Է� 
			if(no<100 || no>999)
			{
				JOptionPane.showMessageDialog(this, "���ڸ�������  �Է��� �����մϴ�");
				tf.setText("");
				tf.requestFocus();
				return;
			}
			
			// user[]�� ���� 
			user[0]=no/100;
			user[1]=(no%100)/10;
			user[2]=no%10;
			
			if(user[0]==user[1] || user[1]==user[2] ||user[0]==user[2])
			{
				JOptionPane.showMessageDialog(this, "�ߺ��� ���� ����� �� �����ϴ�");
				tf.setText("");
				tf.requestFocus();
				return;
			}
			
			if(user[0]==0 || user[1]==0 || user[2]==0)
			{
				JOptionPane.showMessageDialog(this, "0�� ��� �� �� �����ϴ�");
				tf.setText("");
				tf.requestFocus();
				return;
			}
			// ��
			s=0;
			b=0;
			for(int i=0;i<3;i++)
			{
				for(int j=0;j<3;j++)
				{
					if(com[i]==user[j])// ���� ���� �ִ��� Ȯ��
					{
						if(i==j)
							s++;
						else
							b++;
					}
				}
			}
			// ��Ʈ 
			String hint="Input Number:"+no+",Result:"+s+"S-"+b+"B\n";
			ta.append(hint);
			
			// ���Ῡ�� 
			if(s==3)
			{
				int res=JOptionPane.showConfirmDialog(this,"�����ұ��?","����",
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










