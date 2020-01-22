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
    	if(no==0)
    	{
    		back=Toolkit.getDefaultToolkit().getImage("c:\\image\\"+no+".jpg");
    	}
    	else
    	{
    	  back=Toolkit.getDefaultToolkit().getImage("c:\\image\\"+no+".png");
          
    	}
    }
	@Override
	public void paint(Graphics g) {
		g.drawImage(back,0,0,getWidth(),getHeight(),this);
		//g.drawImage(img, dx1, dy1, dx2, dy2, sx1, sy1, sx2, sy2, observer)
	}
    
}
