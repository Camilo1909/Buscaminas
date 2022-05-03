/**
 * Class MainController: clase de controller abre cualquiera de las tres ventanas del buscaminas
 * @author Jhonnier Isaza
 * @author Camilo Vargas
 * @version 1.0
*/

package Controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainController implements Initializable {

	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub	
	}

	/**
     * Metodo: getPrincipiante.<br>
     * Este metodo abre la ventana del nivel de Principiante del Buscaminas.<b>
     * <b> pre: <b>. Debe de estar creado el boton de Principiante.<b>
     * <b> pos: <b>. Se abre la ventana de Principiante.<b>
     * @param: Que el usuario elija le de clic al boton de Principiante.<b>
     */
    @FXML
    void getPrincipiante(ActionEvent event) {
    	try {
			Parent viewBegin = FXMLLoader.load(getClass().getResource("/application/Principiante.fxml"));
			Scene sceneBegin = new Scene(viewBegin);
			Stage windowBe = (Stage) ((Node) event.getSource()).getScene().getWindow();
			windowBe.setScene(sceneBegin);
			windowBe.show();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
    }
    
    /**
     * Metodo: getIntermedio.<br>
     * Este metodo abre la ventana del nivel de intermedio del Buscaminas.<b>
     * <b> pre: <b>. Debe de estar creado el boton de Intermedio.<b>
     * <b> pos: <b>. Se abre la ventana de Intermedio.<b>
     * @param: Que el usuario elija le de clic al boton de Intermedio.<b>
     */
    @FXML
    void getIntermedio(ActionEvent event) {
    	try {
			Parent viewIntermedium = FXMLLoader.load(getClass().getResource("/application/Intermedio.fxml"));
			Scene sceneIntermedium = new Scene(viewIntermedium);
			Stage windowIn = (Stage) ((Node) event.getSource()).getScene().getWindow();
			windowIn.setScene(sceneIntermedium);
			windowIn.show();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
    }
    
    /**
     * Metodo: getExperto.<br>
     * Este metodo abre la ventana del nivel de Experto del Buscaminas.<b>
     * <b> pre: <b>. Debe de estar creado el boton de Experto.<b>
     * <b> pos: <b>. Abre la ventana de Experto.<b>
     * @param: Que el usuario elija le de clic al boton de Experto.<b>
     */
    @FXML
    void getExperto(ActionEvent event) {
    	try {
			Parent viewExpert = FXMLLoader.load(getClass().getResource("/application/Experto.fxml"));
			Scene sceneExpert = new Scene(viewExpert);
			Stage windowEx = (Stage) ((Node) event.getSource()).getScene().getWindow();
			windowEx.setScene(sceneExpert);
			windowEx.show();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
    }
}
