package Logica;

import java.util.ArrayList;

import Interfaz.Caracteristicas_De_Archivos;
import javafx.collections.ObservableList;

public class RadixSort {
ArrayList<String> lista2 = new ArrayList<String>();
	
	public void mostrarLista(ObservableList<Caracteristicas_De_Archivos> List) {
		ArrayList<String> lista2 = new ArrayList<String>();
		 for(Caracteristicas_De_Archivos Dates: List) {
			 lista2.add(Dates.getPeso());
		 }
		 for (int i=0; i<=lista2.size()-1;i++) {
			 System.out.println(lista2.get(i));
		 }
		 this.lista2= lista2;
		
		
	} 
}

