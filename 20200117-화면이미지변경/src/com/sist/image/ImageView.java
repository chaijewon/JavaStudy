package com.sist.image;
import java.awt.*;
import javax.swing.*;
public class ImageView extends JPanel{
    Image back;
    // back=> �޸� �Ҵ� (�ʱ�ȭ)
    public ImageView()
    {
    	 back=Toolkit.getDefaultToolkit().getImage("c:\\image\\background.jpg");
    }
    public void setImage(int no)
    {
    	if(no==0)
    	{
    		back=Toolkit.getDefaultToolkit().getImage("c:\\image\\0.jpg");
    	}
    	else
    	{
    		back=Toolkit.getDefaultToolkit().getImage("c:\\image\\movie"+no+".jpg");
    	}
    }
	@Override
	public void paint(Graphics g) {
		g.drawImage(back,0,0,getWidth(),getHeight(),this);
	}
    
}
