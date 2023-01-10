package tp5_2;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuSortie extends Menu implements ActionListener{
	
	private static final long serialVersionUID = 8161748977119008212L;
	private MenuItem sortir;
	private MenuBar menu_bar;
	public MenuSortie(String titre){
		super(titre);
		sortir=new MenuItem("Fin pour declencher");
		menu_bar=new MenuBar();
		menu_bar.add(this);
		this.add(sortir);
		sortir.addActionListener(this);
		
	}
	public MenuBar getMenu_bar() {
		return menu_bar;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==sortir) System.exit(0);
		
	}
}
