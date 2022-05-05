package biblioteka;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Zanr {
	private String oznaka;
	private String opis;
	
	public Zanr() {
		this.oznaka = "";
		this.opis = "";
	}
	
	public Zanr(String oznaka,String opis) {
		this.oznaka = oznaka;
		this.opis = opis;
	}
	
	
	
 

public String getOznaka() {
		return oznaka;
	}

	public void setOznaka(String oznaka) {
		this.oznaka = oznaka;
	}

	public String getOpis() {
		return opis;
	}

	public void setOpis(String opis) {
		this.opis = opis;
	}

@Override
 public String toString() {
	 return this.oznaka;
			 }

public static ArrayList<Zanr> citajZanrove(String imeFajlaZanrovi) throws IOException {
	ArrayList<Zanr> zanrovi = new ArrayList<Zanr>();
	File fajlZanrova = new File(imeFajlaZanrovi);
	BufferedReader reader = new BufferedReader(new FileReader(fajlZanrova));
	String line = null;
	while ((line = reader.readLine()) != null) {
		String[] linijaZanr = line.split(";");
		String oznakaZanra = linijaZanr[0];
		String opisZanra = linijaZanr[1];
		Zanr zanr = new Zanr(oznakaZanra,opisZanra);
		zanrovi.add(zanr);
		System.out.println(zanr);
	
	}
	
	reader.close();
	return zanrovi;
	
	
}

}
