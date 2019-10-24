package TableViews;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import Interfaz.Caracteristicas_De_Archivos;
import Interfaz.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.control.ToolBar;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public class TableViewer {
	
	public static TableView<Caracteristicas_De_Archivos> tabla2 = new TableView();
	public TableColumn columnas;
	static String Nombre;
	static String Direccion; 
	static String Peso;
	String Fecha;
	static FilteredList lista; 
	private VBox caja = new VBox();  
	private TitledPane txtPane = new TitledPane(); 
	
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
	public void setTable(FilteredList Lista, TableViewer table, TableColumn ColumDir, TableColumn ColumName, TableColumn ColumSize,TableColumn ColumDate) {
		
		
		TableView<Caracteristicas_De_Archivos> tablita = new TableView();
		
		tablita.getColumns().addAll(ColumDir, ColumName,ColumSize,ColumDate);
		
		tablita.setOnMouseClicked(new EventHandler<MouseEvent>(){
	        @Override
	        //Ordenar Este metodo en otro lugar
	        public void handle(MouseEvent event) {
	        	if (event.getClickCount() == 2) //Checking double click
	            {
	        		File file = new File(tablita.getSelectionModel().getSelectedItem().getDireccion());
	        		try {
	        			
	        			FileReader Archivo_Por_Leer = new FileReader(file);
		        		try (BufferedReader reader = new BufferedReader(Archivo_Por_Leer)) {

		        	        String line;
		        	        while ((line = reader.readLine()) != null)
		        	        	Main.texto.setText(line);
		        	    } catch (IOException e) {
		        	        e.printStackTrace();
		        	    }
	        			
	        		}catch(Exception L){
	        			
	        		}
	        		
	        	}             
	        }
		});
		tablita.setItems(Lista);
		this.tabla2 = tablita;

		
	}

	//TlitedPane con el table view para visualizar Txt 
	public void crearCaja(TextField Entrada1, TableView<Caracteristicas_De_Archivos> Tabla,FilteredList<Caracteristicas_De_Archivos> Lista) {
		BorderPane EstructuraInterior = new BorderPane(); 
		ToolBar Superior = new ToolBar(Entrada1);
		EstructuraInterior.setTop(Superior);
		EstructuraInterior.setCenter(Tabla);
		ScrollPane izquierda = new ScrollPane(EstructuraInterior);
		izquierda.setPrefHeight(1000);
		izquierda.setMaxSize(335, 1000);
		Tabla.setPrefHeight(1000);
		Tabla.setPrefWidth(1000);
		//METODO PARA LA BUSQUEDA
		Entrada1.setPromptText("BuscarArchivo");
		Entrada1.textProperty().addListener((prop, old, text) -> {
		    Lista.setPredicate(person -> {
		        if(text == null || text.isEmpty()) return true;
		        
		        String name = person.getNombre().toLowerCase();  
		        return name.contains(text.toLowerCase());
		    });
		});
		TitledPane Datos_txt = new TitledPane("", EstructuraInterior);
		Datos_txt.setText("Archivos TXT");
		Datos_txt.setExpanded(true);
		this.txtPane=Datos_txt;
		this.tabla2 = Tabla;

	}
	public TitledPane getTXTPane() {
		return txtPane;
	}

}
