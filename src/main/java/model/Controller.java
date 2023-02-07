package model;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import model.dao.*;
import model.entities.Especies;
import model.views.Interior;
import model.views.MenuView;

import java.util.List;
import java.util.Scanner;

public class Controller {
    public static void main(String[] args) {
        Interior.insertar();
        MenuView.menuPrincipal();
    }
}
