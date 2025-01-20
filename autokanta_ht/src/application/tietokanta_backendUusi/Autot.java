package tietokanta_backendUusi;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;


import tietokanta_backendUusi.SailoException;

public class Autot {
	private String tiedostonNimi="autot.txt";
	private String tiedotstonPerusNimi="";
	private final ArrayList<Auto> autolista = new ArrayList<Auto>();
	private boolean muutettu= false;
	
	public Autot() {
		
	}
	/**
	 * lisää auton tietorakenteeseen.
	 * @param auto
	 */
	 public void lisaa(Auto auto) {

	        autolista.add(auto);
	        muutettu= true;
	    }

	 /**
	  * lukee tiedoston perussijainnista 
	  * @throws SailoException
	  */
	 public void lueTiedostosta() throws SailoException {

		 File tiedosto= new File(tiedotstonPerusNimi);
	    	
	    	
	    	try (Scanner lue= new Scanner(new FileInputStream(tiedosto));){
	    		 while(lue.hasNext()) {
	    			 String s= lue.nextLine();
	    			 if(s.equals("")) continue;
	    			 Auto auto= new Auto();
	    			 auto.parse(s);
	    			 lisaa(auto);
	    		 }
	    	} catch(Exception e) {
	    		 throw new SailoException("Tiedostoa" + tiedotstonPerusNimi + " ei ole vielä olemassa "  );	
	    	}
	        
	        

	        

	    }
	 
	 public int getLkm() {

	        return autolista.size();

	    }
	 
	 public Iterator<Auto> iterator() {

	        return autolista.iterator();

	    }
	 
	 
	 public List<Auto> annaLiikkeenAutot(int tunnusnro) {

	        List<Auto> loydetyt = new ArrayList<Auto>();

	        for (Auto auto : autolista)

	            if (auto.getLiikeID()== tunnusnro) loydetyt.add(auto);

	        return loydetyt;

	    }
	 
	 /**
	 

	  * @example
	  * <pre name="test">
	  * Autot autot = new Autot(); 
    Auto auto1 = new Auto(); 
    Auto auto2 = new Auto(); 
    Auto auto3 = new Auto(); 
    Auto auto4 = new Auto(); 
    auto1.taytaTiedot(1); 
    auto2.taytaTiedot(2); 
    auto3.taytaTiedot(2); 
    auto4.taytaTiedot(2); 
    String tiedosto= "testiautot.txt"; 
    autot.setTiedostonPerusNimi(tiedosto);
    File testitiedosto= new File(tiedosto); 
    autot.lisaa(auto1); 
    autot.lisaa(auto2); 
    autot.lisaa(auto3); 
    autot.lisaa(auto4); 
    autot.tallenna(); 
    int lkm = autot.getLkm();
   	lkm===4;
   	
   	autot.poista(auto1);
   	3===autot.getLkm();
   
	  * </pre>
	  * 
	  * @param args
	  * @throws SailoException
	  */
	 public static void main(String[] args) throws SailoException {
		Autot autot1= new Autot();
		Auto auto = new Auto();
		Auto auto2 = new Auto();
		Auto auto3 = new Auto();
		
		try{
			autot1.lueTiedostosta();
		}catch(SailoException e) {
			System.out.println(e);
		}
		 auto.rekisteroi();
		 auto2.rekisteroi();
		 auto3.rekisteroi();
		 
		 auto.taytaTiedot(1);
		 auto2.taytaTiedot(25);
		 auto3.taytaTiedot(2);
		 
		 autot1.lisaa(auto);
		 autot1.lisaa(auto2);
		 
		 autot1.lisaa(auto3);
		 
		 try {
			autot1.tallenna();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SailoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 List<Auto> liikkeenautot= autot1.annaLiikkeenAutot(1);
		 
		 for(Auto autotulostettava: liikkeenautot) {
			 autotulostettava.tulosta(System.out);
		 }
		 
		 
	 }
	 	
	 /**
	  * tallentaa nimet ja liikkeiden autot
	 * @throws SailoException 
	  */
	public void tallenna() throws SailoException, FileNotFoundException {
		if(!muutettu) return;
		
		File tiedosto= new File(this.getTiedostonnimi());
		PrintStream kirjoitin = new PrintStream(new FileOutputStream(tiedosto, false));
		for(Auto auto:autolista){
			kirjoitin.println(auto.toString());
		}
		kirjoitin.close();
		
		
		
	}
/**
 * asettaa tiedoston perusnimen
 * @param string
 */
	public void setTiedostonPerusNimi(String string) {
		this.tiedotstonPerusNimi=string;
		
	}
/**
 * * palauttaa tiedoston perusnimen	
 * @return
 */
	public String getTiedostonnimi() {
		return this.tiedotstonPerusNimi;
	}
	
	/**
	 * päällekirjoittaa vanhan auton tai luo tarvittaessa uuden;
	 * @param auto
	 */
	public void korvaaTaiLisaa(Auto auto) {
		 int id = auto.getTunnusNro();

	        for (int i = 0; i < getLkm(); i++) {

	        	 if (autolista.get(i).getTunnusNro()== id) {

		                autolista.set(i, auto);

	                muutettu = true;

	                return;

	            }

	        }

	        lisaa(auto);
	        
		
	}
/**
 * poistaa annetun auton tietorakenteesta
 * @param autokohdalla
 */
	public void poista(Auto autokohdalla) {
		int index = etsiSijainti(autokohdalla.getTunnusNro());
		autolista.remove(index);
		muutettu=true;
		
	}
	/**
	 * etsii indeksin annetulla auton tunnusluvulla
	 * @param id
	 * @return
	 */
	 public int etsiSijainti(int id) { 
		 for (int i = 0; i < autolista.size(); i++) 
		 if (id == autolista.get(i).getTunnusNro()) return i; 
		 return -1; 
		     }
/**
 *poistettaessaliike, poistetaan myös sen kaikki autot. poistaa kaikki autot, joissa sijainti on sama kun annettu liike-id
 * @param poistettavanliikkeenID
 * @return
 */
	public int poistaLiikkeenAutot(int poistettavanliikkeenID) {
		int n = 0;
		  for (Iterator<Auto> autoIterator = autolista.iterator();autoIterator .hasNext();) {
		           Auto auto= autoIterator .next();
	            if ( auto.getLiikeID()== poistettavanliikkeenID ) {
	            	autoIterator .remove();
		              n++;
		           }
	        }
		        if (n > 0) muutettu = true;
		      return n;
		
	} 




}
