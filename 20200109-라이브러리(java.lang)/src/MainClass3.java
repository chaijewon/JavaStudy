/*
 *   1) extends Object
 *   2) 생성자 
 *   3) 메소드 void => return
 *   4) import java.lang
 *   5) interface 
 *      void disp();  ==> public abstract void disp();
 *      int a=10      ==> public static final int a=10
 *      
 *      
 *      setBackground(new Color(0,0,0,1))
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class MainClass3 extends JFrame implements ItemListener{
	JLabel la1,la2;
	JComboBox box=new JComboBox();
    public MainClass3() {
    	la1=new JLabel("선택");
    	box.addItem("홍길동");
    	box.addItem("심청이");
    	box.addItem("박문수");
    	la2=new JLabel("");
    	la2.setFont(new Font("굴림체",Font.BOLD,35));
    	
    	JPanel p=new JPanel();
    	p.add(la1);
    	p.add(box);
    	
    	add("North",p);
    	add("Center",la2);
    	setSize(450, 350);
    	setVisible(true);
    	setDefaultCloseOperation(EXIT_ON_CLOSE);
    	
    	box.addItemListener(this);
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        new MainClass3();
	}
	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==box)
		{
			String name=box.getSelectedItem().toString();
			la2.setText(name);
		}
	}

}





