package com.carro.alquilerpelicula;

import java.util.ArrayList;

public class Validaciones {
    private Validaciones() {}

    // Método que busca una película por su id y la devuelve si la encuentra, o null si no la encuentra
    public static Pelicula buscarPeliculaPorId(int id, ArrayList<Pelicula> listaPeliculas) {
        for (Pelicula p : listaPeliculas) {
            if (p.getId() == id) {
                return p;
            }
        }
        return null;
    }

    // Método que busca un cliente por su nombre y lo devuelve si lo encuentra, o null si no lo encuentra
    public static Cliente buscarClientePorNombre(String nombre, ArrayList<Cliente> listaCliente) {
        for (Cliente c : listaCliente) {
            if (c.getNombre().equals(nombre)) {
                return c;
            }
        }
        return null;
    }

    // Método que imprime la información de cualquier objeto usando el método toString()
    public static void imprimirInformacion(Object objeto) {
        System.out.println(objeto.toString());
    }

}
