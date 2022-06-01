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

import biblioteka.Biblioteka;
import biblioteka.Bibliotekar;
import biblioteka.Knjiga;

public class KnjigaProzor extends JFrame {
	private JToolBar mainToolbar = new JToolBar();
	private JButton btnAdd = new JButton();
	private JButton btnEdit = new JButton();
	private JButton btnDelete = new JButton();
	

	private DefaultTableModel tableModel;
	private JTable knjigeTabela;
	
	private Biblioteka biblioteka;
	public KnjigaProzor(Biblioteka biblioteka) {
		this.biblioteka = biblioteka;
		setTitle("Knjige");
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
		
		String[] zaglavlja = new String[] {"ID","Naslov","Originalni naslov","autor","Godina objavljivanja","Jezik originala","opis","zanr"};
		Object[][] sadrzaj = new Object[biblioteka.neobrisaniBibliotekari().size()][zaglavlja.length];
		
		
		for(int i=0; i<biblioteka.neobrisaneKnjige().size(); i++) {
			Knjiga knjiga = biblioteka.neobrisaneKnjige().get(i);
			sadrzaj[i][0] = knjiga.getIDKnjige();
			sadrzaj[i][1] = knjiga.getNaslov();
			sadrzaj[i][2] = knjiga.getOriginalniNaslov();
			sadrzaj[i][3] = knjiga.getAutor();
			sadrzaj[i][4] = knjiga.getGodinaObjavljivanja();
			sadrzaj[i][5] = knjiga.getJezikOriginala();
			sadrzaj[i][6] = knjiga.getOpis();
			sadrzaj[i][7] = knjiga.getZanr();
		
		}
		tableModel = new DefaultTableModel(sadrzaj, zaglavlja);
		knjigeTabela = new JTable(tableModel);
		

	    knjigeTabela.setRowSelectionAllowed(true);
		knjigeTabela.setColumnSelectionAllowed(false);
		knjigeTabela.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		knjigeTabela.setDefaultEditor(Object.class, null);
		knjigeTabela.getTableHeader().setReorderingAllowed(false);
		
		JScrollPane scrollPane = new JScrollPane(knjigeTabela);
		add(scrollPane, BorderLayout.CENTER); }
		
		
		private void initActions() {}
		
	
	}

