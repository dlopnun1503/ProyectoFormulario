package com.es.proyectoformulario.services.impl;

import com.es.proyectoformulario.model.User;

import java.util.ArrayList;
import java.util.Scanner;

public class ServiceUser {

    // ATRIBUTOS
    private ArrayList<User> users; // Contiene todos los registros del fichero users.txt
    private GestionFicheroUser gestionUser; // gestion es un objeto para poder llamar a los métodos de GestionFicheroUser
    private ServiceLogger logger;

    private String ruta = "src/main/resources/users/users.txt";

    public ServiceUser() {
        this.users = new ArrayList<>();
        this.gestionUser = new GestionFicheroUser();
        leerFicheroUsers();
        this.logger = new ServiceLogger();
    }


    public boolean checkUser(String idUser, String password) {
        for (int i = 0; i < this.users.size(); i++) {
            User usuario = this.users.get(i); // usuario es el elemento de la posicion i de users
            if (usuario.getId().equalsIgnoreCase(idUser) && usuario.getPass().equals(password)) {
                this.logger.registrarLog(idUser, "LOGIN", "OK");
                return true;
            }
        }
        this.logger.registrarLog(idUser, "LOGIN", "NOT OK");
        return false;
    }

    public boolean userExists(String idUser) {
        return this.users.stream().anyMatch(user -> user.getId().equalsIgnoreCase(idUser));
    }

    public User getUser(String idUser){
        User user = null;
        for (int i = 0; i < users.size(); i++){
            if (users.get(i).getId().equals(idUser)){
                user = users.get(i);
            }
        }
        return user;
    }


    public void leerFicheroUsers() {
        this.users = gestionUser.leerFichero(this.ruta);
    }

    public void anadirFicheroUsers(User u) {
        gestionUser.anadirFichero(u, this.ruta);
    }

    public void modificarFicheroUsers() {
        gestionUser.modificarFichero(this.users, this.ruta);
    }

    public boolean modificarUsuario(User user){
        boolean usuarioModificado = false;
        if (!user.getId().contains(":") && !user.getName().contains(":") && !user.getPass().contains(":")) {
            if (user.getId().length() <= 20 && user.getPass().length() <= 20 && user.getName().length() <= 20) {
                if (userExists(user.getId())) {

                    // Recorres el arrayList para encontrar la posición de ese Usuario
                    // Una vez lo encuentras, puedes hacer un set en esa posición del usuario nuevo
                    for (int i = 0; i < users.size(); i++) {
                        if (users.get(i).getId().equals(user.getId())){
                            users.set(i, user);
                            System.out.println(users);
                            gestionUser.modificarFichero(users, "C:\\Users\\dlopnun1503\\Desktop\\Programacion\\ProyectoFormulario\\src\\main\\resources\\users\\users.txt");
                            usuarioModificado = true;
                            break;
                        }

                    }
                } else {
                    System.out.println("Usuario no disponible");
                }
            }else {
                System.out.println("Maximo 20 caracteres");
            }
        }else {
            System.out.println(": no disponible en dichos campos");
        }
        return usuarioModificado;
    }

    public boolean altaUsuario(User user) {
        boolean usuarioRegistrado = false;
        if (!user.getId().contains(":") && !user.getName().contains(":") && !user.getPass().contains(":")) {
            if (user.getId().length() <= 20 && user.getPass().length() <= 20 && user.getName().length() <= 20) {
                    if (!userExists(user.getId())) {
                        gestionUser.anadirFichero(user, "C:\\Users\\dlopnun1503\\Desktop\\Programacion\\ProyectoFormulario\\src\\main\\resources\\users\\users.txt");
                        users.add(user);
                        usuarioRegistrado = true;
                    } else {
                        System.out.println("Usuario existente");
                    }
            }else {
                System.out.println("Maximo 20 caracteres");
            }
        }else {
            System.out.println(": no disponible en dichos campos");
        }
        return usuarioRegistrado;
    }

    public boolean bajaUsuario(User user) {
        boolean usuarioEliminado = false;
                if (userExists(user.getId())) {
                    users.remove(user);
                    modificarFicheroUsers();
                    usuarioEliminado = true;
                } else {
                    System.out.println("Usuario no existe");
                }
        return usuarioEliminado;
    }

}
