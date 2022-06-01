package gui;

import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JToolBar;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import biblioteka.Administrator;
import biblioteka.Biblioteka;
import biblioteka.Bibliotekar;

public class BibliotekarProzor extends JFrame {
	private JToolBar mainToolbar = new JToolBar();
	private JButton btnAdd = new JButton();
	private JButton btnEdit = new JButton();
	private JButton btnDelete = new JButton();
	

	private DefaultTableModel tableModel;
	private JTable bibliotekariTabela;
	
	private Biblioteka biblioteka;
	
	public BibliotekarProzor(Biblioteka biblioteka) {
		this.biblioteka = biblioteka;
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
		
		
		private void initActions() {}

}
