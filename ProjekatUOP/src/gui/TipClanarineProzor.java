package gui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JToolBar;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import biblioteka.Biblioteka;
import biblioteka.Primerak;
import biblioteka.TipClanarine;
import biblioteka.Zanr;
import biblioteka.Zaposleni;

public class TipClanarineProzor extends JFrame {
	
	private JToolBar mainToolbar = new JToolBar();
	private JButton btnAdd = new JButton();
	private JButton btnEdit = new JButton();
	private JButton btnDelete = new JButton();
	
	private DefaultTableModel tableModel;
	private JTable clanarineTabela;
	private Zaposleni prijavljeniZaposleni;
	
	private Biblioteka biblioteka;
	
	public TipClanarineProzor(Biblioteka biblioteka,Zaposleni prijavljeniZaposleni) {
		this.biblioteka = biblioteka;
		this.prijavljeniZaposleni = prijavljeniZaposleni;
		setTitle("Clanarine");
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
		
		String[] zaglavlja = new String[] {"Tip","Cena","ID"};
		Object[][] sadrzaj = new Object[biblioteka.neobrisanaIznajmljivanja().size()][zaglavlja.length];
		
		for(int i=0; i<biblioteka.neobrisaneClanarine().size(); i++) {
		    TipClanarine tipClanarine = biblioteka.neobrisaneClanarine().get(i);
			sadrzaj[i][0] = tipClanarine.getTip();
			sadrzaj[i][1] = tipClanarine.getCena();
			sadrzaj[i][2] = tipClanarine.getIDClanarine();
		
		}
		
		tableModel = new DefaultTableModel(sadrzaj, zaglavlja);
		clanarineTabela = new JTable(tableModel);
		
	    clanarineTabela.setRowSelectionAllowed(true);
		clanarineTabela.setColumnSelectionAllowed(false);
		clanarineTabela.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		clanarineTabela.setDefaultEditor(Object.class, null);
		clanarineTabela.getTableHeader().setReorderingAllowed(false);
		
		JScrollPane scrollPane = new JScrollPane(clanarineTabela);
		add(scrollPane, BorderLayout.CENTER); }

		
		private void initActions() {
			btnEdit.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					if(clanarineTabela.getSelectedRow() == -1) {
						JOptionPane.showMessageDialog(rootPane, "Izaberite clanarinu za izmenu");
						return;
					}
					ClanarinaIzmenaProzor cp = new ClanarinaIzmenaProzor(biblioteka, prijavljeniZaposleni, clanarineTabela.getSelectedRow());
					cp.setVisible(true);
				}
					
				
			});
				
		
		btnAdd.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				DodajClanarinuProzor dc = new DodajClanarinuProzor(biblioteka, prijavljeniZaposleni);
				dc.setVisible(true);
			}
				
			
		});

}
}
