package gui;

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
import biblioteka.Povez;
import biblioteka.Primerak;
import net.miginfocom.swing.MigLayout;

public class PrimerakIzmenaProzor extends JFrame {
	private JTextField naslovPolje = new JTextField(20);
    private JLabel lblNaslov = new JLabel("Naslov knjige");
    
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
    private Primerak primerak;
    
    
    public PrimerakIzmenaProzor(Biblioteka biblioteka,Primerak primerak) {
    	this.biblioteka = biblioteka;
    	this.primerak = primerak;
    	cmbxJezik.setModel(new DefaultComboBoxModel<Jezik>(Jezik.values()));
    	cmbxPovez.setModel(new DefaultComboBoxModel<Povez>(Povez.values()));
    	setTitle("Primerak: " + primerak.getIDPrimerka());
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
    	add(lblBrojStrana);
    	add(brojStrana);
    	add(lblGodinaStampe);
    	add(godinaStampe);
    	add(lblJezikStampe);
    	add(cmbxJezik);
    	add(lblPovez);
    	add(cmbxPovez);
    	add(dugmeIzmena);
    	
    	naslovPolje.setText(primerak.getKnjiga().getNaslov());
    	brojStrana.setText(Integer.toString(primerak.getBrojStrana()));
    	godinaStampe.setText(Integer.toString(primerak.getGodinaStampe()));
    
    	
    	
 
    	
    	
    	
    	
    }
	


}
