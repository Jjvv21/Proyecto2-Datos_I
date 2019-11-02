package LinkedList;

import java.util.ArrayList;

import Interfaz.Caracteristicas_De_Archivos;
import Logica.DatosParaLinkedList;
import javafx.collections.ObservableList;

public class Nodo {
	public String dato; 
	public Nodo siguiente;
	//Constructor para insertar al final
	public Nodo(String d) {
		this.dato = d; 
	}
	//Constructor para insertar al inicio
	public Nodo(String d, Nodo n) {
		dato=d;
		siguiente = n;
	}
}
