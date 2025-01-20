package application;

import fi.jyu.mit.fxgui.Dialogs;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class AutokantaController {

	  @FXML
	    private Menu apua;

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
	    private Button lisaaAutoIkkunaLisaa;

	    @FXML
	    private Button poistuLisaaAutoIkkuna;
	    
	    @FXML
	    private Button OKVirhe;
	    
	   
	    @FXML
	    void printError(ActionEvent event) {

	    	 Dialogs.showMessageDialog("Ei osata tehdä vielä!!");
	    }

}
