import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class MainClass6 extends JFrame implements ActionListener,MouseListener{
    JButton b=new JButton("Click");
    public MainClass6() {
    	// ��ġ
    	add("North",b);
    	setSize(480, 300);
    	setVisible(true);
    	//b.addActionListener(this);
    	b.addMouseListener(this);
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        new MainClass6();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==b)
		{
			System.out.println("B��ư Ŭ��!!");
		}
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==b)
		{
			System.out.println("���콺 ��ư Ŭ��!!");
		}
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
