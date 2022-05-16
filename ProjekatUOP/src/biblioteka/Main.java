package biblioteka;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		
		

	try {
		ArrayList<Biblioteka> procitanaBiblioteka = Biblioteka.citajBiblioteku("src/fajlovi/biblioteka.txt");
		
		
		ArrayList<Zanr> zanroviKnjiga = Biblioteka.citajZanrove("src/fajlovi/zanrovi.txt");
		ArrayList<Knjiga> knjige = Biblioteka.citajFajl("src/fajlovi/noveKnjige.txt",zanroviKnjiga);
		
	
		ArrayList<TipClanarine> sveClanarine = Biblioteka.citajClanarine("src/fajlovi/clanarine.txt");
	
		
		ArrayList<Primerak> p = Biblioteka.citajPrimerke("src/fajlovi/primerci.txt",knjige);
		ArrayList <Administrator> a = Biblioteka.citajAdministratore("src/fajlovi/administratori.txt");
		ArrayList<Bibliotekar> b = Biblioteka.citajBibliotekare("src/fajlovi/bibliotekari.txt");
		
		
		
		ArrayList<Clan> c = Biblioteka.citajClanove("src/fajlovi/clanovi.txt",sveClanarine);
		ArrayList<Iznajmljivanje> iznajmljeneKnjigeProcitane = Biblioteka.citajIznajmljivanja("src/fajlovi/iznajmljivanja.txt", c, b, p);
		
		
			

		for (Knjiga kk: knjige) {
			System.out.println(kk);
		for (Clan cll: c) {
			//System.out.println(cll);
		}
		for (Bibliotekar bb: b) {
			//System.out.println(bb);
		}
		
		for (Administrator ad: a) {
			//System.out.println(ad);
		}
			
			
		}
		
		
		ArrayList<Biblioteka> testBiblioteka = new ArrayList<Biblioteka>();
		ArrayList<Iznajmljivanje> iznajmljivanjaKnjiga = new ArrayList<Iznajmljivanje>();
		ArrayList<Administrator> admin = new ArrayList<Administrator>();
		ArrayList<Bibliotekar> bb = new ArrayList<Bibliotekar>();
		ArrayList<Knjiga> sveKnjige = new ArrayList<Knjiga>();
		ArrayList<Clan> cln = new ArrayList<Clan>();
		ArrayList<Primerak> primerci = new ArrayList<Primerak>();
		
		Biblioteka bibliotekaTest = new Biblioteka("Biblioteka Desanka Maksimovic","Laze Teleckog 6","6044395","20-23h");
		Iznajmljivanje iznajmljivanjeTest = new Iznajmljivanje("1235a",b.get(0),c.get(0),LocalDate.parse("2010-03-03"),LocalDate.parse("2010-06-06"),p.get(0));
		Administrator administratorTest = new Administrator("1234","Mica","Micun","0102002735021","Stepe 3",false,Pol.MUSKI,23200.3,"wer","lozinka");
		Bibliotekar bibliotekarTest = new Bibliotekar("12345","Milica","Lakovic","0102002735021","Vojvode Stepe 3",false,Pol.ZENSKI,25000.00,"LAKI","123df");
		Knjiga knjigaNovaTest = new Knjiga("01234","Srpska Trilogija", "Srpska Trilogija", "Stevan Jakovljevic", 1915,Jezik.NEMACKI,"Kvalitetno stivo",zanroviKnjiga.get(0),true);
		Clan clanTest = new Clan("001","Sima","Markovic","0233234","Laze Kostica 3",false,Pol.MUSKI,"5",LocalDate.parse("2019-06-03"),3,true,sveClanarine.get(1));
		Primerak primerakTest = new Primerak("545434",knjige.get(0),567,2010,Jezik.ENGLESKI,true,Povez.MEKI,true);
		sveKnjige.add(knjigaNovaTest);
		cln.add(clanTest);
		bb.add(bibliotekarTest);
		admin.add(administratorTest);
		primerci.add(primerakTest);
		iznajmljivanjaKnjiga.add(iznajmljivanjeTest);
		testBiblioteka.add(bibliotekaTest);
		
		Biblioteka.upisiBiblioteku(testBiblioteka,"src/fajlovi/biblioteka.txt");
		Biblioteka.upisiIznajmljivanje(iznajmljivanjaKnjiga, "src/fajlovi/iznajmljivanja.txt");
		Biblioteka.upisiFajl(sveKnjige, "src/fajlovi/noveKnjige.txt");
		Biblioteka.upisiClanove(cln, "src/fajlovi/clanovi.txt");
		Biblioteka.upisiBibliotekare(bb, "src/fajlovi/bibliotekari.txt");
		Biblioteka.upisiAdministratore(admin, "src/fajlovi/administratori.txt");
		Biblioteka.pisiPrimerke(primerci, "src/fajlovi/primerci.txt");
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	}

}
