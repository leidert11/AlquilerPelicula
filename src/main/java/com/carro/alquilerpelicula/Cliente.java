package com.carro.alquilerpelicula;

public class Cliente {
    private String nombre;
    private String  correo ;
    private String  numeroCelular;

    public Cliente(String nombre, String correo, String numeroCelular) {
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

    public String getNumeroCelular() {
        return numeroCelular;
    }

    public void setNumeroCelular(String numeroCelular) {
        this.numeroCelular = numeroCelular;
    }

    //@Override
    //public String toString() {
    //   return "Cliente" + "nombre=" +  nombre + "\\n correo=" + correo + "\n numero Celular=" + numeroCelular ;
   // }
    
public void mostrarInformacion() {
    System.out.println("Cliente: " + nombre);
    System.out.println("Correo: " + correo);
    System.out.println("Numero de celular: " + numeroCelular);
}


    
}
