package tietokanta_backend;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Autot {
	private static final int MAX_AUTOJA= 5;
	private int lkm = 0 ;
	private Auto[] autot;
	public Collection<Auto>autotlista= new ArrayList<Auto>();
	
	/**
	 * @example
	 * <pre name="test">
	 * Autot autot = new Autot();
	 * Auto auto = new Auto();
	*	Auto auto2 = new Auto();
	*	auto.rekisteroi();
	*	auto2.rekisteroi();
	*	autot.lisaa(auto);
	*autot.lisaa(auto2);
	*	autot.getLKM()===2;
	 * </pre>
	 */
	
	/**
	 * Luodaan uusi taulukko
	 */
	public Autot() {
		autot= new Auto[MAX_AUTOJA];
	}
	
	public static void main(String[] args)  {
		Autot autot = new Autot();
		
		Auto auto = new Auto();
		Auto auto2 = new Auto();
		Auto auto3 = new Auto();
		
		auto.rekisteroi();
		auto.taytaTiedot(1,"audi", "A3" , 15000);
		
		auto2.rekisteroi();
		auto2.taytaTiedot(1,"BMW", "330" , 15800);
		
		auto3.rekisteroi();
		auto3.taytaTiedot(1,"Ford", "Focus" , 45700);
		
		System.out.println("===========Testi autoille==========");
		 autot.lisaaAuto(auto);
		autot.lisaaAuto(auto2);
		autot.lisaaAuto(auto3);
		
		 autot.tulostaKaikki();
		
	}
	 
	
	 
		 
		
		 
		
	
	
	 

	/**
	 * Tulostaa kaikki autot
	 */
	 
	public void tulostaKaikki() {
		for(Auto auto:autotlista) {
			auto.tulosta(System.out);
		}
		
	}
	public void lisaaAuto(Auto auto) {
		autotlista.add(auto);
	}

 /**
  * Antaa auto-objektin kohdassa i
  * @param i
  * @return
  */

	private Auto anna(int i) {
		if(i<0 ||this.lkm<=i) {
			throw new IndexOutOfBoundsException("Laiton indeksi : " + i);
			
		}
		return autot[i];
		
	}

 

 
	/**
	 * Liää auton autot-listan. mIkäli paikkoja ei ole, antaa sailoException-varoituksen
	 * @param auto
	 * @throws SailoException
	 */
	
	 
	
	
	/**
	 * palauttaa autojen lukumäärän listassa
	 * @return
	 */
	 
	public int getLKM() {
		return autotlista.size();
	}

	
	/**
	 * antaa auton paikassa I
	 * @param i
	 * @return
	 */
	 
	public Auto etsiAuto(int idnro) {
		Auto palauteauto= new Auto();
		for(Auto auto: autotlista) {
		 if(auto.getTunnusNro()==idnro) {
			palauteauto=auto;
			return auto;
		 }
	 }
		return null;
}

	public List<Auto> annaAutotLiikkeessa(int liikeID) {
		List<Auto> autotliikkeessa= new ArrayList<Auto>();
		for(Auto auto:autotlista) {
			if(auto.getAutonSijaintiID()==liikeID) {
				autotliikkeessa.add(auto);
			}
		}
		return autotliikkeessa;
		
	}
	
	
	
	 
	
	
}
