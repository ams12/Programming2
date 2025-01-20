package tietokanta_backend;

import java.util.ArrayList;
import java.util.List;

public class Tietokanta {
	private Liikkeet liikkeet = new Liikkeet();
	private Autot autot= new Autot();
	
	public void lisaa(Auto auto) throws SailoException {
	autot.lisaaAuto(auto);
		
	}
	
	
	/**
	 * @example
	 * <pre name="test">
	 * Tietokanta tietokanta = new Tietokanta();
	
	Auto auto = new Auto();
	Auto auto2 = new Auto();
	
	
	auto.rekisteroi();
	auto2.rekisteroi();
	auto.taytaTiedot("Audi", "A3", 18500);
	auto2.taytaTiedot("Volvo", "V70", 21250);
	Liike liike= new Liike();
	liike.rekisteroi();
	liike.taytaTiedot("Makkosen rämä" , "veturintie 34" , "aws@gmail.com" , "0445131345",40950,"muurame"  );
	liike.tulosta(System.out);
	tietokanta.lisaa(auto);
	tietokanta.lisaa(auto2);
	tietokanta.lisaa(liike);
	

	 
	
	tietokanta.getAutojenMaara()===2;
	tietokanta.getLiikkeidenMaara()===1;
	 * </pre>
	 * @param args
	 * @throws SailoException
	 */
	public static void main(String[] args) throws SailoException {
	Tietokanta tietokanta = new Tietokanta();
	
	Auto auto = new Auto();
	Auto auto2 = new Auto();
	
	
	auto.rekisteroi();
	auto2.rekisteroi();
	auto.taytaTiedot(1, "Audi", "A3", 18500);
	auto2.taytaTiedot(1, "Volvo", "V70", 21250);
	Liike liike= new Liike();
	liike.rekisteroi();
	liike.taytaTiedot("Makkosen rämä" , "veturintie 34" , "aws@gmail.com" , "0445131345",40950,"muurame"  );
	liike.tulosta(System.out);
	tietokanta.lisaa(auto);
	tietokanta.lisaa(auto2);
	tietokanta.lisaa(liike);
	 

	
	
	}

	/**
	 * Palauttaa liikkeiden määrän Liikkeet-luokassa
	 * @return
	 */
	public int getLiikkeidenMaara() {
	return	liikkeet.getLiikkeidenMaara();
	}

	/**
	 * Lisää annetun liikkeen Liikkeet-luokan liike-listaan
	 * @param liike
	 * @throws SailoException
	 */
	public void lisaa(Liike liike) throws SailoException {
		liikkeet.lisaa(liike);
		
	}

	
		/**
		 * Antaa auton kohdasta I Autot-luokan listasta
		 * @param i
		 * @return
		 */
	 
	
	public List<Auto> annaAutot(Liike liike){
	return 	 autot.annaAutotLiikkeessa(liike.getLiikeID());
		 }
	
	
	/**
	 * etsii liikkeen, jonka Liike-id vastaa parametrina annettua Liike-idtä
	 * @param idnro
	 * @return
	 */
	public Liike etsiLiikeTietokanta(int idnro) {
		return liikkeet.etsiLiike(idnro);
	}
	
	public Auto etsiAutoTietokanta(int idnro) {
		return autot.etsiAuto(idnro);
	}
	
	/**
	 * palauttaa autojen lukumäärän autot-luokasta
	 * @return
	 */

	public int getAutojenMaara() {
		 return autot.getLKM();
		}
	
	/**
	 * toString-metodi
	 */
	 public String  toString() {
		return this.toString(); 
				}
	 
	 /**
	  * palauttaa liikkeen tietyllä liike-idllä
	  * @param liike
	  * @return
	  */
	  
	 public Liike annaLiike(int i) {
		 return liikkeet.annaliike(i);
	 }
	 public Auto annaAuto(Auto auto) {
		 return autot.etsiAuto(auto.getTunnusNro());
	 }

}
