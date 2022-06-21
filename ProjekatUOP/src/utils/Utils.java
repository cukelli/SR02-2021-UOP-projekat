package utils;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import biblioteka.Administrator;
import biblioteka.TipClanarine;
import biblioteka.Zaposleni;
import biblioteka.Biblioteka;
import biblioteka.Bibliotekar;
import biblioteka.Clan;
import biblioteka.Iznajmljivanje;
import biblioteka.Knjiga;
import biblioteka.Primerak;

public class Utils {

	public static boolean validirajZaposlenog(String ime, String prezime, String jmbg,
										 String adresa, double plata, String koris, 
										 String pass, Administrator admin) {
		
		StringBuilder sb = new StringBuilder();
		boolean ok = true;
		if (ime.equals("")  || !ime.matches("[A-Z][a-zA-Z]*")) {
			sb.append("\nIme ne sadrzi brojeve i specijalne karaktere,i nije prazno");
			ok = false;
		}
		if (prezime.equals("")  || !prezime.matches("[A-Z][a-zA-Z]*")) {
			sb.append("\nPrezime ne sadrzi brojeve i specijalne karaktere,i nije prazno");
			ok = false;
		}
		if (jmbg.equals("") || jmbg.length() != 13 || !jmbg.matches("\\d{13}")) {
			sb.append("\nJmbg sadrzi 13 cifara!");
			ok = false;
		}
		if (plata <= 0 ) {
			sb.append("\nPlata je pozitivna vrednost!");
			ok = false;
		}
		
		if (koris.equals("") || koris.length() < 5) {
			sb.append("\nKorisnicko ime sadrzi barem 5 karaktera");
			ok = false;
		}
		
		if (pass.equals("") || !pass.matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{8,20}$")) {
			sb.append("\nLozinka sadrzi izmedju 8 i 20 cifara,jedno veliko i jedno malo slovo i min jedan broj");
			ok = false;
		}
		
		if(ok == false) {
			JOptionPane.showMessageDialog(null, sb.toString(), "Neispravni podaci", JOptionPane.WARNING_MESSAGE);
		}
		return ok;
	}
	
	public static boolean validirajClana(String ime,String prezime,String JMBG,String adresa,String brojClanske,int brojUplacenihMeseci,LocalDate datumPoslednjeUplate,Zaposleni zaposleni) {
		StringBuilder sb = new StringBuilder();
		boolean ok = true;
		if (ime.equals("")  || !ime.matches("[A-Z][a-zA-Z]*")) {
			sb.append("\nIme");
			ok = false;
		}
		if (prezime.equals("")  || !prezime.matches("[A-Z][a-zA-Z]*")) {
			sb.append("\nPrezime");
			ok = false;
		}
		if (JMBG.equals("") || JMBG.length() != 13 || !JMBG.matches("\\d{13}")) {
			sb.append("\nJmbg ima 13 cifara!");
			ok = false;
		}
		
		if (adresa.equals("") || !adresa.matches(".*\\d+.*")) { //barem 1 broj
			sb.append("\nAdresa ima barem 1 broj");
			ok = false;
		}
		
		if (brojClanske.equals("") || !brojClanske.matches("^\\d+$")) {
			sb.append("\nBroj clanske karte sadrzi samo cifre");
			ok = false;
		}
		
		if (brojUplacenihMeseci <0) {
			sb.append("\nBroj uplacenih meseci ne moze biti negativan broj");
			ok = false;
		}
		
		if (datumPoslednjeUplate.isAfter(LocalDate.now())) {
			sb.append("\n Datum poslednje uplate ne moze biti posle danasnjeg datuma");
			ok=false;
		}
		if(ok == false) {
			JOptionPane.showMessageDialog(null, sb.toString(), "Neispravni podaci", JOptionPane.WARNING_MESSAGE);
		}
		
		
		
		return ok;
	}
	
	
	public static boolean validirajIznajmljivanje(LocalDate datumIznajmljivanja,LocalDate datumVracanja) {
		StringBuilder sb = new StringBuilder();
		boolean ok = true;
		
		if (datumIznajmljivanja.isAfter(datumVracanja)) {
			sb.append("\nDatumi se ne poklapaju,unesite ponovo");
			ok=false;
		}
		if(ok == false) {
			JOptionPane.showMessageDialog(null, sb.toString(), "Neispravni podaci", JOptionPane.WARNING_MESSAGE);
		}
		
		
		return ok;
	}
	
