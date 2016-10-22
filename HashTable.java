/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */




package hashtable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;
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

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        
        //Creacion de la Tabla Hash
        Map<String, List<String>> mapOfList = new HashMap<String, List<String>>();
        
        //Aggregar entradas a las tablas
        Agregar(mapOfList,"key1","Arturo", "Lopez", "Nacciones Unidas", "3317074142","40008678");
        Agregar(mapOfList,"key2","Juan", "Robles", "Avenida Patria", "3317079215","31350150");
        
        //Retorno de Objectos en base a las busquedas de ID
        Object Propiedad = Buscar(mapOfList,"key1");
        Object Propuedad2 = Buscar(mapOfList,"key2");
        
        //Impresion de resultados 
        System.out.println(Propiedad);
        System.out.println(Propuedad2);
        
        //Remover un objeto de la tabla en base a su ID
        Remover(mapOfList,"key2");
        Propuedad2 = Buscar(mapOfList,"key2");
        
        //Verificar que no se encontro ID
        System.out.println(Propuedad2);
        
        //Para acceder a elementos por separado se debe de usar un indexCode
        System.out.println(mapOfList.get("key1").get(0));

        // TODO code application logic here
    }
    
    public static void Agregar(Map Mapa,String ID,String Nombre, String Apellido, String Direccion, String Telefono1,String Telefono2) {
        Mapa.put(ID, Arrays.asList(Nombre,Apellido,Direccion,Telefono1,Telefono2));
    }
    
    public static Object Buscar(Map Mapa,String IDToFind) {
        return Mapa.get(IDToFind);
    }
    
    public static void Remover(Map Mapa,String IDToRemove) {
        Mapa.remove(IDToRemove);
    }
}
