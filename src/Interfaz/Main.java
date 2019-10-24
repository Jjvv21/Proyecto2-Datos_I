package Interfaz;

import TableViews.TableViewer;
import TableViews.TableViewerDocx;
import TableViews.TableViewerPdf;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToolBar;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;


public class Main extends Application { 
	//ATRIBUTOS DE LA VENTANA PRINCIPAL
	private BorderPane Estructura = new BorderPane();
	public ToolBar Herramientas = new ToolBar();
	private static TextField caja_De_Entrada = new TextField();
	private static TextField searchtxt = new TextField();
	private static TextField searchdocx = new TextField();
	private static TextField searchpdf = new TextField();
	public static Label texto = new Label("Aquí se mostrarán las coincidencias del texto que busques.");
	private static VBox Vertical = new VBox();
	
	
	//ObservableList para los Txt
	public static ObservableList<Caracteristicas_De_Archivos> datostxt = FXCollections.observableArrayList();
	FilteredList<Caracteristicas_De_Archivos> filteredDatatxt = new FilteredList<>(datostxt, p -> true);
	//ObservableList para los Docx 
	public static ObservableList<Caracteristicas_De_Archivos> datosdocx = FXCollections.observableArrayList();
	FilteredList<Caracteristicas_De_Archivos> filteredDatadocx = new FilteredList<>(datosdocx, p -> true);
	//ObservableList para los Pdf 
	public static ObservableList<Caracteristicas_De_Archivos> datospdf = FXCollections.observableArrayList();
	FilteredList<Caracteristicas_De_Archivos> filteredDatapdf = new FilteredList<>(datospdf, p -> true);
	
