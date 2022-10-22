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
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Optional;
import java.util.Scanner;

/**
 *
 * @author jackiesanchez
 */
public class ListTasks {

    private String IdListadoTareas;
    private String IdTableroTareas;
    private String NombreListado;
    private ArrayList<Task> Tareas;
    private int TotalTareas;

    /**
     * @return the IdListadoTareas
     */
    public String getIdListadoTareas() {
        return IdListadoTareas;
    }

    /**
     * @param IdListadoTareas the IdListadoTareas to set
     */
    public void setIdListadoTareas(String IdListadoTareas) {
        this.IdListadoTareas = IdListadoTareas;
    }

    /**
     * @return the IdTableroTareas
     */
    public String getIdTableroTareas() {
        return IdTableroTareas;
    }

    /**
     * @param IdTableroTareas the IdTableroTareas to set
     */
    public void setIdTableroTareas(String IdTableroTareas) {
        this.IdTableroTareas = IdTableroTareas;
    }

    /**
     * @return the NombreListado
     */
    public String getNombreListado() {
        return NombreListado;
    }

    /**
     * @param NombreListado the NombreListado to set
     */
    public void setNombreListado(String NombreListado) {
        this.NombreListado = NombreListado;
    }

    /**
     * @return the Tareas
     */
    public ArrayList<Task> getTareas() {
        return Tareas;
    }

    /**
     * @param Tareas the Tareas to set
     */
    public void setTareas(ArrayList<Task> Tareas) {
        this.Tareas = Tareas;
    }
    
     /**
     * @return the TotalTareas
     */
    public int getTotalTareas() {
        this.TotalTareas = this.leerTareasLista().size();
        return TotalTareas;
    }

    /**
     * @param TotalTareas the TotalTareas to set
     */
    public void setTotalTareas(int TotalTareas) {
        this.TotalTareas = TotalTareas;
    }
    
