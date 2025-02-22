package com.charly.referencia_metodos;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Usuario> usuarios = Arrays.asList(
                new Usuario("Carlso"),
                new Usuario("Pedro")
        );

        InterfazCf cf = Usuario::new;
        cf.crearUsuario("Pedro");
        cf.crearUsuario("Maria");

        
    }

    public static class Prueba {
        public void mostrarNombre(Usuario usuario) {
            System.out.println(usuario.getNombre());
        }
    }

    public static void mostrarNombre(Usuario usuario) {
        System.out.println(usuario.getNombre());
    }
}
