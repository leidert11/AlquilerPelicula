package com.carro.alquilerpelicula;

public class Pelicula {
    private int id ;
    private String titulo;
    private String director;
    private char genero ;
    private int  precioAlquiler;
    private boolean peliculasEnDescuento;
    private int descuentoPeliculaEspecial;

    public Pelicula(int id, String titulo, String director, char genero, int precioAlquiler, boolean peliculasEnDescuento) {
        this.id = id;
        this.titulo = titulo;
        this.director = director;
        this.genero = genero;
        this.precioAlquiler = precioAlquiler;
        this.peliculasEnDescuento = false;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public char getGenero() {
        return genero;
    }

    public void setGenero(char genero) {
        this.genero = genero;
    }

    public int getPrecioAlquiler() {
        return precioAlquiler;
    }

    public void setPrecioAlquiler(int precioAlquiler) {
        this.precioAlquiler = precioAlquiler;
    }

    public Boolean getPeliculasEnDescuento() {
        return peliculasEnDescuento;
    }

    public void setPeliculasEnDescuento(Boolean peliculasEnDescuento) {
        this.peliculasEnDescuento = peliculasEnDescuento;
    }

    public int getDescuentoPeliculaEspecial() {
        return descuentoPeliculaEspecial;
    }

    public void setDescuentoPeliculaEspecial(int descuentoPeliculaEspecial) {
        this.descuentoPeliculaEspecial = descuentoPeliculaEspecial;
    }

    // @Override
    // public String toString() {
    //     return "Pelicula" + "id=" + id + "\n titulo=" + titulo + "\n director=" + director + "\n genero=" + genero + "\n precioAlquiler=" + precioAlquiler + "\n peliculasEnDescuento=" + peliculasEnDescuento + "\n descuento Pelicula Especial=" + descuentoPeliculaEspecial ;
    // }
    
    public double calcularPrecio(){
        if (peliculasEnDescuento) {
            return precioAlquiler - (precioAlquiler * 0.15);
        }
        else{
            return precioAlquiler;
        }
    }
    public void mostrarInformacion() {
    System.out.println("Pelicula: " + titulo);
    System.out.println("Id: " + id);
    System.out.println("Director: " + director);
    System.out.println("Genero: " + genero);
    System.out.println("Precio de alquiler: " + precioAlquiler);
    System.out.println("Pelicula en descuento: " + peliculasEnDescuento);
    System.out.println("Precio total: " + calcularPrecio());
}

}
