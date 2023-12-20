package com.carro.alquilerpelicula;

import java.util.*;

public class AlquilerPelicula {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Pelicula pelicula = null;


        while (true) {
            System.out.println("---- Menú de Gestión de peliculas ----");
            System.out.println("1. Registrar un pelicula");
            System.out.println("2. Registrar un cliente");
            System.out.println("3.  realizar el alquiler de una película");
            System.out.println("4. mostrar la información de pelicula");
            System.out.println("5. Mostrar información del cliente");
            System.out.println("6. eliminar una película");
            System.out.println("0. Salir");
            System.out.print("Ingrese su opción: ");

            int opcion = scanner.nextInt();
            scanner.nextLine(); 

            
            switch (opcion) {
                case 1:

                break;
            
                case 2:
                break;
            
                case 3:
                
                break;
                case 4:
                    
                break;
                case 5:
                    
                break;
                case 6:
                
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