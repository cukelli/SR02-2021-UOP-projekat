package biblioteka;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		
		

	try {
		Biblioteka biblioteka = new Biblioteka();
        	
		
		
		biblioteka.citajZanrove("src/fajlovi/zanrovi.txt");
		biblioteka.citajFajl("src/fajlovi/noveKnjige.txt",biblioteka.sviZanrovi);
		biblioteka.citajFajl("src/fajlovi/noveKnjige.txt",biblioteka.sviZanrovi);
		
	
	  biblioteka.citajClanarine("src/fajlovi/clanarine.txt");
      biblioteka.citajPrimerke("src/fajlovi/primerci.txt",biblioteka.knjige);
		
		biblioteka.citajAdministratore("src/fajlovi/administratori.txt");
		biblioteka.citajBibliotekare("src/fajlovi/bibliotekari.txt");
		
		
		
		 biblioteka.citajClanove("src/fajlovi/clanovi.txt",biblioteka.sveClanarine);
	      biblioteka.citajIznajmljivanja("src/fajlovi/iznajmljivanja.txt", biblioteka.sviClanovi, biblioteka.sviBibliotekari, biblioteka.sviPrimerci);
		
		
			
		
		ArrayList<TipClanarine> dodateClanarine = new ArrayList<TipClanarine>();
		ArrayList<Biblioteka> testBiblioteka = new ArrayList<Biblioteka>();
		ArrayList<Iznajmljivanje> iznajmljivanjaKnjiga = new ArrayList<Iznajmljivanje>();
		ArrayList<Administrator> admin = new ArrayList<Administrator>();
		ArrayList<Bibliotekar> dodaniBibliotekari = new ArrayList<Bibliotekar>();
		ArrayList<Knjiga> dodaneKnjige = new ArrayList<Knjiga>();
		ArrayList<Clan> dodaniClanovi = new ArrayList<Clan>();
		ArrayList<Primerak> noviPrimerci = new ArrayList<Primerak>();
		int getLibrarianID = Bibliotekar.getUpdateMaker()+1;
		int getClanID = Clan.getUpdateMaker()+1;
		int getAdminID = Administrator.getUpdateMaker()+1;
		int getIznajmljivanjeID = Iznajmljivanje.getUpdateMaker()+1;
		int getMembershipID = TipClanarine.getUpdateMaker()+1;

		
		Biblioteka bibliotekaTest = new Biblioteka("Biblioteka Desanka Maksimovic","Laze Teleckog 6","6044395","20-23h");
		Iznajmljivanje iznajmljivanjeTest = new Iznajmljivanje(getIznajmljivanjeID,biblioteka.sviBibliotekari.get(0),biblioteka.sviClanovi.get(0),LocalDate.parse("2010-03-03"),LocalDate.parse("2010-06-06"),biblioteka.sviPrimerci.get(0),false);
		Administrator administratorTest = new Administrator(getAdminID,"Mica","Micun","0102002735021","Stepe 3",false,Pol.MUSKI,23200.3,"wer","lozinka");
		Bibliotekar bibliotekarTest = new Bibliotekar(getLibrarianID,"Milica","Lakovic","0102002735021","Vojvode Stepe 3",false,Pol.ZENSKI,25000.00,"LAKI","123df");
		int getId = Knjiga.getUpdateMaker()+1;
		int getPrimerakID = Primerak.getUpdateMaker()+1;
		TipClanarine clanarinaTest = new TipClanarine("srednja",234.00,getMembershipID,false);
		Knjiga knjigaNovaTest = new Knjiga(getId,"Srpska Trilogija", "Srpska Trilogija", "Stevan Jakovljevic", 1915,Jezik.NEMACKI,"Kvalitetno stivo",biblioteka.sviZanrovi.get(0),true);
		
		
		Clan clanTest = new Clan(getClanID,"Sima","Markovic","0233234","Laze Kostica 3",false,Pol.MUSKI,"5",LocalDate.parse("2019-06-03"),3,true,biblioteka.sveClanarine.get(1));
		Primerak primerakTest = new Primerak(getPrimerakID,biblioteka.knjige.get(0),567,2010,Jezik.ENGLESKI,true,Povez.MEKI,true);
		dodateClanarine.add(clanarinaTest);
		dodaneKnjige.add(knjigaNovaTest);
		dodaniClanovi.add(clanTest);
		dodaniBibliotekari.add(bibliotekarTest);
		admin.add(administratorTest);
		//noviPrimerci.add(primerakTest);
	//	iznajmljivanjaKnjiga.add(iznajmljivanjeTest);
		testBiblioteka.add(bibliotekaTest);
		
		
		Biblioteka.upisiClanarinu(dodateClanarine, "src/fajlovi/clanarine.txt");
		Biblioteka.upisiBiblioteku(testBiblioteka,"src/fajlovi/biblioteka.txt");
		Biblioteka.upisiIznajmljivanje(iznajmljivanjaKnjiga, "src/fajlovi/iznajmljivanja.txt");
		Biblioteka.upisiFajl(dodaneKnjige, "src/fajlovi/noveKnjige.txt");
		Biblioteka.upisiClanove(dodaniClanovi, "src/fajlovi/clanovi.txt");
		Biblioteka.upisiBibliotekare(dodaniBibliotekari, "src/fajlovi/bibliotekari.txt");
		Biblioteka.upisiAdministratore(admin, "src/fajlovi/administratori.txt");
		Biblioteka.pisiPrimerke(noviPrimerci, "src/fajlovi/primerci.txt");
		
		

		Biblioteka.izbrisiSadrzajFajla("src/fajlovi/biblioteka.txt");
	
		
		ArrayList<Knjiga> sveKnjige2 = new ArrayList<Knjiga>();
		//sveKnjige2.addAll(procitaneKnjige);
		sveKnjige2.addAll(dodaneKnjige);

		
		
         administratorTest.brisiKnjigu(13, biblioteka);
         administratorTest.brisiClana(1002, biblioteka);
         administratorTest.brisiClanarinu(2, biblioteka);
         administratorTest.brisiPrimerak(35, biblioteka);
         administratorTest.brisiZanr(3, biblioteka);
         administratorTest.brisiBibliotekara(301, biblioteka);
         bibliotekarTest.brisiIznajmljivanje(6001, biblioteka);
         bibliotekarTest.iznajmiKnjigu(14, bibliotekarTest, clanTest, LocalDate.parse("2020-03-03"),LocalDate.parse("2020-04-04"), primerakTest);
         administratorTest.brisiAdministratora(234, biblioteka);
		
		
		
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	}

}
