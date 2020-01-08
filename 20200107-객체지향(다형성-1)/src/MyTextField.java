import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
/*
 *   interface ==> implements 인터페이스명
 *   =========
 *     다중 상속이 가능 
 *     
 *     interface A
 *     interface B
 *     class C implements A,B,...
 */
public class MyTextField extends JFrame implements ActionListener{
    JTextField tf=new JTextField();
    JTextArea ta=new JTextArea();
    public MyTextField() {
    	
    	ta.setEditable(false);
    	JScrollPane js=new JScrollPane(ta);
    	add("Center",js);
    	add("South",tf);
    	setSize(350, 450);
    	setVisible(true);
    	
    	// 이벤트 등록 
    	tf.addActionListener(this);// 엔터시에 이벤트 발생 
    	setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        // 생성자 
		new MyTextField();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==tf) // 엔터를 친 textfield가 뭐냐?
		{
			ta.setText(tf.getText()+"\n");
			// append(문자 결합)   , setText(새로운 문자만 출력)
			// tf.getText() => 입력된 문자를 읽어온다 
		}
	}

}
