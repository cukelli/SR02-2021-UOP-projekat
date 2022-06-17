package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import biblioteka.Biblioteka;
import biblioteka.Jezik;
import biblioteka.Knjiga;
import biblioteka.Povez;
import biblioteka.Primerak;
import biblioteka.Zaposleni;
import net.miginfocom.swing.MigLayout;
import utils.Utils;

public class DodajPrimerakProzor extends JDialog {
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

    private JButton dugmeDodaj = new JButton("Dodaj");
    
    private Biblioteka biblioteka;
    private Zaposleni prijavljeniZaposleni;
    
    public DodajPrimerakProzor(Biblioteka biblioteka,Zaposleni prijavljeniZaposleni) {
    	this.biblioteka = biblioteka;
    	this.prijavljeniZaposleni = prijavljeniZaposleni;
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
    	add(dugmeDodaj);
    
    

}
    private void initActions() {
   		dugmeDodaj.addActionListener(new ActionListener() {
   			@Override
  			public void actionPerformed(ActionEvent e) {
  				try {
  					int brojStranaDodaj =  Integer.parseInt(brojStrana.getText().trim());
  					int godinaStampeDodaj = Integer.parseInt(godinaStampe.getText().trim());
  					
  					if (Utils.validirajPrimerak(brojStranaDodaj, godinaStampeDodaj)) {
  					
					prijavljeniZaposleni.dodajPrimerke(Primerak.getUpdateMaker()+1,biblioteka.neobrisaneKnjige().get(cmbxKnjige.getSelectedIndex()),brojStranaDodaj,godinaStampeDodaj,Jezik.valueOf(cmbxJezik.getSelectedItem().toString().trim()),Povez.valueOf(cmbxPovez.getSelectedItem().toString()),biblioteka);
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
