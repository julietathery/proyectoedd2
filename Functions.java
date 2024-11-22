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
    
    
    
//     public Lista getParadas (String content){
//        
//        Lista lista = new Lista();
//        String[] separar = content.split("Linea");
//        
//        
//        
//        for (int i = 1; i < separar.length; i++) {
//            String newString = separar[i].replaceAll("/n","");
//            newString = newString.replaceAll(" ", "").replaceAll(String.valueOf('"'), "").replaceAll("\\{", "").replaceAll("\\}", "").replaceAll("\\[","").replaceAll("\\]","");
//            String[] person = newString.split(",");
//
//            
//            lista.insertFinal(new NodoArbol(new Sucursal("OtraLinea")));
//            for (int j = 0; j < person.length; j++) {
//                 if (person[j].contains(":")) {
//                    try{
//                     String[] probando = person[j].split(":");
//                     int prueba = Integer.parseInt(person[j].split(":")[0]);
//                     if (probando.length > 2){
//                         person[j] = person[j].split(":")[1].trim();
//                     } else{
//                         person[j] = person[j].split(":")[1].trim();
//                     }
//                     
//                    } catch (NumberFormatException e) {
//                      person[j] = person[j].split(":")[0].trim();
//                      }
//                    
//                      
//                    }
//                    
//                if (!checkParadasList (lista, person[j])){
//                lista.insertFinal(new NodoArbol(new Sucursal(person[j])));
//            }}}
//        
//       
//        return lista;
//    }

    
}
