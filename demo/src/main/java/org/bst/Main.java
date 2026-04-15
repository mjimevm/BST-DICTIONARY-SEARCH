package org.bst;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        TXTReader reader = new TXTReader();
        Scanner teclado = new Scanner(System.in);
        String contenido = reader.leerArchivo(new java.io.File("src/main/resources/diccionario.txt"));
        String[] lineas = contenido.split("\n");
        BinaryTree<String> tree = new BinaryTree<>();
        // Insertar cada linea en el arbol como: woman, mujer
        for (String line : lineas) {
            tree.insert(line);
        }

        System.out.println("MENÚ:");
        System.out.println("1. Traducir palabra");
        System.out.println("2. Leer archivo texto.txt para traducir");
        System.out.println("3. Introducir frase para traducir");
        System.out.println("4. Salir");
        int opcion = teclado.nextInt();
        switch (opcion) {
            case 1:
                // Traducir palabra
                System.out.println("Introduce la palabra a traducir:");
                String palabra = teclado.next();
                for (String line : lineas) {
                    if (line.startsWith(palabra + ",")) {
                        String traduccion = line.split(",")[1].trim();
                        System.out.println("Traducción: " + traduccion);
                        break;
                    }
                }
                break;
            case 2:
                String frase = reader.leerArchivo(new java.io.File("src/main/resources/texto.txt"));
                System.out.println("Frase introducida: " + frase);
                break;
            case 3:
                String frase2 = reader.leerArchivo(new java.io.File("src/main/resources/texto.txt"));
                System.out.println("Frase introducida: " + frase2);
                break;
            case 4:
                System.out.println("Saliendo...");
                break;
            default:
                System.out.println("Opción no válida.");
        }
    }
}