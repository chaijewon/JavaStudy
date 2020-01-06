package server;

import java.awt.Color;
import java.io.Serializable;

public class PaintProtocol implements Serializable{
	public static final long serialversionUid = 2L;
	private int x, y, wh, cmd;
	private Color color;
	public PaintProtocol() {}
	public PaintProtocol(int x, int y, int wh, int cmd, Color color) {
		this.x = x;
		this.y = y;
		this.wh = wh;
		this.cmd = cmd;
		this.color = color;
	}
	public int getX() {		return x;	}
	public void setX(int x) {		this.x = x;	}
	public int getY() {		return y;	}
	public void setY(int y) {		this.y = y;	}
	public int getWh() {		return wh;	}
	public void setWh(int wh) {		this.wh = wh;	}
	public int getCmd() {		return cmd;	}
	public void setCmd(int cmd) {		this.cmd = cmd;	}
	public Color getColor() {		return color;	}
	public void setColor(Color color) {		this.color = color;	}
	
}
