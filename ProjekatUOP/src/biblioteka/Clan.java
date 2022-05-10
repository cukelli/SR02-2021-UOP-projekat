package biblioteka;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

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
	
	public Clan(String IDOsobe,String ime,String prezime,String JMBG,String adresa,Pol pol,String brojClanske,LocalDate datumPoslednjeUplate,int brojUplacenihMeseci,boolean aktivnost,TipClanarine tipClanarine,boolean obrisan) {
		super(IDOsobe,ime,prezime,JMBG,adresa);
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
	
	
	public static ArrayList<Clan> citajClanove (String fajlClanovi,ArrayList<TipClanarine> sveClanarine) throws IOException {
		ArrayList<Clan> clanovi = new ArrayList<Clan>();
		File clanoviFajl = new File(fajlClanovi);
		
		BufferedReader reader = new BufferedReader(new FileReader(clanoviFajl));
		String line = null;
		while ((line = reader.readLine()) != null) {
			String [] nizClanova = line.split(";");
			String IDclana = nizClanova[0];
			String imeClana = nizClanova[1];
			String prezimeClana = nizClanova[2];
			String JMBGClana = nizClanova[3];
			String adresaClana = nizClanova[4];
			String polClana = nizClanova[5];
			Pol defPol = Pol.MUSKI;
			for (Pol p: Pol.values()) {
				if (p.name().equalsIgnoreCase(polClana)) {
					defPol = p;
				}
			}
			
			String brojClanskeClana = nizClanova[6];
			LocalDate datumPoslednjeUplateClana = LocalDate.parse(nizClanova[7]);
			int UplaceniMeseciClana = Integer.parseInt(nizClanova[8]);
			boolean aktivnostClana = Boolean.parseBoolean(nizClanova[9]);
			TipClanarine tmpClanarine = sveClanarine.get(0);
			
			for (TipClanarine tip: sveClanarine) {
				
				if (tip.getTip().equalsIgnoreCase(nizClanova[10])) {
				
			  tmpClanarine = tip;
		// System.out.println("usao u petljlu");
				}
			}
			boolean obrisanostClana = Boolean.parseBoolean(nizClanova[11]);
		
				
			Clan clan = new Clan(IDclana,imeClana,prezimeClana,JMBGClana,adresaClana,defPol,brojClanskeClana,datumPoslednjeUplateClana,UplaceniMeseciClana,aktivnostClana,tmpClanarine,obrisanostClana);
			clanovi.add(clan);	
			
		}
		reader.close();
		return clanovi;
		
	}
	
	public static void upisiClanove(ArrayList<Clan> clanoviUpis, String clanoviFajl) throws IOException {
		ArrayList<Clan> clanovi = clanoviUpis;
		File fajlSaClanovima = new File(clanoviFajl);
		BufferedWriter writer = new BufferedWriter(new FileWriter(fajlSaClanovima, true));
		
		for (Clan c: clanovi) {
			String sbClan = c.getIDOsobe() + ";" + c.getIme() + ";" + c.getPrezime() + ";" + c.getJMBG() + ";" + c.getAdresa() + ";" + c.getPol() + ";" + c.getBrojClanske() + ";" + c.getDatumPoslednjeUplate() + ";" + c.getBrojUplacenihMeseci() + ";" + c.isAktivnost() + ";" + c.getTipClanarine() + ";" + c.isObrisan();
			writer.write(sbClan);
			writer.newLine();
			
 		}
		writer.close();

		
	}
	

}
