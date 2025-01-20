package fxAutoTietokanta;


import java.awt.Desktop;
 
 
import java.io.IOException;
import java.io.PrintStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.ResourceBundle;

import fi.jyu.mit.fxgui.ComboBoxChooser;
import fi.jyu.mit.fxgui.Dialogs;
import fi.jyu.mit.fxgui.ListChooser;
import fi.jyu.mit.fxgui.ModalController;
import fi.jyu.mit.fxgui.StringGrid;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;

import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;

// --------------------------------------------------------------------//
//----------------------Omat importit -----------------------------------

import tietokanta_backendUusi.Auto;
import tietokanta_backendUusi.Liike;
import tietokanta_backendUusi.Liikkeet;
import tietokanta_backendUusi.Autot;
import tietokanta_backendUusi.Tietokanta;
import tietokanta_backendUusi.SailoException;
 


 
 

public class AutokantaController implements Initializable  {
    @FXML
    private BorderPane borderPane;
    @FXML
    private MenuButton Hakuehto;
    
    @FXML
    private Button btnUusiLiike;
    
    @FXML
    private Menu apua;
    @FXML
    private MenuItem lisaaLiike;
    
    @FXML
    private MenuItem muokkaaliike;
    

    @FXML
    private TextField hakulause;

    @FXML
    private MenuItem lisaaAutoMenu;
    

    @FXML
    private Menu muokkaa;

    @FXML
    private MenuItem muokkaaAutoaMenu;

    @FXML
    private MenuItem poistaAutoMenu;

    @FXML
    private MenuItem suljeohjelma;

    @FXML
    private Button tallenna;

    @FXML
    private Menu tiedosto;

    @FXML
    private MenuItem tietojamenu;

    @FXML
    private Button uusiauto;
    
    @FXML
    private Button kirjauduSisaas;
    
    @FXML
    private MenuItem AvaaBTN;
    
    @FXML
    private TextField txtLiiikepostinro;
    @FXML
    private TextField txtLiikePuhnro;
    @FXML
    private TextField txtLiikekaupunki;
    @FXML
    private TextField txtLiikeosoite;
    @FXML
    private TextField txtliikeSposti;
    @FXML
    private TextField txtLiikeNimi;
    @FXML
    private TextField txtLiikeID;
    
    @FXML
    private TextField hinta;

    @FXML
    private TextField kayttovoima;

    @FXML
    private TextField kuvaus;

    @FXML
    private TextField malli;

    @FXML
    private TextField merkki;

    @FXML
    private TextField mittarilukema;

    @FXML
    private TextField moottorikoko;

    @FXML
    private TextField rekisterinumero;

    @FXML
    private TextField vuosimalli;
    
    
    @FXML
    private Button btnPoistaAuto;
    

    @FXML
    private Button btnPoistaLiike;
    
    @FXML
    private MenuItem jekku;
    
    @FXML
    private ComboBoxChooser<String> cbAutoHaku;
    
    @FXML
    private TextField txtAutoHakuEhto;
 
    
    @FXML
    private StringGrid<Auto> tableAutot;
    
    

    @FXML
      ListChooser<Liike> chooserLiike;
    
    @FXML
    private TextArea textareaLiike;
    
    @FXML
    private ComboBoxChooser<String> cbHakuehto;
   
	  /**
	   * Alustusmetodi
	   */
	  @Override
		public void initialize(URL arg0, ResourceBundle arg1) {
		alusta();
	 
			
		}
	  
	  /**
	   * Hallinnoi HAKU-ikkunan toimintaa
	   * @param event
	 * @throws SailoException 
	   */
	@FXML
    private void handleHaku() throws SailoException {
		 hae(0);

    }
	 @FXML
	    void handleAutohaku() throws SailoException {
		autoHaku();
	    }
	
	   @FXML
	    void handleAvaa(ActionEvent event) {
		   	avaa();
	    }
	
	   @FXML
	    void handleMuokkaaLiiketta(ActionEvent event) throws CloneNotSupportedException, SailoException {
		   	muokkaa();
	    }
	   
	   
	   @FXML
	    void handleLisaaLiike(ActionEvent event) {
		   uusiliikemetodi();
	    }
	   
	   @FXML
	    void handlePoistaLiike(ActionEvent event) {
		   poistaLiike();
	    }

	    @FXML
	    void handlePoistaAuto(ActionEvent event) {
	    	poistaAuto();
	    }
	   
 

