package biblioteka;

import java.time.LocalDate;

public class Iznajmljivanja {
	
	private Zaposleni zaposleni;
	private Clan clan;
	private LocalDate datumIznajmljivanja;
	private LocalDate datumVracanja;
	private Primerak iznajmljenPrimerak;
	
	
	public Iznajmljivanja() {
		this.zaposleni = null;
		this.clan = null;
		this.datumIznajmljivanja = null;
		this.datumVracanja = null;
		this.iznajmljenPrimerak = null;
		
	}
	public Iznajmljivanja(Zaposleni zaposleni,Clan clan,LocalDate datumIznajmljivanja,LocalDate datumVracanja,Primerak iznajmljenPrimerak) {
		this.zaposleni = zaposleni;
		this.clan = clan;
		this.datumIznajmljivanja = datumIznajmljivanja;
		this.datumVracanja = datumVracanja;
		this.iznajmljenPrimerak = iznajmljenPrimerak;
	}
	public Zaposleni getZaposleni() {
		return zaposleni;
	}
	public void setZaposleni(Zaposleni zaposleni) {
		this.zaposleni = zaposleni;
	}
	public Clan getClan() {
		return clan;
	}
	public void setClan(Clan clan) {
		this.clan = clan;
	}
	public LocalDate getDatumIznajmljivanja() {
		return datumIznajmljivanja;
	}
	public void setDatumIznajmljivanja(LocalDate datumIznajmljivanja) {
		this.datumIznajmljivanja = datumIznajmljivanja;
	}
	public LocalDate getDatumVracanja() {
		return datumVracanja;
	}
	public void setDatumVracanja(LocalDate datumVracanja) {
		this.datumVracanja = datumVracanja;
	}
	public Primerak getIznajmljenPrimerak() {
		return iznajmljenPrimerak;
	}
	public void setIznajmljenPrimerak(Primerak iznajmljenPrimerak) {
		this.iznajmljenPrimerak = iznajmljenPrimerak;
	}
	
	@Override
	public String toString() {
		return "Iznajmljivanje:[" + this.zaposleni + ", clan: " + this.clan + ", datum vracanja: " + this.datumVracanja + ", datum iznajmljivanja: " + this.datumIznajmljivanja + ",primerak: " + this.iznajmljenPrimerak;
				}

}
