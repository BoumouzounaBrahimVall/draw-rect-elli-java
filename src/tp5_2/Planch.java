package tp5_2;

import java.awt.*;

import java.awt.event.*;

import javax.swing.ImageIcon;



public class Planch extends WindowAdapter implements MouseListener, ItemListener,MouseMotionListener  {
	private Frame fenetre;
	private MenuSortie mFichier;
	private Couleur clrs;
	private Dessin drawingSpace;
	private Panel outils;
	private Checkbox fill;
	private Form shapes;
	public Planch()
	{
		// colors 
		clrs=new Couleur(this); 
	
		// espace de dessin
		drawingSpace= new Dessin(clrs.getSelectedColor(),this);
		
		// menu de sortie
		mFichier=new MenuSortie("Fichier");
		// bar d'outils en bas
		outils=new Panel();
		outils.setBackground(Color.lightGray);
		
		shapes=new Form(this);
		outils.add(shapes);

		outils.add(clrs);
		

		fill=new Checkbox("Remplire");
		fill.setBackground(Color.WHITE);
		outils.add(fill);
		fill.addItemListener(this);
		
		// creation du fenetre principale
		fenetre=new Frame();
		fenetre.setTitle("Zone de Dessing");
		//affecter la bar menu a la fenetre
		fenetre.setMenuBar(mFichier.getMenu_bar());
		// ajouter l'espace de dessin et la bar d'outils
		fenetre.add(BorderLayout.CENTER,drawingSpace);
		fenetre.add(BorderLayout.PAGE_END,outils);
		//afficher la fenetre
		fenetre.setSize(500,400);
		fenetre.setVisible(true);
		fenetre.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e){System.exit(0);}
		});
		
	}
	
	@Override
	public void itemStateChanged(ItemEvent e) {
		if ((e.getSource()).getClass().equals(Choice.class)) {
			Choice ch = (Choice) e.getSource();
			if (ch.getSelectedItem().equals("Rectangle")) {
				drawingSpace.shapeElip = false;
				System.out.println(((Choice) e.getSource()).getSelectedItem());
			} else
				drawingSpace.shapeElip = true;

			return;
		} else {
			Checkbox c = (Checkbox) e.getSource();
			if (((Checkbox) e.getSource()).getLabel().equals(fill.getLabel())) {
				drawingSpace.remplir = (drawingSpace.remplir ? false : true);
			} else
				drawingSpace.setColor(c.getBackground());
		}
	}
	
	public void mouseClicked(MouseEvent e) {}
	public void mousePressed(MouseEvent e) {
		drawingSpace.pt1 = e.getPoint();
		drawingSpace.pt2=e.getPoint();
	}
	public void mouseReleased(MouseEvent e) {}
	public void mouseEntered(MouseEvent e) {}
	public void mouseExited(MouseEvent e) {}

	
	@Override
	public void mouseDragged(MouseEvent e) {
		Point pt=e.getPoint();
		
		if(drawingSpace.pt1.x>pt.x) {
		drawingSpace.pt1.x=pt.x;
		}
		if(drawingSpace.pt1.y>pt.y) {
			drawingSpace.pt1.y=pt.y;
			}
		if(drawingSpace.pt1.x<pt.x || drawingSpace.pt1.y<pt.y ) drawingSpace.pt2=pt;
		
		drawingSpace.repaint();
	}

	@Override
	public void mouseMoved(MouseEvent e) {}
	

	
	
	
}


