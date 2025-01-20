package tietokanta_backendUusi;

import java.io.OutputStream;
import java.io.PrintStream;

import fi.jyu.mit.ohj2.Mjonot;
import javafx.scene.control.TextField;
import kanta.rekisterinro;

public class Auto  implements Cloneable {
	private int tunnusNro;
	private String merkki ="";
	private String malli ="";
	private int vuosimalli;
	private int mittarilukema;
	private String rekisterinumero = "";
	private int moottorinkoko;
	private String kayttovoima= "";
	private int hinta;
	private String kuvaus ="";
	private int sijainti_ID;
	
	
	private static int seuraavaNro = 1;
	
	/**
	 * testausta varten metodi, joka täyttää tiedot autoon.
	 */
	public void taytaTiedot() {
		merkki= "mercedes-Bnez";
		malli= "c220";
		vuosimalli= 2017;
		mittarilukema= 125000;
		rekisterinumero= "XYS-567";
		moottorinkoko  = 1999;
		kayttovoima="Diesel";
		hinta= 25000;
		kuvaus= "toimiva peli";
		
			
	}
	/**
	 * testausta varten metodi, joka täyttää tiedot autoon.paramterina liike-johon lisätään
	 * @param liikeid
	 */
	public void taytaTiedot(int liikeid) {
		merkki= "mercedes-Bnez";
		malli= "c220";
		vuosimalli= 2017;
		mittarilukema= 125000;
		rekisterinumero= "XYS-567";
		moottorinkoko  = 1999;
		kayttovoima="Diesel";
		hinta= 25000;
		kuvaus= "toimiva peli";
		this.sijainti_ID=liikeid;
			
	}
	public void tulosta(OutputStream os) {
		tulosta(new PrintStream(os));
	}
	
	public void tulosta(PrintStream out) {
		out.println("Tämän auton tunnus on " + String.format("%03d", tunnusNro, 3));
		out.println("Merkki : " + merkki);
		out.println("Mallli : " + malli);
		out.println("Vuosimalli : " + vuosimalli);
		out.println("Mittarilukema : " + mittarilukema);
		out.println("Rekisterinuemro : " + rekisterinumero);
		out.println("Moottorin koko : " + moottorinkoko);
		out.println("Polttoaine : " + kayttovoima);
		out.println("Hinta : " + hinta);
		out.println("Kuvaus : " + kuvaus);
		out.println("Sijainti-ID : " + sijainti_ID);
	}
	
	
	/**
	 * @example
	 * <pre name="test">
	 * Auto auto1 = new Auto();
	 * Auto auto2 = new Auto();
	 * auto1.taytaTiedot(1);
	 * auto1.rekisteroi();
	 * auto2.taytaTiedot(1);
	 * auto2.rekisteroi();
	 * auto1.toString()=== "1|mercedes-Bnez|c220|2017|125000|XYS-567|1999|Diesel|25000|toimiva peli|1";
	 * auto2.toString()==="2|mercedes-Bnez|c220|2017|125000|XYS-567|1999|Diesel|25000|toimiva peli|1";
	 * int n1= auto1.getTunnusNro();
	 * int n2=auto2.getTunnusNro();
	 * Auto auto3=auto2.clone();
	 * int n3=auto3.getTunnusNro();
	 * n3===n2;
	 *  Auto auto4 = new Auto();
    auto4.rekisteroi();
    auto4.taytaTiedot();
    int vuosimalli=Integer.parseInt(auto4.anna(2));
    vuosimalli===2017;
	 * n2===n1+1;
	 * 
	 * 
	 * </pre>
	 * @param out
	 */
/**
 * luo tunnusnumeron autole
 * @return
 */
	 public int rekisteroi() {

	        tunnusNro = seuraavaNro;

	        seuraavaNro++;

	        return tunnusNro;

	    }
	 
	  public int getTunnusNro() {

	        return tunnusNro;

	    }

	  public int getLiikeID() {
		  
		  return sijainti_ID;
	  }
	 
	  /**
	   * muuttaa olion tiedot palautettavaksi tekstijonoksi tallennusta varten. 
	   */
	  public String toString() {
		  String palaute=  ""+
	  this.getTunnusNro() + "|" +
				  merkki + "|"+
	  malli + "|" + 
				  vuosimalli + "|" + 
	  mittarilukema + "|" + 
				  rekisterinumero + "|" +
	  moottorinkoko + "|"+
				  kayttovoima + "|"+
	  hinta + "|" + 
				  kuvaus + "|" +
	  this.sijainti_ID ;
				  
				  
				  
				  
				  
				  
				  
		  return palaute;
	  }
	 public static void main(String[] args) {
		Auto auto= new Auto();
		auto.rekisteroi();
		
		Auto auto2= new Auto();
		auto2.rekisteroi();
		auto.taytaTiedot();
		auto2.taytaTiedot();
		
		auto.tulosta(System.out);
		auto2.tulosta(System.out);
		
		System.out.println(auto.toString());
	}

