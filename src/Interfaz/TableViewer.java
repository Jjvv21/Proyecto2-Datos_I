package Interfaz;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class TableViewer {
	
	public static TableView tabla = new TableView(); 
	public TableColumn columnas;
	public TableView getTable() {
		return tabla; 
	}
	//Metodo para modificar la Tabla que se va a insertar 
	public void setTable(TableColumn Nombre,TableColumn Tama�o,TableColumn Fecha) {
		TableView tablita = new TableView();
		tablita.getColumns().addAll(Nombre,Tama�o,Fecha);
		this.tabla=tablita;
	}
	

}
