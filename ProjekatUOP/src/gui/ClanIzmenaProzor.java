package gui;

import java.awt.event.ActionEvent;



import java.awt.event.ActionListener;
import java.io.IOException;
import java.nio.file.Files;

import java.time.LocalDate;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;



import biblioteka.Biblioteka;
import biblioteka.Clan;
import biblioteka.Pol;
import biblioteka.TipClanarine;
import biblioteka.Zaposleni;


import net.miginfocom.swing.MigLayout;
import utils.Utils;

public class ClanIzmenaProzor extends JDialog {
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
    
    //private JCheckBox aktivnostCheck = new JCheckBox("Aktivnost");
    
   

    
    private JButton dugmeIzmena = new JButton("Izmenite");
    
   
    private Biblioteka biblioteka;
    private Zaposleni prijavljeniZaposleni;
    private int index;
    
    
    
    
    
    
    public ClanIzmenaProzor(Biblioteka biblioteka,Zaposleni prijavljeniZaposleni,int index) {
    	this.index = index;
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
     	    	add(lblAdresa);
     	    	add(adresaClana);
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
     	    	//add(aktivnostCheck);
     	    	add(dugmeIzmena);
     	    	IDClana.setEditable(false);
     	    	
     	    	
     	    	Clan c = biblioteka.neobrisaniClanovi().get(index);
     	    	IDClana.setText(Integer.toString(c.getIDOsobe()));
     	    	imeClana.setText(c.getIme());
     	    	prezimeClana.setText(c.getPrezime());
     	    	brojClanske.setText(c.getBrojClanske());
     	    	adresaClana.setText(c.getAdresa());
     	    	datumPoslednjeUplate.setText(c.getDatumPoslednjeUplate().toString());
     	    	brojUplacenihMeseci.setText(Integer.toString(c.getBrojUplacenihMeseci()));
     	    	cmbxOznakaClanarine.setSelectedItem(c.getTipClanarine());
     	    	JMBGClana.setText(c.getJMBG());
     	
     	    	
     	    	cmbxPol.setSelectedItem(c.getPol());
     	        	    				
     	    	   	  
 	  		}
     	 
     	 private void initActions() {
   		dugmeIzmena.addActionListener(new ActionListener() {
   			@Override
  			public void actionPerformed(ActionEvent e) {
   				
   				double cena = biblioteka.getSviClanovi().get(index).getTipClanarine().getCena();
   				

   			
   				
   				String imeUpdate = imeClana.getText().trim();
   				String prezimeUpdate = prezimeClana.getText().trim();
   				String JMBGUpdate = JMBGClana.getText().trim();
   				String adresaUpdate = adresaClana.getText().trim();
   				String brojClanskeUpdate = brojClanske.getText().trim();
   				int brojUplacenihMeseciUpdate = Integer.parseInt(brojUplacenihMeseci.getText().trim());
   				int idClana = Integer.parseInt(IDClana.getText().trim());
   				LocalDate datumPoslednjeUplateUpdate = LocalDate.parse(datumPoslednjeUplate.getText().trim());
   			    if (brojUplacenihMeseciUpdate >=6 && brojUplacenihMeseciUpdate <12) {
   			    	cena = (brojUplacenihMeseciUpdate * cena) - (brojUplacenihMeseciUpdate * cena * 0.1);
   			    	
   			    }
   			    else if (brojUplacenihMeseciUpdate >= 12) {
   			    	cena = (brojUplacenihMeseciUpdate * cena) - (brojUplacenihMeseciUpdate * cena * 0.2);
   			    	
   			    }
   			    else {
   			    	cena = brojUplacenihMeseciUpdate * cena;
   			    	
   			    }
   			    
  				try {
  					
  					
  					if (Utils.validirajClana(imeUpdate, prezimeUpdate, JMBGUpdate, adresaUpdate,
							brojClanskeUpdate,brojUplacenihMeseciUpdate,datumPoslednjeUplateUpdate,prijavljeniZaposleni) &&
  							!(Utils.JMBGClanstvoValidacijaClan(biblioteka.AktivniClanovi(), JMBGUpdate, brojClanskeUpdate,idClana))) {
					prijavljeniZaposleni.updateClan(idClana,imeUpdate,prezimeUpdate,JMBGUpdate,adresaUpdate,Pol.valueOf(cmbxPol.getSelectedItem().toString().trim()),brojClanskeUpdate,datumPoslednjeUplateUpdate,
							brojUplacenihMeseciUpdate,biblioteka.neobrisaneClanarine().get(cmbxOznakaClanarine.getSelectedIndex()),biblioteka);
					     
					
   			    	JOptionPane.showMessageDialog(rootPane, "Cena je: " + cena);

					dispose();
					ClanProzor cp = new ClanProzor(biblioteka,prijavljeniZaposleni);
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


