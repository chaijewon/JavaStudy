package com.sist.image;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class MainForm extends JFrame implements ActionListener{
    JButton startBtn,prevBtn,nextBtn;
    ImageView imagePanel;
    int no=1;
    public MainForm()
    {
    	// �޸� �Ҵ� 
    	startBtn=new JButton("����");
    	prevBtn=new JButton("����");
    	nextBtn=new JButton("����");
    	imagePanel=new ImageView();
    	// Ŭ������ new�� �̿��ؼ� �������� ���� 
    	// new����� �� ���� Ŭ���� (�̿ϼ��� Ŭ���� => �߻�Ŭ����,�������̽�)
    	// ��ġ 
    	JPanel p=new JPanel();
    	p.add(startBtn);
    	p.add(prevBtn);
    	p.add(nextBtn);
    	
    	// ������ �ø��� 
    	add("Center",imagePanel);
    	add("South",p);
    	
    	// ũ�� ���� 
    	setSize(640, 480); // setBounds(x,y,width,height)
    	// x=0,y=0
    	// �����츦 �����ش� 
    	setVisible(true);
    	
    	setDefaultCloseOperation(EXIT_ON_CLOSE);
    	
    	// System.exit(0)
    	
    	// �̺�Ʈ ��� 
    	startBtn.addActionListener(this);
    	prevBtn.addActionListener(this);
    	nextBtn.addActionListener(this);
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        new MainForm();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==startBtn)
		{
			imagePanel.setImage(0);
			imagePanel.repaint();
			
			new ImageThread().start();
		}
		else if(e.getSource()==prevBtn)
		{
			no--;
			if(no<1)
				no=1;
			imagePanel.setImage(no);
			imagePanel.repaint();
		}
		else if(e.getSource()==nextBtn)
		{
			no++;
			if(no>5)
				no=5;
			imagePanel.setImage(no);
			imagePanel.repaint();
		}
	}
	
	class ImageThread extends Thread
	{
		public void run()
		{
			while(true)
			{
				try
				{
					no++;
					if(no>5)
						no=1;
					imagePanel.setImage(no);
					imagePanel.repaint();
					Thread.sleep(1000);
				}catch(Exception ex) {}
			}
		}
	}

}






