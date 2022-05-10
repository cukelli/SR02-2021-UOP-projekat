package biblioteka;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Primerak {
	private String IDPrimerka;
	private Knjiga knjiga;
	private int brojStrana;
	private int godinaStampe;
	private Jezik jezikStampe;
	private boolean iznajmljena;
	private Povez povez;
	
	public Primerak() {
		this.IDPrimerka = "";
		this.knjiga = null;
		this.brojStrana = 0;
		this.godinaStampe = 0;
		this.jezikStampe = null;
		this.iznajmljena = false;
		this.povez = null;
	}
	
	public Primerak(String IDPrimerka,Knjiga knjiga,int brojStrana,int godinaStampe, Jezik jezikStampe,boolean iznajmljena,Povez povez) {
		this.IDPrimerka = IDPrimerka;
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
	
	
	
	public String getIDPrimerka() {
		return IDPrimerka;
	}

	public void setIDPrimerka(String iDPrimerka) {
		IDPrimerka = iDPrimerka;
	}

	@Override
	
	public String toString() {
		return "primerak: [Knjiga: " + ", naslov: " + this.knjiga.getNaslov() + ",broj strana: " + this.brojStrana + ",povez " + this.povez + ",godina stampe: " + this.godinaStampe + ",jezik stampe: " + this.jezikStampe + ",iznajmljena:" + this.iznajmljena + ", ID:" + this.IDPrimerka;
	}
	
	
	
	

}
