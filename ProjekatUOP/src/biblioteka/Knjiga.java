package biblioteka;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Knjiga {
	private String IDKnjige;
	private String naslov;
	private String originalniNaslov;
	private String autor;
	private int godinaObjavljivanja;
	private Jezik jezikOriginala;
	private String opis;
	private Zanr zanr;
	
	public Knjiga() {
		this.IDKnjige = "";
		this.naslov = "";
		this.originalniNaslov = "";
		this.autor = "";
		this.godinaObjavljivanja = 0;
		this.jezikOriginala = null;
		this.opis = "";
		this.zanr = null;
	}
	
	public Knjiga(String IDKnjige,String naslov,String originalniNaslov,String autor,int godinaObjavljivanja,Jezik jezikOriginala,String opis,Zanr zanr) {
		this.IDKnjige = IDKnjige;
		this.naslov = naslov;
		this.originalniNaslov = originalniNaslov;
		this.autor = autor;
		this.godinaObjavljivanja = godinaObjavljivanja;
		this.jezikOriginala = jezikOriginala;
		this.opis = opis;
		this.zanr = zanr;
	}
	

	public String getIDKnjige() {
		return IDKnjige;
	}

	public void setIDKnjige(String iDKnjige) {
		IDKnjige = iDKnjige;
	}

	public String getNaslov() {
		return naslov;
	}

	public void setNaslov(String naslov) {
		this.naslov = naslov;
	}

	public String getOriginalniNaslov() {
		return originalniNaslov;
	}

	public void setOriginalniNaslov(String originalniNaslov) {
		this.originalniNaslov = originalniNaslov;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public int getGodinaObjavljivanja() {
		return godinaObjavljivanja;
	}

	public void setGodinaObjavljivanja(int godinaObjavljivanja) {
		this.godinaObjavljivanja = godinaObjavljivanja;
	}

	public Jezik getJezikOriginala() {
		return jezikOriginala;
	}

	public void setJezikOriginala(Jezik jezikOriginala) {
		this.jezikOriginala = jezikOriginala;
	}

	public String getOpis() {
		return opis;
	}

	public void setOpis(String opis) {
		this.opis = opis;
	}

	public Zanr getZanr() {
		return zanr;
	}

	public void setZanr(Zanr zanr) {
		this.zanr = zanr;
	}
	
	@Override
	public String toString() {
		return "Knjiga [naslov: " + this.naslov + ",originalni naslov: " + this.originalniNaslov + ",autor: " + this.autor + ",godina objavljivanja: " + this.godinaObjavljivanja + ",jezik originala: " + this.jezikOriginala + ",opis: " + this.opis + ",zanr: " + this.zanr.getOznaka() + ", ID:" + this.IDKnjige;
	}
	
	public static ArrayList<Knjiga> citajFajl(String imeFajla) throws IOException {
		ArrayList<Knjiga> knjige = new ArrayList<Knjiga>();
		File fajl = new File(imeFajla);
		BufferedReader reader = new BufferedReader(new FileReader(fajl));

		String line = null;
		while ((line = reader.readLine()) != null) {
			String [] niz = line.split(";");
			String naslov = niz[0];
			String originalniNaslov = niz[1];
			String autor = niz[2];
			int godinaObjavljivanja = Integer.parseInt(niz[3]);
			String jezikOriginala = niz[4];
			Jezik defJezik = Jezik.ENGLESKI;
			for (Jezik j: Jezik.values()) {
				if (j.name().equalsIgnoreCase(jezikOriginala)) {
					defJezik = j;
				}
			}
			String opis = niz[5];
			Zanr zanr = new Zanr(opis,niz[6]);
			
			
			
			String IDKnjige = niz[7];
			Knjiga knjiga = new Knjiga(IDKnjige,naslov,originalniNaslov,autor,godinaObjavljivanja,defJezik,opis,zanr);
			knjige.add(knjiga);
			
		}
		reader.close();
		return knjige;
		
		
	}

	public static void upisiFajl(ArrayList<Knjiga> knjigeUpis, String imeFajla) throws IOException {
		ArrayList<Knjiga> knjige = knjigeUpis;
		File fajl = new File(imeFajla);
		BufferedWriter writer = new BufferedWriter(new FileWriter(fajl, true));

		for (Knjiga k: knjige) {
			String sb = k.getNaslov() + ";" + k.getOriginalniNaslov() + ";" + k.getAutor() + ";" + k.getGodinaObjavljivanja() + ";" + k.getJezikOriginala() + ";" + k.getOpis() + ";" + k.getZanr() + ";" + k.getIDKnjige();
			writer.write(sb);
			writer.newLine();
		}
		
		writer.close();
	}
	
}
