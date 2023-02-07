package model.views;

import model.dao.PlanetasDAO;
import model.entities.Planeta;

import java.util.List;
import java.util.Scanner;

public class PlanetasView extends ControllerView{
    private static PlanetasDAO planetaDAO = new PlanetasDAO();
    private static Scanner scanner = new Scanner(System.in);
    public static void listarPlanetas(){
        List<Planeta> planetaList = planetaDAO.select(entityManager);
        System.out.println("Lista de planeta: ");
        for(int i =0 ; i < planetaList.size(); i++){
            System.out.println("\t["+planetaList.get(i).getNombre()+", "+planetaList.get(i).getSistema() + ", "+planetaList.get(i).getEsquirla()+"]");
        }
    }

    public static void annadirPlaneta(){
        boolean correcto = false;
        int atras = 1;
        while (!correcto && atras!=0) {
            Planeta planeta = new Planeta("1", "Roshar", "Sistema de Roshar", "Esquirla Honor");
            System.out.println("Introduce nombre del planeta");
            String nombre = scanner.nextLine();
            nombre = nombre.toUpperCase().charAt(0) + nombre.substring(1, nombre.length()).toLowerCase();
            planeta.setNombre(nombre);
            System.out.println("Introduce nombre del sistema");
            String sistema = scanner.nextLine();
            sistema = sistema.toUpperCase().charAt(0) + sistema.substring(1, sistema.length()).toLowerCase();
            planeta.setSistema(sistema);

            System.out.println("Introduce nombre de la esquirla");
            String esquirla = scanner.nextLine();
            planeta.setEsquirla(esquirla);
            planetaDAO.insert(planeta,entityManager);
            System.out.println("Se ha añadido");
            correcto = true;
        }
    }

    public static void modificarPlaneta() {
        System.out.println("Introduce nombre del planeta");
        String nombre = scanner.nextLine();
        nombre = nombre.toUpperCase().charAt(0) + nombre.substring(1, nombre.length()).toLowerCase();
        Planeta planeta;
        planeta = planetaDAO.find(entityManager, nombre);
        boolean correcto = false;
        int atras = 1;
        while (!correcto && atras != 0) {

            if (planeta != null) {
                System.out.println("Introduce nuevo nombre del planeta");
                nombre = scanner.nextLine();
                nombre = nombre.toUpperCase().charAt(0) + nombre.substring(1, nombre.length()).toLowerCase();
                planeta.setNombre(nombre);
                System.out.println("Introduce nombre del sistema");
                String sistema = scanner.nextLine();
                sistema = sistema.toUpperCase().charAt(0) + sistema.substring(1, sistema.length()).toLowerCase();
                planeta.setSistema(sistema);

                System.out.println("Introduce nombre de la esquirla");
                String esquirla = scanner.nextLine();
                planeta.setEsquirla(esquirla);

                entityManager.persist(planeta);
                System.out.println("Se ha actualizado");
                correcto = true;
            }else{
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
    public static void eliminarPlaneta(){
        System.out.println("Introduce nombre de la planeta");
        String nombre = scanner.nextLine();
        nombre = nombre.toUpperCase().charAt(0) + nombre.substring(1, nombre.length()).toLowerCase();
        Planeta planeta;
        planeta = planetaDAO.find(entityManager, nombre);

        boolean borrado = planetaDAO.delete(planeta,entityManager);
        if (borrado){
            System.out.println("Se ha borrado la planeta "+ planeta.getNombre());
        }else {
            System.out.println("No se ha podido borrar la planeta");
        }
    }
}
