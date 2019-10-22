package pack1;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JTextField;

public class EcouteurFocus implements FocusListener {
	MaFenetre jft;
	
	EcouteurFocus(MaFenetre tf){
		this.jft=tf;
	}
	@Override
	public void focusGained(FocusEvent e) {
		// TODO Auto-generated method stub
		this.jft.lnom.setText("Votre nom");
	}

	@Override
	public void focusLost(FocusEvent e) {
		// TODO Auto-generated method stub

	}

}
