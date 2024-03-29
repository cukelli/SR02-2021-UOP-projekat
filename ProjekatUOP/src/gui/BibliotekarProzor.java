package gui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JToolBar;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import biblioteka.Administrator;
import biblioteka.Biblioteka;
import biblioteka.Bibliotekar;
import biblioteka.Zaposleni;

public class BibliotekarProzor extends JFrame {
	private JToolBar mainToolbar = new JToolBar();
	private JButton btnAdd = new JButton();
	private JButton btnEdit = new JButton();
	private JButton btnDelete = new JButton();
	

	private DefaultTableModel tableModel;
	private JTable bibliotekariTabela;
	private Zaposleni prijavljeniZaposleni;
	private Biblioteka biblioteka;
	
	public BibliotekarProzor(Biblioteka biblioteka,Zaposleni prijavljeniZaposleni) {
		this.biblioteka = biblioteka;
		this.prijavljeniZaposleni = prijavljeniZaposleni;
		setTitle("Bibliotekari");
		setSize(500, 300);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		initGUI();
		initActions();
	}
	
	private void initGUI() {
		ImageIcon addIcon = new ImageIcon(getClass().getResource("/slike/add.gif"));
		btnAdd.setIcon(addIcon);
		ImageIcon editIcon = new ImageIcon(getClass().getResource("/slike/edit.gif"));
		btnEdit.setIcon(editIcon);
		ImageIcon deleteIcon = new ImageIcon(getClass().getResource("/slike/remove.gif"));
		btnDelete.setIcon(deleteIcon);
		
		mainToolbar.add(btnAdd);
		mainToolbar.add(btnEdit);
		mainToolbar.add(btnDelete);
		add(mainToolbar, BorderLayout.NORTH);
		
		String[] zaglavlja = new String[] {"Ime","Prezime","ID","JMBG","Adresa","Pol","Plata","Korisnicko ime","Lozinka"};
		Object[][] sadrzaj = new Object[biblioteka.neobrisaniBibliotekari().size()][zaglavlja.length];
		
		
		for(int i=0; i<biblioteka.neobrisaniBibliotekari().size(); i++) {
			Bibliotekar bibliotekar = biblioteka.neobrisaniBibliotekari().get(i);
			sadrzaj[i][0] = bibliotekar.getIme();
			sadrzaj[i][1] = bibliotekar.getPrezime();
			sadrzaj[i][2] = bibliotekar.getIDOsobe();
			sadrzaj[i][3] = bibliotekar.getJMBG();
			sadrzaj[i][4] = bibliotekar.getAdresa();
			sadrzaj[i][5] = bibliotekar.getPol();
			sadrzaj[i][6] = bibliotekar.getPlata();
			sadrzaj[i][7] = bibliotekar.getKorIme();
			sadrzaj[i][8] = bibliotekar.getLozinka();
		}
		
		tableModel = new DefaultTableModel(sadrzaj, zaglavlja);
		bibliotekariTabela = new JTable(tableModel);
		

		bibliotekariTabela.setRowSelectionAllowed(true);
		bibliotekariTabela.setColumnSelectionAllowed(false);
		bibliotekariTabela.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		bibliotekariTabela.setDefaultEditor(Object.class, null);
		bibliotekariTabela.getTableHeader().setReorderingAllowed(false);
		
		JScrollPane scrollPane = new JScrollPane(bibliotekariTabela);
		add(scrollPane, BorderLayout.CENTER); }
	
	public void initActions() {
		btnEdit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(bibliotekariTabela.getSelectedRow() == -1) {
					JOptionPane.showMessageDialog(rootPane, "Izaberite bibliotekara za izmenu");
					return;
				}
				BibliotekarIzmenaProzor bp = new BibliotekarIzmenaProzor(biblioteka, prijavljeniZaposleni, bibliotekariTabela.getSelectedRow());
				bp.setVisible(true);
			}
				
			
		});
		
		btnAdd.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				DodajBibliotekaraProzor dp = new DodajBibliotekaraProzor(biblioteka, prijavljeniZaposleni);
				dp.setVisible(true);
			}
				
			
		});
		
		btnDelete.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(bibliotekariTabela.getSelectedRow() == -1) {
					JOptionPane.showMessageDialog(rootPane, "Izaberite bibliotekari za brisanje");
				
					return;
				}
				else {
				   Administrator admin = (Administrator) prijavljeniZaposleni;
				   Bibliotekar brisi =  biblioteka.neobrisaniBibliotekari().get(bibliotekariTabela.getSelectedRow());
				   if (!brisi.isObrisan()) {
					   try {
							admin.brisiBibliotekara(brisi.getIDOsobe(),biblioteka);
							tableModel.removeRow(bibliotekariTabela.getSelectedRow());
							
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
				   } else {
					JOptionPane.showMessageDialog(rootPane, "Korisnik je vec obrisan, ponovo otvirite aplikaciju.");					
					return;
				   }
	
				}
				
			}
			
				
			
		});
		
		
		
		
	}
}
