package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import biblioteka.Biblioteka;
import biblioteka.Zanr;
import biblioteka.Zaposleni;
import net.miginfocom.swing.MigLayout;
import utils.Utils;

public class DodajZanrProzor extends JDialog {
	
	private JTextField opisPolje = new JTextField(20);
    private JLabel lblOpis = new JLabel("Opis");
    
    private JTextField oznakaPolje = new JTextField(20);
    private JLabel lblOznaka = new JLabel("Oznaka");
    
    private JButton dugmeDodaj = new JButton("Dodajte");
    
    private Biblioteka biblioteka;
    private Zaposleni prijavljeniZaposleni;
    
    public DodajZanrProzor(Biblioteka biblioteka,Zaposleni prijavljeniZaposleni) {
    	this.biblioteka = biblioteka;
    	this.prijavljeniZaposleni = prijavljeniZaposleni;
    	setTitle("Admin: " + prijavljeniZaposleni.getIDOsobe());
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
		 
		  add(lblOpis);
		  add(opisPolje);
		  add(lblOznaka);
		  add(oznakaPolje);
		  add(dugmeDodaj);
     	

}
	  private void initActions() {
	   		dugmeDodaj.addActionListener(new ActionListener() {
	   			@Override
	  			public void actionPerformed(ActionEvent e) {
	  				try {
	  					
	  					String opisDodaj = opisPolje.getText().trim();
	  					String oznakaDodaj = oznakaPolje.getText().trim();
	  					
	  					
	  					if (Utils.validirajZanr(oznakaDodaj, opisDodaj)) {
	  					
						prijavljeniZaposleni.dodajZanr(opisDodaj,oznakaDodaj,Zanr.getIdMaker()+1,biblioteka);
						dispose();
						ZanrProzor zp = new ZanrProzor(biblioteka,prijavljeniZaposleni);
						zp.setVisible(true);
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
