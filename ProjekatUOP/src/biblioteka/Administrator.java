package biblioteka;

import java.io.IOException;
import java.util.ArrayList;

public class Administrator extends Zaposleni {
	private static int idMaker=0;
	//private Biblioteka biblioteka;
	
	public Administrator() {
		
		super();
	}
	
	
	public Administrator(int IDOsobe,String ime,String prezime,String JMBG,String adresa,boolean obrisan,Pol pol,double plata,String korIme,String lozinka) {
	 super(IDOsobe,ime,prezime,JMBG,adresa,obrisan,pol, plata,korIme,lozinka);
	 
	this.IDOsobe = IDOsobe;
	Administrator.idMaker = IDOsobe;
	}
	
	
	
	public void dodajAdmina(int IDOsobe,String ime,String prezime,String JMBG,String adresa,boolean obrisan,Pol pol,double plata,String korIme,String lozinka) throws IOException {
		ArrayList<Administrator> sviAdministratori = new ArrayList<Administrator>();
		
		Administrator administrator = new Administrator();
		administrator.setIDOsobe(IDOsobe);
		administrator.setIme(ime);
		administrator.setPrezime(prezime);
		administrator.setJMBG(JMBG);
		administrator.setAdresa(adresa);
		administrator.setObrisan(obrisan);
		administrator.setPol(pol);
		administrator.setPlata(plata);
		administrator.setKorIme(korIme);
		administrator.setLozinka(lozinka);
		sviAdministratori.add(administrator);
		Biblioteka.upisiAdministratore(sviAdministratori, "src/fajlovi/administratori.txt");
		}
	
	public void dodajBibliotekara(int IDOsobe,String ime,String prezime,String JMBG,String adresa,boolean obrisan,Pol pol,double plata,String korIme,String lozinka) throws IOException {
		ArrayList<Bibliotekar> sviBibliotekari = new ArrayList<Bibliotekar>();
		Bibliotekar bibliotekar = new Bibliotekar();
		bibliotekar.setIDOsobe(IDOsobe);
		bibliotekar.setIme(ime);
		bibliotekar.setPrezime(prezime);
		bibliotekar.setJMBG(JMBG);
		bibliotekar.setAdresa(adresa);
		bibliotekar.setObrisan(obrisan);
		bibliotekar.setPol(pol);
		bibliotekar.setPlata(plata);
		bibliotekar.setKorIme(korIme);
		bibliotekar.setLozinka(lozinka);
		sviBibliotekari.add(bibliotekar);
		Biblioteka.upisiBibliotekare(sviBibliotekari, "src/fajlovi/bibliotekari.txt");

		}
	
	public void brisiBibliotekara(int ID,Biblioteka biblioteka) throws IOException {
        biblioteka.getSviBibliotekari();
        for (Bibliotekar b: biblioteka.getSviBibliotekari()) {
        	if (b.getIDOsobe()==ID) {
        		b.setObrisan(true);
        		
        	}
        	
        	Biblioteka.izbrisiSadrzajFajla("src/fajlovi/bibliotekari.txt");
        	Biblioteka.upisiBibliotekare(biblioteka.sviBibliotekari,"src/fajlovi/bibliotekari.txt");
        }    	
	
	}
	
	public void brisiAdministratora(int ID,Biblioteka biblioteka) throws IOException {
        biblioteka.getSviAdministratori();
        for (Administrator a: biblioteka.getSviAdministratori()) {
        	if (a.getIDOsobe()==ID) {
        		a.setObrisan(true);
        		
        	}
        	
        	Biblioteka.izbrisiSadrzajFajla("src/fajlovi/administratori.txt");
        	Biblioteka.upisiAdministratore(biblioteka.sviAdministratori,"src/fajlovi/administratori.txt");
        }    	
	
	}
	
	public void updateAdmina(int IDAdmina,String ime,String prezime,String JMBG,String adresa,boolean obrisan,Pol pol,double plata,String korIme,String lozinka,Biblioteka biblioteka) throws IOException {
		for (Administrator a: biblioteka.getSviAdministratori()) {
			if (a.getIDOsobe() == IDAdmina) {
				a.setIme(ime);
				a.setPrezime(prezime);
				a.setJMBG(JMBG);
				a.setAdresa(adresa);
				a.setObrisan(obrisan);
				a.setPol(pol);
				a.setPlata(plata);
				a.setKorIme(korIme);
				a.setLozinka(lozinka);
				a.setBiblioteka(biblioteka);
				
				
				Biblioteka.izbrisiSadrzajFajla("src/fajlovi/administratori.txt");
	        	Biblioteka.upisiAdministratore(biblioteka.sviAdministratori,"src/fajlovi/administratori.txt");
				
				
			}
		}
	}
	
	public void updateBibliotekara(int IDBibliotekara,String ime,String prezime,String JMBG,String adresa,boolean obrisan,Pol pol,double plata,String korIme,String lozinka,Biblioteka biblioteka) throws IOException {
		for (Bibliotekar b: biblioteka.getSviBibliotekari()) {
			if (b.getIDOsobe()==IDBibliotekara) {
				b.setIme(ime);
				b.setPrezime(prezime);
				b.setJMBG(JMBG);
				b.setAdresa(adresa);
				b.setObrisan(obrisan);
				b.setPol(pol);
				b.setPlata(plata);
				b.setKorIme(korIme);
				b.setLozinka(lozinka);
				b.setBiblioteka(biblioteka);
				
				Biblioteka.izbrisiSadrzajFajla("src/fajlovi/bibliotekari.txt");
				Biblioteka.upisiBibliotekare(biblioteka.sviBibliotekari, "src/fajlovi/bibliotekari.txt");
				
			}
		}
	}
	
	

	public static void setIdMaker(int count) {
		Administrator.idMaker = count;
	}
	
	public static int getUpdateMaker() {
		return Administrator.idMaker;
	}
	
	
	
	@Override 
	
	public String toString() {
		return "Administrator [ID: " + this.IDOsobe + ", ime: " + this.ime + ", prezime:" + this.prezime + ", JMBG:" + this.JMBG + ", adresa" + this.adresa + ", pol:" + this.pol + ", plata:" + this.plata + ", korisnicko ime: " + this.korIme + ", lozinka: " + this.lozinka + "\n";
				}

	
	
	
	
	
	
	
}