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
	Dimension dim;
	public Dessin(Color c,Planch P) {
		this.setBackground(Color.BLACK);
		pt1=new Point();
		pt2=new Point();
		crt=c;
		dim=new Dimension();
		
		this.addMouseListener(P);
		this.addMouseMotionListener(P);
	}
	public void setColor(Color c){	crt=c;}
	
	void limiteDessin()
	{
		if(this.pt2.x>this.getWidth()-1) this.pt2.x=this.getWidth()-1;
		if(this.pt2.y>this.getHeight()-1) this.pt2.y=this.getHeight()-1;
		if(this.pt1.x<=3) this.pt1.x=3;
		if(this.pt1.y<=3) this.pt1.y=3;
		this.dim.width=Math.abs((this.pt1.x-this.pt2.x));
		this.dim.height= Math.abs((this.pt1.y-this.pt2.y));
	}
	public void paint(Graphics g) {
	
		
		
		g.setColor(crt);
		
		limiteDessin();
		if(shapeElip==true) {
			if(remplir) g.fillOval(pt1.x, pt1.y,dim.width ,dim.height);
			else  g.drawOval(pt1.x, pt1.y,dim.width ,dim.height);
		}else {
			if(remplir)g.fillRect(pt1.x, pt1.y, dim.width ,dim.height);
			else g.drawRect(pt1.x, pt1.y, dim.width ,dim.height);

		}
	}
	public Dimension getMinimumSize() {
		return new Dimension(200, 100);
	}
	public Dimension getPreferredSize() {return getMinimumSize();}
	
}