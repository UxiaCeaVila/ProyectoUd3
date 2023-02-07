package model.views;

import model.dao.LibroDAO;
import model.dao.PlanetasDAO;
import model.dao.SagasDAO;
import model.entities.Libro;
import model.entities.Planeta;
import model.entities.Sagas;

import java.util.List;
import java.util.Scanner;

public class LibroView extends ControllerView{
    private static LibroDAO libroDAO = new LibroDAO();
    private static PlanetasDAO planetasDAO = new PlanetasDAO();
    private static SagasDAO sagasDAO = new SagasDAO();
    private static Scanner scanner = new Scanner(System.in);
    public static void listarLibros(){
        List<Libro> libroList = libroDAO.select(entityManager);
        System.out.println("Lista de libro: ");
        for(int i =0 ; i < libroList.size(); i++){
            System.out.println("\t["+libroList.get(i).getNombre()+", "+libroList.get(i).getSaga().getNombre() + ", "+libroList.get(i).getPlaneta().getNombre()+"]");
        }
    }

    public static void annadirLibro(){
        boolean correcto = false;
        int atras = 1;
        while (!correcto && atras!=0) {
            Libro libro = new Libro();
            System.out.println("Introduce nombre del libro");
            String nombre = scanner.nextLine();
            nombre = nombre.toUpperCase().charAt(0) + nombre.substring(1, nombre.length()).toLowerCase();
            libro.setNombre(nombre);
            System.out.println("Introduce nombre del planeta ambiente");
            String nombrePlaneta = scanner.nextLine();
            nombrePlaneta = nombrePlaneta.toUpperCase().charAt(0) + nombrePlaneta.substring(1, nombrePlaneta.length()).toLowerCase();
            Planeta nPlan = planetasDAO.find(entityManager, nombrePlaneta);
            if (nPlan!=null) {
                libro.setPlaneta(nPlan);

                System.out.println("Introduce nombre de la saga");
                String nombreSaga = scanner.nextLine();
                nombreSaga = nombreSaga.toUpperCase().charAt(0) + nombreSaga.substring(1, nombreSaga.length()).toLowerCase();
                Sagas saga = sagasDAO.find(entityManager,nombreSaga);
                if (saga!=null) {
                    libro.setSaga(saga);

                    libroDAO.insert(libro,entityManager);
                    System.out.println("Se ha añadido");
                    correcto = true;
                    
                } else {
                    boolean out = false;
                    while(!out) {
                        System.out.println("No hay saga con ese nombre, introduce 0 para volver al menu principal, o 1 para volver a insertar");
                        if(scanner.hasNextInt()){
                            atras = scanner.nextInt();
                            scanner.nextLine();
                            if(atras == 0){
                                System.out.println("Volviendo");
                            }
                            out = true;
                        }else {
                            System.out.println("Valor  incorrecto");
                        }
                    }
                }
            } else {
                boolean out = false;
                while(!out) {
                    System.out.println("No hay planeta con ese nombre, introduce 0 para volver al menu principal, o 1 para volver a insertar");
                    if(scanner.hasNextInt()){
                        atras = scanner.nextInt();
                        scanner.nextLine();
                        if(atras == 0){
                            System.out.println("Volviendo");
                        }
                        out = true;
                    }else {
                        System.out.println("Valor  incorrecto");
                    }
                }
            }
        }
    }

    public static void modificarLibro(){
        System.out.println("Introduce nombre del libro");
        String nombre = scanner.nextLine();
        nombre = nombre.toUpperCase().charAt(0) + nombre.substring(1, nombre.length()).toLowerCase();
        Libro libro;
        libro = libroDAO.find(entityManager, nombre);
        boolean correcto = false;
        int atras = 1;
        while (!correcto && atras!=0) {
            if (libro != null) {
                System.out.println("Introduce nuevo nombre del libro");
                nombre = scanner.nextLine();
                nombre = nombre.toUpperCase().charAt(0) + nombre.substring(1, nombre.length()).toLowerCase();
                libro.setNombre(nombre);
                System.out.println("Introduce nuevo nombre del planeta ambiente");
                String nombrePlaneta = scanner.nextLine();
                nombrePlaneta = nombrePlaneta.toUpperCase().charAt(0) + nombrePlaneta.substring(1, nombrePlaneta.length()).toLowerCase();
                Planeta nPlan = planetasDAO.find(entityManager, nombrePlaneta);
                if (nPlan != null) {
                    libro.setPlaneta(nPlan);

                    System.out.println("Introduce nuevo nombre de la saga");
                    String nombreSaga = scanner.nextLine();
                    nombreSaga = nombreSaga.toUpperCase().charAt(0) + nombreSaga.substring(1, nombreSaga.length()).toLowerCase();
                    Sagas saga = sagasDAO.find(entityManager, nombreSaga);
                    if (saga != null) {
                        libro.setSaga(saga);
                        libroDAO.update(libro,entityManager);
                        System.out.println("Se ha actualizado");
                        correcto = true;
                    } else {
                        boolean out = false;
                        while (!out) {
                            System.out.println("No hay saga con ese nombre, introduce 0 para volver al menu principal, o 1 para volver a insertar");
                            if (scanner.hasNextInt()) {
                                atras = scanner.nextInt();
                                scanner.nextLine();
                                if (atras == 0) {
                                    System.out.println("Volviendo");
                                }
                                out = true;
                            } else {
                                System.out.println("Valor  incorrecto");
                            }
                        }
                    }
                } else {
                    boolean out = false;
                    while (!out) {
                        System.out.println("No hay planeta con ese nombre, introduce 0 para volver al menu principal, o 1 para volver a insertar");
                        if (scanner.hasNextInt()) {
                            atras = scanner.nextInt();
                            scanner.nextLine();
                            if (atras == 0) {
                                System.out.println("Volviendo");
                            }
                            out = true;
                        } else {
                            System.out.println("Valor  incorrecto");
                        }
                    }
                }
            }
        }
    }

    public static void eliminarLibro(){
        System.out.println("Introduce nombre de la libro");
        String nombre = scanner.nextLine();
        nombre = nombre.toUpperCase().charAt(0) + nombre.substring(1, nombre.length()).toLowerCase();
        Libro libro;
        libro = libroDAO.find(entityManager, nombre);

        boolean borrado = libroDAO.delete(libro,entityManager);
        if (borrado){
            System.out.println("Se ha borrado la libro "+ libro.getNombre());
        }else {
            System.out.println("No se ha podido borrar la libro");
        }
    }
}
