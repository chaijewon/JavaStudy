import java.awt.Graphics;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/*
 *    JFrame
 *    JPanel
 *    JWindow
 *    JDialog
 */
import java.awt.*;// window와 관련된 클래스 
public class Login extends JPanel{
    Image back;
    // Login login=new Login()
    JLabel la1,la2;
    JTextField tf;
    JPasswordField pf;
    JButton b1,b2;
    Login(){
    	String[] bname= {"수락","거절"};
    	JOptionPane.showOptionDialog(this, "초대하기","초대하기",
    			JOptionPane.YES_NO_OPTION,
    			JOptionPane.QUESTION_MESSAGE,null,
    			bname,bname[0]);
    	setLayout(null);
    	back=Toolkit.getDefaultToolkit().getImage("c:\\image\\back.png");
        la1=new JLabel("ID",JLabel.RIGHT);
        //la1.setForeground(Color.white);
        la2=new JLabel("Password",JLabel.RIGHT);
        //la2.setForeground(Color.white);
        
        tf=new JTextField();
        pf=new JPasswordField();
        
        b1=new JButton("로그인");
        b2=new JButton("취소");
        
        // 배치 
        //la1.setBounds(381,330,60,30);
        tf.setBounds(444, 286, 190, 30);
       
        //la2.setBounds(381,365,80,30);
        pf.setBounds(444, 348, 190, 30);
        
        JPanel p=new JPanel();
        p.add(b1);
        p.add(b2);
        p.setBounds(390, 405, 235, 35);
        p.setOpaque(false);
        //add(la1);
        add(tf);
        //add(la2);
        add(pf);
        add(p);
       
    }
	@Override
	public void paintComponent(Graphics g) {
		g.drawImage(back, 0, 0, getWidth(), getHeight(), this);
	}

  
}