	public void parse(String s) {
		StringBuilder sb = new StringBuilder (s);
		setTunnusNro(Mjonot.erota(sb, '|' , this.getTunnusNro()));
		
		merkki=Mjonot.erota(sb,'|', merkki);
		malli=Mjonot.erota(sb,'|', malli);
		vuosimalli=Mjonot.erota(sb, '|', vuosimalli);
		mittarilukema=Mjonot.erota(sb, '|', mittarilukema);
		rekisterinumero=Mjonot.erota(sb,'|', rekisterinumero);
		moottorinkoko=Mjonot.erota(sb, '|', moottorinkoko);
		kayttovoima=Mjonot.erota(sb,'|', kayttovoima);
		hinta=Mjonot.erota(sb, '|', hinta);
		kuvaus=Mjonot.erota(sb,'|', kuvaus);
		sijainti_ID=Mjonot.erota(sb,'|', sijainti_ID);
		
		
	}
	
	public int getHinta() {
		return hinta;
	}
	/**
	 * luo ckopion muokkausta varten
	 */
	public Auto clone() throws CloneNotSupportedException {
		Auto uusi;
		uusi= (Auto) super.clone();
		return uusi;
	}

	private void setTunnusNro(int numero) {
		this.tunnusNro=numero;
		if(this.tunnusNro>=seuraavaNro) {
			seuraavaNro=numero+1;
		}
		
	}
/**
 * asettaa uudet tiedot objektiin. 
 * @param uusi
 * @param nro
 * @param kentta
 */
	public void aseta(String uusi, int nro, TextField kentta) {
	switch(nro) {
	case 0:	merkki=uusi; 
	if(merkki==null||merkki==""||merkki.length()<3) {
		kentta.getStyleClass().add("virhe");
		
	}
	else {
		kentta.getStyleClass().add("normaali");
	}
	break;	
	case 1: 	malli=uusi; 
	if(malli==null||malli=="") {
		kentta.getStyleClass().add("virhe");
		
	}
	else {
		kentta.getStyleClass().add("normaali");
	}
	case 2: try {int vuosimalliuusi= Integer.parseInt(uusi);
	if(vuosimalliuusi<1970||vuosimalliuusi>2022) {
		kentta.getStyleClass().add("virhe");
	}
	else kentta.getStyleClass().add("normaali");
	vuosimalli=vuosimalliuusi;
	break;
		
	}catch(Exception e) {
		kentta.getStyleClass().add("virhe");
		break;
	}
	case 3:try{kentta.getStyleClass().add("normaali");
		int mittarilukemauusi= Integer.parseInt(uusi);
	 if(mittarilukemauusi<0||mittarilukemauusi>200000) {
		 kentta.getStyleClass().add("virhe");
	 }
	 else kentta.getStyleClass().add("normaali");
	mittarilukema=mittarilukemauusi;
	break;
		
	}catch(Exception e){
		kentta.getStyleClass().add("virhe");
		break;
	}
	case 4:rekisterinro reksnro= new rekisterinro();
		boolean onkoHyva=reksnro.tarkista(uusi);
		if(!onkoHyva) {
			kentta.getStyleClass().add("virhe");
		}
		else kentta.getStyleClass().add("normaali");
		rekisterinumero=uusi;break;
	case 5:try{kentta.getStyleClass().add("normaali");
		int moottorinkokouusi= Integer.parseInt(uusi);
	 
	moottorinkoko=moottorinkokouusi;
	break;
		
	}catch(Exception e){
		kentta.getStyleClass().add("virhe");
		break;
	}
	case 6:kayttovoima=uusi; break;
	case 7:try{kentta.getStyleClass().add("normaali");
		int hintauusi= Integer.parseInt(uusi);
	 
	hinta=hintauusi;
	break;
		
	}catch(Exception e){
		kentta.getStyleClass().add("virhe");
		break;
	}
	case 8:kuvaus=uusi; break;
	}
		
	}

	public void setLiikeID(int liikeID) {
	this.sijainti_ID=liikeID;
		
	}

	public String getMerkki() {
		return merkki;
	}
/**
 * antaa parametrin i-mukaan oikein tiedon objektista.
 * @param nro
 * @return
 */
	public String anna(int nro) {
		switch(nro) {
		case 0: return ""+merkki; 
		case 1:return ""+malli; 
		case 2:return ""+vuosimalli; 
		case 3:return ""+mittarilukema; 
		case 4:return ""+rekisterinumero; 
		case 5:return ""+ moottorinkoko; 
		case 6:return ""+kayttovoima; 
		case 7: return ""+hinta; 
		case 8:return ""+kuvaus; 
		default: return "vika";
		}
	}

	public int ekaKentta() {
		return 1;
	}
		
	}

	


