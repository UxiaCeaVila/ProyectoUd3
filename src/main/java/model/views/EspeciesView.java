package model.views;

import model.dao.EspeciesDAO;
import model.dao.PlanetasDAO;
import model.entities.Especies;
import model.entities.Planeta;

import java.util.List;
import java.util.Scanner;

public class EspeciesView extends ControllerView{
    private static EspeciesDAO especiesDAO = new EspeciesDAO();
    private static PlanetasDAO planetasDAO = new PlanetasDAO();
    private static Scanner scanner = new Scanner(System.in);
    public static void listarEspecies(){
        List<Especies> especiesList = especiesDAO.select(entityManager);
        System.out.println("Lista de especies: ");
        for(int i =0 ; i < especiesList.size(); i++){
            System.out.println("\t["+especiesList.get(i).getNombre()+", "+especiesList.get(i).getPlanetaOrigen().getNombre() + ", "+especiesList.get(i).getFisiologia()+"]");
        }
    }

    public static void annadirEspecie(){
        boolean correcto = false;
        int atras = 1;
        while (!correcto && atras!=0) {
            Especies especie = new Especies();
            System.out.println("Introduce nombre de la especie");
            String nombre = scanner.nextLine();
            nombre = nombre.toUpperCase().charAt(0) + nombre.substring(1, nombre.length()).toLowerCase();
            especie.setNombre(nombre);
            System.out.println("Introduce nombre del planeta de origen");
            String nombrePlaneta = scanner.nextLine();
            nombrePlaneta = nombrePlaneta.toUpperCase().charAt(0) + nombrePlaneta.substring(1, nombrePlaneta.length()).toLowerCase();
            Planeta nPlan = planetasDAO.find(entityManager, nombrePlaneta);
            if (nPlan!=null) {
                especie.setPlanetaOrigen(nPlan);

                boolean out = false;
                while(!out) {
                    System.out.println("Introduce fisiologia de la especie");
                    if(scanner.hasNextInt()){
                        int fisiologia = scanner.nextInt();
                        especie.setFisiologia(fisiologia);

                        especiesDAO.insert(especie,entityManager);
                        System.out.println("Se ha añadido");
                        correcto = true;
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

    public static void modificarEspecie() {
        System.out.println("Introduce nombre de la especie");
        String nombre = scanner.nextLine();
        nombre = nombre.toUpperCase().charAt(0) + nombre.substring(1, nombre.length()).toLowerCase();
        Especies especie;
        especie = especiesDAO.find(entityManager, nombre);
        boolean correcto = false;
        int atras = 1;
        while (!correcto && atras != 0) {
            if (especie != null) {
                System.out.println("Introduce nuevo nombre de la especie");
                nombre = scanner.nextLine();
                nombre = nombre.toUpperCase().charAt(0) + nombre.substring(1, nombre.length()).toLowerCase();
                especie.setNombre(nombre);
                System.out.println("Introduce nuevo nombre del planeta de origen");
                String nombrePlaneta = scanner.nextLine();
                nombrePlaneta = nombrePlaneta.toUpperCase().charAt(0) + nombrePlaneta.substring(1, nombrePlaneta.length()).toLowerCase();
                Planeta nPlan = planetasDAO.find(entityManager, nombrePlaneta);
                if (nPlan != null) {
                    especie.setPlanetaOrigen(nPlan);


                    boolean out = false;
                    while (!out) {
                        System.out.println("Introduce nueva fisiologia de la especie");
                        if (scanner.hasNextInt()) {
                            int fisiologia = scanner.nextInt();
                            especie.setFisiologia(fisiologia);
                            especiesDAO.update(especie,entityManager);
                            System.out.println("Se ha actualizado");
                            correcto = true;
                            out = true;
                        } else {
                            System.out.println("Valor  incorrecto");
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
            } else {
                System.out.println("Especie no existente");
            }
        }
    }
    public static void eliminarEspeice(){
        System.out.println("Introduce nombre de la especie");
        String nombre = scanner.nextLine();
        nombre = nombre.toUpperCase().charAt(0) + nombre.substring(1, nombre.length()).toLowerCase();
        Especies especie;
        especie = especiesDAO.find(entityManager, nombre);

        boolean borrado = especiesDAO.delete(especie,entityManager);
        if (borrado){
            System.out.println("Se ha borrado la especie "+ especie.getNombre());
        }else {
            System.out.println("No se ha podido borrar la especie");
        }
    }
}
