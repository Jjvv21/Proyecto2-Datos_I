package Logica;

import java.util.ArrayList;

import Interfaz.Caracteristicas_De_Archivos;
import Interfaz.Main;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;

public class BubbleSort {

	public void mostrarLista(ObservableList List) {
		Main.datostxt = List;	
		for(int i=0;i<=List.size()-1;i++) {
			System.out.println(List.get(i));
		}
	}
}
