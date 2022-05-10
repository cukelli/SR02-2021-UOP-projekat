package biblioteka;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class Biblioteka {
	private String naziv;
	private String adresa;
	private String telefon;
	private LocalDateTime radnoVreme;
	
	

	public Biblioteka() {
		this.naziv = "";
		this.adresa = "";
		this.telefon = "";
		this.radnoVreme = null;
		
		
	}
	
	public Biblioteka(String naziv,String adresa,String telefon,LocalDateTime radnoVreme) {
		this.naziv = naziv;
		this.adresa = adresa;
		this.telefon = telefon;
		this.radnoVreme = radnoVreme;
		
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public String getAdresa() {
		return adresa;
	}

	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}

	public String getTelefon() {
		return telefon;
	}

	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}

	public LocalDateTime getRadnoVreme() {
		return radnoVreme;
	}

	public void setRadnoVreme(LocalDateTime radnoVreme) {
		this.radnoVreme = radnoVreme;
	}	
	
	

	

	@Override
	public String toString() {
		return "Biblioteka [naziv: " + this.naziv + ",adresa: " + this.adresa + ",telefon: " + this.telefon + ",radno vreme: " + this.radnoVreme + "]";
	}
	
	
	public static ArrayList<Zanr> citajZanrove(String imeFajlaZanrovi) throws IOException {
		ArrayList<Zanr> sviZanrovi = new ArrayList<Zanr>();
		File fajlZanrova = new File(imeFajlaZanrovi);
		BufferedReader reader = new BufferedReader(new FileReader(fajlZanrova));
		String line = null;
		while ((line = reader.readLine()) != null) {
			String[] linijaZanr = line.split(";");
			String oznakaZanra = linijaZanr[0];
			String opisZanra = linijaZanr[1];
			Zanr zanr = new Zanr(oznakaZanra,opisZanra);
			sviZanrovi.add(zanr);
			System.out.println(zanr);
		
		}
		
		reader.close();
		return sviZanrovi;
		
		
	}
	
	 public static ArrayList<TipClanarine> citajClanarine(String imeFajlaClanarine) throws IOException {
			ArrayList<TipClanarine> sveClanarine = new ArrayList<TipClanarine>();
			File fajlClanarine = new File(imeFajlaClanarine);
			BufferedReader reader = new BufferedReader(new FileReader(fajlClanarine));
			String line = null;
			while ((line = reader.readLine()) != null) {
				String[] linijaClanarine = line.split(";");
				String tipClanarine = linijaClanarine[0];
				double cenaClanarine = Double.parseDouble(linijaClanarine[1]);
				TipClanarine clanarina = new TipClanarine(tipClanarine,cenaClanarine);
				sveClanarine.add(clanarina);
			
			}
			reader.close();
			return sveClanarine;
	 
	 
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
		
		
		
		public static ArrayList<Administrator> citajAdministratore (String fajlAdministratori) throws IOException {
			ArrayList<Administrator> administratori = new ArrayList<Administrator>();
			File administratoriFajl = new File(fajlAdministratori);
			
			BufferedReader reader = new BufferedReader(new FileReader(administratoriFajl));
			String line = null;
			while ((line = reader.readLine()) != null) {
				String[] nizAdministratora = line.split(";");
				String IDAdministratora = nizAdministratora[0];
				String imeAdministratora = nizAdministratora[1];
				String prezimeAdministratora = nizAdministratora[2];
				String JMBGAdministratora = nizAdministratora[3];
				String adresaAdministratora = nizAdministratora[4];
				String polAdministratora = nizAdministratora[5];
				Pol defPol = Pol.MUSKI;
				for (Pol p: Pol.values()) {
					if (p.name().equalsIgnoreCase(polAdministratora)) {
						defPol = p;
					}
				}
				double plataAdministratora = Double.parseDouble(nizAdministratora[6]);
				String korImeAdministratora = nizAdministratora[7];
				String lozinkaAdministratora = nizAdministratora[8];
				
				Administrator administrator = new Administrator(IDAdministratora,imeAdministratora,prezimeAdministratora,JMBGAdministratora,adresaAdministratora,defPol,plataAdministratora,korImeAdministratora,lozinkaAdministratora);
	            administratori.add(administrator);
			}
			reader.close();
			return administratori;		

			
		}
		
		
		public static ArrayList<Knjiga> citajFajl(String imeFajla,ArrayList<Zanr> zanroviKnjiga) throws IOException {
			
			
			
			ArrayList<Knjiga> knjige = new ArrayList<Knjiga>();
			File fajl = new File(imeFajla);
			BufferedReader reader = new BufferedReader(new FileReader(fajl));

			String line = null;
			while ((line = reader.readLine()) != null) {
				String [] niz = line.split(";");
				String naslov = niz[0];
				String originalniNaslov = niz[1];
				String autor = niz[2];
				int godinaObjavljivanja = Integer.parseInt(niz[3]);
				String jezikOriginala = niz[4];
				Jezik defJezik = Jezik.ENGLESKI;
				for (Jezik j: Jezik.values()) {
					if (j.name().equalsIgnoreCase(jezikOriginala)) {
						defJezik = j;
					}
				}
				String opis = niz[5];
				Zanr tmp = zanroviKnjiga.get(0);

				for (Zanr z: zanroviKnjiga) {
				
					if (z.getOznaka().equalsIgnoreCase(niz[6])) {
					
				  tmp = z;
			// System.out.println("usao u petljlu");
					}
				}
				
				
				
				String IDKnjige = niz[7];
				Knjiga knjiga = new Knjiga(IDKnjige,naslov,originalniNaslov,autor,godinaObjavljivanja,defJezik,opis,tmp);
				knjige.add(knjiga);
				
			}
			reader.close();
			return knjige;
			
			
		}

		
		
		public static ArrayList<Primerak> citajPrimerke(String fajlPrimeraka,ArrayList<Knjiga> knjige) throws IOException {
			ArrayList<Primerak> sviPrimerci = new ArrayList<Primerak>();
			File fajl = new File(fajlPrimeraka);
			BufferedReader reader = new BufferedReader(new FileReader(fajl));
			String line = null;
			while ((line = reader.readLine()) != null) {
				String [] nizPrimerka = line.split(";");
				String IDPrimerka = nizPrimerka[0];
				Knjiga tmpKnjiga = knjige.get(0);
				
				for (Knjiga knj: knjige) {
					
					if (knj.getNaslov().equalsIgnoreCase(nizPrimerka[1])) {
						tmpKnjiga = knj;
					}
				}
				
				int brojStranaPrimerka = Integer.parseInt(nizPrimerka[2]);
				int godinaStampePrimerka = Integer.parseInt(nizPrimerka[3]);
				String jezikPrimerka = nizPrimerka[4];
				Jezik defJezikPrimerka = Jezik.SRPSKI;
				for (Jezik j: Jezik.values()) {
					if (j.name().equalsIgnoreCase(jezikPrimerka)) {
						defJezikPrimerka = j;
					}
				}
				
				boolean iznajmljenostPrimerka = Boolean.parseBoolean(nizPrimerka[5]);
				
				String povezPrimerka = nizPrimerka[6];
				Povez defPovezPrimerka = Povez.MEKI;
				for (Povez p: Povez.values()) {
					if (p.name().equalsIgnoreCase(povezPrimerka)) {
						defPovezPrimerka = p;	
					}
				}
				Primerak primerak = new Primerak(IDPrimerka,tmpKnjiga,brojStranaPrimerka,godinaStampePrimerka,defJezikPrimerka,iznajmljenostPrimerka,defPovezPrimerka);
				sviPrimerci.add(primerak);			
				
			}
			reader.close();
			return sviPrimerci;
			
			
		}
		
		public static ArrayList<Iznajmljivanje> citajIznajmljivanja (String fajlSaIznajmljivanjem, ArrayList<Clan> c,ArrayList<Bibliotekar> b,ArrayList<Primerak> p) throws IOException {
			
			ArrayList<Iznajmljivanje> svaIznajmljivanja = new ArrayList<Iznajmljivanje>();
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
				  svaIznajmljivanja.add(iznajmljivanje);
				  
			}
			reader.close();
			return svaIznajmljivanja;
			
			
			
		}
		
		

}
