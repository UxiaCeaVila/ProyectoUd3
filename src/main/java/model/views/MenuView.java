package model.views;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import model.dao.*;
import model.entities.Especies;

import java.util.List;
import java.util.Scanner;

public class MenuView {
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
                if(opcion >= 0 && opcion <= 5){
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

    public static void menuPrincipal(){
        int opcion1 = 1, opcion2 = 1, salir = 1, atras= 1;
        while(salir!=0) {

            opcion1 = menu1();

            switch (opcion1) {
                case 1:
                    atras = 1;
                    while(atras != 0 && salir != 0) {
                        opcion2 = menu2();
                        switch (opcion2) {
                            case 1:
                                EspeciesView.listarEspecies();
                                break;
                            case 2:
                                EspeciesView.annadirEspecie();
                                break;
                            case 3:
                                EspeciesView.modificarEspecie();
                                break;
                            case 4:
                                EspeciesView.eliminarEspeice();
                                break;
                            case 5:
                                System.out.println("Atras....");
                                atras = 0;
                                break;
                            default:
                                System.out.println("Saliendo");
                                salir = 0;
                                break;
                        }
                    }
                    break;
                case 2:
                    atras = 1;
                    while(atras != 0 && salir != 0) {
                        opcion2 = menu2();
                        switch (opcion2) {
                            case 1:
                                LibroView.listarLibros();
                                break;
                            case 2:
                                LibroView.annadirLibro();
                                break;
                            case 3:
                                LibroView.modificarLibro();
                                break;
                            case 4:
                                LibroView.eliminarLibro();
                                break;
                            case 5:
                                System.out.println("Atras....");
                                atras = 0;
                                break;
                            default:
                                System.out.println("Saliendo");
                                salir = 0;
                                break;
                        }
                    }
                    break;
                case 3:
                    atras = 1;
                    while(atras != 0 && salir != 0) {
                        opcion2 = menu2();
                        switch (opcion2) {
                            case 1:
                                MagiaView.listarMagias();
                                break;
                            case 2:
                                MagiaView.annadirMagia();
                                break;
                            case 3:
                                MagiaView.modificarMagia();
                                break;
                            case 4:
                                MagiaView.eliminarMagia();
                                break;
                            case 5:
                                System.out.println("Atras....");
                                atras = 0;
                                break;
                            default:
                                System.out.println("Saliendo");
                                salir = 0;
                                break;
                        }
                    }
                    break;
                case 4:
                    atras = 1;
                    while(atras != 0 && salir != 0) {
                        opcion2 = menu2();
                        switch (opcion2) {
                            case 1:
                                PersonajeView.listarPersonajes();
                                break;
                            case 2:
                                PersonajeView.annadirPersonaje();
                                break;
                            case 3:
                                PersonajeView.modificarPersonaje();
                                break;
                            case 4:
                                PersonajeView.eliminarPersonaje();
                                break;
                            case 5:
                                System.out.println("Atras....");
                                atras = 0;
                                break;
                            default:
                                System.out.println("Saliendo");
                                salir = 0;
                                break;
                        }
                    }
                    break;
                case 5:
                    atras = 1;
                    while(atras != 0 && salir != 0) {
                        opcion2 = menu2();
                        switch (opcion2) {
                            case 1:
                                PlanetasView.listarPlanetas();
                                break;
                            case 2:
                                PlanetasView.annadirPlaneta();
                                break;
                            case 3:
                                PlanetasView.modificarPlaneta();
                                break;
                            case 4:
                                PlanetasView.eliminarPlaneta();
                                break;
                            case 5:
                                System.out.println("Atras....");
                                atras = 0;
                                break;
                            default:
                                System.out.println("Saliendo");
                                salir = 0;
                                break;
                        }
                    }
                    break;
                case 6:
                    atras = 1;
                    while(atras != 0 && salir != 0) {
                        opcion2 = menu2();
                        switch (opcion2) {
                            case 1:
                                SagasView.listarSagas();
                                break;
                            case 2:
                                SagasView.annadirSaga();
                                break;
                            case 3:
                                SagasView.modificarSaga();
                                break;
                            case 4:
                                SagasView.eliminarSaga();
                                break;
                            case 5:
                                System.out.println("Atras....");
                                atras = 0;
                                break;
                            default:
                                System.out.println("Saliendo");
                                salir = 0;
                                break;
                        }
                    }
                    break;
                default:
                    System.out.println("Saliendo....");
                    salir = 0;
                    break;
            }
        }
    }

}
