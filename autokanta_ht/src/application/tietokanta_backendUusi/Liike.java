package tietokanta_backendUusi;

import java.io.OutputStream;
import java.io.PrintStream;


import fi.jyu.mit.ohj2.Mjonot;
import javafx.scene.control.TextField;

public class Liike  implements Cloneable{
private int liikeID;
private String liikenimi= "";
private String osoite="";
private String sposti="";
private String puhnro="";
private int postinro;
private String kaupunki="";

private static int seuraavaNro = 1;





public int getLiikeID() {

    return liikeID;

}
public String getOsoite()
{
	return osoite;
}

public String getSposti() {
	return sposti;
}

public String getPuhnro() {
	return puhnro;
}


public int getPostinro() {
	return postinro;
}

public String getKaupunki() {
	return kaupunki;
	
}


public int rekisteroi() {

    liikeID = seuraavaNro;

    seuraavaNro++;

    return liikeID;

}
/**
 * testeihin määritetty metodi, joka lisää auton tiedot autoon;
 */
public void taytaTiedot() {
	liikenimi= "Mikkosen auto";
	osoite= "Kaaratie 342";
	sposti="sales@mikkosenauto.com";
	puhnro= "0441457845";
	postinro = 40520;
	kaupunki="Jyväskylä";
	
}

public void tulosta(OutputStream os) {

    tulosta(new PrintStream(os));

}
/**
 * testauskessa käytetty metodi tulostukseen
 * @param out
 */
public void tulosta(PrintStream out) {
	out.println(" Liikkeen tunnus on : " + String.format("%03d", liikeID, 3) );
	out.println("Liikkeen nimi : " + liikenimi);
	out.println("Osoite : " + osoite);
	out.println("Sähköposti : " + sposti);
	out.println("Puhelinnumero : " +   puhnro);
	out.println("postinumero : " + postinro);
	out.println("kaupunki" + kaupunki);
}

public static void main(String[] args) {
	Liike liike= new Liike();
	liike.rekisteroi();
	liike.taytaTiedot();
	liike.tulosta(System.out);
	Liike liike2= new Liike();
	liike2.rekisteroi();
	liike2.taytaTiedot();
	liike2.tulosta(System.out);
	System.out.println(liike.toString());
	
}

public String getNimi() {
	return liikenimi;
}



/**
 * tallennuksessa käytetty metodi, joka kirjoittaa liike-olion tallennettavaan tekstimuotoon
 */
public String toString() {
	String palaute= this.getLiikeID() +
			"|" + this.liikenimi +
			"|" + this.osoite + "|" + this.sposti + "|" + this.puhnro + "|" + this.postinro + "|" + this.kaupunki;
	
	return palaute;
}

/**
 * @example
 * <pre name="test">
 * Liike liike = new Liike();
 * liike.parse("1| Makkosen auto|Vartujankatu 3||testi@gmail.com|0445147847|40100|kemi");
 * liike.getLiikeID()===1;
 * liike.toString().startsWith("1|Makkosen auto|Vartujankatu 3|")===true;
 
 *
 *	String osoite=liike.anna(2);
 *	osoite==="Vartujankatu 3";
 * String nimi=liike.anna(1);
 * nimi==="Makkosen auto";
 * </pre>
 * @param s
 */
public void parse(String s) {
	StringBuilder sb = new StringBuilder (s);
	setLiikeID(Mjonot.erota(sb, '|' , this.getLiikeID()));
	liikenimi= Mjonot.erota(sb, '|' , liikenimi);
	osoite= Mjonot.erota(sb,'|', osoite);
	sposti= Mjonot.erota(sb,'|', sposti);
	puhnro=Mjonot.erota(sb,'|', puhnro);
	postinro= Mjonot.erota(sb,  '|', postinro);
	kaupunki=Mjonot.erota(sb,'|',kaupunki);
	
}

private void setLiikeID(int numero) {
	this.liikeID=numero;
	if(this.liikeID>=seuraavaNro) {
		seuraavaNro=numero+1;
	}
	
}
public void setKaupunki(String uusi) {
	this.kaupunki=uusi;
	
}

public Liike clone() throws CloneNotSupportedException {
	Liike uusi;
	uusi= (Liike) super.clone();
	return uusi;
}
public void setLiikenimi(String uusi) {
this.liikenimi=uusi;
	
}
public void setPuhnro(String uusi) {
	this.puhnro=uusi;
	
}
public void setSposti(String uusi) {
	this.sposti=uusi;
	
}
public void setOsoite(String uusi) {
	this.osoite=uusi;
}
public void setPostinro(int uusi) {
	this.postinro=uusi;
	
}
public void aseta(String uusi, int nro, TextField kentta) {

	switch(nro) {
	case 1: setLiikenimi(uusi); break;
	case 2:setPuhnro(uusi); break;
	case 3:setSposti(uusi); break;
	case 4:setOsoite(uusi); break;
	case 5:try {int uusipostinro = Integer.parseInt(uusi);
	setPostinro(uusipostinro);
	kentta.getStyleClass().add("normaali");
	break;
	}catch(NumberFormatException e) {
		kentta.getStyleClass().add("virhe");
		break;
	}
	case 6:setKaupunki(uusi); break;
		
	default:
		break;
	
}

}
public int ekaKentta() {
	return 1;
}

/**
 * antaa tietyn arvon liikkeen tiedoista
 * @param hk
 * @return
 */
public String anna(int hk) {
	switch(hk) {
	case 1: return "" + liikenimi;
	case 2:	return "" + osoite;
	case 3: return ""+ kaupunki;
	default: return "vika";
	}
	
}
}

