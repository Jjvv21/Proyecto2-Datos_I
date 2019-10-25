 package Interfaz;

import javafx.beans.property.SimpleStringProperty;

public class Caracteristicas_De_Archivos {
	 private final SimpleStringProperty Nombre;
     private final SimpleStringProperty Peso;
     private final SimpleStringProperty Direccion;
     private final SimpleStringProperty Fecha;
     
     public Caracteristicas_De_Archivos(String Nombre, String Peso, String Direccion,String Fecha) {
         this.Nombre = new SimpleStringProperty(Nombre);
         this.Peso = new SimpleStringProperty(Peso);
         this.Direccion = new SimpleStringProperty(Direccion);
         this.Fecha = new SimpleStringProperty(Fecha);
     }

     public String getNombre() {
         return Nombre.get();
     }

     public String getPeso() {
         return Peso.get();
     }

     public String getDireccion() {
         return Direccion.get();
     }
     public String getFecha() {
    	 return Fecha.get();
     }
     public String ToString() {
    	 return Nombre+","+Peso+","+Direccion+","+Fecha;
     }
 }

