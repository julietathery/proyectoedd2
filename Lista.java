/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectoedd2;

import javax.swing.JOptionPane;

/**
 * Clase que define una lista doblemente enlazada
 * @author julietathery
 */

public class Lista <T> {
    
    private Nodo head;
    private Nodo tail;
    private int size;

    
    
    
    /**
     * Constructor de la clase
     */
    
    public Lista() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }
    
    
    
    /**
     * Getters and setters de la lista 
     * @return 
     */

    public Nodo getHead() {
        return head;
    }
    
    

    public void setHead(Nodo head) {
        this.head = head;
    }
    
    

    public Nodo getTail() {
        return tail;
    }
    
    

    public void setTail(Nodo tail) {
        this.tail = tail;
    }
    
    

    public int getSize() {
        return size;
    }
    
    

    public void setSize(int size) {
        this.size = size;
    }
    
    
    /**
     * Metodo que verifica si la lista esta vacia 
     * @return 
     */
    
    public boolean isEmpty(){
       return head == null;
    } 
    
    
   /**
    * Metodo que permite insertar un elemento al comienzo de la lista
    * @param element
    * @return 
    */
    
    public Nodo insertBegin(T element) {
        Nodo node = new Nodo(element);
        if (isEmpty()) {
            setHead(node);
            setTail(node);
        } else {
            node.setNext(getHead());
            getHead().setPrevious(node);
            setHead(node);
            Nodo pointer = getHead();
            while (pointer.getNext() != null) {
                pointer = pointer.getNext();
            }
            setTail(pointer);
        }
        size++;
        return node;
    }
    
    
    /**
     * Metodo que permite agregar un elemento al final de la lista 
     * @param element
     * @return 
     */
    
     public Nodo insertFinal(T element){
        Nodo node = new Nodo(element);
        if (isEmpty()) {
            setHead(node);
            setTail(node);
        } else {
            Nodo pointer = getHead();
            while (pointer.getNext() != null) {
                pointer = pointer.getNext();
            }
            pointer.setNext(node);
            node.setPrevious(pointer);
            setTail(node);
        }
        size++;
        return node;
    }
     
     
    /**
     * Metodo que permite agregar un elemento en un indice de la lista 
     * @param index
     * @param element
     * @return 
     */
     
      public Nodo insertInIndex(int index, T element) {
        Nodo node = new Nodo(element);
        if (isEmpty()) {
            setHead(node);
        } else {
            if (index > getSize()) {
                System.out.println("The index is bigger than the size");
                return insertFinal(element);
            } else {
                if (index > getSize() / 2) {
                    Nodo pointer = getTail();
                    int cont = 0;
                    while (cont < (getSize() - index) && pointer.getPrevious()!= null) {
                        pointer = pointer.getPrevious();
                        cont++;
                    }
  
                    node.setNext(pointer.getNext());
                    node.setPrevious(pointer);
                    pointer.getNext().setPrevious(node);
                    pointer.setNext(node);
                } else {
                    Nodo pointer = getHead();
                    int cont = 0;
                    while (cont < (index-1) && pointer.getNext()!= null) {
                        pointer = pointer.getNext();
                        cont++;
                    }
                    node.setNext(pointer.getNext());
                    node.setPrevious(pointer);
                    pointer.getNext().setPrevious(pointer);
                    pointer.setNext(node);
                }
            }
        }
        size++;
        return node;
    }
      
    /**
     * Metodo que permite eliminar el primer elemento de la lista
     */  
      
    public void deleteFirst() {

        if (!isEmpty()) {
            Nodo<T> pointer = getHead();
            setHead(pointer.getNext());
            pointer.setNext(null);
            size--;

        } else {
            JOptionPane.showMessageDialog(null, "Error. Cannot delete node because the list is empty.");

        }
    }
    
    
    
    /**
     * Metodo que elimina el ultimo elemento de la lista 
     * @return 
     */
    
    public Nodo deleteFinal(){
        if (!isEmpty()){
            Nodo pointer = getHead();
            if (getSize() == 1) {
                setHead(null);
                size--;
            } else {
                while (pointer.getNext() != null && pointer.getNext().getNext() != null){
                    pointer = pointer.getNext();
                }
                pointer.getNext().setPrevious(null);
                Nodo nodeReturn = pointer.getNext();
                pointer.setNext(null);
                setTail(pointer);
                size--;
                return nodeReturn;
            }
        }
        return null;
    }
    
    
    /**
     * Metodo que elimina un elemento de la lista en un indice 
     * @param index
     * @return 
     */
    
    public Nodo<T> deleteInIndex(int index) {
        if (!isEmpty()) {
            Nodo<T> pointer = getHead();
            if (index > getSize()) {
                System.out.println("The index is bigger than the size");
                return deleteFinal();
                
            } else if (index == 0){
                deleteFirst();
                
            } else if (index +1 == getSize()){
                deleteFinal();
                
            } else {
                if (index > getSize() / 2) {
                    pointer = getTail();
                    int cont = 0;
                    while (cont <= (getSize() - index - 1) && pointer.getPrevious() != getTail()) {
                        pointer = pointer.getPrevious();
                        cont++;
                    }
                    Nodo<T> temp = pointer.getNext();
                    pointer.setNext(temp.getNext());
                    temp.getNext().setPrevious(pointer);
                    temp.setNext(null);
                    temp.setPrevious(null);
                    size--;
                    return temp;

                } else {
                    pointer = getHead();
                    int cont = 0;
                    while (cont < (index - 1) && pointer.getNext() != getHead()) {
                        pointer = pointer.getNext();
                        cont++;
                    }
                    Nodo<T> temp = pointer.getNext();
                    pointer.setNext(temp.getNext());
                    temp.getNext().setPrevious(pointer);
                    temp.setNext(null);
                    temp.setPrevious(null);
                    size--;
                    return temp;
                }
            }
        }
        return null;
    }
    
    
    /**
     * Metodo que permite obtener la informacion de un nodo en una posicion especifica
     * @param index
     * @return 
     */
    
    public Nodo<T> getDato(int index) {
        if (isEmpty()) {
            return null;

        } else {
            Nodo<T> pointer = getHead();
            int counter = 0;
            while (counter < index && pointer.getNext() != null) {
                pointer = pointer.getNext();
                counter++;
            }
            return pointer;
        }
    }
    
    
    /**
     * Metodo que imprime la lista 
     */
    
    public void printList(){
        for (int i = 0; i < getSize(); i++) {
            Nodo objeto = getDato(i);
            Family currentFamily = (Family) objeto.getElement();
            System.out.println(i + ": "+ currentFamily.getName());
        }
    }
    
    
  private static Family findParent(Family member, Lista familyList) {
    if (member.getFather() == null) {
        return null; // If the member has no father, return null
    }

    String fatherName = member.getFather();
    for (int i = 0; i < familyList.getSize(); i++) {
        Family current = (Family) familyList.getDato(i).getElement();
        if (current.getName().equals(fatherName)) {
            return current;
        }
    }
    return null;
}
    
}