	@FXML
    void UusiLiike(ActionEvent event) {
    	uusiliikemetodi();
    }
    
	 
	/**
	 * kysyy haluaako käyttäjä tosiaan sulkea ohjelman. mikäli kyllä, niin sulkee ojelman ensin tallentaen
	 * @param event
	 */
	  @FXML
	    void suljeOhjelma(ActionEvent event) {
		  if(!Dialogs.showQuestionDialog("Poistuminen", "Poistutaanko ohjelmasta? " , "Kyllä", "ei"))	return;
		  tallenna();
		  Platform.exit();
	    }

	/**
	 * avaa avustus-aliohjelman vastaavaa painiketta avatessa
	 * @param event
	 */
	   @FXML
	    void handleAvustus(ActionEvent event) {
		   avustus();
	    }
	   
	   /**
	    * avaa muokkaa auton tietoja-kohtaan liittyvän uuden ikkunan
	    * @param event
	 * @throws CloneNotSupportedException 
	 * @throws SailoException 
	    */
	    @FXML
	    void handleMuokkaa(ActionEvent event) throws SailoException, CloneNotSupportedException {
	    muokkaaAutoa();
	    }  

 
	    	/**
	    	 * tallentaisi tiedot suoraan uuteen 
	    	 * @param event
	    	 */
	@FXML
    void handleTallenna(ActionEvent event) {
    	tallenna();
    }
 
    @FXML
    void printError(ActionEvent event) {
    	Dialogs.showMessageDialog("ei voida sulkea");
    }
    
    @FXML
    void kirjaudu(ActionEvent event) {
    	
    }
    
    
    

  /**
   * uusi auto-nappia painettaessa avaa uusiautometodi-aliohjelmnan
   */
    @FXML
    public void uusiAuto() {
    /**	ModalController.showModal
    	(AutokantaController.class.getResource("LisaaAuto.fxml")," testi ",null , "");
    	**/
    	uusiautometodi();
    }
 

 /**javafxml-hässäkät
  * =------------------------------------------------------------------------------------------------
  * ------------------------------------------------------------------------------
  * ------------------------------------------------------------------------------
  *///omaa koodia

    
	private Tietokanta tietokanta;
	private Liike liikekohdalla;
	private Auto autokohdalla;
	   private static Liike apuliike= new Liike();
	   //private static Auto apuauto= new Auto();
	private String maakunta="Keski-Suomi";

	private TextField [] edits;
	private TextField [] kentat;
	
	/***
	 * avaa ohjelman käyttöön liiittyvät ohjeet
	 */
    private void avustus() {
    	Desktop desktop = Desktop.getDesktop();
    	URI uri;
		try {
			uri = new URI("https://tim.jyu.fi/view/kurssit/tie/ohj2/2022s/ht/aaelmust");
			desktop.browse(uri);
		} catch (URISyntaxException | IOException e) {
			System.out.println("Vikatila avustuksessa" + e);// TODO Auto-generated catch block
			 
		}
     
		
	}

    /**
     * antaa käskyn lukea tiedosto tietokanta-luokalle. tämän jälkeen käskee hae-aliohjelmaa hakemaan akikki tiedostosta luetut toiminteet listchooseriin
     * @param sijainti
     * @return
     * @throws SailoException
     */
    private String luetiedosto(String sijainti) throws SailoException {
    	maakunta=sijainti;
    try {	
    	tietokanta.lueTiedosto(sijainti);
    	hae(0);
    	return null;
    }catch (SailoException e) {
    	hae(0);
    	String virhe = e.getMessage();
    	Dialogs.showMessageDialog(virhe);
    	return virhe;
    }
    }
	
	     
    /**
     * tallenna-aliohjelma tietojen tallentamista varten
     */
	public  void tallenna() {
		tietokanta.tallenna();
		Dialogs.showMessageDialog("tallennus onnistui!");
		
	}
	
/**
 * kysyy käyttäjälät minkä maakunnan autokannan hän haluaa avata
 */
    private void avaa() {
String uusinimi= KirjautuminenController.kysyMaakunta(null, maakunta);
	 
       try {
		luetiedosto(uusinimi);
	} catch (SailoException e) {
		// TODO Auto-generated catch block
		Dialogs.showMessageDialog("virhe! " + e );
	}
		
	}

	
	/**
	 * asetetaan tietokanta ohjelmalle
	 * @param tietokanta
	 */
	
	public void setTietokanta(Tietokanta tietokanta) {
		this.tietokanta=tietokanta;
		naytaLiike();
		 avaa();
		 
		
		
		
	}
	
	 
	
	
	
	
	/**
	 * alustaa listchooserin null-arovihin
	 */
	protected void alusta() {
		
		
		 
		
		chooserLiike.clear();
		 
		 
		chooserLiike.addSelectionListener(e -> naytaLiike());
		 
		
		edits = new TextField[] { txtLiikeNimi , txtLiikePuhnro , txtliikeSposti , txtLiikeosoite , txtLiiikepostinro , txtLiikekaupunki }; 
	 
		kentat = new TextField[] {
				merkki, malli, vuosimalli, mittarilukema, rekisterinumero, moottorikoko, kayttovoima, hinta, kuvaus
		}; 
		
		
		
		
	}

	 
		
		

