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
    private String number;
    private String father;
    private String apodo;
    private String title;
    private String spouse;
    private String eyes;
    private String hair;
    private String sons;
    private String notes;
    private String fate;
    private Lista adyacentes;

    
    /**
     * Constructor de la clase 
     * @param name
     * @param father
     * @param sons 
     */
    
    

    public Family(String name, String lastName, String number, String father, String apodo, String title, String spouse, String eyes, String hair, String sons, String notes, String fate, Lista adyacentes) {
        this.name = name;
        this.lastName = lastName;
        this.number = number;
        this.father = father;
        this.apodo = apodo;
        this.title = title;
        this.spouse = spouse;
        this.eyes = eyes;
        this.hair = hair;
        this.sons = sons;
        this.notes = notes;
        this.fate = fate;
        this.adyacentes = adyacentes;
    }

    
    
    /**
     * Getters and setters de la clase
     * @return
     */
    public String getName(){
        return name;
    }

    public void setName(String name) {    
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getFather() {
        return father;
    }

    public void setFather(String father) {
        this.father = father;
    }

    public String getApodo() {
        return apodo;
    }

    public void setApodo(String apodo) {
        this.apodo = apodo;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSpouse() {
        return spouse;
    }

    public void setSpouse(String spouse) {
        this.spouse = spouse;
    }

    public String getEyes() {
        return eyes;
    }

    public void setEyes(String eyes) {
        this.eyes = eyes;
    }

    public String getHair() {
        return hair;
    }

    public void setHair(String hair) {
        this.hair = hair;
    }

    public String getSons() {
        return sons;
    }

    public void setSons(String sons) {
        this.sons = sons;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getFate() {
        return fate;
    }

    public void setFate(String fate) {
        this.fate = fate;
    }

    public Lista getAdyacentes() {
        return adyacentes;
    }

    public void setAdyacentes(Lista adyacentes) {
        this.adyacentes = adyacentes;
    }

    
    
    /**
     * Metodo para imprimir los nodod adyacentes 
     * @return
     */
    public String printAdy() {
        if (!this.adyacentes.isEmpty()) {
            Nodo aux = this.adyacentes.getHead();
            String adyacentesStr = "";
            while (aux.getNext() != null) {
                Family actual = (Family) aux.getElement();
                adyacentesStr += actual.getName() + " ---> ";

                aux = aux.getNext();

            }
            Family actual = (Family) aux.getElement();
            adyacentesStr += actual.getName();
            return adyacentesStr;
            
        } 
        return "No tiene adyacentes.";
    }
    
    
    
    /**
     * funcion que convierte en un string
     * @return 
     */
    
    public String toString() {
        StringBuilder cadena = new StringBuilder();
    
        cadena.append("  \nNombre=").append(name);
        cadena.append(", \nNumeral=").append(number);
        cadena.append(", \nPadre=").append(father);
        cadena.append(", \nApodo=").append(apodo);
        cadena.append(", \nTitulo=").append(title);
        cadena.append(", \nEsposa=").append(spouse);
        cadena.append(", \nColordeOjos=").append(eyes);
        cadena.append(", \nColordeCabello=").append(hair);
        cadena.append(", \nNotas=").append(notes);
        cadena.append(", \nDestino=").append(fate);
       
        return cadena.toString();
    }
}
    
    
    
    