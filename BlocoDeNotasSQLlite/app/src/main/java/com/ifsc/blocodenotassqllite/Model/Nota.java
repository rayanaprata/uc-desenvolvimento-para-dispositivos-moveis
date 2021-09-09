package com.ifsc.blocodenotassqllite.Model;

public class Nota {
    Integer id;
    String titulo;
    String texto;

    public Nota(Integer id, String titulo, String texto) {
        this.id = id;
        this.titulo = titulo;
        this.texto = texto;
    }

    public Nota(String titulo, String texto) {
        this.titulo = titulo;
        this.texto = texto;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }
}