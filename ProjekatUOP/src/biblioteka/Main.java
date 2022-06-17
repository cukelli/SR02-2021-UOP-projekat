package biblioteka;

import gui.AdminIzmenaProzor;
import gui.AdminProzor;
import gui.BibliotekarIzmenaProzor;
import gui.BibliotekarProzor;
import gui.ClanIzmenaProzor;
import gui.GlavniProzor;
import gui.KnjigaIzmenaProzor;
import gui.LoginProzor;
import gui.PrimerakIzmenaProzor;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;


public class Main {

	public static void main(String[] args) {
		
		

	try {
		Biblioteka biblioteka = new Biblioteka("Biblioteka Desanka Maksimovic","Laze Teleckog 6","6044395","20-25",1);
		biblioteka.citajAdministratore("src/fajlovi/administratori.txt");
        biblioteka.citajBibliotekare("src/fajlovi/bibliotekari.txt");
        biblioteka.citajClanarine("src/fajlovi/clanarine.txt");
        biblioteka.citajZanrove("src/fajlovi/zanrovi.txt");
        biblioteka.citajClanove("src/fajlovi/clanovi.txt", biblioteka.sveClanarine);
        biblioteka.citajFajl("src/fajlovi/noveKnjige.txt", biblioteka.sviZanrovi);
        biblioteka.citajPrimerke("src/fajlovi/primerci.txt", biblioteka.knjige);
        biblioteka.citajIznajmljivanja("src/fajlovi/iznajmljivanja.txt", biblioteka.sviClanovi, biblioteka.sviBibliotekari, biblioteka.sviPrimerci);
        Biblioteka.citajBiblioteku("src/fajlovi/biblioteka.txt");
        
        biblioteka.sviZaposleni();
        biblioteka.sviNeobrisaniZaposleni();
        biblioteka.neobrisaniPrimerci();

		 Administrator admin = biblioteka.neobrisaniAdministratori().get(0);
		 
	
		 
		 LoginProzor loginProzor = new LoginProzor(biblioteka);
		 loginProzor.setVisible(true);
		 
		  } catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	}

}
