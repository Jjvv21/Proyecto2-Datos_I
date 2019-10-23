package Interfaz;

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
	public static Pane derecha = new Pane();
	private BorderPane Estructura = new BorderPane();
	public ToolBar Herramientas = new ToolBar();
	private static TextField caja_De_Entrada = new TextField();
	private static TextField search = new TextField();
	public static Label texto = new Label("Aquí se mostrarán las coincidencias del texto que busques.");
	public static ObservableList<Caracteristicas_De_Archivos> datos = FXCollections.observableArrayList();
	FilteredList<Caracteristicas_De_Archivos> filteredData = new FilteredList<>(datos, p -> true);


	public  void start(Stage Stage) {
		
		
		 TableColumn<Caracteristicas_De_Archivos, String> Nombre = new TableColumn<>("Name");
		 
		 Nombre.setCellValueFactory(new PropertyValueFactory<Caracteristicas_De_Archivos, String>("Nombre"));
		 Nombre.setResizable(true);
		 
        TableColumn<Caracteristicas_De_Archivos, String> Peso = new TableColumn<>("Size");
        
        Peso.setCellValueFactory(new PropertyValueFactory<Caracteristicas_De_Archivos, String>("Peso"));
        Peso.setResizable(true);
        
        TableColumn<Caracteristicas_De_Archivos, String> Direccion = new TableColumn<>("Location");
        
        Direccion.setCellValueFactory(new PropertyValueFactory<Caracteristicas_De_Archivos, String>("Direccion"));
        Direccion.setResizable(true);
        
        TableColumn<Caracteristicas_De_Archivos, String> Fecha = new TableColumn<>("Date");
        
        Fecha.setCellValueFactory(new PropertyValueFactory<Caracteristicas_De_Archivos, String>("Fecha"));
        Fecha.setResizable(true);
		
		
		
        
        // ESTRUCTURA PARA LA TABLA
        TableViewer estructura = new TableViewer();

		//Configuración del Texto en el Label
		texto.setWrapText(true);

        //ESTRUCTURA DE LA TABLA
		TableViewer tabla = new TableViewer();
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


		//Configuración del Stackpane que tiene al label en donde se mostrará el texto
		StackPane centeredarch = new StackPane(texto);
		centeredarch.setStyle("-fx-background-color: #d2d7db;");

		StackPane archroot = new StackPane(centeredarch);
		archroot.setPadding(new Insets(35));

		// CREACION DE ELEMENTOS CON SUS PARAMETROS
	
		tabla.setTable(filteredData, tabla, Direccion, Nombre, Peso, Fecha);
		//
		estructura.crearCaja(search, tabla.getTable(),filteredData);
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
		
		
		

		
		//ESTRUCTURA PRINCIPAL
		Herramientas.getItems().addAll(Añadir.getButton(),Quitar.getButton(),Subir.getButton(),Bajar.getButton(),caja_De_Entrada,Buscar.getButton());
		Estructura.setTop(Herramientas);
		Estructura.setCenter(archroot);
		Estructura.setLeft(estructura.getCaja());
		Estructura.setRight(derecha);
		Scene escena = new Scene(Estructura,1350,1000);
		Stage.setTitle("TextFinder");
		Stage.setScene(escena);
		Stage.show();
		
	}
	public static void main(String[] args) {
		launch(args);
	}
}
