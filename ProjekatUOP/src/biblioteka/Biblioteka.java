package biblioteka;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;


public class Biblioteka {
    ArrayList<Knjiga> knjige = new ArrayList<Knjiga>();	
    ArrayList<Clan> sviClanovi = new ArrayList<Clan>();
    ArrayList<TipClanarine> sveClanarine = new ArrayList<TipClanarine>();
    ArrayList<Primerak> sviPrimerci = new ArrayList<Primerak>();
    ArrayList<Zanr>sviZanrovi = new ArrayList<Zanr>();
    ArrayList<Iznajmljivanje>svaIznajmljivanja = new ArrayList<Iznajmljivanje>();
    ArrayList<Bibliotekar> sviBibliotekari = new ArrayList<Bibliotekar>();
    ArrayList<Administrator> sviAdministratori = new ArrayList<Administrator>();
    
    
    
	private String naziv;
	private String adresa;
	private String telefon;
	private String radnoVreme;
	
	

	public Biblioteka() {
		this.naziv = "";
		this.adresa = "";
		this.telefon = "";
		this.radnoVreme = "";
		
		
	}
	
	public Biblioteka(String naziv,String adresa,String telefon,String radnoVreme) {
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

	public String getRadnoVreme() {
		return radnoVreme;
	}

	public void setRadnoVreme(String radnoVreme) {
		this.radnoVreme = radnoVreme;
	}	
	
	

	public ArrayList<Bibliotekar> getSviBibliotekari() {
		return sviBibliotekari;
	}

	public void setSviBibliotekari(ArrayList<Bibliotekar> sviBibliotekari) {
		this.sviBibliotekari = sviBibliotekari;
	}

	public ArrayList<Iznajmljivanje> getSvaIznajmljivanja() {
		return svaIznajmljivanja;
	}

	public void setSvaIznajmljivanja(ArrayList<Iznajmljivanje> svaIznajmljivanja) {
		this.svaIznajmljivanja = svaIznajmljivanja;
	}

	public ArrayList<Knjiga> getKnjige() {
		return knjige;
	}

	public void setKnjige(ArrayList<Knjiga> knjige) {
		this.knjige = knjige;
	}
	
	

	public ArrayList<Clan> getSviClanovi() {
		return sviClanovi;
	}

	public void setSviClanovi(ArrayList<Clan> sviClanovi) {
		this.sviClanovi = sviClanovi;
	}
	

	public ArrayList<TipClanarine> getSveClanarine() {
		return sveClanarine;
	}

	public void setSveClanarine(ArrayList<TipClanarine> sveClanarine) {
		this.sveClanarine = sveClanarine;
	}
	
	

	public ArrayList<Primerak> getSviPrimerci() {
		return sviPrimerci;
	}

	public void setSviPrimerci(ArrayList<Primerak> sviPrimerci) {
		this.sviPrimerci = sviPrimerci;
	}
	

	public ArrayList<Zanr> getSviZanrovi() {
		return sviZanrovi;
	}

	public void setSviZanrovi(ArrayList<Zanr> sviZanrovi) {
		this.sviZanrovi = sviZanrovi;
	}
	

	public ArrayList<Administrator> getSviAdministratori() {
		return sviAdministratori;
	}

	public void setSviAdministratori(ArrayList<Administrator> sviAdministratori) {
		this.sviAdministratori = sviAdministratori;
	}

	@Override
	public String toString() {
		return "Biblioteka [naziv: " + this.naziv + ",adresa: " + this.adresa + ",telefon: " + this.telefon + ",radno vreme: " + this.radnoVreme + "]";
	}
	
	
	public void citajZanrove(String imeFajlaZanrovi) throws IOException {
		 this.sviZanrovi = new ArrayList<Zanr>();
		File fajlZanrova = new File(imeFajlaZanrovi);
		BufferedReader reader = new BufferedReader(new FileReader(fajlZanrova));
		String line = null;
		while ((line = reader.readLine()) != null) {
			String[] linijaZanr = line.split(";");
			String oznakaZanra = linijaZanr[0];
			String opisZanra = linijaZanr[1];
			int IDZanra = Integer.parseInt(linijaZanr[2]);
			boolean obrisanostZanra = Boolean.parseBoolean(linijaZanr[3]);
			Zanr zanr = new Zanr(oznakaZanra,opisZanra,IDZanra,obrisanostZanra);
			sviZanrovi.add(zanr);
			System.out.println(zanr);
		
		}
		
		reader.close();
		
		
		
	}
	
	 public void citajClanarine(String imeFajlaClanarine) throws IOException {
			this.sveClanarine = new ArrayList<TipClanarine>();
			File fajlClanarine = new File(imeFajlaClanarine);
			BufferedReader reader = new BufferedReader(new FileReader(fajlClanarine));
			String line = null;
			while ((line = reader.readLine()) != null) {
				String[] linijaClanarine = line.split(";");
				String tipClanarine = linijaClanarine[0];
				double cenaClanarine = Double.parseDouble(linijaClanarine[1]);
				int IDClanarine = Integer.parseInt(linijaClanarine[2]);
				boolean obrisanostClanarine = Boolean.parseBoolean(linijaClanarine[3]);
				TipClanarine clanarina = new TipClanarine(tipClanarine,cenaClanarine,IDClanarine,obrisanostClanarine);
				sveClanarine.add(clanarina);
			
			}
			reader.close();
			
	 
	 
	}
	 
	 
	 public void citajClanove (String fajlClanovi,ArrayList<TipClanarine> sveClanarine) throws IOException {
			this.sviClanovi = new ArrayList<Clan>();
			File clanoviFajl = new File(fajlClanovi);
			
			BufferedReader reader = new BufferedReader(new FileReader(clanoviFajl));
			String line = null;
			while ((line = reader.readLine()) != null) {
				String [] nizClanova = line.split(";");
				int IDclana = Integer.parseInt(nizClanova[0]);
				String imeClana = nizClanova[1];
				String prezimeClana = nizClanova[2];
				String JMBGClana = nizClanova[3];
				String adresaClana = nizClanova[4];
				String polClana = nizClanova[5];
				Pol defPol = Pol.MUSKI;
				for (Pol p: Pol.values()) {
					if (p.name().equalsIgnoreCase(polClana)) {
						defPol = p;
					}
				}
				
				String brojClanskeClana = nizClanova[6];
				LocalDate datumPoslednjeUplateClana = LocalDate.parse(nizClanova[7]);
				int UplaceniMeseciClana = Integer.parseInt(nizClanova[8]);
				boolean aktivnostClana = Boolean.parseBoolean(nizClanova[9]);
				TipClanarine tmpClanarine = sveClanarine.get(0);
				
				for (TipClanarine tip: sveClanarine) {
					
					if (tip.getTip().equalsIgnoreCase(nizClanova[10])) {
					
				  tmpClanarine = tip;
					}
				}
				boolean obrisanostClana = Boolean.parseBoolean(nizClanova[11]);
			
					
				Clan clan = new Clan(IDclana,imeClana,prezimeClana,JMBGClana,adresaClana,obrisanostClana,defPol,brojClanskeClana,datumPoslednjeUplateClana,UplaceniMeseciClana,aktivnostClana,tmpClanarine);
				sviClanovi.add(clan);	
				
			}
			reader.close();
			
			
		}
		
		public static void upisiClanove(ArrayList<Clan> clanoviUpis, String clanoviFajl) throws IOException {
			ArrayList<Clan> clanovi = clanoviUpis;
			File fajlSaClanovima = new File(clanoviFajl);
			BufferedWriter writer = new BufferedWriter(new FileWriter(fajlSaClanovima, true));
			
			for (Clan c: clanovi) {
				String sbClan = c.getIDOsobe() + ";" + c.getIme() + ";" + c.getPrezime() + ";" + c.getJMBG() + ";" + c.getAdresa() + ";" + c.getPol() + ";" + c.getBrojClanske() + ";" + c.getDatumPoslednjeUplate() + ";" + c.getBrojUplacenihMeseci() + ";" + c.isAktivnost() + ";" + c.getTipClanarine() + ";" + c.isObrisan();
				writer.write(sbClan);
				writer.newLine();
				
	 		}
			writer.close();

			
		}
	 
	 public void citajBibliotekare (String fajlBibliotekari) throws IOException {
			this.sviBibliotekari = new ArrayList<Bibliotekar>();
			File bibliotekariFajl = new File(fajlBibliotekari);
			
			BufferedReader reader = new BufferedReader(new FileReader(bibliotekariFajl));
			
			String line = null;
			while ((line = reader.readLine()) != null) {
				String[] nizBibliotekara = line.split(";");
				int IDBibliotekara = Integer.parseInt(nizBibliotekara[0]);
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
				boolean obrisanostBibliotekara = Boolean.parseBoolean(nizBibliotekara[9]);
			//	System.out.println(obrisanostBibliotekara);

				Bibliotekar bibliotekar = new Bibliotekar(IDBibliotekara,imeBibliotekara,prezimeBibliotekara,JMBGBibliotekara,adresaBibliotekara,obrisanostBibliotekara,defPol,plataBibliotekara,korImeBibliotekara,lozinkaBibliotekara);
				sviBibliotekari.add(bibliotekar);
				
              			
				}
		//	System.out.println(sviBibliotekari+"Svi");
			reader.close();
			
			
		}
		
	 
	 public static void upisiBibliotekare(ArrayList<Bibliotekar> bibliotekariUpis,String bibliotekariFajl) throws IOException {
			ArrayList<Bibliotekar> sviBibliotekari = bibliotekariUpis;
			File fajlSaBibliotekarima = new File(bibliotekariFajl);
			BufferedWriter writer = new BufferedWriter(new FileWriter(fajlSaBibliotekarima, true));
			
			for (Bibliotekar b: sviBibliotekari) {
				String sbBibliotekar = b.getIDOsobe() + ";" + b.getIme() + ";" + b.getPrezime() + ";" + b.getJMBG() + ";" + b.getAdresa() + ";" + b.getPol() + ";" + b.getPlata() + ";" + b.getKorIme() + ";" + b.getLozinka() + ";" + b.obrisan;
				writer.write(sbBibliotekar);
				writer.newLine();
			}
			writer.close();
			

			
		}
		
		
		public void citajAdministratore (String fajlAdministratori) throws IOException {
			this.sviAdministratori = new ArrayList<Administrator>();
			File administratoriFajl = new File(fajlAdministratori);
			
			BufferedReader reader = new BufferedReader(new FileReader(administratoriFajl));
			String line = null;
			while ((line = reader.readLine()) != null) {
				String[] nizAdministratora = line.split(";");
				int IDAdministratora = Integer.parseInt(nizAdministratora[0]);
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
				boolean obrisanostAdministratora = Boolean.parseBoolean(nizAdministratora[9]);
				
				Administrator administrator = new Administrator(IDAdministratora,imeAdministratora,prezimeAdministratora,JMBGAdministratora,adresaAdministratora,obrisanostAdministratora,defPol,plataAdministratora,korImeAdministratora,lozinkaAdministratora);
	            sviAdministratori.add(administrator);
	          //  System.out.println(sviAdministratori);
			}
			
//			for (Administrator a: sviAdministratori) {
//				System.out.println(a.getJMBG());
//			}
			reader.close();
			

			
		}
		
		
		public static void upisiAdministratore(ArrayList<Administrator> administratoriUpis,String administratoriFajl) throws IOException {
			ArrayList<Administrator> administratori = administratoriUpis;
			File fajlSaAdministratorima = new File(administratoriFajl);
			BufferedWriter writer = new BufferedWriter(new FileWriter(fajlSaAdministratorima, true));
			for (Administrator a: administratori) {
				String sbAdministrator = a.getIDOsobe() + ";" + a.getIme() + ";" + a.getPrezime() + ";" + a.getJMBG() + ";" + a.getAdresa() + ";" + a.getPol() + ";" + a.getPlata() + ";" + a.getKorIme() + ";" + a.getLozinka() + ";" + a.obrisan;
				writer.write(sbAdministrator);
				writer.newLine();
			}
			writer.close();
			
		}
		
		public void citajFajl(String imeFajla,ArrayList<Zanr> zanroviKnjiga) throws IOException {
			
			
			
			this.knjige = new ArrayList<Knjiga>();
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
					}
				}
				
				
				int IDKnjige = Integer.parseInt(niz[7]);
				boolean obrisanostKnjige = Boolean.parseBoolean(niz[8]);
				Knjiga knjiga = new Knjiga(IDKnjige,naslov,originalniNaslov,autor,godinaObjavljivanja,defJezik,opis,tmp,obrisanostKnjige);
				//System.out.println(knjiga.getIDKnjige());
				this.knjige.add(knjiga);
				
			}
			reader.close();
			
			
			
			
		}
		
		
		

		
		
		public void citajPrimerke(String fajlPrimeraka,ArrayList<Knjiga> knjige) throws IOException {
			this.sviPrimerci = new ArrayList<Primerak>();
			File fajl = new File(fajlPrimeraka);
			BufferedReader reader = new BufferedReader(new FileReader(fajl));
			String line = null;
			while ((line = reader.readLine()) != null) {
				String [] nizPrimerka = line.split(";");
				int IDPrimerka = Integer.parseInt(nizPrimerka[0]);
				
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
				boolean obrisanostPrimerka = Boolean.parseBoolean(nizPrimerka[7]);
				Primerak primerak = new Primerak(IDPrimerka,tmpKnjiga,brojStranaPrimerka,godinaStampePrimerka,defJezikPrimerka,iznajmljenostPrimerka,defPovezPrimerka,obrisanostPrimerka);
				
				sviPrimerci.add(primerak);			
				
			}
			reader.close();
			
			
			
		}
		
		
		public static void pisiPrimerke(ArrayList<Primerak> primerciUpis,String fajlUpisPrimeraka) throws IOException {
			ArrayList<Primerak> sviPrimerci = primerciUpis;
			File fajl = new File(fajlUpisPrimeraka);
			BufferedWriter writer = new BufferedWriter(new FileWriter(fajl, true));
			
			for (Primerak p: sviPrimerci) {
				String sbPrimerak = p.getIDPrimerka() + ";" + p.getKnjiga().getNaslov() + ";" + p.getBrojStrana() + ";" + p.getGodinaStampe() + ";" + p.getJezikStampe() + ";" + p.isIznajmljena() + ";" + p.getPovez() + ";" + p.isObrisan();
				writer.write(sbPrimerak);
				writer.newLine();
				
			}
			writer.close();
		}
		
		
		public static void upisiFajl(ArrayList<Knjiga> knjigeUpis, String imeFajla) throws IOException {
			ArrayList<Knjiga> sveKnjige = knjigeUpis;
			File fajl = new File(imeFajla);
			BufferedWriter writer = new BufferedWriter(new FileWriter(fajl, true));
			
			

			for (Knjiga k: sveKnjige) {
				
				String sb = k.getNaslov() + ";" + k.getOriginalniNaslov() + ";" + k.getAutor() + ";" + k.getGodinaObjavljivanja() + ";" + k.getJezikOriginala() + ";" + k.getOpis() + ";" + k.getZanr() + ";" + k.getIDKnjige() + ";" + k.isObrisana();
				writer.write(sb);
				writer.newLine();
			}
			
			writer.close();
		}
		
		
		
		public void citajIznajmljivanja (String fajlSaIznajmljivanjem, ArrayList<Clan> c,ArrayList<Bibliotekar> b,ArrayList<Primerak> p) throws IOException {
			
			this.svaIznajmljivanja = new ArrayList<Iznajmljivanje>();
			File fajl = new File(fajlSaIznajmljivanjem);
			BufferedReader reader = new BufferedReader(new FileReader(fajl));
			String line = null;
			while ((line = reader.readLine()) != null) {
				String[] redIznajmljivanja = line.split(";");
				  int IDIznajmljivanja = Integer.parseInt(redIznajmljivanja[0]);
				  Bibliotekar tmpBibliotekar = b.get(0);
				  
				  for (Bibliotekar iteratorBibliotekar: b) {
					  if (iteratorBibliotekar.getIDOsobe()==Integer.parseInt(redIznajmljivanja[1])) {
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
					  if (iteratorPrimerak.getIDPrimerka()==(Integer.parseInt(redIznajmljivanja[5]))) {
						  tmpPrimerak = iteratorPrimerak;
					  }
				  }
				  
				  boolean obrisanostIznajmljivanja = Boolean.parseBoolean(redIznajmljivanja[6]);
				
				  Iznajmljivanje iznajmljivanje = new Iznajmljivanje(IDIznajmljivanja,tmpBibliotekar,tmpClan,datumIznajmljivanja,datumVracanja,tmpPrimerak,obrisanostIznajmljivanja);
				  svaIznajmljivanja.add(iznajmljivanje);
				  
			}
			reader.close();			
			
		}
		
		
		public static void upisiIznajmljivanje(ArrayList<Iznajmljivanje> iznajmljivanjeUpis,String fajlUpisIznajmljivanja) throws IOException {
			ArrayList<Iznajmljivanje> iznajmljivanja = iznajmljivanjeUpis;
			
			File fajl = new File(fajlUpisIznajmljivanja);
			BufferedWriter writer = new BufferedWriter(new FileWriter(fajl, true));
			 
			for (Iznajmljivanje i: iznajmljivanja) {
				String sbIznajmljivanja = i.getIDIznajmljivanja() + ";" + i.getBibliotekar().getIDOsobe() + ";" + i.getClan().getBrojClanske() + ";" + i.getDatumIznajmljivanja() + ";" + i.getDatumVracanja() + ";" + i.getIznajmljenPrimerak().getIDPrimerka() + ";" + i.isObrisanostIznajmljivanja();
				writer.write(sbIznajmljivanja);
				writer.newLine();
				
			
			}
			writer.close();
			
		}
		
		
		public static ArrayList<Biblioteka> citajBiblioteku(String fajlBiblioteke) throws IOException {
			ArrayList<Biblioteka> bibliotekaCitanje = new ArrayList<Biblioteka>();
			File fajl = new File(fajlBiblioteke);
			BufferedReader reader = new BufferedReader(new FileReader(fajl));
			String line = null;
			while ((line = reader.readLine()) != null) { 
				String[] redBiblioteke = line.split(";");
				String nazivBiblioteke = redBiblioteke[0];
				String adresaBiblioteke = redBiblioteke[1];
				String brojTelefonaBiblioteke = redBiblioteke[2];
				String radnoVremeBiblioteke = redBiblioteke[3];
				Biblioteka biblioteka = new Biblioteka(nazivBiblioteke,adresaBiblioteke,brojTelefonaBiblioteke,radnoVremeBiblioteke);
				bibliotekaCitanje.add(biblioteka);


			}
		
			reader.close();
			return bibliotekaCitanje;
			
			
			
		}
		
		
		public static void upisiBiblioteku(ArrayList<Biblioteka> bibliotekaUpis,String fajlUpisBiblioteke) throws IOException {
			ArrayList<Biblioteka> biblioteka = bibliotekaUpis;
			File fajl = new File(fajlUpisBiblioteke);
			BufferedWriter writer = new BufferedWriter(new FileWriter(fajl,true));
			
			for (Biblioteka b: biblioteka) {
				String sbBiblioteke = b.getNaziv() + ";" + b.getAdresa() + ";" + b.getTelefon() + ";" + b.getRadnoVreme();
				writer.write(sbBiblioteke);
				writer.newLine();
			}
			writer.close();
		}
		
		public static void upisiClanarinu (ArrayList<TipClanarine> clanarinaUpis,String fajlUpisClanarine) throws IOException {
			ArrayList<TipClanarine> clanarine = clanarinaUpis;
			File fajl = new File(fajlUpisClanarine);
			BufferedWriter writer = new BufferedWriter(new FileWriter(fajl,true));
			
			for (TipClanarine tip: clanarine) {
		    	String sbClanarine = tip.getTip() + ";" + tip.getCena() + ";" + tip.getIDClanarine() + ";" + tip.isObrisanaClanarina();
			   writer.write(sbClanarine);
				writer.newLine();
			}
			writer.close();
		}
		
		public static void upisiZanr (ArrayList<Zanr> zanrUpis,String fajlUpisZanr) throws IOException {
			ArrayList<Zanr> zanr = zanrUpis;
			File fajl = new File(fajlUpisZanr);
			BufferedWriter writer = new BufferedWriter(new FileWriter(fajl,true));
			for (Zanr z: zanr) {
				String sbZanr = z.getOznaka() + ";" + z.getOpis() + ";" + z.getIDZanra() + ";" + z.isObrisanZanr();
				writer.write(sbZanr);
				writer.newLine();
			}
			writer.close();
		}
		
		public static boolean izbrisiSadrzajFajla(String putanja) throws IOException {
			BufferedWriter writer = Files.newBufferedWriter(Paths.get(putanja));
			writer.write("");
			writer.flush();
			
			return true;
		}
		
		public ArrayList<Bibliotekar> neobrisaniBibliotekari() {
			ArrayList<Bibliotekar> neobrisaniBibliotekari = new ArrayList<Bibliotekar>();
			for (Bibliotekar b: sviBibliotekari) {
				if (b.isObrisan() == false) {
					neobrisaniBibliotekari.add(b);
				}
			}
			System.out.println(neobrisaniBibliotekari);
			return neobrisaniBibliotekari;
		}
		
		public ArrayList<Administrator> neobrisaniAdministratori() {
			ArrayList<Administrator> neobrisaniAdministratori = new ArrayList<Administrator>();
			for (Administrator a: sviAdministratori) {
				if (a.isObrisan() == false) {
					neobrisaniAdministratori.add(a);
					
				}
			}
			return neobrisaniAdministratori;
			}
		
		public ArrayList<Clan> neobrisaniClanovi() {
			ArrayList<Clan> neobrisaniClanovi = new ArrayList<Clan>();
			for (Clan c: sviClanovi) {
				if (c.isObrisan() == false) {
					neobrisaniClanovi.add(c);
					
				}
			}
			return neobrisaniClanovi;
			}
		
		public ArrayList<Knjiga> neobrisaneKnjige() {
			ArrayList<Knjiga> neobrisaneKnjige = new ArrayList<Knjiga>();
			for (Knjiga k: knjige) {
				if (k.isObrisana() == false) {
					neobrisaneKnjige.add(k);
					
				}
			}
			System.out.println(neobrisaneKnjige);
			return neobrisaneKnjige;
			
			}
		
		public ArrayList<Iznajmljivanje> neobrisanaIznajmljivanja() {
			ArrayList<Iznajmljivanje> neobrisanaIznajmljivanja = new ArrayList<Iznajmljivanje>();
			for (Iznajmljivanje i: svaIznajmljivanja) {
				if (i.isObrisanostIznajmljivanja() == false) {
					neobrisanaIznajmljivanja.add(i);
					
				}
			}
			return neobrisanaIznajmljivanja;
			
			}
		public ArrayList<TipClanarine> neobrisaneClanarine() {
			ArrayList<TipClanarine> neobrisaneClanarine = new ArrayList<TipClanarine>();
			for (TipClanarine tc: sveClanarine) {
				if (tc.isObrisanaClanarina() == false) {
					neobrisaneClanarine.add(tc);
				}
			}
			System.out.println(neobrisaneClanarine);
			return neobrisaneClanarine;
		}
		
		public ArrayList<Primerak> neobrisaniPrimerci() {
			ArrayList<Primerak> neobrisaniPrimerci = new ArrayList<Primerak>();
			for (Primerak p: sviPrimerci) {
				if (p.isObrisan() == false) {
					neobrisaniPrimerci.add(p);
				}
			}
			System.out.println(neobrisaniPrimerci);
			return neobrisaniPrimerci;
		}
		
		public ArrayList<Zanr> neobrisaniZanrovi() {
			ArrayList<Zanr> neobrisaniZanrovi = new ArrayList<Zanr>();
			for (Zanr z: sviZanrovi) {
				if (z.isObrisanZanr()== false) {
					neobrisaniZanrovi.add(z);
				}
			}
			System.out.println(neobrisaniZanrovi);
			return neobrisaniZanrovi;
		}
		

}
