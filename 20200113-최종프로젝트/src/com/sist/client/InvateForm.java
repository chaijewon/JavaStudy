package com.sist.client;
import java.awt.*;
import javax.swing.*;
import javax.swing.table.*;
public class InvateForm extends JFrame{
    JLabel la=new JLabel("�ʴ��� ���",JLabel.CENTER);
    JTable table;
    DefaultTableModel model;
    JButton b;
    public InvateForm()
    {
    	la.setFont(new Font("�ü�ü",Font.BOLD,30));
    	b=new JButton("Ȯ��");
    	JPanel p=new JPanel();
    	p.add(b);
    	
    	String[] col={"ID","�̸�","����"};
    	String[][] row=new String[0][3];
    	model=new DefaultTableModel(row,col) {
    		public boolean isCellEditable(int r,int c)
    		{
    			return false;
    		}
    	};
    	
    	table=new JTable(model);
    	JScrollPane js=new JScrollPane(table);
    	
    	add("North",la);
    	add("Center",js);
    	add("South",p);
    	
    	setSize(350, 350);
    	//setVisible(true);
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        new InvateForm();
	}

}
