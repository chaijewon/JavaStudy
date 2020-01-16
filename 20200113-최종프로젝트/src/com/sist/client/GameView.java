package com.sist.client;
import java.awt.*;
import javax.swing.*;
public class GameView extends JPanel{
	Image back;
    public GameView()
    {
    	back=Toolkit.getDefaultToolkit().getImage("c:\\image\\main.jpg");
    }
    public void setImage(int no)
    {
    	back=Toolkit.getDefaultToolkit().getImage("c:\\image\\"+no+".png");
    }
	@Override
	public void paint(Graphics g) {
		g.drawImage(back,0,0,getWidth(),getHeight(),this);
	}
    
}