		/**
		 * näyttää liikkeen tiedotpienessä ikkunassa, sekä näyttää valitun liikkeen autot.
		 */
	public void naytaLiike() {
		liikekohdalla=chooserLiike.getSelectedObject();
		if(liikekohdalla==null) return;
		//txtLiikeNimi.setText(liikekohdalla.getNimi());
		LiikeDialogController.naytaLiike(edits, liikekohdalla);
		
		naytaLiikkeenAutot(liikekohdalla);
		
		 
		 
		 
		
		
			
	}

		
	/**
	 * näyttää valutussa liikkeessä olevat autot
	 * @param liikekohdalla2
	 */
		private void naytaLiikkeenAutot(Liike liikekohdalla2) {
		tableAutot.clear();
			if (liikekohdalla2==null) return;
		
		List<Auto> autotliikkeessa= tietokanta.annaLiikkeenAutot(liikekohdalla2);	
		if(autotliikkeessa.size()==0) {
			return;
		}
			
		for(Auto auto:autotliikkeessa) {
			naytaAuto(auto);
		}
		 
		 
		
			 
		
	}
		/**
		 * lisää valitun liikkeen autot stringridiin näytille
		 * @param auto
		 */
		private void naytaAuto(Auto auto) {
			String[] rivi=auto.toString().split("\\|");
			tableAutot.add(auto, rivi[1], rivi[2], rivi[3], rivi[4], rivi[5], rivi[6] , rivi[7] , rivi[8], rivi[9]);
			tableAutot.setOnMouseClicked(e->naytaLiikeAutonPerusteella());
			
		}
		/**
		 * kun auto on valittu, näyttää ohjelma kyseisen liikkeen tiedot käyttäjälle
		 */
		private void naytaLiikeAutonPerusteella() {
			autokohdalla=tableAutot.getObject();
			if(autokohdalla==null)return;
			liikekohdalla=tietokanta.getLiikeAutosta(autokohdalla);
			LisaaAutoController.naytaAuto(kentat, autokohdalla);
			LiikeDialogController.naytaLiike(edits, liikekohdalla);
		}
/**
 * liikkeen muokkaamiseen ohjelam
 * @throws SailoException
 * @throws CloneNotSupportedException
 */
		private void muokkaa() throws SailoException, CloneNotSupportedException  {
			Liike liikekohdalla=chooserLiike.getSelectedObject();
			if(liikekohdalla==null) return;
			
			Liike liike;
			liike = LiikeDialogController.kysyLiike(null, liikekohdalla.clone());
			 if(liike == null)return;
			 tietokanta.korvaaTaiLisaa(liike);
			 hae(liike.getLiikeID()); 
			
			 
		}
		/**
		 * auton muokkaamiseen sopiva ohjelma
		 * @throws SailoException
		 * @throws CloneNotSupportedException
		 */
		private void muokkaaAutoa() throws SailoException, CloneNotSupportedException {
			autokohdalla=tableAutot.getObject();
			if(autokohdalla==null) return;
			
			Auto auto;
			auto = LisaaAutoController.kysyAuto(null, autokohdalla.clone());
			 if(auto == null)return;
			tietokanta.korvaaTaiLisaa(auto);
			naytaLiikkeenAutot(liikekohdalla);
			
		}





	
	/**
	 * uuden liikkeen lisäämiseen ohjelma
	 */
	public void uusiliikemetodi() {
		
		
		try {
			Liike uusiliike= new Liike();
			 
			uusiliike = LiikeDialogController.kysyLiike(null, uusiliike);
			if(uusiliike==null) return;
			uusiliike.rekisteroi();
			tietokanta.lisaa(uusiliike);
			hae(uusiliike.getLiikeID());
		} catch (SailoException e) {
			// TODO Auto-generated catch block
			Dialogs.showMessageDialog("Lisäys ei valitettavasti onnistunut");
			return;	
		}
		
	}
		/**
		 * hakee liikkeet, jotka ovat sopivilla parametreilla varustettu
		 * @param liikeid
		 * @throws SailoException
		 */
		protected void hae(int liikeid) throws SailoException {
			
			int likeID = liikeid; 
			        if ( likeID <= 0 ) { 
			            Liike kohdalla = liikekohdalla; 
			            if ( kohdalla != null ) likeID = kohdalla.getLiikeID();
			        }
			        
			        int k = cbHakuehto.getSelectionModel().getSelectedIndex() + apuliike.ekaKentta(); 
			        String ehto = hakulause.getText(); 
			        if (ehto.indexOf('*') < 0) ehto = "*" + ehto + "*"; 
			        
			        chooserLiike.clear();
			
			        int index = 0;
			        Collection<Liike> liikkeet;
			        try {
			        liikkeet = tietokanta.etsi(ehto, k);
					int i = 0;
					for (Liike liike:liikkeet) {
					    if (liike.getLiikeID()== likeID) index = i;
					    chooserLiike.add(liike.getNimi(),liike);
					    i++;
					}
			        }catch(Exception e) {
			        	Dialogs.showMessageDialog("haussa tuli vika" + e);
			        }
			        chooserLiike.setSelectedIndex(index); 
			    }
			
			
			
			

