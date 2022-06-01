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
import biblioteka.TipClanarine;
import biblioteka.Zanr;

public class ZanrProzor extends JFrame {
	
	private JToolBar mainToolbar = new JToolBar();
	private JButton btnAdd = new JButton();
	private JButton btnEdit = new JButton();
	private JButton btnDelete = new JButton();
	
	private DefaultTableModel tableModel;
	private JTable zanroviTabela;
	
	private Biblioteka biblioteka;
	
	public ZanrProzor(Biblioteka biblioteka) {
		this.biblioteka = biblioteka;
		setTitle("Zanrovi");
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
		
		String[] zaglavlja = new String[] {"Oznaka","Opis","ID"};
		Object[][] sadrzaj = new Object[biblioteka.neobrisaniZanrovi().size()][zaglavlja.length];
		
		for(int i=0; i<biblioteka.neobrisaniZanrovi().size(); i++) {
		    Zanr zanr = biblioteka.neobrisaniZanrovi().get(i);
			sadrzaj[i][0] = zanr.getOznaka();
			sadrzaj[i][1] = zanr.getOpis();
			sadrzaj[i][2] = zanr.getIDZanra();
		
		}
		tableModel = new DefaultTableModel(sadrzaj, zaglavlja);
		zanroviTabela = new JTable(tableModel);
		
	    zanroviTabela.setRowSelectionAllowed(true);
		zanroviTabela.setColumnSelectionAllowed(false);
		zanroviTabela.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		zanroviTabela.setDefaultEditor(Object.class, null);
		zanroviTabela.getTableHeader().setReorderingAllowed(false);
		
		JScrollPane scrollPane = new JScrollPane(zanroviTabela);
		add(scrollPane, BorderLayout.CENTER); }

		
		private void initActions() {}

}
	

