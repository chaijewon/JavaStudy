import java.awt.*;
import javax.swing.*;
public class Movie {
	public JPanel p;
    JLabel la;
    JTextField f;
    String poster;
    String name;
    public Movie() {
    	
    	poster="c:\\image\\poster.jpg";
    	name="Ãµ¹®: ÇÏ´Ã¿¡ ¹¯´Â´Ù (2018)";
    	la=new JLabel(new ImageIcon(poster));
    	f=new JTextField();
    	f.setText(name);
    	p=new JPanel();
    	p.setLayout(new BorderLayout());
    	p.add("Center",la);
    	p.add("South",f);
    }
}
