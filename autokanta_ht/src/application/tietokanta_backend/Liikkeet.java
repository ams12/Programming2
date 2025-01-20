package tietokanta_backend;

import java.util.ArrayList;
import java.util.Collection;

public class Liikkeet {
	private static final int MAX_LIIKKEET=500; 
	private Liike[] liikkeet;
	private int lkm=0;
	
	private Collection<Liike> liikelista = new ArrayList<Liike>();
	/**
	 * parametriton muodostaja, luo automqaattisesti listan Liike-luokan oliille tietokannan lisäämistä varten. Näin saavutetaan linkki luokkien välillä.
	 */
	
	
	/**
	 * @example
	 * <pre name="test">
	 * Liikkeet liikkeet = new Liikkeet();
		
		Liike liike= new Liike();
		Liike liike2= new Liike();
		liike.rekisteroi();
		liike2.rekisteroi();
		try {
			liikkeet.lisaa(liike);
			liikkeet.lisaa(liike2);
		} catch (SailoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	 * </pre>
	 */
	public Liikkeet() {
		 
			liikkeet= new Liike[MAX_LIIKKEET];
		 
	}
	public static void main(String[] args) throws SailoException {
		Liikkeet liikkeet = new Liikkeet();
		
		Liike liike= new Liike();
		Liike liike2= new Liike();
		liike.rekisteroi();
		liike2.rekisteroi();
		liike.taytaTiedot("Makkosen rämä" , "veturintie 34" , "aws@gmail.com" , "05500500",45080,"muurame"  );
		liike2.taytaTiedot("Mikkosen mobiili" , "Telatie 157" , "sales@mikkosenmobiili.com" , "0145134789", 15090,"Ivalo"  );
		 
		liike.tulosta(System.out);
		liikkeet.lisaa(liike);
		liikkeet.lisaa(liike2);
		liike2.tulosta(System.out);
		
		 
		liikkeet.etsiLiike(000).tulosta(System.out);
		
		try {
			liikkeet.lisaa(liike);
		} catch (SailoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	/**
	 * palauttaa liikkeiden lukumäärän
	 * @return
	 */
	public int getLiikkeidenMaara() {
		return lkm;
	}
	/**
	 * lisää liikkeen liikkeiden listaan, ja samalla lisää liikkeiden lukumäärä (lkm) laskuriin 1 kpl
	 * @param liike
	 * @throws SailoException
	 */
	
	public void lisaa(Liike liike) throws SailoException {
		if(lkm>=liikkeet.length) throw new SailoException("Liikaa alkioita!!");
			
		 liikkeet[lkm]=liike;
		 lkm++;
		 
		 
		
	}
	
	public Liike annaliike(int i) {
		return liikkeet[i];
	}
	
	
	/**
	 * Etsii liikelistasta liikkeen annetulla idllä. 
	 * @param liikeid (vastaa valitun auton rekisteröimää id-tunnusta, jota vastaava liike etsitään liikkeet-listasta
	 * @return
	 */
	public Liike etsiLiike(int liikeid) {
		Liike palautettavaliike= new Liike();
			for(Liike liike : liikkeet) {
			 if(liike.getLiikeID()==liikeid) {
				palautettavaliike=liike;
				return palautettavaliike;
			 }
		 }
			return null;
	}
		
	}

