package tp5_2;

import java.awt.*;
import java.util.Vector;

class Couleur extends Panel  {
	private static final long serialVersionUID = -4420597815394934848L;
	public Vector<Checkbox> couleurs ;
	private Color SelectedColor;
	private CheckboxGroup grpForms;
	
	public Couleur(Planch p) {
		
		Vector<Color> clc= allColors();
		clc.add(Color.WHITE);
		int colorsNumber=clc.size();
		this.setLayout(new GridLayout(1,colorsNumber));
		
		couleurs=new Vector<>();
		SelectedColor=Color.WHITE;
		
		grpForms=new CheckboxGroup();
		for(int i=0;i<colorsNumber;i++) {
			Checkbox cc;
			cc=new Checkbox("",grpForms,false);
			cc.setBackground(clc.elementAt(i));
			cc.setMaximumSize(new Dimension(10,10));
			couleurs.add(cc);
			
		}
		for(Checkbox c : couleurs)
		{
			this.add(c);
			c.addItemListener(p);
		
		}
		 
	}
	private Vector<Color> allColors()
	{
		var clc=new Vector<Color>();
		clc.add(Color.MAGENTA);
		clc.add(Color.BLUE);
		clc.add(Color.CYAN);
		clc.add(Color.DARK_GRAY);
		clc.add(Color.GRAY);
		clc.add(Color.DARK_GRAY);
		clc.add(Color.GREEN);
		clc.add(Color.YELLOW);
		clc.add(Color.ORANGE);
		clc.add(Color.RED);
		clc.add(Color.PINK);
		return clc;
	}
	public Color getSelectedColor() {
		return SelectedColor;
	}
	
	
	
}


