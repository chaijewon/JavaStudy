package com.sist.client;
/*
 *    ��ġ 
 *     = BorderLayout : JFrame , JDialog , JWindow
 *        5���� ��ġ 
 *        ========
 *          East West Center North South
 *     = FlowLayout
 *     = GridLayout
 *     = ����� ���� 
 */
import java.awt.*; // Layout , Event..
import javax.swing.*;
/*
 *    class JFrame
 *    {
 *        private String layout="BorderLayout";
 *        public void setLayout(String s)
 *        {
 *            layout=s;
 *        }
 *    }
 */
public class LayoutEx {
    JFrame frame=new JFrame("BorderLayout");
  
    public LayoutEx()
    {
    	JButton[] btn=new JButton[5];
    	String[] layout={"East","West","Center","North","South"};
		/*
		 * for(int i=0;i<5;i++) { btn[i]=new JButton(layout[i]);
		 * frame.add(layout[i],btn[i]); }
		 */
    	btn[0]=new JButton("Center");
    	frame.add("North",btn[0]);
    	btn[1]=new JButton("South");
    	frame.add("South",btn[1]);
    	frame.setSize(350, 350);
    	frame.setVisible(true);
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        LayoutEx ex=new LayoutEx();  
	}

}






