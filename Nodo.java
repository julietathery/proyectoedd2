/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectoedd2;

/**
 * Clase que define los nodos 
 * @author julietathery
 */

public class Nodo <T>{
    
    private T element;
    private Nodo next;
    private Nodo previous;
    
    
    /**
     * Constructor de la clase
     * @param element 
     */

    public Nodo(T element) {
        this.element = element;
        this.next = null;
        this.previous = null;
    }

    
    /**
     * Getters and setters de lista
     * @return 
     */
    
    public T getElement() {
        return element;
    }
    
    

    public void setElement(T element) {
        this.element = element;
    }
    
    

    public Nodo getNext() {
        return next;
    }
    
    

    public void setNext(Nodo next) {
        this.next = next;
    }
    
    

    public Nodo getPrevious() {
        return previous;
    }
    
    

    public void setPrevious(Nodo previous) {
        this.previous = previous;
    }
    
    
    void setAttribute(String uistyle, String fillcolor_red) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
    
    
    
}


