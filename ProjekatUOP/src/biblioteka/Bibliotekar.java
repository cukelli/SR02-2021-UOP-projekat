package biblioteka;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Bibliotekar extends Zaposleni {
	public Bibliotekar() {
		super();	
	}
	
	public Bibliotekar(String IDOsobe,String ime,String prezime,String JMBG,String adresa,Pol pol,double plata,String korIme,String lozinka) {
		super(IDOsobe,ime,prezime,JMBG,adresa,pol,plata,korIme,lozinka);
	}
	
	public String toString() {
		return "Bibliotekar: [ID: " + this.IDOsobe + ", ime: " + this.ime + ", prezime:" + this.prezime + ", JMBG:" + this.JMBG + ", adresa" + this.adresa + ", pol:" + this.pol + ", plata:" + this.plata + ", korisnicko ime: " + this.korIme + ", lozinka: " + this.lozinka;
				}
	
	

	public static void upisiBibliotekare(ArrayList<Bibliotekar> bibliotekariUpis,String bibliotekariFajl) throws IOException {
		ArrayList<Bibliotekar> sviBibliotekari = bibliotekariUpis;
		File fajlSaBibliotekarima = new File(bibliotekariFajl);
		BufferedWriter writer = new BufferedWriter(new FileWriter(fajlSaBibliotekarima, true));
		
		for (Bibliotekar b: sviBibliotekari) {
			String sbBibliotekar = b.getIDOsobe() + ";" + b.getIme() + ";" + b.getPrezime() + ";" + b.getJMBG() + ";" + b.getAdresa() + ";" + b.getPol() + ";" + b.getPlata() + ";" + b.getKorIme() + ";" + b.getLozinka();
			writer.write(sbBibliotekar);
			writer.newLine();
		}
		writer.close();
		

		
	}
	
}
