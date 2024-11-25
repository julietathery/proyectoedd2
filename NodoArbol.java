/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectoedd2;

/**
 *
 * @author julietathery
 */
public class NodoArbol {
    public NodoArbol son;
    public NodoArbol sib;
    public Object data;
    private Lista descendientes;

    
    /**
     * Constructor de la clase 
     * @param son
     * @param sib
     * @param data 
     */
    public NodoArbol(Object data) {
        this.son = null;
        this.sib = null;
        this.data = data;
    }

    
    /**
     * Getters and setters de la clase 
     * @return 
     */
    
    public NodoArbol getSon() {
        return son;
    }
    

    public void setSon(NodoArbol son) {
        this.son = son;
    }
    

    public NodoArbol getSib() {
        return sib;
    }
    

    public void setSib(NodoArbol sib) {
        this.sib = sib;
    }
    

    public Object getData() {
        return data;
    }
    

    public void setData(Object data) {
        this.data = data;
    }
    
    
    /**
     * Metodo que verifica si es una hoja 
     * @return 
     */
    
    public boolean isEmpty(){
        return this.son.isEmpty();
    }
    
    /**
     * Metodo para agregar un hijo en el arbol 
     * @param newSon 
     */
    
    public void addSon(NodoArbol newSon){
        if(getSon() != null){
            NodoArbol temp = getSon();
            NodoArbol sib = temp;
            while(temp != null){
                sib= temp;
                temp = temp.getSib();
            }
            sib.setSib(newSon);
            
        }else{
            setSon(newSon);
        }
    }
    
    
    public boolean buscar(NodoArbol descendientes) {
        if (!this.isEmpty()) {
            Family nueva = (Family) son.getData();
            for (int i = 0; i < this.descendientes.getSize(); i++) {
                Nodo hijoActual = (Nodo) this.descendientes.getDato(i);
                Family personaActual = (Family) hijoActual.getElement();
                if (personaActual.getName().equalsIgnoreCase(nueva.getName())) {
                    return true;
                }
            }

            return false;
        }
        
        return false;
    }

    
     /**
     * metodo que busca un nodo
     * @param root
     * @param member
     * @return 
     */
    public NodoArbol findNode(Family member) {
    if (this == null) {
        return null;
    }
    if (this.data.equals(member)) {
        return this;
    }
    NodoArbol found = null;
    if (this.son != null) {
        found = this.son.findNode(member); // Search in sons
    }
    if (found != null) {
        return found;
    }
    if (this.sib != null) {
        return this.sib.findNode(member); // Search in siblings
    }
    return null;
}
    
    
    
    
}
