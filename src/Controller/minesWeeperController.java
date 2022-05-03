/**
 * Class minesWeeperController: clase de controller que maneja la iteracion del usuario con la aplicacion
 * @author Jhonnier Isaza
 * @author Camilo Vargas
 * @version 1.0
*/

package Controller;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import Modelo.Panel;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class minesWeeperController implements Initializable{
	
	//Asociacion
	Panel panel;
	
	//Atributos
	@FXML 
	private GridPane minesWeeper;
	@FXML
    private TextField Coordenadas;
	@FXML
    private Button help;
	@FXML 
	private Button btSolution;
	
	/**
	 * Metodo constructor
	 */
	public minesWeeperController(){
		
	}
	
	/**
	 * Metodo: initializable.<br>
	 * <br> pre: <br>. El usuario elige el nivel que desea jugar.<br>
	 * <br> pos: <br>. Dependiendo el nivel que elija se obtienen el tamaño del buscaminas y se llama la ventana correpondiente.<br>
	 */
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		if(minesWeeper.impl_getColumnCount()==8) {
			panel = new Panel(1);
		}else if(minesWeeper.impl_getColumnCount()==16){
			panel = new Panel(2);
		}else if(minesWeeper.impl_getColumnCount()==30)
			panel = new Panel(3);
	}
	
	/**
	 * Metodo: getHint.<br>
	 * Este metodo le da una pista al jugador del buscaminas.<br>
	 * <br> pre: <br> Que ya se haya mostrado el tablero dependiendo del nivel.<br>
	 * <br> pre: <br> Que ya se haya creado los recuadros.<br>
	 * <br> pos: <br> Se muestra la ayuda, siendo un numero diferente de cero y donde no hay minas.<br>
	 * @param event: Que el boton haya sido presionado.<br>
	 */
	@FXML
	void getHint(ActionEvent event) {
		int row = 0;
		int column = 0;
		char r = ' ';
		char c = ' ';
		String ro = "";
		String co = "";
		String hint = panel.hint();
		if(hint.equalsIgnoreCase("No hay pistas disponibles")){
			Coordenadas.setText(hint);
		} else {
			r = hint.charAt(1);
			if(r == ' ') {
				c = hint.charAt(4);
				row = Integer.parseInt(hint.charAt(0)+"");
				if(c == ' ') {
					column = Integer.parseInt(hint.charAt(3)+"");
				} else if(c != ' '){
					co = hint.substring(3, 5);
					column = Integer.parseInt(co);
				}
			} else if(r != ' '){
				c = hint.charAt(5);
				ro = hint.substring(0, 2);
				row = Integer.parseInt(ro);
				if (c == ' ') {
					column = Integer.parseInt(hint.charAt(4) + "");
				} else if(c != ' ') {
					co = hint.substring(4, 6);
					column = Integer.parseInt(co);
				}	
			}	
			Button result = null;
			ObservableList<Node> childrens = minesWeeper.getChildren();
			for (Node node : childrens ) {
				if(minesWeeper.getRowIndex(node) == row && minesWeeper.getColumnIndex(node) == column) {
			    	result = (Button) node;
			    	Coordenadas.setText(row+","+column);
			    	result.setText(panel.getNumber(row, column));
			    	result.setDisable(true);
			    	break;
			    }
			}	
		}	
	}
	
	/**
	 * Metodo: getSolution.<br>
	 * Este metodo muestra la solucion del Buscaminas cuando el jugador lo desee<br>
	 * <br> pre: <br> Que ya se haya mostrado el tablero dependiendo del nivel.<br>
	 * <br> pre: <br> Que ya se haya creado los recuadros.<br>
	 * <br> pos: <br> Se muestra la solucion del buscaminas y se desabilitan los botones de pista y solucion.<br>
	 * @param event: Que el boton haya sido presionado.<br>
	 */
	@FXML
	void getSolution(ActionEvent event) {
		panel.solution();
		int size = panel.getColumns()+1;
		int size1 = panel.getRows()+1;
		btSolution.setDisable(true);
		help.setDisable(true);
		for(int i = 0; i<size1 ;i++) {
			for(int k = 0; k<size; k++) {
				Button result = null;
				ObservableList<Node> childrens = minesWeeper.getChildren();
				for (Node node : childrens ) {
		    		if(minesWeeper.getRowIndex(node) == i && minesWeeper.getColumnIndex(node) == k) {
		            result = (Button) node;
		            result.setText(panel.getNumber(i, k));
		            result.setDisable(true);
		            break;
		    		}
				}	
			}
		}
	}
	
	/**
	 * Metodo: newGame.<br>
	 * Este metodo le da la opcion al usuario de regresar a la pantalla principal para jugar de nuevo, ya sea el mismo nivel u otro.<br>
	 * <br> pre: <br> Que ya se haya mostrado el tablero dependiendo del nivel.<br>
	 * <br> pre: <br> Que ya se haya creado los recuadros.<br>
	 * <br> pos: <br> Regresa a la ventana principal donde podra seleccionar el nuevo nivel que quiere jugar.<br>
	 * @param event: Que el boton haya sido presionado.<br>
	 */
	@FXML
	void newGame(ActionEvent event) {
		try {
			Parent viewMain = FXMLLoader.load(getClass().getResource("/application/MainWindow.fxml"));
			Scene sceneMain = new Scene(viewMain);
			Stage windowMain = (Stage) ((Node) event.getSource()).getScene().getWindow();
			windowMain.setScene(sceneMain);
			windowMain.show();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
    }
    
	/**
	 * Metodo: searchMine.<br>
	 * Este metodo busca si hay minas donde presiono y muestra si perdio o el numero que va en esa posicion.<br>
	 * <br> pre: <br> Que ya se haya mostrado el tablero dependiendo del nivel.<br>
	 * <br> pre: <br> Que ya se haya creado los recuadros.<br>
	 * <br> pos: <br> Si hay una mina en ese lugar, se muestra un alert que indica que perdio.<br>
	 * <br> pos: <br> Si no hay minas se muestra el numero indicado dependiendo de cuantas minas haya alrededor. Si no hay se muestra el 0.<br>
	 * @param event: Que el boton haya sido presionado
	 */
    @FXML
    void searchMine(ActionEvent event) {
    	Button button = (Button) event.getSource(); 
    	int row = GridPane.getRowIndex(button);
    	int column = GridPane.getColumnIndex(button);
		if(panel.continueGame(row,column)== true){
			help.setDisable(true);
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("¡ATENCION!");
			alert.setContentText("¡Haz Perdido,Suerte para la proxima!");
			alert.setHeaderText("¡A continuation veras la solucion");
			alert.show();
			getSolution(event);
			Button result = null;
			ObservableList<Node> childrens = minesWeeper.getChildren();
			int size = panel.getColumns()+1;
			int size1 = panel.getRows()+1;
			for(int i = 0; i<size1 ;i++) {
				for(int k = 0; k<size; k++) {
					for (Node node : childrens ) {
						if(minesWeeper.getRowIndex(node) == i && minesWeeper.getColumnIndex(node) == k) {
							result = (Button) node;
							result.setDisable(true);
							break;
							}
						}
					}
				}
			}else if(panel.continueGame(row,column)== false){
			panel.numberMines(row,column);
			button.setText(panel.getNumber(row,column));
			button.setDisable(true);
			if(panel.win() == true){
				getSolution(event);
				Alert won = new Alert(AlertType.WARNING);
				won.setTitle("¡ATENCION!");
				won.setContentText("¡FELICITACIONES! HAZ GANADO");
				won.setHeaderText("¡BUENA SUERTE!");
				won.show();
				Button result = null;
				ObservableList<Node> childrens = minesWeeper.getChildren();
				int size = panel.getColumns()+1;
				int size1 = panel.getRows()+1;
				for(int i = 0; i<size1 ;i++) {
					for(int k = 0; k<size; k++) {
						for (Node node : childrens ) {
							if(minesWeeper.getRowIndex(node) == i && minesWeeper.getColumnIndex(node) == k) {
								result = (Button) node;
								result.setDisable(true);
								break;
							}
						}
					}
				}
			}
		} 	
    }

	
}
