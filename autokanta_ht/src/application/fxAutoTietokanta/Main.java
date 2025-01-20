package fxAutoTietokanta;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import tietokanta_backendUusi.Tietokanta;

 

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			 final FXMLLoader ldr = new FXMLLoader(getClass().getResource("/fxAutoTietokanta/AutokantaGUIView.fxml"));

	            final Pane root = (Pane)ldr.load();

			  final AutokantaController autoCtrl = (AutokantaController)ldr.getController();

	            final Scene scene = new Scene(root);

			  scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setTitle("Autotietokanta");
			primaryStage.show();
			 Tietokanta tietokanta = new Tietokanta();
			 autoCtrl.setTietokanta(tietokanta);
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
