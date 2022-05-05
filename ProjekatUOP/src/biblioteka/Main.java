package biblioteka;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
//		Zaposleni zaposleni = new Zaposleni("Anastasija","Cukelj","0102002735021","4.jula,25",Pol.ZENSKI,23000.0,"cukelli","anastasija123");
//		Zanr zanr = new Zanr("rom","asdasd");
//		Knjiga knjiga = new Knjiga("Mali Princ","Little Prince","Zan klod",1999,Jezik.NEMACKI,"okokok",zanr);
//		Primerak primerak = new Primerak(knjiga,230,1998,Jezik.SRPSKI,false,Povez.MEKI);
		
//    System.out.println(zaposleni);
//    System.out.println(knjiga);
//    System.out.println(primerak);
	try {
		ArrayList <Administrator> a = Administrator.citajAdministratore("src/biblioteka/bibliotekari.txt");
		ArrayList<Bibliotekar> b = Bibliotekar.citajBibliotekare("src/biblioteka/bibliotekari.txt");
		ArrayList<Knjiga> k = Knjiga.citajFajl("src/biblioteka/noveKnjige.txt");
		ArrayList<Clan> c = Clan.citajClanove("src/biblioteka/clanovi.txt");
		for (Knjiga kk: k) {
			System.out.println(kk);
		for (Clan cll: c) {
			System.out.println(cll);
		}
		for (Bibliotekar bb: b) {
			System.out.println(bb);
		}
		
		for (Administrator ad: a) {
			System.out.println(ad);
		}
			
			
		}
		
		ArrayList<Administrator> admin = new ArrayList<Administrator>();
		ArrayList<Bibliotekar> bb = new ArrayList<Bibliotekar>();
		ArrayList<Knjiga> cc = new ArrayList<Knjiga>();
		ArrayList<Clan> cln = new ArrayList<Clan>();
		
		Administrator administratorTest = new Administrator("1234","Mica","Micun","0102002735021","Stepe 3",Pol.MUSKI,23200.3,"wer","lozinka");
		Bibliotekar bibliotekarTest = new Bibliotekar("12345","Milica","Lakovic","0102002735021","Vojvode Stepe 3",Pol.ZENSKI,25000.00,"LAKI","123df");
		Knjiga knjigaNovaTest = new Knjiga("01234","Srpska Trilogija", "Srpska Trilogija", "Stevan Jakovljevic", 1915,Jezik.NEMACKI,"Kvalitetno stivo",new Zanr("Kvalitet", "Stivo"));
		Clan clanTest = new Clan("001","Sima","Markovic","0233234","Laze Kostica 3",Pol.MUSKI,"5",LocalDate.parse("2019-06-03"),3,true,new TipClanarine("odrasla",250.00));
		cc.add(knjigaNovaTest);
		cln.add(clanTest);
		bb.add(bibliotekarTest);
		admin.add(administratorTest);
		Knjiga.upisiFajl(cc, "src/biblioteka/noveKnjige.txt");
		Clan.upisiClanove(cln, "src/biblioteka/clanovi.txt");
		Bibliotekar.upisiBibliotekare(bb, "src/biblioteka/bibliotekari.txt");
		Administrator.upisiAdministratore(admin, "src/biblioteka/administratori.txt");
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	}

}
