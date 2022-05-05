package biblioteka;

abstract class Zaposleni extends Osoba {
	
	protected double plata;
	protected String korIme;
	protected String lozinka;
	
	public Zaposleni() {
		super();
		this.plata = 0.0;
		this.korIme = "";
		this.lozinka = "";
	}
	
	public Zaposleni(String IDOsobe,String ime,String prezime,String JMBG,String adresa,Pol pol,double plata,String korIme,String lozinka) {
		super(IDOsobe,ime,prezime,JMBG,adresa);
		this.plata = plata;
		this.korIme = korIme;
		this.lozinka = lozinka;
		this.pol = pol;
		
	}

	public double getPlata() {
		return plata;
	}

	public void setPlata(double plata) {
		this.plata = plata;
	}

	public String getKorIme() {
		return korIme;
	}

	public void setKorIme(String korIme) {
		this.korIme = korIme;
	}

	public String getLozinka() {
		return lozinka;
	}

	public void setLozinka(String lozinka) {
		this.lozinka = lozinka;
	}
	
	
	
	@Override
	public String toString() {
		return "Zaposleni: [ime: " + this.ime + ",prezime: " + this.prezime + ",JMBG: " + this.JMBG + ",adresa: " + this.adresa + ",pol: " + this.pol + ",plata: " + this.plata + ",korisnicko ime: " + this.korIme + ",lozinka: " + this.lozinka + ", ID" + this.IDOsobe + "]";
	}
	

}
