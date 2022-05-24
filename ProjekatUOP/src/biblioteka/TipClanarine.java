package biblioteka;


public class TipClanarine {
	private static int idMaker=0;

	
	private String tip;
	private double cena;
	private int IDClanarine;
	
	public TipClanarine() {
		this.tip = "";
		this.cena = 0.0;
		this.IDClanarine = 0;
	}
	
	public TipClanarine(String tip, double cena,int IDClanarine) {
		this.tip = tip;
		this.cena = cena;
		this.IDClanarine = IDClanarine;
		TipClanarine.idMaker = IDClanarine;
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
	
	
	public static void setIdMaker(int count) {
		TipClanarine.idMaker = count;
	}
	
	public static int getUpdateMaker() {
		return TipClanarine.idMaker;
	}
	
	
 public int getIDClanarine() {
		return IDClanarine;
	}

	public void setIDClanarine(int iDClanarine) {
		IDClanarine = iDClanarine;
	}

	public static int getIdMaker() {
		return idMaker;
	}

@Override
 public String toString() {
	 return this.tip;
 }
 
 
}