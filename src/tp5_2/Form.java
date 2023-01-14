package tp5_2;

import java.awt.*;

class Form extends Panel{
	private static final long serialVersionUID = 3732108577945891670L;
	public Choice choix;
	public Form(Planch P)
	{
		 choix =new Choice();
		 choix.add("Rectangle");
		 choix.add("Ellipse");
		 this.add(choix);
		 choix.addItemListener(P);

		
	}
}