import java.awt.*;
import javax.swing.*;
public class MainClass3 {
    public MainClass3() {
    	JFrame f=new JFrame();
    	Movie movie=new Movie();
    	f.add("Center",movie.p);
    	f.setSize(350, 350);
    	f.setVisible(true);
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        new MainClass3();
	}

}
