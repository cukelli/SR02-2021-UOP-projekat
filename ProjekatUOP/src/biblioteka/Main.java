package biblioteka;

public class Main {

	public static void main(String[] args) {
		Zaposleni zaposleni = new Zaposleni("Anastasija","Cukelj","0102002735021","4.jula,25",Pol.ZENSKI,23000.0,"cukelli","anastasija123");
		Zanr zanr = new Zanr("rom","asdasd");
		Knjiga knjiga = new Knjiga("Mali Princ","Little Prince","Zan klod",1999,"srpski","okokok",zanr);
		Primerak primerak = new Primerak(knjiga,230,1998,"srpski",false,Povez.MEKI);
		
    System.out.println(zaposleni);
    System.out.println(knjiga);
    System.out.println(primerak);
	}

}
