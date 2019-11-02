package LinkedList;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

public class RadixSort {
	ArrayList Sizes = new ArrayList(); 
	protected NodoRadix head;
    private int size; 
 
    public RadixSort(){
        this.head = null;
        this.size = 0;
		
	}

	public ArrayList getSizes() {
		return Sizes; 
	}
	public void Size(ArrayList Lista ) {
		for(int i = 0; i<Lista.size();i++) {
			File file = new File((String) Lista.get(i));
			getSizes().add(file.length());
		}
		Radix(getSizes());
		
	
	}
	
    public void add(String dato3) {
    	NodoRadix node = new NodoRadix(dato3);
        if (head == null) {
            head = node;
        } else {
        	NodoRadix currentNode = head;
            while(currentNode.siguiente3 != null) {
                currentNode = currentNode.siguiente3;
            }
            currentNode.siguiente3 = node;
        }
        size++;     
    }
    public void sort() {
        if (size > 1) {
        	boolean cambio;
 
            do {
            	NodoRadix current = head;
            	NodoRadix previous = null;
            	NodoRadix next = head.siguiente3;
            	cambio = false;
 
                while ( next != null ) {
                    if ((current.dato3).compareTo(next.dato3)>1 ) {
                        
                    	cambio = true;
 
                        if ( previous != null ) {
                        	NodoRadix sig = next.siguiente3;
 
                        	previous.siguiente3 = next;
                        	next.siguiente3 = current;
                        	current.siguiente3 = sig;
                        } else {
                        	NodoRadix sig = next.siguiente3;
 
                        	head = next;
                        	next.siguiente3 = current;
                        	current.siguiente3 = sig;
                        }
 
                        previous = next;
                        next = current.siguiente3;
                    } else { 
						previous = current;
	                    current = next;
	                    next = next.siguiente3;
                    }
                } 
            } while( cambio );
        }
    }
    public int listSize() {     
        return size;
    }
    public void printdato3() {
        NodoRadix currentNode = head;
 
        while(currentNode != null) {
            String dato3 = currentNode.getData();

            System.out.print("RadixSort===>"+"["+dato3 +"]--->");
            currentNode = currentNode.siguiente3;
        }
 
        System.out.println();
    }
    public boolean isEmpty() {
        return size == 0;
    }
  
   
		
		
	public void Radix(ArrayList lista) {
		int i = 0; 
		for (i=0;i<lista.size();i++) {
			add(Long.toString((long) lista.get(i))) ;
			getSizes().clear();
		}
		
	}
}
