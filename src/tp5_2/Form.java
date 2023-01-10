package tp5_2;

import java.awt.*;

class Form extends Panel{
	private static final long serialVersionUID = 3732108577945891670L;
	public Choice choix;
	private CheckboxGroup grpForms;
	public Form()
	{
		 choix =new Choice();
		 choix.add("Rectangle");
		 choix.add("Ellipse");
		 grpForms=new CheckboxGroup();		
		//this.setBackground(Color.WHITE);
		this.add(choix);
		
	}
}