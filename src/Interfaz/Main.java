package Interfaz;

import java.io.FileNotFoundException;

import Logica.BubbleSort;
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
import javafx.scene.image.Image;
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
	private static VBox Vertical = new VBox();
	public static BorderPane Spane = new BorderPane();
	Image icono = new Image("file:icon.png");
	public static Label texto = new Label("Aqui se mostrara el cuerpo del documento seleccionado");
	
	
	//ObservableList para los Txt
	public static ObservableList<Caracteristicas_De_Archivos> datostxt = FXCollections.observableArrayList();
	FilteredList<Caracteristicas_De_Archivos> filteredDatatxt = new FilteredList<>(datostxt, p -> true);
	//ObservableList para los Docx 
	
	public static ObservableList<Caracteristicas_De_Archivos> datosdocx = FXCollections.observableArrayList();
	FilteredList<Caracteristicas_De_Archivos> filteredDatadocx = new FilteredList<>(datosdocx, p -> true);
	
	//ObservableList para los Pdf 
	public static ObservableList<Caracteristicas_De_Archivos> datospdf = FXCollections.observableArrayList();
	FilteredList<Caracteristicas_De_Archivos> filteredDatapdf = new FilteredList<>(datospdf, p -> true);
	
	public  void start(Stage Stage) throws FileNotFoundException {
		
		
		/// TXT /// 
		TableColumn<Caracteristicas_De_Archivos, String> Name1 = new TableColumn<>("Name");
	
		TableColumn<Caracteristicas_De_Archivos, String> Size1 = new TableColumn<>("Size(Bytes)");
				
		TableColumn<Caracteristicas_De_Archivos, String> Location1 = new TableColumn<>("Location");

		TableColumn<Caracteristicas_De_Archivos, String> Date1 = new TableColumn<>("Date");


		
		///// DOCX /////
		
		TableColumn<Caracteristicas_De_Archivos, String> Name2 = new TableColumn<>("Name");
   		
		TableColumn<Caracteristicas_De_Archivos, String> Size2 = new TableColumn<>("Size(Bytes)");
		
		TableColumn<Caracteristicas_De_Archivos, String> Location2 = new TableColumn<>("Location");
		
		TableColumn<Caracteristicas_De_Archivos, String> Date2 = new TableColumn<>("Date");

		////PDF /////
		
		TableColumn<Caracteristicas_De_Archivos, String> Name3 = new TableColumn<>("Name");
		
		TableColumn<Caracteristicas_De_Archivos, String> Size3 = new TableColumn<>("Size(Bytes)");
	
		TableColumn<Caracteristicas_De_Archivos, String> Location3 = new TableColumn<>("Location");
		
		TableColumn<Caracteristicas_De_Archivos, String> Date3 = new TableColumn<>("Date");
		

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
		
		
		//BUBBLESORT
		BubbleSort OrdenarFecha = new BubbleSort();
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
		Columnas Columnas = new Columnas();
		//
		PantallaDeTexto ClaseTexto = new PantallaDeTexto();
		//
		Botones MenuB = new Botones();

		//Configuración del Stackpane que tiene al label en donde se mostrará el texto
		

		// CREACION DE ELEMENTOS CON SUS PARAMETROS
		//COLUMNAS TXT
		Columnas.Nametxt(Name1);
		//
		Columnas.Tamañotxt(Size1);
		//
		Columnas.Direcciontxt(Location1);
		//
		Columnas.Fechatxt(Date1);
	
		
		//COLUMNAS DOCX
		Columnas.Namedocx(Name2);
		//
		Columnas.TamañoDocx(Size2);;
		//
		Columnas.DireccionDocx(Location2);
		//
		Columnas.FechaDocx(Date2);
		
		//COLUMNAS PDF
		Columnas.NamePdf(Name3);
		//
		Columnas.TamañoPdf(Size3);;
		//
		Columnas.DireccionPdf(Location3);
		//
		Columnas.FechaPdf(Date3);
		
		//COLUMNAS TXT 
		//
		tabla.setTable(filteredDatatxt, tabla, Columnas.getDirecciontxt(), Columnas.getNombretxt(),Columnas.getTamañotxt(),Columnas.getFechaTxt());
		//
		Estructura2.crearCaja(searchtxt, tabla.getTable(),filteredDatatxt);
		
		//COLUMNAS DOCX
		//
		tabla2.setTable(filteredDatadocx, tabla2, Columnas.getDireccionDocx(), Columnas.getNombreDocx(),Columnas.getTamañoDocx(),Columnas.getFechaDocx());
		//
		Estructura3.crearCaja(searchdocx, tabla2.getTable2(), filteredDatadocx);
		
		//COLUMNAS PDF
		//
		tabla3.setTable(filteredDatapdf, tabla3, Columnas.getDireccionPdf(),Columnas.getNombrePdf(),Columnas.getTamañoPdf(),Columnas.getFechaPdf());
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
		MenuB.zoom(MenuB,Button_type.Zoom);
		//
		caja_De_Entrada.setPromptText("Buscar...");
		//
		controles.CrearToolBar(controles);
		//
	
		ClaseTexto.CrearEstructuraDeTexto(texto);
		//
		ClaseTexto.setTextPane(Spane);
		
		//Configuración Toolbars
		Herramientas.getItems().addAll(Añadir.getButton(),Quitar.getButton(),Subir.getButton(),Bajar.getButton(),caja_De_Entrada,Buscar.getButton(),MenuB.getMenuB());
		Herramientas.setStyle("-fx-background-color: #6C6C6C;");

		// ESTRUCTURA DE LA CAJA IZQUIERDA
		Vertical.setMaxSize(335, 1000);
		Vertical.setPadding(new Insets(15,0,15,15));
		Vertical.getChildren().addAll(Estructura2.getTXTPane(),Estructura3.getDocxPane(),Estructura4.getPdfPane());
		
		//ESTRUCTURA PRINCIPAL
		Estructura.setTop(Herramientas);
		Estructura.setCenter(Spane);
		Estructura.setLeft(Vertical);
		Estructura.setRight(controles.getControles());
		Scene escena = new Scene(Estructura,1350,1000);
		Stage.getIcons().add(icono);
		Stage.setTitle("TextFinder");
		Stage.setScene(escena);
		Stage.show();
		
	}
	public static void main(String[] args) {
		launch(args);
	}
}
