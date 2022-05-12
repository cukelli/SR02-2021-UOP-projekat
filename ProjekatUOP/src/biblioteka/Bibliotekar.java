package biblioteka;


public class Bibliotekar extends Zaposleni {
	public Bibliotekar() {
		super();	
	}
	
	public Bibliotekar(String IDOsobe,String ime,String prezime,String JMBG,String adresa,boolean obrisan,Pol pol,double plata,String korIme,String lozinka) {
		super(IDOsobe,ime,prezime,JMBG,adresa,obrisan,pol,plata,korIme,lozinka);
	}
	
	
	
	
	public String toString() {
		return "Bibliotekar: [ID: " + this.IDOsobe + ", ime: " + this.ime + ", prezime:" + this.prezime + ", JMBG:" + this.JMBG + ", adresa" + this.adresa + ", pol:" + this.pol + ", plata:" + this.plata + ", korisnicko ime: " + this.korIme + ", lozinka: " + this.lozinka;
				}
	
	

	
	
}
