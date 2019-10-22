package pack1;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MaFenetre extends JFrame{
	JLabel lnom,lprenom,lpseudo,lhelp;
	JTextField tfnom,tfprenom,tfpseudo;
	JButton jvalider;
	JPanel pnom;
	MaFenetre(){
		this.setTitle("MaFenetre");
		this.setSize(700,300);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout());
		lnom = new JLabel("Nom");
		lnom.addMouseListener(new Ecouteur1());
		lprenom = new JLabel("Prenom");
		lprenom.addMouseListener(new Ecouteur1());
		lpseudo = new JLabel("Pseudo");
		lpseudo.addMouseListener(new Ecouteur1());
		tfnom = new JTextField();
		tfnom.setPreferredSize(new Dimension(100,20));
		tfnom.addFocusListener(new EcouteurFocus(this));
		tfprenom = new JTextField();
		tfprenom.setPreferredSize(new Dimension(100,20));
		tfprenom.addFocusListener(new EcouteurFocus(this));
		tfpseudo = new JTextField();
		tfpseudo.setPreferredSize(new Dimension(100,20));
		tfpseudo.addFocusListener(new EcouteurFocus(this));
		jvalider = new JButton("Valider");
		pnom=new JPanel();
		pnom.setLayout(new FlowLayout());
		pnom.add(lnom);
		pnom.add(tfnom);
		pnom.add(lprenom);
		pnom.add(tfprenom);
		pnom.add(lpseudo);
		pnom.add(tfpseudo);
		pnom.add(jvalider);
		this.add(pnom,BorderLayout.NORTH);
		lhelp=new JLabel("Help");
		this.add(lhelp,BorderLayout.SOUTH);

		jvalider.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JOptionPane.showMessageDialog(MaFenetre.this,tfnom.getText()+tfprenom.getText()+tfpseudo.getText());
			}
		});
	}
	class Ecouteur1 extends MouseAdapter {
		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			if (e.getSource()==lnom) {
			lnom.setForeground(Color.RED);
			}
			else if (e.getSource()==lprenom) {
				lprenom.setForeground(Color.RED);
			}
			else if (e.getSource()==lpseudo) {
				lpseudo.setForeground(Color.RED);
			}
			
			super.mouseEntered(e);
		}
		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			if (e.getSource()==lnom) {
				lnom.setForeground(null);
				}
				else if (e.getSource()==lprenom) {
					lprenom.setForeground(null);
				}
				else if (e.getSource()==lpseudo) {
					lpseudo.setForeground(null);
				}
			super.mouseExited(e);
		}

	}
}
