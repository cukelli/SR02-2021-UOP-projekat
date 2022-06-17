package gui;

import java.awt.event.ActionEvent;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextField;

import java.awt.event.ActionListener;
import java.io.IOException;

import biblioteka.Administrator;
import biblioteka.Biblioteka;
import biblioteka.Jezik;
import biblioteka.Povez;
import biblioteka.Zaposleni;
import net.miginfocom.swing.MigLayout;
import utils.Utils;

public class GlavniProzor extends JFrame {
	
	JTextField bibliotekaID = new JTextField(20);
    JLabel lblID = new JLabel("ID biblioteke");
	
	JTextField bibliotekaNazivPolje = new JTextField(20);
    JLabel lblNaziv = new JLabel("Naziv biblioteke");
    
    JTextField adresaBiblioteke = new JTextField(20);
    JLabel lblAdresa = new JLabel("Adresa");
    
    JTextField telefonBiblioteke = new JTextField(20);
    JLabel lblTelefon = new JLabel("Telefon");
    
    JTextField radnoVremeBiblioteke = new JTextField(20);
    JLabel lblRadnoVreme = new JLabel("Radno vreme");
    
	private JButton btnIzmeni = new JButton("Izmeni");

    
	
	
	private JMenuBar mainMenu = new JMenuBar();
	private JMenu zaposleniMenu = new JMenu("Zaposleni");
	private JMenuItem administratorItem = new JMenuItem("Administrator");
	private JMenuItem bibliotekarItem = new JMenuItem("Bibliotekari");
	private JMenuItem clanarineItem = new JMenuItem("Clanarine");
	private JMenuItem knjigeItem = new JMenuItem("Knjige");
	private JMenuItem iznajmljivanjeItem = new JMenuItem("Iznajmljivanja");
	private JMenuItem primerakItem = new JMenuItem("Primerci");
	private JMenuItem clanItem = new JMenuItem("Clanovi");
	private JMenuItem zanroviItem = new JMenuItem("Zanrovi");
	
	private Biblioteka biblioteka;
	private Zaposleni prijavljenZaposleni;
	
	public GlavniProzor(Biblioteka biblioteka,Zaposleni prijavljeniZaposleni) {
//		zaposleniMenu.add(administratorItem);
//		zaposleniMenu.add(bibliotekarItem);
		this.biblioteka = biblioteka;
		this.prijavljenZaposleni = prijavljeniZaposleni;
		setTitle("Zaposleni: " + prijavljeniZaposleni.getIDOsobe());
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

		
		setJMenuBar(mainMenu);
	//	mainMenu.add(zaposleniMenu);
		mainMenu.add(clanarineItem);
		mainMenu.add(knjigeItem);
	//	mainMenu.add(iznajmljivanjeItem);
		mainMenu.add(primerakItem);
		mainMenu.add(clanItem);
		mainMenu.add(zanroviItem);
		add(lblID);
		add(bibliotekaID);
		add(lblNaziv);
		add(bibliotekaNazivPolje);
		add(lblAdresa);
		add(adresaBiblioteke);
		add(lblTelefon);
		add(telefonBiblioteke);
		add(lblRadnoVreme);
		add(radnoVremeBiblioteke);
		add(btnIzmeni);
		
		
		bibliotekaID.setText(Integer.toString(biblioteka.getID()));
		bibliotekaNazivPolje.setText(biblioteka.getNaziv());
		adresaBiblioteke.setText(biblioteka.getAdresa());
	    telefonBiblioteke.setText(biblioteka.getTelefon());
	    radnoVremeBiblioteke.setText(biblioteka.getRadnoVreme());
	    
		

	}
	private void initActions() {
		administratorItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			AdminProzor adminProzor = new AdminProzor(biblioteka,prijavljenZaposleni);
				adminProzor.setVisible(true);
			}
		});
		
	bibliotekarItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			BibliotekarProzor bibliotekarProzor = new BibliotekarProzor(biblioteka,prijavljenZaposleni);
				bibliotekarProzor.setVisible(true);
			}
		});
	
	clanItem.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
		ClanProzor clanProzor = new ClanProzor(biblioteka,prijavljenZaposleni);
			clanProzor.setVisible(true);
		}
	});
	
	iznajmljivanjeItem.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
		IznajmljivanjeProzor iznajmljivanjeProzor = new IznajmljivanjeProzor(biblioteka,prijavljenZaposleni);
			iznajmljivanjeProzor.setVisible(true);
		}
	});
	
	knjigeItem.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
		KnjigaProzor knjigaProzor = new KnjigaProzor(biblioteka,prijavljenZaposleni);
			knjigaProzor.setVisible(true);
		}
	});
	
	primerakItem.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
		PrimerakProzor primerakProzor = new PrimerakProzor(biblioteka,prijavljenZaposleni);
			primerakProzor.setVisible(true);
		}
	});
	
	clanarineItem.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
		TipClanarineProzor clanarinaProzor = new TipClanarineProzor(biblioteka,prijavljenZaposleni);
			clanarinaProzor.setVisible(true);
		}
	});
	
	zanroviItem.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
		ZanrProzor zanrProzor = new ZanrProzor(biblioteka,prijavljenZaposleni);
			zanrProzor.setVisible(true);
		}
		
		
	});
	
	if (prijavljenZaposleni.getIDOsobe() >=300  && prijavljenZaposleni.getIDOsobe() <= 500) {
		bibliotekaID.setEditable(false);
		bibliotekaNazivPolje.setEditable(false);
		adresaBiblioteke.setEditable(false);
		telefonBiblioteke.setEditable(false);
		radnoVremeBiblioteke.setEditable(false);
		mainMenu.add(iznajmljivanjeItem);
		
		btnIzmeni.setEnabled(false);
	}
	
	if (prijavljenZaposleni.getIDOsobe() >= 1  && prijavljenZaposleni.getIDOsobe() <= 100) {
		mainMenu.add(zaposleniMenu);
		bibliotekaID.setEditable(false);
		zaposleniMenu.add(administratorItem);
		zaposleniMenu.add(bibliotekarItem);
	}
	
	btnIzmeni.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					int IDBiblioteke = Integer.parseInt(bibliotekaID.getText().trim());
					String nazivBibliotekeIzmena = bibliotekaNazivPolje.getText().trim();
					String adresaBibliotekeIzmena = adresaBiblioteke.getText().trim();
					String telefonBibliotekeIzmena = telefonBiblioteke.getText().trim();
					String radnoVremeBibliotekeIzmena = radnoVremeBiblioteke.getText().trim();
					
					Administrator admin = (Administrator) prijavljenZaposleni;
					
					if (Utils.validirajBiblioteku(nazivBibliotekeIzmena, adresaBibliotekeIzmena, telefonBibliotekeIzmena, radnoVremeBibliotekeIzmena)) {
						System.out.println("Valdacija uspesna");
						admin.updateBiblioteku(nazivBibliotekeIzmena, radnoVremeBibliotekeIzmena, telefonBibliotekeIzmena,adresaBibliotekeIzmena,biblioteka);
						
			dispose();
			GlavniProzor gp = new GlavniProzor(biblioteka,admin);
			gp.setVisible(true);
				} else {
					System.out.println(biblioteka.getAdresa());
				}
		} catch (NumberFormatException e1) {
				
				e1.printStackTrace();
			} catch (IOException e1) {
				
				e1.printStackTrace();
			}
			
			
				
				
			}
		});
	
	
		
	}
}


