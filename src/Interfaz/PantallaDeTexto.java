package Interfaz;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;

public class PantallaDeTexto {
	private Label label = new Label();
	
	public void CrearEstructuraDeTexto(Label label) {
		label.setWrapText(true);
		label.setStyle("-fx-background-color: white;");
		this.label=label;
	}
	public Label getLabel() {
		return label;
	}
	void setTextPane(BorderPane pane) {
		pane.setMaxSize(800, 800);
		BorderPane pane2 = new BorderPane();
		pane2.setMaxWidth(750);
		pane2.setCenter(getLabel());
		StackPane Spane = new StackPane(pane2);
		Spane.setMinSize(800, 800);
		Spane.setStyle("-fx-background-color: white;");
		ScrollPane SCPane = new ScrollPane(Spane);
		SCPane.setMaxSize(800, 800);
		pane.setCenter(SCPane);
	 
	
	}
	
}
