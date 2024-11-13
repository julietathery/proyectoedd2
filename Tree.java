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
    
    private class Nodo {
        Family family;
        Nodo left;
        Nodo right;
        
        public Nodo(Family family) {
            this.family = family;
            this.left = null;
            this.right = null;
        }
    }
    
    
    private Nodo root;
    
    public Tree() {
        this.root = null;
    }
    
    
    /**
     * Metodos que permiten insertar 
     * @param root
     * @param family
     * @return 
     */
    
    public void insert(Family family) {
        root = insertRec(root, family);
    }
    
    
    private Nodo insertRec(Nodo root, Family family) {
        if (root == null) {
            return new Nodo(family);
        }
        
        // Compara los nombres de las familias para mantener el orden
        if (family.getName().compareTo(root.family.getName()) < 0) {
            root.left = insertRec(root.left, family);
        } else if (family.getName().compareTo(root.family.getName()) > 0) {
            root.right = insertRec(root.right, family);
        }
        
        return root;
    }
    
    
    /**
     * Metodo para buscar en el arbol
     * @param name
     * @return 
     */
    
    public Family search(String name) {
        Nodo result = searchRec(root, name);
        return result != null ? result.family : null;
    }
    
    
    private Nodo searchRec(Nodo root, String name) {
        if (root == null || root.family.getName().equals(name)) {
            return root;
        }
        
        if (name.compareTo(root.family.getName()) < 0) {
            return searchRec(root.left, name);
        }
        
        return searchRec(root.right, name);
    }
    
    /**
     * Metodo para imprimir el arbol en orden
     */
    
    public void inorderTraversal() {
        inorderRec(root);
    }
    
    private void inorderRec(Nodo root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.println("Familia: " + root.family.getName() + 
                             ", Padre: " + root.family.getFather() + 
                             ", Hijos: " + root.family.getSons());
            inorderRec(root.right);
        }
    }
}
