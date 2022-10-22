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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Optional;
import java.util.Scanner;

/**
 *
 * @author jackiesanchez
 */
public class Task {
    private String Id;
    private String IdLista;
    private String Nombre;
    private String Descripcion;
    private int Posicion;
    private String FechaInicio;
    private String FechaFinal;
    private String Vigencia;
    private ArrayList<ListActivities> listaActividades = new ArrayList();
    private ArrayList<Comments> Comentarios = new ArrayList();
    /**
     * @return the Id
     */
    public String getId() {
        return Id;
    }

    /**
     * @param Id the Id to set
     */
    public void setId(String Id) {
        this.Id = Id;
    }

    /**
     * @return the IdLista
     */
    public String getIdLista() {
        return IdLista;
    }

    /**
     * @param IdLista the IdLista to set
     */
    public void setIdLista(String IdLista) {
        this.IdLista = IdLista;
    }

    /**
     * @return the Nombre
     */
    public String getNombre() {
        return Nombre;
    }

    /**
     * @param Nombre the Nombre to set
     */
    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    /**
     * @return the Descripcion
     */
    public String getDescripcion() {
        return Descripcion;
    }

    /**
     * @param Descripcion the Descripcion to set
     */
    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    /**
     * @return the Posicion
     */
    public int getPosicion() {
        return Posicion;
    }

    /**
     * @param Posicion the Posicion to set
     */
    public void setPosicion(int Posicion) {
        this.Posicion = Posicion;
    }

    /**
     * @return the FechaInicio
     */
    public String getFechaInicio() {
        return FechaInicio;
    }

    /**
     * @param FechaInicio the FechaInicio to set
     */
    public void setFechaInicio(String FechaInicio) {
        this.FechaInicio = FechaInicio;
    }

    /**
     * @return the FechaFinal
     */
    public String getFechaFinal() {
        return FechaFinal;
    }

    /**
     * @param FechaFinal the FechaFinal to set
     */
    public void setFechaFinal(String FechaFinal) {
        this.FechaFinal = FechaFinal;
    }

    /**
     * @return the Vigencia
     */
    public String getVigencia() {
        return Vigencia;
    }

    /**
     */
    public void setVigencia(String FechaFinal) throws ParseException {
        SimpleDateFormat fecha = new SimpleDateFormat("dd/MM/yyyy");
        Date fechahoy = new Date();
        String fechahoystring = fecha.format(fechahoy);
        Date dt_2 = fecha.parse(FechaFinal);
        Date dt_1 = fecha.parse(fechahoystring);
        String Vigencia = "";
        if (dt_1.compareTo(dt_2) > 0) {  
            Vigencia = "Vencida"; 
        }  
        else if (dt_1.compareTo(dt_2) < 0) {  
            Vigencia = "En tiempo"; 
        } 
        else if (dt_1.compareTo(dt_2) == 0) {  
            Vigencia = "Por vencer";  
        } 
        else {  
            System.out.println("¡Pareces ser un viajero del tiempo!"); 
        }         
        this.Vigencia = Vigencia;
    }
    
    public void setVigenciaToString(String Vigencia){
          this.Vigencia = Vigencia;
    }
    
     public void crearArchivo(ArrayList<ListActivities> lista) {
		FileWriter flwriter = null;
		try {
			
			flwriter = new FileWriter("/Users/jackiesanchez/Organizador/ListaActividades/" + this.Id + ".txt");
                    try ( 
                            BufferedWriter bfwriter = new BufferedWriter(flwriter)) {
                        for (ListActivities actividades : lista) {
                           
                           bfwriter.write(actividades.getIdLista() + "|" + actividades.getIdTarea() + "|" + actividades.getIdTablero() + "|" + actividades.getNombreLista() + "|" + actividades.getPorcentaje() + "\n");
                        }
                        
                    }
			System.out.println("Lista de actividades creadas satisfactoriamente..");

		} catch (IOException e) {
		} finally {
			if (flwriter != null) {
				try {//cierra el flujo principal
					flwriter.close();
				} catch (IOException e) {
				}
			}
		}
    }