	public static boolean validirajKnjigu(String naslov,String originalniNaslov,String autor,int godinaObjavljivanja,String opis) {
     StringBuilder sb = new StringBuilder();
     boolean ok = true;
	
     
       if (naslov.equals("")) {
    	   sb.append("\nNaslov knjige");
    	   ok = false;
       }
       if (originalniNaslov.equals("")) {
    	   sb.append("\nOriginalni naslov knjige");
    	   ok = false;
       }
       
       if ( autor.equals("") || !autor.matches("^([a-zA-Z]{2,}\\s[a-zA-Z]{1,}'?-?[a-zA-Z]{2,}\\s?([a-zA-Z]{1,})?)")) {
         sb.append("\nAutor u sebi ne sadrzi karaktere");
         ok = false;
          
       }
       
       if (godinaObjavljivanja > 2022) {
    	   sb.append("\nGodina objavljivanja ne moze biti veca od tekuce");
    	   ok = false;
       }
       
       if (opis.equals("")) {
    	   sb.append("\nOpis");
    	   ok = false;
       }
       if(ok == false) {
			JOptionPane.showMessageDialog(null, sb.toString(), "Neispravni podaci", JOptionPane.WARNING_MESSAGE);
		}
		return ok;
	}
	
	public static boolean validirajPrimerak(int brojStrana,int godinaStampe) {
		StringBuilder sb = new StringBuilder();
		boolean ok = true;
		
		if (brojStrana <= 0) {
			sb.append("\nBroj strana nije negativan");
			ok = false;
		}
		if (godinaStampe <= 0) {
			sb.append("\nGodina stampe nije negativna");
			ok = false;
		}
		if(ok == false) {
			JOptionPane.showMessageDialog(null, sb.toString(), "Neispravni podaci", JOptionPane.WARNING_MESSAGE);
		}
		return ok;
	}
	
	public static boolean validirajTipClanarine(String tip,int cena) {
		StringBuilder sb = new StringBuilder();
		boolean ok = true;
		
		if (tip.equals("")) {
			sb.append("\nTip ne sme biti prazan");
			ok = false;
		}
		
		if (cena <= 0) {
			sb.append("\nCena nije negativan");
			ok = false;
		}
		if(ok == false) {
			JOptionPane.showMessageDialog(null, sb.toString(), "Neispravni podaci", JOptionPane.WARNING_MESSAGE);
		}
		
		return ok;
	}
	
	public static boolean validirajZanr(String oznaka,String opis) {
		StringBuilder sb = new StringBuilder();
		boolean ok = true;
		
		if (oznaka.equals("")) {
			sb.append("\nOznaka ne moze biti prazna");
			ok = false;
		}
		if (opis.equals("")) {
			sb.append("\nOpis nije popunjen");
			ok = false;
			}
		if(ok == false) {
			JOptionPane.showMessageDialog(null, sb.toString(), "Neispravni podaci", JOptionPane.WARNING_MESSAGE);
		}
		return ok;
	}
	
	public static boolean validirajBiblioteku(String naziv,String adresa,String telefon,String radnoVreme) {
	    StringBuilder sb = new StringBuilder();
	    boolean ok = true;
	    
	    if (naziv.equals("")) {
	    	ok = false;
	    	sb.append("\nNaziv biblioteke nije prazan");
	    }
	    if (adresa.equals("") || !adresa.matches(".*\\d+.*")) {
	    	ok = false;
	    	sb.append("\nAdresa sadrzi broj");
	    }
	    if (telefon.equals("") || !telefon.matches("^(\\d{3})?(\\d{4})(\\d{3})$")) {
	    ok = false;
	    sb.append("\nTelefon se u nosi u formatu: 0211234567");
	    }
	    if (radnoVreme.equals("")) {
	    	ok = false;
	    	sb.append("\nRadno vreme");
	    }
	    if (ok == false) {
	    	JOptionPane.showMessageDialog(null,sb.toString(),"Neispravni podaci",JOptionPane.WARNING_MESSAGE);;
	    }
	    return ok;
	}
	
