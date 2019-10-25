package Interfaz;

import java.io.File;
import java.io.FileInputStream;

import Eventos.Eventos_de_Botones;
import Interfaz.Botones;
import Interfaz.Button_type;
import Logica.BubbleSort;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Botones {
	private Button new_Button; 
	String imagenes = ("C:\\Users\\Julio\\Desktop\\images\\Pitos");
	BubbleSort BubbleSort = new BubbleSort();
	
	
	
	public Button getButton() {
		return new_Button; 
		
	}
	/**
	 * Metodo para insertar un Boton dentro de la ventana segun su tipo
	 * @param button
	 * @param type
	 */
	public void setButton(Botones button, Button_type type) {
		try {
			this.new_Button = new Button();
			if(type == Button_type.Quitar_Archivo ) {
				FileInputStream input = new FileInputStream(imagenes+"\\Delete.png"); 
				Image i = new Image(input);
				ImageView iw = new ImageView(i); 
				this.new_Button.setGraphic(iw);
				
			}else if(type==Button_type.Añadir_Archivo) {
				FileInputStream input = new FileInputStream(imagenes+"\\Files.png"); 
				Image i = new Image(input);
				ImageView iw = new ImageView(i); 
				this.new_Button.setGraphic(iw);
				
			}else if(type== Button_type.Bajar) {
				FileInputStream input = new FileInputStream(imagenes+"\\Down.png"); 
				Image i = new Image(input);
				ImageView iw = new ImageView(i); 
				this.new_Button.setGraphic(iw);
				
			}else if (type == Button_type.Subir) {
				FileInputStream input = new FileInputStream(imagenes+"\\Up.png"); 
				Image i = new Image(input);
				ImageView iw = new ImageView(i); 
				this.new_Button.setGraphic(iw);
				
			}else if(type == Button_type.Buscar) {
				FileInputStream input = new FileInputStream(imagenes+"\\Search.png"); 
				Image i = new Image(input);
				ImageView iw = new ImageView(i); 
				this.new_Button.setGraphic(iw);
			}
			
		}catch(Exception a) {
			System.out.println(a.getMessage());
		}
		
	}
	/**
	 * 
	 * @param button
	 * @param type
	 * @param Stage
	 * Sobre este metodo tendremos un Overload, para poder utilizar la escena
	 * que se tiene como principal
	 */
	public void setButton(Botones button, Button_type type,Stage Stage) {
		Button new_Button = new Button();
			
		if (type == Button_type.Añadir_Archivo) {
			try {
				FileInputStream input = new FileInputStream(imagenes+"\\Files.png"); 
				Image i = new Image(input);
				ImageView iw = new ImageView(i); 
				new_Button.setGraphic(iw);
			}catch(Exception a) {
				System.out.println(a.getMessage());
			}
			new_Button.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
					Eventos_de_Botones.Añadir(event, Stage ,new_Button );
				}
			});

		}
		this.new_Button= new_Button;
	}
	//BOTONES PARA ORDENAR 
	public void BotonesDeBusqueda(Botones button, Ordenar_Type Type) {
		Button Buscar = new Button();
		if (Type == Ordenar_Type.Bubble) {
			Buscar.setText("Sort Dates");
			Buscar.setOnAction(new EventHandler<ActionEvent>() {
			    public void handle(ActionEvent t) {
			    	BubbleSort.mostrarLista(Main.datostxt);
			    	}
			    });
		}else if(Type == Ordenar_Type.Quick) {
			Buscar.setText("Sort Names");
		}else if(Type == Ordenar_Type.Radix) {
			Buscar.setText("Sort Sizes");
		}
		this.new_Button=Buscar; 
	}
	
}
 