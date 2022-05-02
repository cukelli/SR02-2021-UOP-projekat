package biblioteka;

public class Knjiga {
	private String naslov;
	private String originalniNaslov;
	private String autor;
	private int godinaObjavljivanja;
	private String jezikOriginala;
	private String opis;
	private Zanr zanr;
	
	public Knjiga() {
		this.naslov = "";
		this.originalniNaslov = "";
		this.autor = "";
		this.godinaObjavljivanja = 0;
		this.jezikOriginala = "";
		this.opis = "";
		this.zanr = null;
	}
	
	public Knjiga(String naslov,String originalniNaslov,String autor,int godinaObjavljivanja,String jezikOriginala,String opis,Zanr zanr) {
		this.naslov = naslov;
		this.originalniNaslov = originalniNaslov;
		this.autor = autor;
		this.godinaObjavljivanja = godinaObjavljivanja;
		this.jezikOriginala = jezikOriginala;
		this.opis = opis;
		this.zanr = zanr;
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

	public String getJezikOriginala() {
		return jezikOriginala;
	}

	public void setJezikOriginala(String jezikOriginala) {
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
		return "Knjiga [naslov: " + this.naslov + ",originalni naslov: " + this.originalniNaslov + ",autor: " + this.autor + ",godina objavljivanja: " + this.godinaObjavljivanja + ",jezik originala: " + this.jezikOriginala + ",opis: " + this.opis + ",zanr: " + this.zanr.getOznaka();
	}

}
