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
    
    
    
    
}
