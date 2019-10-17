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
	public void setTable(TableColumn Nombre,TableColumn Tamaño,TableColumn Fecha) {
		TableView tablita = new TableView();
		tablita.getColumns().addAll(Nombre,Tamaño,Fecha);
		this.tabla=tablita;
	}
	

}
