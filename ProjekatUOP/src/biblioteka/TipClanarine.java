package biblioteka;

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
}
