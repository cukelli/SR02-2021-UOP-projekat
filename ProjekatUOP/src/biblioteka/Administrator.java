package biblioteka;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Administrator extends Zaposleni {
	public Administrator() {
		super();
	}
	
	
	public Administrator(String IDOsobe,String ime,String prezime,String JMBG,String adresa,Pol pol,double plata,String korIme,String lozinka) {
	 super(IDOsobe,ime,prezime,JMBG,adresa,pol, plata,korIme,lozinka);
	}
	@Override 
	
	public String toString() {
		return "Administrator [ID: " + this.IDOsobe + ", ime: " + this.ime + ", prezime:" + this.prezime + ", JMBG:" + this.JMBG + ", adresa" + this.adresa + ", pol:" + this.pol + ", plata:" + this.plata + ", korisnicko ime: " + this.korIme + ", lozinka: " + this.lozinka;
				}

	
	
	public static ArrayList<Administrator> citajAdministratore (String fajlAdministratori) throws IOException {
		ArrayList<Administrator> administratori = new ArrayList<Administrator>();
		File administratoriFajl = new File(fajlAdministratori);
		
		BufferedReader reader = new BufferedReader(new FileReader(administratoriFajl));
		String line = null;
		while ((line = reader.readLine()) != null) {
			String[] nizAdministratora = line.split(";");
			String IDAdministratora = nizAdministratora[0];
			String imeAdministratora = nizAdministratora[1];
			String prezimeAdministratora = nizAdministratora[2];
			String JMBGAdministratora = nizAdministratora[3];
			String adresaAdministratora = nizAdministratora[4];
			String polAdministratora = nizAdministratora[5];
			Pol defPol = Pol.MUSKI;
			for (Pol p: Pol.values()) {
				if (p.name().equalsIgnoreCase(polAdministratora)) {
					defPol = p;
				}
			}
			double plataAdministratora = Double.parseDouble(nizAdministratora[6]);
			String korImeAdministratora = nizAdministratora[7];
			String lozinkaAdministratora = nizAdministratora[8];
			
			Administrator administrator = new Administrator(IDAdministratora,imeAdministratora,prezimeAdministratora,JMBGAdministratora,adresaAdministratora,defPol,plataAdministratora,korImeAdministratora,lozinkaAdministratora);
            administratori.add(administrator);
		}
		reader.close();
		return administratori;		

		
	}
	public static void upisiAdministratore(ArrayList<Administrator> administratoriUpis,String administratoriFajl) throws IOException {
		ArrayList<Administrator> administratori = administratoriUpis;
		File fajlSaAdministratorima = new File(administratoriFajl);
		BufferedWriter writer = new BufferedWriter(new FileWriter(fajlSaAdministratorima, true));
		for (Administrator a: administratori) {
			String sbAdministrator = a.getIDOsobe() + ";" + a.getIme() + ";" + a.getPrezime() + ";" + a.getJMBG() + ";" + a.getAdresa() + ";" + a.getPol() + ";" + a.getPlata() + ";" + a.getKorIme() + ";" + a.getLozinka();
			writer.write(sbAdministrator);
			writer.newLine();
		}
		writer.close();
		
	}
}