package tp5_2;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;

class Dessin extends Canvas  {
	private static final long serialVersionUID = -6146356665446422140L;
	Point pt1,pt2;
	private Color crt;
	boolean shapeElip;
	boolean remplir;
	public Dessin(Color c) {
		this.setBackground(Color.BLACK);
		pt1=new Point();
		pt2=new Point();
		crt=c;
	}
	public void setColor(Color c){	crt=c;}
	public void paint(Graphics g) {
		int width,height;
	
		if(pt2.x>this.getWidth()-1) pt2.x=this.getWidth()-1;
		if(pt2.y>this.getHeight()-1) pt2.y=this.getHeight()-1;
		width=Math.abs((pt1.x-pt2.x));
		height= Math.abs((pt1.y-pt2.y));
		
		g.setColor(crt);
		if(shapeElip==true) {
			if(remplir) g.fillOval(pt1.x, pt1.y,width ,height);
			else  g.drawOval(pt1.x, pt1.y,width ,height);
		}else {
			if(remplir)g.fillRect(pt1.x, pt1.y, width ,height);
			else g.drawRect(pt1.x, pt1.y, width ,height);

		}
	}
	public Dimension getMinimumSize() {
		return new Dimension(200, 100);
	}
	public Dimension getPreferredSize() {return getMinimumSize();}
	
}