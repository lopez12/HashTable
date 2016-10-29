/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



package hashtable;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

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
	
	public static Map<String,TreeMap<String,Persona>> mapaPersonas = 
			new HashMap<String, TreeMap<String,Persona>>();
    
	public static void agregar(String id,Persona p) {
    	TreeMap<String,Persona> listaPersonas = null;
    	String key;
    	if(mapaPersonas.get(id) == null){
    		listaPersonas = new TreeMap<String,Persona>();
    		mapaPersonas.put(id, listaPersonas);
    	}else{
    		listaPersonas = mapaPersonas.get(id);
    	}
    	key = generarHash(p.getNombre()+p.getApellido());
    	listaPersonas.put(key, p);
    }
    
    public static Persona buscar(String id, Persona p) {
    	Map<String, TreeMap<String, Persona>> treeMap = new TreeMap<String, TreeMap<String, Persona>>();
        if(mapaPersonas.get(id) != null){
        	for(Entry<String, Persona> entry : mapaPersonas.get(id).entrySet())
            {
		        	if(p.equals(entry.getValue())){
		        		return (Persona) entry.getValue();
		        	}
        	}
        }
        return null;
    }
    
    public static boolean remover(String id, Persona p) {
        if(mapaPersonas.get(id) != null){
        	for(Entry<String, Persona> entry : mapaPersonas.get(id).entrySet())
            {
		        	if(p.equals(entry.getValue())){
		        		mapaPersonas.get(id).remove(generarHash(p.getNombre()+p.getApellido()));
		        		return true;
		        	}
        	}
        }
        return false;
    }
    
    public static boolean modificar(String id, Persona anterior, Persona nueva){
    	Persona encontrada = buscar(id, anterior);
    	if(encontrada != null){
    		encontrada.setDireccion(nueva.getDireccion());
    		encontrada.setTelefono1(nueva.getTelefono1());
    		encontrada.setTelefono2(nueva.getTelefono2());
    		return true;
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
