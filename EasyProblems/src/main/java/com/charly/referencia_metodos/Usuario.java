package com.charly.referencia_metodos;

public class Usuario {

    private String nombre;

    public Usuario(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void imprimirNombre() {
        System.out.println(this.nombre);
    }
}
