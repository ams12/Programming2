package fxAutoTietokanta;

import java.net.URL;
import java.util.ResourceBundle;

import fi.jyu.mit.fxgui.Dialogs;
import fi.jyu.mit.fxgui.ModalController;
import fi.jyu.mit.fxgui.ModalControllerInterface;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import tietokanta_backendUusi.Liike;

public class LiikeDialogController implements ModalControllerInterface<Liike> , Initializable{


    @FXML
    private Button btnPeruuta;

    @FXML
    private Button btnTallenna;

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
    
    /**
     * poistuu ikkunasta.
     */

    @FXML
    void handleTallenna() {

    	ModalController.closeStage(btnPeruuta);
    	
    	
    	
    	 
    	
    }
    /**
     * poistuu ikkunasta tallentamatta autoa rakenteeseen.
     */
    @FXML
    void handlePeruuta() {
    	liikekohdalla=null;
    	ModalController.closeStage(btnPeruuta);
    }
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		 alusta();
		
	}

	/**
	 * palauuttaa luodun/muokatun liikkeen tiedot
	 */
	@Override
	public Liike getResult() {
	return liikekohdalla;
	}

	@Override
	public void handleShown() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setDefault(Liike liike) {
		
		this.liikekohdalla=liike;
		naytaLiike(edits, liikekohdalla);
	}
	/*
	=============================================================================================
	**/
	
	private Liike liikekohdalla;
	private TextField [] edits; 

	 
	/**
	 * alustaa textfieldit ja asettaa ne kuunteluun 
	 */
	private void alusta() {
		edits = new TextField[] { txtLiikeNimi , txtLiikePuhnro , txtliikeSposti , txtLiikeosoite , txtLiiikepostinro , txtLiikekaupunki }; 
		
		
	
		txtLiikeNimi.setOnKeyReleased(e -> kasitteleLiikeMuutos( 1 , txtLiikeNimi));
		txtLiikePuhnro.setOnKeyReleased(e -> kasitteleLiikeMuutos(2 , txtLiikePuhnro));
		txtliikeSposti.setOnKeyReleased(e -> kasitteleLiikeMuutos(3, txtliikeSposti));
		
		txtLiikeosoite.setOnKeyReleased(e -> kasitteleLiikeMuutos(4, txtLiikeosoite));
		txtLiiikepostinro.setOnKeyReleased(e -> kasitteleLiikeMuutos(5, txtLiiikepostinro));
		txtLiikekaupunki.setOnKeyReleased(e -> kasitteleLiikeMuutos(6, txtLiikekaupunki));
		
		
	}
	
	 
	
		 
	
	
	       /**
	        * käsittelee muutoksen liikkeeseen       
	        * @param nro
	        * @param kentta
	        */

	private void kasitteleLiikeMuutos(int nro, TextField kentta) {
		if(liikekohdalla==null) return; 
		String uusi = kentta.getText();
		liikekohdalla.aseta(uusi, nro, kentta);
		
	
		
	} 

	
	/**
	 * avaa ikkunan tietojen syöttöä varten
	 * @param modalitystage
	 * @param liikekohdalla
	 * @return
	 */
	public static Liike kysyLiike(Stage modalitystage, Liike liikekohdalla) {
	return 	ModalController.showModal
    	(AutokantaController.class.getResource("LiikeDialogGUIView.fxml")," muokkaa liikettä",modalitystage ,  liikekohdalla);
		
	}
/**
 * asettaa valitun liikkeen tiedot näkyväiin 
 * @param kentta
 * @param liikekohdalla
 */
	public static void naytaLiike(TextField[] kentta, Liike liikekohdalla) {
		try {
		kentta[0].setText(liikekohdalla.getNimi());
		kentta[1].setText(liikekohdalla.getPuhnro());
		kentta[2].setText(liikekohdalla.getSposti());
		kentta[3].setText(liikekohdalla.getOsoite());
		kentta[4].setText(Integer.toString(liikekohdalla.getPostinro()));
		kentta[5].setText(liikekohdalla.getKaupunki());
		}catch(Exception e) {
			Dialogs.showMessageDialog("Vikatila : " + e) ;
		}
		
	}

}
