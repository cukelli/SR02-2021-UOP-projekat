package gui;

import javax.swing.JButton;


import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import biblioteka.Administrator;
import biblioteka.Biblioteka;
import biblioteka.Bibliotekar;
import biblioteka.Zaposleni;
import net.miginfocom.swing.MigLayout;

public class BibliotekarIzmenaProzor extends JDialog {
	private JTextField IDPolje = new JTextField(20);
    private JLabel lblID = new JLabel("ID");
	
	private JTextField imePolje = new JTextField(20);
    private JLabel lblIme = new JLabel("Ime");
    
    private JTextField prezimePolje = new JTextField(20);
    private JLabel lblPrezime = new JLabel("Prezime");
    
    private JTextField adresaPolje = new JTextField(20);
    private JLabel lblAdresa = new JLabel("Adresa");
    
    private JTextField plata = new JTextField(20);
    private JLabel lblPlata = new JLabel("Plata");
    

    private JTextField korisnickoIme = new JTextField(20);
    private JLabel lblKorisnickoIme = new JLabel("Korisnicko ime");
    

    private JPasswordField lozinka = new JPasswordField(20);
    private JLabel lblLozinka = new JLabel("Lozinka");
    
    private JButton dugmeIzmena = new JButton("Izmenite");
    
    private Biblioteka biblioteka;
    private Zaposleni prijavljeniZaposleni;
    private int index;
    
    
    public BibliotekarIzmenaProzor(Biblioteka biblioteka, Zaposleni prijavljeniZaposleni,int index) {
    this.prijavljeniZaposleni = prijavljeniZaposleni;
  	this.biblioteka = biblioteka;
	setTitle("Administrator: " + prijavljeniZaposleni.getKorIme());
	setSize(500, 500);
	setResizable(false);
	setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	setLocationRelativeTo(null);
 	initMenu();
//	initActions();
	
} 

private void initMenu() {
	MigLayout mig = new MigLayout("wrap 2","[][]", "[]10[][]10[]");
	setLayout(mig);
	add(lblID);
	add(IDPolje);
	IDPolje.setEditable(false);
	add(lblIme);
	add(imePolje);
	add(lblPrezime);
	add(prezimePolje);
	add(lblAdresa);
	add(adresaPolje);
	add(lblPlata);
	add(plata);
	add(lblKorisnickoIme);
	add(korisnickoIme);
	add(lblLozinka);
	add(lozinka);
	add(dugmeIzmena);
	
	this.setVisible(true);
	Bibliotekar b = biblioteka.neobrisaniBibliotekari().get(index);
	
	IDPolje.setText(Integer.toString(b.getIDOsobe()));
	imePolje.setText(b.getIme());
	prezimePolje.setText(b.getPrezime());
    adresaPolje.setText(b.getAdresa());
	plata.setText(Double.toString(b.getPlata()));
	korisnickoIme.setText(b.getKorIme());
	lozinka.setText(b.getLozinka());
	
}

}
