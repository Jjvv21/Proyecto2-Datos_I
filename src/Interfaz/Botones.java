package Interfaz;

import Eventos.Eventos_de_Botones;
import Interfaz.Botones;
import Interfaz.Button_type;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Botones {
	private Button new_Button; 
	
	
	public Button getButton() {
		return new_Button; 
	}
	/**
	 * Metodo para insertar un Boton dentro de la ventana segun su tipo
	 * @param button
	 * @param type
	 */
	public void setButton(Botones button, Button_type type) {
		this.new_Button = new Button();
		if(type == Button_type.Quitar_Archivo ) {
			this.new_Button.setText("Quitar_Archivo");
		}else if(type==Button_type.Añadir_Archivo) {
			this.new_Button.setText("Añadir archivo");
		}else if(type== Button_type.Bajar) {
			this.new_Button.setText("Bajar");
		}else if (type == Button_type.Subir) {
			this.new_Button.setText("subir");
		}else if(type == Button_type.Buscar) {
			this.new_Button.setText("Buscar Palabra");
		}
	}
	public void setButton(Botones button, Button_type type,Stage Stage) {
		Button new_Button = new Button();
			
		if (type == Button_type.Añadir_Archivo) {
			new_Button.setText("Añadir_Archivo");
			new_Button.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
					Eventos_de_Botones.Añadir(event, Stage ,new_Button );
				}
			});

		}
		this.new_Button= new_Button;
	}
	
}
 