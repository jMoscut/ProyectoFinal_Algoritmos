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
public class ListActivities {
    private String idLista;
    private String idTarea;
    private String idTablero;
    private String NombreLista;
    private float Porcentaje;
    private ArrayList<Activities> Actividades = new ArrayList();

    /**
     * @return the idLista
     */
    public String getIdLista() {
        return idLista;
    }

    /**
     * @param idLista the idLista to set
     */
    public void setIdLista(String idLista) {
        this.idLista = idLista;
    }

    /**
     * @return the idTarea
     */
    public String getIdTarea() {
        return idTarea;
    }

    /**
     * @param idTarea the idTarea to set
     */
    public void setIdTarea(String idTarea) {
        this.idTarea = idTarea;
    }

    /**
     * @return the idTablero
     */
    public String getIdTablero() {
        return idTablero;
    }

    /**
     * @param idTablero the idTablero to set
     */
    public void setIdTablero(String idTablero) {
        this.idTablero = idTablero;
    }

    /**
     * @return the NombreLista
     */
    public String getNombreLista() {
        return NombreLista;
    }

    /**
     * @param NombreLista the NombreLista to set
     */
    public void setNombreLista(String NombreLista) {
        this.NombreLista = NombreLista;
    }

    /**
     * @return the Porcentaje
     */
    public float getPorcentaje() {
        float completado;
        completado = CompletadoLista();  
        Actividades = this.leerTareasLista();
        if (Actividades.isEmpty()) {
            return 100;
        }
        else{
            return completado / Actividades.size() * 100;
        }
    }

    /**
     * @param Porcentaje the Porcentaje to set
     */
    public void setPorcentaje(float Porcentaje) {
        this.Porcentaje = Porcentaje;
    }
    
     public void crearArchivo(ArrayList<Activities> lista) {
		FileWriter flwriter = null;
		try {
			
			flwriter = new FileWriter("/Users/jackiesanchez/Organizador/Actividades/" + this.idLista + ".txt");
                    try ( 
                            BufferedWriter bfwriter = new BufferedWriter(flwriter)) {
                        for (Activities actividades : lista) {
                        
                           bfwriter.write(actividades.getId() + "|" + actividades.getIdListaActividades() + "|" + actividades.getNombre() + "|" + actividades.getEstado() + "\n");
                        }
                      
                    }
			System.out.println("actividades creadas satisfactoriamente..");

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
       

        File file = new File("/Users/jackiesanchez/Organizador/Actividades/" + this.idLista + ".txt");
        ArrayList listaTareas = new ArrayList<Activities>();
        Scanner scanner;
        try {
          
            scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                
                String linea = scanner.nextLine();
                Scanner delimitar = new Scanner(linea);
              				
                delimitar.useDelimiter("\\s*\\|\\s*");
                Activities e = new Activities();
                e.setId(delimitar.next());
                e.setIdListaActividades(delimitar.next());
                e.setNombre(delimitar.next());
                e.setEstado(delimitar.next());
                listaTareas.add(e);                
            }
            this.Actividades = listaTareas;
      
            scanner.close();
            System.out.println("Lista actividades leidas satisfactoriamente..");
        } catch (FileNotFoundException e) {
            System.out.println(e);
            this.Actividades = new ArrayList<Activities>();
        }
        return Actividades;
    }

    //añadir más tareas al archivo
    public void aniadirTareasLista(ArrayList<Activities> lista) {
        File directorio = new File("/Users/jackiesanchez/Organizador/Actividades");
        if (!directorio.exists()) {
            if (directorio.mkdirs()) {
                System.out.println("Directorio creado");
            } else {
                System.out.println("Error al crear directorio");
            }
        }
        FileWriter flwriter = null;
        try {
            flwriter = new FileWriter("/Users/jackiesanchez/Organizador/Actividades/" + this.idLista + ".txt", true);
            try ( BufferedWriter bfwriter = new BufferedWriter(flwriter)) {
                for (Activities actividades : lista) {
                 
                    bfwriter.write(actividades.getId() + "|" + actividades.getIdListaActividades() + "|" + actividades.getNombre() + "|" + actividades.getEstado() + "\n");
                }
            }
            System.out.println("actividades modificadas satisfactoriamente..");
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

    public void eliminarTodasActividadesLista() {
        File archivo = new File("/Users/jackiesanchez/Organizador/Actividades/" + this.idLista + ".txt");
        System.out.println("eliminacion de tareas de la lista " + this.NombreLista);
        if (archivo.delete()) {
            System.out.println("El fichero de actividades ha sido borrado satisfactoriamente");
        } else {
            System.out.println("El fichero de actividades no puede ser borrado");
        }
    }
    
     public void modificarActividades(String id, String nombre, String estado){
         Activities lista = this.BuscarActividad(id);    
         lista.setNombre(nombre);   
         lista.setEstado(estado);
         GlobalStatus.TransferenciaActividades = lista;
         
         ArrayList<Activities> newList = new ArrayList<>();
         
         for(int i=0; i<Actividades.size(); i++){
             Activities item = Actividades.get(i);
             newList.add(item);
         }
         this.crearArchivo(newList);         
     }
     
     public void eliminarActividades(String id){
         Activities lista = this.BuscarActividad(id);    
         Actividades.removeIf(x -> x.getId().equals(id));
         
         GlobalStatus.TransferenciaActividades = new Activities();
         
         ArrayList<Activities> newList = new ArrayList<>();
         
         for(int i=0; i<Actividades.size(); i++){
             Activities item = Actividades.get(i);
             newList.add(item);
         }
         this.crearArchivo(newList);         
     }
     
      public Activities BuscarActividad(String id) {  
        Actividades = this.leerTareasLista();
        Optional<Activities> lista = this.Actividades.stream()
            .filter(p -> p.getId().equals(id))
            .findFirst();
        System.out.println("la actividad es: " + lista.get().getNombre());
        return lista.isPresent() ? lista.get() : null;
    }
      
      public long CompletadoLista() {  
        Actividades = this.leerTareasLista();
        long list = Actividades.stream().filter(x->x.getEstado().equals("Completada")).count();
        System.out.println("cantidad actividades es: " + Actividades.size() + " tamaño filter: " + list);
        return list;
    }
   
}
