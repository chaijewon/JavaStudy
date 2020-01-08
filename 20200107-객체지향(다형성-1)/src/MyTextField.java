import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
/*
 *   interface ==> implements �������̽���
 *   =========
 *     ���� ����� ���� 
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
    	
    	// �̺�Ʈ ��� 
    	tf.addActionListener(this);// ���ͽÿ� �̺�Ʈ �߻� 
    	setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        // ������ 
		new MyTextField();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==tf) // ���͸� ģ textfield�� ����?
		{
			ta.setText(tf.getText()+"\n");
			// append(���� ����)   , setText(���ο� ���ڸ� ���)
			// tf.getText() => �Էµ� ���ڸ� �о�´� 
		}
	}

}
