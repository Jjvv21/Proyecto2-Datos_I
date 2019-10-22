package Interfaz;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class Main extends Application { 
	public static Pane derecha = new Pane();
	private BorderPane Estructura = new BorderPane();
	public ToolBar Herramientas = new ToolBar();
	private static TextField caja = new TextField();
	public static ObservableList<Caracteristicas_De_Archivos> datos = FXCollections.observableArrayList();
	private VBox CajaVertical = new VBox(new Label("Left Control"));

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
		
		
		
		// HACER ESTO CON ENUM Y AGREGAR COLUMNAS

        
		TableViewer tabla = new TableViewer();
		Botones Añadir = new Botones();
		Botones Quitar = new Botones();
		Botones Subir = new Botones();
		Botones Bajar = new Botones();
		Botones Buscar = new Botones();
		
		tabla.setTable( datos, tabla, Direccion, Nombre, Peso, Fecha);
		Añadir.setButton(Añadir, Button_type.Añadir_Archivo, Stage);
		Quitar.setButton(Quitar, Button_type.Quitar_Archivo);
		Subir.setButton(Subir, Button_type.Subir);
		Bajar.setButton(Bajar, Button_type.Bajar);
		Buscar.setButton(Buscar, Button_type.Buscar);
		
		
		
		//DIMENSIONES Y CARACTERISTICAS DEL PANE QUE CONTIENE LA TABLA
		
		ScrollPane izquierda = new ScrollPane(tabla.getTable());
		izquierda.setPrefHeight(1000);
		izquierda.setMaxSize(300, 1000);
		tabla.getTable().setPrefHeight(1000);
		tabla.getTable().setPrefWidth(1000);
		VBox Vertical = new VBox(izquierda);
		Vertical.setPadding(new Insets(15,15,15,15));


		
		
		Herramientas.getItems().addAll(Añadir.getButton(),Quitar.getButton(),Subir.getButton(),Bajar.getButton(),caja,Buscar.getButton());
		Estructura.setTop(Herramientas);
		Estructura.setLeft(Vertical);
		Estructura.setRight(derecha);
		Scene escena = new Scene(Estructura,950,1000);
		Stage.setTitle("TextFinder");
		Stage.setScene(escena);
		Stage.show();
		
	}
	public static void main(String[] args) {
		launch(args);
	}
}
