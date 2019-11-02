package LinkedList;

import java.io.File;
import java.util.ArrayList;

public class QuickSort {
	protected NodoQuickSort head ; 
	public static NodoQuickSort n; 
	ArrayList Names = new ArrayList(); 
	
	public QuickSort() {
	     this.head = null;
	}
	  
	public void addNode(String dato3) 
	{ 
	    if(head == null) 
	    { 
	        head = new NodoQuickSort(dato3); 
	        return; 
	    } 
	  
	    NodoQuickSort curr = head; 
	    while(curr.siguiente3 != null) 
	        curr = curr.siguiente3; 
	  
	    NodoQuickSort newNode = new NodoQuickSort(dato3); 
	    curr.siguiente3 = newNode; 
	} 
	  
	public void printList(NodoQuickSort n) 
	{ 
	    while(n!= null) 
	    { 
	        System.out.print("QuickSort=====>"+"["+n.dato3+"]"); 
	        n = n.siguiente3; 
	    } 
	    System.out.println();
	} 
	
	NodoQuickSort partitionLast(NodoQuickSort start, NodoQuickSort end) 
	{ 
		
	    if(start == end ||  
	       start == null || end == null) 
	        return start; 
	  
	    NodoQuickSort pivot_prev = start; 
	    NodoQuickSort curr = start;  
	    String pivot = end.dato3;  
	      

	    while(start != end ) 
	    { 
	        if((start.dato3).compareTo(pivot)<0) 
	        {  

	            pivot_prev = curr;  
	            String temp = curr.dato3;  
	            curr.dato3 = start.dato3;  
	            start.dato3 = temp;  
	            curr = curr.siguiente3;  
	        } 
	        start = start.siguiente3;  
	    } 
	      

	    String temp = curr.dato3;  
	    curr.dato3 = pivot;  
	    end.dato3 = temp;  
	  

	    return pivot_prev; 
	} 
	  
	public void sort(NodoQuickSort start, NodoQuickSort end) 
	{ 
	    if(start == end ) 
	        return; 

	    NodoQuickSort pivot_prev = partitionLast(start, end); 
	    sort(start, pivot_prev); 
	
	    if( pivot_prev != null &&  
	        pivot_prev == start ) 
	        sort(pivot_prev.siguiente3, end); 

	    else if(pivot_prev != null &&  
	            pivot_prev.siguiente3 != null) 
	        sort(pivot_prev.siguiente3.siguiente3, end); 
	} 
	public ArrayList getNames() {
		return Names; 
	}
	public void Names(ArrayList Lista ) {
		for(int i = 0; i<Lista.size();i++) {
			File file = new File((String) Lista.get(i));
			getNames().add(file.getName());
		}
		Quick(getNames());
		
	
	}		
	public void Quick(ArrayList lista) {
		int i = 0; 
		for (i=0;i<lista.size();i++) {
			addNode((String) lista.get(i)) ;
		}
		getNames().clear();
	}
	public void Mostrar() {
		NodoQuickSort n = head;
			printList(head);

		
		
	}
	public void Ordenar() {
		NodoQuickSort n = head;
		while(n.siguiente3!=null) {
			n=n.siguiente3;
			sort(head,n);

		}
	}
	
	
	
}
