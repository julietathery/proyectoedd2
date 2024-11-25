/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectoedd2;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 *
 * @author julietathery
 */
public class Functions {
    
    
    /**
     * Metodo que permite leer el json 
     * @param BaratheonJSON
     * @return 
     */
    public String leerBaratheonJson(String BaratheonJSON){
       String jsonText = " ";
        try{
            BufferedReader bf = new BufferedReader(new FileReader(BaratheonJSON));
            String line;
            while ((line = bf.readLine()) != null ){
                jsonText += line + "/n";
                
                
            }
            bf.close();
            
        } catch (Exception e){
            e.printStackTrace();
        }
        return jsonText; 
        
        
    }
    
    
    /**
     * Metodo que permite leer el json
     * @param TargeryenJSON
     * @return 
     */
    public String leerTargeryenJson(String TargeryenJSON){
       String jsonText = " ";
        try{
            BufferedReader bf = new BufferedReader(new FileReader(TargeryenJSON));
            String line;
            while ((line = bf.readLine()) != null ){
                jsonText += line + "/n";
                
                
            }
            bf.close();
            
        } catch (Exception e){
            e.printStackTrace();
        }
        return jsonText; 
        
    } 
    
    
    
    public Lista getPersonas (String content){
        
        Lista lista = new Lista();
        String[] separar = content.split("House");
        
        
        
        for (int i = 1; i <= separar.length; i++) {
            String newString = separar[i].replaceAll("/n","");
            newString = newString.replaceAll(" ", "").replaceAll(String.valueOf('"'), "").replaceAll("\\{", "").replaceAll("\\}", "").replaceAll("\\[","").replaceAll("\\]","");
            String[] personas = newString.split(",");

            
            lista.insertFinal(new NodoArbol(new Tree()));
            for (int j = 0; j < personas.length; j++) {
                 if (personas[j].contains(":")) {
                    try{
                     String[] probando = personas[j].split(":");
                     int prueba = Integer.parseInt(personas[j].split(":")[0]);
                     if (probando.length > 2){
                         personas[j] = personas[j].split(":")[1].trim();
                     } else{
                         personas[j] = personas[j].split(":")[1].trim();
                     }
                     
                    } catch (NumberFormatException e) {
                      personas[j] = personas[j].split(":")[0].trim();
                      }
                    
                      
                    }
                    
                if (!checkFamilia (lista, personas[j])){
                lista.insertFinal(new NodoArbol(new Tree()));
            }}}
        
        System.out.println(lista);
        return lista;
    }
    

    
    public boolean checkFamilia (Lista lista, String elemento){
        for (int i = 0; i < lista.getSize(); i++) {
            if (lista.getDato(i).getElement().equals(elemento)){
                return true; 
            }
        } return false;
    }

    
    
    
}
