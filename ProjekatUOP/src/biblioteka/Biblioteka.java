package biblioteka;

import java.time.LocalDateTime;

public class Biblioteka {
	private String naziv;
	private String adresa;
	private String telefon;
	private LocalDateTime radnoVreme;
	
	public Biblioteka() {
		this.naziv = "";
		this.adresa = "";
		this.telefon = "";
		this.radnoVreme = null;
	}	
	
	public Biblioteka(String naziv,String adresa,String telefon,LocalDateTime radnoVreme) {
		this.naziv = naziv;
		this.adresa = adresa;
		this.telefon = telefon;
		this.radnoVreme = radnoVreme;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public String getAdresa() {
		return adresa;
	}

	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}

	public String getTelefon() {
		return telefon;
	}

	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}

	public LocalDateTime getRadnoVreme() {
		return radnoVreme;
	}

	public void setRadnoVreme(LocalDateTime radnoVreme) {
		this.radnoVreme = radnoVreme;
	}	
	
	@Override
	public String toString() {
		return "Biblioteka [naziv: " + this.naziv + ",adresa: " + this.adresa + ",telefon: " + this.telefon + ",radno vreme: " + this.radnoVreme + "]";
	}

}
