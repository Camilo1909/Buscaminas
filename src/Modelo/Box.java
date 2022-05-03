/**
 * Class Box: clase del modelo que tiene las minas y los numeros del recuadro
 * @author Jhonnier Isaza
 * @author Camilo Vargas
 * @version 1.0
*/

package Modelo;

public class Box {
	
	private boolean mine;
	private String numine;
	
	/**
	*Nombre del metodo: Box.<br>
	*Este metodo es el constructor de la clase, es el encargado de incicializar los atributos.<br>
	*<b>pre: </b>. Deben haber atriutos por inicializar.<br>
	*<b>post: </b> Se incializan los atributos.<br>
	*@param numine - Este paramtero determina la catidad de minas alrededor, debe ser numine = "-" o numine == "X" o  numina mayor o igual a 0 y menor o igual a 8
	*@param mine - Este parametro determina si hay o no mina, debe ser mine == false o mine == true
	*/
	public Box (String numine, boolean mine){
	this.mine = mine;
	this.numine = numine;
	}
	/**
	*Nombre del metodo: getMine.<br>
	*Este metodo es el encargado de retornar si hay o no mina.<br>
	*<b>pre: </b> mine debe estar incializada y mine == true o mine == false.<br>
	*@return mine
	*/
	public boolean getMine(){
		return mine;
	}
	/**
	*Nombre del metodo: setMine.<br>
	*Este metodo es el encargado de modificar la existencia de una mina.<br>
	*<b>pre: </b> mina debe estar incializada.<br>
	*<b>post: </b> Se modifica el estado del atributo mine.<br>
	*@param mine - mine == false o mine == true.
	*/
	public void setMine(boolean mine){
		this.mine = mine;
	}
	/**
	*Nombre del metodo: getNumine.<br>
	*Este metodo es el encargado de retornar el numero de minas alrededor.<br>
	*<b>pre: </b> numina debe estar incializada, numine == "-" o numine == "X" o  numine mayor o igual a 0 y menor o igual a 8.<br>
	*@return numine
	*/
	public String getNumine(){
		return numine;
	}
	/**
	*Nombre del metodo: setNumine.<br>
	*Este metodo es el encargado de modificar el numero de minas existentes alrededor.<br>
	*<b>pre: </b> numina debe estar incializada.<br>
	*<b>post: </b> Se modifica el numero de minas alrededor.<br>
	*@param numine - numine == "-" o numine == "X" o  numine mayor o igual a 0 y menor o igual a 8
	*/
	public void setNumine(String numine){
		this.numine = numine;
	}

}
