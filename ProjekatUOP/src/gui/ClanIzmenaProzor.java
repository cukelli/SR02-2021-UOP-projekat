package gui;

import java.nio.file.Files;

import java.time.LocalDate;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import biblioteka.Biblioteka;
import biblioteka.Clan;
import biblioteka.TipClanarine;
import biblioteka.Zaposleni;
import net.miginfocom.swing.MigLayout;

public class ClanIzmenaProzor extends JDialog {
	private JTextField brojClanske = new JTextField(20);
    private JLabel lblBrojClanske = new JLabel("Broj clanske");
    
    private JTextField datumPoslednjeUplate = new JTextField(20);
    private JLabel lblDatumPoslednjeUplate = new JLabel("Datum poslednje uplate");
    
    private JTextField brojUplacenihMeseci = new JTextField(20);
    private JLabel lblBrojUplacenihMeseci = new JLabel("Broj uplacenih meseci");
    
 
    private JLabel lblTipClanarine = new JLabel("Tip clanarine");
    private JComboBox<String> cmbxOznakaClanarine = new JComboBox<String>();

    
    private JButton dugmeIzmena = new JButton("Izmenite");
    
    private Biblioteka biblioteka;
    private Zaposleni prijavljeniZaposleni;
    private int index;
    
    
    
    
    
    
    public ClanIzmenaProzor(Biblioteka biblioteka,Zaposleni prijavljeniZaposleni,int index) {
    	this.biblioteka = biblioteka;
    	this.prijavljeniZaposleni = prijavljeniZaposleni;
    	setTitle("Zaposleni: " + prijavljeniZaposleni.getIDOsobe());
		setSize(500, 500);
		String[] clanarine = new String[biblioteka.neobrisaneClanarine().size()];
		for (int i=0; i<biblioteka.neobrisaneClanarine().size();i++) {
			TipClanarine tc = biblioteka.neobrisaneClanarine().get(i);
			clanarine[i] = tc.getTip();
			
		}
		
	    cmbxOznakaClanarine.setModel(new DefaultComboBoxModel<String>(clanarine));
   		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
     	initMenu();
//		initActions();
    }
     	
     	  private void initMenu() {
     	    	MigLayout mig = new MigLayout("wrap 2","[][]", "[]10[][]10[]");
     	    	setLayout(mig);
     	    	
     	    	add(lblBrojClanske);
     	    	add(brojClanske);
     	    	add(lblDatumPoslednjeUplate);
     	    	add(datumPoslednjeUplate);
     	      	add(lblBrojUplacenihMeseci);
     	    	add(brojUplacenihMeseci);
     	    	add(lblTipClanarine);
     	    	add(cmbxOznakaClanarine);
     	    	
     	 
     	    	add(dugmeIzmena);
     	    	
     	    	
     	    	
     	    	Clan c = biblioteka.AktivniClanovi().get(index);
     	    	brojClanske.setText(c.getBrojClanske());
     	    	datumPoslednjeUplate.setText(c.getDatumPoslednjeUplate().toString());
     	    	brojUplacenihMeseci.setText(Integer.toString(c.getBrojUplacenihMeseci()));
     	    	cmbxOznakaClanarine.setSelectedItem(c.getTipClanarine());
     	    	
     	    	
     	  
     	  
     	  }
    	
    } 


