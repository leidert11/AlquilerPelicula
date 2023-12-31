package com.carro.alquilerpelicula;

public class Cliente {
    private String nombre;
    private String  correo ;
    private int  numeroCelular;

    public Cliente(String nombre, String correo, int numeroCelular) {
        this.nombre = nombre;
        this.correo = correo;
        this.numeroCelular = numeroCelular;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public int getNumeroCelular() {
        return numeroCelular;
    }

    public void setNumeroCelular(int numeroCelular) {
        this.numeroCelular = numeroCelular;
    }

    @Override
    public String toString() {
        return "Cliente" + '\n' +
                "nombre = " + nombre + '\n' +
                "correo = " + correo + '\n' +
                "numeroCelular = " + numeroCelular ;
    }
    
    
// public void mostrarInformacion() {
//     System.out.println("Cliente: " + nombre);
//     System.out.println("Correo: " + correo);
//     System.out.println("Numero de celular: " + numeroCelular);
// }


    
}
