package kanta;

import java.util.Random;

public class rekisterinro {
	private String rekisterinumero;
	char[] aakkoset = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
	
	int[] numerot = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};

	public void setReknro(String rnr) {
		this.rekisterinumero=rnr;
	}
	
	/**
	 * @example
	 * <pre name="test">
	 * rekisterinro rnr= new rekisterinro();
	 * boolean eka=System.out.println(rnr.tarkista("ZSR-745"));
	 * boolean toka=System.out.println(rnr.tarkista("ZSR-4777"));
	 * boolean kolmas=System.out.println(rnr.tarkista("tamaonvaintesti"));
	 * boolean neljas=System.out.println(rnr.tarkista("ZSR_745"));
	 * eka===true;
	 * toka===false;
	 * kolmas===false;
	 * neljas===false;
	 * </pre>
	 * @param args
	 */
	public static void main(String[] args) {
		rekisterinro rnr= new rekisterinro();
		
		System.out.println(rnr.tarkista("ZSR-745"));
		System.out.println(rnr.tarkista("ZSR-4777"));
		System.out.println(rnr.tarkista("tamaonvaintesti"));
		System.out.println(rnr.tarkista("ZSR_745"));
		
	}
	
	public boolean tarkista(String rekisterinumero) {
		char[] reknro = rekisterinumero.toCharArray(); 
		
		if(reknro.length>7) {
			return false;
		}
		
		
		if(reknro.length<7) {
		return false;
		}
		
		
		for(int i = 0 ;i<3;i++) {
			boolean onkoOikeamuotoKirjain=	onkoAakkonen(reknro[i]);
				if(onkoOikeamuotoKirjain==false) {
					return false;
			}
		}
		
		for(int i = 4 ;i<7;i++) {
			boolean onkoOikeamuotoNro=	onkoNumero(reknro[i]);
				if(onkoOikeamuotoNro==false) {
					return false;
			}
		}
		
		
		if(reknro[3]!='-') {
			return false;
		}
		
		
		return true;
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
	
	public boolean onkoAakkonen(char aakkonen) {

		
		for(int i=0;i<aakkoset.length;i++) {
			if(Character.toLowerCase(aakkonen)==aakkoset[i]) {
				return true;
			}
		}
		return false;
	}
	
	public boolean onkoNumero(char numero){
		int nro = Character.getNumericValue(numero);
		
		for(int i=0; i<numerot.length; i++) {
			if(nro==numerot[i]) return true;
		}
		return false;
		
	}
}
