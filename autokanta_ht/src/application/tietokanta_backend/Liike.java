package tietokanta_backend;

import java.io.PrintStream;

public class Liike {
	private int liikeID;
	private String liikenimi;
	private String liikeosoite;
	private String liike_sposti;
	private String liike_puhelinnumero;
	private int liike_postinro;
	private String liike_paikkakunta;
	private static int seuraavaNro;
	
	/**
	 * @example
	 * <pre name="test">
	 * Liike n1 = new Liike();
	 * n1.rekisteroi();
	 * Liike n2 = new Liike()
	 * n2.rekisteroi();
	 * int testin1= n1.getLiikeID();
	 * int testin2=n2.getLiikeID();
	 * testin2-testin1===1;
	 * </pre>
	 */
	
	/**
	 * paramtetriton muodostaja
	 */
	public Liike() {
		
	}
	
	/**
	 * Paramterillinen muodostaja liike-luokalle
	 * @param liikenimi
	 * @param liikeosoite
	 * @param liike_sposti
	 * @param puhnro
	 * @param liike_postinro
	 * @param paikkakunta
	 */
	public Liike(String liikenimi, String liikeosoite, String liike_sposti , String
			puhnro, int liike_postinro , String paikkakunta ) {
		this.liikenimi=liikenimi;
		this.liikeosoite= liikeosoite;
		this.liike_sposti=liike_sposti;
		this.liike_puhelinnumero=puhnro;
		this.liike_postinro=liike_postinro;
		this.liike_paikkakunta=paikkakunta;
	}
	
	/**
	 * antaa liikkeelle oman uniikin Liike-id;n
	 * @return
	 */
	public int rekisteroi() {
		 
			this.liikeID=seuraavaNro;
			seuraavaNro++;
			return this.liikeID;
		}
	
	/**
	 * palauttaa liikkeen oman liike-id:n
	 * @return
	 */
	public int getLiikeID() {
		return this.liikeID;
	}
	
	
	/**
	 * palauttaa liikkeen kaikki tiedot
	 * @param out
	 */
	public void tulosta(PrintStream out) {
		out.println(String.format("%03d", this.liikeID )  + " liikkeen nimi on  " + this.liikenimi  );
		out.println("============Tarkat tiedot============");
		out.println("Osoite on  " + liikeosoite);
		out.println("Postinro : " + liike_postinro);
		out.println("Paikkakunta : " + liike_paikkakunta);
		out.println("Puhelinnumero : " + liike_puhelinnumero);
		out.println("Sahkoposti : " + liike_sposti);
		
	}
	public static void main(String[] args) {
		Liike liike= new Liike();
		liike.taytaTiedot("Makkosen rämä" , "veturintie 34" , "aws@gmail.com" , "0445131345",40950,"muurame"  );
		liike.tulosta(System.out);
	}
	
	/**
	 * täyttää liikkeen tiedot käyttäjän antamilla parametreilla
	 * @param liikenimi
	 * @param liikeosoite
	 * @param liike_sposti
	 * @param puhelinro
	 * @param postinro
	 * @param paikkakunta
	 */
	public void taytaTiedot(String liikenimi, String liikeosoite, String liike_sposti, String puhelinro, int postinro, String paikkakunta) {
		this.liikenimi=liikenimi;
		this.liikeosoite= liikeosoite;
		this.liike_sposti=liike_sposti;
		this.liike_puhelinnumero=puhelinro;
		this.liike_postinro=postinro;
		this.liike_paikkakunta=paikkakunta;
		
	}

	public String getNimi() {
		return this.liikenimi;
	}
	
	
	
	
	
	
	
	}



