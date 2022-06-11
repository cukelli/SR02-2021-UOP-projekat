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
import biblioteka.Zanr;
import biblioteka.Zaposleni;
import net.miginfocom.swing.MigLayout;

public class DodajKnjiguProzor extends JDialog {
	
	
	private JTextField naslovPolje = new JTextField(20);
    private JLabel lblNaslov = new JLabel("Naslov");
    
    
    private JTextField originalniNaslov = new JTextField(20);
    private JLabel lblOriginalniNaslov = new JLabel("Originalni naslov");
    

    private JTextField autor = new JTextField(20);
    private JLabel lblAutor = new JLabel("Autor");
    
    private JTextField godinaObjavljivanja = new JTextField(20);
    private JLabel lblGodinaObjavljivanja = new JLabel("Godina objavljivanja");
    
    private JLabel lblJezik = new JLabel("Jezik");
    private JComboBox<Jezik> cmbxJezik = new JComboBox<Jezik>();

    

    private JTextField opis = new JTextField(20);
    private JLabel lblOpis = new JLabel("Opis");
    

    
    private JLabel lblZanr = new JLabel("Zanr");
    private JComboBox<String> cmbxZanr = new JComboBox<String>();
    
    private JButton dugmeDodaj = new JButton("Dodaj");
    
    
    
    private Biblioteka biblioteka;
    private Zaposleni prijavljeniZaposleni;


public DodajKnjiguProzor(Biblioteka biblioteka,Zaposleni prijavljeniZaposleni) {
	this.biblioteka = biblioteka;
	this.prijavljeniZaposleni = prijavljeniZaposleni;
	setTitle("Zaposleni: " + prijavljeniZaposleni.getIDOsobe());
	setSize(500, 500);
	cmbxJezik.setModel(new DefaultComboBoxModel<Jezik>(Jezik.values()));
	
	String[] zanrovi = new String[biblioteka.neobrisaniZanrovi().size()];
	for (int i=0; i<biblioteka.neobrisaniZanrovi().size(); i++) {
		Zanr z =  biblioteka.neobrisaniZanrovi().get(i);
		zanrovi[i] = z.getOznaka();
	}
    
	cmbxZanr.setModel(new DefaultComboBoxModel<String>(zanrovi));
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
	add(naslovPolje);
	add(lblOriginalniNaslov);
	add(originalniNaslov);
	add(lblAutor);
	add(autor);
	add(lblGodinaObjavljivanja);
  	add(godinaObjavljivanja);
	add(lblJezik);
	add(cmbxJezik);
	add(lblOpis);
	add(opis);
	add(lblZanr);
	add(cmbxZanr);
	add(dugmeDodaj);
	
}
private void initActions() {
		dugmeDodaj.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
				prijavljeniZaposleni.dodajKnjigu(Knjiga.getUpdateMaker()+1,naslovPolje.getText().trim(),originalniNaslov.getText().trim(),autor.getText().trim(),Integer.parseInt(godinaObjavljivanja.getText().trim()),Jezik.valueOf(cmbxJezik.getSelectedItem().toString().trim()),opis.getText().trim(),biblioteka.neobrisaniZanrovi().get(cmbxZanr.getSelectedIndex()),biblioteka);
				dispose();
				KnjigaProzor kp = new KnjigaProzor(biblioteka,prijavljeniZaposleni);
				kp.setVisible(true);
			} catch (NumberFormatException e1) {
				
				e1.printStackTrace();
			} catch (IOException e1) {
				
				e1.printStackTrace();
			}
			
			
				
				
			}
		});
		};



}