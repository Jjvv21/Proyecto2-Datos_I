package Interfaz;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class TableViewer {
	
	public static TableViewer tabla = new TableViewer(); 
	public static TableView<Caracteristicas_De_Archivos> tabla2 = new TableView();
	public TableColumn columnas;
	static String Nombre;
	static String Direccion; 
	static String Peso;
	String Fecha;
	static ObservableList lista; 

	
	public TableView getTable() {
		
		return tabla2;
	}
	
	
	
	/**
	 * METODO PARA CREAR UN TABLEVIEW CON LOS DATOS DE LOS ARCHIVOS
	 * @param table
	 * @param Nombre
	 * @param Peso
	 * @param Direccion
	 * @param Fecha
	 */
	public void setTable(ObservableList Lista, TableViewer table, TableColumn ColumDir, TableColumn ColumName, TableColumn ColumSize,TableColumn ColumDate) {
		
		
		TableView<Caracteristicas_De_Archivos> tablita = new TableView();
		
		tablita.getColumns().addAll(ColumDir, ColumName,ColumSize,ColumDate);
		
	
		tablita.setItems(Lista);
		this.tabla2 = tablita;

		
		
		

	}
	public void Direccion(String direccion) {
		this.Direccion=direccion;
	
	}
	public void Peso(long Peso) {
		String PesoStr = Long.toString(Peso);
		this.Peso=PesoStr; 
	}
	public void Fecha(String Fecha) {
		this.Fecha = Fecha; 
	}
	public void Nombre(String Nombre) {

		this.Nombre=Nombre;
	}
	public static String getName() {
		return Nombre;
	}
	public static String getDireccion() {
		return Direccion; 
	}
	public static String getPeso() {
		return Peso; 
	}

	

}
