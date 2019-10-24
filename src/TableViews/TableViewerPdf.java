package TableViews;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import Interfaz.Caracteristicas_De_Archivos;
import Interfaz.Main;
import javafx.collections.transformation.FilteredList;
import javafx.event.EventHandler;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.control.ToolBar;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public class TableViewerPdf extends TableViewer {
	public static TableView<Caracteristicas_De_Archivos> tabla3 = new TableView();


	static FilteredList lista; 
	private TitledPane pdfPane = new TitledPane(); 
	
	public TableView getTable3() {
		
		return tabla3;
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
		
		
		TableView<Caracteristicas_De_Archivos> tablita3 = new TableView();
		
		tablita3.getColumns().addAll(ColumDir, ColumName,ColumSize,ColumDate);
		
		tablita3.setOnMouseClicked(new EventHandler<MouseEvent>(){
	        @Override
	        //Ordenar Este metodo en otro lugar
	        public void handle(MouseEvent event) {
	        	if (event.getClickCount() == 2) //Checking double click
	            {
	        		File file = new File(tablita3.getSelectionModel().getSelectedItem().getDireccion());
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
		tablita3.setItems(Lista);
		this.tabla3 = tablita3;

		
	
	}
	//TlitedPane con el table view para visualizar Txt 
	public void crearCaja(TextField Entrada3, TableView<Caracteristicas_De_Archivos> Tabla,FilteredList<Caracteristicas_De_Archivos> Lista) {
		BorderPane EstructuraInterior = new BorderPane(); 
		ToolBar Superior = new ToolBar(Entrada3);
		EstructuraInterior.setTop(Superior);
		EstructuraInterior.setCenter(Tabla);
		ScrollPane izquierda = new ScrollPane(EstructuraInterior);
		izquierda.setPrefHeight(1000);
		izquierda.setMaxSize(335, 1000);
		Tabla.setPrefHeight(1000);
		Tabla.setPrefWidth(1000);
		//METODO PARA LA BUSQUEDA
		Entrada3.setPromptText("BuscarArchivo");
		Entrada3.textProperty().addListener((prop, old, text) -> {
		    Lista.setPredicate(person -> {
		        if(text == null || text.isEmpty()) return true;
		        
		        String name = person.getNombre().toLowerCase();  
		        return name.contains(text.toLowerCase());
		    });
		});
		TitledPane pdf_Pane = new TitledPane("", EstructuraInterior);
		pdf_Pane.setText("Archivos PDF");
		pdf_Pane.setExpanded(false);
		this.pdfPane=pdf_Pane;
		this.tabla3 = Tabla;

	}
	public TitledPane getPdfPane() {
		return pdfPane;
	}

}

