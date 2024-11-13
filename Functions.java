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

    
}
