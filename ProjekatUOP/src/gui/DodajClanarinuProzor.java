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
import biblioteka.TipClanarine;
import biblioteka.Zaposleni;
import net.miginfocom.swing.MigLayout;
import utils.Utils;

public class DodajClanarinuProzor extends JDialog {
	private JTextField IDPolje = new JTextField(20);
    private JLabel lblID = new JLabel("ID");
	
	private JTextField tipPolje = new JTextField(20);
    private JLabel lblTip = new JLabel("Tip");
    
    private JTextField cenaPolje = new JTextField(20);
    private JLabel lblCena = new JLabel("Cena");
  private JButton dugmeDodaj = new JButton("Dodaj");
    
    private Biblioteka biblioteka;
    private Zaposleni prijavljeniZaposleni;
    
    
    public DodajClanarinuProzor(Biblioteka biblioteka,Zaposleni prijavljeniZaposleni) {
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
	    	add(lblID);
	    	add(IDPolje);
	    	add(lblTip);
	    	add(tipPolje);
	    	add(lblCena);
	    	add(cenaPolje);
	    	add(dugmeDodaj);
	    	IDPolje.setEditable(false);

}
    private void initActions() {
   		dugmeDodaj.addActionListener(new ActionListener() {
   			@Override
  			public void actionPerformed(ActionEvent e) {
  				try {
  					
  					String tipDodaj = tipPolje.getText().trim();
  					int cenaDodaj = Integer.parseInt(cenaPolje.getText().trim());
  					
  					if (Utils.validirajTipClanarine(tipDodaj, cenaDodaj)) {
  					
					prijavljeniZaposleni.dodajTipClanarine(TipClanarine.getIdMaker()+1,tipDodaj,cenaDodaj,biblioteka);
					dispose();
					TipClanarineProzor cp = new TipClanarineProzor(biblioteka,prijavljeniZaposleni);
					cp.setVisible(true);
					
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
