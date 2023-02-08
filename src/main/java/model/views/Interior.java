package model.views;

import model.dao.*;
import model.entities.*;

import java.util.*;

public class Interior extends ControllerView{

    public static void insertar() {
        PlanetasDAO planetasDAO = new PlanetasDAO();


        Planeta planeta = new Planeta("Roshar", "Sistema de Roshar", "Esquirla Honor");
        planetasDAO.insert(planeta, entityManager);

        Planeta planeta1 = new Planeta("Nalthis", "Sistema de Nalthis", "Esquirla Nalthis");
        planetasDAO.insert(planeta1, entityManager);

        Planeta planeta2 = new Planeta("Scadrial", "Sistema de Scadrial", "Esquirla Conservación");
        planetasDAO.insert(planeta2, entityManager);

        Planeta planeta3 = new Planeta("Sel", "Sistema de Sel", "Esquirla Devoción");
        planetasDAO.insert(planeta3, entityManager);

        Planeta planeta4 = new Planeta("Yomen", "Sistema de Yomen", "Adonalsium");
        planetasDAO.insert(planeta4, entityManager);

        Planeta planeta5 = new Planeta("Taldain", "Sistema de Taldain", "Esquirla Autonomía");
        planetasDAO.insert(planeta5, entityManager);

        Planeta planeta6 = new Planeta("Donne", "Sistema de Sel", "Esquirla Devoción");
        planetasDAO.insert(planeta6, entityManager);

        Planeta planeta7 = new Planeta("Aaqual Nod", "Sistema de Scadrial", "Esquirla Conservación");
        planetasDAO.insert(planeta7, entityManager);

        Planeta planeta8 = new Planeta("Braize", "Sistema de Roshar", "Esquirla Odium");
        planetasDAO.insert(planeta8, entityManager);


        SagasDAO sagasDAO = new SagasDAO();

        Sagas sagas = new Sagas("El Archivo de las Tormentas","4", planeta);
        sagasDAO.insert(sagas,entityManager);

        Sagas sagas1 = new Sagas("El Aliento de los Dioses","1", planeta1);
        sagasDAO.insert(sagas1,entityManager);

        Sagas sagas2 = new Sagas("Nacidos de la bruma","7", planeta2);
        sagasDAO.insert(sagas2,entityManager);

        Sagas sagas3 = new Sagas("Elantris","3", planeta3);
        sagasDAO.insert(sagas3,entityManager);



        EspeciesDAO especiesDAO = new EspeciesDAO();

        Especies especies = new Especies("Humanos",planeta4,1);
        especiesDAO.insert(especies,entityManager);

        Especies especies1 = new Especies("Humanos-Scadrial",planeta2,2);
        especiesDAO.insert(especies1,entityManager);

        Especies especies2 = new Especies("Chull",planeta,3);
        especiesDAO.insert(especies2,entityManager);

        Especies especies3 = new Especies("Rocabrote",planeta,4);
        especiesDAO.insert(especies3,entityManager);


        PersonajeDAO personajeDAO = new PersonajeDAO();

        Personaje personaje = new Personaje("Dalinar Kholin","54", especies, planeta);
        personajeDAO.insert(personaje, entityManager);

        Personaje personaje1 = new Personaje("Kaladin","20", especies, planeta);
        personajeDAO.insert(personaje1, entityManager);

        Personaje personaje2 = new Personaje("Shallan Dava","18", especies, planeta);
        personajeDAO.insert(personaje2, entityManager);

        Personaje personaje3 = new Personaje("Vivenna","28", especies, planeta1);
        personajeDAO.insert(personaje3, entityManager);

        Personaje personaje4 = new Personaje("Vasher","558", especies, planeta1);
        personajeDAO.insert(personaje, entityManager);

        Personaje personaje5 = new Personaje("Vin","20", especies1, planeta2);
        personajeDAO.insert(personaje5, entityManager);

        Personaje personaje6 = new Personaje("Kelsier","36", especies1, planeta2);
        personajeDAO.insert(personaje6, entityManager);

        Personaje personaje7 = new Personaje("Sazed","34", especies1, planeta2);
        personajeDAO.insert(personaje7, entityManager);

        Personaje personaje8 = new Personaje("Raoden","26", especies, planeta3);
        personajeDAO.insert(personaje8, entityManager);

        Personaje personaje9 = new Personaje("Hoid","9999", especies, planeta4);
        personajeDAO.insert(personaje9, entityManager);


        LibroDAO libroDAO = new LibroDAO();

        Libro libro = new Libro("El Camino de los Reyes",planeta,sagas);
        libroDAO.insert(libro,entityManager);
        
        Libro libro1 = new Libro("Palabras Radiantes",planeta,sagas);
        libroDAO.insert(libro1,entityManager);

        Libro libro2 = new Libro("Juramentada",planeta,sagas);
        libroDAO.insert(libro2,entityManager);

        Libro libro3 = new Libro("El Aliento de los Dioses",planeta1,sagas1);
        libroDAO.insert(libro3,entityManager);

        Libro libro4 = new Libro("El Imperio Final",planeta2,sagas2);
        libroDAO.insert(libro4,entityManager);

        Libro libro5 = new Libro("El Pozo de la Ascensión",planeta2,sagas2);
        libroDAO.insert(libro5,entityManager);
        
        Libro libro6 = new Libro("El Héroe de las Eras",planeta2,sagas2);
        libroDAO.insert(libro6,entityManager);

        Libro libro7 = new Libro("Elantris",planeta3,sagas3);
        libroDAO.insert(libro7,entityManager);

        Libro libro8 = new Libro("El alma del emperador",planeta3,sagas3);
        libroDAO.insert(libro8,entityManager);



        MagiaDAO magiaDAO = new MagiaDAO();

        Magia magia = new Magia("Vinculo de Nahel","Permite vincularse a un Spren","Esquirla Honor");
        magiaDAO.insert(magia,entityManager);

        Magia magia1 = new Magia("Alomancia","Permite quemar metales","Esquirla Conservación");
        magiaDAO.insert(magia1,entityManager);

        Magia magia2 = new Magia("Feruquimia","Permite almacenar en metales","Esquirla Ruina");
        magiaDAO.insert(magia2,entityManager);

        Magia magia3 = new Magia("Despertar","Permite despertar objetos inanimados","Esquirla Dotación");
        magiaDAO.insert(magia3,entityManager);

        List<Magia> magias1  = new ArrayList<>();
        magias1.add(magia3);
        personaje4.setMagias(magias1);

        List<Magia> magias2  = new ArrayList<>();
        magias2.add(magia);
        personaje9.setMagias(magias2);

        List<Magia> magias3  = new ArrayList<>();
        magias3.add(magia1);
        personaje4.setMagias(magias3);
    }
}
