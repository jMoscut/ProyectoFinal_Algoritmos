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
import java.util.ArrayList;
import java.util.Optional;
import java.util.Scanner;

/**
 *
 * @author jackiesanchez
 */
public class TaskTable {
    
    private String Identificacion;
    private String Nombre;
    private ArrayList<ListTasks> Tareas = new ArrayList();
    private int TotalTareas;
    
    public String getIdentificacion() {
        return this.Identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.Identificacion = identificacion;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        this.Nombre = nombre;
    }

    public ArrayList<ListTasks> getTareas() {
        return Tareas;
    }

    public void addTareas(ListTasks tarea) {
        this.Tareas.add(tarea);
    }    
    
    public int countTareas(){
        return this.leerTareasTablero().size();
    }
    
    public int getTotalTareas() {
        this.TotalTareas = this.leerTareasTablero().size();
        return TotalTareas;
    }

    public void setTotalTareas(int totalTareas) {
        this.TotalTareas = totalTareas;
    }
    
    public void crearArchivo(ArrayList<ListTasks> lista) {
		FileWriter flwriter = null;
		try {
			
			flwriter = new FileWriter("/Users/jackiesanchez/Organizador/ListaTareas/" + this.Identificacion + ".txt");
                    try ( 
                            BufferedWriter bfwriter = new BufferedWriter(flwriter)) {
                        for (ListTasks tareas : lista) {
                            
                           bfwriter.write(tareas.getIdListadoTareas() + "|" + tareas.getIdTableroTareas()+ "|" + tareas.getNombreListado() + "\n");
                        }
                        
                    }
			System.out.println("Lista creado satisfactoriamente..");

		} catch (IOException e) {
		} finally {
			if (flwriter != null) {
				try {
					flwriter.close();
				} catch (IOException e) {
				}
			}
		}
    }
    
    public ArrayList leerTareasTablero() {
	
                           
		File file = new File("/Users/jackiesanchez/Organizador/ListaTareas/" + this.Identificacion + ".txt");
		ArrayList listaTareas= new ArrayList<ListTasks>();	
		Scanner scanner;
		try {
			
			scanner = new Scanner(file);
			while (scanner.hasNextLine()) {
				
				String linea = scanner.nextLine();
				Scanner delimitar = new Scanner(linea);
								
				delimitar.useDelimiter("\\s*\\|\\s*");
				ListTasks e = new ListTasks();
                                e.setIdListadoTareas(delimitar.next());
                                e.setIdTableroTareas(delimitar.next());
                                e.setNombreListado(delimitar.next());
				listaTareas.add(e);
                                this.Tareas = listaTareas;
			}
			
			scanner.close();
                        System.out.println("Listas leidas satisfactoriamente..");
		} catch (FileNotFoundException e) {
                    System.out.println(e);
                    this.Tareas = new ArrayList<ListTasks>();
		}
		return Tareas ;
	}
	
    
    public void aniadirTareasTablero(ArrayList<ListTasks> lista) {
            File directorio = new File("/Users/jackiesanchez/Organizador/ListaTareas");
                if (!directorio.exists()) {
                   if (directorio.mkdirs()) {
                       System.out.println("Directorio creado");                        
                   } else {
                       System.out.println("Error al crear directorio");
                   }
               }      
            FileWriter flwriter = null;
            try {
                    flwriter = new FileWriter("/Users/jackiesanchez/Organizador/ListaTareas/" + this.Identificacion + ".txt", true);
                try (BufferedWriter bfwriter = new BufferedWriter(flwriter)) {
                    for (ListTasks tareas : lista) {
                        
                        bfwriter.write(tareas.getIdListadoTareas() + "|" + tareas.getIdTableroTareas()+ "|" + tareas.getNombreListado() + "\n");
                    }
                }
                    System.out.println("Listas modificadas satisfactoriamente..");

            } catch (IOException e) {
            } finally {
                    if (flwriter != null) {
                            try {
                                    flwriter.close();
                            } catch (IOException e) {
                            }
                    }
            }
    }
    
    public void eliminarTareasTablero(){
        File archivo = new File("/Users/jackiesanchez/Organizador/ListaTareas/" + this.Identificacion + ".txt");
        if (archivo.delete()) {
            System.out.println("El fichero de listas ha sido borrado satisfactoriamente");
        }else{
           System.out.println("El fichero de listas no puede ser borrado");
        }
    }
    
    public void eliminarListado(String id){
        this.Tareas = this.leerTareasTablero();         
         ListTasks listado = this.BuscarListado(id);
         listado.eliminarTareasLista();
         this.Tareas.removeIf(x -> x.getIdListadoTareas().equals(id));
         ArrayList<ListTasks> newList = new ArrayList<>();
         
         for(int i=0; i<this.Tareas.size(); i++){
             ListTasks item = this.Tareas.get(i);
             newList.add(item);
         }
         this.crearArchivo(newList);
     }
        
    public void modificarListas(String id, String nombre){
         Tareas = this.leerTareasTablero();
         ListTasks listado = this.BuscarListado(id);    
         listado.setNombreListado(nombre);        
         GlobalStatus.TransferencialistadoTareas = listado;
         
         ArrayList<ListTasks> newList = new ArrayList<>();
         
         for(int i=0; i<Tareas.size(); i++){
             ListTasks item = Tareas.get(i);
             newList.add(item);
         }
         this.crearArchivo(newList);         
     }
        
        public ListTasks BuscarListado(String id) {  
        Optional<ListTasks> lista = this.Tareas.stream()
            .filter(p -> p.getIdListadoTareas().equals(id))
            .findFirst();
        System.out.println("el tablero es: " + lista.get().getNombreListado());
        return lista.isPresent() ? lista.get() : null;
    }
}
