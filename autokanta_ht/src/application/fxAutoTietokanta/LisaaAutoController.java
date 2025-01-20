package fxAutoTietokanta;

import java.net.URL;
import java.util.ResourceBundle;

import fi.jyu.mit.fxgui.Dialogs;
import fi.jyu.mit.fxgui.ModalController;
import fi.jyu.mit.fxgui.ModalControllerInterface;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import tietokanta_backendUusi.Auto;
import tietokanta_backendUusi.Liike;

public class LisaaAutoController implements ModalControllerInterface<Auto>, Initializable {

	
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

    
    
    /**
    0	"merkki"		
    1	"malli" 		
    2	"vuosimalli"		
    3 "mittarilukema" 	
    4	"rekisterinumero"
    5	"moottorikoko" 	
    6	"kayttovoima" 		
    7	"hinta" 		
    8	"kuvaus" 			
                     
	**/

	
    @FXML
    void handleDefaultCancel(ActionEvent event) {
    	autokohdalla=null;
    	ModalController.closeStage(mittarilukema);
    }

    @FXML
    
    void handleDefaultOK(ActionEvent event) {
    	
    	
    	ModalController.closeStage(vuosimalli);
    }
    @FXML
    
    public void handleMuokkaa( ActionEvent event) {
    	
    }
    
     

	@Override
	public void handleShown() {
		 
		
	}
	
	   

	 

	@Override
	public Auto getResult() {
	return autokohdalla;
	}
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		alusta();		
	}

	
	@Override
	public void setDefault(Auto auto) {
		 this.autokohdalla=auto;
		 naytaAuto(kentat, autokohdalla);
		
	}
	
	/**
	 * 
	 * 
	 * 
		
	}
	============================================================================================
		*/
	private Auto autokohdalla;
	private TextField [] kentat;
	
	/**
	 * avaa dialogin auton lisäystä varten, jolloin käyttäjä pääsee syöttämään auton tiedot
	 * @param modalitystage
	 * @param autokohdalla
	 * @return
	 */
	public static Auto kysyAuto(Stage modalitystage, Auto autokohdalla) {
		return 	ModalController.showModal
		    	(AutokantaController.class.getResource("LisaaAuto.fxml")," muokkaa autoa",modalitystage ,  autokohdalla);
			
	}
	/**
	 * näyttää auton tiedot valitusta autosta esim muokkausta varten
	 * @param kentta
	 * @param autokohdalla
	 */
	public static void naytaAuto(TextField[] kentta, Auto autokohdalla ) {
		if(autokohdalla==null) return;
		try {
		for(int i=0;i<kentta.length;i++ ) {
			kentta[i].setText(autokohdalla.anna(i));
		}
		}catch(Exception e) {
			Dialogs.showMessageDialog("virhe" + e);
		}
	}

	
	
	/**
	 * alustaa ikkunan
	 */
	private void alusta() {
		kentat = new TextField[] {
				merkki, malli, vuosimalli, mittarilukema, rekisterinumero, moottorikoko, kayttovoima, hinta, kuvaus
		};
		
		kentat[0].setOnKeyReleased(e -> kasitteleMuutosAutoon(0,kentat[0]));
		kentat[1].setOnKeyReleased(e -> kasitteleMuutosAutoon(1,kentat[1]));
		kentat[2].setOnKeyReleased(e -> kasitteleMuutosAutoon(2,kentat[2]));
		kentat[3].setOnKeyReleased(e -> kasitteleMuutosAutoon(3,kentat[3]));
		kentat[4].setOnKeyReleased(e -> kasitteleMuutosAutoon(4,kentat[4]));
		kentat[5].setOnKeyReleased(e -> kasitteleMuutosAutoon(5,kentat[5]));
		kentat[6].setOnKeyReleased(e -> kasitteleMuutosAutoon(6,kentat[6]));
		kentat[7].setOnKeyReleased(e -> kasitteleMuutosAutoon(7,kentat[7]));
		kentat[8].setOnKeyReleased(e -> kasitteleMuutosAutoon(8,kentat[8]));
		
	}
	/**
	 * käsittelee muutoksen autoon, ja völittää tiedot auto-luokan metodeille.
	 * @param nro
	 * @param kentta
	 */
	private void kasitteleMuutosAutoon(int nro, TextField kentta) {
		if(autokohdalla==null) return; 
		String uusi = kentta.getText();
		autokohdalla.aseta(uusi, nro, kentta);
	}

	 
}
