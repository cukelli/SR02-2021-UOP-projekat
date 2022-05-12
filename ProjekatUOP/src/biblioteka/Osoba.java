package biblioteka;

abstract class Osoba {
	protected String IDOsobe;
	protected String ime;
	protected String prezime;
	protected String JMBG;
	protected String adresa;
	protected Pol pol;
	protected boolean obrisan;
	
	public Osoba() {
		this.IDOsobe = "";
		this.ime = "";
		this.prezime = "";
		this.JMBG = "";
		this.adresa = "";
		this.pol = null;
		this.obrisan = false;
		
	}
	
	public Osoba(String IDOsobe,String ime,String prezime,String JMBG,String adresa,boolean obrisan) {
		this.IDOsobe = IDOsobe;
		this.ime = ime;
		this.prezime = prezime;
		this.JMBG = JMBG;
		this.adresa = adresa;
		this.pol = pol;
		this.obrisan = obrisan;
	}

	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getPrezime() {
		return prezime;
	}

	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}

	public String getJMBG() {
		return JMBG;
	}

	public void setJMBG(String jMBG) {
		this.JMBG = JMBG;
	}

	public String getAdresa() {
		return adresa;
	}

	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}

	public Pol getPol() {
		return pol;
	}

	public void setPol(Pol pol) {
		this.pol = pol;
	}

	public String getIDOsobe() {
		return IDOsobe;
	}

	public void setIDOsobe(String IDOsobe) {
		IDOsobe = IDOsobe;
	}

	public boolean isObrisan() {
		return obrisan;
	}

	public void setObrisan(boolean obrisan) {
		this.obrisan = obrisan;
	}
	
	
	
	
	

}