	public  void start(Stage Stage) {
		
		TableColumn<Caracteristicas_De_Archivos, String> Name1 = new TableColumn<>("Name");
   		Name1.setCellValueFactory(new PropertyValueFactory<Caracteristicas_De_Archivos, String>("Nombre"));
		Name1.setResizable(true);
		
		TableColumn<Caracteristicas_De_Archivos, String> Size1 = new TableColumn<>("Size(Bytes)");
		Size1.setCellValueFactory(new PropertyValueFactory<Caracteristicas_De_Archivos, String>("Peso"));
		Size1.setResizable(true);
		Size1.setMinWidth(150);
		
		TableColumn<Caracteristicas_De_Archivos, String> Location1 = new TableColumn<>("Location");
		
		Location1.setCellValueFactory(new PropertyValueFactory<Caracteristicas_De_Archivos, String>("Direccion"));
		Location1.setResizable(true);
		
		TableColumn<Caracteristicas_De_Archivos, String> Date1 = new TableColumn<>("Date");
		
		Date1.setCellValueFactory(new PropertyValueFactory<Caracteristicas_De_Archivos, String>("Fecha"));
		Date1.setResizable(true);
		
		////////DOCX /////
		
		TableColumn<Caracteristicas_De_Archivos, String> Name2 = new TableColumn<>("Name");
   		Name2.setCellValueFactory(new PropertyValueFactory<Caracteristicas_De_Archivos, String>("Nombre"));
		Name2.setResizable(true);
		
		TableColumn<Caracteristicas_De_Archivos, String> Size2 = new TableColumn<>("Size(Bytes)");
		Size2.setCellValueFactory(new PropertyValueFactory<Caracteristicas_De_Archivos, String>("Peso"));
		Size2.setResizable(true);
		Size2.setMinWidth(150);
		
		TableColumn<Caracteristicas_De_Archivos, String> Location2 = new TableColumn<>("Location");
		
		Location2.setCellValueFactory(new PropertyValueFactory<Caracteristicas_De_Archivos, String>("Direccion"));
		Location2.setResizable(true);
		
		TableColumn<Caracteristicas_De_Archivos, String> Date2 = new TableColumn<>("Date");
		
		Date2.setCellValueFactory(new PropertyValueFactory<Caracteristicas_De_Archivos, String>("Fecha"));
		Date2.setResizable(true);
		
		////PDF /////
		TableColumn<Caracteristicas_De_Archivos, String> Name3 = new TableColumn<>("Name");
   		Name3.setCellValueFactory(new PropertyValueFactory<Caracteristicas_De_Archivos, String>("Nombre"));
		Name3.setResizable(true);
		
		TableColumn<Caracteristicas_De_Archivos, String> Size3 = new TableColumn<>("Size(Bytes)");
		Size3.setCellValueFactory(new PropertyValueFactory<Caracteristicas_De_Archivos, String>("Peso"));
		Size3.setResizable(true);
		Size3.setMinWidth(150);
		
		TableColumn<Caracteristicas_De_Archivos, String> Location3 = new TableColumn<>("Location");
		
		Location3.setCellValueFactory(new PropertyValueFactory<Caracteristicas_De_Archivos, String>("Direccion"));
		Location3.setResizable(true);
		
		TableColumn<Caracteristicas_De_Archivos, String> Date3 = new TableColumn<>("Date");
		
		Date3.setCellValueFactory(new PropertyValueFactory<Caracteristicas_De_Archivos, String>("Fecha"));
		Date3.setResizable(true);
		
		
        // ESTRUCTURA PARA LA TABLA


        //TXT
		TableViewer tabla = new TableViewer();
		TableViewer Estructura2 = new TableViewer();
		//DOCX
		TableViewerDocx Estructura3 = new TableViewerDocx();
		TableViewerDocx tabla2 = new TableViewerDocx();
		//PDF
		TableViewerPdf Estructura4 = new TableViewerPdf();
		TableViewerPdf tabla3 = new TableViewerPdf();
		
		//BOTON AÑADIR
		Botones Añadir = new Botones();
		//BOTON QUITAR
		Botones Quitar = new Botones();
		//BOTON SUBIR
		Botones Subir = new Botones();
		//BOTON BAJAR
		Botones Bajar = new Botones();
		//BOTON BUSCAR
		Botones Buscar = new Botones();
		//
		Controles controles = new Controles();
		//
		Columnas columnas = new Columnas();

		//Configuración del Stackpane que tiene al label en donde se mostrará el texto
		StackPane centeredarch = new StackPane(texto);
		centeredarch.setStyle("-fx-background-color: #d2d7db;");
		
		//
		StackPane archroot = new StackPane(centeredarch);
		archroot.setPadding(new Insets(35));

		
		
		
		
		
		// CREACION DE ELEMENTOS CON SUS PARAMETROS
	
		tabla.setTable(filteredDatatxt, tabla, Location1, Name1,Size1,Date1);
		//
		Estructura2.crearCaja(searchtxt, tabla.getTable(),filteredDatatxt);
		
		
		//
		tabla2.setTable(filteredDatadocx, tabla2, Location2, Name2,Size2,Date2);
		//
		Estructura3.crearCaja(searchdocx, tabla2.getTable2(), filteredDatadocx);
		
		
		//
		tabla3.setTable(filteredDatapdf, tabla3, Location3, Name3,Size3,Date3);
		//
		Estructura4.crearCaja(searchpdf,tabla3.getTable3(), filteredDatapdf);
		//
		
		Añadir.setButton(Añadir, Button_type.Añadir_Archivo, Stage);
		//
		Quitar.setButton(Quitar, Button_type.Quitar_Archivo);
		//
		Subir.setButton(Subir, Button_type.Subir);
		//
		Bajar.setButton(Bajar, Button_type.Bajar);
		//
		Buscar.setButton(Buscar, Button_type.Buscar);
		//
		caja_De_Entrada.setPromptText("Buscar...");
		//
		controles.CrearToolBar(controles);

		
		
		
		
		//Configuración Toolbars
		Herramientas.getItems().addAll(Añadir.getButton(),Quitar.getButton(),Subir.getButton(),Bajar.getButton(),caja_De_Entrada,Buscar.getButton());
		Herramientas.setStyle("-fx-background-color: #6C6C6C;");

		// ESTRUCTURA DE LA CAJA IZQUIERDA
		Vertical.setMaxSize(335, 1000);
		Vertical.setPadding(new Insets(15,0,15,15));
		Vertical.getChildren().addAll(Estructura2.getTXTPane(),Estructura3.getDocxPane(),Estructura4.getPdfPane());
		
		//ESTRUCTURA PRINCIPAL
		
		//Configuración del Texto en el Label
		
		texto.setWrapText(true);
		Estructura.setTop(Herramientas);
		Estructura.setCenter(archroot);
		Estructura.setLeft(Vertical);
		Estructura.setRight(controles.getControles());
		Scene escena = new Scene(Estructura,1350,1000);
		Stage.setTitle("TextFinder");
		Stage.setScene(escena);
		Stage.show();
		
	}
	public static void main(String[] args) {
		launch(args);
	}
}
