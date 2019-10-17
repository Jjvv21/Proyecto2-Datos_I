package Patron_Abstract_Factory;

import javafx.scene.control.Button;

public class Fabrica_concreta implements Fabrica_Abstracta{
	@Override
	public Productos_Abstractos crearObjetos() {
		return (Productos_Abstractos) new Button();
	}

}
