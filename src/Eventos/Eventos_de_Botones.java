package Eventos;

import java.awt.Desktop;

import Interfaz.Caracteristicas_De_Archivos;
import Interfaz.Main;
import LinkedList.Listas;
import LinkedList.OrdenamientosDocx;
import LinkedList.OrdenamientosPdf;
import LinkedList.OrdenamientosTxt;
import TableViews.TableViewer;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import LinkedList.QuickSort;
import LinkedList.RadixSort;
import LinkedList.BubbleSort;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import Interfaz.Caracteristicas_De_Archivos;

public class Eventos_de_Botones {
	private static Desktop desktop = Desktop.getDesktop();
	private static TableViewer tabla = new TableViewer();
	private static Listas Listas = new Listas();
	private static OrdenamientosTxt LinkedLisTxt = new OrdenamientosTxt();
	private static OrdenamientosPdf LinkedListPdf = new OrdenamientosPdf();
	private static OrdenamientosDocx LinkedListDocx = new OrdenamientosDocx();
	private static String Nombre = new String();
	private static BubbleSort BubbleSort = new BubbleSort();
	private static QuickSort Quick = new QuickSort();
	private static RadixSort Radix = new RadixSort();
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
		        	
		        	if (file.getName().contentEquals(Nombre)) {
	        			Alert ArchivoDuplicado = new Alert(AlertType.INFORMATION);
	        			ArchivoDuplicado.setTitle("Archivo Duplicado");
	        			ArchivoDuplicado.setContentText(" El archivo que intenta incluir ya existe");
	        			ArchivoDuplicado.show();
	        			
		        	}else {
		        		Nombre=file.getName();
		        		try {
			        		String Tamaño = Long.toString(file.length());
			        		BasicFileAttributes attrs;
	        			    attrs = Files.readAttributes(file.toPath(), BasicFileAttributes.class);
	        			    FileTime time = attrs.creationTime();
	        			    
	        			    String pattern = "yyyy-MM-dd";
	        			    SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);	
	        			    String formatted = simpleDateFormat.format( new Date( time.toMillis() ) );
	        			    
	        			    String Size = Long.toString(file.length());
	        			    int Size2 = Integer.parseInt(Size);
	        			    
	        		
	        			    if(getFileExtension(file).contentEquals(".txt")) {     			    	
	        			    	
	        			    	Main.datostxt.add(new Caracteristicas_De_Archivos(file.getName(),Size, file.getPath(),formatted)); 	      		
	    		        		Listas.ListaTxt(file.getAbsolutePath());
	    		        		LinkedLisTxt.AgregarNodos(Listas.getListatxt());
	    		        		LinkedLisTxt.mostrarLista();
	    		          		System.out.println("\n");
	    		        		
	    		        		BubbleSort.LastModified(Listas.getListatxt());	    	
	    		        		Radix.Size(Listas.getListatxt());    		
	    		        		Quick.Names(Listas.getListatxt());
	    		          		Listas.getListatxt().clear();
	    		        		
	    		        	
	    		          		Quick.Ordenar();
	    		        		Quick.Mostrar();
	    		        		
	    		        		
	    		        		System.out.println("\n");
	    		        		
	    		        		
	    		        		BubbleSort.printdato2();
	    		        		BubbleSort.sort();
	    		     	  
	    		        		System.out.println("\n");
	    		        		
	    		        		
	    		        		Radix.printdato3();
	    		        		Radix.sort();
	    		        		
	    		        		System.out.println("\n");
	    		        		
	    		        	
	    		        		
	    		        	}else if (getFileExtension(file).contentEquals(".pdf")) {
	    		        		
	    		        		Main.datospdf.add(new Caracteristicas_De_Archivos(file.getName(),Size, file.getPath(),formatted));
	    		        		Listas.ListaPdf(file.getAbsolutePath());
	    		        		LinkedListPdf.AgregarNodos(Listas.getListaPdf());
	    		        		LinkedListPdf.mostrarLista();
	    		          		System.out.println("\n");
	    		        		

	    		        		BubbleSort.LastModified(Listas.getListaPdf());	    	
	    		        		Radix.Size(Listas.getListaPdf());    		
	    		        		Quick.Names(Listas.getListaPdf());
	    		        		Listas.getListaPdf().clear();
	    		        		
	    		        		Quick.Mostrar();
	    		        		Quick.Ordenar();
	    		        		
	    		        		System.out.println("\n");
	    		        		
	    		        		
	    		        		BubbleSort.printdato2();
	    		        		BubbleSort.sort();
	    		     	  
	    		        		System.out.println("\n");
	    		        		
	    		        		
	    		        		Radix.printdato3();
	    		        		Radix.sort();
	    		        		
	    		        		System.out.println("\n");
	    		        		
	    		        	}else if(getFileExtension(file).contentEquals(".docx")) {
	    		        		
	    		        		Main.datosdocx.add(new Caracteristicas_De_Archivos(file.getName(),Size, file.getPath(),formatted));
	    		        		Listas.ListaDocx(file.getAbsolutePath());
	    		        		LinkedListDocx.AgregarNodos(Listas.getListaDocx());
	    		        		LinkedListDocx.mostrarLista();
	    		           		System.out.println("\n");
	    		        		
	    		        		
	    		        		BubbleSort.LastModified(Listas.getListaPdf());	    	
	    		        		Radix.Size(Listas.getListaPdf());    		
	    		        		Quick.Names(Listas.getListaPdf());
	    		        		
	    		        		Listas.getListaPdf().clear();
	    		        		Quick.Mostrar();
	    		        		Quick.Ordenar();
	    		        		
	    		        		System.out.println("\n");
	    		        		
	    		        		
	    		        		BubbleSort.printdato2();
	    		        		BubbleSort.sort();
	    		     	  
	    		        		System.out.println("\n");
	    		        		
	    		        		
	    		        		Radix.printdato3();
	    		        		Radix.sort();
	    		        		
	    		        		System.out.println("\n");
	    		        		
	    		        	}else {
	    		        		Alert Alerta1 = new Alert(AlertType.INFORMATION);
	    		        		Alerta1.setTitle("Archivo Indescifrable");
	    		        		Alerta1.setContentText("Extensiones Soportadas:"+"\n"+
	    		        		"PDF"+"\n"+"DOCX"+"\n"+"TXT");
	    		        		Alerta1.show();
	    		        	}
	        			   
	        			   
	        			} catch (IOException e) {
	        			    e.printStackTrace();
	        			}
		        	}
		        	
		
		        	
		        	
		        }else {
		        	
		        }
		        
		    }
		});
		
	}
	public void FuncionFiles() {
		
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
