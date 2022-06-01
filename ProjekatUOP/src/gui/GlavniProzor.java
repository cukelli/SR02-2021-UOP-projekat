package gui;

import java.awt.event.ActionEvent;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import biblioteka.Administrator;
import biblioteka.Biblioteka;
import biblioteka.Zaposleni;

public class GlavniProzor extends JFrame {
	
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
		zaposleniMenu.add(administratorItem);
		zaposleniMenu.add(bibliotekarItem);
		this.biblioteka = biblioteka;
		this.prijavljenZaposleni = prijavljeniZaposleni;
		setTitle("Admin: " + prijavljeniZaposleni.getIDOsobe());
		setSize(500, 500);
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		initMenu();
		initActions();
	}
	
	private void initMenu() {
		setJMenuBar(mainMenu);
		mainMenu.add(zaposleniMenu);
		mainMenu.add(clanarineItem);
		mainMenu.add(knjigeItem);
		mainMenu.add(iznajmljivanjeItem);
		mainMenu.add(primerakItem);
		mainMenu.add(clanItem);
		mainMenu.add(zanroviItem);


	}
	private void initActions() {
		administratorItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			AdminProzor adminProzor = new AdminProzor(biblioteka);
				adminProzor.setVisible(true);
			}
		});
		
	bibliotekarItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			BibliotekarProzor bibliotekarProzor = new BibliotekarProzor(biblioteka);
				bibliotekarProzor.setVisible(true);
			}
		});
	
	clanItem.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
		ClanProzor clanProzor = new ClanProzor(biblioteka);
			clanProzor.setVisible(true);
		}
	});
	
	iznajmljivanjeItem.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
		IznajmljivanjeProzor iznajmljivanjeProzor = new IznajmljivanjeProzor(biblioteka);
			iznajmljivanjeProzor.setVisible(true);
		}
	});
	
	knjigeItem.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
		KnjigaProzor knjigaProzor = new KnjigaProzor(biblioteka);
			knjigaProzor.setVisible(true);
		}
	});
	
	primerakItem.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
		PrimerakProzor primerakProzor = new PrimerakProzor(biblioteka);
			primerakProzor.setVisible(true);
		}
	});
	
	clanarineItem.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
		TipClanarineProzor clanarinaProzor = new TipClanarineProzor(biblioteka);
			clanarinaProzor.setVisible(true);
		}
	});
	
	zanroviItem.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
		ZanrProzor zanrProzor = new ZanrProzor(biblioteka);
			zanrProzor.setVisible(true);
		}
	});
		
	}
}


