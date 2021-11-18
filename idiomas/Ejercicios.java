package com.example.idiomas;

public class Ejercicios {

    private int id;
    private String pregunta;
    private String respuesta;
    private String Imagen1;
    private String Imagen2;
    private String Imagen3;
    private String Imagen4;
    private int Cont;


    public Ejercicios() {
    }
    public Ejercicios(int id, String pregunta,String respuesta, String Imagen1, String Imagen2, String Imagen3, String Imagen4, int Cont) {
        this.id = id;
        this.pregunta = pregunta;
        this.respuesta = respuesta;
        this.Imagen1 = Imagen1;
        this.Imagen2 = Imagen2;
        this.Imagen3 = Imagen3;
        this.Imagen4 = Imagen4;
        this.Cont = Cont;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPregunta() {
        return pregunta;
    }

    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }

    public String getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }

    public String getImagen1() {
        return Imagen1;
    }

    public void setImagen1(String Imagen1) {
        this.Imagen1 = Imagen1;
    }

    public String getImagen2() {
        return Imagen2;
    }

    public void setImagen2(String Imagen2) {
        this.Imagen2 = Imagen2;
    }

    public String getImagen3() {
        return Imagen3;
    }

    public void setImagen3(String Imagen3) {
        this.Imagen3 = Imagen3;
    }

    public String getImagen4() {
        return Imagen4;
    }

    public void setImagen4(String Imagen4) {
        this.Imagen4 = Imagen4;
    }

    public int getCont() {
        return Cont;
    }

    public void setCont(int Cont) {
        this.Cont = Cont;
    }


    @Override
    public String toString() {
        return pregunta;
    }
}