	/**
	 * metodi uuden auton lisäämiseksi. Avaa uuden ikkunan
	 */
	public void uusiautometodi() {
		try {
		Auto uusiauto = new Auto();
		Liike liikekohdalla= chooserLiike.getSelectedObject();
		
		uusiauto = LisaaAutoController.kysyAuto(null, uusiauto);
		if(uusiauto==null) {
			return;
		}
		uusiauto.setLiikeID(liikekohdalla.getLiikeID());
		
		uusiauto.rekisteroi();
		tietokanta.lisaa(uusiauto);
		naytaLiikkeenAutot(liikekohdalla);
		}catch(Exception e) {
			Dialogs.showMessageDialog("Vikatila" + e);
		}
	 
		
		
			
	}
	
	/**
	 * näyttää listchooserista valitun auton tiedot, ja kutsuu aliohjelmaa naytaLiike
	 * @param autot2 
	 */
	
	
	public void tulosta(PrintStream os,   Liike liike) {

        os.println("----------------------------------------------");

        liike.tulosta(os);

        os.println("----------------------------------------------");
       
        
        
        List<Auto> autot = tietokanta.annaLiikkeenAutot(liike);
        
        for (Auto auto:autot) {

            auto.tulosta(os);  
            os.println("==========");
        }
       
        
        
        

    }
	
	/**
	 * poistaa valitun liikkeen, sekä siinä sijaitsevat autot
	 */
private void poistaLiike() {
	liikekohdalla=chooserLiike.getSelectedObject();
	if(liikekohdalla==null) {
		return;
	}
	if(!Dialogs.showQuestionDialog("Liikkeen poistaminen", "Poistetaanko liike " + liikekohdalla.getNimi(), "Kyllä", "ei"))	return;
	try {
		tietokanta.poista(liikekohdalla);
		hae(0);
		Dialogs.showMessageDialog("Liikkeen poisto onnistui");
	}catch(Exception e) {
		Dialogs.showMessageDialog(""+e );
	}
	
	
	}
 	/**
 	 * poistaa vlaitun liikkeen 
 	 */
	private void poistaAuto() {
		autokohdalla=tableAutot.getObject();
		if(autokohdalla==null)return;
		if(!Dialogs.showQuestionDialog("Auton poistaminen", "Poistetaanko auto " + autokohdalla.getMerkki(), "Kyllä", "ei"))	return;
		try {
		tietokanta.poista(autokohdalla);
		hae(0);
		Dialogs.showMessageDialog("auto poistettu");
		
	}catch(Exception e) {
		Dialogs.showMessageDialog("Poisto epäonnistyi syystä "  + e);
	}
	
}
	
	/**
	 * aliohjelma auton hakemiseen 
	 * @throws SailoException
	 */
	private void autoHaku() throws SailoException {
		List<Auto> haetutautot=new ArrayList<Auto>();
		 int k = cbAutoHaku.getSelectionModel().getSelectedIndex() ;
		   String ehto = txtAutoHakuEhto.getText();
		   if (ehto.indexOf('*') < 0) ehto = "*" + ehto + "*"; 
		 
		haetutautot=tietokanta.etsiAutot(ehto, k);
		//if(halpikset.size()<1) Dialogs.showMessageDialog("Ei tarpeeksi autoja");
		tableAutot.clear();
		for(Auto auto:haetutautot) {
			naytaAuto(auto);
		}
		
		
		autokohdalla=tableAutot.getObject();
		
		if(autokohdalla!=null) {
			haeLiikekohdalle(autokohdalla);
			 
		}
		
	}
	/**
	 * hakee valitun auton perusteella liikkeen tiedot ikkunaan näkymään 
	 * @param autokohdalla2
	 * @throws SailoException
	 */
	private void haeLiikekohdalle(Auto autokohdalla2) throws SailoException {
		liikekohdalla=tietokanta.getLiikeAutosta(autokohdalla2);
		hae(liikekohdalla.getLiikeID());
		
	}
	
}
