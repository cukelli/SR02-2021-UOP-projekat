package biblioteka;

import java.io.IOException;
import java.util.ArrayList;

public class Administrator extends Zaposleni {
	private static int idMaker=0;
	
	public Administrator() {
		
		super();
	}
	
	
	public Administrator(int IDOsobe,String ime,String prezime,String JMBG,String adresa,boolean obrisan,Pol pol,double plata,String korIme,String lozinka) {
	 super(IDOsobe,ime,prezime,JMBG,adresa,obrisan,pol, plata,korIme,lozinka);
	 if (idMaker >= IDOsobe) {
		 idMaker = IDOsobe + 1;
	 }
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
	

	public static void setIdMaker(int count) {
		Administrator.idMaker = count;
	}
	
	public static int getUpdateMaker() {
		return Administrator.idMaker;
	}
	
	
	
	@Override 
	
	public String toString() {
		return "Administrator [ID: " + this.IDOsobe + ", ime: " + this.ime + ", prezime:" + this.prezime + ", JMBG:" + this.JMBG + ", adresa" + this.adresa + ", pol:" + this.pol + ", plata:" + this.plata + ", korisnicko ime: " + this.korIme + ", lozinka: " + this.lozinka;
				}

	
	
	
	
	
	
	
}