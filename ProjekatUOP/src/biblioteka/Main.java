package biblioteka;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		
		

	try {
		ArrayList<Zanr> zanroviKnjiga = Zanr.citajZanrove("src/biblioteka/zanrovi.txt");
		ArrayList<Knjiga> knjige = Knjiga.citajFajl("src/biblioteka/noveKnjige.txt",zanroviKnjiga);
		
	
		ArrayList<TipClanarine> sveClanarine = TipClanarine.citajClanarine("src/biblioteka/clanarine.txt");
	
		
		ArrayList<Primerak> p = Primerak.citajPrimerke("src/biblioteka/primerci.txt",knjige);
		ArrayList <Administrator> a = Administrator.citajAdministratore("src/biblioteka/bibliotekari.txt");
		ArrayList<Bibliotekar> b = Bibliotekar.citajBibliotekare("src/biblioteka/bibliotekari.txt");
		
		
		
		ArrayList<Clan> c = Clan.citajClanove("src/biblioteka/clanovi.txt",sveClanarine);
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
		
		
		ArrayList<Administrator> admin = new ArrayList<Administrator>();
		ArrayList<Bibliotekar> bb = new ArrayList<Bibliotekar>();
		ArrayList<Knjiga> sveKnjige = new ArrayList<Knjiga>();
		ArrayList<Clan> cln = new ArrayList<Clan>();
		ArrayList<Primerak> primerci = new ArrayList<Primerak>();
		
		Administrator administratorTest = new Administrator("1234","Mica","Micun","0102002735021","Stepe 3",Pol.MUSKI,23200.3,"wer","lozinka");
		Bibliotekar bibliotekarTest = new Bibliotekar("12345","Milica","Lakovic","0102002735021","Vojvode Stepe 3",Pol.ZENSKI,25000.00,"LAKI","123df");
		Knjiga knjigaNovaTest = new Knjiga("01234","Srpska Trilogija", "Srpska Trilogija", "Stevan Jakovljevic", 1915,Jezik.NEMACKI,"Kvalitetno stivo",zanroviKnjiga.get(0));
		Clan clanTest = new Clan("001","Sima","Markovic","0233234","Laze Kostica 3",Pol.MUSKI,"5",LocalDate.parse("2019-06-03"),3,true,sveClanarine.get(1));
		Primerak primerakTest = new Primerak("545434",knjige.get(0),567,2010,Jezik.ENGLESKI,true,Povez.MEKI);
		sveKnjige.add(knjigaNovaTest);
		cln.add(clanTest);
		bb.add(bibliotekarTest);
		admin.add(administratorTest);
		primerci.add(primerakTest);
		
		Knjiga.upisiFajl(sveKnjige, "src/biblioteka/noveKnjige.txt");
		Clan.upisiClanove(cln, "src/biblioteka/clanovi.txt");
		Bibliotekar.upisiBibliotekare(bb, "src/biblioteka/bibliotekari.txt");
		Administrator.upisiAdministratore(admin, "src/biblioteka/administratori.txt");
		Primerak.pisiPrimerke(primerci, "src/biblioteka/primerci.txt");
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	}

}
