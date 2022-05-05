package biblioteka;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
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
	
	public static ArrayList<Bibliotekar> citajBibliotekare (String fajlBibliotekari) throws IOException {
		ArrayList<Bibliotekar> bibliotekari = new ArrayList<Bibliotekar>();
		File bibliotekariFajl = new File(fajlBibliotekari);
		
		BufferedReader reader = new BufferedReader(new FileReader(bibliotekariFajl));
		
		String line = null;
		while ((line = reader.readLine()) != null) {
			String[] nizBibliotekara = line.split(";");
			String IDBibliotekara = nizBibliotekara[0];
			String imeBibliotekara = nizBibliotekara[1];
			String prezimeBibliotekara = nizBibliotekara[2];
			String JMBGBibliotekara = nizBibliotekara[3];
			String adresaBibliotekara = nizBibliotekara[4];
			String polBibliotekara = nizBibliotekara[5];
			Pol defPol = Pol.MUSKI;
			for (Pol p: Pol.values()) {
				if (p.name().equalsIgnoreCase(polBibliotekara)) {
					defPol = p;
				}
			}
			double plataBibliotekara = Double.parseDouble(nizBibliotekara[6]);
			String korImeBibliotekara = nizBibliotekara[7];
			String lozinkaBibliotekara = nizBibliotekara[8];
			
			Bibliotekar bibliotekar = new Bibliotekar(IDBibliotekara,imeBibliotekara,prezimeBibliotekara,JMBGBibliotekara,adresaBibliotekara,defPol,plataBibliotekara,korImeBibliotekara,lozinkaBibliotekara);
			bibliotekari.add(bibliotekar);
			
			}
		reader.close();
		return bibliotekari;
		
	}
	
	public static void upisiBibliotekare(ArrayList<Bibliotekar> bibliotekariUpis,String bibliotekariFajl) throws IOException {
		ArrayList<Bibliotekar> bibliotekari = bibliotekariUpis;
		File fajlSaBibliotekarima = new File(bibliotekariFajl);
		BufferedWriter writer = new BufferedWriter(new FileWriter(fajlSaBibliotekarima, true));
		
		for (Bibliotekar b: bibliotekari) {
			String sbBibliotekar = b.getIDOsobe() + ";" + b.getIme() + ";" + b.getPrezime() + ";" + b.getJMBG() + ";" + b.getAdresa() + ";" + b.getPol() + ";" + b.getPlata() + ";" + b.getKorIme() + ";" + b.getLozinka();
			writer.write(sbBibliotekar);
			writer.newLine();
		}
		writer.close();
		

		
		
	}

}
