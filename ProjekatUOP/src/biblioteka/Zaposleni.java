package biblioteka;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

abstract class Zaposleni extends Osoba {
	
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

	public void DodajKnjigu(int IDKnjige,String naslov,String originalniNaslov,String autor,int godinaObjavljivanja,Jezik jezikOriginala,String opis,Zanr zanr,boolean obrisana) throws IOException {
		ArrayList<Knjiga> sveKnjige = new ArrayList<Knjiga>();
		Knjiga knjiga = new Knjiga();
		knjiga.setIDKnjige(Knjiga.getUpdateMaker());
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
	
	public void dodajClanove(int IDOsobe,String ime,String prezime,String JMBG,String adresa,boolean obrisan,Pol pol,String brojClanske,LocalDate datumPoslednjeUplate,int brojUplacenihMeseci,boolean aktivnost,TipClanarine tipClanarine) throws IOException {
		ArrayList<Clan> sviClanovi = new ArrayList<Clan>();
		Clan clan = new Clan();
		clan.setIDOsobe(Clan.getUpdateMaker());
		clan.setIme(ime);
		clan.setPrezime(prezime);
		clan.setJMBG(JMBG);
		clan.setAdresa(adresa);
		clan.setObrisan(obrisan);
		clan.setPol(pol);
		clan.setBrojClanske(brojClanske);
		clan.setDatumPoslednjeUplate(datumPoslednjeUplate);
	    clan.setBrojUplacenihMeseci(brojUplacenihMeseci);
	    clan.setAktivnost(aktivnost);
	    clan.setTipClanarine(tipClanarine);
	    sviClanovi.add(clan);
	    Biblioteka.upisiClanove(sviClanovi, "src/fajlovi/clanovi.txt");
	}
	
	public void dodajPrimerke(int IDPrimerka,Knjiga knjiga,int brojStrana,int godinaStampe,Jezik jezikStampe,boolean iznajmljena,Povez povez,boolean obrisan) throws IOException {
		ArrayList<Primerak> sviPrimerci = new ArrayList<Primerak>();
		Primerak primerak = new Primerak();
		primerak.setIDPrimerka(IDPrimerka);
		primerak.setKnjiga(knjiga);
		primerak.setBrojStrana(brojStrana);
		primerak.setGodinaStampe(godinaStampe);
		primerak.setJezikStampe(jezikStampe);
		primerak.setIznajmljena(iznajmljena);
		primerak.setPovez(povez);
		primerak.setObrisan(obrisan);
		sviPrimerci.add(primerak);
		Biblioteka.pisiPrimerke(sviPrimerci,"src/fajlovi/primerci.txt");

		
	}
	
	public void dodajTipClanarine(String tip,double cena) throws IOException {
		ArrayList<TipClanarine> sveClanarine = new ArrayList<TipClanarine>();
	    TipClanarine tipClanarine = new TipClanarine();
	    tipClanarine.setCena(cena);
	    tipClanarine.setTip(tip);
	    sveClanarine.add(tipClanarine);
	    Biblioteka.upisiClanarinu(sveClanarine, "src/fajlovi/clanarine.txt");
	   
	}
	
	
	public void dodajZanr(String oznaka,String opis,int IDZanra) {
		ArrayList<Zanr> sviZanrovi = new ArrayList<Zanr>();
		Zanr zanr = new Zanr();
		zanr.setOznaka(oznaka);
		zanr.setOpis(opis);
		zanr.setIDZanra(IDZanra);
	}
	
	@Override
	public String toString() {
		return "Zaposleni: [ime: " + this.ime + ",prezime: " + this.prezime + ",JMBG: " + this.JMBG + ",adresa: " + this.adresa + ",pol: " + this.pol + ",plata: " + this.plata + ",korisnicko ime: " + this.korIme + ",lozinka: " + this.lozinka + ", ID" + this.IDOsobe + "]";
	}
	

}
