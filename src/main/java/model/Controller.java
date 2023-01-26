package model;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import model.dao.*;
import model.entities.Especies;

import java.util.List;
import java.util.Scanner;

public class Controller {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EspeciesDAO especiesDAO = new EspeciesDAO();
        PlanetasDAO planetasDAO = new PlanetasDAO();
        LibroDAO libroDAO = new LibroDAO();
        MagiaDAO magiaDAO = new MagiaDAO();
        PersonajeDAO personajeDAO = new PersonajeDAO();
        SagasDAO sagasDAO = new SagasDAO();
        int opcion1 = 1, opcion2 = 1, salir = 1, atras= 1;
        while(salir!=0) {

            opcion1 = menu1();

            switch (opcion1) {
                case 1:
                    atras = 1;
                    while(atras != 0 || salir != 0) {
                        opcion2 = menu2();
                        switch (opcion2) {
                            case 1:
                                List<Especies> especiesList = especiesDAO.select(entityManager);
                                break;
                            case 2:
                                boolean correcto = false;
                                while (!correcto) {
                                    Especies especie = new Especies();
                                    System.out.println("Introduce nombre de la especie");
                                    String nombre = scanner.nextLine();
                                    nombre = nombre.toUpperCase().charAt(0) + nombre.substring(1, nombre.length()).toLowerCase();
                                    especie.setNombre(nombre);
                                    System.out.println("Introduce nombre del planeta de origen");
                                    String nombrePlaneta = scanner.nextLine();
                                    nombrePlaneta = nombrePlaneta.toUpperCase().charAt(0) + nombrePlaneta.substring(1, nombrePlaneta.length()).toLowerCase();
                                    List<String> nPlan = planetasDAO.findAutocomplete(nombrePlaneta, entityManager);
                                    if (!nPlan.isEmpty() && nPlan.size() == 1) {
                                        especie.setPlanetaOrigen(planetasDAO.find(entityManager, nombrePlaneta));

                                        boolean out = false;
                                        while(!out) {
                                            System.out.println("Introduce fisiologia de la especie");
                                            if(scanner.hasNextInt()){
                                                int fisiologia = scanner.nextInt();
                                                especie.setFisiologia(fisiologia);
                                                out = true;
                                            }else {
                                                System.out.println("Valor  incorrecto");
                                            }
                                        }
                                    } else {
                                        boolean out = false;
                                        while(!out) {
                                            System.out.println("No hay planeta con ese nombre, introduce 0 para volver al menu principal, o 1 para volver a insertar");
                                            if(scanner.hasNextInt()){
                                                atras = scanner.nextInt();
                                                if(atras == 0){
                                                    break;
                                                }
                                                out = true;
                                            }else {
                                                System.out.println("Valor  incorrecto");
                                            }
                                        }
                                    }
                                    entityManager.persist(especie);
                                }


                            case 3:
                                System.out.println("Introduce nombre de la especie que quieres modificar");
                                String nombre = scanner.nextLine();
                                nombre = nombre.toUpperCase().charAt(0) + nombre.substring(1, nombre.length()).toLowerCase();
                                
                            case 4:
                                opcion2 = menu2();

                            case 5:
                                System.out.println("Atras....");
                                atras = 0;
                            default:
                                System.out.println("Saliendo");
                                salir = 0;
                        }
                    }
                case 2:
                    opcion2 = menu2();
                case 3:
                    opcion2 = menu2();
                case 4:
                    opcion2 = menu2();
                case 5:
                    opcion2 = menu2();
                case 6:
                    opcion2 = menu2();
                default:
                    System.out.println("Saliendo....");
            }
        }
    }

    public static int menu1(){
        Scanner sc = new Scanner(System.in);
        int opcion = 0;
        boolean correcto = false;
        while(!correcto) {
            String menu = "A que quieres acceder? Escoje un numero.\n\t1- Especies\n\t2- Libro\n\t3- Magia\n\t4- Personajes\n\t5- Planetas\n\t6- Sagas\n\t0- Salir";
            System.out.println(menu);
            if(sc.hasNextInt()){
                opcion = sc.nextInt();
                sc.nextLine();
                if(opcion >= 0 && opcion < 7){
                    correcto = true;
                }else {
                    System.out.println("El numero introducido está fuera de rango.");
                }
            }else {
                System.out.println("Introduce alguno de los numeros que acompañan a las opciones.");
            }
        }
        return opcion;
    }
    public static int menu2(){
        Scanner sc = new Scanner(System.in);
        int opcion = 0;
        boolean correcto = false;
        while(!correcto) {
            String menu = "Que accion se va a ejecutar? Escoje un numero.\n\t1- Listar\n\t2- Insertar\n\t3- Modificar\n\t4- Eliminar\n\t5- Atras\n\t0- Salir";
            System.out.println(menu);
            if(sc.hasNextInt()){
                opcion = sc.nextInt();
                sc.nextLine();
                if(opcion >= 0 && opcion < 5){
                    correcto = true;
                }else {
                    System.out.println("El numero introducido está fuera de rango");
                }
            }else {
                System.out.println("Introduce alguno de los numeros que acompañan a las opciones");
            }
        }
        return opcion;
    }
}
