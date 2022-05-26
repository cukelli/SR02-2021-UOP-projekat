package biblioteka;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

public class Bibliotekar extends Zaposleni {
	private static int idMaker=0;

	
	
	public Bibliotekar() {
	
		super();
	}
	
	public Bibliotekar(int IDOsobe,String ime,String prezime,String JMBG,String adresa,boolean obrisan,Pol pol,double plata,String korIme,String lozinka) {
		super(IDOsobe,ime,prezime,JMBG,adresa,obrisan,pol,plata,korIme,lozinka);
		this.IDOsobe = IDOsobe;
		Bibliotekar.idMaker = IDOsobe;
	}
	
	public static void setIdMaker(int count) {
		Bibliotekar.idMaker = count;
	}
	
	public static int getUpdateMaker() {
		return Bibliotekar.idMaker;
	}
	
	
	public void iznajmiKnjigu(int IDIznajmljivanja,Bibliotekar bibliotekar,Clan clan,LocalDate datumIznajmljivanja,LocalDate datumVracanja,Primerak iznajmljenPrimerak) throws IOException {
		ArrayList<Iznajmljivanje> svaIznajmljivanja = new ArrayList<Iznajmljivanje>();
		Iznajmljivanje iznajmljivanje = new Iznajmljivanje();
		iznajmljivanje.setIDIznajmljivanja(IDIznajmljivanja);
		iznajmljivanje.setBibliotekar(bibliotekar);
		iznajmljivanje.setClan(clan);
		iznajmljivanje.setDatumIznajmljivanja(datumIznajmljivanja);
		iznajmljivanje.setDatumVracanja(datumVracanja);
		iznajmljivanje.setIznajmljenPrimerak(iznajmljenPrimerak);
		svaIznajmljivanja.add(iznajmljivanje);
		Biblioteka.upisiIznajmljivanje(svaIznajmljivanja, "src/fajlovi/iznajmljivanja.txt");
	
		
	}
	
	public void brisiIznajmljivanje(int ID,Biblioteka biblioteka) throws IOException {
        biblioteka.getSvaIznajmljivanja();
        for (Iznajmljivanje i: biblioteka.getSvaIznajmljivanja()) {
        	if (i.getIDIznajmljivanja()==ID) {
        	    i.setObrisanostIznajmljivanja(true);
        		
        	}
        	
        	Biblioteka.izbrisiSadrzajFajla("src/fajlovi/iznajmljivanja.txt");
        	Biblioteka.upisiIznajmljivanje(biblioteka.svaIznajmljivanja,"src/fajlovi/iznajmljivanja.txt");
        }    	
	
	}
	
	public void updateIznajmljivanje(int ID,Bibliotekar bibliotekar,Clan clan,LocalDate datumIznajmljivanja,LocalDate datumVracanja,Primerak iznajmljenPrimerak,boolean obrisanostIznajmljivanja,Biblioteka biblioteka) throws IOException {
		for (Iznajmljivanje i: biblioteka.getSvaIznajmljivanja()) {
			if (i.getIDIznajmljivanja()==ID){
				i.setBibliotekar(bibliotekar);
				i.setClan(clan);
				i.setDatumIznajmljivanja(datumIznajmljivanja);
				i.setDatumVracanja(datumVracanja);
				i.setIznajmljenPrimerak(iznajmljenPrimerak);
				i.setObrisanostIznajmljivanja(obrisanostIznajmljivanja);
	
			
				
				Biblioteka.izbrisiSadrzajFajla("src/fajlovi/iznajmljivanja.txt");
				Biblioteka.upisiIznajmljivanje(biblioteka.svaIznajmljivanja,"src/fajlovi/iznajmljivanja.txt");
				
			}
		}
	}
	
	
	

	public String toString() {
		return "Bibliotekar: [ID: " + this.IDOsobe + ", ime: " + this.ime + ", prezime:" + this.prezime + ", JMBG:" + this.JMBG + ", adresa" + this.adresa + ", pol:" + this.pol + ", plata:" + this.plata + ", korisnicko ime: " + this.korIme + ", lozinka: " + this.lozinka;
				}
	
	

	
	
}