	public static boolean JMBGValidacijaAdmin(ArrayList<Administrator> zaposleni, String jmbg, int id) {
		if ((zaposleni == null) || (zaposleni.size() == 0)) {
			return false;
		}
		for (Administrator zz: zaposleni) {
			if (zz.getJMBG().equals(jmbg) && zz.getIDOsobe() != id) {
		    	JOptionPane.showMessageDialog(null,"JMBG vec postoji","Neispravni podaci",JOptionPane.WARNING_MESSAGE);		    
				return true;
			}
		}
		return false;
	}
	
	
	public static boolean JMBGValidacijaBibliotekar(ArrayList<Bibliotekar> zaposleni, String jmbg, int id) {
		if ((zaposleni == null) || (zaposleni.size() == 0)) {
			return false;
		}
		for (Bibliotekar zz: zaposleni) {
			if (zz.getJMBG().equals(jmbg) && zz.getIDOsobe() != id) {
		    	JOptionPane.showMessageDialog(null,"JMBG vec postoji","Neispravni podaci",JOptionPane.WARNING_MESSAGE);		    
				return true;
			}
		}
		return false;
	}
	
	public static boolean JMBGClanstvoValidacijaClan(ArrayList<Clan> clanovi, String jmbg, String brCl, int id) {
		if ((clanovi == null) || (clanovi.size() == 0)) {
			return false;
		}
		for (Clan cl: clanovi) {
			if ((cl.getJMBG().equals(jmbg) || cl.getBrojClanske().equals(brCl)) && (cl.getIDOsobe() != id)) {
		    	JOptionPane.showMessageDialog(null,"JMBG ili broj clanske karte vec postoji","Neispravni podaci",JOptionPane.WARNING_MESSAGE);		    
				return true;
			}
		}
		return false;
	}
	
	public static boolean validacijaBrisanja(ArrayList<Iznajmljivanje> iznajmljivanja, int idKnjige) {
		if ((iznajmljivanja == null) || (iznajmljivanja.size() == 0)) {
			return false;
		}
		for (Iznajmljivanje i: iznajmljivanja) {
			Primerak p = i.getIznajmljenPrimerak();
			Knjiga kk = p.getKnjiga();
			if (kk.getIDKnjige() == idKnjige) {
		    	JOptionPane.showMessageDialog(null,"Primerak knjige je iznajmljen,ne moze se obrisati","Neispravni podaci",JOptionPane.WARNING_MESSAGE);		    
				return true;
			}
			
		}
		return false;
	}
	
	public static boolean validirajNovogClana(String ime,String prezime,String JMBG,String adresa,String brojClanske,int brojUplacenihMeseci,LocalDate datumPoslednjeUplate,Zaposleni zaposleni) {
		StringBuilder sb = new StringBuilder();
		boolean ok = true;
		if (ime.equals("")  || !ime.matches("[A-Z][a-zA-Z]*")) {
			sb.append("\nIme");
			ok = false;
		}
		if (prezime.equals("")  || !prezime.matches("[A-Z][a-zA-Z]*")) {
			sb.append("\nPrezime");
			ok = false;
		}
		if (JMBG.equals("") || JMBG.length() != 13 || !JMBG.matches("\\d{13}")) {
			sb.append("\nJmbg ima 13 cifara!");
			ok = false;
		}
		
		if (adresa.equals("") || !adresa.matches(".*\\d+.*")) { //barem 1 broj
			sb.append("\nAdresa ima barem 1 broj");
			ok = false;
		}
		
		if (brojClanske.equals("") || !brojClanske.matches("^\\d+$")) {
			sb.append("\nBroj clanske karte sadrzi samo cifre");
			ok = false;
		}
		
		if (brojUplacenihMeseci <0 || brojUplacenihMeseci>=6) {
			sb.append("\nBroj uplacenih meseci ne moze biti negativan broj,i novi clan ne moze uplatiti vise od 5 meseci");
			ok = false;
		}
		
		if (datumPoslednjeUplate.isAfter(LocalDate.now())) {
			sb.append("\n Datum poslednje uplate ne moze biti posle danasnjeg datuma");
			ok=false;
		}
		if(ok == false) {
			JOptionPane.showMessageDialog(null, sb.toString(), "Neispravni podaci", JOptionPane.WARNING_MESSAGE);
		}
		
		
		
		return ok;
	}
	
	
	      
}
