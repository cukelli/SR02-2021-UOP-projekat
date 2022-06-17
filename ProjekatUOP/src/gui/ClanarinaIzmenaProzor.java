package gui;

import java.awt.event.ActionEvent;


import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import biblioteka.Administrator;
import biblioteka.Biblioteka;
import biblioteka.Pol;
import biblioteka.TipClanarine;
import biblioteka.Zaposleni;
import net.miginfocom.swing.MigLayout;
import utils.Utils;

public class ClanarinaIzmenaProzor extends JDialog {
	private JTextField IDPolje = new JTextField(20);
    private JLabel lblID = new JLabel("ID");
	
	private JTextField tipPolje = new JTextField(20);
    private JLabel lblTip = new JLabel("Opis");
    
    private JTextField cenaPolje = new JTextField(20);
    private JLabel lblCena = new JLabel("Oznaka");
  private JButton dugmeIzmena = new JButton("Izmenite");
    
    private Biblioteka biblioteka;
    private Zaposleni prijavljeniZaposleni;
    private int index;
    
    public ClanarinaIzmenaProzor(Biblioteka biblioteka,Zaposleni prijavljeniZaposleni,int index) {
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
	    	add(dugmeIzmena);
	    	IDPolje.setEditable(false);
	    	
	    	TipClanarine tc = biblioteka.neobrisaneClanarine().get(index);
	    	IDPolje.setText(Integer.toString(tc.getIDClanarine()));
	    	tipPolje.setText(tc.getTip());
	    	cenaPolje.setText(Double.toString(tc.getCena()));
	    	
	    	
    }
    
    private void initActions() {
   		dugmeIzmena.addActionListener(new ActionListener() {
   			@Override
  			public void actionPerformed(ActionEvent e) {
  				try {
  					
  					String tipIzmena = tipPolje.getText().trim();
  					int cenaIzmena = Integer.parseInt(cenaPolje.getText().trim());
  					
  					if (Utils.validirajTipClanarine(tipIzmena, cenaIzmena)) {
  					
  					
					prijavljeniZaposleni.updateClanarina(tipIzmena,cenaIzmena,Integer.parseInt(IDPolje.getText().trim()),biblioteka);
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
