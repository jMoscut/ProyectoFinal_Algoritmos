/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MainOrganizer;

/**
 *
 * @author jackiesanchez
 */
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class OperationalFile {

	public static void crearArchivo(ArrayList<TaskTable> lista) {
		FileWriter flwriter = null;
		try {

			flwriter = new FileWriter("/Users/jackiesanchez/Organizador/Tableros/tableros.txt");
                    try ( 
                            BufferedWriter bfwriter = new BufferedWriter(flwriter)) {
                        for (TaskTable tablero : lista) {
                            
                            bfwriter.write(tablero.getIdentificacion() + "|" + tablero.getNombre() + "|" + tablero.countTareas() + "\n");
                        }
                        
                    }
			System.out.println("Tablero creado satisfactoriamente..");

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
	
	
	public static ArrayList leerArchivo() {
		
		File file = new File("/Users/jackiesanchez/Organizador/Tableros/tableros.txt");
		ArrayList listaTableros= new ArrayList<>();	
		Scanner scanner;
		try {
			
			scanner = new Scanner(file);
			while (scanner.hasNextLine()) {
			
				String linea = scanner.nextLine();
				Scanner delimitar = new Scanner(linea);
								
				delimitar.useDelimiter("\\s*\\|\\s*");
				TaskTable e = new TaskTable();
				e.setIdentificacion(delimitar.next());
				e.setNombre(delimitar.next());
				e.setTotalTareas(Integer.parseInt(delimitar.next()));
				listaTableros.add(e);
			}
		
			scanner.close();
                        System.out.println("Tableros leidos satisfactoriamente..");
		} catch (FileNotFoundException e) {
                    System.out.println(e);
		}
		return listaTableros;
	}
	
	
	public static void aniadirArchivo(ArrayList<TaskTable> lista) {
                File root = new File("/Users/jackiesanchez/Organizador");
                    if (!root.exists()) {
                       if (root.mkdirs()) {
                           System.out.println("Directorio creado");                        
                       } else {
                           System.out.println("Error al crear raiz");
                       }
                   }        
                File directorio = new File("/Users/jackiesanchez/Organizador/Tableros");
                 if (!directorio.exists()) {
                    if (directorio.mkdirs()) {
                        System.out.println("Directorio creado");                        
                    } else {
                        System.out.println("Error al crear directorio");
                    }
                }                 
                FileWriter flwriter = null;
		try {
			flwriter = new FileWriter("/Users/jackiesanchez/Organizador/Tableros/tableros.txt", true);
                    try (BufferedWriter bfwriter = new BufferedWriter(flwriter)) {
                        for (TaskTable tablero : lista) {
                           
                            bfwriter.write(tablero.getIdentificacion() + "|" + tablero.getNombre() + "|" + tablero.countTareas() + "\n");
                        }
                    }
			System.out.println("Archivo modificado satisfactoriamente..");

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
        
        public static void eliminarArchivo(){
            
        }
}
