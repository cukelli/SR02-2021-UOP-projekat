package biblioteka;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class TipClanarine {
	
	private String tip;
	private double cena;
	
	public TipClanarine() {
		this.tip = "";
		this.cena = 0.0;
	}
	
	public TipClanarine(String tip, double cena) {
		this.tip = tip;
		this.cena = cena;
	}

	public String getTip() {
		return tip;
	}

	public void setTip(String tip) {
		this.tip = tip;
	}

	public double getCena() {
		return cena;
	}

	public void setCena(double cena) {
		this.cena = cena;
	} 
	
 @Override
 public String toString() {
	 return this.tip;
 }
 
 public static ArrayList<TipClanarine> citajClanarine(String imeFajlaClanarine) throws IOException {
		ArrayList<TipClanarine> clanarine = new ArrayList<TipClanarine>();
		File fajlClanarine = new File(imeFajlaClanarine);
		BufferedReader reader = new BufferedReader(new FileReader(fajlClanarine));
		String line = null;
		while ((line = reader.readLine()) != null) {
			String[] linijaClanarine = line.split(";");
			String tipClanarine = linijaClanarine[0];
			double cenaClanarine = Double.parseDouble(linijaClanarine[1]);
			TipClanarine clanarina = new TipClanarine(tipClanarine,cenaClanarine);
			clanarine.add(clanarina);
		
		}
		reader.close();
		return clanarine;
 
 
}
}