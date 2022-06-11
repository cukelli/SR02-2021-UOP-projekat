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
import biblioteka.Bibliotekar;
import biblioteka.Iznajmljivanje;
import biblioteka.Zaposleni;

public class IznajmljivanjeProzor extends JFrame {
	private JToolBar mainToolbar = new JToolBar();
	private JButton btnAdd = new JButton();
	private JButton btnEdit = new JButton();
	private JButton btnDelete = new JButton();
	

	private DefaultTableModel tableModel;
	private JTable iznajmljivanjeTabela;
	
	private Zaposleni prijavljenZaposleni;
	private Biblioteka biblioteka;
	
	public IznajmljivanjeProzor(Biblioteka biblioteka,Zaposleni prijavljenZaposleni) {
		this.prijavljenZaposleni = prijavljenZaposleni;
		this.biblioteka = biblioteka;
		setTitle("Iznajmljivanje");
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
		
		String[] zaglavlja = new String[] {"ID","Bibliotekar","Clan","Datum iznajmljivanja","Datum vracanja","iznajmljen Primerak"};
		Object[][] sadrzaj = new Object[biblioteka.neobrisanaIznajmljivanja().size()][zaglavlja.length];
		
		for(int i=0; i<biblioteka.neobrisanaIznajmljivanja().size(); i++) {
			Iznajmljivanje iznajmljivanje = biblioteka.neobrisanaIznajmljivanja().get(i);
			sadrzaj[i][0] = iznajmljivanje.getIDIznajmljivanja();
			sadrzaj[i][1] = iznajmljivanje.getBibliotekar().getIDOsobe();
			sadrzaj[i][2] = iznajmljivanje.getClan().getIDOsobe();
			sadrzaj[i][3] = iznajmljivanje.getDatumIznajmljivanja();
			sadrzaj[i][4] = iznajmljivanje.getDatumVracanja();
			sadrzaj[i][5] = iznajmljivanje.getIznajmljenPrimerak().getIDPrimerka();
			
		
		}
		

	tableModel = new DefaultTableModel(sadrzaj, zaglavlja);
	iznajmljivanjeTabela = new JTable(tableModel);
	

	iznajmljivanjeTabela.setRowSelectionAllowed(true);
	iznajmljivanjeTabela.setColumnSelectionAllowed(false);
	iznajmljivanjeTabela.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	iznajmljivanjeTabela.setDefaultEditor(Object.class, null);
	iznajmljivanjeTabela.getTableHeader().setReorderingAllowed(false);
	
	JScrollPane scrollPane = new JScrollPane(iznajmljivanjeTabela);
	add(scrollPane, BorderLayout.CENTER); 
	}
	
	
	private void initActions() {
		btnEdit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(iznajmljivanjeTabela.getSelectedRow() == -1) {
					JOptionPane.showMessageDialog(rootPane, "Izaberite clana za izmenu");
					return;
				}
				IznajmljivanjeIzmenaProzor ip = new IznajmljivanjeIzmenaProzor(biblioteka, prijavljenZaposleni, iznajmljivanjeTabela.getSelectedRow());
				ip.setVisible(true);
			}
				
			
		});
		
	
	btnAdd.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			
			DodajIznajmljivanjeProzor dp = new DodajIznajmljivanjeProzor(biblioteka, prijavljenZaposleni);
			dp.setVisible(true);
		}
			
		
	});
}
}
