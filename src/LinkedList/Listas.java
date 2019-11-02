package LinkedList;

import java.util.ArrayList;

import Logica.DatosParaLinkedList;

public class Listas {
	
	     private static  ArrayList nListasTxt = new ArrayList();
	     private static ArrayList nListasDocx = new ArrayList();
	     private static ArrayList nListasPdf = new ArrayList();
	     
	     
	    public void ListaTxt(String Path) {
	    	this.nListasTxt.add(Path);
	    }
		public void ListaDocx(String Path) {
			this.nListasDocx.add(Path);
	    }
	    public void ListaPdf(String Path) {
	    	this.nListasPdf.add(Path);
	    }
	    
	    
	    public ArrayList getListatxt(){
			return nListasTxt;
	   	 
	    }
	    public ArrayList<String> getListaDocx(){
			return nListasDocx;
	    }
	    public ArrayList<String> getListaPdf(){
			return nListasPdf;
	    }
	    
}
