package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;


import biblioteka.Biblioteka;
import biblioteka.Zanr;
import biblioteka.Zaposleni;

import net.miginfocom.swing.MigLayout;

public class ZanrIzmenaProzor extends JDialog {
	private JTextField IDPolje = new JTextField(20);
    private JLabel lblID = new JLabel("ID");
	
	private JTextField opisPolje = new JTextField(20);
    private JLabel lblOpis = new JLabel("Opis");
    
    private JTextField oznakaPolje = new JTextField(20);
    private JLabel lblOznaka = new JLabel("Oznaka");
    
    private JButton dugmeIzmena = new JButton("Izmenite");
    
    private Biblioteka biblioteka;
    private Zaposleni prijavljeniZaposleni;
    private int index;
    
    public ZanrIzmenaProzor(Biblioteka biblioteka,Zaposleni prijavljeniZaposleni,int index) {
    	this.biblioteka = biblioteka;
    	this.prijavljeniZaposleni = prijavljeniZaposleni;
    	setTitle("Admin: " + prijavljeniZaposleni.getIDOsobe());
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
     		  IDPolje.setEditable(false);
     		  add(IDPolje);
     		  add(lblOpis);
     		  add(opisPolje);
     		  add(lblOznaka);
     		  add(oznakaPolje);
     		  add(dugmeIzmena);
     		  
     		  Zanr z = biblioteka.neobrisaniZanrovi().get(index);
     		  IDPolje.setText(Integer.toString(z.getIDZanra()));
     		  opisPolje.setText(z.getOpis());
     		  oznakaPolje.setText(z.getOznaka());
     		  
     		  
     	  }
     	  
//     	 private void initActions() {
//     		dugmeIzmena.addActionListener(new ActionListener() {
//     			@Override
//     			public void actionPerformed(ActionEvent e) {
//     				
//     			}
//     				
//     		});
//     	};
    } 
    