    public ArrayList leerTareasLista() {
   

        File file = new File("/Users/jackiesanchez/Organizador/ListaActividades/" + this.Id + ".txt");
        ArrayList listaTareas = new ArrayList<ListActivities>();
        Scanner scanner;
        try {
           
            scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                
                String linea = scanner.nextLine();
                Scanner delimitar = new Scanner(linea);
              				
                delimitar.useDelimiter("\\s*\\|\\s*");
                ListActivities e = new ListActivities();
                e.setIdLista(delimitar.next());
                e.setIdTarea(delimitar.next());
                e.setIdTablero(delimitar.next());
                e.setNombreLista(delimitar.next());
                e.setPorcentaje(Float.parseFloat(delimitar.next()));
                listaTareas.add(e);                
            }
            this.listaActividades = listaTareas;
         
            scanner.close();
            System.out.println("Lista actividades leidas satisfactoriamente..");
        } catch (FileNotFoundException e) {
            System.out.println(e);
            this.listaActividades = new ArrayList<ListActivities>();
        }
        return listaActividades;
    }

    //añadir más tareas al archivo
    public void aniadirTareasLista(ArrayList<ListActivities> lista) {
        File directorio = new File("/Users/jackiesanchez/Organizador/ListaActividades");
        if (!directorio.exists()) {
            if (directorio.mkdirs()) {
                System.out.println("Directorio creado");
            } else {
                System.out.println("Error al crear directorio");
            }
        }
        FileWriter flwriter = null;
        try {
            flwriter = new FileWriter("/Users/jackiesanchez/Organizador/ListaActividades/" + this.Id + ".txt", true);
            try ( BufferedWriter bfwriter = new BufferedWriter(flwriter)) {
                for (ListActivities actividades : lista) {
                    
                    bfwriter.write(actividades.getIdLista() + "|" + actividades.getIdTarea() + "|" + actividades.getIdTablero() + "|" + actividades.getNombreLista() + "|" + actividades.getPorcentaje() + "\n");
                }
            }
            System.out.println("Lista de actividades modificadas satisfactoriamente..");
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

    public void eliminarTodasListaActividades() {
        listaActividades = this.leerTareasLista();
        for(ListActivities tareas: listaActividades){
            tareas.eliminarTodasActividadesLista();
        }
        File archivo = new File("/Users/jackiesanchez/Organizador/ListaActividades/" + this.Id + ".txt");
        System.out.println("eliminacion de tareas de la lista " + this.Nombre);
        if (archivo.delete()) {
            System.out.println("El fichero de listas de actividades ha sido borrado satisfactoriamente");
        } else {
            System.out.println("El fichero de listas de actividades no puede ser borrado");
        }
    }
    
      public void eliminarListaActividades(String id){       
         ListActivities listado = this.BuscarLista(id);
         listado.eliminarTodasActividadesLista();
         listaActividades.removeIf(x -> x.getIdLista().equals(id));
         ArrayList<ListActivities> newList = new ArrayList<>();
         
         for(int i=0; i<listaActividades.size(); i++){
             ListActivities item = listaActividades.get(i);
             newList.add(item);
         }
         this.crearArchivo(newList);
     }
    
     public void modificarListas(String id, String nombre){
         ListActivities lista = this.BuscarLista(id);    
         lista.setNombreLista(nombre);        
         GlobalStatus.TransferenciaListadoActividades = lista;
         
         ArrayList<ListActivities> newList = new ArrayList<>();
         
         for(int i=0; i<listaActividades.size(); i++){
             ListActivities item = listaActividades.get(i);
             newList.add(item);
         }
         this.crearArchivo(newList);         
     }
     
      public ListActivities BuscarLista(String id) {  
        Optional<ListActivities> lista = this.listaActividades.stream()
            .filter(p -> p.getIdLista().equals(id))
            .findFirst();
        System.out.println("la lista de actividades es: " + lista.get().getNombreLista());
        return lista.isPresent() ? lista.get() : null;
    }
    
                public void crearComentarios(ArrayList<Comments> lista) {
		FileWriter flwriter = null;
		try {
			//crea el flujo para escribir en el archivo
			flwriter = new FileWriter("/Users/jackiesanchez/Organizador/Comentarios/" + this.Id + ".txt");
                    try ( //crea un buffer o flujo intermedio antes de escribir directamente en el archivo
                            BufferedWriter bfwriter = new BufferedWriter(flwriter)) {
                        for (Comments actividades : lista) {
                            //escribe los datos en el archivo
                           bfwriter.write(actividades.getIdComentario() + "|" + actividades.getIdTarea() + "|" + actividades.getComentario() + "\n");
                        }
                        //cierra el buffer intermedio
                    }
			System.out.println("comentarios creados satisfactoriamente..");

		} catch (IOException e) {
		} finally {
			if (flwriter != null) {
				try {//cierra el flujo principal
					flwriter.close();
				} catch (IOException e) {
				}
			}
		}
    }

    public ArrayList leerComentariosTarea() {
        // crea el flujo para leer desde el archivo

        File file = new File("/Users/jackiesanchez/Organizador/Comentarios/" + this.Id + ".txt");
        ArrayList listaTareas = new ArrayList<Comments>();
        Scanner scanner;
        try {
            //se pasa el flujo al objeto scanner
            scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                // el objeto scanner lee linea a linea desde el archivo
                String linea = scanner.nextLine();
                Scanner delimitar = new Scanner(linea);
                //se usa una expresión regular
                //que valida que antes o despues de un pipe (|) exista cualquier cosa
                //parte la cadena recibida cada vez que encuentre un pipe				
                delimitar.useDelimiter("\\s*\\|\\s*");
                Comments e = new Comments();
                e.setIdComentario(delimitar.next());
                e.setIdTarea(delimitar.next());
                e.setComentario(delimitar.next());
                listaTareas.add(e);                
            }
            this.Comentarios = listaTareas;
            //se cierra el ojeto scanner
            scanner.close();
            System.out.println("comentarios leidos satisfactoriamente..");
        } catch (FileNotFoundException e) {
            System.out.println(e);
            this.Comentarios = new ArrayList<Comments>();
        }
        return Comentarios;
    }

    //añadir más tareas al archivo
    public void aniadirComentariosTarea(ArrayList<Comments> lista) {
        File directorio = new File("/Users/jackiesanchez/Organizador/Comentarios");
        if (!directorio.exists()) {
            if (directorio.mkdirs()) {
                System.out.println("Directorio creado");
            } else {
                System.out.println("Error al crear directorio");
            }
        }
        FileWriter flwriter = null;
        try {//además de la ruta del archivo recibe un parámetro de tipo boolean, que le indican que se va añadir más registros 
            flwriter = new FileWriter("/Users/jackiesanchez/Organizador/Comentarios/" + this.Id + ".txt", true);
            try ( BufferedWriter bfwriter = new BufferedWriter(flwriter)) {
                for (Comments actividades : lista) {
                    //escribe los datos en el archivo
                   bfwriter.write(actividades.getIdComentario() + "|" + actividades.getIdTarea() + "|" + actividades.getComentario() + "\n");
                }
            }
            System.out.println("comentarios modificados satisfactoriamente..");
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

    public void eliminarTodosComentarios() {
        File archivo = new File("/Users/jackiesanchez/Organizador/Comentarios/" + this.Id + ".txt");
        System.out.println("eliminacion de comentarios de la tarea " + this.Nombre);
        if (archivo.delete()) {
            System.out.println("El fichero de comentarios ha sido borrado satisfactoriamente");
        } else {
            System.out.println("El fichero de comentarios no puede ser borrado");
        }
    }
    
      public void eliminarComentario(String id){       
         Comentarios.removeIf(x -> x.getIdComentario().equals(id));
         ArrayList<Comments> newList = new ArrayList();
         
         for(int i=0; i<Comentarios.size(); i++){
             Comments item = Comentarios.get(i);
             newList.add(item);
         }
         this.crearComentarios(newList);
     }
    
     public void modificarComentarios(String id, String nombre){
         Comments lista = this.BuscarComentario(id);    
         lista.setComentario(nombre);        
         GlobalStatus.TransferenciaComentarios = lista;
         
         ArrayList<Comments> newList = new ArrayList();
         
         for(int i=0; i<Comentarios.size(); i++){
             Comments item = Comentarios.get(i);
             newList.add(item);
         }
         this.crearComentarios(newList);         
     }
     
      public Comments BuscarComentario(String id) {  
        Optional<Comments> lista = this.Comentarios.stream()
            .filter(p -> p.getIdComentario().equals(id))
            .findFirst();
        System.out.println("el comentario es: " + lista.get().getComentario());
        return lista.isPresent() ? lista.get() : null;
    } 
    
}
