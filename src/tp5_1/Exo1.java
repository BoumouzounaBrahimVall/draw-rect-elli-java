package tp5_1;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Exo1 extends WindowAdapter implements  ActionListener{
		
	private Frame frame; 
	private Button[] boutons=new Button[12];
	private TextField phoneNumber;
	private String history;
	public Exo1() {
		history="";
		Panel panelB=new Panel();
		Panel panelT=new Panel();
		phoneNumber=new TextField(40);
		
		panelT.add(phoneNumber);
		
		panelB.setLayout(new GridLayout(4,3));
		for(int i=1;i<=9;i++) {
			panelB.add(( boutons[i]=new Button(Integer.toString(i)) ) );
			boutons[i].addActionListener(this);
		}
		panelB.add(( boutons[0]=new Button("Bis") ));
		boutons[0].addActionListener(this);

		panelB.add(( boutons[10]=new Button("0") ));
		boutons[10].addActionListener(this);

		panelB.add(( boutons[11]=new Button("Reset") ));
		boutons[11].addActionListener(this);

		
		frame=new Frame("Untitled");
		frame.add(panelT,BorderLayout.NORTH);
		frame.add(panelB,BorderLayout.CENTER);
		frame.setMinimumSize(new Dimension(400,400));
		frame.pack();
		frame.setVisible(true);
	

		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e){System.exit(0);}
		});
		
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Button tmp=(Button)e.getSource();
		if(tmp.getLabel().equals("Reset")) { 
			history="";
			history+=phoneNumber.getText();
			phoneNumber.setText(" ");
		}
		else if(tmp.getLabel().equals("Bis")) phoneNumber.setText(history);
		else phoneNumber.setText(phoneNumber.getText() +tmp.getLabel());
		
	}
	
	public static void main(String[] args) {
		@SuppressWarnings("unused")
		var E=new Exo1(); 
	}
	
	

	
}
