package com.example.idiomas;

public class Usuarios {

    static int id;
    static String nombre;
    static String apellido;

    public Usuarios() {
    }

    public Usuarios(int id) {
        this.id = id;
    }

    public static int getId() {
        return id;
    }

    public static void setId(int idU) {
        id = idU;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String toString() {
        return nombre + " "+ apellido;
    }


}
