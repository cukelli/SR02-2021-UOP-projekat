package biblioteka;



public class Knjiga {
	private Biblioteka biblioteka;
	
	private static int idMaker = 0;
	private int IDKnjige;
	private String naslov;
	private String originalniNaslov;
	private String autor;
	private int godinaObjavljivanja;
	private Jezik jezikOriginala;
	private String opis;
	private Zanr zanr;
	private boolean obrisana;
	
	
	
	public Knjiga() {
		
		this.IDKnjige = 0;
		this.naslov = "";
		this.originalniNaslov = "";
		this.autor = "";
		this.godinaObjavljivanja = 0;
		this.jezikOriginala = null;
		this.opis = "";
		this.zanr = null;
		this.obrisana = false;
	}
	
	public Knjiga(int IDKnjige,String naslov,String originalniNaslov,String autor,int godinaObjavljivanja,Jezik jezikOriginala,String opis,Zanr zanr,boolean obrisana) {
        this.IDKnjige = IDKnjige;
        Knjiga.idMaker = IDKnjige;
		this.naslov = naslov;
		this.originalniNaslov = originalniNaslov;
		this.autor = autor;
		this.godinaObjavljivanja = godinaObjavljivanja;
		this.jezikOriginala = jezikOriginala;
		this.opis = opis;
		this.zanr = zanr;
		this.obrisana = obrisana;
		
		
	}
	

	public int getIDKnjige() {
		return IDKnjige;
	}

	public void setIDKnjige(int iDKnjige) {
		this.IDKnjige = iDKnjige;
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
	
	
	
	public boolean isObrisana() {
		return obrisana;
	}

	public void setObrisana(boolean obrisana) {
		this.obrisana = obrisana;
	}
	
	public static void setIdMaker(int count) {
		Knjiga.idMaker = count;
	}
	
	public static int getUpdateMaker() {
		return Knjiga.idMaker;
	}
	
	
	
	
	

	public static int getIdMaker() {
		return idMaker;
	}

	@Override
	public String toString() {
		
		
		return "Knjiga [naslov: " + this.naslov + ",originalni naslov: " + this.originalniNaslov + ",autor: " + this.autor + ",godina objavljivanja: " + this.godinaObjavljivanja + ",jezik originala: " + this.jezikOriginala + ",opis: " + this.opis + ",zanr: " + this.zanr.getOznaka() + ", ID:" + this.getIDKnjige() + "\n";
	}
	
	
	
}
