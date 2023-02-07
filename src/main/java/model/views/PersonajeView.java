package model.views;

import model.dao.EspeciesDAO;
import model.dao.PersonajeDAO;
import model.dao.PlanetasDAO;
import model.dao.EspeciesDAO;
import model.entities.Especies;
import model.entities.Personaje;
import model.entities.Planeta;
import model.entities.Especies;

import java.util.List;
import java.util.Scanner;

public class PersonajeView extends ControllerView {
    private static PersonajeDAO personajeDAO = new PersonajeDAO();
    private static PlanetasDAO planetasDAO = new PlanetasDAO();
    private static EspeciesDAO especiesDAO = new EspeciesDAO();
    private static Scanner scanner = new Scanner(System.in);

    public static void listarPersonajes() {
        List<Personaje> personajeList = personajeDAO.select(entityManager);
        System.out.println("Lista de personaje: ");
        for (int i = 0; i < personajeList.size(); i++) {
            System.out.println("\t["+personajeList.get(i).getNombre()+ ", "+personajeList.get(i).getEdad()+ ", "
                    +personajeList.get(i).getEspecie().getNombre()+", "+personajeList.get(i).getPlanetaOrigen().getNombre() +"]");
        }
    }

    public static void annadirPersonaje() {
        boolean correcto = false;
        int atras = 1;
        while (!correcto && atras!=0) {
            Personaje personaje = new Personaje();
            System.out.println("Introduce nombre del personaje");
            String nombre = scanner.nextLine();
            nombre = nombre.toUpperCase().charAt(0) + nombre.substring(1, nombre.length()).toLowerCase();
            personaje.setNombre(nombre);

            System.out.println("Introduce nombre del personaje");
            int edad = scanner.nextInt();
            scanner.nextLine();
            String sedad = ""+edad;
            personaje.setEdad(sedad);

            System.out.println("Introduce nombre de la especie");
            String nombreEspecie = scanner.nextLine();
            nombreEspecie = nombreEspecie.toUpperCase().charAt(0) + nombreEspecie.substring(1, nombreEspecie.length()).toLowerCase();
            Especies especie = especiesDAO.find(entityManager, nombreEspecie);
            if (especie != null) {
                personaje.setEspecie(especie);
                System.out.println("Introduce nombre del planeta ambiente");
                String nombrePlaneta = scanner.nextLine();
                nombrePlaneta = nombrePlaneta.toUpperCase().charAt(0) + nombrePlaneta.substring(1, nombrePlaneta.length()).toLowerCase();
                Planeta nPlan = planetasDAO.find(entityManager, nombrePlaneta);
                if (nPlan != null) {
                    personaje.setPlanetaOrigen(nPlan);

                    personajeDAO.insert(personaje,entityManager);
                    System.out.println("Se ha añadido");
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
                boolean out = false;
                while (!out) {
                    System.out.println("No hay especie con ese nombre, introduce 0 para volver al menu principal, o 1 para volver a insertar");
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

    public static void modificarPersonaje() {
        System.out.println("Introduce nombre del personaje");
        String nombre = scanner.nextLine();
        nombre = nombre.toUpperCase().charAt(0) + nombre.substring(1, nombre.length()).toLowerCase();
        Personaje personaje;
        personaje = personajeDAO.find(entityManager, nombre);
        boolean correcto = false;
        int atras = 1;
        while (!correcto && atras!=0) {

            if (personaje != null) {
                System.out.println("Introduce nuevo nombre del personaje");
                nombre = scanner.nextLine();
                nombre = nombre.toUpperCase().charAt(0) + nombre.substring(1, nombre.length()).toLowerCase();
                personaje.setNombre(nombre);
                System.out.println("Introduce nombre del personaje");
                int edad = scanner.nextInt();
                scanner.nextLine();
                String sedad = "" + edad;
                personaje.setEdad(sedad);

                System.out.println("Introduce nombre de la especie");
                String nombreEspecie = scanner.nextLine();
                nombreEspecie = nombreEspecie.toUpperCase().charAt(0) + nombreEspecie.substring(1, nombreEspecie.length()).toLowerCase();
                Especies especie = especiesDAO.find(entityManager, nombreEspecie);
                if (especie != null) {
                    personaje.setEspecie(especie);
                    System.out.println("Introduce nombre del planeta ambiente");
                    String nombrePlaneta = scanner.nextLine();
                    nombrePlaneta = nombrePlaneta.toUpperCase().charAt(0) + nombrePlaneta.substring(1, nombrePlaneta.length()).toLowerCase();
                    Planeta nPlan = planetasDAO.find(entityManager, nombrePlaneta);
                    if (nPlan != null) {
                        personaje.setPlanetaOrigen(nPlan);
                        personajeDAO.update(personaje,entityManager);
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
                    boolean out = false;
                    while (!out) {
                        System.out.println("No hay especie con ese nombre, introduce 0 para volver al menu principal, o 1 para volver a insertar");
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

    public static void eliminarPersonaje() {
        System.out.println("Introduce nombre de la personaje");
        String nombre = scanner.nextLine();
        nombre = nombre.toUpperCase().charAt(0) + nombre.substring(1, nombre.length()).toLowerCase();
        Personaje personaje;
        personaje = personajeDAO.find(entityManager, nombre);

        boolean borrado = personajeDAO.delete(personaje, entityManager);
        if (borrado) {
            System.out.println("Se ha borrado la personaje " + personaje.getNombre());
        } else {
            System.out.println("No se ha podido borrar la personaje");
        }
    }
}