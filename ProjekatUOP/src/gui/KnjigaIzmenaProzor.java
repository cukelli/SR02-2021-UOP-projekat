package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.time.LocalDate;

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
import biblioteka.Pol;
import biblioteka.Zanr;
import biblioteka.Zaposleni;
import net.miginfocom.swing.MigLayout;
import utils.Utils;

public class KnjigaIzmenaProzor extends JDialog {
	
	private JTextField IDPolje = new JTextField(4);
    private JLabel lblID = new JLabel("ID");
	
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
    
    private JButton dugmeIzmena = new JButton("Izmenite");
    
    
    
    private Biblioteka biblioteka;
    private Zaposleni prijavljeniZaposleni;
    private int index;
    
    
    public KnjigaIzmenaProzor(Biblioteka biblioteka,Zaposleni prijavljeniZaposleni,int index) {
    	this.index = index;
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
    	
    	add(lblID);
    	add(IDPolje);
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
    	add(dugmeIzmena);
    	IDPolje.setEditable(false);
    	
    	Knjiga k = biblioteka.neobrisaneKnjige().get(index);
    	IDPolje.setText(Integer.toString(k.getIDKnjige()));
    	IDPolje.setEditable(false);
    	naslovPolje.setText(k.getNaslov());
        originalniNaslov.setText(k.getOriginalniNaslov());
        godinaObjavljivanja.setText(Integer.toString(k.getGodinaObjavljivanja()));
        cmbxJezik.setSelectedItem(k.getJezikOriginala());
        opis.setText(k.getOpis());
        cmbxZanr.setSelectedItem(k.getZanr().getOznaka());
        autor.setText(k.getAutor());
        
        
        
    }
    
    private void initActions() {
   		dugmeIzmena.addActionListener(new ActionListener() {
   			@Override
  			public void actionPerformed(ActionEvent e) {
  				try {
  					
  					String naslovIzmeni = naslovPolje.getText().trim();
					String originalniNaslovIzmeni = originalniNaslov.getText().trim();
					String autorIzmeni = autor.getText().trim();
					int godinaObjavljivanjaIzmeni = Integer.parseInt(godinaObjavljivanja.getText().trim());
					String opisIzmeni = opis.getText().trim();
					
					
					if (Utils.validirajKnjigu(naslovIzmeni, originalniNaslovIzmeni, autorIzmeni, godinaObjavljivanjaIzmeni, opisIzmeni)) {
					
					prijavljeniZaposleni.updateKnjigu(Integer.parseInt(IDPolje.getText().trim()),naslovIzmeni,originalniNaslovIzmeni,autorIzmeni,godinaObjavljivanjaIzmeni,Jezik.valueOf(cmbxJezik.getSelectedItem().toString().trim()),opisIzmeni,biblioteka.neobrisaniZanrovi().get(cmbxZanr.getSelectedIndex()),biblioteka);
					dispose();
					KnjigaProzor kp = new KnjigaProzor(biblioteka,prijavljeniZaposleni);
					kp.setVisible(true);
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
