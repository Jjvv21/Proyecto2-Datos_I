package Eventos;

import java.awt.Desktop;

import Interfaz.Caracteristicas_De_Archivos;
import Interfaz.Main;
import Interfaz.TableViewer;
import java.io.File;
import java.io.IOException;

import Interfaz.TableViewer;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import Interfaz.Caracteristicas_De_Archivos;

public class Eventos_de_Botones {
	private static Desktop desktop = Desktop.getDesktop();
	private static TableViewer tabla = new TableViewer();
	/**
	 * 
	 * @param a
	 * @param Stage
	 * @param Abrir
	 */
	public static void  Añadir(ActionEvent a , Stage Stage, Button Abrir) {
		Abrir.setOnAction(new EventHandler<ActionEvent>() {
		    @Override
		    public void handle(final ActionEvent a) {
		    	FileChooser fileChooser = new FileChooser();
		        File file = fileChooser.showOpenDialog(Stage);
		        if (file != null) {	       
		        	if(getFileExtension(file).contentEquals(".txt") || getFileExtension(file).contentEquals(".pdf")||getFileExtension(file).contentEquals(".docx") ) {
		        		 tabla.Direccion(file.getPath());
		        		 tabla.Peso(file.length());
		        		 tabla.Nombre(file.getName());
		        		 String Tamaño = Long.toString(file.length());
		        		 Main.datos.add(new Caracteristicas_De_Archivos(file.getName(),Tamaño, file.getPath(), "FECHA"));
		        	}else {
		        		
		        		Alert Alerta1 = new Alert(AlertType.INFORMATION);
		        		Alerta1.setTitle("Archivo Indescifrable");
		        		Alerta1.setContentText("Extensiones Soportadas:"+"\n"+
		        		"PDF"+"\n"+"DOCX"+"\n"+"TXT");
		        		Alerta1.show();
		        	}
		       
		        	
		    
		        }else {
		        	System.out.println("No hay seleccion alguna");
		        }
		    }
		});
	}
	/**
	 * 
	 * @param file
	 */
	private static void openFile(File file) {
        try {
            desktop.open(file);
        } catch (IOException ex) {
        	System.out.println("Error 01");
            
        }
    
	
	}
	/**
	 * 
	 * 
	 * @param file
	 * @return
	 * Obtener la extension del archivo que se selecciona.
	 * 
	 */
	public static String getFileExtension(File file) {
	    String name = file.getName();
	    int lastIndexOf = name.lastIndexOf(".");
	    if (lastIndexOf == -1) {
	        return ""; // empty extension
	    }
	    return name.substring(lastIndexOf);
        
		
	}
}
