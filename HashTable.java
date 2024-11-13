/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectoedd2;

/**
 *
 * @author julietathery
 */
public class HashTable {
    
    private Lista[] array;
    private int hashSize;

    
    /**
     * Constructor de la clase 
     * @param hashSize 
     */
    
    public HashTable(int hashSize) {
        this.array = new Lista[hashSize];
        this.hashSize = hashSize;
    }

    
    
    /**
     * Getters and settes de la clase
     * @return 
     */
    
    
    public Lista[] getArray() {
        return array;
    }
    
    

    public void setArray(Lista[] array) {
        this.array = array;
    }
    
    

    public int getHashSize() {
        return hashSize;
    }
    
    

    public void setHashSize(int hashSize) {
        this.hashSize = hashSize;
    }
    
    
    
    /**
     * Metodo que permite obtener el ASCII 
     * @param palabra
     * @return 
     */
    
    public int getAsciiValue(String palabra) {
        int suma = 0;

        for (int i = 0; i < palabra.length(); i++) {
            char character = palabra.charAt(i);
            int ascii = (int) character;
            suma += ascii;
        }
        return suma;
    }
    
    
    /**
     * Metodo que permite obtener el hashcode a partir del valor ASCII del nombre y apellido de la persona
     * @param name
     * @param lastName
     * @return 
     */
    
    public int hashCode(String name, String lastName) {
        int clave;
        name = name.toLowerCase();
        lastName = lastName.toLowerCase();
        String junto = name + lastName;
        clave = getAsciiValue(junto) % getHashSize();
        return clave;
    }
    
    
    /**
     * Metodo que imprime el hashtable
     */
    
     public void printTable() {
        for (int i = 0; i < hashSize; i++) {
            if (array[i] != null) {
                System.out.println("key: " + i);
                array[i].printList();
            }

        }
    }
     
    /**
     * Metodo que permite agregar en el hashtable 
     * @param value 
     */ 
     
    public void insertInHashtable(Family value) {

        String name = value.getName();
        String lastName = value.getLastName();
        int key = hashCode(name, lastName);
        Lista subLista = new Lista();
        subLista.insertFinal(value);
        Lista valorArreglo = getArray()[key];
        if (valorArreglo != null) {
            valorArreglo.insertFinal(value);
        } else {
            getArray()[key] = subLista;
        }
    }
    
    
}
