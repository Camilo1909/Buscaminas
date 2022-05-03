/**s
 * Class Main: clase de application que muestra la primera pantalla del Buscaminas
 * @author Jhonnier Isaza
 * @author Camilo Vargas
 * @version 1.0
*/

package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Main extends Application {

	/**
	 * Nombre del metodo: star.<br>
	 * Este metodo inicia la panalla principal del Buscaminas
	 */
	@Override
	public void start(Stage primaryStage) throws Exception {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("/application/MainWindow.fxml"));
			Parent root = (Parent) loader.load();
			Scene scene = new Scene(root);
			primaryStage.setScene(scene);
			primaryStage.show();
			primaryStage.setResizable(false);
			primaryStage.setTitle("Buscaminas");
			primaryStage.getIcons().add(new Image("/application/Imagen1.png"));
			
		} 
		
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);

	}

}
