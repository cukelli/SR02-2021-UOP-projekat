package gui;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JToolBar;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import java.awt.BorderLayout;

import biblioteka.Administrator;
import biblioteka.Biblioteka;

public class AdminProzor extends JFrame {
	

	private JToolBar mainToolbar = new JToolBar();
	private JButton btnAdd = new JButton();
	private JButton btnEdit = new JButton();
	private JButton btnDelete = new JButton();
	

	private DefaultTableModel tableModel;
	private JTable adminiTabela;
	
	private Biblioteka biblioteka;
	
	public AdminProzor(Biblioteka biblioteka) {
		this.biblioteka = biblioteka;
		setTitle("Administratori");
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
		Object[][] sadrzaj = new Object[biblioteka.neobrisaniAdministratori().size()][zaglavlja.length];
		
		for(int i=0; i<biblioteka.neobrisaniAdministratori().size(); i++) {
			Administrator admin = biblioteka.neobrisaniAdministratori().get(i);
			sadrzaj[i][0] = admin.getIme();
			sadrzaj[i][1] = admin.getPrezime();
			sadrzaj[i][2] = admin.getIDOsobe();
			sadrzaj[i][3] = admin.getJMBG();
			sadrzaj[i][4] = admin.getAdresa();	
			sadrzaj[i][5] = admin.getPol();
			sadrzaj[i][6] = admin.getPlata();
			sadrzaj[i][7] = admin.getKorIme();
			sadrzaj[i][8] = admin.getLozinka();
		}
		
		tableModel = new DefaultTableModel(sadrzaj, zaglavlja);
		adminiTabela = new JTable(tableModel);
		
		adminiTabela.setRowSelectionAllowed(true);
		adminiTabela.setColumnSelectionAllowed(false);
		adminiTabela.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		adminiTabela.setDefaultEditor(Object.class, null);
		adminiTabela.getTableHeader().setReorderingAllowed(false);
		
		JScrollPane scrollPane = new JScrollPane(adminiTabela);
		add(scrollPane, BorderLayout.CENTER); }
		
		
		private void initActions() {}
		

}
