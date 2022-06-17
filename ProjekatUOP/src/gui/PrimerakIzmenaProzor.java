package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Vector;



import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import biblioteka.Biblioteka;
import biblioteka.Jezik;
import biblioteka.Knjiga;
import biblioteka.Pol;
import biblioteka.Povez;
import biblioteka.Primerak;
import biblioteka.TipClanarine;
import biblioteka.Zaposleni;
import net.miginfocom.swing.MigLayout;
import utils.Utils;

public class PrimerakIzmenaProzor extends JFrame {
	
	private JTextField ID = new JTextField(4);
    private JLabel lblID = new JLabel("ID");
	
    private JLabel lblNaslov = new JLabel("Naslov knjige");
    private JComboBox<String> cmbxKnjige = new JComboBox<String>();
    
    private JTextField brojStrana = new JTextField(20);
    private JLabel lblBrojStrana = new JLabel("Broj strana");
    
    private JTextField godinaStampe = new JTextField(20);
    private JLabel lblGodinaStampe = new JLabel("Godina stampe");
    
  
    private JLabel lblJezikStampe = new JLabel("Jezik stampe");
    private JComboBox<Jezik> cmbxJezik = new JComboBox<Jezik>();
    
    private JLabel lblPovez = new JLabel("Povez");
    private JComboBox<Povez> cmbxPovez = new JComboBox<Povez>();
   
   private JButton dugmeIzmena = new JButton("Potvrdite izmenu"); 
    
    private Biblioteka biblioteka;
    private Zaposleni prijavljeniZaposleni;
    private int index;
    
    
    public PrimerakIzmenaProzor(Biblioteka biblioteka,Zaposleni prijavljeniZaposleni,int index) {
    	this.biblioteka = biblioteka;
    	this.prijavljeniZaposleni = prijavljeniZaposleni;
    	this.index = index;
    	String[] knjige = new String[biblioteka.neobrisaneKnjige().size()];
		for (int i=0; i<biblioteka.neobrisaneKnjige().size();i++) {
			Knjiga k = biblioteka.neobrisaneKnjige().get(i);
			knjige[i] = k.getNaslov();
			
		}
    	
    	
    	cmbxKnjige.setModel(new DefaultComboBoxModel<String>(knjige));
    	cmbxJezik.setModel(new DefaultComboBoxModel<Jezik>(Jezik.values()));
    	cmbxPovez.setModel(new DefaultComboBoxModel<Povez>(Povez.values()));
    	setTitle("Zaposleni: " + prijavljeniZaposleni.getIDOsobe());
		setSize(500, 500);
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		
	
		
     	initMenu();
		initActions();
    	
    } 
    
    private void initMenu() {
    	MigLayout mig = new MigLayout("wrap 2","[][]", "[]10[][]10[]");
    	setLayout(mig);
    	
    	add(lblID);
    	add(ID);
    	add(lblNaslov);
    	add(cmbxKnjige);
    	add(lblBrojStrana);
    	add(brojStrana);
    	add(lblGodinaStampe);
    	add(godinaStampe);
    	add(lblJezikStampe);
    	add(cmbxJezik);
    	add(lblPovez);
    	add(cmbxPovez);
    	add(dugmeIzmena);
    	
    	Primerak p = biblioteka.neobrisaniPrimerci().get(index);
    	
    	ID.setText(Integer.toString(p.getIDPrimerka()));
    	ID.setEditable(false);
        cmbxKnjige.setSelectedItem(p.getKnjiga().getNaslov());
    	brojStrana.setText(Integer.toString(p.getBrojStrana()));
    	godinaStampe.setText(Integer.toString(p.getGodinaStampe()));
    	cmbxJezik.setSelectedItem(p.getJezikStampe());
    	cmbxPovez.setSelectedItem(p.getJezikStampe());
    	
    }
    
    private void initActions() {
   		dugmeIzmena.addActionListener(new ActionListener() {
   			@Override
  			public void actionPerformed(ActionEvent e) {
  				try {
  					int brojStranaIzmena =  Integer.parseInt(brojStrana.getText().trim());
  					int godinaStampeIzmena = Integer.parseInt(godinaStampe.getText().trim());
  					
  					if (Utils.validirajPrimerak(brojStranaIzmena, godinaStampeIzmena)) {
  						
					prijavljeniZaposleni.updatePrimerak(Integer.parseInt(ID.getText().trim()),biblioteka.neobrisaneKnjige().get(cmbxKnjige.getSelectedIndex()),brojStranaIzmena,godinaStampeIzmena,Jezik.valueOf(cmbxJezik.getSelectedItem().toString().trim()),Povez.valueOf(cmbxPovez.getSelectedItem().toString()),biblioteka);
					dispose();
					PrimerakProzor pp = new PrimerakProzor(biblioteka,prijavljeniZaposleni);
					pp.setVisible(true);
  					}
				} catch (NumberFormatException e1) {
					
					e1.printStackTrace();
				} catch (IOException e1) {
					
					e1.printStackTrace();
				}
  			
 			
  				
  				
  			}
   		});
   		};
	


}
