package com.carro.alquilerpelicula;


import java.util.ArrayList;
import java.util.Scanner;
import java.util.Set;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;


public class AlquilerPelicula {

    private static final ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
    private static final Validator validator = factory.getValidator();

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        Pelicula pelicula = null;
        Cliente cliente = null;

        ArrayList<Pelicula> listaPeliculas = new ArrayList<>();
        ArrayList<Cliente> listaClientes = new ArrayList<>();
        ArrayList<String> listaAlquiler = new ArrayList<>();

        while (true) {
        System.out.println("---- Menu de Gestión de películas ----");
        System.out.println("1. Registrar una película");
        System.out.println("2. Registrar un cliente");
        System.out.println("3. Realizar el alquiler de una película");
        System.out.println("4. Mostrar la información de una película");
        System.out.println("5. Mostrar información de un cliente");
        System.out.println("6. Eliminar una película");
        System.out.println("0. Salir");
        System.out.print("Ingrese su opción: ");
        int opcion = scanner.nextInt();
        scanner.nextLine();
        switch (opcion) {
            case 1:
        System.out.print("Ingrese el id de la película: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Ingrese el título de la película: ");
        String titulo = scanner.nextLine();
        System.out.print("Ingrese el director de la película: ");
        String director = scanner.nextLine();
        System.out.print("Ingrese el género de la película: ");
        String genero = scanner.nextLine();
        System.out.print("Ingrese el precio de alquiler de la película: ");
        int precioAlquiler = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Ingrese si la película está en descuento (true o false): ");
        boolean peliculaEnDescuento = scanner.nextBoolean();
        scanner.nextLine();
        pelicula = new Pelicula(id, titulo, director, genero, precioAlquiler, peliculaEnDescuento);
        Set<ConstraintViolation<Pelicula>> violations = validator.validate(pelicula);
        if (violations.isEmpty()) {
            boolean existe = Validaciones.buscarPeliculaPorId(id, listaPeliculas) != null;
            if (existe) {
                System.out.println("Ya existe una película con ese ID. Intente con otro.");
            } else {
                listaPeliculas.add(pelicula);
                System.out.println("Película registrada con éxito.");
            }
        } else {
            for (ConstraintViolation<Pelicula> violation : violations) {
                System.out.println(violation.getMessage());
            }
        }
        break;
        case 2:
        System.out.print("Ingrese el nombre del cliente: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese el correo del cliente: ");
        String correo = scanner.nextLine();
        System.out.print("Ingrese el número de celular del cliente: ");
        int numeroCelular = scanner.nextInt();
        scanner.nextLine();
        cliente = new Cliente(nombre, correo, numeroCelular);
        Set<ConstraintViolation<Cliente>> violationsCliente = validator.validate(cliente);
        if (violationsCliente.isEmpty()) {
            boolean repetido = false;
            for (Cliente c : listaClientes) {
                if (c.getCorreo().equals(correo) || c.getNumeroCelular() == numeroCelular) {
                    repetido = true;
                    break;
                }
            }
            if (repetido) {
                System.out.println("Ya existe un cliente con ese correo o número de celular. Intente con otros.");
            } else {
                listaClientes.add(cliente);
                System.out.println("Cliente registrado con éxito.");
            }
        } else {
            for (ConstraintViolation<Cliente> violation : violationsCliente) {
                System.out.println(violation.getMessage());
            }
        }
        break;
    case 3:
        System.out.print("Ingrese el id de la película que quiere alquilar: ");
        int idPelicula = scanner.nextInt();
    scanner.nextLine();
    pelicula = Validaciones.buscarPeliculaPorId(idPelicula, listaPeliculas);
    if (pelicula ==  null) {
        System.out.println("id de pelicula no existente ");
    } else {
        System.out.print("Ingrese el nombre del cliente que quiere alquilar la película: ");
        String nombreCliente  = scanner.nextLine();
        
        cliente = Validaciones.buscarClientePorNombre(nombreCliente, listaClientes);
        
        if (cliente == null) {
            System.out.println("no se encontro un cliente con ese noombre");
        }else{
            System.out.println("Información del alquiler:");
            pelicula.mostrarInformacion();
            cliente.mostrarInformacion();
            System.out.println("precio total :" + pelicula.calcularPrecio());
            // Se guarda el alquiler en la lista de alquileres
            String alquiler = "pelicula : "+ pelicula.getTitulo() + "\n cliente : " + cliente.getNombre()+ "\n precio : "+pelicula.calcularPrecio();
            listaAlquiler.add(alquiler);
            System.out.println(" se realizo el alquler ");
        }
    }
            break;
    case 4:
    System.out.println("ingrese el id de la pelicula que desea buscar ");
    int idpeliculaVer = scanner.nextInt();
    scanner.nextLine();
    pelicula = Validaciones.buscarPeliculaPorId(idpeliculaVer, listaPeliculas);
    if (pelicula == null) {
        System.out.println("pelicula no eencontrada");
    }else{
        Validaciones.imprimirInformacion(pelicula);
    }
    break;
    case 5:
        System.out.println("ingrese el nombre del cliente que desea buscar : ");  
        String nombreVer = scanner.nextLine();
        cliente = Validaciones.buscarClientePorNombre(nombreVer, listaClientes);
        if (cliente == null ) {
            System.out.println("cliente non encontrado");
        } else {
            Validaciones.imprimirInformacion(cliente);
        }
    break;
    case 6: 
        System.out.println("ingrese el id de la pelicula que desea buscar ");
        int idPeliculaEliminar = scanner.nextInt();
        scanner.nextLine();
        pelicula = Validaciones.buscarPeliculaPorId(idPeliculaEliminar, listaPeliculas);
        if (pelicula == null) {
            System.out.println("id no existe");
        }else{
        boolean alquilada = false;
        for (String a : listaAlquiler) {
                if (a.contains(pelicula.getTitulo())) {
                    alquilada = true;
                    break;
                }
            }
            if (alquilada) {
                System.out.println("la pelicula no se puede eiminar por que esta alquilada ");
            } else {
                listaPeliculas.remove(pelicula);
                System.out.println(" pelicula eliminada ");
            }
        }
    break;
    case 0:
    System.out.println("Saliendo del sistema de gestión de peliculas...");
        scanner.close();
        return;
    default:
        System.out.println("Opción inválida. Por favor, ingrese una opción válida.");
        break;
            }
        }
    }
}

