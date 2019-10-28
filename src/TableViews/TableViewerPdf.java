package TableViews;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import Interfaz.Botones;
import Interfaz.Caracteristicas_De_Archivos;
import Interfaz.Main;
import Interfaz.Ordenar_Type;
import Interfaz.PantallaDeTexto;
import Logica.LeerPdf;
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
	private Botones BubbleSort = new Botones();
	private Botones QuickSort = new Botones();
	private Botones RadixSort = new Botones();
	PantallaDeTexto Texto = new PantallaDeTexto();
	private LeerPdf lectorPdf = new LeerPdf();
	
	
	
	
	
	
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
						lectorPdf.PdfReader(file);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	        		
	        	}             
	        }
		});
		tablita3.setItems(Lista);
		this.tabla3 = tablita3;

		
	
	}
	//TlitedPane con el table view para visualizar Txt 
	public void crearCaja(TextField Entrada3, TableView<Caracteristicas_De_Archivos> Tabla,FilteredList<Caracteristicas_De_Archivos> Lista) {
		// BOTONES DE BUSQUEDA 
		BubbleSort.BotonesDeBusqueda(BubbleSort,Ordenar_Type.Bubble);
		QuickSort.BotonesDeBusqueda(QuickSort,Ordenar_Type.Quick);
		RadixSort.BotonesDeBusqueda(RadixSort,Ordenar_Type.Radix);
		
		
		// CREACION DE LA ESTRUCTURA 
		BorderPane EstructuraInterior = new BorderPane(); 
		ScrollPane Scroll_Para_EstructuraInterior = new ScrollPane(EstructuraInterior);
		ToolBar Superior = new ToolBar(Entrada3,BubbleSort.getButton(),QuickSort.getButton(),RadixSort.getButton());
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
		TitledPane pdf_Pane = new TitledPane("", Scroll_Para_EstructuraInterior);
		pdf_Pane.setText("Archivos PDF");
		pdf_Pane.setExpanded(false);
		this.pdfPane=pdf_Pane;
		this.tabla3 = Tabla;

	}
	public TitledPane getPdfPane() {
		return pdfPane;
	}

}

