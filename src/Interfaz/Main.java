package Interfaz;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;


public class Main extends Application { 
	public static Pane derecha = new Pane();
	private BorderPane Estructura = new BorderPane();
	public ToolBar Herramientas = new ToolBar();
	private static TextField caja = new TextField();
	
	public  void start(Stage Stage) {
		// HACER ESTO CON ENUM Y AGREGAR COLUMNAS
		TableColumn nombre = new TableColumn("Nombre");
		nombre.setMinWidth(100);
		
		TableColumn fecha = new TableColumn("Fecha");
		
		TableColumn tama�o = new TableColumn("Tama�o");
		
		TableViewer tabla = new TableViewer();
		Botones A�adir = new Botones();
		Botones Quitar = new Botones();
		Botones Subir = new Botones();
		Botones Bajar = new Botones();
		Botones Buscar = new Botones();
	
		tabla.setTable(nombre,fecha ,tama�o );
		A�adir.setButton(A�adir, Button_type.A�adir_Archivo, Stage);
		Quitar.setButton(Quitar, Button_type.Quitar_Archivo);
		Subir.setButton(Subir, Button_type.Subir);
		Bajar.setButton(Bajar, Button_type.Bajar);
		Buscar.setButton(Buscar, Button_type.Buscar);
		

		ScrollPane izquierda = new ScrollPane(tabla.getTable());
		tabla.getTable().setMinHeight(1000);
		
		Herramientas.getItems().addAll(A�adir.getButton(),Quitar.getButton(),Subir.getButton(),Bajar.getButton(),caja,Buscar.getButton());
		Estructura.setTop(Herramientas);
		Estructura.setLeft(izquierda);
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