    public void crearArchivo(ArrayList<Task> lista) {
		FileWriter flwriter = null;
		try {
			
			flwriter = new FileWriter("/Users/jackiesanchez/Organizador/Tareas/" + this.IdListadoTareas + ".txt");
                    try ( 
                            BufferedWriter bfwriter = new BufferedWriter(flwriter)) {
                        for (Task tareas : lista) {
                          
                           bfwriter.write(tareas.getId() + "|" + tareas.getIdLista() + "|" + tareas.getNombre() + "|" + tareas.getDescripcion() + "|" + tareas.getFechaInicio() + "|" + tareas.getFechaFinal() + "|" + tareas.getVigencia() + "\n");
                        }
                    
                    }
			System.out.println("Tareas creadas satisfactoriamente..");

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

    public ArrayList leerTareasLista() {
       

        File file = new File("/Users/jackiesanchez/Organizador/Tareas/" + this.IdListadoTareas + ".txt");
        ArrayList listaTareas = new ArrayList<Task>();
        Scanner scanner;
        try {
           
            scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
              
                String linea = scanner.nextLine();
                Scanner delimitar = new Scanner(linea);
              				
                delimitar.useDelimiter("\\s*\\|\\s*");
                Task e = new Task();
                e.setId(delimitar.next());
                e.setIdLista(delimitar.next());
                e.setNombre(delimitar.next());
                e.setDescripcion(delimitar.next());
                e.setFechaInicio(delimitar.next());
                e.setFechaFinal(delimitar.next());
                e.setVigenciaToString(delimitar.next());
                listaTareas.add(e);
                this.Tareas = listaTareas;
            }
            
            scanner.close();
            System.out.println("Tareas leidas satisfactoriamente..");
        } catch (FileNotFoundException e) {
            System.out.println(e);
            this.Tareas = new ArrayList<Task>();
        }
        return Tareas;
    }

    public void aniadirTareasLista(ArrayList<Task> lista) {
        File directorio = new File("/Users/jackiesanchez/Organizador/Tareas");
        if (!directorio.exists()) {
            if (directorio.mkdirs()) {
                System.out.println("Directorio creado");
            } else {
                System.out.println("Error al crear directorio");
            }
        }
        FileWriter flwriter = null;
        try { 
            flwriter = new FileWriter("/Users/jackiesanchez/Organizador/Tareas/" + this.IdListadoTareas + ".txt", true);
            try ( BufferedWriter bfwriter = new BufferedWriter(flwriter)) {
                for (Task tareas : lista) {
                    
                    bfwriter.write(tareas.getId() + "|" + tareas.getIdLista() + "|" + tareas.getNombre() + "|" + tareas.getDescripcion() + "|" + tareas.getFechaInicio() + "|" + tareas.getFechaFinal() + "|" + tareas.getVigencia() + "\n");
                }
            }
            System.out.println("Tareas modificadas satisfactoriamente..");
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

    public void eliminarTareasLista() {
        Tareas = this.leerTareasLista();
        for(Task tareas: Tareas){
            tareas.eliminarTodasListaActividades();
        }
        File archivo = new File("/Users/jackiesanchez/Organizador/Tareas/" + this.IdListadoTareas + ".txt");
        System.out.println("eliminacion de tareas de la lista " + this.NombreListado);
        if (archivo.delete()) {
            System.out.println("El fichero de tareas ha sido borrado satisfactoriamente");
        } else {
            System.out.println("El fichero de tareas no puede ser borrado");
        }
    }

    public void modificarTareasLista(ArrayList<Task> lista) {
        FileWriter flwriter = null;
        try {
       
            flwriter = new FileWriter("/Users/jackiesanchez/Organizador/Tareas/" + this.IdListadoTareas + ".txt");
            try ( 
                     BufferedWriter bfwriter = new BufferedWriter(flwriter)) {
                for (Task tareas : lista) {
                
                    bfwriter.write(tareas.getId() + "|" + tareas.getIdLista() + "|" + tareas.getNombre() + "|" + tareas.getDescripcion() + "|" + tareas.getFechaInicio() + "|" + tareas.getFechaFinal() + "|" + tareas.getVigencia() + "\n");
                }
                
            }
            System.out.println("Tablero modificado satisfactoriamente..");

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
    
     public void modificarListas(String id, String nombre, String descripcion, String fechainicio, String fechafinal,String vigencia) throws ParseException{
         Task tarea = this.BuscarTarea(id);    
         tarea.setNombre(nombre);
         tarea.setFechaInicio(fechainicio);
         tarea.setFechaFinal(fechafinal);
         tarea.setNombre(nombre);
         tarea.setDescripcion(descripcion);
         if (vigencia.equals("sin datos")) {
             tarea.setVigenciaToString(vigencia);
         }else{
              tarea.setVigencia(fechafinal);
         }        
         GlobalStatus.TransferenciaTarea = tarea;
         
         ArrayList<Task> newList = new ArrayList<>();
         
         for(int i=0; i<Tareas.size(); i++){
             Task item = Tareas.get(i);
             newList.add(item);
         }
         this.crearArchivo(newList);         
     }
     
      public void eliminarTarea(String id){       
         Task tarea = this.BuscarTarea(id);
         tarea.eliminarTodasListaActividades();
         this.Tareas.removeIf(x -> x.getId().equals(id));
         ArrayList<Task> newList = new ArrayList<>();
         
         for(int i=0; i<this.Tareas.size(); i++){
             Task item = this.Tareas.get(i);
             newList.add(item);
         }
         this.crearArchivo(newList);
     }
     
      public Task BuscarTarea(String id) {  
        Optional<Task> lista = this.Tareas.stream()
            .filter(p -> p.getId().equals(id))
            .findFirst();
        System.out.println("la tarea es: " + lista.get().getNombre());
        return lista.isPresent() ? lista.get() : null;
    }

   

}
