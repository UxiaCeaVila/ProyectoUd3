package model.views;

import model.dao.EspeciesDAO;
import model.dao.MagiaDAO;
import model.dao.PlanetasDAO;
import model.dao.SagasDAO;
import model.entities.Especies;
import model.entities.Magia;
import model.entities.Planeta;
import model.entities.Sagas;

import java.util.List;
import java.util.Scanner;

public class MagiaView extends ControllerView{
    private static MagiaDAO magiaDAO = new MagiaDAO();
    private static Scanner scanner = new Scanner(System.in);
    public static void listarMagias(){
        List<Magia> magiaList = magiaDAO.select(entityManager);
        System.out.println("Lista de magia: ");
        for(int i =0 ; i < magiaList.size(); i++){
            System.out.println("\t["+magiaList.get(i).getNombre()+", "+magiaList.get(i).getDescripcion() + ", "+magiaList.get(i).getEsquirla()+"]");
        }
    }

    public static void annadirMagia(){
        boolean correcto = false;
        int atras = 1;
        while (!correcto && atras!=0) {
            Magia magia = new Magia();
            System.out.println("Introduce nombre del magia");
            String nombre = scanner.nextLine();
            nombre = nombre.toUpperCase().charAt(0) + nombre.substring(1, nombre.length()).toLowerCase();
            magia.setNombre(nombre);
            System.out.println("Introduce decripcion de la magia");
            String descripcionMagia = scanner.nextLine();
            descripcionMagia = descripcionMagia.toUpperCase().charAt(0) + descripcionMagia.substring(1, descripcionMagia.length()).toLowerCase();
            magia.setDescripcion(descripcionMagia);

            System.out.println("Introduce nombre de la esquirla");
            String esquirla = scanner.nextLine();
            magia.setEsquirla(esquirla);
            magiaDAO.insert(magia,entityManager);
            System.out.println("Se ha añadido");
            correcto = true;
        }
    }

    public static void modificarMagia(){
        System.out.println("Introduce nombre del magia");
        String nombre = scanner.nextLine();
        nombre = nombre.toUpperCase().charAt(0) + nombre.substring(1, nombre.length()).toLowerCase();
        Magia magia;
        magia = magiaDAO.find(entityManager, nombre);
        boolean correcto = false;
        int atras = 1;
        while (!correcto && atras!=0) {

            if (magia != null) {
                System.out.println("Introduce nuevo nombre del magia");
                nombre = scanner.nextLine();
                nombre = nombre.toUpperCase().charAt(0) + nombre.substring(1, nombre.length()).toLowerCase();
                magia.setNombre(nombre);
                System.out.println("Introduce nueva decripcion de la magia");
                String descripcionMagia = scanner.nextLine();
                descripcionMagia = descripcionMagia.toUpperCase().charAt(0) + descripcionMagia.substring(1, descripcionMagia.length()).toLowerCase();
                magia.setDescripcion(descripcionMagia);

                System.out.println("Introduce nuevo nombre de la esquirla");
                String esquirla = scanner.nextLine();
                magia.setEsquirla(esquirla);
                magiaDAO.update(magia,entityManager);
                System.out.println("Se ha añadido");
                correcto = true;
            }else {
                boolean out = false;
                while (!out) {
                    System.out.println("No hay magia con ese nombre, introduce 0 para volver al menu principal, o 1 para volver a insertar");
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
        entityManager.persist(magia);
    }

    public static void eliminarMagia(){
        System.out.println("Introduce nombre de la magia");
        String nombre = scanner.nextLine();
        nombre = nombre.toUpperCase().charAt(0) + nombre.substring(1, nombre.length()).toLowerCase();
        Magia magia;
        magia = magiaDAO.find(entityManager, nombre);

        boolean borrado = magiaDAO.delete(magia,entityManager);
        if (borrado){
            System.out.println("Se ha borrado la magia "+ magia.getNombre());
        }else {
            System.out.println("No se ha podido borrar la magia");
        }
    }
}
