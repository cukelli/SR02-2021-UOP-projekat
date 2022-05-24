package biblioteka;


public class Zanr {
	private static int idMaker=0;
	
	private String oznaka;
	private String opis;
	private int IDZanra;
	
	public Zanr() {
		this.IDZanra = IDZanra;
		this.oznaka = "";
		this.opis = "";
	}
	
	public Zanr(String oznaka,String opis,int IDZanra) {
		this.oznaka = oznaka;
		this.opis = opis;
		this.IDZanra = IDZanra;
		Zanr.idMaker = IDZanra;
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
	

	public static void setIdMaker(int count) {
	    Zanr.idMaker = count;
	}
	
	public static int getUpdateMaker() {
		return Zanr.idMaker;
	}

	public int getIDZanra() {
		return IDZanra;
	}

	public void setIDZanra(int iDZanra) {
		IDZanra = iDZanra;
	}

@Override
 public String toString() {
	 return this.oznaka;
			 }



}
