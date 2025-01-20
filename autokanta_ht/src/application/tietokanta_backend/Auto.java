package tietokanta_backend;

import java.io.PrintStream;

public class Auto {

		private int tunnusId;
		private String merkki = "";
		private String malli = "";
		private int vuosimalli =0;
		private int mittarilukema =0;
		private String rekisterinumero = "";
		private int moottorinkoko = 0;
		private String kayttovoima = "";
		private int hinta =0;
		private String tuotekuvaus = "";
		private int sijainti_id;
		private int auton_sijainti_ID;
		private static int seuraavaNro =0;
		
		
		/**
		 * Constructor
		 */
		
		public Auto() {
			
		}
		
		
		
		/**
		 * Constructor valmiiksi asetetuilla parametreilla, käytetään valmiissa ohjelmassa
		 */
		
	public Auto(String merkki, String malli, int vuosimalli, int mittarilukema, String rekisterinumero, int moottorinkoko, String kayttovoima, int hinta, int auton_sijainti_ID) {
			this.merkki=merkki;
			this.malli=malli;
			this.vuosimalli=vuosimalli;
			this.mittarilukema = mittarilukema;
			this.rekisterinumero= rekisterinumero;
			this.moottorinkoko=moottorinkoko;
			this.kayttovoima=kayttovoima;
			this.hinta=hinta; 
			this.auton_sijainti_ID=auton_sijainti_ID;
			
		}
/**
 * @example
 * <pre name="test">
 * Auto auto1 = new Auto();
 * Auto auto2 = new Auto();
 * auto1.taytaTiedot("Audi", "A3")
 * auto1.rekisteroi();
 * n1=auto1.getTunnusNro();
 * n2= auto2.getTunnusNro();
 * n2=n1+1;
 * </pre>
 * @param out
 */

	
	/**
	 * tulostaa auton tiedot tietovirtaan
	 * @param out
	 */

	public void tulosta(PrintStream out) {
		out.println("Auton tunnusnro systeemissa on : " +  String.format("%03d", this.tunnusId ) );
		out.println("Merkki : " + this.merkki);
		out.println("Malli : " + this.malli);
		out.println("Vuosimalli : " + this.vuosimalli);
		out.println("Hinta  : " + this.hinta);
		out.println("============Tekniset tiedot============");
		out.println("Moottorin koko " + moottorinkoko  );
		out.println("Polttoaine : " + kayttovoima);
		out.println("Mittarilukema : " + mittarilukema);
		out.println("Rekisterinumero : " + rekisterinumero);
	}
	
	public static void main(String[] args) {
		Auto auto = new Auto("Audi" , "A3" , 2012 , 15800 , "FHG-847" , 1999 , "Bensiini" , 18900, 001 );
		Auto auto2 = new Auto("Bmw" , "330" , 2017 , 35500, "HFE-724" , 2499, "Bensiini" , 45200 , 001);
		Auto auto3 = new Auto(); 
		auto.rekisteroi();
		auto2.rekisteroi();
		auto3.rekisteroi();
		auto3.tulosta(System.out);
		 auto3.taytaTiedot(1,"Mercedes-Benz" , "C320", 15800);
		 auto.getTunnusNro();
		
		auto.tulosta(System.out);
		auto2.tulosta(System.out);
		auto3.tulosta(System.out);
		 
		
		 
	}


	/**
	 * palauttaa valitun auton tunnus-id;n
	 * @return
	 */
	public int  getTunnusNro() {
		return this.tunnusId;
		
	}


	/**
	 * Täyttää auton tiedot annetuilla tiedoilla
	 * @param sijaintitunnus 
	 * @param merkki
	 * @param malli
	 * @param hinta
	 */
	public void taytaTiedot(int sijaintitunnus, String merkki, String malli , int hinta) {
		this.merkki= merkki;
		this.auton_sijainti_ID=sijaintitunnus;
		this.malli=malli;
		this.hinta=hinta;
		 
	}
	
	public int getAutonSijaintiID() {
		return this.auton_sijainti_ID;
	}


	//rekisteröi autolle oman ID-numeron
	public int rekisteroi() {
		this.tunnusId=seuraavaNro;
		seuraavaNro++;
		return this.tunnusId;
		
		
	}


	//palauttaa auton merkin
	public String getMerkki() {
		return merkki;
	}



	public void setSijainti(int liikeID) {
		this.auton_sijainti_ID=liikeID;
		
	}
}
