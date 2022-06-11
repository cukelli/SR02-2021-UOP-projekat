package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.time.LocalDate;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import biblioteka.Biblioteka;
import biblioteka.Clan;
import biblioteka.Pol;
import biblioteka.TipClanarine;
import biblioteka.Zaposleni;
import net.miginfocom.swing.MigLayout;

public class DodajClanaProzor extends JDialog {
	private JTextField IDClana = new JTextField(4);
    private JLabel lblID = new JLabel("ID");
    
	private JTextField imeClana = new JTextField(10);
    private JLabel lblIme= new JLabel("Ime");
    
	private JTextField prezimeClana = new JTextField(10);
    private JLabel lblPrezime = new JLabel("Prezime");
    
    private JTextField JMBGClana = new JTextField(13);
    private JLabel lblJMBG = new JLabel("JMBG");
    
    private JTextField adresaClana = new JTextField(20);
    private JLabel lblAdresa = new JLabel("Adresa ");
    
    private JLabel lblPol = new JLabel("Pol clana");
    private JComboBox<Pol> cmbxPol = new JComboBox<Pol>();
	
	
	
	private JTextField brojClanske = new JTextField(20);
    private JLabel lblBrojClanske = new JLabel("Broj clanske");
    
    private JTextField datumPoslednjeUplate = new JTextField(20);
    private JLabel lblDatumPoslednjeUplate = new JLabel("Datum poslednje uplate");
    
    private JTextField brojUplacenihMeseci = new JTextField(20);
    private JLabel lblBrojUplacenihMeseci = new JLabel("Broj uplacenih meseci");
    
 
    private JLabel lblTipClanarine = new JLabel("Tip clanarine");
    private JComboBox<String> cmbxOznakaClanarine = new JComboBox<String>();
    
    JCheckBox aktivnostCheck = new JCheckBox("Aktivnost");
    
   

    
    private JButton dugmeDodaj = new JButton("Dodaj");
    
   
    private Biblioteka biblioteka;
    private Zaposleni prijavljeniZaposleni;
    public DodajClanaProzor(Biblioteka biblioteka,Zaposleni prijavljeniZaposleni) {
    	this.biblioteka = biblioteka;
    	this.prijavljeniZaposleni = prijavljeniZaposleni;
    	setTitle("Zaposleni: " + prijavljeniZaposleni.getIDOsobe());
		setSize(500, 500);
		String[] clanarine = new String[biblioteka.neobrisaneClanarine().size()];
		for (int i=0; i<biblioteka.neobrisaneClanarine().size();i++) {
			TipClanarine tc = biblioteka.neobrisaneClanarine().get(i);
			clanarine[i] = tc.getTip();
			
		}
		
		cmbxPol.setModel(new DefaultComboBoxModel<Pol>(Pol.values()));
	    cmbxOznakaClanarine.setModel(new DefaultComboBoxModel<String>(clanarine));
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
	    	add(IDClana);
	    	add(lblIme);
	    	add(imeClana);
	    	add(lblJMBG);
	    	add(JMBGClana);
	    	add(lblPol);
	    	add(cmbxPol);
	    	add(lblPrezime);
	    	add(prezimeClana);
	    	add(lblBrojClanske);
	    	add(brojClanske);
	    	add(lblDatumPoslednjeUplate);
	    	add(datumPoslednjeUplate);
	      	add(lblBrojUplacenihMeseci);
	    	add(brojUplacenihMeseci);
	    	add(lblTipClanarine);
	    	add(cmbxOznakaClanarine);
	    	add(aktivnostCheck);
	    	add(dugmeDodaj);
	    	IDClana.setEditable(false);
	
	
    }	
    
    private void initActions() {
   		dugmeDodaj.addActionListener(new ActionListener() {
   			@Override
  			public void actionPerformed(ActionEvent e) {
  				try {
					prijavljeniZaposleni.dodajClanove(Clan.getUpdateMaker()+1,imeClana.getText().trim(),prezimeClana.getText().trim(),JMBGClana.getText().trim(),adresaClana.getText().trim(),Pol.valueOf(cmbxPol.getSelectedItem().toString().trim()),brojClanske.getText().trim(),LocalDate.parse(datumPoslednjeUplate.getText().trim()),Integer.parseInt(brojUplacenihMeseci.getText()),biblioteka.neobrisaneClanarine().get(cmbxOznakaClanarine.getSelectedIndex()),biblioteka);
					dispose();
					ClanProzor cp = new ClanProzor(biblioteka,prijavljeniZaposleni);
					cp.setVisible(true);
				} catch (NumberFormatException e1) {
					
					e1.printStackTrace();
				} catch (IOException e1) {
					
					e1.printStackTrace();
				}
  			
 			
  				
  				
  			}
   		});
   		};
   		
   		

}
