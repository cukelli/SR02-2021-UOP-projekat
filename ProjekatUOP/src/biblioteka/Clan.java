package biblioteka;

import java.time.LocalDate;

public class Clan extends Osoba {
	
	private String brojClanske;
	private LocalDate datumPoslednjeUplate;
	private int brojUplacenihMeseci;
	private boolean aktivnost;
	private TipClanarine tipClanarine;
	boolean obrisan;
	
	public Clan() {
		super();
		this.brojClanske = "";
		this.datumPoslednjeUplate = null;
		this.brojUplacenihMeseci = 0;
		this.aktivnost = false;
		this.tipClanarine = null;
		this.obrisan = false;
	}
	
	public Clan(String IDOsobe,String ime,String prezime,String JMBG,String adresa,boolean obrisan,Pol pol,String brojClanske,LocalDate datumPoslednjeUplate,int brojUplacenihMeseci,boolean aktivnost,TipClanarine tipClanarine) {
		super(IDOsobe,ime,prezime,JMBG,adresa,obrisan);
		this.brojClanske = brojClanske;
		this.datumPoslednjeUplate = datumPoslednjeUplate;
		this.brojUplacenihMeseci = brojUplacenihMeseci;
		this.aktivnost = aktivnost;
		this.tipClanarine = tipClanarine;
		this.pol = pol;
		this.obrisan = obrisan;
	}

	public String getBrojClanske() {
		return brojClanske;
	}

	public void setBrojClanske(String brojClanske) {
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
	
	
	
	
	public boolean isObrisan() {
		return obrisan;
	}

	public void setObrisan(boolean obrisan) {
		this.obrisan = obrisan;
	}

	@Override 
	public String toString() {
		return "Clan: [ime: " + this.ime + ",prezime: " + this.prezime + ",JMBG: " + this.JMBG + ",adresa: " + this.adresa + ",pol: " + this.pol + ",broj clanske karte: " + this.brojClanske + "datum poslednje uplate: " + this.datumPoslednjeUplate + ",broj uplacenih meseci: " + this.brojUplacenihMeseci + ",aktivnost: " + this.aktivnost + ",tip clanarine: " + this.tipClanarine + "obrisan: " + this.obrisan +"]";
	}
	
	
	
	

}
