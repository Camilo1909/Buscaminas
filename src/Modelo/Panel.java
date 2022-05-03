/**
 * Class Panel: clase del modelo que maneja los recuadros de la clase Box
 * @author Jhonnier Isaza
 * @author Camilo Vargas
 * @version 1.0
*/

package Modelo;

public class Panel {
	
	//Constantes
		public static final int PRINCIPIANTE = 1;
		public static final int INTERMEDIO = 2;
		public static final int EXPERTO = 3;
		public static final int COLUMNAS_PRINCIPIANTE = 8;
		public static final int FILAS_PRINCIPIANTE = 8;
		public static final int COLUMNAS_INTERMEDIO = 16;
		public static final int FILAS_INTERMEDIO = 16;
		public static final int COLUMNAS_EXPERTO = 30;
		public static final int FILAS_EXPERTO = 16;
		
		//Atributos
		private Box table[][];
		private int mines;
		private int rows;
		private int columns;
		
		/**
		*Nombre del metodo: Panel.<br>
		*Este metodo es el constructor de la clase, es el encargado de incicializar los atributos.<br>
		*<b> pre: </b>. Deben haber atributos para inicializar.<br>
		*<b> post: </b> Se incializan los atributos.<br>
		*@param dificult - dificult == PRINCIPIANTE, dificult == INTERMEDIO, dificult == EXPERTO
		*/
		public Panel (int dificult){
			
			if(dificult == PRINCIPIANTE){
				mines = 10;
				table = new Box[FILAS_PRINCIPIANTE][COLUMNAS_PRINCIPIANTE];
				rows = FILAS_PRINCIPIANTE-1;
				columns = COLUMNAS_PRINCIPIANTE-1;
			}else if(dificult == INTERMEDIO){
				mines = 40;
				table = new Box[FILAS_INTERMEDIO][COLUMNAS_INTERMEDIO];
				rows = FILAS_INTERMEDIO-1;
				columns = COLUMNAS_INTERMEDIO-1;
			}else if(dificult == EXPERTO){
				mines = 99;
				table = new Box[FILAS_EXPERTO][COLUMNAS_EXPERTO];
				rows = FILAS_EXPERTO-1;
				columns = COLUMNAS_EXPERTO-1;
			}
		initializeBox();
		generateMines();
			
		}
		/**
		*Nombre del metodo: initializeBox.<br>
		*Este metodo es el encargado de incializar cada posicion que se encuentra dentro de la matriz.<br>
		*<b> pre: </b> La matriz debe ser de tipo Recuadro.<br>
		*<b> post: </b> Se incializa cada posicion dentro de la matriz.<br>
		*/
		public void initializeBox(){
			for (int i = 0; i < table.length; i++) {
				for (int j = 0; j < table[0].length; j++) {
					table[i][j] = new Box("-",false);
				}
			}
		}
		
		/**
		 *Nombre del metodo: getColumns.<br>
		 *Este metod es el encargado de retornar la cantidad de columnas que hay en la matriz.<br>
		 *<b>pre:</b> Debe estar inicializado dicho atributo</b> 
		 *@return columns
		 */
		public int getColumns() {
			return columns;
		}
		/**
		 *Nombre del metodo: getRows.<br>
		 *Este metod es el encargado de retornar la cantidad de columnas que hay en la matriz.<br>
		 *<b>pre: </b>Debe estar inicializado dicho atributo</b> 
		 *@return rows
		 */
		public int getRows() {
			return rows;
		}
		
		/**
		 * Nombre del metodo: getNumber.<br>
		 * Este metodo es el encargado de retornar el numero de minas alrededor de una posiciones<br>
		 * @param row - La fila que el jugador abre, fila debe ser mayor o igual a 0 y dependiendo del tamaño de la matriz para nivel PRINCIPIANTE fila debe ser menor o igual a 8, para nivel INTERMEDIO fila debe ser menor o igual a 16 y para nivel EXPERTO fila debe ser menor o igual a 16 
		 * @param column - La columna que el jugador abre, columna debe ser mayor 0 y dependiendo del tamaño de la matriz para nivel PRINCIPIANTE columna deber ser menor o igual a 8, para nivel INTERMEDIO columna debe der menor o igual a 16 y para nivel EXPERTO columna debe ser menor o igual a 30
		 * @return number
		 */
		public String getNumber(int row, int column) {
			String number;
			number = table[row][column].getNumine();
			return number;
		}

