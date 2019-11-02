package Logica;

import java.util.ArrayList;

public class DatosParaLinkedList {
	 private final String Nombre;
     private final String Peso;
     private final String Direccion;
     private final String Fecha;
    
     public DatosParaLinkedList(String Nombre, String Peso, String Direccion,String Fecha) {
         this.Nombre = new String(Nombre);
         this.Peso = new String(Peso);
         this.Direccion = new String(Direccion);
         this.Fecha = new String(Fecha);
     }

     public String getNombre() {
         return Nombre;
     }

     public String getPeso() {
         return Peso;
     }

     
     public String getDireccion() {
         return Direccion;
     }
     public String getFecha() {
    	 return Fecha;
     }
     public String ToString() {
    	 return Nombre+","+Peso+","+Direccion+","+Fecha;
     }
}



