package LinkedList;

import java.util.ArrayList;

public class OrdenamientosPdf {
	Listas listatxt = new Listas();

	
	protected Nodo inicio,fin;// punteros para saber donde esta el inicio y el fin
	public OrdenamientosPdf() {
		inicio = null;
		fin=null;
	}
	//Metodo para agregar un Nodo al inicio de la lista 
	public void agregarAlInicio(String string) {
		//Creando al Nodo 
		inicio = new Nodo(string, inicio);
		if(fin==null) {
			fin=inicio;
		}
	}
	//Metodo para mostrar los datos 
	public void mostrarLista() {
		Nodo recorrer=inicio;
		System.out.println();
		while(recorrer!=null) {
			System.out.print("["+recorrer.dato+"]------>");
			recorrer=recorrer.siguiente;
		}
	}
	public void AgregarNodos(ArrayList lista) {
		int i = 0; 
		for (i=0;i<lista.size();i++) {
			agregarAlInicio((String) lista.get(i));

		}
	}
}
