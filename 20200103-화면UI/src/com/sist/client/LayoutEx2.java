package com.sist.client;
import java.awt.*;
import javax.swing.*;
/*
 *     
 */
public class LayoutEx2 {
    JFrame frame=new JFrame();
    public LayoutEx2() {
    	//frame.setLayout(new FlowLayout());
    	frame.setLayout(new GridLayout(3,2,10,10));
    	JButton b1=new JButton("����");
    	JButton b2=new JButton("����");
    	JButton b3=new JButton("����");
    	JButton b4=new JButton("����");
    	JButton b5=new JButton("����");
    	JButton b6=new JButton("����");
    	
    	frame.add(b1);
    	frame.add(b2);
    	frame.add(b3);
    	frame.add(b4);
    	frame.add(b5);
    	frame.add(b6);
    	
    	frame.setSize(400, 300);
    	frame.setVisible(true);
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        new LayoutEx2();
	}

}
