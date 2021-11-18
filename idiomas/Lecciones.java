package com.example.idiomas;

public class Lecciones {

    private int id;
    private String nombre;
    private int contador;
    private String Imagen;


    public Lecciones() {
    }
    public Lecciones(int id, String nombre, int contador, String Imagen) {
        this.id = id;
        this.nombre = nombre;
        this.contador = contador;
        this.Imagen = Imagen;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getContador() {
        return contador;
    }

    public void setContador(int contador) {
        this.contador = contador;
    }

    public String getImagen() {
        return Imagen;
    }

    public void setImagen(String Imagen) {
        this.Imagen = Imagen;
    }


    @Override
    public String toString() {
        return nombre+" "+ contador+"/10";
    }
}
