package model.views;

import model.dao.SagasDAO;
import model.dao.PlanetasDAO;
import model.entities.Sagas;
import model.entities.Planeta;

import java.util.List;
import java.util.Scanner;

public class SagasView extends ControllerView{
    private static SagasDAO sagasDAO = new SagasDAO();
    private static PlanetasDAO planetasDAO = new PlanetasDAO();
    private static Scanner scanner = new Scanner(System.in);
    public static void listarSagas(){
        List<Sagas> sagasList = sagasDAO.select(entityManager);
        System.out.println("Lista de sagas: ");
        for(int i =0 ; i < sagasList.size(); i++){
            System.out.println("\t["+sagasList.get(i).getNombre()+", "+sagasList.get(i).getPlaneta().getNombre() + ", "+sagasList.get(i).getLongitud()+"]");
        }
    }

    public static void annadirSaga(){
        boolean correcto = false;
        int atras = 1;
        while (!correcto && atras!=0) {
            Sagas saga = new Sagas();
            System.out.println("Introduce nombre de la saga");
            String nombre = scanner.nextLine();
            nombre = nombre.toUpperCase().charAt(0) + nombre.substring(1, nombre.length()).toLowerCase();
            saga.setNombre(nombre);
            System.out.println("Introduce numero de libros de la saga");
            int log = scanner.nextInt();
            scanner.nextLine();
            String longitud = ""+log;
            saga.setLongitud(longitud);
            System.out.println("Introduce nombre del planeta de origen");
            String nombrePlaneta = scanner.nextLine();
            nombrePlaneta = nombrePlaneta.toUpperCase().charAt(0) + nombrePlaneta.substring(1, nombrePlaneta.length()).toLowerCase();
            Planeta nPlan = planetasDAO.find(entityManager, nombrePlaneta);
            if (nPlan!=null) {
                saga.setPlaneta(nPlan);

                sagasDAO.insert(saga,entityManager);
                System.out.println("Se ha añadido");
                correcto = true;

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

    public static void modificarSaga() {
        System.out.println("Introduce nombre de la saga");
        String nombre = scanner.nextLine();
        nombre = nombre.toUpperCase().charAt(0) + nombre.substring(1, nombre.length()).toLowerCase();
        Sagas saga;
        saga = sagasDAO.find(entityManager, nombre);
        boolean correcto = false;
        int atras = 1;
        while (!correcto && atras != 0) {
            if (saga != null) {
                System.out.println("Introduce nuevo nombre de la saga");
                nombre = scanner.nextLine();
                nombre = nombre.toUpperCase().charAt(0) + nombre.substring(1, nombre.length()).toLowerCase();
                saga.setNombre(nombre);
                System.out.println("Introduce numero de libros de la saga");
                int log = scanner.nextInt();
                scanner.nextLine();
                String longitud = "" + log;
                saga.setLongitud(longitud);
                System.out.println("Introduce nuevo nombre del planeta de origen");
                String nombrePlaneta = scanner.nextLine();
                nombrePlaneta = nombrePlaneta.toUpperCase().charAt(0) + nombrePlaneta.substring(1, nombrePlaneta.length()).toLowerCase();
                Planeta nPlan = planetasDAO.find(entityManager, nombrePlaneta);
                if (nPlan != null) {
                    saga.setPlaneta(nPlan);

                    sagasDAO.update(saga,entityManager);
                    System.out.println("Se ha actualizado");
                    correcto = true;

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
            } else {
                System.out.println("Saga no existente");
            }
        }
    }
    public static void eliminarSaga(){
        System.out.println("Introduce nombre de la saga");
        String nombre = scanner.nextLine();
        nombre = nombre.toUpperCase().charAt(0) + nombre.substring(1, nombre.length()).toLowerCase();
        Sagas saga;
        saga = sagasDAO.find(entityManager, nombre);

        boolean borrado = sagasDAO.delete(saga,entityManager);
        if (borrado){
            System.out.println("Se ha borrado la saga "+ saga.getNombre());
        }else {
            System.out.println("No se ha podido borrar la saga");
        }
    }
}