package biblioteka;

import java.io.IOException;
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
		ArrayList<Knjiga> k = Knjiga.citajFajl("src/biblioteka/noveKnjige.txt");
		for (Knjiga kk: k) {
			System.out.println(kk);
		}
		
		
		ArrayList<Knjiga> cc = new ArrayList<Knjiga>();
		
		Knjiga knjigaNovaTest = new Knjiga("Srpska Trilogija", "Srpska Trilogija", "Stevan Jakovljevic", 1915,Jezik.NEMACKI,"Kvalitetno stivo",new Zanr("Kvalitet", "Stivo"));
		cc.add(knjigaNovaTest);
		Knjiga.upisiFajl(cc, "src/biblioteka/noveKnjige.txt");
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	}

}
