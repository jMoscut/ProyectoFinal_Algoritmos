/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MainOrganizer;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import static java.time.Clock.system;
import java.util.ArrayList;
import java.util.Optional;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author jackiesanchez
 */
public class GetTasksOrganizer {
     public static ArrayList<TaskTable> listaTableros = new ArrayList<>();
     
     public static void agregarTableros(TaskTable oTablero){
        ArrayList<TaskTable> newTablero = new ArrayList<>();
        newTablero.add(oTablero);
        OperationalFile.aniadirArchivo(newTablero);                
     }
     
     public static ArrayList traerTableros(){
         listaTableros = OperationalFile.leerArchivo();
         return listaTableros;
     }
     
     public static void eliminarTableros(String id){
         listaTableros = OperationalFile.leerArchivo();         
         TaskTable tablero = GetTasksOrganizer.BuscarTablero(id);
         ArrayList<ListTasks> listadosTareas = tablero.leerTareasTablero();
         for(ListTasks item : listadosTareas){
             item.eliminarTareasLista();
         }
         tablero.eliminarTareasTablero();
         listaTableros.removeIf(x -> x.getIdentificacion().equals(id));
         ArrayList<TaskTable> newList = new ArrayList<>();
         
         for(int i=0; i<listaTableros.size(); i++){
             TaskTable item = listaTableros.get(i);
             newList.add(item);
         }
         OperationalFile.crearArchivo(newList);
     }
     
     public static void modificarTableros(String id, String nombre){
         listaTableros = OperationalFile.leerArchivo();
         TaskTable tablero = GetTasksOrganizer.BuscarTablero(id);
         tablero.setNombre(nombre);
         GlobalStatus.TransferenciaTablero = tablero;
         
         ArrayList<TaskTable> newList = new ArrayList<>();
         
         for(int i=0; i<listaTableros.size(); i++){
             TaskTable item = listaTableros.get(i);
             newList.add(item);
         }
         OperationalFile.crearArchivo(newList);         
     }
     
      public static int cantidadTableros(){
         listaTableros = OperationalFile.leerArchivo();
         return listaTableros.size();
     }
      
    public static TaskTable BuscarTablero(String id) {  
        Optional<TaskTable> tablero = listaTableros.stream()
            .filter(p -> p.getIdentificacion().equals(id))
            .findFirst();
        System.out.println("el tablero es: " + tablero.get().getNombre());
        return tablero.isPresent() ? tablero.get() : null;
    }
}

    