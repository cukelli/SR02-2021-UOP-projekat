package biblioteka;


public class TipClanarine {
	private static int idMaker=0;

	
	private String tip;
	private double cena;
	private int IDClanarine;
	private boolean obrisanaClanarina;
	
	public TipClanarine() { 
		this.tip = "";
		this.cena = 0.0;
		this.IDClanarine = 0;
		this.obrisanaClanarina = false;
	}
	
	public TipClanarine(String tip, double cena,int IDClanarine,boolean obrisanaClanarina) {
		this.tip = tip;
		this.cena = cena;
		this.IDClanarine = IDClanarine;
		TipClanarine.idMaker = IDClanarine;
		this.obrisanaClanarina = obrisanaClanarina;
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
	
	

public boolean isObrisanaClanarina() {
		return obrisanaClanarina;
	}

	public void setObrisanaClanarina(boolean obrisanaClanarina) {
		this.obrisanaClanarina = obrisanaClanarina;
	}

@Override
 public String toString() {
	 return this.tip;
 }
 
 
}