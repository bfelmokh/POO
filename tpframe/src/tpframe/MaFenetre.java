package tpframe;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import javax.imageio.ImageIO;
import javax.swing.ButtonGroup;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.SpinnerListModel;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileView;
import javax.swing.plaf.FileChooserUI;


public class MaFenetre extends JFrame implements ActionListener{
	//Déclaration de mes composants
	private JLabel lnom,lpassword,llangue,lsexe,ldatenai,lville,ladresse,lloisir,lphoto;
	private JTextField txtnom;
	private JPasswordField txtpassword;
	private JButton bvalider,bannuler;
	private JList jllangue,jlville,jlgouv;
	private DefaultListModel lmlangue,lmgouv;
	private DefaultComboBoxModel lmville;
	private JScrollPane jsplangue,jspgouv;
	private JComboBox jspville;
	private ButtonGroup bgsexe;
	private JRadioButton rbmale,rbfemelle;
	private JPanel jpsexe,jpdatenai,jploisir,jpadresse;
	private JTextArea jtaadresse;
	private JCheckBox jcbjava,jcbfoot,jcbmusic,jcbcuisine,jcbvoyage;
	private JButton bphoto;
	MaFenetre () {
		//init de la fenetre
		this.setTitle("MaFenetre");
		this.setSize(800,700);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLayout(new FlowLayout());
		// Name Line
		lnom = new JLabel ("Nom الاسم");
		lnom.setBackground(Color.cyan);
		lnom.setOpaque(true);
		lnom.setForeground(Color.white);
		lnom.setPreferredSize(new Dimension(300,50));
		lnom.setHorizontalAlignment(JLabel.RIGHT);
		this.add(lnom);
		txtnom = new JTextField();
		txtnom.setFont(new Font("Arial",Font.BOLD,26));
		txtnom.setText("Saisir votre Nom");
		txtnom.setForeground(Color.white);
		txtnom.setSelectedTextColor(Color.red);
		txtnom.setBackground(Color.green);
		txtnom.setPreferredSize(new Dimension(460,50));
		this.add(txtnom);
		
		// Password Line
		lpassword = new JLabel("Password");
		lpassword.setPreferredSize(new Dimension(300,50));
		this.add(lpassword);
		txtpassword = new JPasswordField();
		txtpassword.setPreferredSize(new Dimension(460,30));
		this.add(txtpassword);

		// Language Line
		llangue = new JLabel("Langue");
		llangue.setPreferredSize(new Dimension(300,50));
		this.add(llangue);
				String[] t = new String [] {"Arabe","Français","Anglais","Italien","Allemand"};
				lmlangue = new DefaultListModel();
				jllangue = new JList (lmlangue);
				for (int i=0;i<5;i++) {
				lmlangue.addElement(t[i]);
				}
				jllangue.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
				jsplangue=new JScrollPane(jllangue);	
				jsplangue.setPreferredSize(new Dimension(460,60));
		this.add(jsplangue);
		// Sexe Line
		lsexe = new JLabel("Sexe");
		lsexe.setHorizontalAlignment(JLabel.CENTER);
		lsexe.setPreferredSize(new Dimension(300,30));
		this.add(lsexe);
		rbmale = new JRadioButton("Male");
		rbfemelle = new JRadioButton("Femelle");
		bgsexe = new ButtonGroup();
		bgsexe.add(rbmale);
		bgsexe.add(rbfemelle);
		jpsexe= new JPanel();
		jpsexe.setLayout(new FlowLayout());
		jpsexe.add(rbmale);
		jpsexe.add(rbfemelle);
		jpsexe.setPreferredSize(new Dimension(460,30));
		this.add(jpsexe);
		
		// Date de Naissance 
		
		ldatenai = new JLabel("Date de naissance");
		ldatenai.setPreferredSize(new Dimension(300,30));
		this.add(ldatenai);
		jpdatenai = new JPanel();
		jpdatenai.setLayout(new FlowLayout()); 
		jpdatenai.setPreferredSize(new Dimension(460,30));
		//date Static (On peut faire l'automatisation pour le jour selon mois et année)
		
		String[] dayList = new String[31];
		dayList = new String[30];
		for (int i=1;i<29;i++) {
			dayList[i]=Integer.toString(i);
		}
		DefaultComboBoxModel cbmday= new DefaultComboBoxModel(dayList);
		JComboBox jcbday = new JComboBox();
		jcbday.setModel(cbmday);
		jcbday.setPreferredSize(new Dimension(45, 20));
		jpdatenai.add(jcbday);
		jpdatenai.add(new JLabel("/"));
		
		String[] monthList = new String[12];
		monthList = new String[13];
		for (int i=1;i<13;i++) {
			monthList[i]=Integer.toString(i);
		}
		DefaultComboBoxModel cbmmonth= new DefaultComboBoxModel(monthList);
		JComboBox jcbmonth = new JComboBox();
		jcbmonth.setModel(cbmmonth);
		jcbmonth.setPreferredSize(new Dimension(45, 20));
		jpdatenai.add(jcbmonth);
		jpdatenai.add(new JLabel("/"));
		
		String[] yearList = new String[100];
		yearList = new String[100];
		for (int i=1;i<100;i++) {
			yearList[i]=Integer.toString(i+1910);
		}
		DefaultComboBoxModel cbmyear= new DefaultComboBoxModel(yearList);
		JComboBox jcbyear = new JComboBox();
		jcbyear.setModel(cbmyear);
		jcbyear.setPreferredSize(new Dimension(60, 20));
		jpdatenai.add(jcbyear);
		
		this.add(jpdatenai);
		
		lville = new JLabel("Ville");
		lville.setPreferredSize(new Dimension(300,30));
		this.add(lville);
			
			String[] v = new String [] {"Haouaria","Kelibia","Tunis","Sousse","Djerba"};
			lmville = new DefaultComboBoxModel();
			//jlville = new JList (lmgouv);
			for (int i=0;i<5;i++) {
				lmville.addElement(v[i]);
			}
			jspville=new JComboBox(lmville);
			jspville.setPreferredSize(new Dimension(460,30));
		this.add(jspville);
		
		//igouv = new Image("Ville");
//		this.add(lville);
		
		BufferedImage wPic;
		try {
			wPic = ImageIO.read(this.getClass().getResource("map.png"));
			JLabel wIcon = new JLabel(new ImageIcon(wPic));
			wIcon.setSize(new Dimension(100,120));
			wIcon.setPreferredSize(new Dimension(300,150));
			this.add(wIcon);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
			String[] g = new String [] {"Ariana","Nabeul","Tunis","Sousse","Sfax","Monastir","Ben Arous"};
			lmgouv = new DefaultListModel();
			jlgouv = new JList (lmgouv);
			for (int i=0;i<g.length;i++) {
				lmgouv.addElement(g[i]);
			}
			jlgouv.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			jspgouv=new JScrollPane(jlgouv);	
			jspgouv.setPreferredSize(new Dimension(460,100));
		this.add(jspgouv);
		
		
		ladresse = new JLabel("Adresse");
		ladresse.setPreferredSize(new Dimension(300,30));
		this.add(ladresse);
		jtaadresse = new JTextArea();
		jtaadresse.setPreferredSize(new Dimension (460,80));
	    jpadresse = new JPanel();
	    jpadresse.setLayout(new FlowLayout());
	    jpadresse.add(jtaadresse);
	    jpadresse.setPreferredSize(new Dimension (460,80));
// 	    jpadresse.add(scrollBar);
	    JScrollPane scrollPane = new JScrollPane(jpadresse,ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
	    scrollPane.setPreferredSize(new Dimension(460, 80));
		this.add(scrollPane);
		lloisir = new JLabel("Loisir");
		lloisir.setPreferredSize(new Dimension(300,30));
		this.add(lloisir);
		jploisir= new JPanel();
		jploisir.setLayout(new FlowLayout());
		jploisir.setPreferredSize(new Dimension(460,40));
		jcbjava = new JCheckBox("Java");
		jploisir.add(jcbjava);
		jcbfoot = new JCheckBox("Foot");
		jploisir.add(jcbfoot);
		jcbmusic = new JCheckBox("Music");
		jploisir.add(jcbmusic);
		jcbcuisine = new JCheckBox("Cuisine");
		jploisir.add(jcbcuisine);		
		jcbvoyage = new JCheckBox("Cuisine");
		jploisir.add(jcbvoyage);
		this.add(jploisir);
		
		lphoto = new JLabel("Photo");
		lphoto.setPreferredSize(new Dimension(300,30));
		lphoto.setHorizontalAlignment(JLabel.LEFT);
		this.add(lphoto);
		bphoto = new JButton("Choisir votre photo");
		bphoto.setPreferredSize(new Dimension(200,30));
		bphoto.addActionListener(this);
		this.add(bphoto);
		bvalider = new JButton("Valider");
		bvalider.setPreferredSize(new Dimension(300,30));
		this.add(bvalider);
		bannuler = new JButton("Annuler");
		bannuler.setPreferredSize(new Dimension(460,30));
		this.add(bannuler);
			
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == bphoto ) {
			JFileChooser jfcphoto= new JFileChooser();
			jfcphoto.setCurrentDirectory(new java.io.File("D:/Profiles"));
			jfcphoto.showOpenDialog(this);
		}
		
	}

}
