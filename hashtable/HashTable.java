/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */




package hashtable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
*   Note that Multimap is not an exact equivalent of the home-baked solution; 
*   Hashtable synchronizes all its methods, while Multimap makes no such guarantee. 
*   This means that using a Multimap may cause you problems if you are using it
*   on multiple threads. If your map is used only on one thread,
*   it will make no difference (and you should have been using HashMap
*   instead of Hashtable anyway).
*/

/**
 *
 * @author Arturo
 */
public class HashTable {
	
	public static Map<String,List<Persona>> mapaPersonas = 
			new HashMap<String, List<Persona>>();
    
    public static void agregar(String id,Persona p) {
    	List<Persona> listaPersonas = null;
    	if(mapaPersonas.get(id) == null){
    		listaPersonas = new ArrayList<Persona>();
    		mapaPersonas.put(id, listaPersonas);
    	}else{
    		listaPersonas = mapaPersonas.get(id);
    	}
    	listaPersonas.add(p);
    }
    
    public static Persona buscar(String id, Persona p) {
        if(mapaPersonas.get(id) != null){
        	for(Persona persona: mapaPersonas.get(id)){
        		if(p.equals(persona)){
        			return persona;
        		}
        	}
        }
        return null;
    }
    
    public static boolean remover(String id, Persona p) {
    	if(mapaPersonas.get(id) != null){
        	for(Persona persona: mapaPersonas.get(id)){
        		if(p.equals(persona)){
        			mapaPersonas.get(id).remove(p);
        			return true;
        		}
        	}
        }
    	return false;
    }
    
    public static String generarHash(String nombreCompleto){
    	char[] array = nombreCompleto.toCharArray();
    	int sum = 0;
    	for(int i=0; i < array.length; i++){
    		sum += array[i];
    	}
    	sum *= 31;
    	return String.valueOf(sum);
    }
}
