package biblioteka;

import java.time.LocalDate;

public class Iznajmljivanje {
	private static int idMaker=0;

	
	private int IDIznajmljivanja;
	private Bibliotekar bibliotekar;
	private Clan clan;
	private LocalDate datumIznajmljivanja;
	private LocalDate datumVracanja;
	private Primerak iznajmljenPrimerak;
	
	
	public Iznajmljivanje() {
		
		this.IDIznajmljivanja = 0;
		this.bibliotekar = null;
		this.clan = null;
		this.datumIznajmljivanja = null;
		this.datumVracanja = null;
		this.iznajmljenPrimerak = null;
		
	}
	public Iznajmljivanje(int IDIznajmljivanja,Bibliotekar bibliotekar,Clan clan,LocalDate datumIznajmljivanja,LocalDate datumVracanja,Primerak iznajmljenPrimerak)
	{
		this.IDIznajmljivanja = IDIznajmljivanja;
		Iznajmljivanje.idMaker = IDIznajmljivanja;
		this.bibliotekar = bibliotekar;
		this.clan = clan;
		this.datumIznajmljivanja = datumIznajmljivanja;
		this.datumVracanja = datumVracanja;
		this.iznajmljenPrimerak = iznajmljenPrimerak;
	}
	public Bibliotekar getBibliotekar() {
		return bibliotekar;
	}
	public void setBibliotekar(Bibliotekar bibliotekar) {
		this.bibliotekar = bibliotekar;
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
	
	
	
	public int getIDIznajmljivanja() {
		return IDIznajmljivanja;
	}
	public void setIDIznajmljivanja(int iDIznajmljivanja) {
		IDIznajmljivanja = iDIznajmljivanja;
	}
	

	public static void setIdMaker(int count) {
		Iznajmljivanje.idMaker = count;
	}
	
	public static int getUpdateMaker() {
		return Iznajmljivanje.idMaker;
	}
	@Override
	public String toString() {
		return "Iznajmljivanje:[" + this.bibliotekar + ", clan: " + this.clan + ", datum vracanja: " + this.datumVracanja + ", datum iznajmljivanja: " + this.datumIznajmljivanja + ",primerak: " + this.iznajmljenPrimerak + ", ID:" + this.IDIznajmljivanja;
				}
	
	
	
	

}
