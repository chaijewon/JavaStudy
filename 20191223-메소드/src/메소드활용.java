import java.awt.FlowLayout;

import javax.swing.*;
// JFrame (윈도우) ==> 
public class 메소드활용 extends JFrame{
    JLabel la=new JLabel("나이");
    JTextField tf=new JTextField(10);
       메소드활용(){
         setLayout(new FlowLayout());
         add(la);
         add(tf);
         tf.setText(String.valueOf(100));
         setSize(350, 80);
         setVisible(true);
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        new 메소드활용();
	}

}
