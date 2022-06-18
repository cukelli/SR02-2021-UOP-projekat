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
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import biblioteka.Administrator;
import biblioteka.Biblioteka;
import biblioteka.Pol;
import biblioteka.Zaposleni;
import net.miginfocom.swing.MigLayout;
import utils.Utils;

public class DodajAdminaRegistracija extends JDialog {
	
	
	private JTextField imePolje = new JTextField(20);
    private JLabel lblIme = new JLabel("Ime");
    
    private JTextField prezimePolje = new JTextField(20);
    private JLabel lblPrezime = new JLabel("Prezime");
    
    private JTextField JMBGPolje = new JTextField(13);
    private JLabel lblJMBG = new JLabel("JMBG");
    
    private JLabel lblPol = new JLabel("Pol admina");
    private JComboBox<Pol> cmbxPol = new JComboBox<Pol>();
    
    
    private JTextField adresaPolje = new JTextField(20);
    private JLabel lblAdresa = new JLabel("Adresa");
    
    private JTextField plata = new JTextField(20);
    private JLabel lblPlata = new JLabel("Plata");
    

    private JTextField korisnickoIme = new JTextField(20);
    private JLabel lblKorisnickoIme = new JLabel("Korisnicko ime");
    

    private JPasswordField lozinka = new JPasswordField(20);
    private JLabel lblLozinka = new JLabel("Lozinka");
    
    private JButton dugmeDodaj = new JButton("Dodaj");
    
    private Biblioteka biblioteka;
    
    public DodajAdminaRegistracija(Biblioteka biblioteka) {
    	this.biblioteka = biblioteka;
    	setTitle("Registracija Administratora");
		setSize(500, 500);
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		cmbxPol.setModel(new DefaultComboBoxModel<Pol>(Pol.values()));
     	initMenu();
		initActions();
    	
    } 
    
    private void initMenu() {
    	MigLayout mig = new MigLayout("wrap 2","[][]", "[]10[][]10[]");
    	setLayout(mig);
    	add(lblIme);
    	add(imePolje);
    	add(lblPol);
    	add(cmbxPol);
    	add(lblPrezime);
    	add(prezimePolje);
    	add(lblAdresa);
    	add(adresaPolje);
    	add(lblJMBG);
    	add(JMBGPolje);
    	add(lblPlata);
    	add(plata);
    	add(lblKorisnickoIme);
    	add(korisnickoIme);
    	add(lblLozinka);
    	add(lozinka);
    	add(dugmeDodaj);
    }
    private void initActions() {
   		dugmeDodaj.addActionListener(new ActionListener() {
   			@Override
  			public void actionPerformed(ActionEvent e) {
  				try {
  					String ime = imePolje.getText().trim();
					String prezime = prezimePolje.getText().trim();
					String jmbg = JMBGPolje.getText().trim();
					String adresa = adresaPolje.getText().trim();
					double plataUpdate = Double.parseDouble(plata.getText().trim());
					String korisName = korisnickoIme.getText().trim();
					@SuppressWarnings("deprecation")
					String lozinkaUpdate = lozinka.getText().trim();
  					  					

					if (Utils.validirajZaposlenog(ime, prezime, jmbg, adresa,
							plataUpdate, korisName, lozinkaUpdate,null)  && 
							!Utils.JMBGValidacijaAdmin(biblioteka.getSviAdministratori(), jmbg, Integer.MAX_VALUE)) {
  					
					Administrator.registrujAdmina(Administrator.getIdMaker()+1,ime,prezime,jmbg,adresa,Pol.valueOf(cmbxPol.getSelectedItem().toString().trim()),plataUpdate,korisName,lozinkaUpdate,biblioteka);
					JOptionPane.showMessageDialog(null, "", "Uspesno ste se registrovali", JOptionPane.INFORMATION_MESSAGE);
					dispose();
					return;
					
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
