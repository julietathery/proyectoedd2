/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectoedd2;

/**
 *
 * @author julietathery
 */
public class Family {
    private String name;
    private String lastName;
    private String father;
    private String sons;

    
    /**
     * Constructor de la clase 
     * @param name
     * @param father
     * @param sons 
     */
    public Family(String name, String lastName, String father, String sons) {
        this.name = name;
        this.lastName = lastName;
        this.father = father;
        this.sons = sons;
    }

    
    /**
     * Getters and setters de la clase 
     * @return 
     */
    public String getName() {
        return name;
    }
    
    

    public void setName(String name) {
        this.name = name;
    }
    
    

    public String getFather() {
        return father;
    }
    
    

    public void setFather(String father) {
        this.father = father;
    }
    
    

    public String getSons() {
        return sons;
    }

    
    
    public void setSons(String sons) {
        this.sons = sons;
    }
    
    

    public String getLastName() {
        return lastName;
    }
    
    

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
     
    
}
