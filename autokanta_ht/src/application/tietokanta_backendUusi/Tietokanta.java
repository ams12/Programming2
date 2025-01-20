package tietokanta_backendUusi;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import fi.jyu.mit.ohj2.WildChars;
import tietokanta_backendUusi.SailoException;

public class Tietokanta {
public final Autot autot= new Autot();
private final Liikkeet liikkeet = new Liikkeet();
private Auto apuauto= new Auto();


public int getLiikkeidenLkm() {
	return liikkeet.getLkm();
}



/**
 * välittää tallennuskäskyn alemmille luokille, eli autot ja liikkeet-luokille
 */
public void tallenna() {
	try {
		autot.tallenna();
		liikkeet.tallenna();
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SailoException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

}
/**
 * määrittää tiedostojen oletussijainnin kutsumalla aliohjelmaa settiedosto
 * välittää käskyn luea tiedosto alemmille luokille (autot ja liikkeet)
 * 
 * @param sijainti
 * @throws SailoException
 */
public void lueTiedosto(String sijainti) throws SailoException {
	
	setTiedosto(sijainti);
	autot.lueTiedostosta();
	liikkeet.luetiedosto();
}
/**
 * määrittää vakion tiedosto- liikkeisiin ja autot-luokkaan. 
 * @param nimi
 */
public void setTiedosto(String nimi) {

    File dir = new File(nimi);

    dir.mkdirs();

    String hakemistonNimi = "";

    if ( !nimi.isEmpty() ) hakemistonNimi = nimi +"/";

    liikkeet.setTiedostonPerusNimi(hakemistonNimi + "liikkeet.txt");

    autot.setTiedostonPerusNimi(hakemistonNimi + "autot.txt");

}

/**
 * Lisää liikkeen tietorakenteeseen liikkeet
 * @param liike
 * @throws SailoException
 */
public void lisaa(Liike liike) throws SailoException {
	liikkeet.lisaa(liike);
}

/**
 * lisää auton autot-tietorakenteeseen 
 * @param auto
 * @throws SailoException
 */
public void lisaa(Auto auto) throws SailoException {
	autot.lisaa(auto);
}

/**
 * välittää käskyn liike-luokalle antaa liike kohdassa i
 * @param i
 * @return
 */
public Liike annaLiike(int i) {
	return liikkeet.anna(i);
}
/**
 * antaa käskyn autot-luokalle antaa kaikki autot tietorakenteestaan, joissa on merkitty sijainti-idksi parametrina annettu liike
 * @param liike
 * @return
 */
public List <Auto> annaLiikkeenAutot(Liike liike){
	return autot.annaLiikkeenAutot(liike.getLiikeID());
}



/**
 * @example
 * <pre name="test">
 *Tietokanta tietokanta= new Tietokanta();
	 Tietokanta tietokanta= new Tietokanta(); 
    Autot autot= new Autot(); 
    Auto auto= new Auto(); 
    auto.rekisteroi(); 
    Auto auto2= new Auto(); 
    auto2.rekisteroi(); 
    auto.taytaTiedot(); 
    auto2.taytaTiedot(); 
    Liike liike= new Liike(); 
    liike.rekisteroi(); 
    liike.taytaTiedot(); 
    tietokanta.lueTiedosto("testi"); 
    int t1 = tietokanta.autot.getLkm(); 
    tietokanta.lisaa(auto); 
    tietokanta.lisaa(auto2); 
    int t2= tietokanta.autot.getLkm(); 
    assertEquals("From: Tietokanta line: 105", t1+2, t2); 
    tietokanta.tallenna(); 
    tietokanta.poista(auto2);
    Auto auto3= new Auto();
    Auto auto4= new Auto();
    auto3.rekisteroi();
    auto4.rekisteroi();
    Liike liike2=new Liike();
    liike2.rekisteroi();
    auto3.taytaTiedot(liike2.getLiikeID());
    auto4.taytaTiedot(liike2.getLiikeID());
    tietokanta.lisaa(liike2);
    tietokanta.lisaa(auto3);
    tietokanta.lisaa(auto3);
    tietokanta.poista(liike2);
  	liike2.getKaupunki===null;
  	auto4===null;
    assertEquals(t2, t1+2);
	
	tietokanta.tallenna();
 * </pre>
 * @param args
 * @throws SailoException
 */
public static void main(String[] args) throws SailoException {
	Tietokanta tietokanta= new Tietokanta();
	Autot autot= new Autot();
	Auto auto= new Auto();
	auto.rekisteroi();
	Auto auto2= new Auto();
	auto2.rekisteroi();
	auto.taytaTiedot();
	auto2.taytaTiedot();
	Liike liike= new Liike();
	liike.rekisteroi();
	liike.taytaTiedot();
	
	tietokanta.lueTiedosto("testi");
	System.out.println(tietokanta.autot.getLkm());	
	
	tietokanta.lisaa(auto);
	tietokanta.lisaa(auto2);
	System.out.println(tietokanta.autot.getLkm()); 
	tietokanta.tallenna();
	
	
	
	
	List<Auto> loydetyt = tietokanta.annaLiikkeenAutot(liike);
	for(Auto autolistasta:loydetyt) {
		autolistasta.tulosta(System.out);
	}
	
	
	
}

/**
 * välittää käskyn korvata tai lisätä liikkeet-luokalle
 * @param liike
 * @throws SailoException
 */
public void korvaaTaiLisaa(Liike liike) throws SailoException {
	liikkeet.korvaaTaiLisaa(liike);
	
}

/**
 * välittää käskyn korvata tai lisätä autot-luokalle
 * @param auto
 */
public void korvaaTaiLisaa(Auto auto) {
	autot.korvaaTaiLisaa(auto);
	
}

/**
 * välittää poista-käskyn autot-luokalle
 * @param autokohdalla
 */
public void poista(Auto autokohdalla) {
	autot.poista(autokohdalla);
	
}

/**
 * välittää poista-käskyn liikkeet-luokalle. Myöskin poistaa liikkeessä olevat autot.
 * @param liikekohdalla
 */
public void poista(Liike liikekohdalla) {
	if(liikekohdalla==null)return;
	int poistettavaID= liikekohdalla.getLiikeID();
 
	int poistettavanliikkeenID=	liikkeet.poista(poistettavaID);
 
	autot.poistaLiikkeenAutot(poistettavaID);
	
	
}


public Collection<Liike> etsi(String ehto, int k) {
	return liikkeet.etsi(ehto, k);
}

/**
 * etsitään sekä palautetaan joka ikinen liike ja jokaisen liikkeen autot. 
 * 
 * @param hakuehto
 * @param k
 * @return
 */
public List<Auto> etsiAutot(String hakuehto, int k) {
	List<Auto>loydetythalpikset = new ArrayList<Auto>();
	String ehto= "*";
	 if ( hakuehto != null && hakuehto.length() > 0 ) ehto = hakuehto; 
     int hk = k; 
     if ( hk < 0 ) hk = 0;
     List<Auto>loydetyt = new ArrayList<Auto>();	
	for(Liike liike:liikkeet) {
		 
	
		loydetyt=autot.annaLiikkeenAutot(liike.getLiikeID());
		for(Auto auto:loydetyt) {
			if(WildChars.onkoSamat(auto.anna(hk), ehto)) {
				loydetythalpikset.add(auto);
			}
		}
	}
	return loydetythalpikset;
}

/**
 * jokaiseen autoon on tallennettu liikkeen id. metodi palauttaa liikkeen valitusta autosta. 
 * @param autokohdalla
 * @return
 */
public Liike getLiikeAutosta(Auto autokohdalla) {
	int liikeid= autokohdalla.getLiikeID();
	return liikkeet.anna(liikeid);
}







}
