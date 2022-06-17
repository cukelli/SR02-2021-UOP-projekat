package biblioteka;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public abstract class Zaposleni extends Osoba {
	
	protected Biblioteka biblioteka;
	
	
	protected double plata;
	protected String korIme;
	protected String lozinka;
	
	public Zaposleni() {
		super();
		this.plata = 0.0;
		this.korIme = "";
		this.lozinka = "";
	}
	
	public Zaposleni(int IDOsobe,String ime,String prezime,String JMBG,String adresa,boolean obrisan,Pol pol,double plata,String korIme,String lozinka) {
		super(IDOsobe,ime,prezime,JMBG,adresa,obrisan);
		this.plata = plata;
		this.korIme = korIme;
		this.lozinka = lozinka;
		this.pol = pol;
		this.obrisan = obrisan;
		
	}

	public double getPlata() {
		return plata;
	}

	public void setPlata(double plata) {
		this.plata = plata;
	}

	public String getKorIme() {
		return korIme;
	}

	public void setKorIme(String korIme) {
		this.korIme = korIme;
	}

	public String getLozinka() {
		return lozinka;
	}

	public void setLozinka(String lozinka) {
		this.lozinka = lozinka;
	}
	
	

	public Biblioteka getBiblioteka() {
		return biblioteka;
	}

	public void setBiblioteka(Biblioteka biblioteka) {
		this.biblioteka = biblioteka;
	}

	public void dodajKnjigu(int IDKnjige,String naslov,String originalniNaslov,String autor,int godinaObjavljivanja,Jezik jezikOriginala,String opis,Zanr zanr,Biblioteka biblioteka) throws IOException {
		ArrayList<Knjiga> sveKnjige = new ArrayList<Knjiga>();
		Knjiga knjiga = new Knjiga();
		knjiga.setIDKnjige(IDKnjige);
		knjiga.setNaslov(naslov);
		knjiga.setOriginalniNaslov(originalniNaslov);
		knjiga.setAutor(autor);
        knjiga.setGodinaObjavljivanja(godinaObjavljivanja);
        knjiga.setJezikOriginala(jezikOriginala);
        knjiga.setOpis(opis);
        knjiga.setZanr(zanr);
        sveKnjige.add(knjiga);
        Biblioteka.upisiFajl(sveKnjige, "src/fajlovi/noveKnjige.txt");       
             
	}
	
	public void dodajClanove(int IDOsobe,String ime,String prezime,String JMBG,String adresa,Pol pol,String brojClanske,LocalDate datumPoslednjeUplate,int brojUplacenihMeseci,TipClanarine tipClanarine,Biblioteka biblioteka) throws IOException {
		ArrayList<Clan> sviClanovi = new ArrayList<Clan>();
		Clan clan = new Clan();
		clan.setIDOsobe(Clan.getUpdateMaker()+1);
		clan.setIme(ime);
		clan.setPrezime(prezime);
		clan.setJMBG(JMBG);
		clan.setAdresa(adresa);
		//clan.setObrisan(obrisan);
		clan.setPol(pol);
		clan.setBrojClanske(brojClanske);
		clan.setDatumPoslednjeUplate(datumPoslednjeUplate);
	    clan.setBrojUplacenihMeseci(brojUplacenihMeseci);
	    clan.setAktivnost(true);
	    clan.setTipClanarine(tipClanarine);
	    sviClanovi.add(clan);
	    Biblioteka.upisiClanove(sviClanovi, "src/fajlovi/clanovi.txt");
	}
	
	public void dodajPrimerke(int IDPrimerka,Knjiga knjiga,int brojStrana,int godinaStampe,Jezik jezikStampe,Povez povez,Biblioteka biblioteka) throws IOException {
		ArrayList<Primerak> sviPrimerci = new ArrayList<Primerak>();
		Primerak primerak = new Primerak();
		primerak.setIDPrimerka(IDPrimerka);
		primerak.setKnjiga(knjiga);
		primerak.setBrojStrana(brojStrana);
		primerak.setGodinaStampe(godinaStampe);
		primerak.setJezikStampe(jezikStampe);
		//primerak.setIznajmljena(iznajmljena);
		primerak.setPovez(povez);
		//primerak.setObrisan(obrisan);
		sviPrimerci.add(primerak);
		Biblioteka.pisiPrimerke(sviPrimerci,"src/fajlovi/primerci.txt");

		
	}
	
	public void dodajTipClanarine(int ID,String tip,double cena,Biblioteka biblioteka) throws IOException {
		ArrayList<TipClanarine> sveClanarine = new ArrayList<TipClanarine>();
	    TipClanarine tipClanarine = new TipClanarine();
	     tipClanarine.setIDClanarine(ID);
	    tipClanarine.setCena(cena);
	    tipClanarine.setTip(tip);
	    sveClanarine.add(tipClanarine);
	    Biblioteka.upisiClanarinu(sveClanarine, "src/fajlovi/clanarine.txt");
	   
	}
	
	
	public void dodajZanr(String oznaka,String opis,int IDZanra,Biblioteka biblioteka) throws IOException {
		ArrayList<Zanr> sviZanrovi = new ArrayList<Zanr>();
		Zanr zanr = new Zanr();
		zanr.setOznaka(oznaka);
		zanr.setOpis(opis);
		zanr.setIDZanra(IDZanra);
		sviZanrovi.add(zanr);
		Biblioteka.upisiZanr(sviZanrovi, "src/fajlovi/zanrovi.txt");
	}
	
	
	
	
	public void brisiKnjigu(int ID, Biblioteka biblioteka) throws IOException {
		biblioteka.getKnjige();
		for (Knjiga k: biblioteka.getKnjige()) {
			if (k.getIDKnjige()==ID) { 
				k.setObrisana(true);
			}
				
			}
		  Biblioteka.izbrisiSadrzajFajla("src/fajlovi/noveKnjige.txt");
		  Biblioteka.upisiFajl(biblioteka.knjige, "src/fajlovi/noveKnjige.txt");
		
			
		}
	
	public void brisiClana(int ID,Biblioteka biblioteka) throws IOException {
        biblioteka.getSviClanovi();
        for (Clan c: biblioteka.getSviClanovi()) {
        	if (c.getIDOsobe()==ID) {
        		c.setObrisan(true);
        		
        	}
        	
        	Biblioteka.izbrisiSadrzajFajla("src/fajlovi/clanovi.txt");
        	Biblioteka.upisiClanove(biblioteka.sviClanovi,"src/fajlovi/clanovi.txt");
        }    	
	
	}
	
	public void brisiClanarinu(int ID,Biblioteka biblioteka) throws IOException {
        biblioteka.getSveClanarine();
        for (TipClanarine tc: biblioteka.getSveClanarine()) {
        	if (tc.getIDClanarine()==ID) {
        		tc.setObrisanaClanarina(true);
        		
        	}
        	
        	Biblioteka.izbrisiSadrzajFajla("src/fajlovi/clanarine.txt");
        	Biblioteka.upisiClanarinu(biblioteka.sveClanarine,"src/fajlovi/clanarine.txt");
        }    	
	
	}
	
	public void brisiPrimerak(int ID,Biblioteka biblioteka) throws IOException {
        biblioteka.getSviPrimerci();
        for (Primerak p: biblioteka.getSviPrimerci()) {
        	if (p.getIDPrimerka()==ID) {
        		p.setObrisan(true);
        		
        	}
        	
        	Biblioteka.izbrisiSadrzajFajla("src/fajlovi/primerci.txt");
        	Biblioteka.pisiPrimerke(biblioteka.sviPrimerci,"src/fajlovi/primerci.txt");
        }    	
	
	}
	
	public void brisiZanr(int ID,Biblioteka biblioteka) throws IOException {
        biblioteka.getSviZanrovi();
        for (Zanr z: biblioteka.getSviZanrovi()) {
        	if (z.getIDZanra()==ID) {
        		z.setObrisanZanr(true);
        		
        	}
        	
        	Biblioteka.izbrisiSadrzajFajla("src/fajlovi/zanrovi.txt");
        	Biblioteka.upisiZanr(biblioteka.sviZanrovi,"src/fajlovi/zanrovi.txt");
        }    	
	
	}
	
    public void updateKnjigu(int ID,String naslov,String originalniNaslov,String autor,int godinaObjavljivanja,Jezik jezikOriginala,String opis,Zanr zanr,Biblioteka biblioteka) throws IOException {
    	   for(Knjiga k: biblioteka.getKnjige()) {
    		   if (k.getIDKnjige() == ID) {
    			    k.setNaslov(originalniNaslov);
    			    k.setAutor(autor);
    			    k.setGodinaObjavljivanja(godinaObjavljivanja);
    			    k.setJezikOriginala(jezikOriginala);
    			    k.setOpis(opis);
    			    k.setZanr(zanr);
    			  //  k.setObrisana(obrisana);
    		   }
    		   Biblioteka.izbrisiSadrzajFajla("src/fajlovi/noveKnjige.txt");
    		   Biblioteka.upisiFajl(biblioteka.knjige, "src/fajlovi/noveKnjige.txt");
    	   }
    }
	
    public void updateClan(int ID,String ime,String prezime,String JMBG,String adresa,Pol pol,String brojClanske,LocalDate datumPoslednjeUplate,int brojUplacenihMeseci,TipClanarine tipClanarine,Biblioteka biblioteka) throws IOException {
    	for (Clan c: biblioteka.getSviClanovi()) {
    		if (c.getIDOsobe() == ID) {
    		    c.setIme(ime);
    		    c.setPrezime(prezime);
    		    c.setJMBG(JMBG);
    		    c.setAdresa(adresa);
    		    c.setObrisan(obrisan);
    		    c.setPol(pol);
    		    c.setBrojClanske(brojClanske);
    		    c.setDatumPoslednjeUplate(datumPoslednjeUplate);
    		    c.setBrojUplacenihMeseci(brojUplacenihMeseci);
    		   // c.setAktivnost(aktivnost);
    		    c.setTipClanarine(tipClanarine);
    		    
    		    Biblioteka.izbrisiSadrzajFajla("src/fajlovi/clanovi.txt");
    		    Biblioteka.upisiClanove(biblioteka.sviClanovi,"src/fajlovi/clanovi.txt");
    		 
    		}
    	}
    }
		
	
    public void updatePrimerak(int ID,Knjiga knjiga,int brojStrana,int godinaStampe, Jezik jezikStampe,Povez povez,Biblioteka biblioteka) throws IOException {
    	for (Primerak p: biblioteka.getSviPrimerci()) {
    		if (p.getIDPrimerka() == ID) {
    			p.setKnjiga(knjiga);
    			p.setBrojStrana(brojStrana);
    			p.setGodinaStampe(godinaStampe);
    			p.setJezikStampe(jezikStampe);
    			//p.setIznajmljena(iznajmljena);
    			p.setPovez(povez);
    			p.setObrisan(obrisan);
   			
    			
    			Biblioteka.izbrisiSadrzajFajla("src/fajlovi/primerci.txt");
    			Biblioteka.pisiPrimerke(biblioteka.sviPrimerci, "src/fajlovi/primerci.txt");
    		}
    	}
    }
    
    public void updateClanarina(String tip, double cena,int ID,Biblioteka biblioteka) throws IOException {
    	for (TipClanarine tc: biblioteka.getSveClanarine()) {
    		if (tc.getIDClanarine() == ID) {
    			tc.setTip(tip);
    			tc.setCena(cena);
    		//	tc.setObrisanaClanarina(obrisanaClanarina);
    			
    			Biblioteka.izbrisiSadrzajFajla("src/fajlovi/clanarine.txt");
    			Biblioteka.upisiClanarinu(biblioteka.sveClanarine,"src/fajlovi/clanarine.txt");
    		}
    	}
    }
    
    public void updateZanr(String oznaka,String opis,int ID,Biblioteka biblioteka) throws IOException {
    	for (Zanr z: biblioteka.getSviZanrovi()) {
    		if (z.getIDZanra() == ID) {
    			z.setOznaka(oznaka);
    			z.setOpis(opis);
    			//z.setObrisanZanr(obrisanZanr);
    			
    			Biblioteka.izbrisiSadrzajFajla("src/fajlovi/zanrovi.txt");
    			Biblioteka.upisiZanr(biblioteka.sviZanrovi, "src/fajlovi/zanrovi.txt");
    		}
    	}
    	
    }
    
    public void updateIznajmljivanje(int ID,Bibliotekar bibliotekar,Clan clan,LocalDate datumIznajmljivanja,LocalDate datumVracanja,Primerak iznajmljenPrimerak,Biblioteka biblioteka) throws IOException {
		for (Iznajmljivanje i: biblioteka.getSvaIznajmljivanja()) {
			if (i.getIDIznajmljivanja()==ID){
				i.setBibliotekar(bibliotekar);
				i.setClan(clan);
				i.setDatumIznajmljivanja(datumIznajmljivanja);
				i.setDatumVracanja(datumVracanja);
				i.setIznajmljenPrimerak(iznajmljenPrimerak);
				//i.setObrisanostIznajmljivanja(obrisanostIznajmljivanja);
	
			
				
				Biblioteka.izbrisiSadrzajFajla("src/fajlovi/iznajmljivanja.txt");
				Biblioteka.upisiIznajmljivanje(biblioteka.svaIznajmljivanja,"src/fajlovi/iznajmljivanja.txt");
				
			}
		}
	}
	

	
	@Override
	public String toString() {
		return "Zaposleni: [ime: " + this.ime + ",prezime: " + this.prezime + ",JMBG: " + this.JMBG + ",adresa: " + this.adresa + ",pol: " + this.pol + ",plata: " + this.plata + ",korisnicko ime: " + this.korIme + ",lozinka: " + this.lozinka + ", ID" + this.IDOsobe + "]";
	}
	

}
