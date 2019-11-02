package LinkedList;

import java.io.File;
import java.util.ArrayList;

public class BubbleSort {
	ArrayList Dates = new ArrayList(); 
	protected NodoBubble head;
    private int size; 
 
    public BubbleSort(){
        this.head = null;
        this.size = 0;
		
	}

	public ArrayList getDates() {
		return Dates; 
	}
	public void LastModified(ArrayList Lista) {
		for(int i = 0; i<Lista.size();i++) {
			File file = new File((String) Lista.get(i));
			getDates().add(file.lastModified());
		
		}
		Burbuja(getDates());
		
		
	
	}
	
    public void add(String dato2) {
    	NodoBubble node = new NodoBubble(dato2);
        if (head == null) {
            head = node;
        } else {
        	NodoBubble currentNode = head;
            while(currentNode.siguiente2 != null) {
                currentNode = currentNode.siguiente2;
            }
            currentNode.siguiente2 = node;
        }
        size++;     
    }
    public void sort() {
        if (size > 1) {
        	boolean cambio;
 
            do {
            	NodoBubble current = head;
            	NodoBubble previous = null;
            	NodoBubble next = head.siguiente2;
            	cambio = false;
 
                while ( next != null ) {
                    if ((current.dato2).compareTo(next.dato2)>1 ) {
                        
                        cambio = true;
 
                        if ( previous != null ) {
                        	NodoBubble sig = next.siguiente2;
 
                        	previous.siguiente2 = next;
                        	next.siguiente2 = current;
                        	current.siguiente2 = sig;
                        } else {
                        	NodoBubble sig = next.siguiente2;
 
                        	head = next;
                        	next.siguiente2 = current;
                        	current.siguiente2 = sig;
                        }
 
                        previous = next;
                        next = current.siguiente2;
                    } else { 
						previous = current;
	                    current = next;
	                    next = next.siguiente2;
                    }
                } 
            } while( cambio );
        }
    }
    public int listSize() {     
        return size;
    }
    public void printdato2() {
        NodoBubble currentNode = head;
 
    
        while(currentNode != null) {
            String dato2 = currentNode.getData();
         
            System.out.print("BubbleSort===>"+"["+dato2+"]---->");
            currentNode = currentNode.siguiente2;
        }
        System.out.println();
    }
    public boolean isEmpty() {
        return size == 0;
    }
  
   
		
		
	public void Burbuja(ArrayList lista) {
		int i = 0; 
		for (i=0;i<lista.size();i++) {
			add(Long.toString((long) lista.get(i))) ;
			getDates().clear();
		}
		
	}
	
}
