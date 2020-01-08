import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class MyButton extends JFrame implements ActionListener{
    JButton b1,b2;
    JLabel la;
    int index=1;
    public MyButton() {
    	b1=new JButton("이전");
    	b2=new JButton("다음");
    	la=new JLabel(new ImageIcon("c:\\image\\movie1.jpg"));
    	JPanel p=new JPanel();
    	p.add(b1);
    	p.add(b2);
    	
    	add("Center",la);
    	add("South",p);
    	
    	setSize(600, 550);
    	setVisible(true);
    	
    	setDefaultCloseOperation(EXIT_ON_CLOSE);
    	
    	b1.addActionListener(this);
    	b2.addActionListener(this);
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        new MyButton();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==b1)
		{
			index--;
			if(index<1)
				index=5;
			
			la.setIcon(new ImageIcon("c:\\image\\movie"+index+".jpg"));
		}
		else if(e.getSource()==b2)
		{
			index++;
			if(index>5)
				index=1;
			
			la.setIcon(new ImageIcon("c:\\image\\movie"+index+".jpg"));
		}
	}

}
