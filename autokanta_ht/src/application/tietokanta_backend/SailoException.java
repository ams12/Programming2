package tietokanta_backend;

public class SailoException extends Exception {
	
	private static final long serialVersionUID=1L;
	
	
	/**
	 * poikkeuksen muodostaja ja käytettävä viesti
	 * @param viesti
	 */
	public SailoException(String viesti) {
		super(viesti);
	}
}
