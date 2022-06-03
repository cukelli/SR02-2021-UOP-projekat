package gui;

import javax.swing.JButton;


import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import biblioteka.Biblioteka;
import biblioteka.Knjiga;
import biblioteka.Zaposleni;
import net.miginfocom.swing.MigLayout;

public class KnjigaIzmenaProzor extends JDialog {
	
	private JTextField naslovPolje = new JTextField(20);
    private JLabel lblNaslov = new JLabel("Naslov");
    
    private JTextField originalniNaslov = new JTextField(20);
    private JLabel lblOriginalniNaslov = new JLabel("Originalni naslov");
    
    private JTextField godinaObjavljivanja = new JTextField(20);
    private JLabel lblGodinaObjavljivanja = new JLabel("Godina objavljivanja");
    
    private JTextField jezik = new JTextField(20);
    private JLabel lblJezik = new JLabel("Jezik");
    

    private JTextField opis = new JTextField(20);
    private JLabel lblOpis = new JLabel("Opis");
    

    private JTextField zanr = new JTextField(20);
    private JLabel lblZanr = new JLabel("Zanr");
    
    private JButton dugmeIzmena = new JButton("Izmenite");
    
    
    
    private Biblioteka biblioteka;
    private Zaposleni prijavljeniZaposleni;
    private int index;
    
    
    public KnjigaIzmenaProzor(Biblioteka biblioteka,Zaposleni prijavljeniZaposleni,int index) {
    	this.biblioteka = biblioteka;
    	this.prijavljeniZaposleni = prijavljeniZaposleni;
    	setTitle("Zaposleni: " + prijavljeniZaposleni.getIDOsobe());
		setSize(500, 500);
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
     	initMenu();
//		initActions();
    	
    } 
    
    private void initMenu() {
    	MigLayout mig = new MigLayout("wrap 2","[][]", "[]10[][]10[]");
    	setLayout(mig);
    	
    	add(lblNaslov);
    	add(naslovPolje);
    	add(lblOriginalniNaslov);
    	add(originalniNaslov);
    	add(lblGodinaObjavljivanja);
      	add(godinaObjavljivanja);
    	add(lblJezik);
    	add(jezik);
    	add(lblOpis);
    	add(opis);
    	add(lblZanr);
    	add(zanr);
    	add(dugmeIzmena);
    	
    	Knjiga k = biblioteka.neobrisaneKnjige().get(index);
    	naslovPolje.setText(k.getNaslov());
        originalniNaslov.setText(k.getOriginalniNaslov());
        godinaObjavljivanja.setText(Integer.toString(k.getGodinaObjavljivanja()));
        jezik.setText(k.getJezikOriginala().name());
        opis.setText(k.getOpis());
        zanr.setText(k.getZanr().getOznaka());
        
        
    
	
    }

}