		/**
		*Nombre del metodo: generateMines.<br>
		*Este metodo es el encargado de generar minas en posiciones aleatorias dentro de la matriz.<br>
		*<b> pre: </b> La matriz debe estar incializada.<br>
		*<b> post: </b> Se generan la cantidad de minas corrspondientes al tamaño de la matriz en posiciones aletorias de la matriz.<br>
		*/
		public void generateMines(){
			int cnew;
			int rnew;
				for(int i = 0; i<mines; i++){
					rnew = (int) (Math.random() * rows+1);
					cnew = (int) (Math.random() * columns+1);
					if(table[rnew][cnew].getMine() == false) {
					table[rnew][cnew].setMine(true);
					}else if(table[rnew][cnew].getMine() == true) {
						i--;
					}
				}
			}
		/**
		*Nombre del metodo: marcarMinas. <br>
		*Este metodo permite marcar una posicion donde el jugador piense que hay una mina.<br>
		*<b> pre: </b> La matriz debe estar incializada, se debe de haber generado minas, el jugador debe de estar jugando.<br>
		*<b> post: </b> Modificica el numero de minas por una "X" para determinar que en esa posicion existe una mina.<br>
		*@param fila - La fila que el jugador abre, fila debe ser mayor o igual a 0 y dependiendo del tamaño de la matriz para nivel PRINCIPIANTE fila debe ser menor o igual a 8, para nivel INTERMEDIO fila debe ser menor o igual a 16 y para nivel EXPERTO fila debe ser menor o igual a 16 
		*@param columna - La columna que el jugador abre, columna debe ser mayor 0 y dependiendo del tamaño de la matriz para nivel PRINCIPIANTE columna deber ser menor o igual a 8, para nivel INTERMEDIO columna debe der menor o igual a 16 y para nivel EXPERTO columna debe ser menor o igual a 30
		*/
		public void marcarMinas(int row, int column){
			table[row-1][column-1].setNumine("X");
		}
		/**
		*Nombre del metodo: solution.<br>
		*Este metodo permite saber la solution de la matriz, mostrando las posiciones con mina y las casillas con la contidad de minas alrededor.<br>
		*<b> pre: </b> El jugador debe estar cansado de jugar y desea ver la solution.<br>
		*<b> post: </b> Se debe mostrar la matriz con su respectiva solution.<br>
		*/
		public void solution(){
			for(int t = 0; t<table.length; t++){
				for(int k = 0; k<table[0].length; k++){
					if(table[t][k].getMine()== true){
						table[t][k].setNumine("X");
					}else{
						numberMines(t,k);
					}
				}
			}
		}
		/**
		*Nombre del metodo: hint.<br>
		*Este metodo es el encargado de abriri la primer posicion que tiene minas alrededor.<br>
		*<b> pre: </b> .<br>
		*<b> post: </b> Se modifica la primer posicion con minas alrededor.<br>
		*/
		public String hint(){
			boolean stop = false;
			String track = "";
			int accountant = 0;
			int positions = table.length*table[0].length;
			for(int f = 0; f<table.length && !stop; f++){
				for(int c = 0 ; c<table[0].length && !stop; c++){
					accountant++;
					if(table[f][c].getNumine().equals("-")){
						numberMines(f,c);
						if(table[f][c].getMine() == true){
							table[f][c].setNumine("-");
						} else if(!table[f][c].getNumine().equals("0")){
							track += Integer.toString(f) + "  " + Integer.toString(c) + "   ";
							stop = true;
						} else if(table[f][c].getNumine().equals("0")){
							table[f][c].setNumine("-");
							stop = false;
						}
					}
				}
				
			 } if(positions == accountant){
				track += "No hay pistas disponibles";
			 }
			
			return track;
		}
		
