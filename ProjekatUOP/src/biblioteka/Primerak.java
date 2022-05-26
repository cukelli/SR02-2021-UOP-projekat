package biblioteka;



public class Primerak {
	
	
	private int IDPrimerka;
	private static int IDMaker = 0;
	private Knjiga knjiga;
	private int brojStrana;
	private int godinaStampe;
	private Jezik jezikStampe;
	private boolean iznajmljena;
	private Povez povez;
	private boolean obrisan;
	
	public Primerak() {
		this.IDPrimerka = 0;
		this.knjiga = null;
		this.brojStrana = 0;
		this.godinaStampe = 0;
		this.jezikStampe = null;
		this.iznajmljena = false;
		this.povez = null;
		this.obrisan = false;
	}
	
	public Primerak(int IDPrimerka,Knjiga knjiga,int brojStrana,int godinaStampe, Jezik jezikStampe,boolean iznajmljena,Povez povez,boolean obrisan) {
		this.IDPrimerka = IDPrimerka;
	     Primerak.IDMaker = IDPrimerka;
		this.knjiga = knjiga;
		this.brojStrana = brojStrana;
		this.godinaStampe = godinaStampe;
		this.jezikStampe = jezikStampe;
		this.iznajmljena = iznajmljena;
		this.povez = povez;
		this.obrisan = obrisan;
	}

	public Knjiga getKnjiga() {
		return knjiga;
	}

	public void setKnjiga(Knjiga knjiga) {
		this.knjiga = knjiga;
	}

	public int getBrojStrana() {
		return brojStrana;
	}

	public void setBrojStrana(int brojStrana) {
		this.brojStrana = brojStrana;
	}

	public int getGodinaStampe() {
		return godinaStampe;
	}

	public void setGodinaStampe(int godinaStampe) {
		this.godinaStampe = godinaStampe;
	}

	public Jezik getJezikStampe() {
		return jezikStampe;
	}

	public void setJezikStampe(Jezik jezikStampe) {
		this.jezikStampe = jezikStampe;
	}

	public boolean isIznajmljena() {
		return iznajmljena;
	}

	public void setIznajmljena(boolean iznajmljena) {
		this.iznajmljena = iznajmljena;
	}

	public Povez getPovez() {
		return povez;
	}

	public void setPovez(Povez povez) {
		this.povez = povez;
	}
	
	
	
	public int getIDPrimerka() {
		return IDPrimerka;
	}

	public void setIDPrimerka(int iDPrimerka) {
		IDPrimerka = iDPrimerka;
	}
	

	public boolean isObrisan() {
		return obrisan;
	}

	public void setObrisan(boolean obrisan) {
		this.obrisan = obrisan;
	}
	
	public static void setIdMaker(int count) {
		Primerak.IDMaker = count;
	}
	
	public static int getUpdateMaker() {
		return Primerak.IDMaker;
	}
	

	@Override
	
	public String toString() {
		return "primerak: [Knjiga: " + ", naslov: " + this.knjiga.getNaslov() + ",broj strana: " + this.brojStrana + ",povez " + this.povez + ",godina stampe: " + this.godinaStampe + ",jezik stampe: " + this.jezikStampe + ",iznajmljena:" + this.iznajmljena + ", ID:" + this.IDPrimerka;
	}
	
	
	
	

}
