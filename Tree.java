/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectoedd2;

/**
 *
 * @author julietathery
 */
public class Tree {
    private NodoArbol root;
    
    
    
    /**
     * Constructor de la clase 
     */
    public Tree(){
        this.root = null;
    }

    
    /**
     * Getters and setters de la clase 
     * @return 
     */
    public NodoArbol getRoot() {
        return root;
    }
    

    public void setRoot(NodoArbol root) {
        this.root = root;
    }
    
    
    /**
     * Metodo que verifica si el arbol esta vacio 
     * @return 
     */
    
    public boolean isEmpty(){
        return getRoot()== null;
    }
    
    
    /**
     * Metodo que inserta un nodo en la raiz del arbol 
     * @param data 
     */
    public void create(Object data){
        NodoArbol newNode = new NodoArbol(data);
        setRoot(newNode);
    }
    
    
    /**
     * Metodo que inserta un nodo como hijo en el arbol 
     * @param data
     * @param parent 
     */
    public void insert(Object data, NodoArbol parent){
        NodoArbol newNode = new NodoArbol(data);
        if(!isEmpty()){
            parent.addSon(newNode);
        }
    }
    
    
    /**
     * Metodo para recorrer el arbol
     * @param root
     * @return 
     */
    
    public String preorder(NodoArbol root){
        String toPrint = " ";
        if(root != null){
            toPrint += root.getData()+ "\n";
            toPrint += preorder(root.getSon());
            toPrint += preorder(root.getSib());
        }
        return toPrint;
    }
   
    /**
     * Metodo para recorrer el arbol 
     * @param root
     * @return 
     */
    
    public String inorder(NodoArbol root){
        String toPrint= " ";
        if(root != null){
            NodoArbol temp = root.getSon();
            toPrint += inorder(temp);
            toPrint += root.getData()+ "\n";
            while(temp != null){
                temp = temp.getSib();
                toPrint += inorder(temp);
                
            }
        }
        return toPrint;
    }
    
    
    /**
     * Metodo para recorrer el arbol
     * @param root
     * @return 
     */
    public String postorder(NodoArbol root){
        String toPrint = " ";
        if(root != null){
            NodoArbol temp = root.getSon();
            while(temp != null){
                toPrint += postorder(temp);
                temp = temp.getSib();
                
            }
            toPrint += root.getData()+ "\n";
            
        }
        return toPrint;
    }
    
    
}
