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
import biblioteka.Primerak;
import biblioteka.Zaposleni;

public class PrimerakProzor extends JFrame {

	private JToolBar mainToolbar = new JToolBar();
	private JButton btnAdd = new JButton();
	private JButton btnEdit = new JButton();
	private JButton btnDelete = new JButton();
	
	private DefaultTableModel tableModel;
	private JTable primerciTabela;
	
	private Zaposleni prijavljeniZaposleni;
	private Biblioteka biblioteka;
	
	public PrimerakProzor(Biblioteka biblioteka,Zaposleni prijavljeniZaposleni) {
		this.prijavljeniZaposleni = prijavljeniZaposleni;
 		this.biblioteka = biblioteka;
		setTitle("Primerci");
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
		
		String[] zaglavlja = new String[] {"ID","Knjiga","Broj strana","Godina stampe","Jezik stampe","Povez"};
		Object[][] sadrzaj = new Object[biblioteka.neobrisaniPrimerci().size()][zaglavlja.length];
		
		for(int i=0; i <(biblioteka.sviNeiznajmljeniPrimerci().size()); i++) {
		    Primerak primerak = biblioteka.sviNeiznajmljeniPrimerci().get(i);
			sadrzaj[i][0] = primerak.getIDPrimerka();
			sadrzaj[i][1] = primerak.getKnjiga().getIDKnjige();
			sadrzaj[i][2] = primerak.getBrojStrana();
			sadrzaj[i][3] = primerak.getGodinaStampe();
			sadrzaj[i][4] = primerak.getJezikStampe();
			sadrzaj[i][5] = primerak.getPovez();
		
		}
		

		tableModel = new DefaultTableModel(sadrzaj, zaglavlja);
		primerciTabela = new JTable(tableModel);
		
		primerciTabela.setRowSelectionAllowed(true);
		primerciTabela.setColumnSelectionAllowed(false);
		primerciTabela.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		primerciTabela.setDefaultEditor(Object.class, null);
		primerciTabela.getTableHeader().setReorderingAllowed(false);
		
		JScrollPane scrollPane = new JScrollPane(primerciTabela);
		add(scrollPane, BorderLayout.CENTER); }
		
		
		private void initActions() {
			btnEdit.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					if(primerciTabela.getSelectedRow() == -1) {
						JOptionPane.showMessageDialog(rootPane, "Izaberite primerak za izmenu");
						return;
					}
					AdminIzmenaProzor ap = new AdminIzmenaProzor(biblioteka, prijavljeniZaposleni, primerciTabela.getSelectedRow());
					ap.setVisible(true);
				}
					
				
			});
			btnAdd.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					
					DodajPrimerakProzor dpr = new DodajPrimerakProzor(biblioteka, prijavljeniZaposleni);
					dpr.setVisible(true);
				}
					
				
			});
			
			btnDelete.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					if(primerciTabela.getSelectedRow() == -1) {
						JOptionPane.showMessageDialog(rootPane, "Izaberite primerak za brisanje");
					
						return;
					}
					else {
					   Primerak brisi =  biblioteka.neobrisaniPrimerci().get(primerciTabela.getSelectedRow());
					   if (!brisi.isObrisan()) {
						   try {
								prijavljeniZaposleni.brisiPrimerak(brisi.getIDPrimerka(),biblioteka);
								tableModel.removeRow(primerciTabela.getSelectedRow());
								
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
					   } else {
						JOptionPane.showMessageDialog(rootPane, "Primerak je vec obrisan, ponovo otvirite aplikaciju.");					
						return;
					   }
		
					}
					
				}
				
					
				
			});
			
		}
	}


