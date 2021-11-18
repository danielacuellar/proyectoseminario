package com.example.idiomas;

public class Niveles {
    private int id;
    private String nombre;
    private float porcentaje;


    public Niveles() {
    }

    public Niveles(int id, String nombre, float porcentaje) {
        this.id = id;
        this.nombre = nombre;
        this.porcentaje = porcentaje;
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

    public float getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(float porcentaje) {
        this.porcentaje = porcentaje;
    }


    @Override
    public String toString() {
        return nombre+" "+ porcentaje+"%";
    }
}
