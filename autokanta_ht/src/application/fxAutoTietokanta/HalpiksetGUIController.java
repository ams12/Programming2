package fxAutoTietokanta;

import java.util.List;

import fi.jyu.mit.fxgui.Dialogs;
import fi.jyu.mit.fxgui.ModalController;
import fi.jyu.mit.fxgui.ModalControllerInterface;
import fi.jyu.mit.fxgui.StringGrid;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import tietokanta_backendUusi.Auto;

public class HalpiksetGUIController implements ModalControllerInterface<Auto>{

    @FXML
    private static StringGrid<Auto> tableHalpikset;
    private Auto valittuauto;
    @FXML
    private Button btnOK;
    @FXML
    private Button btnPalaa;
    @FXML
    void handleOKS() {
    	ModalController.closeStage(btnOK);
    }
    @FXML
    void handlePalaa() {
    	valittuauto=null;
    	ModalController.closeStage(btnOK);
    	
    }
    
	public static void naytaHalpikset(Stage modalitystage, List<Auto> halpikset) {
		
		for(Auto auto:halpikset) {
			naytaAuto(auto);
		}
		//return ModalController.showModal(HalpiksetGUIController.class.getResource("HalpiksetGUI.fxml"), null, modalitystage, valittuauto);
		
			 
		
	}

		 
		
 

    
			private static void naytaAuto(Auto auto) {
					String[] rivi=auto.toString().split("\\|");
					tableHalpikset.add(auto, rivi[1], rivi[2], rivi[3], rivi[4], rivi[5], rivi[6] , rivi[7] , rivi[8], rivi[9]);
						Dialogs.showMessageDialog("Onnistui halpikset");
	
}






			@Override
			public Auto getResult() {
				return valittuauto;
			}






			@Override
			public void handleShown() {
				// TODO Auto-generated method stub
				
			}






			@Override
			public void setDefault(Auto auto) {
				 this.valittuauto=auto;
				
			}


}