package biblioteka;

import java.time.LocalDate;

public class Clan extends Osoba {
	
	private int brojClanske;
	private LocalDate datumPoslednjeUplate;
	private int brojUplacenihMeseci;
	private boolean aktivnost;
	private TipClanarine tipClanarine;
	
	public Clan() {
		super();
		this.brojClanske = 0;
		this.datumPoslednjeUplate = null;
		this.brojUplacenihMeseci = 0;
		this.aktivnost = false;
		this.tipClanarine = null;
	}
	
	public Clan(String ime,String prezime,String JMBG,String adresa,Pol pol) {
		super(ime,prezime,JMBG,adresa);
		this.brojClanske = brojClanske;
		this.datumPoslednjeUplate = datumPoslednjeUplate;
		this.brojUplacenihMeseci = brojUplacenihMeseci;
		this.aktivnost = aktivnost;
		this.tipClanarine = tipClanarine;
		this.pol = pol;
	}

	public int getBrojClanske() {
		return brojClanske;
	}

	public void setBrojClanske(int brojClanske) {
		this.brojClanske = brojClanske;
	}

	public LocalDate getDatumPoslednjeUplate() {
		return datumPoslednjeUplate;
	}

	public void setDatumPoslednjeUplate(LocalDate datumPoslednjeUplate) {
		this.datumPoslednjeUplate = datumPoslednjeUplate;
	}

	public int getBrojUplacenihMeseci() {
		return brojUplacenihMeseci;
	}

	public void setBrojUplacenihMeseci(int brojUplacenihMeseci) {
		this.brojUplacenihMeseci = brojUplacenihMeseci;
	}

	public boolean isAktivnost() {
		return aktivnost;
	}

	public void setAktivnost(boolean aktivnost) {
		this.aktivnost = aktivnost;
	}

	public TipClanarine getTipClanarine() {
		return tipClanarine;
	}

	public void setTipClanarine(TipClanarine tipClanarine) {
		this.tipClanarine = tipClanarine;
	}
	
	@Override 
	public String toString() {
		return "Clan: [ime: " + this.ime + ",prezime: " + this.prezime + ",JMBG: " + this.JMBG + ",adresa: " + this.adresa + ",pol: " + this.pol + ",broj clanske karte: " + this.brojClanske + "datum poslednje uplate: " + this.datumPoslednjeUplate + ",broj uplacenih meseci: " + this.brojUplacenihMeseci + ",aktivnost: " + this.aktivnost + ",tip clanarine: " + this.tipClanarine + "]";
	}
	

}
