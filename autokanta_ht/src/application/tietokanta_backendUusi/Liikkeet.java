package tietokanta_backendUusi;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

import fi.jyu.mit.fxgui.Dialogs;
import fi.jyu.mit.ohj2.WildChars;
import tietokanta_backendUusi.SailoException;

public class Liikkeet implements Iterable<Liike> {
	 private static final int MAX_JASENIA   = 5;

	    private int lkm  = 0;
	   
	    private String TiedostonPerusnimi="";
	    private Liike  liikkeet[]      = new Liike[MAX_JASENIA];
	    private boolean muutettu=false;

	    
	    public Liikkeet() {
	    	
	    }
	    /**
	     * lisää liikkeen ansimmäiseen vapaaseen kohtaan;
	     * @param liike
	     * @throws SailoException
	     */
	    public void lisaa(Liike liike) throws SailoException {

	        if (lkm >= liikkeet.length) liikkeet=Arrays.copyOf(liikkeet, lkm+20);

	        liikkeet[lkm] = liike;

	        lkm++;
	        muutettu=true;

	    }
	    /**
	     * palauttaa liikkeen tietorakneteen kohdasta i
	     * @param i
	     * @return
	     * @throws IndexOutOfBoundsException
	     */
	    public Liike anna(int i) throws IndexOutOfBoundsException {

	        if (i < 0 || lkm <= i)

	            throw new IndexOutOfBoundsException("Laiton indeksi: " + i);

	        return liikkeet[i];

	    }
	    
	    public int getLkm() {

	        return lkm;

	    }
	    /**
	     * @example
	     * <pre name="test">
	     * 	Liikkeet liikkeet = new Liikkeet();
			Liike liike = new Liike();
			Liike liike2 = new Liike();
			Liike liike3 = new Liike();
			
		
	     *liikkeet.getLkm()===0;
	     *liikkeet.lisaa(liike);
	     *liikkeet.getLkm()===1;
	     *liikkeet.lisaa(liike2);
	     *liikkeet.getLkm()===2;
	     *
	     * liikkeet.lisaa(liike3);
	     * liikkeet.getLkm()===3;
	     * liikkeet.anna(0)===liike;
	     * liikkeet.poista(liike2);
	     * liikkeet.getLmk()===2;
	     * </pre>	
	     * @param args
	     */
	    public static void main(String[] args) {
	    	Liikkeet liikkeet = new Liikkeet();
			Liike liike = new Liike();
			Liike liike2 = new Liike();
			Liike liike3 = new Liike();
			
			liikkeet.luetiedosto();
			
			liike.rekisteroi();
			liike2.rekisteroi();
			liike3.rekisteroi();
			
			liike.taytaTiedot();
			liike2.taytaTiedot();
			liike3.taytaTiedot();
			
			try {
				liikkeet.lisaa(liike);
				liikkeet.lisaa(liike2);
				liikkeet.lisaa(liike3);
			} catch (SailoException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 
			liikkeet.tallenna();
			
			for(int i=0;i<liikkeet.getLkm();i++) {
				Liike liiketuloste=liikkeet.anna(i);
				System.out.println("Liikkeen nro " + i);
				liiketuloste.tulosta(System.out);
			}
			
			
	    }
	    /**
	     * lukee tiedoston oikeasta tiedostosijainista.
	     */
	   
	    public void luetiedosto() {
	    	File tiedosto= new File(this.getTiedostonPerusNimi());
	    	
	    	
	    	try (Scanner lue= new Scanner(new FileInputStream(tiedosto));){
	    		 while(lue.hasNext()) {
	    			 String s= lue.nextLine();
	    			 if(s.equals("")) continue;
	    			 Liike liike= new Liike();
	    			 liike.parse(s);
	    			 lisaa(liike);
	    		 }
	    	} catch(Exception e) {
	    		Dialogs.showMessageDialog("Tiedostoa "  + TiedostonPerusnimi + "ei ole olemassa. Se luodaan nyt.");
	    		
	    	}
	    	
	    	muutettu=false;
	    }
	    /**
	     * tallentaa annettuun tiedostoon kaikki liikkeet jokta löytyvät tietorakenteesta
	     */
		public void tallenna() {
			if(!muutettu) return;
			File tiedosto= new File(this.getTiedostonPerusNimi());
			try {
				PrintStream kirjoitin = new PrintStream(new FileOutputStream(tiedosto, false));
				
				for(int i=0;i<this.getLkm();i++) {
					Liike liike= this.anna(i); 
				kirjoitin.println(liike.toString());	
				}
				kirjoitin.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 
			
		}
/**
 * asettaa tiedoston perusnimen
 * @param tiedostonimi
 */
		public void setTiedostonPerusNimi(String tiedostonimi) {
		this.TiedostonPerusnimi=tiedostonimi;
			
		}
		/**
		 * palauttaa tiedoston perusnimen
		 * @return
		 */
		public String getTiedostonPerusNimi() {
			return this.TiedostonPerusnimi;
		}

		
			/**
			 * muokkaa annetun liikkeen tietoja (käyttäjän antama) vaikka olis paskat bileet ja rumii ämmii
			 * @param liike
			 * @throws SailoException
			 */
		public void korvaaTaiLisaa(Liike liike) throws SailoException {
			int id= liike.getLiikeID();
			for(int i = 0 ; i<lkm;i++) {
				if(liikkeet[i].getLiikeID()==id) {
					liikkeet[i]=liike;
					muutettu=true;
					return;
				}
			}
			lisaa (liike);
			
			
		}
/**
 * postaa annetullla IDllä olevan liikkeen. Siirtää muita yhden askeleen lähemmäksi 0-arvoa
 * @param poistettavaID
 * @return
 */
		public int poista(int poistettavaID) {
			 int index = getId(poistettavaID); 
			 if (index< 0) return 0; 
			 lkm--; 
			 for (int i = index; i < lkm; i++) 
			 liikkeet[i] = liikkeet[i + 1]; 
			 liikkeet[lkm] = null; 
			 muutettu = true; 
			        return 1; 
			
		}
		/**
		 * antaa indexin id-numeron perusteella
		 * @param idNro
		 * @return
		 */
		private int getId(int idNro) {
		    for (int i = 0; i < lkm; i++) 
		    	            if (idNro == liikkeet[i].getLiikeID()) return i; 
		    	         return -1; 
		}
			/**
			 * haku-aliohjelma-joka palauttaa liikkeent jotka sopivat kriteerit
			 * @param hakuehto
			 * @param k
			 * @return
			 */
		public Collection<Liike> etsi(String hakuehto, int k) { 
			         String ehto = "*"; 
			         if ( hakuehto != null && hakuehto.length() > 0 ) ehto = hakuehto; 
			         int hk = k; 
			         if ( hk < 0 ) hk = 0;
			         List<Liike> loytyneet = new ArrayList<Liike>(); 
			        for(Liike liike:this){ 
			             if (WildChars.onkoSamat(liike.anna(hk), ehto)) loytyneet.add(liike);   
			        
			       
			     }
		
		
			        return loytyneet; 

}

		@Override
		public Iterator<Liike> iterator() {
			return new liikkeetiterator();
		}

		
		public class liikkeetiterator implements Iterator<Liike>{
				private int kohdalla=0;
			@Override
			public boolean hasNext() {
				return kohdalla<getLkm();
			}

			@Override
			public Liike next() {
					if(!hasNext()) {
					throw new NoSuchElementException("Hakemaasi elementtiä ei ole");
					 
				}
					return anna(kohdalla++);
			}
			
		}
}

