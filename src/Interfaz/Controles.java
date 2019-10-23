package Interfaz;

import java.io.FileInputStream;

import javafx.geometry.Orientation;
import javafx.scene.control.Button;
import javafx.scene.control.ToolBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class Controles {
	private ToolBar Controles = new ToolBar();
	String imagenes= ("C:\\Users\\Julio\\Desktop\\images\\Pitos");
	
	public void CrearToolBar(Controles controles) {
		try {
		ToolBar Controles = new ToolBar();
			FileInputStream input = new FileInputStream(imagenes+"\\Skip.png"); 
			Image i = new Image(input);
			ImageView skip = new ImageView(i); 
			Button Skip=new Button("",skip);
			FileInputStream input2 = new FileInputStream(imagenes+"\\Next.png"); 
			Image i2 = new Image(input2);
			ImageView Next2 = new ImageView(i2); 
			Button Next= new Button("",Next2);
			Controles.getItems().addAll(Skip,Next);
			Controles.setStyle("-fx-background-color: #6C6C6C;");
			Controles.setOrientation(Orientation.VERTICAL);
			this.Controles= Controles; 
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
				
	}
	public ToolBar getControles() {
		return Controles;
	}

}
