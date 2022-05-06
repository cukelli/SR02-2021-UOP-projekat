package biblioteka;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Primerak {
	private String IDPrimerka;
	private Knjiga knjiga;
	private int brojStrana;
	private int godinaStampe;
	private Jezik jezikStampe;
	private boolean iznajmljena;
	private Povez povez;
	
	public Primerak() {
		this.IDPrimerka = "";
		this.knjiga = null;
		this.brojStrana = 0;
		this.godinaStampe = 0;
		this.jezikStampe = null;
		this.iznajmljena = false;
		this.povez = null;
	}
	
	public Primerak(String IDPrimerka,Knjiga knjiga,int brojStrana,int godinaStampe, Jezik jezikStampe,boolean iznajmljena,Povez povez) {
		this.IDPrimerka = IDPrimerka;
		this.knjiga = knjiga;
		this.brojStrana = brojStrana;
		this.godinaStampe = godinaStampe;
		this.jezikStampe = jezikStampe;
		this.iznajmljena = iznajmljena;
		this.povez = povez;
	}

	public Knjiga getKnjiga() {
		return knjiga;
	}

	public void setKnjiga(Knjiga knjiga) {
		this.knjiga = knjiga;
	}

	public int getBrojStrana() {
		return brojStrana;
	}

	public void setBrojStrana(int brojStrana) {
		this.brojStrana = brojStrana;
	}

	public int getGodinaStampe() {
		return godinaStampe;
	}

	public void setGodinaStampe(int godinaStampe) {
		this.godinaStampe = godinaStampe;
	}

	public Jezik getJezikStampe() {
		return jezikStampe;
	}

	public void setJezikStampe(Jezik jezikStampe) {
		this.jezikStampe = jezikStampe;
	}

	public boolean isIznajmljena() {
		return iznajmljena;
	}

	public void setIznajmljena(boolean iznajmljena) {
		this.iznajmljena = iznajmljena;
	}

	public Povez getPovez() {
		return povez;
	}

	public void setPovez(Povez povez) {
		this.povez = povez;
	}
	
	
	
	public String getIDPrimerka() {
		return IDPrimerka;
	}

	public void setIDPrimerka(String iDPrimerka) {
		IDPrimerka = iDPrimerka;
	}

	@Override
	
	public String toString() {
		return "primerak: [Knjiga: " + ", naslov: " + this.knjiga.getNaslov() + ",broj strana: " + this.brojStrana + ",povez " + this.povez + ",godina stampe: " + this.godinaStampe + ",jezik stampe: " + this.jezikStampe + ",iznajmljena:" + this.iznajmljena + ", ID:" + this.IDPrimerka;
	}
	
	public static ArrayList<Primerak> citajPrimerke(String fajlPrimeraka,ArrayList<Knjiga> knjige) throws IOException {
		ArrayList<Primerak> sviPrimerci = new ArrayList<Primerak>();
		File fajl = new File(fajlPrimeraka);
		BufferedReader reader = new BufferedReader(new FileReader(fajl));
		String line = null;
		while ((line = reader.readLine()) != null) {
			String [] nizPrimerka = line.split(";");
			String IDPrimerka = nizPrimerka[0];
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
			Primerak primerak = new Primerak(IDPrimerka,tmpKnjiga,brojStranaPrimerka,godinaStampePrimerka,defJezikPrimerka,iznajmljenostPrimerka,defPovezPrimerka);
			sviPrimerci.add(primerak);			
			
		}
		reader.close();
		return sviPrimerci;
		
		
	}
	public static void pisiPrimerke(ArrayList<Primerak> primerciUpis,String fajlUpisPrimeraka) throws IOException {
		ArrayList<Primerak> primerci = primerciUpis;
		File fajl = new File(fajlUpisPrimeraka);
		BufferedWriter writer = new BufferedWriter(new FileWriter(fajl, true));
		
		for (Primerak p: primerci) {
			String sbPrimerak = p.getIDPrimerka() + ";" + p.getKnjiga().getNaslov() + ";" + p.getBrojStrana() + ";" + p.getGodinaStampe() + ";" + p.getJezikStampe() + ";" + p.isIznajmljena() + ";" + p.getPovez();
			writer.write(sbPrimerak);
			writer.newLine();
			
		}
		writer.close();
	}
	
	

}