		/**
		*Nombre del metodo: numberMines. <br>
		*Este metodo permite saber cuantas minas hay alrededor de una posision que no tiene minas.<br>
		*<b> pre: </b> La matriz debe estar incializada, se debe de haber generado minas, el jugador debe de estar jugando.<br>
		*<b> post: </b> Modificica el numero de minas alrededor de una posicion sin mina.<br>
		*@param fila - La fila que el jugador abre, fila debe ser mayor o igual a 0 y dependiendo del tamaño de la matriz para nivel PRINCIPIANTE fila debe ser menor o igual a 8, para nivel INTERMEDIO fila debe ser menor o igual a 16 y para nivel EXPERTO fila debe ser menor o igual a 16 
		*@param columna - La columna que el jugador abre, columna debe ser mayor 0 y dependiendo del tamaño de la matriz para nivel PRINCIPIANTE columna deber ser menor o igual a 8, para nivel INTERMEDIO columna debe der menor o igual a 16 y para nivel EXPERTO columna debe ser menor o igual a 30
		*/
		public void numberMines(int row, int column){
			int numinas = 0;
			String num = "";
			if((row-1 >= 0) && (row+1<=rows) && (column-1>=0) && (column+1<=columns) ){
				if(table[row-1][column-1].getMine() == true){
					numinas++;
				}if(table[row-1][column].getMine() == true){
					numinas++;
				}if(table[row-1][column+1].getMine() == true){
					numinas++;
				}if(table[row][column-1].getMine() == true){
					numinas++;
				}if(table[row][column+1].getMine() == true){
					numinas++;
				}if(table[row+1][column-1].getMine() == true){
					numinas++;
				}if(table[row+1][column].getMine() == true){
					numinas++;
				}if(table[row+1][column+1].getMine() == true){
					numinas++;
				}
			}else if((column-1 <0) && (row-1 <0)){
				if(table[row][column+1].getMine() == true){
					numinas++;
				}if(table[row+1][column].getMine() == true){
					numinas++;
				}if(table[row+1][column+1].getMine() == true){
					numinas++;
				}
			}else if((row+1>rows)&&(column-1<0)){
				if(table[row-1][column].getMine() == true){
					numinas++;
				}if(table[row][column+1].getMine() == true){
					numinas++;
				}if(table[row-1][column+1].getMine() == true){
					numinas++;
				}
			}else if((column+1>columns)&&(row-1<0)){
				if(table[row][column-1].getMine() == true){
					numinas++;
				}if(table[row+1][column-1].getMine() == true){
					numinas++;
				}if(table[row+1][column].getMine() == true){
					numinas++;
				}
			}else if((column+1>columns)&&(row+1>rows)){
				if(table[row-1][column-1].getMine() == true){
					numinas++;
				}if(table[row-1][column].getMine() == true){
					numinas++;
				}if(table[row][column-1].getMine() == true){
					numinas++;
				}
			}else if(row-1 < 0){
				if(table[row][column+1].getMine() == true){
					numinas++;
				}if(table[row+1][column].getMine() == true){
					numinas++;
				}if(table[row+1][column+1].getMine() == true){
					numinas++;
				}if(table[row+1][column-1].getMine() == true){
					numinas++;
				}if(table[row][column-1].getMine() == true){
					numinas++;
				}
			}else if(column-1<0){
				if(table[row][column+1].getMine() == true){
					numinas++;
				}if(table[row+1][column].getMine() == true){
					numinas++;
				}if(table[row+1][column+1].getMine() == true){
					numinas++;
				}if(table[row-1][column].getMine() == true){
					numinas++;
				}if(table[row-1][column+1].getMine() == true){
					numinas++;
				}
			}else if(column+1>columns){
				if(table[row-1][column].getMine() == true){
					numinas++;
				}if(table[row+1][column].getMine() == true){
					numinas++;
				}if(table[row][column-1].getMine() == true){
					numinas++;
				}if(table[row-1][column-1].getMine() == true){
					numinas++;
				}if(table[row+1][column-1].getMine() == true){
					numinas++;
				}
			}else if(row+1>rows){
				if(table[row][column-1].getMine() == true){
					numinas++;
				}if(table[row][column+1].getMine() == true){
					numinas++;
				}if(table[row-1][column].getMine() == true){
					numinas++;
				}if(table[row-1][column-1].getMine() == true){
					numinas++;
				}if(table[row-1][column+1].getMine() == true){
					numinas++;
				}
			}
			num = Integer.toString(numinas);
			table[row][column].setNumine(num);
		}
		/**
		*Nombre del metodo: continueGame.<br>
		*Este metodo permite saber si el jugador perdio o puede seguir jugando.<br>
		*<b> pre: </b> la matriz debe estar incializada, se debe de haber generado minas, el jugador ya ha empezado a jugar.<br>
		*@param fila - La fila que el jugador abre, fila debe ser mayor o igual a 0 y dependiendo del tamaño de la matriz para nivel PRINCIPIANTE fila debe ser menor o igual a 8, para nivel INTERMEDIO fila debe ser menor o igual a 16 y para nivel EXPERTO fila debe ser menor o igual a 16 
		*@param columna - La columna que el jugador abre, columna debe ser mayor 0 y dependiendo del tamaño de la matriz para nivel PRINCIPIANTE columna deber ser menor o igual a 8, para nivel INTERMEDIO columna debe der menor o igual a 16 y para nivel EXPERTO columna debe ser menor o igual a 30
		*@return continuar - continuar == true para determinar que el jugador perdio,continuar == false para determinar que el jugador puede seguir jugando
		*/
		public boolean continueGame(int row, int column){
			boolean follow = false;
			if(table[row][column].getMine() == true){
				follow = true;
			}else if (table[row][column].getMine() == false){
				follow = false;
			}
			return follow;
		}
		/**
		*Nombre del metodo: win.<br>
		*Este metodo permite saber cuando el jugador gana.<br>
		*<b> pre: </b> La matriz debe estar incializada, se debe de haber generado minas, el jugador ya ha empezado a jugar.<br>
		*@return gano - gano == true para determinar si gano, gano == false para determinar que no ha ganado todavia
		*/
		public boolean win(){
			boolean won = false;
			int accountant = 0;
			int win = table.length*table[0].length;
			for(int t = 0; t<table.length; t++){
				for(int k = 0 ; k<table[0].length; k++){
					if((table[t][k].getMine() != true && table[t][k].getNumine() != "-") || (table[t][k].getMine() == true && table[t][k].getNumine() == "-" || table[t][k].getMine() == true && table[t][k].getNumine() == "X")){
						accountant ++;
					}
				}
			}if(accountant == win){
				won = true;
			}
			return won;
		}
}