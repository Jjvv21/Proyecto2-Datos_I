	package TableViews;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import Interfaz.Botones;
import Interfaz.Caracteristicas_De_Archivos;
import Interfaz.Main;
import Interfaz.Ordenar_Type;
import Logica.LeerDocx;
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

public class TableViewerDocx extends TableViewer {
	
	public static TableView<Caracteristicas_De_Archivos> tabla2 = new TableView();
	static FilteredList lista; 
	private TitledPane txtPane = new TitledPane(); 
	private Botones BubbleSort = new Botones();
	private Botones QuickSort = new Botones();
	private Botones RadixSort = new Botones();
	private LeerDocx LectorDocx = new LeerDocx();
	
	
	
	public TableView getTable2() {
		
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
		
		
		TableView<Caracteristicas_De_Archivos> tablita2 = new TableView();
		
		tablita2.getColumns().addAll(ColumDir, ColumName,ColumSize,ColumDate);
		
		tablita2.setOnMouseClicked(new EventHandler<MouseEvent>(){
	        @Override
	        //Ordenar Este metodo en otro lugar
	        public void handle(MouseEvent event) {
	        	if (event.getClickCount() == 2) //Checking double click
	            {
	        		File file = new File(tablita2.getSelectionModel().getSelectedItem().getDireccion());
	        		LectorDocx.SetText(file);
	        	}             
	        }
		});
		tablita2.setItems(Lista);
		this.tabla2 = tablita2;

		
	
	}
	//TlitedPane con el table view para visualizar Txt 
	public void crearCaja(TextField Entrada2, TableView<Caracteristicas_De_Archivos> Tabla,FilteredList<Caracteristicas_De_Archivos> Lista) {
		// BOTONES DE BUSQUEDA 
		BubbleSort.BotonesDeBusqueda(BubbleSort,Ordenar_Type.Bubble);
		QuickSort.BotonesDeBusqueda(QuickSort,Ordenar_Type.Quick);
		RadixSort.BotonesDeBusqueda(RadixSort,Ordenar_Type.Radix);
		
		
		// CREACION DE LA ESTRUCTURA
		BorderPane EstructuraInterior = new BorderPane(); 
		ScrollPane Scroll_Para_EstructuraInterior = new ScrollPane(EstructuraInterior);
		ToolBar Superior = new ToolBar(Entrada2,BubbleSort.getButton(),QuickSort.getButton(),RadixSort.getButton());
		EstructuraInterior.setTop(Superior);
		EstructuraInterior.setCenter(Tabla);
		ScrollPane izquierda = new ScrollPane(EstructuraInterior);
		izquierda.setPrefHeight(1000);
		izquierda.setMaxSize(335, 1000);
		Tabla.setPrefHeight(1000);
		Tabla.setPrefWidth(1000);
		//METODO PARA LA BUSQUEDA
		Entrada2.setPromptText("BuscarArchivo");
		Entrada2.textProperty().addListener((prop, old, text) -> {
		    Lista.setPredicate(person -> {
		        if(text == null || text.isEmpty()) return true;
		        
		        String name = person.getNombre().toLowerCase();  
		        return name.contains(text.toLowerCase());
		    });
		});
		TitledPane Datos_Docx = new TitledPane("", Scroll_Para_EstructuraInterior);
		Datos_Docx.setText("Archivos DOCX");
		Datos_Docx.setExpanded(false);
		this.txtPane=Datos_Docx;
		this.tabla2 = Tabla;

	}
	public TitledPane getDocxPane() {
		return txtPane;
	}

}
