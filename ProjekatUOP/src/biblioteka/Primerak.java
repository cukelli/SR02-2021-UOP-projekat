package biblioteka;

public class Primerak {
	private Knjiga knjiga;
	private int brojStrana;
	private int godinaStampe;
	private String jezikStampe;
	private boolean iznajmljena;
	private Povez povez;
	
	public Primerak() {
		this.knjiga = null;
		this.brojStrana = 0;
		this.godinaStampe = 0;
		this.jezikStampe = "";
		this.iznajmljena = false;
		this.povez = null;
	}
	
	public Primerak(Knjiga knjiga,int brojStrana,int godinStampe,String jezikStampe,boolean iznajmljena,Povez povez) {
		this.knjiga = knjiga;
		this.brojStrana = brojStrana;
		this.godinaStampe = godinaStampe;
		this.jezikStampe = jezikStampe;
		this.iznajmljena = iznajmljena;
		this.povez = povez;
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

	public String getJezikStampe() {
		return jezikStampe;
	}

	public void setJezikStampe(String jezikStampe) {
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
	
	@Override
	
	public String toString() {
		return "primerak: [Knjiga: " + this.knjiga.getNaslov() + ",broj strana: " + this.brojStrana + ",povez " + this.povez + ",godina stampe: " + this.godinaStampe + ",jezik stampe: " + this.jezikStampe + ",iznajmljena:" + this.iznajmljena;
	}
	
	
	

}
