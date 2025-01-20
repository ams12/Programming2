package fxAutoTietokanta;



import fi.jyu.mit.fxgui.ModalController;
import fi.jyu.mit.fxgui.ModalControllerInterface;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
/**
 * luokka sisäänkirjautumista varten
 * @author aatum
 *
 */
public class KirjautuminenController implements ModalControllerInterface<String> {
	@FXML
    private Button kirjauduSisaas;

    @FXML
    private TextField txtMaakunta;
    private String palaute="";

    @FXML
   private  void kirjaudu(ActionEvent event) {
    	palaute = txtMaakunta.getText();

        ModalController.closeStage(txtMaakunta);

    }

    @FXML
    void printError(MouseEvent event) {

    }

	@Override
	public String getResult() {
		return palaute;
	}

	@Override
	public void handleShown() {
		txtMaakunta.requestFocus();
		
	}

	@Override
	public void setDefault(String arg0) {
	//	txtMaakunta.setText(arg0);
		
	}
	
/*
 * näytää ikkunan, jonka mukaan 
 */
public static String kysyMaakunta(Stage modalityStage, String oletus){
		return ModalController.showModal(

                KirjautuminenController.class.getResource("KirjautuminenGUIView.fxml"),

                "Kerho",

                modalityStage, oletus);
		

	}

   

}
