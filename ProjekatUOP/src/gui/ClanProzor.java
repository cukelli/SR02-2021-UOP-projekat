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
import biblioteka.Clan;
import biblioteka.Zaposleni;

public class ClanProzor extends JFrame {
	

	private JToolBar mainToolbar = new JToolBar();
	private JButton btnAdd = new JButton();
	private JButton btnEdit = new JButton();
	private JButton btnDelete = new JButton();
	
	private DefaultTableModel tableModel;
	private JTable clanoviTabela;
	private Zaposleni prijavljeniZaposleni;
	
	private Biblioteka biblioteka;
	
	public ClanProzor(Biblioteka biblioteka,Zaposleni prijavljeniZaposleni) {
		this.prijavljeniZaposleni = prijavljeniZaposleni;
		this.biblioteka = biblioteka;
		setTitle("Clanovi");
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
		
		String[] zaglavlja = new String[] {"ID","Ime","Prezime","JMBG","Adresa","Pol","Broj clanske","Datum poslednje uplate","Broj uplacenih meseci","Tip clanarine"};
		Object[][] sadrzaj = new Object[biblioteka.neobrisaniClanovi().size()][zaglavlja.length];
		
		for(int i=0; i<biblioteka.neobrisaniClanovi().size(); i++) {
		    Clan clan = biblioteka.neobrisaniClanovi().get(i);
			sadrzaj[i][0] = clan.getIDOsobe();
			sadrzaj[i][1] = clan.getIme();
			sadrzaj[i][2] = clan.getPrezime();
			sadrzaj[i][3] = clan.getJMBG();
			sadrzaj[i][4] = clan.getAdresa();
			sadrzaj[i][5] = clan.getPol();
			sadrzaj[i][6] = clan.getBrojClanske();
			sadrzaj[i][7] = clan.getDatumPoslednjeUplate();
			sadrzaj[i][8] = clan.getBrojUplacenihMeseci();
            sadrzaj[i][9] = clan.getTipClanarine();
		}
		

		tableModel = new DefaultTableModel(sadrzaj, zaglavlja);
		clanoviTabela = new JTable(tableModel);
		
		clanoviTabela.setRowSelectionAllowed(true);
		clanoviTabela.setColumnSelectionAllowed(false);
		clanoviTabela.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		clanoviTabela.setDefaultEditor(Object.class, null);
		clanoviTabela.getTableHeader().setReorderingAllowed(false);
		
		JScrollPane scrollPane = new JScrollPane(clanoviTabela);
		add(scrollPane, BorderLayout.CENTER); }
		
		
		private void initActions() {
		btnEdit.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			if(clanoviTabela.getSelectedRow() == -1) {
				JOptionPane.showMessageDialog(rootPane, "Izaberite clana za izmenu");
				return;
			}
			ClanIzmenaProzor cp = new ClanIzmenaProzor(biblioteka, prijavljeniZaposleni, clanoviTabela.getSelectedRow());
			cp.setVisible(true);
		}
			
		
	});
			

		btnAdd.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				DodajClanaProzor dc = new DodajClanaProzor(biblioteka, prijavljeniZaposleni);
				dc.setVisible(true);
			}
				
			
		});
		
		btnDelete.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(clanoviTabela.getSelectedRow() == -1) {
					JOptionPane.showMessageDialog(rootPane, "Izaberite clana za brisanje");
				
					return;
				}
				else {
				  
				   Clan brisi =  biblioteka.neobrisaniClanovi().get(clanoviTabela.getSelectedRow());
				   if (!brisi.isObrisan()) {
					   try {
							prijavljeniZaposleni.brisiClana(brisi.getIDOsobe(),biblioteka);
							tableModel.removeRow(clanoviTabela.getSelectedRow());
							
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
				   } else {
					JOptionPane.showMessageDialog(rootPane, "Clan je vec obrisan, ponovo otvirite aplikaciju.");					
					return;
				   }
	
				}
				
			}
			
				
			
		});
		

}
	

}

