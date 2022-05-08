package biblioteka;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

public class Iznajmljivanje {
	
	private String IDIznajmljivanja;
	private Zaposleni zaposleni;
	private Clan clan;
	private LocalDate datumIznajmljivanja;
	private LocalDate datumVracanja;
	private Primerak iznajmljenPrimerak;
	
	
	public Iznajmljivanje() {
		
		this.IDIznajmljivanja = "";
		this.zaposleni = null;
		this.clan = null;
		this.datumIznajmljivanja = null;
		this.datumVracanja = null;
		this.iznajmljenPrimerak = null;
		
	}
	public Iznajmljivanje(String IDIznajmljivanja,Zaposleni zaposleni,Clan clan,LocalDate datumIznajmljivanja,LocalDate datumVracanja,Primerak iznajmljenPrimerak)
	{
		this.IDIznajmljivanja = IDIznajmljivanja;
		this.zaposleni = zaposleni;
		this.clan = clan;
		this.datumIznajmljivanja = datumIznajmljivanja;
		this.datumVracanja = datumVracanja;
		this.iznajmljenPrimerak = iznajmljenPrimerak;
	}
	public Zaposleni getZaposleni() {
		return zaposleni;
	}
	public void setZaposleni(Zaposleni zaposleni) {
		this.zaposleni = zaposleni;
	}
	public Clan getClan() {
		return clan;
	}
	public void setClan(Clan clan) {
		this.clan = clan;
	}
	public LocalDate getDatumIznajmljivanja() {
		return datumIznajmljivanja;
	}
	public void setDatumIznajmljivanja(LocalDate datumIznajmljivanja) {
		this.datumIznajmljivanja = datumIznajmljivanja;
	}
	public LocalDate getDatumVracanja() {
		return datumVracanja;
	}
	public void setDatumVracanja(LocalDate datumVracanja) {
		this.datumVracanja = datumVracanja;
	}
	public Primerak getIznajmljenPrimerak() {
		return iznajmljenPrimerak;
	}
	public void setIznajmljenPrimerak(Primerak iznajmljenPrimerak) {
		this.iznajmljenPrimerak = iznajmljenPrimerak;
	}
	
	
	
	public String getIDIznajmljivanja() {
		return IDIznajmljivanja;
	}
	public void setIDIznajmljivanja(String iDIznajmljivanja) {
		IDIznajmljivanja = iDIznajmljivanja;
	}
	@Override
	public String toString() {
		return "Iznajmljivanje:[" + this.zaposleni + ", clan: " + this.clan + ", datum vracanja: " + this.datumVracanja + ", datum iznajmljivanja: " + this.datumIznajmljivanja + ",primerak: " + this.iznajmljenPrimerak + ", ID:" + this.IDIznajmljivanja;
				}
	
	
	public static ArrayList<Iznajmljivanje> citajIznajmljivanja (String fajlSaIznajmljivanjem, ArrayList<Clan> c,ArrayList<Bibliotekar> b,ArrayList<Primerak> p) throws IOException {
	//	File fajlPrimerci = new File(fajlPrimeraka);
		//Primerak.citajPrimerke(fajlPrimeraka,knjige);
		ArrayList<Iznajmljivanje> iznajmljivanja = new ArrayList<Iznajmljivanje>();
		File fajl = new File(fajlSaIznajmljivanjem);
		BufferedReader reader = new BufferedReader(new FileReader(fajl));
		String line = null;
		while ((line = reader.readLine()) != null) {
			String[] redIznajmljivanja = line.split(";");
			  String IDIznajmljivanja = redIznajmljivanja[0];
			  Bibliotekar tmpBibliotekar = b.get(0);
			  
			  for (Bibliotekar iteratorBibliotekar: b) {
				  if (iteratorBibliotekar.getIDOsobe().equalsIgnoreCase(redIznajmljivanja[1])) {
					  tmpBibliotekar = iteratorBibliotekar;
				  }					  			  
				  
			  }
			  
			  Clan tmpClan = c.get(0);
			  
			  for (Clan iteratorClan: c) {
				  if (iteratorClan.getBrojClanske().equalsIgnoreCase(redIznajmljivanja[2])) {
					  tmpClan = iteratorClan;
				  }
			  }
			
			  LocalDate datumIznajmljivanja = LocalDate.parse(redIznajmljivanja[3]);
			  LocalDate datumVracanja = LocalDate.parse(redIznajmljivanja[4]);
			  
			  Primerak tmpPrimerak = p.get(0);
			  
			  for (Primerak iteratorPrimerak: p) {
				  if (iteratorPrimerak.getIDPrimerka().equalsIgnoreCase(redIznajmljivanja[5])) {
					  tmpPrimerak = iteratorPrimerak;
				  }
			  }
			
			  Iznajmljivanje iznajmljivanje = new Iznajmljivanje(IDIznajmljivanja,tmpBibliotekar,tmpClan,datumIznajmljivanja,datumVracanja,tmpPrimerak);
			  iznajmljivanja.add(iznajmljivanje);
			  
		}
		reader.close();
		return iznajmljivanja;
		
		
		
	}
	
	public static void upisiIznajmljivanje(ArrayList<Iznajmljivanje> iznajmljivanjeUpis,String fajlUpisIznajmljivanja) throws IOException {
		ArrayList<Iznajmljivanje> iznajmljivanja = iznajmljivanjeUpis;
		
		File fajl = new File(fajlUpisIznajmljivanja);
		BufferedWriter writer = new BufferedWriter(new FileWriter(fajl, true));
		 
		for (Iznajmljivanje i: iznajmljivanja) {
			String sbIznajmljivanja = i.getIDIznajmljivanja() + ";" + i.getZaposleni().getIDOsobe() + ";" + i.getClan().getBrojClanske() + ";" + i.getDatumIznajmljivanja() + ";" + i.getDatumVracanja() + ";" + i.getIznajmljenPrimerak().getIDPrimerka();
			writer.write(sbIznajmljivanja);
			writer.newLine();
			
		
		}
		writer.close();
		
	}
	

}
