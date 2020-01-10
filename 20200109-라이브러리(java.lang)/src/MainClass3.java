/*
 *   1) extends Object
 *   2) ������ 
 *   3) �޼ҵ� void => return
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
    	la1=new JLabel("����");
    	box.addItem("ȫ�浿");
    	box.addItem("��û��");
    	box.addItem("�ڹ���");
    	la2=new JLabel("");
    	la2.setFont(new Font("����ü",Font.BOLD,35));
    	
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





