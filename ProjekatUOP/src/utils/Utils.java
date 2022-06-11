package utils;

import javax.swing.JOptionPane;

import biblioteka.Administrator;

public class Utils {

	public static boolean validirajAdmin(String ime, String prezime, String jmbg,
										 String adresa, double plata, String koris, 
										 String pass, Administrator admin) {
		
		StringBuilder sb = new StringBuilder();
		boolean ok = true;
		if (ime.equals("")) {
			sb.append("\nIme");
			ok = false;
		}
		if (prezime.equals("")) {
			sb.append("\nPrezime");
			ok = false;
		}
		if (jmbg.equals("") || jmbg.length() != 13 || !jmbg.matches("\\d{13}")) {
			sb.append("\nJmbg");
			ok = false;
		}
		if (plata <= 0) {
			sb.append("\nPlata");
			ok = false;
		}
		
		if (koris.equals("")) {
			sb.append("\nKorisnicko ime");
			ok = false;
		}
		
		if (pass.equals("") || pass.length() < 8) {
			sb.append("\nLozinka");
			ok = false;
		}
		
		if(ok == false) {
			JOptionPane.showMessageDialog(null, sb.toString(), "Neispravni podaci", JOptionPane.WARNING_MESSAGE);
		}
		return ok;
	}
}
