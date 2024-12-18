/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectoedd2;

import javax.swing.JOptionPane;

/**
 *
 * @author julietathery
 */
public class Grafo {
    private Lista personas;
    
    /**
     * Constructor de la clase 
     * @param personas 
     */

    public Grafo() {
        this.personas = null;
    }

    
    /**
     * Getters and setters de la clase 
     * @return 
     */
    public Lista getPersonas() {
        return personas;
    }
    

    public void setPersonas(Lista personas) {
        this.personas = personas;
    }
    
    
    public boolean isEmpty(){
        return this.personas.isEmpty();
    }
    
    
    /**
     * Metodo para buscar 
     * @param name
     * @return 
     */
    public Family search(String name){
        if(!this.isEmpty()){
            Nodo aux = this.personas.getHead();
            while(aux != null){
                Family actual = (Family) aux.getElement();
                if(actual.getName().equalsIgnoreCase(name)){
                  return actual;
                        
                }
                
                aux = aux.getNext();
            }
            return null;
        }
        return null;
    }
    
    
    
    public void getadjacent(String name){
        if(this.search(name) != null){ 
           Family persona = this.search(name);
            JOptionPane.showMessageDialog(null,persona.printAdy());
        }else{
            JOptionPane.showMessageDialog(null, "Esta persona ya existe.");
        }
    }
    
    /** 
     * Metodo que agrega conexiones entre dos nombres 
     * @param name1
     * @param name2 
     */
    public void addConnection(String name1, String name2){
        if(this.search(name1) != null && this.search(name2) != null){
            Family inicio = search(name1);
            Family ultima = search(name2);
            
            inicio.getAdyacentes().insertFinal(ultima);
            ultima.getAdyacentes().insertFinal(inicio);
            
            JOptionPane.showMessageDialog(null, "Conexion agregada con exito.");
    }else{
            if(this.search(name1) == null && this.search(name2) != null){
                JOptionPane.showMessageDialog(null, "Esta persona no existe.");
            }else if(this.search(name1) != null && this.search(name2) == null){
                JOptionPane.showMessageDialog(null, "Esta persona no existe.");
            }else{
                JOptionPane.showMessageDialog(null, "Esta persona no existe.");
            }
        
    }
    }
    
    
    
   
    
}
