package biblioteka;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		
		

	try {
	 ArrayList<Biblioteka> procitanaBibliotekaTest = Biblioteka.citajBiblioteku("src/fajlovi/biblioteka.txt");
	
		
		
		ArrayList<Zanr> zanroviKnjiga = Biblioteka.citajZanrove("src/fajlovi/zanrovi.txt");
		ArrayList<Knjiga> procitaneKnjige = Biblioteka.citajFajl("src/fajlovi/noveKnjige.txt",zanroviKnjiga);
		
	
		ArrayList<TipClanarine> sveClanarine = Biblioteka.citajClanarine("src/fajlovi/clanarine.txt");
	
		
		ArrayList<Primerak> procitaniPrimerci = Biblioteka.citajPrimerke("src/fajlovi/primerci.txt",procitaneKnjige);
		
		ArrayList <Administrator> a = Biblioteka.citajAdministratore("src/fajlovi/administratori.txt");
		ArrayList<Bibliotekar> b = Biblioteka.citajBibliotekare("src/fajlovi/bibliotekari.txt");
		
		
		
		ArrayList<Clan> c = Biblioteka.citajClanove("src/fajlovi/clanovi.txt",sveClanarine);
		ArrayList<Iznajmljivanje> iznajmljeneKnjigeProcitane = Biblioteka.citajIznajmljivanja("src/fajlovi/iznajmljivanja.txt", c, b, procitaniPrimerci);
		
		
			
		
		ArrayList<TipClanarine> testClanarine = new ArrayList<TipClanarine>();
		ArrayList<Biblioteka> testBiblioteka = new ArrayList<Biblioteka>();
		ArrayList<Iznajmljivanje> iznajmljivanjaKnjiga = new ArrayList<Iznajmljivanje>();
		ArrayList<Administrator> admin = new ArrayList<Administrator>();
		ArrayList<Bibliotekar> bb = new ArrayList<Bibliotekar>();
		ArrayList<Knjiga> dodaneKnjige = new ArrayList<Knjiga>();
		ArrayList<Clan> cln = new ArrayList<Clan>();
		ArrayList<Primerak> primerci = new ArrayList<Primerak>();
		int getLibrarianID = Bibliotekar.getUpdateMaker()+1;
		int getClanID = Clan.getUpdateMaker()+1;
		int getAdminID = Administrator.getUpdateMaker()+1;
		int getIznajmljivanjeID = Iznajmljivanje.getUpdateMaker()+1;
		int getMembershipID = TipClanarine.getUpdateMaker()+1;

		
		Biblioteka bibliotekaTest = new Biblioteka("Biblioteka Desanka Maksimovic","Laze Teleckog 6","6044395","20-23h");
		Iznajmljivanje iznajmljivanjeTest = new Iznajmljivanje(getIznajmljivanjeID,b.get(0),c.get(0),LocalDate.parse("2010-03-03"),LocalDate.parse("2010-06-06"),procitaniPrimerci.get(0));
		Administrator administratorTest = new Administrator(getAdminID,"Mica","Micun","0102002735021","Stepe 3",false,Pol.MUSKI,23200.3,"wer","lozinka");
		Bibliotekar bibliotekarTest = new Bibliotekar(getLibrarianID,"Milica","Lakovic","0102002735021","Vojvode Stepe 3",false,Pol.ZENSKI,25000.00,"LAKI","123df");
		int getId = Knjiga.getUpdateMaker()+1;
		int getPrimerakID = Primerak.getUpdateMaker()+1;
		TipClanarine clanarinaTest = new TipClanarine("srednja",234.00,getMembershipID);
		Knjiga knjigaNovaTest = new Knjiga(getId,"Srpska Trilogija", "Srpska Trilogija", "Stevan Jakovljevic", 1915,Jezik.NEMACKI,"Kvalitetno stivo",zanroviKnjiga.get(0),true);
		
		
		
		Clan clanTest = new Clan(getClanID,"Sima","Markovic","0233234","Laze Kostica 3",false,Pol.MUSKI,"5",LocalDate.parse("2019-06-03"),3,true,sveClanarine.get(1));
		Primerak primerakTest = new Primerak(getPrimerakID,procitaneKnjige.get(0),567,2010,Jezik.ENGLESKI,true,Povez.MEKI,true);
		testClanarine.add(clanarinaTest);
		dodaneKnjige.add(knjigaNovaTest);
		cln.add(clanTest);
		bb.add(bibliotekarTest);
		admin.add(administratorTest);
		primerci.add(primerakTest);
		iznajmljivanjaKnjiga.add(iznajmljivanjeTest);
		testBiblioteka.add(bibliotekaTest);
		
		
		Biblioteka.upisiClanarinu(testClanarine, "src/fajlovi/clanarine.txt");
		Biblioteka.upisiBiblioteku(testBiblioteka,"src/fajlovi/biblioteka.txt");
		Biblioteka.upisiIznajmljivanje(iznajmljivanjaKnjiga, "src/fajlovi/iznajmljivanja.txt");
		Biblioteka.upisiFajl(dodaneKnjige, "src/fajlovi/noveKnjige.txt");
		Biblioteka.upisiClanove(cln, "src/fajlovi/clanovi.txt");
		Biblioteka.upisiBibliotekare(bb, "src/fajlovi/bibliotekari.txt");
		Biblioteka.upisiAdministratore(admin, "src/fajlovi/administratori.txt");
		Biblioteka.pisiPrimerke(primerci, "src/fajlovi/primerci.txt");
		
		ArrayList<Biblioteka> procitanaBiblioteka = Biblioteka.citajBiblioteku("src/fajlovi/biblioteka.txt");
	//	ArrayList<Knjiga> procitanaKnjiga = Biblioteka.citajFajl("src/fajlovi/noveKnjige.txt", zanroviKnjiga);

		
		
		for (Biblioteka bibl: procitanaBiblioteka) {
			//System.out.println(bibl);
		}
		
		ArrayList<Knjiga> sveKnjige2 = new ArrayList<Knjiga>();
		sveKnjige2.addAll(procitaneKnjige);
		sveKnjige2.addAll(dodaneKnjige);

		for (Knjiga knj: sveKnjige2) {
		//	System.out.println(knj);
		}

		
		
		
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	}

}
