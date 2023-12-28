package com.carro.alquilerpelicula;

import java.util.ArrayList;
import java.util.regex.Pattern;

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
    public static void imprimirInformacion(Pelicula pelicula) {
        System.out.println(pelicula.toString());
    }
    
    public static boolean validarNumeroCelular(int numeroCelular) {
        // Asumiendo que el número de celular debe tener 10 dígitos
        return String.valueOf(numeroCelular).length() == 10;
    }

    public static boolean validarTituloUnico(String titulo, ArrayList<Pelicula> listaPeliculas) {
        for (Pelicula pelicula : listaPeliculas) {
            if (pelicula.getTitulo().equals(titulo)) {
                return false;
            }
        }
        return true;
    }

    public static boolean validarEmail(String email) {
        // Patrón simple para validar el correo electrónico
        String emailRegex = "^[A-Za-z0-9+_.-]+@(.+)$";
        Pattern pattern = Pattern.compile(emailRegex);
        return pattern.matcher(email).matches();
    }

    public static boolean validarDescuento(String entrada) {
        if (entrada.equalsIgnoreCase("si")) {
            return true;
        } else if (entrada.equalsIgnoreCase("no")) {
            return false;
        } else {
            throw new IllegalArgumentException("Entrada inválida. Debe ser 'si' o 'no'.");
        }
    }
    
    public static boolean validarIdUnico(int id, ArrayList<Pelicula> listaPeliculas) {
        for (Pelicula pelicula : listaPeliculas) {
            if (pelicula.getId() == id) {
                System.out.println("id de pelicula ya existe");
                return false;
            }
        }
        return true;
    }
    
}
