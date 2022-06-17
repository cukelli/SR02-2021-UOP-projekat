package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.time.LocalDate;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import biblioteka.Administrator;
import biblioteka.Biblioteka;
import biblioteka.Bibliotekar;
import biblioteka.Clan;
import biblioteka.Iznajmljivanje;
import biblioteka.Primerak;
import biblioteka.Zaposleni;
import net.miginfocom.swing.MigLayout;
import utils.Utils;

public class DodajIznajmljivanjeProzor extends JDialog {
	
	
 private JLabel lblIDBibliotekara = new JLabel("ID Bibliotekara:");
 private JComboBox<Integer> cmbxIDBibliotekara = new JComboBox<Integer>();

 
 
 private JLabel lblIDclana = new JLabel("ID clana:");
 private JComboBox<Integer> cmbxIDClana = new JComboBox<Integer>();

 
 private JTextField datumIznajmljivanja = new JTextField(20);
 private JLabel lblDatumIznajmljivanja = new JLabel("Datum iznajmljivanja");
 

 private JTextField datumVracanja = new JTextField(20);
 private JLabel lblVracanja = new JLabel("Datum vracanja");
 
 private JLabel lblIDPrimerka = new JLabel("ID primerka:");
 private JComboBox<Integer> cmbxIDPrimerka = new JComboBox<Integer>();
 
 
 private JButton dugmeDodaj = new JButton("Dodaj");
 
 private Biblioteka biblioteka;
 private Zaposleni prijavljeniZaposleni;
 
 public DodajIznajmljivanjeProzor(Biblioteka biblioteka,Zaposleni prijavljeniZaposleni) {
 	this.biblioteka = biblioteka;
 	this.prijavljeniZaposleni = prijavljeniZaposleni;
 	setTitle("Zaposleni: " + prijavljeniZaposleni.getIDOsobe());
		setSize(500, 500);
		Integer[] bibliotekarID = new Integer[biblioteka.neobrisaniBibliotekari().size()];
		for (int i=0; i<biblioteka.neobrisaniBibliotekari().size();i++) {
			Bibliotekar b = biblioteka.neobrisaniBibliotekari().get(i);
			bibliotekarID[i] = b.getIDOsobe();
			
		}
		Integer[] clanID = new Integer[biblioteka.AktivniClanovi().size()];
		for (int i=0; i<biblioteka.AktivniClanovi().size();i++) {
			Clan c = biblioteka.AktivniClanovi().get(i);
			clanID[i] = c.getIDOsobe();
			
		}
		Integer[] primerakID = new Integer[biblioteka.sviNeiznajmljeniPrimerci().size()];
		for (int i=0; i<biblioteka.sviNeiznajmljeniPrimerci().size();i++) {
			Primerak p = biblioteka.sviNeiznajmljeniPrimerci().get(i);
			primerakID[i] = p.getIDPrimerka();
			
		}
		

	    cmbxIDBibliotekara.setModel(new DefaultComboBoxModel<Integer>(bibliotekarID));
	    cmbxIDClana.setModel(new DefaultComboBoxModel<Integer>(clanID));
	    cmbxIDPrimerka.setModel(new DefaultComboBoxModel<Integer>(primerakID));
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
  	initMenu();
	initActions();
 }

 private void initMenu() {
 	MigLayout mig = new MigLayout("wrap 2","[][]", "[]10[][]10[]");
	    	setLayout(mig);

 	
 	
 	add(lblIDBibliotekara);
 	add(cmbxIDBibliotekara);
 	add(lblIDclana);
 	add(cmbxIDClana);
 	add(lblDatumIznajmljivanja);
 	add(datumIznajmljivanja);
 	add(lblVracanja);
 	add(datumVracanja);
 	add(lblIDPrimerka);
 	add(cmbxIDPrimerka);
 	add(dugmeDodaj);
}
 
 private void initActions() {
		dugmeDodaj.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				try {
					LocalDate datumIznajmljivanjaDodaj = LocalDate.parse(datumIznajmljivanja.getText().trim());
					LocalDate datumVracanjaDodaj = LocalDate.parse(datumVracanja.getText().trim());
					
		
					
					
					 if (Utils.validirajIznajmljivanje(datumIznajmljivanjaDodaj, datumVracanjaDodaj)) {
					Bibliotekar bibliotekar = (Bibliotekar) prijavljeniZaposleni;

				bibliotekar.iznajmiKnjigu(Iznajmljivanje.getUpdateMaker()+1, biblioteka.neobrisaniBibliotekari().get(cmbxIDBibliotekara.getSelectedIndex()),biblioteka.neobrisaniClanovi().get(cmbxIDClana.getSelectedIndex()),datumIznajmljivanjaDodaj,datumVracanjaDodaj,biblioteka.sviNeiznajmljeniPrimerci().get(cmbxIDPrimerka.getSelectedIndex()),biblioteka);
				
				dispose();
				IznajmljivanjeProzor ip = new IznajmljivanjeProzor(biblioteka,prijavljeniZaposleni);
				ip.setVisible(true);
				
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