/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


package hashtable;
import java.util.Hashtable;
/**
 *
 * @author Arturo
 */
public class HashTable {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        Hashtable<String,String> paises = new Hashtable<String,String>();
        Agregar(paises,"ES", "España");
        Agregar(paises,"US", "Estados Unidos");	
        paises.remove("ES");
        System.out.println("El valor de la clave " + "US" + " es " + Buscar(paises,"US"));
        System.out.println("El valor de la clave " + "ES" + " es " + Buscar(paises,"ES"));
        // TODO code application logic here
    }
    
    public static void Agregar(Hashtable table,String ID, String Contenido) {
        table.put(ID, Contenido);
    }
    
    public static String Buscar(Hashtable table,String IDToFind) {
        return (String)table.get(IDToFind);
    }
    
    public static void Remover(Hashtable table,String IDToRemove) {
        table.remove(IDToRemove);
    }
}
